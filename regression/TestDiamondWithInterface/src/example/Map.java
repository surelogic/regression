package example;

import java.util.ArrayList;
import java.util.List;

import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.ThreadSafe;
import com.surelogic.UniqueInRegion;

@ThreadSafe
@RegionLock("L is this protects Stuff")
@Region("Stuff")
public class Map {
  /*
   * In both cases below, ArrayList<> should be inferred to be ArrayList<String>.
   * This type is Containable because String is Immutable.  Previously, this
   * didn't work correctly for the second case, where the declared type is List<String>.
   * The problem was the analysis depends on the concrete type of the new expression, and
   * the the analysis was trying to use the syntactic type "ArrayList<>" for the
   * check, but this failed because it has no type actuals.  I changed the analysis 
   * on 20 May 2015 use the inferred IJavaType instead.  This fixed the problem. 
   */
  
  @UniqueInRegion("Stuff")
  final ArrayList<String> labels = new ArrayList<>();
  
  @UniqueInRegion("Stuff")
  final List<String> labelsG = new ArrayList<>();
}
