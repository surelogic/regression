package testSpeso;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.stream.Collector.Characteristics;

public class SpesoCollectors {
	static final Characteristics[] CH_UNORDERED_ID = new Characteristics[] { UNORDERED, IDENTITY_FINISH };

	public static <T> Collector<T, List<T>, List<T>> toArrayList() {
		return Collector.of((Supplier<List<T>>) ArrayList::new, List::add,
				(left, right) -> { left.addAll(right); return left; },
				CH_UNORDERED_ID);
	}

	/*
	BiConsumer<List<String>, String> temp() {
		return List<String>::add;
	}
	*/
	
	public static interface IntCollector<A, R> {

		public Supplier<A> supplier();

		public ObjIntConsumer<A> accumulator();

		public BinaryOperator<A> combiner();

		public Function<A, R> finisher();

		public Set<Characteristics> characteristics();

		public static <A, R> IntCollector<A, R> of(Supplier<A> supplier,
				ObjIntConsumer<A> accumulator, BinaryOperator<A> combiner) {
			/*
			return new IntCollectorImpl<>(supplier, accumulator, combiner,
					castingIdentity(), Collections.emptySet());
					*/
			return null;
		}

	}

	public static IntCollector<TIntSet, TIntSet> TIntSetCollector =
			IntCollector.of((Supplier<TIntSet>) TIntHashSet::new, TIntSet::add,
					(left, right) -> { left.addAll(right);	return left; });
}
