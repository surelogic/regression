package testGuava;

import java.util.concurrent.ConcurrentMap;

public abstract class GenericMapMaker<K0, V0> {
	public abstract <K extends K0, V extends V0> ConcurrentMap<K, V> makeMap();
}
