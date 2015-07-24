package testSweetHome3D;

import java.awt.Image;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Test<T> {
	public static List<Selectable> duplicate(List<? extends Selectable> items) {
		List<Selectable> list = new ArrayList<Selectable>();
		for (Selectable item : items) {
			list.add(item.clone());			
		}
		return list;
	}
	
	private final List<CollectionListener<T>> collectionListeners = null;
	
	/**
	 * Fires a collection event about <code>item</code> at a given <code>index</code>.
	 */
	/*
	@SuppressWarnings("unchecked")
	public void fireCollectionChanged(T item, int index, CollectionEvent.Type eventType) {
		if (!this.collectionListeners.isEmpty()) {
			CollectionEvent<T> furnitureEvent = 
					new CollectionEvent<T>(this.source, item, index, eventType);
			// Work on a copy of collectionListeners to ensure a listener 
			// can modify safely listeners list
			CollectionListener<T> [] listeners = this.collectionListeners.
					toArray(new CollectionListener [this.collectionListeners.size()]);
			for (CollectionListener<T> listener : listeners) {
				listener.collectionChanged(furnitureEvent);
			}
		}
	}
	*/
	@SuppressWarnings("unchecked")
	void copy() {
		CollectionListener<T> [] listeners = this.collectionListeners.
				toArray(new CollectionListener [this.collectionListeners.size()]);		
	}
	
	/*
      homeFrame.getClass().getMethod("setIconImages", List.class)
          .invoke(homeFrame, Arrays.asList(frameImages));	 
	 */
	void invoke() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Image [] frameImages = null;
		getClass().getMethod("setIconImages", List.class).invoke(this, Arrays.asList(frameImages));
	}
}
