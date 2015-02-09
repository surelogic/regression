package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.ThreadSafe;
import com.surelogic.TrackPartiallyInitialized;

public class TestEnumClassDeclaration {
  public static final void main(String[] args) {
    System.out.println(E.B_bad);
    System.out.println(E.B_good);
  }
}



@ThreadSafe
interface Cheese {
  public void stink();
}


@ThreadSafe
@TrackPartiallyInitialized
enum E implements Cheese {
  A {
    @Override
    public void stink() {}
  },
  B_bad {
    { getF(); }
    
    private final int f = getF();
    
    @NonNull
    private final String x = getX();
    
    private int getF() {
      System.out.println(x);
      return 0;
    }
    
    @NonNull
    private String getX() { return "X"; }
    
    @Override
    public void stink() {}
  },
  B_good {
    { getF(); }
    
    private final int f = getF();
    
    @Nullable
    private final String x = getX();
    
    private int getF() {
      System.out.println(x);
      return 0;
    }
    
    private String getX() { return "X"; }
    
    @Override
    public void stink() {}
  },
  C {
    @Override
    public void stink() {}
  }
}
