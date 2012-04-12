package testBinder.formalInQualfiedName;

//package org.apache.hadoop.hdfs.security.token.delegation;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.*;

public class DelegationTokenRenewer<T extends FileSystem & DelegationTokenRenewer.Renewable>
    extends Thread {
  /** The renewable interface used by the renewer. */
  public interface Renewable {
    /** @return the renew token. */
	public Token<?> getRenewToken();

    /** Set delegation token. */
    //public <T extends TokenIdentifier> void setDelegationToken(Token<T> token);
  }

  /**
   * An action that will renew and replace the file system's delegation 
   * tokens automatically.
   */
  private static class RenewAction<T extends FileSystem & Renewable>
      implements Delayed {
    /** when should the renew happen */
    private long renewalTime;
    /** a weak reference to the file system so that it can be garbage collected */
    private final WeakReference<T> weakFs;

    private RenewAction(final T fs) {
      this.weakFs = new WeakReference<T>(fs);
    }
 
    /** Get the delay until this event should happen. */
    public long getDelay(final TimeUnit unit) {
      final long millisLeft = renewalTime - System.currentTimeMillis();
      return unit.convert(millisLeft, TimeUnit.MILLISECONDS);
    }

    public int compareTo(final Delayed delayed) {
      final RenewAction<?> that = (RenewAction<?>)delayed;
      return this.renewalTime < that.renewalTime? -1
          : this.renewalTime == that.renewalTime? 0: 1;
    }

    @Override
    public int hashCode() {
      return (int)renewalTime ^ (int)(renewalTime >>> 32);
    }

    @Override
    public boolean equals(final Object that) {
      if (that == null || !(that instanceof RenewAction)) {
        return false;
      }
      return compareTo((Delayed)that) == 0;
    }
    
    /**
     * Set a new time for the renewal.
     * It can only be called when the action is not in the queue.
     * @param newTime the new time
     */


    /**
     * Renew or replace the delegation token for this file system.
     * @return
     * @throws IOException
     */
    private boolean renew() throws IOException, InterruptedException {
      final T fs = weakFs.get();
      final boolean b = fs != null;
      if (b) {
        synchronized(fs) {
          try {
            fs.getRenewToken().renew(fs.getConf());
          } catch (IOException ie) {
            try {
              fs.setDelegationToken(fs.getDelegationToken(null));
            } catch (IOException ie2) {
              throw new IOException("Can't renew or get new delegation token ", ie);
            }
          }
        }
      }
      return b;
    }
  }

  private DelayQueue<RenewAction<T>> queue = new DelayQueue<RenewAction<T>>();

  @Override
  public void run() {
    for(;;) {
      RenewAction<T> action = null;
      try {
        action = queue.take();
        if (action.renew()) {
          queue.add(action);
        }
      } catch (InterruptedException ie) {
        return;
      } catch (Exception ie) {
    	// THIS WAS PREVIOUSLY NEVER SEEN
        T.LOG.warn("Failed to renew token, action=" + action, ie);
      }
    }
  }
}
