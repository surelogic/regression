package vouch;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.surelogic.Immutable;
import com.surelogic.Vouch;

@Immutable
public final class EntityMgr {

	@Vouch("Immutable")
	private final Map<String, String> f_known;

	public EntityMgr(Map<String, String> defs) {
		Map<String, String> known = new HashMap<String, String>();

		// add defaults
		known.put("&lt;", "<");
		known.put("&gt;", ">");

		known.putAll(defs);

		f_known = Collections.unmodifiableMap(known);
	}

	public EntityMgr() {
		this(Collections.<String, String> emptyMap());
	}

	public String convertIfRecognized(String entity) {
		String value = f_known.get(entity);
		return value == null ? entity : value;
	}
}
