package testSpring3_1_0M1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ObjectUtilsTests {
	public void testCaseInsensitiveValueOf() {
		assertThat(ObjectUtils.caseInsensitiveValueOf(Tropes.values(), "foo"), is(Tropes.FOO));
		/*
		assertThat(ObjectUtils.caseInsensitiveValueOf(Tropes.values(), "BAR"), is(Tropes.BAR));
		try {
			ObjectUtils.caseInsensitiveValueOf(Tropes.values(), "bogus");
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException ex) {
			assertThat(ex.getMessage(),
					is("constant [bogus] does not exist in enum type " +
					"org.springframework.util.ObjectUtilsTests$Tropes"));
		}
		*/
	}
	
	enum Tropes { FOO, BAR, baz };
}
