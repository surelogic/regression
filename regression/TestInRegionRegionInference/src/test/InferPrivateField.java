package test;

import com.surelogic.InRegion;

public class InferPrivateField {
  @InRegion("Private")
  private int x;
  
  @InRegion("Private")
  private int y;
  
  @InRegion("Private") 
  private int z;
  
  @InRegion("Private")
  private int w;
  
  
  // Final fields still cause errors
  @InRegion("NotCreated")
  private final int finalField = 0;
}
