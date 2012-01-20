package test;

import com.surelogic.RegionLock;
import com.surelogic.ThreadSafe;
import com.surelogic.Vouch;

public final class TestThreadSafe {
  @ThreadSafe public static class TSClass {}
  @ThreadSafe public static interface TSInterface1 {}
  @ThreadSafe public static interface TSInterface2 {}
  
  public static class Class {}
  public static interface Interface1 {}
  public static interface Interface2 {}
  
  
  
  // Primitive type
  @ThreadSafe
  public static class Test01 {
    final int value; // GOOD
    
    public Test01(int v) {
      value = v;
    }
  }
  
  
  
  // Array type
  @ThreadSafe
  public static class Test02 {
    final int[] value; // BAD
    
    public Test02(int[] v) {
      value = v;
    }
  }
  
  
  
  // non-Threadsafe class
  @ThreadSafe
  public static class Test03 {
    final Class value; // BAD
    
    public Test03(Class v) {
      value = v;
    }
  }
  
  // non-Threadsafe class -- vouched
  @ThreadSafe
  public static class Test04 {
    @Vouch("ThreadSafe")
    final Class value; // GOOD
    
    public Test04(Class v) {
      value = v;
    }
  }
  
  // ThreadSafe class
  @ThreadSafe
  public static class Test05 {
    final TSClass value; // GOOD
    
    public Test05(TSClass v) {
      value = v;
    }
  }
  
  
  
  // non-Threadsafe interface
  @ThreadSafe
  public static class Test06 {
    final Interface1 value; // BAD
    
    public Test06(Interface1 v) {
      value = v;
    }
  }
  
  // non-Threadsafe interface -- vouched
  @ThreadSafe
  public static class Test07 {
    @Vouch("ThreadSafe")
    final Interface1 value; // GOOD
    
    public Test07(Interface1 v) {
      value = v;
    }
  }
  
  // ThreadSafe interface
  @ThreadSafe
  public static class Test08 {
    final TSInterface1 value; // GOOD
    
    public Test08(TSInterface1 v) {
      value = v;
    }
  }
  
  
  
  // Type formal: non-Threadsafe class
  @ThreadSafe
  public static class Test09<T extends Class> {
    final T value; // BAD
    
    public Test09(T v) {
      value = v;
    }
  }
  
  // Type formal: non-Threadsafe class -- vouched
  @ThreadSafe
  public static class Test10<T extends Class> {
    @Vouch("ThreadSafe")
    final T value; // GOOD
    
    public Test10(T v) {
      value = v;
    }
  }
  
  // Type formal: ThreadSafe class
  @ThreadSafe
  public static class Test11<T extends TSClass> {
    final T value; // GOOD
    
    public Test11(T v) {
      value = v;
    }
  }
  
  
  
  // Type formal: non-Threadsafe interface
  @ThreadSafe
  public static class Test12<T extends Interface1> {
    final T value; // BAD
    
    public Test12(T v) {
      value = v;
    }
  }
  
  // Type formal: non-Threadsafe interface -- vouched
  @ThreadSafe
  public static class Test13<T extends Interface1> {
    @Vouch("ThreadSafe")
    final T value; // GOOD
    
    public Test13(T v) {
      value = v;
    }
  }
  
  // Type formal: ThreadSafe interface
  @ThreadSafe
  public static class Test14<T extends TSInterface1> {
    final T value; // GOOD
    
    public Test14(T v) {
      value = v;
    }
  }


  
  // Type intersection: non-Threadsafe class & non-Threadsafe interfaces
  @ThreadSafe
  public static class Test15<T extends Class & Interface1 & Interface2> {
    final T value; // BAD
    
    public Test15(T v) {
      value = v;
    }
  }
  
  // Type intersection: non-Threadsafe class & non-Threadsafe interfaces + ThreadSafe interfaces
  @ThreadSafe
  public static class Test16<T extends Class & Interface1 & Interface2 & TSInterface1 & TSInterface2> {
    final T value; // GOOD
    
    public Test16(T v) {
      value = v;
    }
  }
  
  // Type intersection: ThreadSafe class & non-Threadsafe interfaces
  @ThreadSafe
  public static class Test17<T extends TSClass & Interface1 & Interface2> {
    final T value; // BAD
    
    public Test17(T v) {
      value = v;
    }
  }
  
  // Type intersection: ThreadSafe class & non-Threadsafe interfaces + ThreadSafe interfaces
  @ThreadSafe
  public static class Test18<T extends TSClass & Interface1 & Interface2 & TSInterface1 & TSInterface2> {
    final T value; // GOOD
    
    public Test18(T v) {
      value = v;
    }
  }


  
  // Type intersection: non-Threadsafe interface & non-Threadsafe interfaces
  @ThreadSafe
  public static class Test19<T extends Interface1 & Interface2> {
    final T value; // BAD
    
    public Test19(T v) {
      value = v;
    }
  }
  
  // Type intersection: non-Threadsafe interfaces + ThreadSafe interfaces
  @ThreadSafe
  public static class Test20<T extends Interface1 & Interface2 & TSInterface1 & TSInterface2> {
    final T value; // GOOD
    
    public Test20(T v) {
      value = v;
    }
  }
}
