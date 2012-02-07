package com.surelogic.boyland;

public class Outer {
	int foo() {
		return 0;
	}
	
	class Middle {
		long bar() {
			return 0;
		}
		
		class Inner {
			float f = this.hashCode() + Outer.this.foo() + Middle.this.bar();
			
			Inner(int i, long l) {
				super();
			}
			Inner() {
				this(Outer.this.foo(), Middle.this.bar());
			}
			
			double baz() {
				return this.hashCode() + Outer.this.foo() + Middle.this.bar();
			}
		}
	}
}
