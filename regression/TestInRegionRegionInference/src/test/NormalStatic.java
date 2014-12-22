package test;

import com.surelogic.InRegion;
import com.surelogic.Region;

@Region("public static Declared")
public class NormalStatic {
  @InRegion("Declared")
  public static int x;
  
  @InRegion("Declared")
  protected int y;
  
  @InRegion("Declared") 
  /*default*/ int z;
  
  @InRegion("Declared")
  private int w;
}
