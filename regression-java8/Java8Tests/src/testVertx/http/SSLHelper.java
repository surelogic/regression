package testVertx.http;

import java.io.ByteArrayInputStream;
import java.security.SecureRandom;
import java.security.cert.CRL;
import java.security.cert.CertificateFactory;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.net.ssl.*;

import testVertx.Buffer;
import testVertx.VertxException;
import testVertx.VertxInternal;

public class SSLHelper {
	private boolean ssl;
	//private KeyStoreHelper keyStoreHelper;
	//private KeyStoreHelper trustStoreHelper;
	private boolean trustAll;
	private ArrayList<String> crlPaths;
	private ArrayList<Buffer> crlValues;
	//private ClientAuth clientAuth = ClientAuth.NONE;
	private Set<String> enabledCipherSuites;
	private boolean verifyHost;

	private SSLContext sslContext;	
	/*
	  If you don't specify a trust store, and you haven't set system properties, the system will try to use either a file
	  called jsssecacerts or cacerts in the JDK/JRE security directory.
	  You can override this by specifying the javax.echo.ssl.trustStore system property

	  If you don't specify a key store, and don't specify a system property no key store will be used
	  You can override this by specifying the javax.echo.ssl.keyStore system property
	 */
	private SSLContext createContext(VertxInternal vertx) {
		try {
			SSLContext context = SSLContext.getInstance("TLS");
			//KeyManager[] keyMgrs = keyStoreHelper == null ? null : keyStoreHelper.getKeyMgrs(vertx);
			TrustManager[] trustMgrs;
			if (trustAll) {
				trustMgrs = null;//new TrustManager[]{createTrustAllTrustManager()};
			} else {
				trustMgrs = null;//trustStoreHelper == null ? null : trustStoreHelper.getTrustMgrs(vertx);
			}
			if (trustMgrs != null && crlPaths != null && crlValues != null && (crlPaths.size() > 0 || crlValues.size() > 0)) {
				Stream<Buffer> tmp = crlPaths.
						stream().
						map(path -> vertx.resolveFile(path).getAbsolutePath()).
						map(vertx.fileSystem()::readFileBlocking);
				tmp = Stream.concat(tmp, crlValues.stream());
				CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");
				ArrayList<CRL> crls = new ArrayList<>();
				for (Buffer crlValue : tmp.collect(Collectors.toList())) {
					crls.addAll(certificatefactory.generateCRLs(new ByteArrayInputStream(crlValue.getBytes())));
				}
				trustMgrs = null;//createUntrustRevokedCertTrustManager(trustMgrs, crls);
			}
			//context.init(keyMgrs, trustMgrs, new SecureRandom());
			return context;
		} catch (Exception e) {
			throw new VertxException(e);
		}
	}
}
