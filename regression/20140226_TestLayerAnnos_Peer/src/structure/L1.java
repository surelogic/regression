package structure;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.surelogic.InLayer;

@InLayer("MODEL")
public class L1 {

  void good() {
    Set<Object> f = new HashSet<Object>();

    List<String> f1 = new ArrayList<String>();
  }

  void bad() {
	  Vector<Object> f = null;
	  ConcurrentHashMap<Object, Set<Vector<Vector<ArrayList<CountDownLatch>>>>> fe = null;
	  Set<Vector<Vector<Object>>> l = null;
	  Class<Set<Vector<Vector<Object>>>> jj = null;
  }

}
