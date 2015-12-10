package test.guardedBy.rw;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.surelogic.GuardedBy;

class Parent {
  protected static final ReadWriteLock parentStaticLock = new ReentrantReadWriteLock();
  protected final ReadWriteLock parentLock = new ReentrantReadWriteLock();
  
  protected ReadWriteLock parentLockMethod() { return parentLock; }
  protected static ReadWriteLock parentStaticLockMethod() { return parentStaticLock; }
}

public class Test extends Parent {
  private static final ReadWriteLock staticLock = new ReentrantReadWriteLock();
  private final ReadWriteLock lock = new ReentrantReadWriteLock();
  
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
  
  
  
  private ReadWriteLock lockMethod() { return lock; }
  private static ReadWriteLock staticLockMethod() { return staticLock; }
  
  
  public void doStuff() {
    @SuppressWarnings("unused")
    int local;
    
    lock.readLock().lock();
    try {
      f2a = 0;
      local = f2a;
      
      f2b = 0;
      local = f2b;
    } finally {
      lock.readLock().unlock();
    }
    
    lock.writeLock().lock();
    try {
      f2a = 0;
      local = f2a;
      
      f2b = 0;
      local = f2b;
    } finally {
      lock.writeLock().unlock();
    }
    
    f2a = 0;
    local = f2a;
    
    f2b = 0;
    local = f2b;

    
    
    parentLock.readLock().lock();
    try {
      f3a = 0;
      local = f3a;
      
      f3b = 0;
      local = f3b;
    } finally {
      parentLock.readLock().unlock();
    }
    
    parentLock.writeLock().lock();
    try {
      f3a = 0;
      local = f3a;
      
      f3b = 0;
      local = f3b;
    } finally {
      parentLock.writeLock().unlock();
    }
    
    f3a = 0;
    local = f3a;
    
    f3b = 0;
    local = f3b;

    
    
    staticLock.readLock().lock();
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
      staticLock.readLock().unlock();
    }
    
    staticLock.writeLock().lock();
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
      staticLock.writeLock().unlock();
    }
    
    f5a = 0;
    local = f5a;
    
    s2a = 0;
    local = s2a;
    
    f5b = 0;
    local = f5b;
    
    s2b = 0;
    local = s2b;

    
    
    parentStaticLock.readLock().lock();
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
      parentStaticLock.readLock().unlock();
    }
    
    parentStaticLock.writeLock().lock();
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
      parentStaticLock.writeLock().unlock();
    }
    
    f5c = 0;
    local = f5c;
    
    s2c = 0;
    local = s2c;
    
    f5d = 0;
    local = f5d;
    
    s2d = 0;
    local = s2d;
    
    
    
    Other.otherStaticLock.readLock().lock();
    try {
      f5e = 0;
      local = f5e;
      
      s2e = 0;
      local = s2e;
    } finally {
      Other.otherStaticLock.readLock().unlock();
    }
    
    Other.otherStaticLock.writeLock().lock();
    try {
      f5e = 0;
      local = f5e;
      
      s2e = 0;
      local = s2e;
    } finally {
      Other.otherStaticLock.writeLock().unlock();
    }
    
    f5e = 0;
    local = f5e;
    
    s2e = 0;
    local = s2e;
    
    
    
    lockMethod().readLock().lock();
    try {
      f6a = 0;
      local = f6a;
        
      f6b = 0;
      local = f6b;
    } finally {
      lockMethod().readLock().unlock();
    }
    
    lockMethod().writeLock().lock();
    try {
      f6a = 0;
      local = f6a;
        
      f6b = 0;
      local = f6b;
    } finally {
      lockMethod().writeLock().unlock();
    }

    f6a = 0;
    local = f6a;
    
    f6b = 0;
    local = f6b;

    
    
    parentLockMethod().readLock().lock();
    try {
      f7a = 0;
      local = f7a;
      
      f7b = 0;
      local = f7b;
    } finally {
      parentLockMethod().readLock().unlock();
    }

    parentLockMethod().writeLock().lock();
    try {
      f7a = 0;
      local = f7a;
      
      f7b = 0;
      local = f7b;
    } finally {
      parentLockMethod().writeLock().unlock();
    }

    f7a = 0;
    local = f7a;
    
    f7b = 0;
    local = f7b;
    
    
    
    staticLockMethod().readLock().lock();
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
      staticLockMethod().readLock().unlock();
    }
    
    staticLockMethod().writeLock().lock();
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
      staticLockMethod().writeLock().unlock();
    }
    
    f8a = 0;
    local = f8a;
    
    s3a = 0;
    local = s3a;
    
    f8b = 0;
    local = f8b;
    
    s3b = 0;
    local = s3b;
    
    
    
    Parent.parentStaticLockMethod().readLock().lock();
    try {
      f8c = 0;
      local = f8c;
      
      s3c = 0;
      local = s3c;
    } finally {
      Parent.parentStaticLockMethod().readLock().unlock();
    }
    
    Parent.parentStaticLockMethod().writeLock().lock();
    try {
      f8c = 0;
      local = f8c;
      
      s3c = 0;
      local = s3c;
    } finally {
      Parent.parentStaticLockMethod().writeLock().unlock();
    }
    
    f8c = 0;
    local = f8c;
    
    s3c = 0;
    local = s3c;
    
    
    
    Other.otherStaticLockMethod().readLock().lock();
    try {
      f8d = 0;
      local = f8d;
      
      s3d = 0;
      local = s3d;
    } finally {
      Other.otherStaticLockMethod().readLock().unlock();
    }
    
    Other.otherStaticLockMethod().writeLock().lock();
    try {
      f8d = 0;
      local = f8d;
      
      s3d = 0;
      local = s3d;
    } finally {
      Other.otherStaticLockMethod().writeLock().unlock();
    }
    
    f8d = 0;
    local = f8d;
    
    s3d = 0;
    local = s3d;
  }
}

class Other {
  protected static final ReadWriteLock otherStaticLock = new ReentrantReadWriteLock();
  
  protected static ReadWriteLock otherStaticLockMethod() { return otherStaticLock; }
}



class Point {
  public int x;
  public int y;
}