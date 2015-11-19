package testSpeso.orgs;

import java.util.Collection;

public interface SetMultimap<T1, T2> {
	Collection<T2> get(T1 id);

}
