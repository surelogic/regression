package test;

import com.surelogic.Initialized;

public class TestRawStarOnReferencesOnly {
  public void testParams(
      @Initialized(through="*") int bad_int,
      @Initialized(through="*") boolean bad_boolean,
      @Initialized(through="*") Object good_object,
      @Initialized(through="*") int[] bad_int_array,
      @Initialized(through="*") Object[] bad_object_array) {
    // foo
  }
  
  @SuppressWarnings("unused")
  public void m() {
    @Initialized(through="*") int bad_int;
    @Initialized(through="*") boolean bad_boolean;
    @Initialized(through="*") Object good_object;
    @Initialized(through="*") int[] bad_int_array;
    @Initialized(through="*") Object[] bad_object_array;
  }
  
  @Initialized(through="*", value="return") 
  public int bad_int() { return 0; }
  
  @Initialized(through="*", value="return") 
  public boolean bad_boolean() { return false; }
  
  @Initialized(through="*", value="return") 
  public Object good_object() { return null; }
  
  @Initialized(through="*", value="return") 
  public int[] bad_int_array() { return null; }
  
  @Initialized(through="*", value="return") 
  public Object[] bad_object_array() { return null; }
  
  @Initialized(through="*", value="return") 
  public void bad_void() {}
  
  
  
  // receivers cannot be non-reference, non-class type
  
  
  // Test that the receiver exists
  
  @Initialized(through="*", value="this") // bad: no receiver
  public static void bad_static_method() {}
}
