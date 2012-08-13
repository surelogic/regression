package test;

import com.surelogic.Containable;
import com.surelogic.Unique;
import com.surelogic.Vouch;

public final class TestContainable {
  @Containable public static class CClass { @Unique("return") public CClass() {} }
  @Containable public static interface CInterface1 {}
  @Containable public static interface CInterface2 {}
  
  public static class Class {}
  public static interface Interface1 {}
  public static interface Interface2 {}
  
  
  
  // Primitive type
  @Containable
  public static class Test01 {
    final int value; // GOOD
    
    @Unique("return")
    public Test01(int v) {
      value = v;
    }
  }
  
  
  
  // Array type -- primitive
  @Containable
  public static class Test02a {
    @Unique
    final int[] value; // GOOD
    
    @Unique("return")
    public Test02a(@Unique int[] v) {
      value = v;
    }
  }
  
  // Array type -- object
  @Containable
  public static class Test02b {
    @Unique
    final CClass[] value; // GOOD!  (used to be bad)
    
    @Unique("return")
    public Test02b(@Unique CClass[] v) {
      value = v;
    }
  }
  
  
  
  // Noncontainable class
  @Containable
  public static class Test03 {
    @Unique
    final Class value; // BAD
    
    @Unique("return")
    public Test03(@Unique Class v) {
      value = v;
    }
  }
  
  // Noncontainable class -- vouched
  @Containable
  public static class Test04 {
    @Unique
    @Vouch("Containable")
    final Class value; // GOOD
    
    @Unique("return")
    public Test04(@Unique Class v) {
      value = v;
    }
  }
  
  // Containable class
  @Containable
  public static class Test05 {
    @Unique
    final CClass value; // GOOD
    
    @Unique("return")
    public Test05(@Unique CClass v) {
      value = v;
    }
  }
  
  
  
  // Noncontainable interface
  @Containable
  public static class Test06 {
    @Unique
    final Interface1 value; // BAD
    
    @Unique("return")
    public Test06(@Unique Interface1 v) {
      value = v;
    }
  }
  
  // Noncontainable interface -- vouched
  @Containable
  public static class Test07 {
    @Unique
    @Vouch("Containable")
    final Interface1 value; // GOOD
    
    @Unique("return")
    public Test07(@Unique Interface1 v) {
      value = v;
    }
  }
  
  // Containable interface
  @Containable
  public static class Test08 {
    @Unique
    final CInterface1 value; // GOOD
    
    @Unique("return")
    public Test08(@Unique CInterface1 v) {
      value = v;
    }
  }
  
  
  
  // Type formal: Noncontainable class
  @Containable
  public static class Test09<T extends Class> {
    @Unique
    final T value; // BAD
    
    @Unique("return")
    public Test09(@Unique T v) {
      value = v;
    }
  }
  
  // Type formal: Noncontainable class -- vouched
  @Containable
  public static class Test10<T extends Class> {
    @Unique
    @Vouch("Containable")
    final T value; // GOOD
    
    @Unique("return")
    public Test10(@Unique T v) {
      value = v;
    }
  }
  
  // Type formal: Containable class
  @Containable
  public static class Test11<T extends CClass> {
    @Unique
    final T value; // GOOD
    
    @Unique("return")
    public Test11(@Unique T v) {
      value = v;
    }
  }
  
  
  
  // Type formal: Noncontainable interface
  @Containable
  public static class Test12<T extends Interface1> {
    @Unique
    final T value; // BAD
    
    @Unique("return")
    public Test12(@Unique T v) {
      value = v;
    }
  }
  
  // Type formal: Noncontainable interface -- vouched
  @Containable
  public static class Test13<T extends Interface1> {
    @Unique
    @Vouch("Containable")
    final T value; // GOOD
    
    @Unique("return")
    public Test13(@Unique T v) {
      value = v;
    }
  }
  
  // Type formal: Containable interface
  @Containable
  public static class Test14<T extends CInterface1> {
    @Unique
    final T value; // GOOD
    
    @Unique("return")
    public Test14(@Unique T v) {
      value = v;
    }
  }


  
  // Type intersection: Noncontainable class & Noncontainable interfaces
  @Containable
  public static class Test15<T extends Class & Interface1 & Interface2> {
    @Unique
    final T value; // BAD
    
    @Unique("return")
    public Test15(@Unique T v) {
      value = v;
    }
  }
  
  // Type intersection: Noncontainable class & Noncontainable interfaces + Containable interfaces
  @Containable
  public static class Test16<T extends Class & Interface1 & Interface2 & CInterface1 & CInterface2> {
    @Unique
    final T value; // GOOD
    
    @Unique("return")
    public Test16(@Unique T v) {
      value = v;
    }
  }
  
  // Type intersection: Containable class & Noncontainable interfaces
  @Containable
  public static class Test17<T extends CClass & Interface1 & Interface2> {
    @Unique
    final T value; // BAD
    
    @Unique("return")
    public Test17(@Unique T v) {
      value = v;
    }
  }
  
  // Type intersection: Containable class & Noncontainable interfaces + Containable interfaces
  @Containable
  public static class Test18<T extends CClass & Interface1 & Interface2 & CInterface1 & CInterface2> {
    @Unique
    final T value; // GOOD
    
    @Unique("return")
    public Test18(@Unique T v) {
      value = v;
    }
  }


  
  // Type intersection: Noncontainable interface & Noncontainable interfaces
  @Containable
  public static class Test19<T extends Interface1 & Interface2> {
    @Unique
    final T value; // BAD
    
    @Unique("return")
    public Test19(@Unique T v) {
      value = v;
    }
  }
  
  // Type intersection: Noncontainable interfaces + Containable interfaces
  @Containable
  public static class Test20<T extends Interface1 & Interface2 & CInterface1 & CInterface2> {
    @Unique
    final T value; // GOOD
    
    @Unique("return")
    public Test20(@Unique T v) {
      value = v;
    }
  }
}
