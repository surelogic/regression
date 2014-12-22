package test;

import com.surelogic.ThreadSafe;

@ThreadSafe
public class TestThreadSafe {
  private Other other;
  private MyEnum value; // do not propose to make this @Unique
  private MySingleton s; // do not propose to make this @Unique
}
