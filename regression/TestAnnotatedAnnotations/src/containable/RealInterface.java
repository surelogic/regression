package containable;

import com.surelogic.Containable;

@Containable
public interface RealInterface {
  @Containable
  public interface NestedInterface {
  }
}
