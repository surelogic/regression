package testHadoop.yarn;

public class HamletSpec {
	public interface _ {}

	public interface _Child extends _ {
		/**
		 * Finish the current element.
		 * @return the parent element
		 */
		_ _();
	}
	/*
	public interface _Head extends HeadMisc {
	}

	public interface _Body extends Block, _Script, _InsDel {
	}
	 */
	public interface _Html extends /*_Head, _Body,*/ _ {		
	}

	public interface HTML extends /*I18nAttrs,*/ _Html {
	}

	public interface Q extends Attrs, /*Inline,*/ _Child {

		/** URI for source document or msg
		 * @param uri the URI
		 * @return the current element builder
		 */
		//Q $cite(String uri);
	}
	
	public interface CoreAttrs {
		
	}
	
	public interface Attrs extends CoreAttrs/*, I18nAttrs, EventsAttrs*/ {
	}
}
