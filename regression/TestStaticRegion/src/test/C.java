package test;

import com.surelogic.InRegion;
import com.surelogic.Region;
import com.surelogic.RegionEffects;
import com.surelogic.Regions;

@Regions({
  @Region("public static S"),
  @Region("public static R extends S")
})
public class C {
  public static int s1;
  
  @InRegion("S")
  public static int s2;
  
  @InRegion("R")
  public static int s3;
  
  
  
  // Make sure that all static fields in C are part of C:Static
  
  @RegionEffects("writes Static") // GOOD
  public void m1() {
    s1 = 1;
  }

  @RegionEffects("writes Static") // GOOD
  public void m2() {
    s2 = 1;
  }

  @RegionEffects("writes Static") // GOOD
  public void m3() {
    s3 = 1;
  }
  
  
  // Make sure that the static fields in C are not part of D:Static
  
  @RegionEffects("writes test.D:Static") // BAD
  public void n1() {
    s1 = 1;
  }

  @RegionEffects("writes test.D:Static") // BAD
  public void n2() {
    s2 = 1;
  }

  @RegionEffects("writes test.D:Static") // BAD
  public void n3() {
    s3 = 1;
  }
}


/* Make sure the Static region of a subclass is distinct from the Static region
 * of the parent. 
 */

@Regions({
  @Region("public static S"),
  @Region("public static R extends S")
})
class D extends C {
  public static int s1;
  
  @InRegion("S")
  public static int s2;
  
  @InRegion("R")
  public static int s3;
  
  
  
  // Make sure the fields of D are in D:Static
  
  @RegionEffects("writes test.D:Static")
  public void x1() {
    s1 = 1;
  }

  @RegionEffects("writes test.D:Static")
  public void x2() {
    s2 = 1;
  }

  @RegionEffects("writes test.D:Static")
  public void x3() {
    s3 = 1;
  }
  
  
  
  // Make sure the fields of D are not in C:Static 
  
  @RegionEffects("writes test.C:Static")
  public void y1() {
    s1 = 1;
  }

  @RegionEffects("writes test.C:Static")
  public void y2() {
    s2 = 1;
  }

  @RegionEffects("writes test.C:Static")
  public void y3() {
    s3 = 1;
  }
}
