package nested.local;

@SuppressWarnings("unused")
public class OneCopy {
  public void method() {
  	// Class does not have a Static region of it's own: cannot have static fields
    class C {
    	// empty
    }
  }
}
