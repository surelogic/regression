package test;

import com.surelogic.AnnotationBounds;
import com.surelogic.Containable;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

@Containable
@AnnotationBounds(containable="A")
public class TestContainable<A, B extends Other, C> {
  // primitive
  private int f1; // good
  
  
  // @Containable
  @Unique
  private Other f2; // good
  
  @Unique
  private Other[] f3; // was good, but is now bad
  
  @Unique
  private Other[][] f4; // bad
  
  
  // Containable by annotation bounds
  @Unique
  private A f5; // good
  
  @Unique
  private A[] f6; // was good, but is now bad
  
  @Unique
  private A[][] f7; // bad
  
  
  // Containable by type bounds
  @Unique 
  private B f8; // good
  
  @Unique
  private B[] f9; // was good, but is now bad
  
  @Unique
  private B[][] f10; // bad
  
  
  // Not containable
  @Unique
  private C f11; // bad
  
  @Unique 
  private C[] f12; // bad
  
  @Unique
  private C[][] f13; // bad
  
  
  
  @RegionEffects("none")
  @Unique("return")
  public TestContainable() {
    super();
  }
}


@Containable
class Other {
  @Unique("return")
  @RegionEffects("none")
  public Other() {}
}
