package test;

import com.surelogic.InRegion;

public class InferProtectedRegion {
  @InRegion("Protected")
  protected int x;
  
  @InRegion("Protected")
  protected int y;
  
  @InRegion("Protected") 
  /*default*/ int z;
  
  @InRegion("Protected")
  private int w;
  
  
  // Final fields still cause errors
  @InRegion("NotCreated")
  protected final int finalField = 0;
}
