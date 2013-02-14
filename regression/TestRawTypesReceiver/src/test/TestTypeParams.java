package test;

import java.util.List;

class Super<T> {
  public Super() {
    super();
  }
  
  public static void use(final Object o) {}
}

class Other extends Super<List<String>> {
  public Other() {
    super();
    use(this);
  }
}

public class TestTypeParams extends Super<String> {
  public TestTypeParams() {
    super();
    use(this);
  }
}
