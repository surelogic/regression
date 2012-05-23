package opCheckTopState.viaOpStore.viaTransferInitializationOfField;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.Unique;

/* Check opCheckTopState() when called by opStore() via transferInitializationOfField().
 * This only happens when the field being initialized is @Unique or
 * @Unique(allowRead=true).
 */
@SuppressWarnings("unused")
public class Test {
  private @Unique(allowRead=true) Object uniqueWriteField = null;
  private @Unique Object uniqueField = null;

  private final @Borrowed Object borrowedField2 = null;
  private @ReadOnly Object readOnlyField2 = null;
  private @Immutable Object immutableField2 = null;
  private Value valueField2 = null;
  private Object sharedField2 = null;
  private @Unique(allowRead=true) Object uniqueWriteField2 = null;
  private @Unique Object uniqueField2 = null;

  
  
  // no way to return a borrowed value
  
  @ReadOnly("return")
  public static Object getReadOnly() { return null; }
  
  @Immutable("return")
  public static Object getImmutable() { return null; }
  
  // Return a value object
  public static Value getValue() { return null; }
  
  // Shared
  public static Object getShared() { return null; }
  
  @Unique(value="return", allowRead=true) 
  public static Object getUniqueWrite() { return null; }
  
  @Unique("return")
  public static Object getUnique() { return null; }
  
 
  
  // ***** Formal Parameters
  
  // UniqueWrite field
  
  public void uniqueWriteField_borrowedParameter(final @Borrowed Object p) {
    class C {
      private @Unique(allowRead=true) Object uniqueWriteField = p; // BAD
    }
  }
  
  public void uniqueWriteField_readOnlyParameter(final @ReadOnly Object p) {
    class C {
      private @Unique(allowRead=true) Object uniqueWriteField = p; // BAD
    }
  }
  
  public void uniqueWriteField_immutableParameter(final @Immutable Object p) {
    class C {
      private @Unique(allowRead=true) Object uniqueWriteField = p; // BAD
    }
  }
  
  public void uniqueWriteField_valueParameter(final Value p) {
    class C {
      private @Unique(allowRead=true) Object uniqueWriteField = p; // BAD
    }
  }
  
  public void uniqueWriteField_sharedParameter(final Object p) {
    class C {
      private @Unique(allowRead=true) Object uniqueWriteField = p; // BAD
    }
  }
  
  public void uniqueWriteField_uniqueWriteParameter(final @Unique(allowRead=true) Object p) {
    class C {
      private @Unique(allowRead=true) Object uniqueWriteField = p; // GOOD
    }
  }
  
  public void uniqueWriteField_uniqueParameter(final @Unique Object p) {
    class C {
      private @Unique(allowRead=true) Object uniqueWriteField = p; // GOOD
    }
  }
  
  // Unique field
  
  public void uniqueField_borrowedParameter(final @Borrowed Object p) {
    class C {
      private @Unique Object uniqueField = p; // BAD
    }
  }
  
  public void uniqueField_readOnlyParameter(final @ReadOnly Object p) {
    class C {
      private @Unique Object uniqueField = p; // BAD
    }
  }
  
  public void uniqueField_immutableParameter(final @Immutable Object p) {
    class C {
      private @Unique Object uniqueField = p; // BAD
    }
  }
  
  public void uniqueField_valueParameter(final Value p) {
    class C {
      private @Unique Object uniqueField = p; // BAD
    }
  }
  
  public void uniqueField_sharedParameter(final Object p) {
    class C {
      private @Unique Object uniqueField = p; // BAD
    }
  }
  
  public void uniqueField_uniqueWriteParameter(final @Unique(allowRead=true) Object p) {
    class C {
      private @Unique Object uniqueField = p; // BAD
    }
  }
  
  public void uniqueField_uniqueParameter(final @Unique Object p) {
    class C {
      private @Unique Object uniqueField = p; // GOOD
    }
  }
  
  

  // ***** Assignment from method return values
   
  // UniqueWrite field
  
  // Cannot have a borrowed return value
  
  public static class uniqueWriteField_readOnlyReturn {
    private @Unique(allowRead=true) Object uniqueWriteField = getReadOnly(); // BAD
  }
  
  public static class uniqueWriteField_immutableReturn {
    private @Unique(allowRead=true) Object uniqueWriteField = getImmutable(); // BAD
  }
  
  public static class uniqueWriteField_valueReturn {
    private @Unique(allowRead=true) Object uniqueWriteField = getValue(); // BAD
  }
  
