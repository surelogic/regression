package testGuava;

import java.util.*;

public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>>
/*extends AbstractBiMap<K, V>*/ {
	public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V>
	create(Map<K, V> map) {
		EnumBiMap<K, V> bimap = create(inferKeyType(map), inferValueType(map));
		//bimap.putAll(map);
		return bimap;
	}

	public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V>
	create(Class<K> keyType, Class<V> valueType) {
		return null;
	}

	static <K extends Enum<K>> Class<K> inferKeyType(Map<K, ?> map) {
		return null;
	}

	private static <V extends Enum<V>> Class<V> inferValueType(Map<?, V> map) {
		return null;
	}
}
