package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.surelogic.GuardedBy;
import com.surelogic.RequiresLock;
import com.surelogic.Unique;

public class Test {
  private Lock jucLock = new ReentrantLock();
  private ReadWriteLock rwLock = new ReentrantReadWriteLock();
  
  @GuardedBy("getLock()")
  private int x;
  
  @GuardedBy("getJUCLock()")
  private int y;
  
  @GuardedBy("getJUCRWLock()")
  private int z;
  
  public Object getLock() { return this; }
  public Lock getJUCLock() { return jucLock; }
  public ReadWriteLock getJUCRWLock() { return rwLock; }
  
  @Unique("return")
  public Test() {
    super();
  }
  
  public void doStuff() {
    synchronized (getLock()) {
      x = 1;
    }
    
    getJUCLock().lock();
    try {
      y = 2;
    } finally {
      getJUCLock().unlock();
    }
    
    getJUCRWLock().writeLock().lock();
    try {
      z = 2;
    } finally {
      getJUCRWLock().writeLock().unlock();
    }
    
    // mixed lock usage warnings:
    synchronized (getJUCLock()) {
      y = 10;
    }
    
    synchronized (getJUCRWLock()) {
      z = 20;
    }
  }
  
  public void doStuff2(Test other) {
    synchronized (other.getLock()) {
      other.x = 2;
    }
  }
  
  @RequiresLock("this.getLock()")
  public void doStuff3() {
    x = 3;
  }
  
  @RequiresLock("other.getLock()")
  public void doStuff4(Test other) {
    other.x = 4;
  }
}