  public static class uniqueWriteField_sharedReturn {
    private @Unique(allowRead=true) Object uniqueWriteField = getShared(); // BAD
  }
  
  public static class uniqueWriteField_uniqueWriteReturn {
    private @Unique(allowRead=true) Object uniqueWriteField = getUniqueWrite(); // GOOD
  }
  
  public static class uniqueWriteField_uniqueReturn {
    private @Unique(allowRead=true) Object uniqueWriteField = getUnique(); // GOOD
  }
  
  // Unique field
  
  // Cannot have a borrowed return value
  
  public static class uniqueField_readOnlyReturn {
    private @Unique Object uniqueField = getReadOnly(); // BAD
  }
  
  public static class uniqueField_immutableReturn {
    private @Unique Object uniqueField = getImmutable(); // BAD
  }
  
  public static class uniqueField_valueReturn {
    private @Unique Object uniqueField = getValue(); // BAD
  }
  
  public static class uniqueField_sharedReturn {
    private @Unique Object uniqueField = getShared(); // BAD
  }
  
  public static class uniqueField_uniqueWriteReturn {
    private @Unique Object uniqueField = getUniqueWrite(); // BAD
  }
  
  public static class uniqueField_uniqueReturn {
    private @Unique Object uniqueField = getUnique(); // GOOD
  }
  
  
  
  // ***** Assignment from fields

  // UniqueWrite field
  
  public static class uniqueWriteField_borrowedField {
    private final @Borrowed Object borrowedField2 = null;
    
    private @Unique(allowRead=true) Object uniqueWriteField = borrowedField2; // GOOD: Borrowed field reads as unique
    // BAD: borrowed field is compromised however
  }
  
  public static class uniqueWriteField_readOnlyField {
    private @ReadOnly Object readOnlyField2;
    
    private @Unique(allowRead=true) Object uniqueWriteField = readOnlyField2; // BAD
  }
  
  public static class uniqueWriteField_immutableField {
    private @Immutable Object immutableField2;
    
    private @Unique(allowRead=true) Object uniqueWriteField = immutableField2; // BAD
  }
  
  public static class uniqueWriteField_valueField {
    private Value valueField2 = null;
    
    private @Unique(allowRead=true) Object uniqueWriteField = valueField2; // BAD
  }
  
  public static class uniqueWriteField_sharedField {
    private Object sharedField2 = null;
    
    private @Unique(allowRead=true) Object uniqueWriteField = sharedField2; // BAD
  }
  
  public static class uniqueWriteField_uniqueWriteField {
    private @Unique(allowRead=true) Object uniqueWriteField2;
    
    private @Unique(allowRead=true) Object uniqueWriteField = uniqueWriteField2; // GOOD
    // BAD: unique write field is compromised however
  }
  
  public static class uniqueWriteField_uniqueField {
    private @Unique Object uniqueField2 = null;
    
    private @Unique(allowRead=true) Object uniqueWriteField = uniqueField2; // GOOD
    // BAD: unique field is compromised however
  }
  
  // Unique field
  
  public static class uniqueField_borrowedField {
    private final @Borrowed Object borrowedField2 = null;
    
    private @Unique Object uniqueField = borrowedField2; // GOOD: Borrowed field reads as unique
    // BAD: borrowed field is compromised however
  }
  
  public static class uniqueField_readOnlyField {
    private @ReadOnly Object readOnlyField2;
    
    private @Unique Object uniqueField = readOnlyField2; // BAD
  }
  
  public static class uniqueField_immutableField {
    private @Immutable Object immutableField2;
    
    private @Unique Object uniqueField = immutableField2; // BAD
  }
  
  public static class uniqueField_valueField {
    private Value valueField2 = null;
    
    private @Unique Object uniqueField = valueField2; // BAD
  }
  
  public static class uniqueField_sharedField {
    private Object sharedField2 = null;
    
    private @Unique Object uniqueField = sharedField2; // BAD
  }
  
  public static class uniqueField_uniqueWriteField {
    private @Unique(allowRead=true) Object uniqueWriteField2;
    
    private @Unique Object uniqueField = uniqueWriteField2; // BAD (broken)
    // BAD: unique write field is compromised however
  }
  
  public static class uniqueField_uniqueField {
    private @Unique Object uniqueField2 = null;
    
    private @Unique Object uniqueField = uniqueField2; // GOOD
    // BAD: unique field is compromised however
  }
}

@Immutable
class Value {
}
