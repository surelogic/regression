package edu.vuum.mocca;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

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
@RegionLock("SimpleAtomicLongLock is mRWLock protects mValue")
class SimpleAtomicLong
{
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;
    
    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */
    private final ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock();

    private final ReentrantReadWriteLock otherLock = new ReentrantReadWriteLock();

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
    @Unique("return")
    public SimpleAtomicLong(final long initialValue) {
        mValue = initialValue;
    }

    /**
     * @brief Gets the current value (properly synchronized)
     * 
     * @returns The current value
     */
    public long get() {
        final Lock lock = mRWLock.readLock();
        lock.lock();
        
        try {
            return mValue;
        } finally {
            lock.unlock();
        }
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
    public long decrementAndGet() {
        final Lock lock = mRWLock.writeLock();
        lock.lock();

        try {
            return --mValue;
        } finally {
            lock.unlock();
        }
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the previous value
     */
    public long getAndIncrement() {
        final Lock lock = mRWLock.writeLock();
        lock.lock();
        
        try {
            return mValue++;
        } finally {
            lock.unlock();
        }
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
    public long getAndDecrement() {
        final Lock lock = otherLock.writeLock(); // bad, unknown lock
        lock.lock();

        try {
            return mValue--;
        } finally {
            lock.unlock();
        }
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the updated value
     */
    public long incrementAndGet() {
        Lock lock = mRWLock.writeLock(); // bad, not final
        lock.lock();

        try {
            return ++mValue;
        } finally {
            lock.unlock();
        }
    }
}

