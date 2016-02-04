package test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;


@RegionLock("L is rwLock protects Instance")
public class Test {
  public final ReadWriteLock rwLock = new ReentrantReadWriteLock();
  
  private int v;
  
  public void doStuff() {
    int local = 0;
    
    local = v; // bad
    v = 0; // bad
    
    rwLock.readLock().lock();
    try {
      local = v; // good
      v = 0; // bad
      
      rwLock.writeLock().lock();
      try {
        local = v; // good
        v = 0; // good
      } finally {
        rwLock.writeLock().unlock();
      }
      
      local = v; // good
      v = 0; // bad
    } finally {
      rwLock.readLock().unlock();
    }
    
    local = v; // bad
    v = 0; // bad
  }


  @RequiresLock("L.readLock()")
  public void doMoreStuff() {
    int local = 0;

    local = v; // good
    v = 0; // bad
      
    rwLock.writeLock().lock();
    try {
      local = v; // good
      v = 0; // good
    } finally {
      rwLock.writeLock().unlock();
    }
      
    local = v; // good
    v = 0; // bad
  }
}
