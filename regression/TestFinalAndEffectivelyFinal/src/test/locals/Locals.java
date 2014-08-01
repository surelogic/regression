package test.locals;

import com.surelogic.Vouch;

public class Locals {
  public void method() {
    int x = 0;
    final int y = 1, z = 2;
    int a = 0, b = 1, c = 2;
    
    System.out.println("foo");
    
    --a;
    
    final Object o = null;
    String s = "";
    
    b *= 4;
    
    System.out.println(s);
    
    c = 6;
  }
  
  public void m2(int p1, final int p2, int p3, boolean flag) {
    p3 += 1;
    
    int a;
    if (flag) {
      a = 1;
    } else {
      a = 2;
    }
    
    int b;
    if (flag) {
      b = 20;
    }
    
    int x;
    x = 5;
    x++;
    
    int y;
    y = 10;
    
    for (int q = 10; ; ) {
      break;
    }
    
    for (int w = 10; w < 100; w += 10) {
      // do stuff
    }
  }
  
  { 
    int a = 10;
    a += 5;
    
    int b = 20;
    int c = 4;
    ++c;
  }
  
  static {
    int a = 10;
    a += 5;
    
    int b = 20;
    int c = 4;
    ++c;
  }
  
  { 
    int a = 10;
    a += 5;
    
    int b = 20;
    int c = 4;
    ++c;
  }
  
  static {
    int a = 10;
    a += 5;
    
    int b = 20;
    int c = 4;
    ++c;
  }   
}
