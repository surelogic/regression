package test;

import com.surelogic.Singleton;

// do not propose to make this @Containable
@Singleton
final class MySingleton {
  public static final MySingleton INSTANCE = new MySingleton();
  private MySingleton() {}
}