package testGuava;

import java.util.*;

public final class ImmutableClassToInstanceMap<B> extends AbstractMap<Class<? extends B>, B> implements ClassToInstanceMap<B> {
	// extends ForwardingMap<Class<? extends B>, B> 
	public static final class Builder<B> {
	    public <T extends B> Builder<B> putAll(
	            Map<? extends Class<? extends T>, ? extends T> map) {
	    	return null;
	    }
	    
	    public ImmutableClassToInstanceMap<B> build() {
	    	return null;
	    }
	}

	public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(
			Map<? extends Class<? extends S>, ? extends S> map) {
		if (map instanceof ImmutableClassToInstanceMap) {
			@SuppressWarnings("unchecked") // covariant casts safe (unmodifiable)
			// Eclipse won't compile if we cast to the parameterized type.
			ImmutableClassToInstanceMap<B> cast = (ImmutableClassToInstanceMap) map;
			return cast;
		}
		return new Builder<B>().putAll(map).build();
	}

	@Override
	public Set<java.util.Map.Entry<Class<? extends B>, B>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}
