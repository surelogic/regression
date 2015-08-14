package testGuava;

import java.util.*;
import java.util.concurrent.*;

public class Queues {
	public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(Iterable<? extends E> elements) {
		if (elements instanceof Collection) {
			return new LinkedBlockingQueue<E>(Collections2.cast(elements));
		}
		LinkedBlockingQueue<E> queue = new LinkedBlockingQueue<E>();
		Iterables.addAll(queue, elements);
		return queue;
	}
}
