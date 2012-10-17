package valObject;

/* BAD: ValObject is @ValueObject and requires that the enumeration be too.
 * But annotating the enumeration as @ValueObject is illegal, so the implements
 * relationship is unresolvable.
 */
public enum Indirect implements ValObject, Other {
	A, B, C;
}
