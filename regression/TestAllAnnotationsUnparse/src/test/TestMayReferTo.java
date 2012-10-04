package test;

import java.io.File;
import java.util.*;
import com.surelogic.MayReferTo;

@MayReferTo("java.util | java.io.File")
public class TestMayReferTo {	
	File f;
	Collection<?> c;
}
