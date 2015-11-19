package testSpeso;

import java.util.function.Function;

import testSpeso.SingletonIterator;

public final class SpesoFunctions {

	private SpesoFunctions() {
		// non instantiable
	}

	public static <T, R> Function<T, Iterable<R>> toIterable(Function<T, R> func) {
		return func
				.andThen(r -> (Iterable<R>) () -> new SingletonIterator<>(r));
	}

}
