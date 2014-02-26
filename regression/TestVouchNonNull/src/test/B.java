package test;

import com.surelogic.Initialized;
import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.RegionEffects;
import com.surelogic.Starts;
import com.surelogic.ThreadSafe;
import com.surelogic.Vouch;

@ThreadSafe
public class B {
  @NonNull
  private final A peer;
  
  @Nullable
  private final A peer2;
  
  @RegionEffects("none")
  @Starts("nothing")
  B(@Initialized(through="Object") A myPeer) {
    @Vouch("NonNull")
    final A cast = myPeer;
    peer = cast; // Okay, because "cast" is always NonNull
    
    @Vouch("Nullable")
    final A cast2 = myPeer;
    peer2 = cast2; // Okay, becaues "cast2" is always Nullable
  }
}
