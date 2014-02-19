package test;

import java.io.Serializable;

import com.surelogic.Initialized;

public class TestRawStarOnInterface {
  public void testParams(
      @Initialized(through="*") Object good_object,
      @Initialized(through="*") Serializable bad_interface) {
    // foo
  }
  
  
  
  @Initialized(through="*", value="return") 
  public Object good_object() { return null; }
  
  @Initialized(through="*", value="return") 
  public Serializable bad_interface() { return null; }
  
  

  // receivers cannot be an interface type
}
