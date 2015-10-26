package testHadoop;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Configuration implements Iterable<Map.Entry<String,String>>,
Writable {

	@Override
	public Iterator<Entry<String, String>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Get the value of the <code>name</code> property as a <code>Class</code>
	 * implementing the interface specified by <code>xface</code>.
	 *   
	 * If no such property is specified, then <code>defaultValue</code> is 
	 * returned.
	 * 
	 * An exception is thrown if the returned class does not implement the named
	 * interface. 
	 * 
	 * @param name the class name.
	 * @param defaultValue default value.
	 * @param xface the interface implemented by the named class.
	 * @return property value as a <code>Class</code>, 
	 *         or <code>defaultValue</code>.
	 */
	public <U> Class<? extends U> getClass(String name, 
	//public <U> Class<? extends InputFormat> getClass(String name, 			
			Class<? extends U> defaultValue, 
			Class<U> xface) {
		return null;
	}
	
	public void set(String name, String value) {		
	}
}