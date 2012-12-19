package test;

public class Test {
  private Object f1;
  private Object f2;
  private Object f3;
  private int a;
  private int b;
  private int x = 10;
  
  public Test(boolean flag) {
    super();
    if (flag) {
      f1 = null;
    } else {
      f2 = null;
    }
    f3 = new Object();
    a = 1;
    
    // f1, f2, b are not definitely assigned
  }
  
  public Test() {
    this(false);
    // everything should be definitely assigned after the this(...) call
  }
  
  public Test(int a, int b) {
    super();
    // everything but x should be not definitely assigned
  }
  
  public void m() {
    // method should be ignored
  }
}
