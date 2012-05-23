package opCheckTopState.viaOpConsume.viaOpCompromise.viaTransferNestedClassUse2;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

/* Check opCheckTopState when called by opConsume via opCompromise via 
 * transferNestedClassUse.  Being called by opCompromise, means the reference is 
 * going to be force to be SHARED.  This use from transferNestedClassUse 
 * compromises the receiver of the method that contains the nested class use
 * if the nested class refers to any external variables.
 */
@SuppressWarnings("unused")
public class Test {
  @RegionEffects("none")
  public static void harmless(final @Borrowed Object p) {
    // do nothing
  }
  
  
  
  @Borrowed("this")
  public void borrowedReceiver(final Object p) {
    final Object external = p;
    
    new Object() { // BAD
      public void doStuff() {
        harmless(external);
      }
    };
  }
  
  @ReadOnly("this")
  public void readOnlyReceiver(final Object p) {
    final Object external = p;
    
    new Object() { // BAD
      public void doStuff() {
        harmless(external);
      }
    };
  }
  
  @Immutable("this")
  public void immutableReceiver(final Object p) {
    final Object external = p;
    
    new Object() { // BAD
      public void doStuff() {
        harmless(external);
      }
    };
  }
  
  public void sharedReceiver(final Object p) {
    final Object external = p;
    
    new Object() { // GOOD
      public void doStuff() {
        harmless(external);
      }
    };
  }
  
  @Unique(value="this", allowRead=true)
  public void uniqueWriteReceiver(final Object p) {
    final Object external = p;
    
    new Object() { // GOOD
      public void doStuff() {
        harmless(external);
      }
    };
  }
  
  @Unique("this")
  public void uniqueReceiver(final Object p) {
    final Object external = p;
    
    new Object() { // GOOD
      public void doStuff() {
        harmless(external);
      }
    };
  }
}
