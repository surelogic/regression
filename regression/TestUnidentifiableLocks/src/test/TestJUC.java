package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.surelogic.RegionLock;
import com.surelogic.RegionLocks;

class TestJUC {
	public final Lock lockField = new ReentrantLock();
	public final ReadWriteLock rwField = new ReentrantReadWriteLock();

	public static final Lock staticLockField = new ReentrantLock();
	public static final ReadWriteLock staticRwField = new ReentrantReadWriteLock();

	public void doStuff() {
		lockField.lock();
		try {
			// do stuff
		} finally {
			lockField.unlock();
		}

		staticLockField.lock();
		try {
			// do stuff
		} finally {
			staticLockField.unlock();
		}

		rwField.readLock().lock();
		try {
			// do stuff
		} finally {
			rwField.readLock().unlock();
		}

		rwField.writeLock().lock();
		try {
			// do stuff
		} finally {
			rwField.writeLock().unlock();
		}

		staticRwField.readLock().lock();
		try {
			// do stuff
		} finally {
			staticRwField.readLock().unlock();
		}

		staticRwField.writeLock().lock();
		try {
			// do stuff
		} finally {
			staticRwField.writeLock().unlock();
		}
	}
}

@RegionLocks({
	@RegionLock("LOCK is lockField protects Instance"),
	@RegionLock("SLOCK is staticLockField protects Static")
})
class TestJUC2 {
	public final Lock lockField = new ReentrantLock();
	public static final Lock staticLockField = new ReentrantLock();

	public void doStuff() {
		lockField.lock();
		try {
			// do stuff
		} finally {
			lockField.unlock();
		}

		staticLockField.lock();
		try {
			// do stuff
		} finally {
			staticLockField.unlock();
		}
	}
}


@RegionLocks({
	@RegionLock("LOCK is rwField protects Instance"),
	@RegionLock("SLOCK is staticRwField protects Static")
})
class TestJUC3 {
	public final ReadWriteLock rwField = new ReentrantReadWriteLock();
	public static final ReadWriteLock staticRwField = new ReentrantReadWriteLock();

	public void doStuff() {
		rwField.readLock().lock();
		try {
			// do stuff
		} finally {
			rwField.readLock().unlock();
		}

		rwField.writeLock().lock();
		try {
			// do stuff
		} finally {
			rwField.writeLock().unlock();
		}

		staticRwField.readLock().lock();
		try {
			// do stuff
		} finally {
			staticRwField.readLock().unlock();
		}

		staticRwField.writeLock().lock();
		try {
			// do stuff
		} finally {
			staticRwField.writeLock().unlock();
		}
	}
}
