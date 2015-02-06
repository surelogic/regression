package test; import com.surelogic.*;

@TrackPartiallyInitialized enum E {
  A,
  B(10),
  C(20) { @NonNull private Object trigger; // force TPI on EnumClassDeclaration
    private boolean f = use(this);
    
    { 
      use(this);
    }
  };

  public static boolean use(final Object o) {return false;}

  private E() { use(this); }
  private E(int x) { use(this); }
}

