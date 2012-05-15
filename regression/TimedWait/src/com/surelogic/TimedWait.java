package com.surelogic;

import java.util.concurrent.TimeUnit;

/* Test that we do not get a modeling error on TimeUnit.  Used to have a 
 * problem with the requires lock here.
 */
public class TimedWait {
  void doTimedWait() {
    synchronized (this) {
      try {
        TimeUnit.MILLISECONDS.timedWait(this, 10);
      } catch (InterruptedException ignore) {
      }
    }
  }
}
