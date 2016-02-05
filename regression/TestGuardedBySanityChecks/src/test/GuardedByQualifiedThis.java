package test;

import com.surelogic.GuardedBy;

// Should be able to qualify this by our own name
public class GuardedByQualifiedThis {
  @GuardedBy("GuardedByQualifiedThis.this")
  private final int x = 0; // bad - final
  
  @GuardedBy("GuardedByQualifiedThis.this")
  private int xx = 0; // good
  
  @GuardedBy("GuardedByQualifiedThis.this")
  private final Object y = null; // bad - final
  
  @GuardedBy("GuardedByQualifiedThis.this")
  private String yy = null; // good
  
  

  @GuardedBy("GuardedByQualifiedThis.this")
  protected static final int s_x = 0; // bad - static
  
  @GuardedBy("GuardedByQualifiedThis.this")
  protected static int s_xx = 0; // bad - static
  
  @GuardedBy("GuardedByQualifiedThis.this")
  protected static final Object s_y = null; // bad - static
  
  @GuardedBy("GuardedByQualifiedThis.this")
  protected static String s_yy = null; // bad - static
  
  

  @GuardedBy("GuardedByQualifiedThis.this") // bad - constructor
  public GuardedByQualifiedThis() {
    super();
    GuardedByQualifiedThis.this.toString(); 
  }
  
  @GuardedBy("GuardedByQualifiedThis.this") // good
  void method1() {
    return;
  }
  
  @GuardedBy("GuardedByQualifiedThis.this") // bad - static
  public static void staticMethod1() {
    return;
  }



  // Qualify by our outer class
  public class Inner {
    @GuardedBy("GuardedByQualifiedThis.this")
    private final int x = 0; // bad - final
    
    @GuardedBy("GuardedByQualifiedThis.this")
    private int xx = 0; // good
    
    @GuardedBy("GuardedByQualifiedThis.this")
    private final Object y = null; // bad - final
    
    @GuardedBy("GuardedByQualifiedThis.this")
    private String yy = null; // good
    
    

    // Can have static primitive constants
    @GuardedBy("GuardedByQualifiedThis.this")
    protected static final int s_x = 0; // bad - static
    
    // Cannot have static fields
//    @GuardedBy("GuardedByQualifiedThis.this")
//    protected static int s_xx = 0; // bad - static
//    
//    @GuardedBy("GuardedByQualifiedThis.this")
//    protected static final Object s_y = null; // bad - static
//    
//    @GuardedBy("GuardedByQualifiedThis.this")
//    protected static String s_yy = null; // bad - static
    
    

    @GuardedBy("GuardedByQualifiedThis.this") // good - enclosing type
    public Inner() {
      super();
      GuardedByQualifiedThis.this.toString(); 
    }
    
    @GuardedBy("Inner.this") // bad - same as "this"
    public Inner(int x) {
      super();
    }
    
    @GuardedBy("GuardedByQualifiedThis.this") // good
    void method1() {
      return;
    }
    
    // Cannot have static methods
//    @GuardedBy("GuardedByQualifiedThis.this") // bad - static
//    public static void staticMethod1() {
//      return;
//    }


    // Qualify by grandparent class
    public class InnerInner1 {
      @GuardedBy("GuardedByQualifiedThis.this")
      private final int x = 0; // bad - final
      
      @GuardedBy("GuardedByQualifiedThis.this")
      private int xx = 0; // good
      
      @GuardedBy("GuardedByQualifiedThis.this")
      private final Object y = null; // bad - final
      
      @GuardedBy("GuardedByQualifiedThis.this")
      private String yy = null; // good
      
      

      // Can have static primitive constants
      @GuardedBy("GuardedByQualifiedThis.this")
      protected static final int s_x = 0; // bad - static
      
      // Cannot have static fields
//      @GuardedBy("GuardedByQualifiedThis.this")
//      protected static int s_xx = 0; // bad - static
//      
//      @GuardedBy("GuardedByQualifiedThis.this")
//      protected static final Object s_y = null; // bad - static
//      
//      @GuardedBy("GuardedByQualifiedThis.this")
//      protected static String s_yy = null; // bad - static
      
      

      @GuardedBy("GuardedByQualifiedThis.this") // good - enclosing type
      public InnerInner1() {
        super();
        GuardedByQualifiedThis.this.toString(); 
      }

      @GuardedBy("Inner.this") // good - enclosing type
      public InnerInner1(int x) {
        super();
      }
      
