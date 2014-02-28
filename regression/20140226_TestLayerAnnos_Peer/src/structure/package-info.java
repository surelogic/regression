@com.surelogic.TypeSets({ @com.surelogic.TypeSet("BAR=Bar"), @com.surelogic.TypeSet("FOO=Foo"),
    @com.surelogic.TypeSet("UTIL = java.util & !(java.util.{Enumeration, Hashtable, Vector})") })
@com.surelogic.Layer("MODEL may refer to UTIL")
package structure;

