package testJSR308LangTools;

public class ConstantPool {
	public int size() {
		return 0;
	}
	
	public interface Visitor<R,P> {
		
	}
	
	public static abstract class CPInfo {
        public abstract <R,D> R accept(Visitor<R,D> visitor, D data);
	}
}
