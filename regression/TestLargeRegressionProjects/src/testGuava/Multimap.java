package testGuava;

import java.util.Collection;
import java.util.Map;

public interface Multimap<K,V> {

	Map<K, Collection<V>> asMap();

}
