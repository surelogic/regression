package threadSafe;

import com.surelogic.ThreadSafe;

@ThreadSafe
public interface RealInterface {
  @ThreadSafe
  public interface NestedInterface {
    
  }
}
