package test.guardedBy;

import com.surelogic.GuardedBy;

class Parent {
  protected static final Object parentStaticLock = new Object();
  protected final Object parentLock = new Object();
  
  protected String parentLockMethod() { return "shazam"; }
  protected static String parentStaticLockMethod() { return "marvel"; }
}

public class Test extends Parent {
  private static final Object staticLock = new Object();
  private final Object lock = new Object();
  
  // THIS
  @GuardedBy("this")
  private int f1;
  
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
  
  // CLASS
  @GuardedBy("Test.class")
  private int f4a;
  
  @GuardedBy("Test.class")
  private static int s1a;
  
  // OTHER.CLASS
  @GuardedBy("Parent.class")
  private int f4b;
  
  @GuardedBy("Parent.class")
  private static int s1b;
  
  @GuardedBy("Other.class")
  private int f4c;
  
  @GuardedBy("Other.class")
  private static int s1c;

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
  
  // ITSELF
  @GuardedBy("itself")
  private final Point f9a = new Point();
  
  private final Point f9b = new Point();
  
  @GuardedBy("itself")
  private static final Point s4a = new Point();
  
  private static final Point s4b = new Point();
  
  
  
  private String lockMethod() { return "foo"; }
  private static String staticLockMethod() { return "bar"; }
  
  
  public void doStuff() {
    @SuppressWarnings("unused")
    int local;
    
    synchronized (this) {
      f1 = 0;
      local = f1;
    }
    
    f1 = 0;
    local = f1;

    
    
    synchronized (this.lock) {
      f2a = 0;
      local = f2a;
      
      f2b = 0;
      local = f2b;
    }
    
    f2a = 0;
    local = f2a;
    
    f2b = 0;
    local = f2b;

    
    
    synchronized (parentLock) {
      f3a = 0;
      local = f3a;
      
      f3b = 0;
      local = f3b;
    }
    
    f3a = 0;
    local = f3a;
    
    f3b = 0;
    local = f3b;
    

    
    synchronized (Test.class) { 
      f4a = 0;
      local = f4a;
      
      s1a = 0;
      local = s1a;
    }
    
    f4a = 0;
    local = f4a;
    
    s1a = 0;
    local = s1a;

    
    
    synchronized (Parent.class) {
      f4b = 0;
      local = f4b;
      
      s1b = 0;
      local = s1b;
    }
    
    f4b = 0;
    local = f4b;
    
    s1b = 0;
    local = s1b;

    
    
    synchronized (Other.class) {
      f4c = 0;
      local = f4c;
      
      s1c = 0;
      local = s1c;
    }    
    
    f4c = 0;
    local = f4c;
    
    s1c = 0;
    local = s1c;

    
    
    synchronized (staticLock) {
      f5a = 0;
      local = f5a;
      
      s2a = 0;
      local = s2a;
      
      f5b = 0;
      local = f5b;
      
      s2b = 0;
      local = s2b;
    }
    
    f5a = 0;
    local = f5a;
    
    s2a = 0;
    local = s2a;
    
    f5b = 0;
    local = f5b;
    
    s2b = 0;
    local = s2b;
    

    
    synchronized (parentStaticLock) {
      f5c = 0;
      local = f5c;
      
      s2c = 0;
      local = s2c;
      
      f5d = 0;
      local = f5d;
      
      s2d = 0;
      local = s2d;
    }
    
    f5c = 0;
    local = f5c;
    
    s2c = 0;
    local = s2c;
    
    f5d = 0;
    local = f5d;
    
    s2d = 0;
    local = s2d;
    
    
    
    synchronized (Other.otherStaticLock) {
      f5e = 0;
      local = f5e;
      
      s2e = 0;
      local = s2e;
    }
    
    f5e = 0;
    local = f5e;
    
    s2e = 0;
    local = s2e;
    
    
    
    synchronized (lockMethod()) {
      f6a = 0;
      local = f6a;
      
      f6b = 0;
      local = f6b;
    }
    
    f6a = 0;
    local = f6a;
    
    f6b = 0;
    local = f6b;

    
    
    synchronized (parentLockMethod()) {
      f7a = 0;
      local = f7a;
      
      f7b = 0;
      local = f7b;
    }
    
    f7a = 0;
    local = f7a;
    
    f7b = 0;
    local = f7b;

    
    
    synchronized (staticLockMethod()) {
      f8a = 0;
      local = f8a;
      
      s3a = 0;
      local = s3a;
      
      f8b = 0;
      local = f8b;
      
      s3b = 0;
      local = s3b;
    }
  
    f8a = 0;
    local = f8a;
    
    s3a = 0;
    local = s3a;
    
    f8b = 0;
    local = f8b;
    
    s3b = 0;
    local = s3b;

    
    
    synchronized (parentStaticLockMethod()) {
      f8c = 0;
      local = f8c;
      
      s3c = 0;
      local = s3c;
    }
    
    f8c = 0;
    local = f8c;
    
    s3c = 0;
    local = s3c;

    
    
    synchronized (Other.otherStaticLockMethod()) {
      f8d = 0;
      local = f8d;
      
      s3d = 0;
      local = s3d;
    }
    
    f8d = 0;
    local = f8d;
    
    s3d = 0;
    local = s3d;

    
    
    synchronized (f9a) {
      f9a.x = 0;
      local = f9a.y;
    }
    
    f9a.x = 0;
    local = f9a.y;
    
    // don't need lock
    f9b.x = 0;
    local = f9b.y;
    
    
    
    synchronized (s4a) {
      s4a.x = 0;
      local = s4a.y;
    }
    
    s4a.x = 0;
    local = s4a.y;
    
    // doesn't need lock
    s4b.x = 0;
    local = s4b.y;
  }
}

class Other {
  protected static final Object otherStaticLock = new Object();
  
  protected static String otherStaticLockMethod() { return "wow"; }
}



class Point {
  public int x;
  public int y;
}