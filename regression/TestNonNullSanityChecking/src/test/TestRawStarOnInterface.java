package test;

import java.io.Serializable;

import com.surelogic.Raw;

public class TestRawStarOnInterface {
  public void testParams(
      @Raw Object good_object,
      @Raw Serializable bad_interface) {
    // foo
  }
  
  
  
  @Raw(value="return")
  public Object good_object() { return null; }
  
  @Raw(value="return")
  public Serializable bad_interface() { return null; }
  
  

  // receivers cannot be an interface type
}
