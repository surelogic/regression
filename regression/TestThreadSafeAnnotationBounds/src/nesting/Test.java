package nesting;

import com.surelogic.AnnotationBounds;
import com.surelogic.Containable;
import com.surelogic.Immutable;
import com.surelogic.ThreadSafe;
import com.surelogic.Unique;

@Immutable
@AnnotationBounds(immutable="A")
public class Test<A> {
	// immutable
	private final A f = null;
	
	@Containable
	@AnnotationBounds(containable="A")
	public class Inner1<A> {
		// containable
		@Unique
		private A f;
		
		@Unique("return")
		public Inner1() {}
		
		@ThreadSafe
		@AnnotationBounds(threadSafe="A")
		public class Inner2<A> {
			// threadsafe
			private final A f = null;
		}
	}
}
