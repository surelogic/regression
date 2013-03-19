package test;

/* N.B. The testing module only checks the LHS of assignments for constancy. */
public class Test {
  @SuppressWarnings("unused")
  public void testLiterals(
      boolean bool, byte b, char c, short s, int i,
      long l, float f, double d, String str, Object o) {
    boolean l1;
    l1 = true; // good
    l1 = bool; // bad
    
    byte l2;
    l2 = 0; // good
    l2 = b; // bad
    
    char l3;
    l3 = 'c'; // good
    l3 = c; // bad
    
    short l4;
    l4 = 0; // good
    l4 = s; // bad
    
    int l5;
    l5 = 0; // good
    l5 = i; // bad
    
    long l6;
    l6 = 0L; // good
    l6 = l; // bad
    
    float l7;
    l7 = 0.0f; // good
    l7 = f; // bad
    
    double l8;
    l8 = 0.0; // good
    l8 = d; // bad
    
    String l9; 
    l9 = "String"; // good
    l9 = null; // bad
    l9 = str; // bad
    
    Object l10;
    l10 = new Object(); // bad
    l10 = null; // bad
    l10 = o; // bad
  }
  
  @SuppressWarnings("unused")
  public void testCast() {
    boolean l1;
    l1 = (boolean) true; // good
    
    byte l2;
    l2 = (byte) 0; // good
    
    char l3;
    l3 = (char) 65; // good
    
    short l4;
    l4 = (short) 0; // good
    
    int l5;
    l5 = (int) 0.0; // good
    
    long l6;
    l6 = (long) 0.0; // good
    
    float l7;
    l7 = (float) 0.0; // good
    
    double l8;
    l8 = (double) 0; // good
    
    String l9; 
    l9 = (String) "x"; // good
    
    Object l10;
    l10 = (Object) "x"; // bad
  }
  
  @SuppressWarnings("unused")
  public void testUnaryAndParens(boolean bool, int i) {
    int l1;
    l1 = (5); // good
    l1 = +(5); // good
    l1 = -(5); // good
    l1 = ~5; // good
    l1 = +i; //  bad;
    l1 = -i; // bad;
    l1 = ~i; // bad;
    l1 = i++; // bad
    l1 = ++i; // bad
    l1 = i--; // bad
    l1 = --i; // bad
    
    boolean l2;
    l2 = !true; // good
    l2 = !(true); // good
    l2 = !bool; // bad
  }
  
  @SuppressWarnings("unused")
  public void testMultiplicative(int i, int j, int k) {
    int l1;
    l1 = 5 * 10; // good
    l1 = 5 / 10; // good
    l1 = 5 % 7; // good
    
    double l2;
    l2 = 5.0 * 100; // good
    l2 = 100 / 2.0; // good
    l2 = 6.5 % 7; // good
    
    l1 = 5 * i; // bad
    l2 = j / 5; // bad
    l2 = j % k; // bad
  }
  
  @SuppressWarnings("unused")
  public void testAdditive(int i, int j, int k, String s1, String s2) {
    int l1;
    l1 = 5 + (-4); // good
    l1 = (int) ((4 + 3) - 4.0f); // good
    l1 = i + k; // bad;
    l1 = i + 3; // bad
    
    String s;
    s = "a" + "b" + (4 - 2); // good
    s = s1 + "a"; // bad
    s = s1 + s2; // bad
  }
  
  @SuppressWarnings("unused")
  public void testShift(int i, int j, int k) {
    int l1;
    l1 = 1 << 1; // good
    l1 = 3 >> 1; // good
    l1 = 47 >>> 2; // good
    
    l1 = i << j; // bad
    l1 = i << 2; // bad
    l1 = 4 << k; // bad
    
    l1 = ((4 << 2 + 3) * ~7) >>> 3; // good
  }
  
  @SuppressWarnings("unused")
  public void testRelational(int i, int j, double d, double dd) {
    boolean b1;
    b1 = 5 < 7; // good
    b1 = -(4) > (6 * 10); // good
    b1 = 0 <= 97f; // good
    b1 = 76 >= (5 << 1 >> 6); // good
    
    b1 = i < 6; // bad
    b1 = 7 > j; // bad
    b1 = i <= j; // bad

    b1 = 4.5 >= -(7.7 * 2.2); // good   
    b1 = 0.0 > dd; // bad
    b1 = d <= dd; // bad
    
    b1 = "String" instanceof String; // bad
  }
  
  @SuppressWarnings("unused")
  public void testEquality(int i, int j, double d, double dd) {
    boolean b;
    b = 5 == 10; // good   
    b = "String" != "foo"; // good   
    b = 0.0f == 0L; // good   
    b = (int) 'A' == 65; // good   
    
    b = i == j; // bad
    b = j != i; // bad
    b = d == 7; // bad
    b = dd != 47.5f; // bad
  }  
  
