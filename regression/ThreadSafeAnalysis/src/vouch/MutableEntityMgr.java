package vouch;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.surelogic.ThreadSafe;
import com.surelogic.Vouch;

@ThreadSafe
public final class MutableEntityMgr {

	@Vouch("Immutable")
	private final Map<String, String> f_defaults;

	@Vouch("ThreadSafe")
	private final Map<String, String> f_additions;

	public MutableEntityMgr() {
		Map<String, String> known = new HashMap<String, String>();

		// add defaults
		known.put("&lt;", "<");
		known.put("&gt;", ">");

		f_defaults = Collections.unmodifiableMap(known);
		f_additions = Collections
				.synchronizedMap(new HashMap<String, String>());
	}

	public String convertIfRecognized(String entity) {
		String value = f_additions.get(entity);
		if (value == null)
			value = f_defaults.get(entity);
		return value == null ? entity : value;
	}
}
