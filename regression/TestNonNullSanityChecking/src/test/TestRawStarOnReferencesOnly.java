package test;

import com.surelogic.Initialized;

public class TestRawStarOnReferencesOnly {
  public void testParams(
      @Initialized(through="Object") int bad_int,
      @Initialized(through="Object") boolean bad_boolean,
      @Initialized(through="Object") Object good_object,
      @Initialized(through="Object") int[] bad_int_array,
      @Initialized(through="Object") Object[] bad_object_array) {
    // foo
  }
  
  @SuppressWarnings("unused")
  public void m() {
    @Initialized(through="Object") int bad_int;
    @Initialized(through="Object") boolean bad_boolean;
    @Initialized(through="Object") Object good_object;
    @Initialized(through="Object") int[] bad_int_array;
    @Initialized(through="Object") Object[] bad_object_array;
  }
  
  @Initialized(through="Object", value="return") 
  public int bad_int() { return 0; }
  
  @Initialized(through="Object", value="return") 
  public boolean bad_boolean() { return false; }
  
  @Initialized(through="Object", value="return") 
  public Object good_object() { return null; }
  
  @Initialized(through="Object", value="return") 
  public int[] bad_int_array() { return null; }
  
  @Initialized(through="Object", value="return") 
  public Object[] bad_object_array() { return null; }
  
  @Initialized(through="Object", value="return") 
  public void bad_void() {}
  
  
  
  // receivers cannot be non-reference, non-class type
  
  
  // Test that the receiver exists
  
  @Initialized(through="Object", value="this") // bad: no receiver
  public static void bad_static_method() {}
}
