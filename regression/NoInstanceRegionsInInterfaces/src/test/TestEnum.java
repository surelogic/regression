package test;

import com.surelogic.Region;
import com.surelogic.Regions;

@Regions({
  @Region("public X"), // good
  @Region("public static S") // good
})
public enum TestEnum {
  A, B, C;
  // who cares
}
