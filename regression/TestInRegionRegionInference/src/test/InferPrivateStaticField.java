package test;

import com.surelogic.InRegion;

public class InferPrivateStaticField {
  @InRegion("Private")
  private int x;
  
  @InRegion("Private")
  private static int y;
  
  @InRegion("Private") 
  private int z;
  
  @InRegion("Private")
  private int w;
  
  
  // Final fields still cause errors
  @InRegion("NotCreated")
  private static final int finalField = 0;
}
