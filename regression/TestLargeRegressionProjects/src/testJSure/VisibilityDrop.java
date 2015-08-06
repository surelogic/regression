package testJSure;

public abstract class VisibilityDrop<T extends ModuleAnnotationNode> extends PromiseDrop<T> {
	VisibilityDrop(T a) {
	}

	protected static <T extends VisibilityDrop<? extends ModuleAnnotationNode>> T buildVisDrop(T res) {
		return null;	  
	}
}
