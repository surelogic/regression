package testJUC;

import java.util.concurrent.locks.Lock;

public class Test {
  public void finalLocal() {
    final Wrapper w = new Wrapper(0);
    
    w.getLock().lock();
    try {
      w.set(1);
    } finally {
      w.getLock().unlock();
    }
  }
  
  public void nonFinalLocal() {
    Wrapper w = new Wrapper(0);
    
    w.getLock().lock();
    try {
      w.set(1);
      w = null;
    } finally {
      w.getLock().unlock();
    }
  }
  

  public void effectivelyFinalLocal() {
    Wrapper w = new Wrapper(0);
    
    w.getLock().lock();
    try {
      w.set(1);
    } finally {
      w.getLock().unlock();
    }
  }
  
  
  
  public void finalParam(final Wrapper w) {
    w.getLock().lock();
    try {
      w.set(1);
    } finally {
      w.getLock().unlock();
    }
  }
  
  public void nonFinalParam(Wrapper w) {
    w.getLock().lock();
    try {
      w.set(1);
      w = null;
    } finally {
      w.getLock().unlock();
    }
  }
  
  public void effectivelyFinalParam(final Wrapper w) {
    w.getLock().lock();
    try {
      w.set(1);
    } finally {
      w.getLock().unlock();
    }
  }  
  
  
  
  public void looperFinal(final Iterable<Wrapper> iter) {
    for (final Wrapper w : iter) {
      w.getLock().lock();
      try {
        w.set(1);
      } finally {
        w.getLock().unlock();
      }
    }
  }
  
  public void looperNonFinal(final Iterable<Wrapper> iter) {
    for (Wrapper w : iter) {
      w.getLock().lock();
      try {
        w.set(1);
        w = null;
      } finally {
        w.getLock().unlock();
      }
    }
  }
  
  public void looperEffectivelyFinal(final Iterable<Wrapper> iter) {
    for (Wrapper w : iter) {
      w.getLock().lock();
      try {
        w.set(1);
      } finally {
        w.getLock().unlock();
      }
    }
  }
  
  
  
  public void cachedFinal(final Wrapper w) {
    final Lock lock = w.getLock();
    lock.lock();
    try {
      w.set(10);
    } finally {
      lock.unlock();
    }
  }
  
  public void cachedNonFinal(final Wrapper w) {
    Lock lock = w.getLock();
    lock.lock();
    try {
      w.set(10);
    } finally {
      lock.unlock();
    }
    lock = null;
  }
    
  public void cachedEffectivelyFinal(final Wrapper w) {
    Lock lock = w.getLock();
    lock.lock();
    try {
      w.set(10);
    } finally {
      lock.unlock();
    }
  }
}
