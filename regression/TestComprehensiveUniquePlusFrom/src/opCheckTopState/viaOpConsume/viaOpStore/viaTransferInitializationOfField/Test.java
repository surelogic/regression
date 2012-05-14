package opCheckTopState.viaOpConsume.viaOpStore.viaTransferInitializationOfField;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.Unique;

/* Don't have to check for assignment to @Borrowed fields because 
 * opCheckTopState is not used for them, opReturn is.
 */
@SuppressWarnings("unused")
public class Test {
  // no way to return a borrowed value
  
  @ReadOnly("return")
  private static Object getReadOnly() { return null; }
  
  @Immutable("return")
  private static Object getImmutable() { return null; }
  
  // Return a value object
  private static Value getValue() { return null; }
  
  // Shared
  private static Object getShared() { return null; }
  
  @Unique(value="return", allowRead=true) 
  private static Object getUniqueWrite() { return null; }
  
  @Unique("return")
  private static Object getUnique() { return null; }
  
 
  
  
  // ***** Assignment from formal parameters
  
  // ReadOnly field
  
  public void readOnlyField_borrowedParam(final @Borrowed Object o) {
    class C {
      private @ReadOnly Object readOnlyField = o; // BAD
    }
  }
  
  public void readOnlyField_readOnlyParam(final @ReadOnly Object o) {
    class C {
      private @ReadOnly Object readOnlyField = o; // GOOD
    }
  }
  
  public void readOnlyField_immutableParam(final @Immutable Object o) {
    class C {
      private @ReadOnly Object readOnlyField = o; // GOOD
    }
  }
  
  public void readOnlyField_valueParam(final Value o) {
    class C {
      private @ReadOnly Object readOnlyField = o; // GOOD
    }
  }
  
  public void readOnlyField_sharedParam(final Object o) {
    class C {
      private @ReadOnly Object readOnlyField = o; // GOOD
    }
  }
  
  public void readOnlyField_uniqueWriteParam(final @Unique(allowRead=true) Object o) {
    class C {
      private @ReadOnly Object readOnlyField = o; // GOOD
    }
  }
  
  public void readOnlyField_uniqueParam(final @Unique Object o) {
    class C {
      private @ReadOnly Object readOnlyField = o; // GOOD
    }
  }
  
  // Immutable field
  
  public void immutableField_borrowedParam(final @Borrowed Object o) {
    class C {
      private @Immutable Object immutableField = o; // BAD
    }
  }
  
  public void immutableField_readOnlyParam(final @ReadOnly Object o) {
    class C {
      private @Immutable Object immutableField = o; // BAD
    }
  }
  
  public void immutableField_immutableParam(final @Immutable Object o) {
    class C {
      private @Immutable Object immutableField = o; // GOOD
    }
  }
  
  public void immutableField_valueParam(final Value o) {
    class C {
      private @Immutable Object immutableField = o; // GOOD
    }
  }
  
  public void immutableField_sharedParam(final Object o) {
    class C {
      private @Immutable Object immutableField = o; // BAD
    }
  }
  
  public void immutableField_uniqueWriteParam(final @Unique(allowRead=true) Object o) {
    class C {
      private @Immutable Object immutableField = o; // GOOD
    }
  }
  
  public void immutableField_uniqueParam(final @Unique Object o) {
    class C {
      private @Immutable Object immutableField = o; // GOOD
    }
  }
  
  // Shared field
  
  public void sharedField_borrowedParam(final @Borrowed Object o) {
    class C {
      private Object sharedField = o; // BAD
    }
  }
  
  public void sharedField_readOnlyParam(final @ReadOnly Object o) {
    class C {
      private Object sharedField = o; // BAD
    }
  }
  
  public void sharedField_immutableParam(final @Immutable Object o) {
    class C {
      private Object sharedField = o; // BAD
    }
  }
  
  public void sharedField_valueParam(final Value o) {
    class C {
      private Object sharedField = o; // GOOD
    }
  }
  
  public void sharedField_sharedParam(final Object o) {
    class C {
      private Object sharedField = o; // GOOD
    }
  }
  
  public void sharedField_uniqueWriteParam(final @Unique(allowRead=true) Object o) {
    class C {
      private Object sharedField = o; // GOOD
    }
  }
  
  public void sharedField_uniqueParam(final @Unique Object o) {
    class C {
      private Object sharedField = o; // GOOD
    }
  }

  
  
  // ***** Assignment from method return values
  
  // ReadOnly field
  
  // Cannot have a borrowed return value
  
  public static class readOnlyField_readOnlyReturn {
    private @ReadOnly Object readOnlyField = getReadOnly(); // GOOD
  }
  
  public static class readOnlyField_immutableReturn {
    private @ReadOnly Object readOnlyField = getImmutable(); // GOOD
  }
  
  public static class readOnlyField_valueReturn {
    private @ReadOnly Object readOnlyField = getValue(); // GOOD
  }
  
  public static class readOnlyField_sharedReturn {
    private @ReadOnly Object readOnlyField = getShared(); // GOOD
  }
  
  public static class readOnlyField_uniqueWriteReturn {
    private @ReadOnly Object readOnlyField = getUniqueWrite(); // GOOD
  }
  
  public static class readOnlyField_uniqueReturn {
    private @ReadOnly Object readOnlyField = getUnique(); // GOOD
  }
  
  // Immutable field
  
  // Cannot have a borrowed return value
  
  public static class immutableField_readOnlyReturn {
    private @Immutable Object immutableField = getReadOnly(); // BAD
  }
  
