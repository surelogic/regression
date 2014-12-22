package test;

import com.surelogic.InRegion;

public class InferDefaultRegion {
  @InRegion("Default")
  /*default*/ int x;
  
  @InRegion("Default")
  /*default*/ int y;
  
  @InRegion("Default") 
  /*default*/ int z;
  
  @InRegion("Default")
  private int w;
  
  
  // Final fields still cause errors
  @InRegion("NotCreated")
  final int finalField = 0;
}
