package test;

import com.surelogic.Containable;
import com.surelogic.RegionLock;
import com.surelogic.ThreadSafe;
import com.surelogic.Unique;
import com.surelogic.Vouch;

public final class TestThreadSafe2 {
  @Containable public static class CClass { @Unique("return") public CClass() {} }
  @Containable public static interface CInterface1 {}
  @Containable public static interface CInterface2 {}
  
  public static class Class {}
  public static interface Interface1 {}
  public static interface Interface2 {}
  
  
  
  // Array type
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test02a {
    @Unique
    final int[] value; // GOOD
    
    public Test02a(@Unique int[] v) {
      value = v;
    }
  }

  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test02b {
    @Unique
    final Object[] value; // GOOD
    
    public Test02b(@Unique Object[] v) {
      value = v;
    }
  }

  
  
  // non-Containable class
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test03 {
    @Unique
    final Class value; // BAD
    
    public Test03(@Unique Class v) {
      value = v;
    }
  }
  
  // non-Containable class -- vouched
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test04 {
    @Vouch("ThreadSafe")
    @Unique
    final Class value; // GOOD
    
    public Test04(@Unique Class v) {
      value = v;
    }
  }
  
  // Containable class
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test05 {
    @Unique
    final CClass value; // GOOD
    
    public Test05(@Unique CClass v) {
      value = v;
    }
  }
  
  
  
  // non-Threadsafe interface
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test06 {
    @Unique
    final Interface1 value; // BAD
    
    public Test06(@Unique Interface1 v) {
      value = v;
    }
  }
  
  // non-Threadsafe interface -- vouched
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test07 {
    @Vouch("ThreadSafe")
    @Unique
    final Interface1 value; // GOOD
    
    public Test07(@Unique Interface1 v) {
      value = v;
    }
  }
  
  // ThreadSafe interface
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test08 {
    @Unique
    final CInterface1 value; // GOOD
    
    public Test08(@Unique CInterface1 v) {
      value = v;
    }
  }
  
  
  
  // Type formal: non-Threadsafe class
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test09<T extends Class> {
    @Unique
    final T value; // BAD
    
    public Test09(@Unique T v) {
      value = v;
    }
  }
  
  // Type formal: non-Threadsafe class -- vouched
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test10<T extends Class> {
    @Vouch("ThreadSafe")
    @Unique
    final T value; // GOOD
    
    public Test10(@Unique T v) {
      value = v;
    }
  }
  
  // Type formal: ThreadSafe class
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test11<T extends CClass> {
    @Unique
    final T value; // GOOD
    
    public Test11(@Unique T v) {
      value = v;
    }
  }
  
  
  
  // Type formal: non-Threadsafe interface
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test12<T extends Interface1> {
    @Unique
    final T value; // BAD
    
    public Test12(@Unique T v) {
      value = v;
    }
  }
  
  // Type formal: non-Threadsafe interface -- vouched
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test13<T extends Interface1> {
    @Vouch("ThreadSafe")
    @Unique
    final T value; // GOOD
    
    public Test13(@Unique T v) {
      value = v;
    }
  }
  
  // Type formal: ThreadSafe interface
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test14<T extends CInterface1> {
    @Unique
    final T value; // GOOD
    
    public Test14(@Unique T v) {
      value = v;
    }
  }


  
  // Type intersection: non-Threadsafe class & non-Threadsafe interfaces
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test15<T extends Class & Interface1 & Interface2> {
    @Unique
    final T value; // BAD
    
    public Test15(@Unique T v) {
      value = v;
    }
  }
  
  // Type intersection: non-Threadsafe class & non-Threadsafe interfaces + ThreadSafe interfaces
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test16<T extends Class & Interface1 & Interface2 & CInterface1 & CInterface2> {
    @Unique
    final T value; // GOOD
    
    public Test16(@Unique T v) {
      value = v;
    }
  }
  
  // Type intersection: ThreadSafe class & non-Threadsafe interfaces
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test17<T extends CClass & Interface1 & Interface2> {
    @Unique
    final T value; // BAD
    
    public Test17(@Unique T v) {
      value = v;
    }
  }
  
  // Type intersection: ThreadSafe class & non-Threadsafe interfaces + ThreadSafe interfaces
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test18<T extends CClass & Interface1 & Interface2 & CInterface1 & CInterface2> {
    @Unique
    final T value; // GOOD
    
    public Test18(@Unique T v) {
      value = v;
    }
  }


  
  // Type intersection: non-Threadsafe interface & non-Threadsafe interfaces
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test19<T extends Interface1 & Interface2> {
    @Unique
    final T value; // BAD
    
    public Test19(@Unique T v) {
      value = v;
    }
  }
  
  // Type intersection: non-Threadsafe interfaces + ThreadSafe interfaces
  @ThreadSafe
  @RegionLock("L is this protects Instance")
  public static class Test20<T extends Interface1 & Interface2 & CInterface1 & CInterface2> {
    @Unique
    final T value; // GOOD
    
    public Test20(@Unique T v) {
      value = v;
    }
  }
}
