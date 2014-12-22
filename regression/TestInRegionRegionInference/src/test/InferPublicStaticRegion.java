package test;

import com.surelogic.InRegion;

public class InferPublicStaticRegion {
  @InRegion("Public")
  public int x;
  
  @InRegion("Public")
  protected int y;
  
  @InRegion("Public") 
  /*default*/ static int z;
  
  @InRegion("Public")
  private int w;
  
  
  // Final fields still cause errors
  @InRegion("NotCreated")
  public static final int finalField = 0;
}
