package test;

import java.io.Serializable;

import com.surelogic.Initialized;

public class TestRawStarOnInterface {
  public void testParams(
      @Initialized(through="Object") Object good_object,
      @Initialized(through="Object") Serializable bad_interface) {
    // foo
  }
  
  
  
  @Initialized(through="Object", value="return") 
  public Object good_object() { return null; }
  
  @Initialized(through="Object", value="return") 
  public Serializable bad_interface() { return null; }
  
  

  // receivers cannot be an interface type
}
