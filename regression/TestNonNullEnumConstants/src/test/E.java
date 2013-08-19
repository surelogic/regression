package test;

public enum E {
  A,
  B(1),
  C(2) {
    
  };
  
  E() {
    this(0);
  }
  
  E(int v) {
    // do nothing
  }
}
