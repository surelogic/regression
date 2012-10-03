package com.surelogic.jsure;

/*
 * Copyright (C) The Apache Software Foundation. All rights reserved.
 *
 * This software is published under the terms of the Apache Software License
 * version 1.1, a copy of which has been included  with this distribution in
 * the LICENSE.txt file.
 *
 * Contributors:     Mathias Bogaert
 *                   joelr@viair.com
 *
 * Annotations by Aaron Greenhouse - Carnegie Mellon University
 */

/**
 * @annotate RegionLock("BufLock is this protects Instance")
 * @annotate Promise("@RequiresLock(BufLock) for *(**)")
 */
public class BoundedFIFO {
	private LoggingEvent[] buf;

	private int numElts = 0;
	private int first = 0;
	private int next = 0;
	private int size;

	/**
	 * @annotate 
	 * 
	 * 
	 * 
	 * Unique("return")
	 * @annotate Starts("nothing")
	 * 
	 * 
	 * 
	 * foo bar Junky {@link Object}.
	 * 
	 * @annotate RegionEffects("none")
	 * Instantiate a new BoundedFIFO with a maximum size passed as argument.
	 * 
	 * @param size
	 *            Maximum size of the BoundedFIFO created.
	 * 
	 */
	public BoundedFIFO(int size) {
		if (size < 1)
			throw new IllegalArgumentException();
		this.size = size;
		buf = new LoggingEvent[size];
	}

	/**
	 * @annotate
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Starts("nothing")
	 */
	void m1() {
		m2();
	}

	/**
	 * @annotate                                            Starts("nothing")
	 */
	void m2() {
		m1();
	}

	/**
	 * Get the first element in the buffer. Returns <code>null</code> if there
	 * are no elements in the buffer.
	 */
	public LoggingEvent get() {
		if (numElts == 0)
			return null;
		LoggingEvent r = buf[next];
		if (++first == size)
			first = 0;
		numElts--;
		return r;
	}

	/**
	 * Place a {@link LoggingEvent} in the buffer. If the buffer is full then
	 * the event is <b>silently dropped</b>. It is the caller's responsibility
	 * to make sure that the buffer has free space.
	 * 
	 * @param o
	 *            The logging event added into the buffer.
	 */
	public void put(LoggingEvent o) {
		if (numElts != size) {
			buf[next] = o;
			if (++next == size)
				next = 0;
			numElts++;
		}
	}

	/**
	 * Get the maximum size of the buffer.
	 */
	public int getMaxSize() {
		return size;
	}

	/**
	 * Get the number of elements in the buffer. This number is guaranteed to be
	 * in the range 0 to <code>maxSize</code> (inclusive).
	 */
	public int length() {
		return numElts;
	}

	/**
	 * Returns <code>true</code> if there is just one element in the buffer. In
	 * other words, if there were no elements before the last {@link #put}
	 * operation completed.
	 */
	public boolean wasEmpty() {
		return numElts == 1;
	}

	/**
	 * Returns <code>true</code> if the number of elements in the buffer plus 1
	 * equals the maximum buffer size, returns <code>false</code> otherwise.
	 */
	public boolean wasFull() {
		return numElts + 1 == size;
	}

	/**
	 * Returns <code>true</code> if the number of elements in the buffer equals
	 * the maximum buffer size, returns <code>false</code> otherwise.
	 */
	public boolean isFull() {
		return numElts == size;
	}
}
