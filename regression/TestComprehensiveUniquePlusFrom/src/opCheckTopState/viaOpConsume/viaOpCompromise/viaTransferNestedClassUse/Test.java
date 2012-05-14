package opCheckTopState.viaOpConsume.viaOpCompromise.viaTransferNestedClassUse;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

/* Check opCheckTopState when called by opConsume via opCompromise via 
 * transferNestedClassUse.  Being called by opCompromise, means the reference is 
 * going to be force to be SHARED.  This use from transferNestedClassUse 
 * compromises all the variables used externally by a nested class to
 * simulate the fact that they are actually assigned to hidden fields in the
 * nested class.
 */
@SuppressWarnings("unused")
public class Test {
  private final @Borrowed Object borrowedField = null;
  private @ReadOnly Object readOnlyField = null;
  private @Immutable Object immutableField = null;
  private Object sharedField = null;
  private @Unique(allowRead=true) Object uniqueWriteField = null;
  private @Unique Object uniqueField = null;

    
  
  @ReadOnly("return")
  private static Object getReadOnly() { return null; }
  
  @Immutable("return")
  private static Object getImmutable() { return null; }
  
  // Shared
  private static Object getShared() { return null; }
  
  @Unique(value="return", allowRead=true) 
  private static Object getUniqueWrite() { return null; }
  
  @Unique("return")
  private static Object getUnique() { return null; }

  
  
  @RegionEffects("none")
  public static void harmless(final @Borrowed Object p) {
    // do nothing
  }
  
  
//  // ***** From formal parameters
//  
//  public void borrowedParam(final @Borrowed Object p) {
//    final Object external = p;
//    
//    new Object() { // BAD
//      public void doStuff() {
//        harmless(external);
//      }
//    };
//  }
//  
//  public void readOnlyParam(final @ReadOnly Object p) {
//    final Object external = p;
//    
//    new Object() { // BAD
//      public void doStuff() {
//        harmless(external);
//      }
//    };
//  }
//  
//  public void immutableParam(final @Immutable Object p) {
//    final Object external = p;
//    
//    new Object() { // BAD
//      public void doStuff() {
//        harmless(external);
//      }
//    };
//  }
//  
//  public void sharedParam(final Object p) {
//    final Object external = p;
//    
//    new Object() { // GOOD
//      public void doStuff() {
//        harmless(external);
//      }
//    };
//  }
//  
//  public void uniqueWriteParam(final @Unique(allowRead=true) Object p) {
//    final Object external = p;
//    
//    new Object() { // GOOD
//      public void doStuff() {
//        harmless(external);
//      }
//    };
//  }
//  
//  public void uniqueParam(final @Unique Object p) {
//    final Object external = p;
//    
//    new Object() { // GOOD
//      public void doStuff() {
//        harmless(external);
//      }
//    };
//  }
//
//
//
//  // ***** From method return
//
//  // Cannot return a borrowed value
//  
//  public void readOnlyReturn() {
//    final Object external = getReadOnly();
//    
//    new Object() { // BAD
//      public void doStuff() {
//        harmless(external);
//      }
//    };
//  }
//  
//  public void immutableReturn() {
//    final Object external = getImmutable();
//    
//    new Object() { // BAD
//      public void doStuff() {
//        harmless(external);
//      }
//    };
//  }
//  
//  public void sharedReturn() {
//    final Object external = getShared();
//    
//    new Object() { // GOOD
//      public void doStuff() {
//        harmless(external);
//      }
//    };
//  }
//  
//  public void uniqueWriteReturn() {
//    final Object external = getUnique();
//    
//    new Object() { // GOOD
//      public void doStuff() {
//        harmless(external);
//      }
//    };
//  }
//  
//  public void uniqueReturn() {
//    final Object external = getUniqueWrite();
//    
//    new Object() { // GOOD
//      public void doStuff() {
//        harmless(external);
//      }
//    };
//  }

  
  
  // ***** From fields

  public void borrowedField() {
    final Object external = borrowedField;
    
    new Object() { // GOOD: reads as unique
      public void doStuff() {
        harmless(external);
      }
    };
    
    // But, borrowed field is compromised
  }
  
  public void readOnlyField() {
    final Object external = readOnlyField;
    
    new Object() { // BAD
      public void doStuff() {
        harmless(external);
      }
    };
  }
  
  public void immutableField() {
    final Object external = immutableField;
    
    new Object() { // BAD
      public void doStuff() {
        harmless(external);
      }
    };
  }
  
  public void sharedField() {
    final Object external = sharedField;
    
    new Object() { // GOOD
      public void doStuff() {
        harmless(external);
      }
    };
  }
  
  public void uniqueWriteField() {
    final Object external = uniqueWriteField;
    
    try {
      new Object() { // GOOD
        public void doStuff() {
          harmless(external);
        }
      };
    } finally {
      uniqueWriteField = null;
    }
  }
  
  public void uniqueField() {
    final Object external = uniqueField;
    
    try {
      new Object() { // GOOD
        public void doStuff() {
          harmless(external);
        }
      };
    } finally {
      uniqueField = null;
    }
  }
}
