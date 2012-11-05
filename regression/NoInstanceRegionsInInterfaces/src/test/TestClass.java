package test;

import com.surelogic.Region;
import com.surelogic.Regions;

@Regions({
  @Region("public X"), // good
  @Region("public static S") // good
})
public class TestClass {
  // who cares
}
