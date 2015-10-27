package testHadoop.yarn;

public class Hamlet extends HamletImpl implements HamletSpec._Html {
	public class HTML<T extends _> extends EImp<T> implements HamletSpec.HTML {
		
	}
	
	public class Q<T extends _> extends EImp<T> implements HamletSpec.Q {
		//@Override
		public Q<T> _(Object... lines) {
			return null;
		}
		
		//@Override
		public Q<T> q(String selector, String cdata) {
			return setSelector(q(), selector)._(cdata)._();
		}
		
	    //@Override
	    public Q<Q<T>> q() {
	      //closeAttrs();
	      //return q_(this, true);
	      return null;
	    }
	}
}
