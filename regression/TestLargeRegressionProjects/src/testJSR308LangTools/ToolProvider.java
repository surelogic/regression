package testJSR308LangTools;

import java.lang.ref.Reference;

public class ToolProvider {
    private <T> T getSystemTool(Class<T> clazz, String name) {
        Class<? extends T> c = getSystemToolClass(clazz, name);
        try {
            return c.asSubclass(clazz).newInstance();
        } catch (Throwable e) {
        	//trace(WARNING, e);
            return null;
        }
    }
	
    private <T> Class<? extends T> getSystemToolClass(Class<T> clazz, String name) {
    	Reference<Class<?>> refClass = null;//toolClasses.get(name);
        Class<?> c = (refClass == null ? null : refClass.get());
        /*
        if (c == null) {
            try {
                c = findSystemToolClass(name);
            } catch (Throwable e) {
                return trace(WARNING, e);
            }
            toolClasses.put(name, new WeakReference<Class<?>>(c));
        }
        */
        return c.asSubclass(clazz);
    }
}
