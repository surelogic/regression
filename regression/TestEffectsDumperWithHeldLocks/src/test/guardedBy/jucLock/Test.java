package test.guardedBy.jucLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.surelogic.GuardedBy;

class Parent {
  protected static final Lock parentStaticLock = new ReentrantLock();
  protected final Lock parentLock = new ReentrantLock();
  
  protected Lock parentLockMethod() { return parentLock; }
  protected static Lock parentStaticLockMethod() { return parentStaticLock; }
}

public class Test extends Parent {
  private static final Lock staticLock = new ReentrantLock();
  private final Lock lock = new ReentrantLock();
  
  // THIS --- Doesn't make sense for read-write locks
  
  // INSTANCE FIELD
  @GuardedBy("lock")
  private int f2a;
  
  @GuardedBy("Test.lock")
  private int f2b;
  
  // SUPERCLASS INSTANCE FIELD
  @GuardedBy("parentLock")
  private int f3a;
  
  @GuardedBy("Parent.parentLock")
  private int f3b;
  
  // CLASS --- Doesn't make sense for read-write locks

  // STATIC FIELD
  @GuardedBy("staticLock")
  private int f5a;
  
  @GuardedBy("staticLock")
  private static int s2a;

  @GuardedBy("Test.staticLock")
  private int f5b;
  
  @GuardedBy("Test.staticLock")
  private static int s2b;

  // OTHER STATIC FIELD
  @GuardedBy("parentStaticLock")
  private int f5c;
  
  @GuardedBy("parentStaticLock")
  private static int s2c;

  @GuardedBy("Parent.parentStaticLock")
  private int f5d;
  
  @GuardedBy("Parent.parentStaticLock")
  private static int s2d;

  @GuardedBy("Other.otherStaticLock")
  private int f5e;
  
  @GuardedBy("Other.otherStaticLock")
  private static int s2e;
  
  // INSTANCE METHOD
  @GuardedBy("lockMethod()")
  private int f6a;
  
  @GuardedBy("Test.lockMethod()")
  private int f6b;
  
  // SUPERCLASS INSTANCE METHOD
  @GuardedBy("parentLockMethod()")
  private int f7a;
  
  @GuardedBy("Parent.parentLockMethod()")
  private int f7b;
  
  // STATIC METHOD
  @GuardedBy("staticLockMethod()")
  private int f8a;
  
  @GuardedBy("staticLockMethod()")
  private static int s3a;

  @GuardedBy("Test.staticLockMethod()")
  private int f8b;
  
  @GuardedBy("Test.staticLockMethod()")
  private static int s3b;

  // OTHER STATIC METHOD
  @GuardedBy("Parent.parentStaticLockMethod()")
  private int f8c;
  
  @GuardedBy("Parent.parentStaticLockMethod()")
  private static int s3c;
  
  @GuardedBy("Other.otherStaticLockMethod()")
  private int f8d;
  
  @GuardedBy("Other.otherStaticLockMethod()")
  private static int s3d;
  
  // ITSELF -- Doesn't make sense for read-write locks
  
  
  
  private Lock lockMethod() { return lock; }
  private static Lock staticLockMethod() { return staticLock; }
  
  
  public void doStuff() {
    @SuppressWarnings("unused")
    int local;
    
    lock.lock();
    try {
      f2a = 0;
      local = f2a;
      
      f2b = 0;
      local = f2b;
    } finally {
      lock.unlock();
    }
    
    f2a = 0;
    local = f2a;
    
    f2b = 0;
    local = f2b;

    
    
    parentLock.lock();
    try {
      f3a = 0;
      local = f3a;
      
      f3b = 0;
      local = f3b;
    } finally {
      parentLock.unlock();
    }
    
    f3a = 0;
    local = f3a;
    
    f3b = 0;
    local = f3b;

    
    
    staticLock.lock();
    try {
      f5a = 0;
      local = f5a;
      
      s2a = 0;
      local = s2a;
      
      f5b = 0;
      local = f5b;
      
      s2b = 0;
      local = s2b;
    } finally {
      staticLock.unlock();
    }
    
    f5a = 0;
    local = f5a;
    
    s2a = 0;
    local = s2a;
    
    f5b = 0;
    local = f5b;
    
    s2b = 0;
    local = s2b;

    
    
    parentStaticLock.lock();
    try {
      f5c = 0;
      local = f5c;
      
      s2c = 0;
      local = s2c;
      
      f5d = 0;
      local = f5d;
      
      s2d = 0;
      local = s2d;
    } finally {
      parentStaticLock.unlock();
    }
    
    f5c = 0;
    local = f5c;
    
    s2c = 0;
    local = s2c;
    
    f5d = 0;
    local = f5d;
    
    s2d = 0;
    local = s2d;
    
    
    
    Other.otherStaticLock.lock();
    try {
      f5e = 0;
      local = f5e;
      
      s2e = 0;
      local = s2e;
    } finally {
      Other.otherStaticLock.unlock();
    }
    
    f5e = 0;
    local = f5e;
    
    s2e = 0;
    local = s2e;
    
    
    
    lockMethod().lock();
    try {
      f6a = 0;
      local = f6a;
        
      f6b = 0;
      local = f6b;
    } finally {
      lockMethod().unlock();
    }

    f6a = 0;
    local = f6a;
    
    f6b = 0;
    local = f6b;

    
    
    parentLockMethod().lock();
    try {
      f7a = 0;
      local = f7a;
      
      f7b = 0;
      local = f7b;
    } finally {
      parentLockMethod().unlock();
    }

    f7a = 0;
    local = f7a;
    
    f7b = 0;
    local = f7b;
    
    
    
    staticLockMethod().lock();
    try {
      f8a = 0;
      local = f8a;
      
      s3a = 0;
      local = s3a;
      
      f8b = 0;
      local = f8b;
      
      s3b = 0;
      local = s3b;
    } finally {
      staticLockMethod().unlock();
    }
    
    f8a = 0;
    local = f8a;
    
    s3a = 0;
    local = s3a;
    
    f8b = 0;
    local = f8b;
    
    s3b = 0;
    local = s3b;
    
    
    
    Parent.parentStaticLockMethod().lock();
    try {
      f8c = 0;
      local = f8c;
      
      s3c = 0;
      local = s3c;
    } finally {
      Parent.parentStaticLockMethod().unlock();
    }
    
    f8c = 0;
    local = f8c;
    
    s3c = 0;
    local = s3c;
    
    
    
    Other.otherStaticLockMethod().lock();
    try {
      f8d = 0;
      local = f8d;
      
      s3d = 0;
      local = s3d;
    } finally {
      Other.otherStaticLockMethod().unlock();
    }
    
    f8d = 0;
    local = f8d;
    
    s3d = 0;
    local = s3d;
  }
}

class Other {
  protected static final Lock otherStaticLock = new ReentrantLock();
  
  protected static Lock otherStaticLockMethod() { return otherStaticLock; }
}



class Point {
  public int x;
  public int y;
}