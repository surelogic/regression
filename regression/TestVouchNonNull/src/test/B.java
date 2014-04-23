package test;

import com.surelogic.Cast;
import com.surelogic.Initialized;
import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.RegionEffects;
import com.surelogic.Starts;
import com.surelogic.ThreadSafe;

@ThreadSafe
public class B {
  @NonNull
  private final A peer;
  
  @Nullable
  private final A peer2;
  
  @RegionEffects("none")
  @Starts("nothing")
  B(@Initialized(through="Object") A myPeer) {
    peer = Cast.toNonNull(myPeer);
    peer2 = Cast.toNullable(myPeer);
  }
}
