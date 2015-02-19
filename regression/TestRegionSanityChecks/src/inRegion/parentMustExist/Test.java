package inRegion.parentMustExist;

import com.surelogic.InRegion;
import com.surelogic.Region;
import com.surelogic.Regions;

@Regions({
  @Region("LocalRegion"),
})
public class Test extends Super {
  @SuppressWarnings("unused")
  @InRegion("NoSuchRegion" /* is CONSISTENT */) // BAD: parent doesn't exist -- 2015-01-30 Now inferred!
  private int field1;
  
  @SuppressWarnings("unused")
  @InRegion("Instance" /* is CONSISTENT */) // GOOD: Instance exists (always)
  private int field2;
  
  @SuppressWarnings("unused")
  @InRegion("SuperRegion" /* is CONSISTENT */) // GOOD: Region from parent
  private int field3;
  
  @SuppressWarnings("unused")
  @InRegion("ChildRegion" /* is CONSISTENT */) // BAD: Region from child -- 2015-01-30 Now inferred!
  private int field4;
  
  @SuppressWarnings("unused")
  @InRegion("UnrelatedRegion" /* is CONSISTENT */) // BAD: Region from unrelated class -- 2015-01-30 Now inferred!
  private int field5;
  
  @SuppressWarnings("unused")
  @InRegion("LocalRegion" /* is CONSISTENT */) // Good: Region from same class
  private int field6;
}
