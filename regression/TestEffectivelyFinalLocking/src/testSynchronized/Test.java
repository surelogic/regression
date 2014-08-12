package testSynchronized;

public class Test {
  public void finalLocal() {
    final Wrapper w = new Wrapper(0);
    
    synchronized (w) {
      w.set(1);
    }
  }
  
  public void nonFinalLocal() {
    Wrapper w = new Wrapper(0);
    
    synchronized (w) {
      w.set(1);
    }
    
    w = null;
  }
  
  public void effectivelyFinalLocal() {
    Wrapper w = new Wrapper(0);
    
    synchronized (w) {
      w.set(1);
    }
  }
  
  
  
  public void finalParam(final Wrapper w) {
    synchronized (w) {
      w.set(2);
    }
  }
  
  public void nonFinalParam(Wrapper w) {
    synchronized (w) {
      w.set(2);
    }
    w = null;
  }
  
  public void effectivelyFinalParam(final Wrapper w) {
    synchronized (w) {
      w.set(2);
    }
  }  
  
  
  
  public void looperFinal(final Iterable<Wrapper> iter) {
    for (final Wrapper w : iter) {
      synchronized (w) {
        w.set(3);
      }
    }
  }
  
  public void looperNonFinal(final Iterable<Wrapper> iter) {
    for (Wrapper w : iter) {
      synchronized (w) {
        w.set(3);
        w = null;
      }
    }
  }
  
  public void looperEffectivelyFinal(final Iterable<Wrapper> iter) {
    for (Wrapper w : iter) {
      synchronized (w) {
        w.set(3);
      }
    }
  }
  
  
  
  public void cachedFinal(final Wrapper w) {
    final Object lock = w.getLock();
    synchronized (lock) {
      w.set(10);
    }
  }
  
  public void cachedNonFinal(final Wrapper w) {
    Object lock = w.getLock();
    synchronized (lock) {
      w.set(10);
    }
    lock = null;
  }
    
  public void cachedEffectivelyFinal(final Wrapper w) {
    Object lock = w.getLock();
    synchronized (lock) {
      w.set(10);
    }
  }  
}