      @GuardedBy("InnerInner1.this") // bad - same as "this"
      public InnerInner1(int x, int y) {
        super();
      }
      
      
      
      @GuardedBy("GuardedByQualifiedThis.this") // good
      void method1() {
        return;
      }
      
      // Cannot have static methods
//      @GuardedBy("GuardedByQualifiedThis.this") // bad - static
//      public static void staticMethod1() {
//        return;
//      }
    }

    
    
    // Qualify by parent class, even though we are doubly nested
    public class InnerInner2 {
      @GuardedBy("Inner.this")
      private final int x = 0; // bad - final
      
      @GuardedBy("Inner.this")
      private int xx = 0; // good
      
      @GuardedBy("Inner.this")
      private final Object y = null; // bad - final
      
      @GuardedBy("Inner.this")
      private String yy = null; // good
      
      

      // Can have static primitive constants
      @GuardedBy("Inner.this")
      protected static final int s_x = 0; // bad - static
      
      // Cannot have static fields
//      @GuardedBy("Inner.this")
//      protected static int s_xx = 0; // bad - static
//      
//      @GuardedBy("Inner.this")
//      protected static final Object s_y = null; // bad - static
//      
//      @GuardedBy("Inner.this")
//      protected static String s_yy = null; // bad - static
      
      

      @GuardedBy("Inner.this") // bad - constructor
      public InnerInner2() {
        super();
        Inner.this.toString(); 
      }
      
      @GuardedBy("Inner.this") // good
      void method1() {
        return;
      }
      
      // Cannot have static methods
//      @GuardedBy("Inner.this") // bad - static
//      public static void staticMethod1() {
//        return;
//      }
    }

  
  
    // Cannot qualify by sibling class, makes no sense
    public class InnerInner3 {
      @GuardedBy("InnerInner2.this")
      private final int x = 0; // bad - final
      
      @GuardedBy("InnerInner2.this")
      private int xx = 0; // good
      
      @GuardedBy("InnerInner2.this")
      private final Object y = null; // bad - final
      
      @GuardedBy("InnerInner2.this")
      private String yy = null; // good
      
      

      // Can have static primitive constants
      @GuardedBy("InnerInner2.this")
      protected static final int s_x = 0; // bad - static
      
      // Cannot have static fields
//      @GuardedBy("InnerInner2.this")
//      protected static int s_xx = 0; // bad - static
//      
//      @GuardedBy("InnerInner2.this")
//      protected static final Object s_y = null; // bad - static
//      
//      @GuardedBy("InnerInner2.this")
//      protected static String s_yy = null; // bad - static
      
      

      @GuardedBy("InnerInner2.this") // bad - cannot resolve type
      public InnerInner3() {
        super();
//        InnerInner2.this.toString(); 
      }
      
      @GuardedBy("InnerInner2.this") // good
      void method1() {
        return;
      }
      
      // Cannot have static methods
//      @GuardedBy("InnerInner2.this") // bad - static
//      public static void staticMethod1() {
//        return;
//      }
    }
  }



  // Static inner class: there is no qualified receiver, so this is nonsense
  public static class StaticInner {
    @GuardedBy("GuardedByQualifiedThis.this")
    private final int x = 0; // bad
    
    @GuardedBy("GuardedByQualifiedThis.this")
    private int xx = 0; // bad
    
    @GuardedBy("GuardedByQualifiedThis.this")
    private final Object y = null; // bad 
    
    @GuardedBy("GuardedByQualifiedThis.this")
    private String yy = null; // bad
    
    

    @GuardedBy("GuardedByQualifiedThis.this")
    protected static final int s_x = 0; // bad
    
    @GuardedBy("GuardedByQualifiedThis.this")
    protected static int s_xx = 0; // bad 
    
    @GuardedBy("GuardedByQualifiedThis.this")
    protected static final Object s_y = null; // bad 
    
    @GuardedBy("GuardedByQualifiedThis.this")
    protected static String s_yy = null; // bad
    
    

    @GuardedBy("GuardedByQualifiedThis.this") // bad
    public StaticInner() {
      super();
//      GuardedByQualifiedThis.this.toString(); 
    }
    
    @GuardedBy("GuardedByQualifiedThis.this") // bad
    void method1() {
      return;
    }
    
    @GuardedBy("GuardedByQualifiedThis.this") // bad 
    public static void staticMethod1() {
      return;
    }
  }
}
