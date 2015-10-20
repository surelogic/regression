package testHadoop.yarn;

public class HamletSpec {
	public interface _ {}
	
	public interface _Child extends _ {		
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
}
