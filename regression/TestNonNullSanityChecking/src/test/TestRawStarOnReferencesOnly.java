package test;

import com.surelogic.Raw;

public class TestRawStarOnReferencesOnly {
  public void testParams(
      @Raw int bad_int,
      @Raw boolean bad_boolean,
      @Raw Object good_object,
      @Raw int[] bad_int_array,
      @Raw Object[] bad_object_array) {
    // foo
  }
  
  @SuppressWarnings("unused")
  public void m() {
    @Raw int bad_int;
    @Raw boolean bad_boolean;
    @Raw Object good_object;
    @Raw int[] bad_int_array;
    @Raw Object[] bad_object_array;
  }
  
  @Raw(value="return")
  public int bad_int() { return 0; }
  
  @Raw(value="return")
  public boolean bad_boolean() { return false; }
  
  @Raw(value="return")
  public Object good_object() { return null; }
  
  @Raw(value="return")
  public int[] bad_int_array() { return null; }
  
  @Raw(value="return")
  public Object[] bad_object_array() { return null; }
  
  @Raw(value="return")
  public void bad_void() {}
  
  
  
  // receivers cannot be non-reference, non-class type
  
  
  // Test that the receiver exists
  
  @Raw(value="this") // bad: no receiver
  public static void bad_static_method() {}
}
