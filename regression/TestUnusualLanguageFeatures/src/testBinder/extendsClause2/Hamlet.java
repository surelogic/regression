package testBinder.extendsClause2;

import java.io.PrintWriter;
import java.util.EnumSet;

import testBinder.extendsClause.SubView;
import testBinder.extendsClause.HtmlPage._;

public class Hamlet {

	public Hamlet(PrintWriter out, int i, boolean b) {
		// TODO Auto-generated constructor stub
	}

	public interface _ {

	}

	public class HTML<T> {

		public HTML(String string, Object object, EnumSet<?> of) {
			// TODO Auto-generated constructor stub
		}

		public HTML<T> meta_http(String string, String html) {
			// TODO Auto-generated method stub
			return null;
		}

		public HTML<T> title(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		public HTML<T> p(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		public HTML<T> _(String... s) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	protected Context context() {
		return null;
	}
	
	protected void subView(Class<? extends SubView> cls) {
		// TODO Auto-generated method stub
		
	}
	
	public int nestLevel() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected boolean wasInline() {
		return false;
	}
	
	protected void setWasInline(boolean v) {
		
	}
	
	protected void render(Class<?> c) {
		
	}
}
