@TypeSets({
	@TypeSet("UTIL= java.util & !(java.util.{Enumeration, Hashtable, Vector})"),
	@TypeSet("XML = org.jdom+ | UTIL | java.{io,net}")
})
@Layers({
	@Layer("MODEL       may refer to UTIL"),
	@Layer("PERSISTENCE may refer to MODEL | XML"),
	@Layer("CONTROLLER  may refer to UTIL | MODEL | PERSISTENCE | java.io.File")
})
package testLayers;

import com.surelogic.*;