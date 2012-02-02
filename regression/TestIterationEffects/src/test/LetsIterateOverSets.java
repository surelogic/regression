package test;

import java.util.Iterator;
import java.util.Set;

import com.surelogic.RegionEffects;

public class LetsIterateOverSets {
  @RegionEffects("reads a:Instance")
  public void forLoopSugar(final Set<Object> a) {
    for (final Object o : a) {
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop(final Set<Object> a) {
    final Iterator<Object> i = a.iterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop2(final Set<Object> a) {
    final Iterator<Object> i;
    i = a.iterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop(final Set<Object> a) {
    for (final Iterator<Object> i = a.iterator(); i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop2(final Set<Object> a) {
    Iterator<Object> i;
    i = a.iterator();
    for (; i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
    }
  }



  @RegionEffects("reads a:Instance")
  public void forLoopSugar_writes(final Set<Object> a) {
    for (final Object o : a) {
      // do stuff
      // cannot write, no ref to the iterator is available
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop_writes(final Set<Object> a) {
    final Iterator<Object> i = a.iterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop2_writes(final Set<Object> a) {
    final Iterator<Object> i;
    i = a.iterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop_writes(final Set<Object> a) {
    for (final Iterator<Object> i = a.iterator(); i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop2_writes(final Set<Object> a) {
    Iterator<Object> i;
    i = a.iterator();
    for (; i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
}

