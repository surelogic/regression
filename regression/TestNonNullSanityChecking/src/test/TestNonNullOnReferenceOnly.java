package test;

import com.surelogic.NonNull;

public class TestNonNullOnReferenceOnly {
  @NonNull
  private int bad_int = 0;
  
  @NonNull
  private boolean bad_boolean = false;
  
  @NonNull
  private Object good_object = "String";
  
  @NonNull
  private int[] good_int_array = { 0 };
  
  @NonNull
  private Object[] good_object_array = { "String" };
  
  
  
  @SuppressWarnings("unused")
  public void testLocals() {
    @NonNull
    int bad_int;
    
    @NonNull
    boolean bad_boolean;
    
    @NonNull
    Object good_object;
    
    @NonNull
    int[] good_int_array;
    
    @NonNull
    Object[] good_object_array;    
  }
  
  
  
  public void testParams(
      @NonNull int bad_int,
      @NonNull boolean bad_boolean,
      @NonNull Object good_object,
      @NonNull int[] good_int_array,
      @NonNull Object[] good_object_array) {
    // foo
  }
  
  
  
  @NonNull
  public int bad_int() { return 0; }
  
  @NonNull
  public boolean bad_boolean() { return false; }
  
  @NonNull
  public Object good_object() { return null; }
  
  @NonNull
  public int[] good_int_array() { return null; }
  
  @NonNull
  public Object[] good_object_array() { return null; }
  
  @NonNull
  public void bad_void() {}
}
