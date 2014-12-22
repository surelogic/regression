package test;

import com.surelogic.InRegion;

public class InferDefaultStaticRegion {
  @InRegion("Default")
  /*default*/ int x;
  
  @InRegion("Default")
  /*default*/ int y;
  
  @InRegion("Default") 
  /*default*/ int z;
  
  @InRegion("Default")
  private static int w;
  
  
  // Final fields still cause errors
  @InRegion("NotCreated")
  static final int finalField = 0;
}
