package edu.vuum.mocca.intrinsic;

import com.surelogic.RegionLock;
import com.surelogic.ThreadSafe;
import com.surelogic.Unique;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.AtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
@ThreadSafe
@RegionLock("SimpleAtomicLongLock is lock protects mValue")
class SimpleAtomicLong2 {
  /**
   * The value that's manipulated atomically via the methods.
   */
  private long mValue;

  /**
   * The ReentrantReadWriteLock used to serialize access to mValue.
   */
  private final Object lock = new Object();

  /**
   * Creates a new SimpleAtomicLong with the given initial value.
   */
  @Unique("return")
  public SimpleAtomicLong2(final long initialValue) {
    mValue = initialValue;
  }

  /**
   * @brief Gets the current value (properly synchronized)
   * 
   * @returns The current value
   */
  public long get() {
    final Object localLock = lock;
    final Object localLock2 = localLock;
    final Object localLock3 = localLock2;
    synchronized (localLock3) {
      return mValue;
    }
  }

  /**
   * @brief Atomically decrements by one the current value
   *
   * @returns the updated value
   */
  public long decrementAndGet() {
    final Object localLock = lock;
    synchronized (localLock) {
      return --mValue;
    }
  }

  /**
   * @brief Atomically increments by one the current value
   *
   * @returns the previous value
   */
  public long getAndIncrement() {
    final Object localLock = lock;
    synchronized (localLock) {
      return mValue++;
    }
  }

  /**
   * @brief Atomically decrements by one the current value
   *
   * @returns the previous value
   */
  public long getAndDecrement() {
    final Object localLock = new Object(); // bad, not a lock we know
    synchronized (localLock) {
      return mValue--;
    }
  }

  /**
   * @brief Atomically increments by one the current value
   *
   * @returns the updated value
   */
  public long incrementAndGet() {
    Object localLock = lock; // bad, not final
    synchronized (localLock) {
      return ++mValue;
    }
  }
}