  public static class immutableField_immutableReturn {
    private @Immutable Object immutableField = getImmutable(); // GOOD
  }
  
  public static class immutableField_valueReturn {
    private @Immutable Object immutableField = getValue(); // GOOD
  }
  
  public static class immutableField_sharedReturn {
    private @Immutable Object immutableField = getShared(); // BAD
  }
  
  public static class immutableField_uniqueWriteReturn {
    private @Immutable Object immutableField = getUniqueWrite(); // GOOD
  }
  
  public static class immutableField_uniqueReturn {
    private @Immutable Object immutableField = getUnique(); // GOOD
  }
  
  // Shared field
  
  // Cannot have a borrowed return value
  
  public static class sharedField_readOnlyReturn {
    private Object sharedField = getReadOnly(); // BAD
  }
  
  public static class sharedField_immutableReturn {
    private Object sharedField = getImmutable(); // BAD
  }
  
  public static class sharedField_valueReturn {
    private Object sharedField = getValue(); // GOOD
  }
  
  public static class sharedField_sharedReturn {
    private Object sharedField = getShared(); // GOOD
  }
  
  public static class sharedField_uniqueWriteReturn {
    private Object sharedField = getUniqueWrite(); // GOOD
  }
  
  public static class sharedField_uniqueReturn {
    private Object sharedField = getUnique(); // GOOD
  }
  
  
  
  // ***** Assignment from fields
  
  // ReadOnly field
  
  public static class readOnlyField_borrowedField {
    private final @Borrowed Object borrowedField2 = null;
    
    private @ReadOnly Object readOnlyField = borrowedField2; // GOOD: Borrowed field reads as unique
    // BAD: borrowed field is compromised however
  }
  
  public static class readOnlyField_readOnlyField {
    private @ReadOnly Object readOnlyField2;
    
    private @ReadOnly Object readOnlyField = readOnlyField2; // GOOD
  }
  
  public static class readOnlyField_immutableField {
    private @Immutable Object immutableField2;
    
    private @ReadOnly Object readOnlyField = immutableField2; // GOOD
  }
  
  public static class readOnlyField_valueField {
    private Value valueField2 = null;
    
    private @ReadOnly Object readOnlyField = valueField2; // GOOD
  }
  
  public static class readOnlyField_sharedField {
    private Object sharedField2 = null;
    
    private @ReadOnly Object readOnlyField = sharedField2; // GOOD
  }
  
  public static class readOnlyField_uniqueWriteField {
    private @Unique(allowRead=true) Object uniqueWriteField2;
    
    private @ReadOnly Object readOnlyField = uniqueWriteField2; // GOOD
    // BAD: unique write field is compromised however
  }
  
  public static class readOnlyField_uniqueField {
    private @Unique Object uniqueField2 = null;
    
    private @ReadOnly Object readOnlyField = uniqueField2; // GOOD
    // BAD: unique field is compromised however
  }

  // Immutable field
  
  public static class immutableField_borrowedField {
    private final @Borrowed Object borrowedField2 = null;
    
    private @Immutable Object immutableField = borrowedField2; // GOOD: Borrowed field reads as unique
    // BAD: borrowed field is compromised however
  }
  
  public static class immutableField_readOnlyField {
    private @ReadOnly Object readOnlyField2;
    
    private @Immutable Object immutableField = readOnlyField2; // BAD
  }
  
  public static class immutableField_immutableField {
    private @Immutable Object immutableField2;
    
    private @Immutable Object immutableField = immutableField2; // GOOD
  }
  
  public static class immutableField_valueField {
    private Value valueField2 = null;
    
    private @Immutable Object immutableField = valueField2; // GOOD
  }
  
  public static class immutableField_sharedField {
    private Object sharedField2 = null;
    
    private @Immutable Object immutableField = sharedField2; // BAD
  }
  
  public static class immutableField_uniqueWriteField {
    private @Unique(allowRead=true) Object uniqueWriteField2;
    
    private @Immutable Object immutableField = uniqueWriteField2; // GOOD
    // BAD: unique write field is compromised however
  }
  
  public static class immutableField_uniqueField {
    private @Unique Object uniqueField2 = null;
    
    private @Immutable Object immutableField = uniqueField2; // GOOD
    // BAD: unique field is compromised however
  }  

  // Shared field
  
  public static class sharedField_borrowedField {
    private final @Borrowed Object borrowedField2 = null;
    
    private Object sharedField = borrowedField2; // GOOD: Borrowed field reads as unique
    // BAD: borrowed field is compromised however
  }
  
  public static class sharedField_readOnlyField {
    private @ReadOnly Object readOnlyField2;
    
    private Object sharedField = readOnlyField2; // BAD
  }
  
  public static class sharedField_immutableField {
    private @Immutable Object immutableField2;
    
    private Object sharedField = immutableField2; // BAD
  }
  
  public static class sharedField_valueField {
    private Value valueField2 = null;
    
    private Object sharedField = valueField2; // GOOD
  }
  
  public static class sharedField_sharedField {
    private Object sharedField2 = null;
    
    private Object sharedField = sharedField2; // GOOD
  }
  
  public static class sharedField_uniqueWriteField {
    private @Unique(allowRead=true) Object uniqueWriteField2;
    
    private Object sharedField = uniqueWriteField2; // GOOD
    // BAD: unique write field is compromised however
  }
  
  public static class sharedField_uniqueField {
    private @Unique Object uniqueField2 = null;
    
    private Object sharedField = uniqueField2; // GOOD
    // BAD: unique field is compromised however
  }
}


@Immutable
class Value {
}
