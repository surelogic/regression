package test;

import com.surelogic.Nullable;

public class TestNullableOnReferencesOnly {
  @Nullable
  private int bad_int = 0;
  
  @Nullable
  private boolean bad_boolean = false;
  
  @Nullable
  private Object good_object = "String";
  
  @Nullable
  private int[] good_int_array = { 0 };
  
  @Nullable
  private Object[] good_object_array = { "String" };
  
  
  
  @SuppressWarnings("unused")
  public void testLocals() {
    @Nullable
    int bad_int;
    
    @Nullable
    boolean bad_boolean;
    
    @Nullable
    Object good_object;
    
    @Nullable
    int[] good_int_array;
    
    @Nullable
    Object[] good_object_array;    
  }
  
  
  
  public void testParams(
      @Nullable int bad_int,
      @Nullable boolean bad_boolean,
      @Nullable Object good_object,
      @Nullable int[] good_int_array,
      @Nullable Object[] good_object_array) {
    // foo
  }
  
  
  
  @Nullable
  public int bad_int() { return 0; }
  
  @Nullable
  public boolean bad_boolean() { return false; }
  
  @Nullable
  public Object good_object() { return null; }
  
  @Nullable
  public int[] good_int_array() { return null; }
  
  @Nullable
  public Object[] good_object_array() { return null; }
  
  @Nullable
  public void bad_void() {}
}
