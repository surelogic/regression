package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.surelogic.GuardedBy;
import com.surelogic.RequiresLock;
import com.surelogic.Unique;

public class TestStatic {
  private static Lock jucLock = new ReentrantLock();
  private static ReadWriteLock rwLock = new ReentrantReadWriteLock();
  
  @GuardedBy("getLock()")
  private static int x;
  
  @GuardedBy("getJUCLock()")
  private static int y;
  
  @GuardedBy("getJUCRWLock()")
  private static int z;
  
  public static Object getLock() { return Object.class; }
  public static Lock getJUCLock() { return jucLock; }
  public static ReadWriteLock getJUCRWLock() { return rwLock; }
  
  @Unique("return")
  public TestStatic() {
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
  
  public void doStuff2(TestStatic other) {
    synchronized (other.getLock()) {
      other.x = 2;
    }
  }
  
  @RequiresLock("TestStatic.getLock()")
  public void doStuff3() {
    x = 3;
  }
  
  @RequiresLock("TestStatic.getLock()")
  public void doStuff4(TestStatic other) {
    other.x = 4;
  }
}
