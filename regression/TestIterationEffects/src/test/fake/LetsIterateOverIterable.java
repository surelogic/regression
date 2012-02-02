package test.fake;

import java.util.Iterator;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

interface Iterable<E> {
  @RegionEffects("writes Instance")
  @Unique("return")
  @Borrowed(value="this", allowReturn=true)
  public Iterator<E> iterator();
}

public class LetsIterateOverIterable {
//  @RegionEffects("reads a:Instance")
//  public void forLoopSugar(final Iterable<Object> a) {
//    for (final Object o : a) {
//      // do stuff
//    }
//  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop(final Iterable<Object> a) {
    final Iterator<Object> i = a.iterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
    }
  }

  @RegionEffects("reads a:Instance")
  public void whileLoop2(final Iterable<Object> a) {
    final Iterator<Object> i;
    i = a.iterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
    }
  }

  @RegionEffects("reads a:Instance")
  public void forLoop(final Iterable<Object> a) {
    for (final Iterator<Object> i = a.iterator(); i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
    }
  }

  @RegionEffects("reads a:Instance")
  public void forLoop2(final Iterable<Object> a) {
    Iterator<Object> i;
    i = a.iterator();
    for (; i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
    }
  }



//  @RegionEffects("reads a:Instance")
//  public void forLoopSugar_writes(final Iterable<Object> a) {
//    for (final Object o : a) {
//      // do stuff
//      // cannot write, no ref to the iterator is available
//    }
//  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop_writes(final Iterable<Object> a) {
    final Iterator<Object> i = a.iterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }

  @RegionEffects("reads a:Instance")
  public void whileLoop2_writes(final Iterable<Object> a) {
    final Iterator<Object> i;
    i = a.iterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }

  @RegionEffects("reads a:Instance")
  public void forLoop_writes(final Iterable<Object> a) {
    for (final Iterator<Object> i = a.iterator(); i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }

  @RegionEffects("reads a:Instance")
  public void forLoop2_writes(final Iterable<Object> a) {
    Iterator<Object> i;
    i = a.iterator();
    for (; i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
}
