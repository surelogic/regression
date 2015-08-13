package testJSR308LangTools;

import static testJSR308LangTools.ConstantPool.*;

public class ConstantWriter extends BasicWriter {
    protected void writeConstantPool(ConstantPool constant_pool) {
        ConstantPool.Visitor<Integer, Void> v = null;
        println("Constant pool:");
        indent(+1);
        int width = String.valueOf(constant_pool.size()).length() + 1;
        int cpx = 1;
        while (cpx < constant_pool.size()) {
            print(String.format("%" + width + "s", ("#" + cpx)));
            try {
                CPInfo cpInfo = null;//constant_pool.get(cpx);
                //print(String.format(" = %-18s ", cpTagName(cpInfo)));
                cpx += cpInfo.accept(v, null);
            } catch (Exception ex) {
                // should not happen
            }
        }
        indent(-1);
    }
}
