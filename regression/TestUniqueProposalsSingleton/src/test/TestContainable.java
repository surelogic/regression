package test;

import com.surelogic.Containable;

@Containable
public class TestContainable {
  private Other other;
  private MyEnum value; // do not propose to make this @Unique
  private MySingleton s; // do not propose to make this @Unique
}
