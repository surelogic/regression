package testGuava;

import java.util.*;
import java.util.Map.Entry;

public class MapConstraints {
	private static class ConstrainedAsMapValues<K, V> extends /*ForwardingCollection*/ArrayList<Collection<V>> {
	    ConstrainedAsMapValues(Collection<Collection<V>> delegate,
	            Set<Entry<K, Collection<V>>> entrySet) {	    	
	    }
	}
	
	private static class ConstrainedMultimap<K, V> {
		final Multimap<K, V> delegate = null;
	    transient Map<K, Collection<V>> asMap;
		
		//@Override 
		public Map<K, Collection<V>> asMap() {
	        Map<K, Collection<V>> result = asMap;
	        if (result == null) {
	          final Map<K, Collection<V>> asMapDelegate = delegate.asMap();

	          asMap = result = new /*Forwarding*/HashMap<K, Collection<V>>() {
	            Set<Entry<K, Collection<V>>> entrySet;
	            Collection<Collection<V>> values;
		
	            protected Map<K, Collection<V>> delegate() {
	            	return null;
	            }
	            
	            //@Override 
	            public Set<Entry<K, Collection<V>>> entrySet() {
	            	return null;
	            }
	            
	            //@Override 
	            public Collection<Collection<V>> values() {
	            	Collection<Collection<V>> result = values;
	            	if (result == null) {
	            		values = result = new ConstrainedAsMapValues<K, V>(
	            				delegate().values(), entrySet());
	            	}
	            	return result;
	            }
	          };
	        }
	        return result;
		}
	}
}
