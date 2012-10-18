package refObject;

/* Should be good.  Enums are implicitly RefObject, so they should satisfy
 * the inheritance requirement of RefObject.
 */
public enum Indirect implements RefObject, Other {
	A, B, C;
}
