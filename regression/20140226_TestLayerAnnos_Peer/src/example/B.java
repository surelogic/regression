package example;

import com.surelogic.*;

@ThreadSafe
public class B {

  @NonNull
  private final A peer;

  @Nullable
  private final A peer2;

  @AllowsReferencesFrom("A")
  @RegionEffects("none")
  @Starts("nothing")
  B(@Initialized(through = "Object") A myPeer) {
    @Vouch("NonNull")
    A cast = myPeer;
    peer = cast;
    @Vouch("Nullable")
    A cast2 = myPeer;
    peer2 = cast2;
  }

  void m1() {
    C.foo();
    C.foo();
    C.foo();
    C.foo();
    C.foo();
    C.foo();
    C.foo();
    C.foo2();
    C.foo2();
  }
}
