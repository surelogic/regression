package nested.local;

@SuppressWarnings("unused")
// TEST: Binder used to confuse the two C classes 
public class TwoCopies {
  public static void method1() {
  	// Class does not have a Static region of it's own: cannot have static fields
    class C {
    	// empty
    }
  }
  
  public void method2() {
  	// Class does not have a Static region of it's own: cannot have static fields
    class C {
    	// empty
    }
  }
}
