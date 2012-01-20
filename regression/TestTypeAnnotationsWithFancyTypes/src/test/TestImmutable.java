package test;

import com.surelogic.Immutable;
import com.surelogic.Vouch;

public final class TestImmutable {
  @Immutable public static class IClass {}
  @Immutable public static interface IInterface1 {}
  @Immutable public static interface IInterface2 {}
  
  public static class Class {}
  public static interface Interface1 {}
  public static interface Interface2 {}
  
  
  
  // Primitive type
  @Immutable
  public static class Test01 {
    final int value; // GOOD
    
    public Test01(int v) {
      value = v;
    }
  }
  
  
  
  // Array type
  @Immutable
  public static class Test02 {
    final int[] value; // BAD
    
    public Test02(int[] v) {
      value = v;
    }
  }
  
  
  
  // Mutable class
  @Immutable
  public static class Test03 {
    final Class value; // BAD
    
    public Test03(Class v) {
      value = v;
    }
  }
  
  // Mutable class -- vouched
  @Immutable
  public static class Test04 {
    @Vouch("Immutable")
    final Class value; // GOOD
    
    public Test04(Class v) {
      value = v;
    }
  }
  
  // Immutable class
  @Immutable
  public static class Test05 {
    final IClass value; // GOOD
    
    public Test05(IClass v) {
      value = v;
    }
  }
  
  
  
  // Mutable interface
  @Immutable
  public static class Test06 {
    final Interface1 value; // BAD
    
    public Test06(Interface1 v) {
      value = v;
    }
  }
  
  // Mutable interface -- vouched
  @Immutable
  public static class Test07 {
    @Vouch("Immutable")
    final Interface1 value; // GOOD
    
    public Test07(Interface1 v) {
      value = v;
    }
  }
  
  // Immutable interface
  @Immutable
  public static class Test08 {
    final IInterface1 value; // GOOD
    
    public Test08(IInterface1 v) {
      value = v;
    }
  }
  
  
  
  // Type formal: Mutable class
  @Immutable
  public static class Test09<T extends Class> {
    final T value; // BAD
    
    public Test09(T v) {
      value = v;
    }
  }
  
  // Type formal: Mutable class -- vouched
  @Immutable
  public static class Test10<T extends Class> {
    @Vouch("Immutable")
    final T value; // GOOD
    
    public Test10(T v) {
      value = v;
    }
  }
  
  // Type formal: Immutable class
  @Immutable
  public static class Test11<T extends IClass> {
    final T value; // GOOD
    
    public Test11(T v) {
      value = v;
    }
  }
  
  
  
  // Type formal: Mutable interface
  @Immutable
  public static class Test12<T extends Interface1> {
    final T value; // BAD
    
    public Test12(T v) {
      value = v;
    }
  }
  
  // Type formal: Mutable interface -- vouched
  @Immutable
  public static class Test13<T extends Interface1> {
    @Vouch("Immutable")
    final T value; // GOOD
    
    public Test13(T v) {
      value = v;
    }
  }
  
  // Type formal: Immutable interface
  @Immutable
  public static class Test14<T extends IInterface1> {
    final T value; // GOOD
    
    public Test14(T v) {
      value = v;
    }
  }


  
  // Type intersection: Mutable class & mutable interfaces
  @Immutable
  public static class Test15<T extends Class & Interface1 & Interface2> {
    final T value; // BAD
    
    public Test15(T v) {
      value = v;
    }
  }
  
  // Type intersection: Mutable class & mutable interfaces + immutable interfaces
  @Immutable
  public static class Test16<T extends Class & Interface1 & Interface2 & IInterface1 & IInterface2> {
    final T value; // GOOD
    
    public Test16(T v) {
      value = v;
    }
  }
  
  // Type intersection: Immutable class & mutable interfaces
  @Immutable
  public static class Test17<T extends IClass & Interface1 & Interface2> {
    final T value; // BAD
    
    public Test17(T v) {
      value = v;
    }
  }
  
  // Type intersection: Immutable class & mutable interfaces + immutable interfaces
  @Immutable
  public static class Test18<T extends IClass & Interface1 & Interface2 & IInterface1 & IInterface2> {
    final T value; // GOOD
    
    public Test18(T v) {
      value = v;
    }
  }


  
  // Type intersection: Mutable interface & mutable interfaces
  @Immutable
  public static class Test19<T extends Interface1 & Interface2> {
    final T value; // BAD
    
    public Test19(T v) {
      value = v;
    }
  }
  
  // Type intersection: Mutable interfaces + immutable interfaces
  @Immutable
  public static class Test20<T extends Interface1 & Interface2 & IInterface1 & IInterface2> {
    final T value; // GOOD
    
    public Test20(T v) {
      value = v;
    }
  }
}
