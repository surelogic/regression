package test;

import com.surelogic.InRegion;

public class InferProtectedStaticRegion {
  @InRegion("Protected")
  protected static int x;
  
  @InRegion("Protected")
  protected int y;
  
  @InRegion("Protected") 
  /*default*/ int z;
  
  @InRegion("Protected")
  private int w;
  
  
  // Final fields still cause errors
  @InRegion("NotCreated")
  protected static final int finalField = 0;
}
