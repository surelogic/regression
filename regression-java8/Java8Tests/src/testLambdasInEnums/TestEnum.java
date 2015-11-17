package testLambdasInEnums;

public enum TestEnum {
	TEST() {
		void foo() {
			Runnable r = () -> this.foo();
		}
	};
	
	Object o = new Object() {
		void bar() {
			Runnable r = () -> this.bar();
		}
		
		Object o2 = new Object() {
			void baz() {
				bar();
				o2 = null;				
			}
		};
	};
	

}
