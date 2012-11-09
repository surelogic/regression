package containable.testStaticFieldsAndClasses;

import com.surelogic.Containable;
import com.surelogic.Unique;

@Containable
public class Empty {
  @Unique("return")
  public Empty() {}
}
