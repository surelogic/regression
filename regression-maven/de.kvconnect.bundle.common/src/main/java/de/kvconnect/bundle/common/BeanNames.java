package de.kvconnect.bundle.common;

/**
 * Diese Klasse enthält saemtliche Namen der Beans fuer fuer den EJB-Server (JBoss).
 * <p>
 * Die Beschreibung jeder einzelnen Beans ist <b>notwendig</b>, da diese direkt in die Dokumentation
 * einfliesst.
 * </p>
 * REVIEW Handler, handler, handler ?
 * 
 * @author berky_g, schaefer_m, strolka_g, hartmann_t
 */
public final class BeanNames
{

    /**
     * Name der Bean für die aktuellen Bundle-Konfigurationen.
     */
    public static final String BUNDLESCONFIG_BEAN = "bundlesconfig-service";

    /**
     * Name der Bean fuer die Zertifikate.
     */
    public static final String CERTIFICATE_SERVICE_BEAN = "certificate-service";

    /**
     * Name der Bean fuer die Konfigurationsparameter
     */
    public static final String CONFIGURATION_SERVICE_BEAN = "configuration-service";

    /**
     * Name der Bean fuer die Connectiontest.
     */
    public static final String CONNECTIONTEST_BEAN = "connectiontest";

    /**
     * Name der Bean fuer die Connectiontest.
     */
    public static final String ERRORREPORT_BEAN = "errorreport";

    /**
     * Name der Bean fuer die Zertifikate.
     */
    public static final String KEYSTOREDOWNLOAD_BEAN = "keystoredownload";

    /**
     * Name der Bean fuer die Zertifikate.
     */
    public static final String KEYSTORE_BEAN = "keystore";

    /**
     * Name der Bean fuer den Email-Verkehr.
     */
    public static final String MAIL_SERVICE_BEAN = "mail-service";

    /**
     * Name der Bean fuer Account Zugriff/Änderungen auf der Datenbank.
     */
    public static final String ACCOUNT_SERVICE_BEAN = "account-service";

    /**
     * Erzeugt eine Instanz von {@link BeanNames}.
     */
    private BeanNames()
    {
        throw new UnsupportedOperationException(); // prevents calls from subclass
    }
}
