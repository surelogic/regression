package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;

public class Test {
  public static int needsNonNull(@NonNull Object o) {
    return -1;
  }
  
  public int test2(Object o) {
    return o != null ? needsNonNull(o) : 0;
  }
  
  public static Other sss = null;
  
  @NonNull
  public Other getOther() {
    return new Other();
  }

  @NonNull
  public Object testIt(Object o) {
    return o != null ? o : "x";
  }

  @NonNull
  public Other test4(@Nullable Other o) {
    return o != null ? o : getOther();
  }

  @NonNull
  public Other test4x(@Nullable Other o) {
    return o != null ? Test.sss : getOther();
  }

  @NonNull
  public Other test5(Other o) {
    if (o != null)
      return o;
    else 
      return getOther();
  }
}


class Other {
}