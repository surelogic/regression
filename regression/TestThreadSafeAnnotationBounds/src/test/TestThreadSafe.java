package test;

import com.surelogic.Containable;
import com.surelogic.Immutable;
import com.surelogic.RegionEffects;
import com.surelogic.RegionLock;
import com.surelogic.ThreadSafe;
import com.surelogic.Unique;

@ThreadSafe(whenThreadSafe="A", whenImmutable="D", whenContainable="F")
@RegionLock("L is this protects Instance")
@SuppressWarnings("unused")
public class TestThreadSafe<A, B extends OtherTS, C, D, E extends OtherI, F, G extends OtherC> {
  // primitive 
  private int f1; // good
  
  
  // @ThreadSafe
  private OtherTS f2; // good
  
  private OtherTS[] f3; // bad
  
  private OtherTS[][] f4; // bad
  
  
  // ThreadSafe by annotation bounds
  private A f5; // good
  
  private A[] f6; // bad
  
  private A[][] f7; // bad
  
  
  // ThreadSafe by type bounds
  private B f8; // good
  
  private B[] f9; // bad
  
  private B[][] f10; // bad
  
  
  // Not Threadsafe, Immutable, or Containable
  private C f11; // bad
  
  private C[] f12; // bad
  
  private C[][] f13; // bad
  
  
  // @Immutable
  private OtherI f14; // good
  
  private OtherI[] f15; // bad
  
  private OtherI[][] f16; // bad
  
  
  // Immutable by annotation bounds
  private D f17; // good
  
  private D[] f18; // bad
  
  private D[][] f19; // bad
  
  
  // Immutable by type bounds
  private E f20; // good
  
  private E[] f21; // bad
  
  private E[][] f22; // bad
  
  
  // @Containable
  @Unique
  private OtherC f23; // good
  
  @Unique
  private OtherC[] f24; // Good
  
  @Unique
  private OtherC[][] f25; // bad
  
  
  // Containable by annotation bounds
  @Unique
  private F f26; // good
  
  @Unique
  private F[] f27; // good
  
  @Unique
  private F[][] f28; // bad
  
  
  // Containable by type bounds
  @Unique
  private G f29; // good
  
  @Unique
  private G[] f30; // good
  
  @Unique
  private G[][] f31; // bad
}

@ThreadSafe
class OtherTS {
  @RegionEffects("none")
  @Unique("return")
  public OtherTS() {}
}


@Immutable
class OtherI {
  @RegionEffects("none")
  @Unique("return")
  public OtherI() {}
}

@Containable
class OtherC {
  @RegionEffects("none")
  @Unique("return")
  public OtherC() {}
}
