package nested.local;

@SuppressWarnings("unused")
public class DifferentNames {
  public void method1() {
  	// Class does not have a Static region of it's own: cannot have static fields
    class C {
    	// empty
    }
  }
  
  public void method2() {
  	// Class does not have a Static region of it's own: cannot have static fields
    class D {
    	// empty
    }
  }
}