  @SuppressWarnings("unused")
  public void testBitwise(int i, int j) {
    int x;
    x = 0x0FF & 0xF; // good   
    x = 7 | 3; // good   
    x = 93 ^ (int) 0.0; // good   
    
    x = i & j; // bad
    x = j ^ 88; // bad
    x = 12 | i; // bad
  }
  
  @SuppressWarnings("unused")
  public void testLogical(boolean aa, boolean bb) {
    boolean b;
    b = true & false; // good   
    b = false | true; // good   
    b = true ^ false; // good   
    
    b = (10 > 3) ^ (3 < 10); // good   
    
    b = aa & true;// bad
    b = false | bb;// bad
    b = aa ^ bb;// bad
    
    
    b = true && (7 > 10); // good   
    b = false || (0.001f <= (97L + 'k'));// good   
    b = aa || bb; // bad
    b = aa && bb; // bad
  }
  
  
  @SuppressWarnings("unused")
  public void testConditional(int i, int j, double d, double dd, String s1, String s2) {
    boolean b;
    b = (5 > 10) ? true : false; // good
    b = (true ? "String" : "foo") == "x"; // good

    int x;
    x = false ? 10 : 11; // good
    x = (9 + 10 >= ~4) ? 3 + -(9) : (int) 0.001; // good
    
    String s;
    s = (false) ? "s" : "x"; // good
    
    s = true ? s1 : s2; // bad
    s = (i > j) ? "a" : "b"; // bad
    s = (false) ? s2 : "j"; // bad
  }
  
  @SuppressWarnings("unused")
  public void testParens(int i) {
    int x;
    x = -(~(7 ^ 3) + 9); // good
    x = (i); // bad
  }
  
  
  private static int get_value() { return 10; }
  
  private final int final_simple_init_int = 10;
  private final int final_simple_bad_init_int = get_value();
  private int simple_init_int = 10;
  private int simple_int;
  private final int final_simple_int;

  private final String final_simple_init_string = "s";
  private final String final_simple_bad_init_string = Integer.toString(100);
  private String simple_init_string = "s";
  private String simple_string;
  private final String final_simple_string;

  private final Object final_simple_init_obj = "s";
  private final Object final_simple_bad_init_obj = Integer.toString(100);
  private Object simple_init_obj = "s";
  private Object simple_obj;
  private final Object final_simple_obj;

  Test() {
    final_simple_int = 10;
    final_simple_string = "s";
    final_simple_obj = "o";
  }
  
  @SuppressWarnings("unused")
  public void testSimpleNames() {
    int x;
    x = final_simple_init_int; // good
    x = this.final_simple_init_int; // bad
    x = final_simple_bad_init_int; // bad
    x = simple_init_int; // bad
    x = simple_int; // bad
    x = final_simple_int; // bad

    String s;
    s = final_simple_init_string; // good
    s = this.final_simple_init_string; // bad
    s = final_simple_bad_init_string; // bad
    s = simple_init_string; // bad
    s = simple_string; // bad
    s = final_simple_string; // bad

    Object o;
    o = final_simple_init_obj; // bad
    o = final_simple_bad_init_obj; // bad
    o = simple_init_obj; // bad
    o = simple_obj; // bad
    o = final_simple_obj; // bad
  }


  
  @SuppressWarnings("unused")
  public void testStaticFields() {
    int x;
    x = Other.final_simple_init_int; // good
    x = Other.final_simple_bad_init_int; // bad
    x = Other.simple_init_int; // bad
    x = Other.simple_int; // bad

    String s;
    s = Other.final_simple_init_string; // good
    s = Other.final_simple_bad_init_string; // bad
    s = Other.simple_init_string; // bad
    s = Other.simple_string; // bad

    Object o;
    o = Other.final_simple_init_obj; // bad
    o = Other.final_simple_bad_init_obj; // bad
    o = Other.simple_init_obj; // bad
    o = Other.simple_obj; // bad
  }
  
  
  @SuppressWarnings("unused")
  public void testEnumConstants() {
    // N.B. Enum constants are not constant expressions
    Object o;
    o = E.A;
  }
}


class Other {
  public static final int final_simple_init_int = 10;
  public static final int final_simple_bad_init_int = get_value();
  public static int simple_init_int = 10;
  public static int simple_int;

  public static final String final_simple_init_string = "s";
  public static final String final_simple_bad_init_string = Integer.toString(100);
  public static String simple_init_string = "s";
  public static String simple_string;

  public static final Object final_simple_init_obj = "s";
  public static final Object final_simple_bad_init_obj = Integer.toString(100);
  public static Object simple_init_obj = "s";
  public static Object simple_obj;

  private static int get_value() { return 10; }
}

enum E {
  A, B;
}
