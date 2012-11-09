package immutable.helpers;

import com.surelogic.Containable;
import com.surelogic.Unique;

@Containable
public class C {
  @Unique("return")
  public C() {}
}
