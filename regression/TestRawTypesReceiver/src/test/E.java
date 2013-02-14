package test;

enum E {
  A,
  B(10),
  C(20) {
    private boolean f = use(this);
    
    { 
      use(this);
    }
  };

  public static boolean use(final Object o) {return false;}

  private E() { use(this); }
  private E(int x) { use(this); }
}

