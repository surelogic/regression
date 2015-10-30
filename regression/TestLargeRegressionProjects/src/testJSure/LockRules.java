package testJSure;

public class LockRules {
	public static ImmutablePromiseDrop getImmutableType(final IRNode cdecl) {
		return null;
	}
	
	public static ThreadSafePromiseDrop getThreadSafeType(final IRNode cdecl) {
		return null;
	}
	
	public static ModifiedBooleanPromiseDrop<? extends AbstractModifiedBooleanNode> getThreadSafeTypePromise(final IRNode tdecl) {
		final ImmutablePromiseDrop immutable = getImmutableType(tdecl);
		// Breaks because of ValidatedDropCallback somehow
		return (immutable == null) ? getThreadSafeType(tdecl) : immutable;
	}
}
