package testJSR308LangTools;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import testJSR308LangTools.Symbol.MethodSymbol;

public class AnnotationProxyMaker {
	//private final Attribute.Compound anno;
    private final Class<? extends Annotation> annoType = null;	
	
    private class ValueVisitor /*implements Attribute.Visitor*/ {
    	private MethodSymbol meth;      // annotation element being visited
        private Class<?> returnClass;   // return type of annotation element
        private Object value;           // value in "dynamic proxy return form"
    
        Object getValue(/*Attribute attr*/) {
            Method method;              // runtime method of annotation element
            try {
                method = annoType.getMethod(meth.name.toString());
            } catch (NoSuchMethodException e) {
                return null;
            }
            /*
            returnClass = method.getReturnType();
            attr.accept(this);
            if (!(value instanceof ExceptionProxy) &&
                !AnnotationType.invocationHandlerReturnType(returnClass)
                                                        .isInstance(value)) {
                typeMismatch(method, attr);
            }
            return value;
            */
            return null;
        }
        
        @SuppressWarnings({"unchecked", "rawtypes"})
        public void visitEnum(/*Attribute.Enum e*/) {
        	if (returnClass.isEnum()) {
        		String constName = null;//e.value.toString();
        		try {
        			value = Enum.valueOf((Class)returnClass, constName);
        		} catch (IllegalArgumentException ex) {
        			//value = new EnumConstantNotPresentExceptionProxy(
        			//		(Class<Enum<?>>) returnClass, constName);
        		}
        	} else {
        		value = null;   // indicates a type mismatch
        	}
        }
    }
}
