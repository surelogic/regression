package structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.surelogic.AllowsReferencesFrom;

import example.A;

@AllowsReferencesFrom("FOO | UTIL")
public class Bar {

  private Set<String> mySet = new HashSet<String>();
  private ReadWriteLock badLock = new ReentrantReadWriteLock();

  public void good() {
    Foo.good();
    Foo.bad();
    List<Foo> l = new ArrayList<Foo>();
    StringBuilder b = new StringBuilder();
  }

  public void bad() {
    new A();
    ReadWriteLock l = new ReentrantReadWriteLock();
  }

}
