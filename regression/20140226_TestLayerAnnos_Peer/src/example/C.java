package example;

import java.util.concurrent.atomic.AtomicReference;

import com.surelogic.AllowsReferencesFrom;
import com.surelogic.MayReferTo;

@AllowsReferencesFrom("B")
@MayReferTo("java.io")
public class C {

  static void foo() {
    System.out.println("foo()" + new AtomicReference<Object>().toString());
  }

  static void foo2() {
    System.out.println("foo2()");
  }

}
