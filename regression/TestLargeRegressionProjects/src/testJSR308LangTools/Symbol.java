package testJSR308LangTools;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.*;
import javax.lang.model.type.TypeMirror;

public abstract class Symbol implements Element {
	public Name name;
	
	public static class MethodSymbol extends Symbol implements ExecutableElement {

		@Override
		public TypeMirror asType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ElementKind getKind() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<? extends AnnotationMirror> getAnnotationMirrors() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Set<Modifier> getModifiers() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Element getEnclosingElement() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<? extends Element> getEnclosedElements() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <R, P> R accept(ElementVisitor<R, P> v, P p) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<? extends TypeParameterElement> getTypeParameters() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public TypeMirror getReturnType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<? extends VariableElement> getParameters() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isVarArgs() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public List<? extends TypeMirror> getThrownTypes() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public AnnotationValue getDefaultValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Name getSimpleName() {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
