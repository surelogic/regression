package test;

import com.surelogic.NonNull;

public class Test {
  private int needsNonNull(final @NonNull Object o) { return 1; }
  
  private Object get() { return null; }
  
  
  
  public int testConditionalExpr(Object o) {
    int v;
    needsNonNull(o); // bad
    v = o == null ? needsNonNull(o) : needsNonNull(o); // bad, good
    v = o != null ? needsNonNull(o) : needsNonNull(o); // good, bad
    v = (o) == (null) ? needsNonNull(o) : needsNonNull(o); // bad, good
    v = ((o) == (null)) ? needsNonNull(o) : needsNonNull(o); // bad, good
    v = (o != null) ? needsNonNull(o) : needsNonNull(o); // good, bad
    v = (((((((o)) != (null))))))? needsNonNull(o) : needsNonNull(o); // good, bad
    return v;
  }
  

  
  public void testIf(Object o) {
    needsNonNull(o); // bad
    
    if (o == null) { needsNonNull(o); } else { needsNonNull(o); o = get(); } // bad, good
    needsNonNull(o); // bad
    
    if (o != null) { needsNonNull(o); } else { needsNonNull(o); o = get(); } // good, bad
    needsNonNull(o);
    
    if ((o) == (null)) { needsNonNull(o); } else { needsNonNull(o); } // bad, good
    if (((o) == (null))) { needsNonNull(o); } else { needsNonNull(o); } // bad, good
    if ((o != null)) { needsNonNull(o); } else { needsNonNull(o); } // good, bad
    if ((((((((o)) != (null))))))) { needsNonNull(o); } else { needsNonNull(o); } // good, bad
  }
  
  
  
  public void testWhile(Object o) {
    needsNonNull(o); // bad
    
    while (o != null) {
      needsNonNull(o); // good
      o = get();
    }
    needsNonNull(o); // bad
    
    while ((o) != (null)) {
      needsNonNull(o); // good
      o = get();
    }
    needsNonNull(o); // bad
    
    while (((((o != null))))) {
      needsNonNull(o); // good
      o = get();
    }
    needsNonNull(o); // bad
    
    while ((((((((o)))) != ((null)))))) {
      needsNonNull(o); // good
      o = get();
    }
    needsNonNull(o); // bad

  
  
    while (o == null) {
      needsNonNull(o); // bad
      o = get();
    }
    needsNonNull(o); // good
    
    while ((o) == (null)) {
      needsNonNull(o); // bad
      o = get();
    }
    needsNonNull(o); // good
    
    while (((((o == null))))) {
      needsNonNull(o); // bad
      o = get();
    }
    needsNonNull(o); // good
    
    while ((((((((o)))) == ((null)))))) {
      needsNonNull(o); // bad
      o = get();
    }
    needsNonNull(o); // good
  }



  public void testDo(Object o) {
    needsNonNull(o); // bad
    
    o = new Object();
    do { 
      needsNonNull(o); // good
      o = get();
      needsNonNull(o); // bad
    } while (o != null);
    needsNonNull(o); // bad
    
    o = new Object();
    do { 
      needsNonNull(o); // good
      o = get();
      needsNonNull(o); // bad
    } while ((o) != (null));
    needsNonNull(o); // bad
    
    o = new Object();
    do { 
      needsNonNull(o); // good
      o = get();
      needsNonNull(o); // bad
    } while (((((o != null)))));
    needsNonNull(o); // bad
    
    o = new Object();
    do { 
      needsNonNull(o); // good
      o = get();
      needsNonNull(o); // bad
    } while ((((((((o)))) != ((null))))));
    needsNonNull(o); // bad
  }
  
  
  
  public void testFor(Object o) {
    needsNonNull(o); // bad
    
    for (; o != null; ) {
      needsNonNull(o); // good
      o = get();
      needsNonNull(o); // bad
    }
    needsNonNull(o); // bad
  }
}
