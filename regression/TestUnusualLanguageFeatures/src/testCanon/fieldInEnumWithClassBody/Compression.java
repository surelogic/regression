package testCanon.fieldInEnumWithClassBody;

import java.io.*;

import testBinder.formalInQualfiedName.Log;
import testCanon.qualifyingTypeNestedInGenericInThrows.Configuration;

/**
 * Compression related stuff.
 */
final class Compression {
  static final Log LOG = LogFactory.getLog(Compression.class);

  /**
   * Prevent the instantiation of class.
   */
  private Compression() {
    // nothing
  }

  /**
   * Compression algorithms.
   */
  static enum Algorithm {
    LZO(TFile.COMPRESSION_LZO) {
      private transient boolean checked = false;
      private static final String defaultClazz =
          "org.apache.hadoop.io.compress.LzoCodec";
      private transient CompressionCodec codec = null;

      public synchronized boolean isSupported() {
        if (!checked) {
          checked = true;
          String extClazz =
              (conf.get(CONF_LZO_CLASS) == null ? System
                  .getProperty(CONF_LZO_CLASS) : null);
          String clazz = (extClazz != null) ? extClazz : defaultClazz;
          try {
            LOG.info("Trying to load Lzo codec class: " + clazz);
            codec =
                (CompressionCodec) ReflectionUtils.newInstance(Class
                    .forName(clazz), conf);
          } catch (ClassNotFoundException e) {
            // that is okay
          }
        }
        return codec != null;
      }

      CompressionCodec getCodec() throws IOException {
        if (!isSupported()) {
          throw new IOException(
              "LZO codec class not specified. Did you forget to set property "
                  + CONF_LZO_CLASS + "?");
        }

        return codec;
      }

      public synchronized InputStream createDecompressionStream(
          InputStream downStream, Decompressor decompressor,
          int downStreamBufferSize) throws IOException {
        if (!isSupported()) {
          throw new IOException(
              "LZO codec class not specified. Did you forget to set property "
                  + CONF_LZO_CLASS + "?");
        }
        InputStream bis1 = null;
        if (downStreamBufferSize > 0) {
          bis1 = new BufferedInputStream(downStream, downStreamBufferSize);
        } else {
          bis1 = downStream;
        }
        conf.setInt("io.compression.codec.lzo.buffersize", 64 * 1024);
        CompressionInputStream cis =
            codec.createInputStream(bis1, decompressor);
        BufferedInputStream bis2 = new BufferedInputStream(cis, DATA_IBUF_SIZE);
        return bis2;
      }

      public synchronized OutputStream createCompressionStream(
          OutputStream downStream, Compressor compressor,
          int downStreamBufferSize) throws IOException {
        if (!isSupported()) {
          throw new IOException(
              "LZO codec class not specified. Did you forget to set property "
                  + CONF_LZO_CLASS + "?");
        }
        OutputStream bos1 = null;
        if (downStreamBufferSize > 0) {
          bos1 = new BufferedOutputStream(downStream, downStreamBufferSize);
        } else {
          bos1 = downStream;
        }
        conf.setInt("io.compression.codec.lzo.buffersize", 64 * 1024);
        CompressionOutputStream cos =
            codec.createOutputStream(bos1, compressor);
        BufferedOutputStream bos2 =
            new BufferedOutputStream(new FinishOnFlushCompressionStream(cos),
                DATA_OBUF_SIZE);
        return bos2;
      }
    };

    private final String compressName;
    // data input buffer size to absorb small reads from application.
    private static final int DATA_IBUF_SIZE = 1 * 1024;
    // data output buffer size to absorb small writes from application.
    private static final int DATA_OBUF_SIZE = 4 * 1024;
    public static final String CONF_LZO_CLASS =
        "io.compression.codec.lzo.class";

    Algorithm(String name) {
      this.compressName = name;
    }
    
    Configuration conf;
  }
  
  interface TFile {
	String COMPRESSION_LZO = null;
  }
}
