package test;

class A {}
class B extends A {}

class X {}
class Y extends X {}

@SuppressWarnings("unused")
public class Test {
  private final boolean a = use(this); // Raw(Object)
  private final boolean aa = use(Test.this); // Raw(Object)
  
  private final Object o = new B() {
    private boolean f = use(this); // Raw(B)
    private boolean ff = use(Test.this); // Raw(Object)
    
    {
      use(this); // Raw(B)
      use(Test.this); // Raw(Object)
      
      new Y() {
        private boolean g = use(this); // Raw(Y)
        // no way to refer to the outer object created by the first anonymous class
        private boolean ggg = use(Test.this); // Raw(Object)
        
        {
          use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          use(Test.this); // Raw(Object)
        }
      };
      
      // Anonymous class should not break these
      use(this); // Raw(B)
      use(Test.this); // Raw(Object)
      
      /* NB. cannot call mm() from here because the qualified receiver
       * is raw, and we cannot annotated qualified receivers as 
       * possibly raw yet.
       * 
       * This means we need to check the types of outer objects against
       * the formal qualified receivers when type-checking.
       */
      // mm();  -- NonNull analysis should flag this as an error
    }
    
    // Anonymous class should not break these
    private boolean f2 = use(this); // Raw(B)
    private boolean ff2 = use(Test.this); // Raw(Object)
    
    public void mm() {
      /* Should track: this(anon class B) ... */
      use(this); // NOT_NULL -- Assumed to be because there is no annotation otherwise
      use(Test.this); // NOT_NULL -- Assumed to be, no way right now to annotate qualified receivers as otherwise, but perhaps should add in the future
      
      new Y() {
        private boolean g = use(this); // Raw(Y)
        // no way to refer to the outer object created by the first anonymous class
        private boolean ggg = use(Test.this); // NOT_NULL
        
        {
          use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          use(Test.this); // NOT_NULL
        }
      };
      
      // Anonymous class should not break these
      use(this); // NOT_NULL
      use(Test.this); // NOT_NULL
    }
  };
  
  // Anonymous class should not break these
  private final boolean a2 = use(this); // Raw(Object)
  private final boolean aa2 = use(Test.this); // Raw(Object)
  
  {
    use(this); // Raw(Object)
    use(Test.this); // Raw(Object)
    
    final Object o = new B() {
      private boolean f = use(this); // Raw(B)
      private boolean ff = use(Test.this); // Raw(Object)
      
      {
        use(this); // Raw(B)
        use(Test.this); // Raw(Object)
        
        new Y() {
          private boolean g = use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          private boolean ggg = use(Test.this); // Raw(Object)
          
          {
            use(this); // Raw(Y)
            // no way to refer to the outer object created by the first anonymous class
            use(Test.this); // Raw(Object)
          }
        };
        
        // Anonymous class should not break these
        use(this); // Raw(B)
        use(Test.this); // Raw(Object)
        
        /* NB. cannot call mm() from here because the qualified receiver
         * is raw, and we cannot annotated qualified receivers as 
         * possibly raw yet.
         * 
         * This means we need to check the types of outer objects against
         * the formal qualified receivers when type-checking.
         */
        // mm();  -- NonNull analysis should flag this as an error
      }
      
      // Anonymous class should not break these
      private boolean f2 = use(this); // Raw(B)
      private boolean ff2 = use(Test.this); // Raw(Object)
      
      public void mm() {
        /* Should track: this(anon class B), Test.this, this(anon clas Y) */
        use(this); // NOT_NULL -- Assumed because there is no annotation to the contrary
        use(Test.this); // NOT_NULL -- Assumed to be, no way right now to annotate qualified receivers as otherwise, but perhaps should add in the future
        
        new Y() {
          private boolean g = use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          private boolean ggg = use(Test.this); // NOT_NULL
          
          {
            use(this); // Raw(Y)
            // no way to refer to the outer object created by the first anonymous class
            use(Test.this); // NOT_NULL
          }
        };
        
        // Anonymous class should not break these
        use(this); // NOT_NULL
        use(Test.this); // NOT_NULL
      }
    };
  }
    
  // Anonymous class should not break these
  private final boolean a3 = use(this); // Raw(Object)
  private final boolean aa3 = use(Test.this); // Raw(Object)

  public static boolean use(final Object o) { return true; }
  
  public Test() {
    super();
    use(this);
  }

  private class C extends B {
    private boolean f = use(this); // Raw(B)
    private boolean ff = use(Test.this); // NOT_NULL
    
    {
      use(this); // Raw(B)
      use(Test.this); // NOT_NULL

      new Y() {
        private boolean g = use(this); // Raw(Y)
        private boolean gg = use(C.this); // Raw(B)
        private boolean ggg = use(Test.this); // NOT_NULL
        
        {
          use(this); // Raw(Y)
          use(C.this); // Raw(B)
          use(Test.this); // NOT_NULL
        }
      };

      // Anonymous class should not break these
      use(this); // Raw(B)
      use(Test.this); // NOT_NULL
    }

    public void m() {
      /* Should track: this(C), Test.this(Test), this(Y) */
      use(this); // NOT_NULL
      use(Test.this); // NOT_NULL

      new Y() {
        private boolean g = use(this); // Raw(Y)
        private boolean gg = use(C.this); // NOT_NULL
        private boolean ggg = use(Test.this); // NOT_NULL
        
        {
          use(this); // Raw(Y)
          use(C.this); // NOT_NULL
          use(Test.this); // NOT_NULL
        }
      };
      
      // Anonymous class should not break these
      use(this); // NOT_NULL
      use(Test.this); // NOT_NULL
    }
  }
  
  public void m() {
    /* Should track: this(Test), this(anon class B), this(anon class Y)*/
    final Object o = new B() {
      private boolean f = use(this); // Raw(B)
      private boolean ff = use(Test.this); // NOT_NULL
      
      {
        use(this); // Raw(B)
        use(Test.this); // NOT_NULL
        
        new Y() {
          private boolean g = use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          private boolean ggg = use(Test.this); // NOT_NULL
          
          {
            use(this); // Raw(Y)
            // no way to refer to the outer object created by the first anonymous class
            use(Test.this); // NOT_NULL
          }
        };

        // Anonymous class should not break these
        use(this); // Raw(B)
        use(Test.this); // NOT_NULL

        /* Can call mm() from here because Test.this is NOT_NULL. */
        // mm(); // not an error
      }

      // Anonymous class should not break these
      private boolean f2 = use(this); // Raw(B)
      private boolean ff2 = use(Test.this); // NOT_NULL

      public void mm() {
        /* Should track: this(anon class), Test.this(Test), test(anon class of Y) */
        use(this); // NOT_NULL -- Assumed to be because it is not annotated otherwise
        use(Test.this); // NOT_NULL -- Assumed to be, no way right now to annotate qualified receivers as otherwise, but perhaps should add in the future
        
        new Y() {
          private boolean g = use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          private boolean ggg = use(Test.this); // NOT_NULL
          
          {
            use(this); // Raw(Y)
            // no way to refer to the outer object created by the first anonymous class
            use(Test.this); // NOT_NULL
          }
        };
        
        // Anonymous class should not break these
        use(this); // NOT_NULL -- Assumed to be because it is not annotated otherwise
        use(Test.this); // NOT_NULL -- Assumed to be, no way right now to annotate qualified receivers as otherwise, but perhaps should add in the future
      }
    };
  }
}


