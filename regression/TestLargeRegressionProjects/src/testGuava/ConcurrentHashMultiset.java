package testGuava;

import java.io.Serializable;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public final class ConcurrentHashMultiset<E> /*extends AbstractMultiset<E>*/ implements Serializable {
	public static <E> ConcurrentHashMultiset<E> create(
			GenericMapMaker<? super E, ? super Number> mapMaker) {
		return new ConcurrentHashMultiset<E>(mapMaker.<E, AtomicInteger>makeMap());
	}
	
	ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> countMap) {
		
	}
}
