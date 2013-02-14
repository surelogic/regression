package test;

class A {
  private boolean f_a1 = use(this);
  private boolean f_a2 = use(this);
  
  {
    use(this);
  }
  
  public static boolean use(final Object o) {return false;}
  
  public A() {
    super();
    use(this);
  }
  
  public A(Object o) {
    this();
    use(this);
  }
}

class B extends A {
  private boolean f_b1 = use(this);
  private boolean f_b2 = use(this);
  
  {
    use(this);
  }

  public B() {
    super();
    use(this);
  }
  
  public B(Object o) {
    this();
    use(this);
  }
}

public class Test extends B {
  private boolean f_t1 = use(this);
  private boolean f_t2 = use(this);
  
  {
    use(this);
  }

  public Test() {
    super();
    use(this);
  }
  
  public Test(Object o) {
    this();
    use(this);
  }
  
  
  
  public void m() {
    Object o = new B() {
      private boolean f = use(this);
      
      {
        use(this);
      }
    };
  }
}


