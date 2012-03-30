package test;

import com.surelogic.RegionLock;
import com.surelogic.Vouch;

@RegionLock("TickLock is this protects ticker")
public class Tricky {

 private volatile int ticker;

 public void tick() {
   synchronized (this) {
     ticker++;
   }
 }

 @Vouch("volatile field -- cheap read-write lock trick")
 public int getTick() {
   return ticker;
 }

}