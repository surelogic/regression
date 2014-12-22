package test;

import com.surelogic.InRegion;

public class InferPublicRegion {
  @InRegion("Public")
  public int x;
  
  @InRegion("Public")
  protected int y;
  
  @InRegion("Public") 
  /*default*/ int z;
  
  @InRegion("Public")
  private int w;
  
  
  // Final fields still cause errors
  @InRegion("NotCreated")
  public final int finalField = 0;
}
