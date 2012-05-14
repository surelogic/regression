package check.uniqueWrite;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

// Test getting results on the normal and abrupt paths -- no way to have error only on the normal path?
@SuppressWarnings("unused")
public class TestDifferentMessagesOnAbruptAndNormal {
  private @Unique(allowRead=true) Object u;
  private @Unique(allowRead=true) Object v;
  private @Unique(allowRead=true) Object w;
  
  
  
  @RegionEffects("none")
  private static void compromiseRef(final Object o) {
    // do nothing
  }

  // bad on both edges
  private void bad1() {
	compromiseRef(u);
  }
  
  // only bad on the abrupt edge
  private void bad2() {
	compromiseRef(u);
    u = new Object();
  }
}


