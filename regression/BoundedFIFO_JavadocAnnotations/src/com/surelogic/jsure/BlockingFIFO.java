package com.surelogic.jsure;

public class BlockingFIFO {
	private final BoundedFIFO fifo;;

	public BlockingFIFO(int size) {
		fifo = new BoundedFIFO(size);
	}

	public void put(LoggingEvent e) {
		synchronized (fifo) {
			while (fifo.isFull()) {
				try {
					fifo.wait();
				} catch (InterruptedException ie) {
					// ignore
				}
			}
			fifo.put(e);
			if (fifo.wasEmpty()) {
				fifo.notify();
			}
			fifo.put(e);
			fifo.put(e);
		}
	}

	public LoggingEvent get() {
		synchronized (fifo) {
			LoggingEvent e;
			while (fifo.length() == 0) {
				try {
					fifo.wait();
				} catch (InterruptedException ie) {
					// ignore
				}
			}
			e = fifo.get();
			if (fifo.wasFull()) {
				fifo.notify();
			}
			return e;
		}
	}

	public int length() {
		synchronized (fifo) {
			return fifo.length();
		}
	}
}
