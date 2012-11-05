package test;

import com.surelogic.Region;
import com.surelogic.Regions;

@Regions({
  @Region("public X"), // bad
  @Region("public static S") // good
})
public @interface TestAnnotation {
  // who cares
}
