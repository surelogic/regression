package test;

import java.util.List;import com.surelogic.TrackPartiallyInitialized;

@TrackPartiallyInitialized class Super<T> {
  public Super() {
    super();
  }
  
  public static void use(final Object o) {}
}

@TrackPartiallyInitialized class Other extends Super<List<String>> {
  public Other() {
    super();
    use(this);
  }
}

@TrackPartiallyInitialized public class TestTypeParams extends Super<String> {
  public TestTypeParams() {
    super();
    use(this);
  }
}
