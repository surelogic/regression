package test;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.surelogic.RegionEffects;

public class LetsIterateOverLists {
  @RegionEffects("reads a:Instance")
  public void forLoopSugar(final List<Object> a) {
    for (final Object o : a) {
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop(final List<Object> a) {
    final Iterator<Object> i = a.iterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop_li(final List<Object> a) {
    final Iterator<Object> i = a.listIterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop_li2(final List<Object> a) {
    final ListIterator<Object> i = a.listIterator(0);
    while (i.hasNext()) {
      final int idx = i.nextIndex();
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop_li3(final List<Object> a) {
    final ListIterator<Object> i = a.listIterator(0);
    while (i.hasPrevious()) {
      final int idx = i.previousIndex();
      final Object o = i.previous();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop2(final List<Object> a) {
    final Iterator<Object> i;
    i = a.iterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop2_li(final List<Object> a) {
    final Iterator<Object> i;
    i = a.listIterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop2_li2(final List<Object> a) {
    final ListIterator<Object> i;
    i = a.listIterator(0);
    while (i.hasNext()) {
      final int idx = i.nextIndex();
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop2_li3(final List<Object> a) {
    final ListIterator<Object> i;
    i = a.listIterator(0);
    while (i.hasPrevious()) {
      final int idx = i.previousIndex();
      final Object o = i.previous();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop(final List<Object> a) {
    for (final Iterator<Object> i = a.iterator(); i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop_li(final List<Object> a) {
    for (final Iterator<Object> i = a.listIterator(); i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop_li2(final List<Object> a) {
    for (final ListIterator<Object> i = a.listIterator(0); i.hasNext(); ) {
      final int idx = i.nextIndex();
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop_li3(final List<Object> a) {
    for (final ListIterator<Object> i = a.listIterator(0); i.hasPrevious(); ) {
      final int idx = i.previousIndex();
      final Object o = i.previous();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop2(final List<Object> a) {
    Iterator<Object> i;
    i = a.iterator();
    for (; i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop2_li(final List<Object> a) {
    Iterator<Object> i;
    i = a.listIterator();
    for (; i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop2_li2(final List<Object> a) {
    ListIterator<Object> i;
    i = a.listIterator(0);
    for (; i.hasNext(); ) {
      final int idx = i.nextIndex();
      final Object o = i.next();
      // do stuff
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop2_li3(final List<Object> a) {
    ListIterator<Object> i;
    i = a.listIterator(0);
    for (; i.hasPrevious(); ) {
      final int idx = i.previousIndex();
      final Object o = i.previous();
      // do stuff
    }
  }



  @RegionEffects("reads a:Instance")
  public void forLoopSugar_writes(final List<Object> a) {
    for (final Object o : a) {
      // do stuff
      // cannot write, no ref to the iterator is available
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop_writes(final List<Object> a) {
    final Iterator<Object> i = a.iterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop_writes_li(final List<Object> a) {
    final Iterator<Object> i = a.listIterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop_writes_li2(final List<Object> a) {
    final ListIterator<Object> i = a.listIterator(0);
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
      i.add(null);
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop_writes_li3(final List<Object> a) {
    final ListIterator<Object> i = a.listIterator(0);
    while (i.hasPrevious()) {
      final Object o = i.previous();
      // do stuff
      i.set(null);
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop2_writes(final List<Object> a) {
    final Iterator<Object> i;
    i = a.iterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop2_writes_li(final List<Object> a) {
    final Iterator<Object> i;
    i = a.listIterator();
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop2_writes_li2(final List<Object> a) {
    final ListIterator<Object> i;
    i = a.listIterator(0);
    while (i.hasNext()) {
      final Object o = i.next();
      // do stuff
      i.add(null);
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void whileLoop2_writes_li3(final List<Object> a) {
    final ListIterator<Object> i;
    i = a.listIterator(0);
    while (i.hasPrevious()) {
      final Object o = i.previous();
      // do stuff
      i.set(null);
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop_writes(final List<Object> a) {
    for (final Iterator<Object> i = a.iterator(); i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop_writes_li(final List<Object> a) {
    for (final Iterator<Object> i = a.listIterator(); i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop_writes_li2(final List<Object> a) {
    for (final ListIterator<Object> i = a.listIterator(0); i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
      i.add(null);
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop_writes_li3(final List<Object> a) {
    for (final ListIterator<Object> i = a.listIterator(0); i.hasPrevious(); ) {
      final Object o = i.previous();
      // do stuff
      i.set(null);
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop2_writes(final List<Object> a) {
    Iterator<Object> i;
    i = a.iterator();
    for (; i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop2_writes_li(final List<Object> a) {
    Iterator<Object> i;
    i = a.listIterator();
    for (; i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
      i.remove();
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop2_writes_li2(final List<Object> a) {
    ListIterator<Object> i;
    i = a.listIterator(0);
    for (; i.hasNext(); ) {
      final Object o = i.next();
      // do stuff
      i.add(null);
    }
  }
  
  @RegionEffects("reads a:Instance")
  public void forLoop2_writes_li3(final List<Object> a) {
    ListIterator<Object> i;
    i = a.listIterator(0);
    for (; i.hasPrevious(); ) {
      final Object o = i.previous();
      // do stuff
      i.set(null);
    }
  }
}

