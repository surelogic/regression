package containable.helpers;

import com.surelogic.Containable;
import com.surelogic.Unique;

@Containable
public class Other {
  @Unique("return")
  public Other() {}
}