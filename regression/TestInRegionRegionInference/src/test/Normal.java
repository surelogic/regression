package test;

import com.surelogic.InRegion;
import com.surelogic.Region;

@Region("public Declared")
public class Normal {
  @InRegion("Declared")
  public int x;
  
  @InRegion("Declared")
  protected int y;
  
  @InRegion("Declared") 
  /*default*/ int z;
  
  @InRegion("Declared")
  private int w;
}
