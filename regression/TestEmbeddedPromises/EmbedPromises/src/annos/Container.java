package annos;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Container {
	TestEnum testEnum();
	Class<?> cls();
	boolean b();
	char c();
	int i();
	float f();
	long l();
	short s();
	double d();
	byte by();
	TestEnum[] enums();
	OtherAnno[] annos();
	int[] prims();
}
