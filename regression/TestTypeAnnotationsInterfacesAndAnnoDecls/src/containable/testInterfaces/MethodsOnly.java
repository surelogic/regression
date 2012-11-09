package containable.testInterfaces;

import com.surelogic.Containable;

@Containable // modeling problem
public @interface MethodsOnly {
  public String m();
  public String n();
}
