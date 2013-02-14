package test;

@SuppressWarnings("unused")
public class Test2 {
  public static boolean use(final Object o) { return true; }

  private final boolean a = use(this); // Raw(Object)
  private final boolean aa = use(Test2.this); // Raw(Object)
  
  private final Object o = new B() {
    private boolean f = use(this); // Raw(B)
    private boolean ff = use(Test2.this); // Raw(Object)
    
    {
      use(this); // Raw(B)
      use(Test2.this); // Raw(Object)
      
      new Y() {
        private boolean g = use(this); // Raw(Y)
        // no way to refer to the outer object created by the first anonymous class
        private boolean ggg = use(Test2.this); // Raw(Object)
        
        {
          use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          use(Test2.this); // Raw(Object)
        }
      };
      
      // Anonymous class should not break these
      use(this); // Raw(B)
      use(Test2.this); // Raw(Object)
      
      new Y() {
        private boolean g = use(this); // Raw(Y)
        // no way to refer to the outer object created by the first anonymous class
        private boolean ggg = use(Test2.this); // Raw(Object)
        
        {
          use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          use(Test2.this); // Raw(Object)
        }
      };
      
      // Anonymous class should not break these
      use(this); // Raw(B)
      use(Test2.this); // Raw(Object)
      
      new Y() {
        private boolean g = use(this); // Raw(Y)
        // no way to refer to the outer object created by the first anonymous class
        private boolean ggg = use(Test2.this); // Raw(Object)
        
        {
          use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          use(Test2.this); // Raw(Object)
        }
      };
      
      // Anonymous class should not break these
      use(this); // Raw(B)
      use(Test2.this); // Raw(Object)
    }
    
    // Anonymous class should not break these
    private boolean f2 = use(this); // Raw(B)
    private boolean ff2 = use(Test2.this); // Raw(Object)
    
    public void mm() {
      /* Should track: this(anon class B) ... */
      use(this); // NOT_RAW -- Assumed to be because there is no annotation otherwise
      use(Test2.this); // NOT_RAW -- Assumed to be, no way right now to annotate qualified receivers as otherwise, but perhaps should add in the future
      
      new Y() {
        private boolean g = use(this); // Raw(Y)
        // no way to refer to the outer object created by the first anonymous class
        private boolean ggg = use(Test2.this); // NOT_RAW
        
        {
          use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          use(Test2.this); // NOT_RAW
        }
      };
      
      // Anonymous class should not break these
      use(this); // NOT_RAW
      use(Test2.this); // NOT_RAW
    }
  };



  
  private final Object oo = new B() {
    private boolean f = use(this); // Raw(B)
    private boolean ff = use(Test2.this); // Raw(Object)
    
    {
      use(this); // Raw(B)
      use(Test2.this); // Raw(Object)
      
      new Y() {
        private boolean g = use(this); // Raw(Y)
        // no way to refer to the outer object created by the first anonymous class
        private boolean ggg = use(Test2.this); // Raw(Object)
        
        {
          use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          use(Test2.this); // Raw(Object)
        }
      };
      
      // Anonymous class should not break these
      use(this); // Raw(B)
      use(Test2.this); // Raw(Object)
      
      new Y() {
        private boolean g = use(this); // Raw(Y)
        // no way to refer to the outer object created by the first anonymous class
        private boolean ggg = use(Test2.this); // Raw(Object)
        
        {
          use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          use(Test2.this); // Raw(Object)
        }
      };
      
      // Anonymous class should not break these
      use(this); // Raw(B)
      use(Test2.this); // Raw(Object)
      
      new Y() {
        private boolean g = use(this); // Raw(Y)
        // no way to refer to the outer object created by the first anonymous class
        private boolean ggg = use(Test2.this); // Raw(Object)
        
        {
          use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          use(Test2.this); // Raw(Object)
        }
      };
      
      // Anonymous class should not break these
      use(this); // Raw(B)
      use(Test2.this); // Raw(Object)
    }
    
    // Anonymous class should not break these
    private boolean f2 = use(this); // Raw(B)
    private boolean ff2 = use(Test2.this); // Raw(Object)
    
    public void mm() {
      /* Should track: this(anon class B) ... */
      use(this); // NOT_RAW -- Assumed to be because there is no annotation otherwise
      use(Test2.this); // NOT_RAW -- Assumed to be, no way right now to annotate qualified receivers as otherwise, but perhaps should add in the future
      
      new Y() {
        private boolean g = use(this); // Raw(Y)
        // no way to refer to the outer object created by the first anonymous class
        private boolean ggg = use(Test2.this); // NOT_RAW
        
        {
          use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          use(Test2.this); // NOT_RAW
        }
      };
      
      // Anonymous class should not break these
      use(this); // NOT_RAW
      use(Test2.this); // NOT_RAW
    }
  };



  {
    new B() {
      private boolean f = use(this); // Raw(B)
      private boolean ff = use(Test2.this); // Raw(Object)
      
      {
        use(this); // Raw(B)
        use(Test2.this); // Raw(Object)
        
        new Y() {
          private boolean g = use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          private boolean ggg = use(Test2.this); // Raw(Object)
          
          {
            use(this); // Raw(Y)
            // no way to refer to the outer object created by the first anonymous class
            use(Test2.this); // Raw(Object)
          }
        };
        
        // Anonymous class should not break these
        use(this); // Raw(B)
        use(Test2.this); // Raw(Object)
        
        new Y() {
          private boolean g = use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          private boolean ggg = use(Test2.this); // Raw(Object)
          
          {
            use(this); // Raw(Y)
            // no way to refer to the outer object created by the first anonymous class
            use(Test2.this); // Raw(Object)
          }
        };
        
        // Anonymous class should not break these
        use(this); // Raw(B)
        use(Test2.this); // Raw(Object)
        
        new Y() {
          private boolean g = use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          private boolean ggg = use(Test2.this); // Raw(Object)
          
          {
            use(this); // Raw(Y)
            // no way to refer to the outer object created by the first anonymous class
            use(Test2.this); // Raw(Object)
          }
        };
        
        // Anonymous class should not break these
        use(this); // Raw(B)
        use(Test2.this); // Raw(Object)
      }
      
      // Anonymous class should not break these
      private boolean f2 = use(this); // Raw(B)
      private boolean ff2 = use(Test2.this); // Raw(Object)
      
      public void mm() {
        /* Should track: this(anon class B) ... */
        use(this); // NOT_RAW -- Assumed to be because there is no annotation otherwise
        use(Test2.this); // NOT_RAW -- Assumed to be, no way right now to annotate qualified receivers as otherwise, but perhaps should add in the future
        
        new Y() {
          private boolean g = use(this); // Raw(Y)
          // no way to refer to the outer object created by the first anonymous class
          private boolean ggg = use(Test2.this); // NOT_RAW
          
          {
            use(this); // Raw(Y)
            // no way to refer to the outer object created by the first anonymous class
            use(Test2.this); // NOT_RAW
          }
        };
        
        // Anonymous class should not break these
        use(this); // NOT_RAW
        use(Test2.this); // NOT_RAW
      }
    };
  }
}


