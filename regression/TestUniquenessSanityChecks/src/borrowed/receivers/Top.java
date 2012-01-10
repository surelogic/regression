package borrowed.receivers;

import com.surelogic.Borrowed;

@Borrowed // bad
public class Top {

}


@Borrowed("this") // bad
class Top2 {
	
}

@Borrowed("X.this") // bad
class Top3 {
	
}

@Borrowed("this, X.this") // bad
class Top4 {
	
}

@Borrowed("q") // bad
class Top5 {
	
}