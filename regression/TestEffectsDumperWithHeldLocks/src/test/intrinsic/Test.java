package test.intrinsic;

import com.surelogic.Borrowed;
import com.surelogic.InRegion;
import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.RegionLocks;
import com.surelogic.Regions;
import com.surelogic.RequiresLock;


// this, class, O.class, instance field, super class instance field, static field, other static field

// protect inherited region, my region

@Regions({
  @Region("public ParentThisRegion"),
  
  @Region("public ParentFieldRegion"),
  
  @Region("public ParentFieldParentFieldRegion")
})
class Parent {
  public static final Object parentStaticLock = new Object();
  public final Object parentFieldLock = new Object();
}


@Regions({
  @Region("public ThisRegion"),
  
  @Region("public static StaticClassRegion"),
  
  @Region("public static OtherStaticClassRegion"),
  
  @Region("public FieldRegion"),
  
  @Region("public ParentFieldFieldRegion"),
  
  @Region("public static StaticFieldRegion"),
  
  @Region("public static OtherStaticFieldRegion1"),
  @Region("public static OtherStaticFieldRegion2")
})
@RegionLocks({
  @RegionLock("ParentThisLock is this protects ParentThisRegion"),
  @RegionLock("ThisLock is this protects ThisRegion"),
  
  @RegionLock("StaticClassLock is class protects StaticClassRegion"),
  
  @RegionLock("OtherStaticClassLock is test.intrinsic.Test.Other.class protects OtherStaticClassRegion"),
  
  @RegionLock("ParentFieldLock is fieldLock protects ParentFieldRegion"),
  @RegionLock("FieldLock is fieldLock protects FieldRegion"),
  
  @RegionLock("ParentFieldParentFieldLock is parentFieldLock protects ParentFieldParentFieldRegion"),
  @RegionLock("ParentFieldFieldLock is parentFieldLock protects ParentFieldFieldRegion"),
  
  @RegionLock("StaticFieldLock is staticFieldLock protects StaticFieldRegion"),
  
  @RegionLock("OtherStaticFieldLock1 is Parent.parentStaticLock protects OtherStaticFieldRegion1"),
  @RegionLock("OtherStaticFieldLock2 is test.intrinsic.Test.Other.otherStaticLock protects OtherStaticFieldRegion2")
})
public class Test extends Parent{
  public static final Object staticFieldLock = new Object();
  public final Object fieldLock = new Object();
  
  @InRegion("ParentThisRegion")
  private int parentThisField;
  
  @InRegion("ThisRegion")
  private int thisField;
  
  @InRegion("StaticClassRegion")
  private static int staticClassStaticField;
  
  @InRegion("StaticClassRegion")
  private int staticClassField;
  
  @InRegion("OtherStaticClassRegion")
  private static int staticOtherClassStaticField;
  
  @InRegion("OtherStaticClassRegion")
  private int staticOtherClassField;
  
  @InRegion("ParentFieldRegion")
  private int parentFieldField;
  
  @InRegion("FieldRegion")
  private int fieldField;
  
  @InRegion("ParentFieldParentFieldRegion")
  private int parentFieldParentField;
  
  @InRegion("ParentFieldFieldRegion")
  private int parentFieldField2;
  
  @InRegion("StaticFieldRegion")
  private static int staticFieldStaticField;
  
  @InRegion("StaticFieldRegion")
  private int staticFieldField;
  
  @InRegion("OtherStaticFieldRegion1")
  private static int otherStaticFieldStaticField1;
  
  @InRegion("OtherStaticFieldRegion1")
  private int otherStaticFieldField1;
  
  @InRegion("OtherStaticFieldRegion2")
  private static int otherStaticFieldStaticField2;
  
  @InRegion("OtherStaticFieldRegion2")
  private int otherStaticFieldField2;

  
  
  static {
    @SuppressWarnings("unused")
    int x;
    
    // protected
    staticClassStaticField = 0;
    x = staticClassStaticField;

    staticOtherClassStaticField = 0;
    x = staticOtherClassStaticField;
    
    staticFieldStaticField = 0;
    x = staticFieldStaticField;
    
    otherStaticFieldStaticField1 = 0;
    x = otherStaticFieldStaticField1;
    
    otherStaticFieldStaticField2 = 0;
    x = otherStaticFieldStaticField2;
  }
  
  
  
  public Test() {
    super();
  }
  
  
  
  // Single-threaded constructor
  @Borrowed("this")
  public Test(int v) {
    @SuppressWarnings("unused")
    int x;
    
    // protected
    parentThisField = 0;
    x = parentThisField;
    
    thisField = 0;
    x = thisField;
    
    staticClassField = 0;
    x = staticClassField;
    
    staticOtherClassField = 0;
    x = staticOtherClassField;
    
    parentFieldField = 0;
    x = parentFieldField;
    
    fieldField = 0;
    x = fieldField;
    
    parentFieldParentField = 0;
    x = parentFieldParentField;
    
    parentFieldField2 = 0;
    x = parentFieldField2;
    
    staticFieldField = 0;
    x = staticFieldField;
    
    otherStaticFieldField1 = 0;
    x = otherStaticFieldField1;
    
    otherStaticFieldField2 = 0;
    x = otherStaticFieldField2;
  }
  
  
  
  // NOT a single-thread constructor
  public Test(int u, int v) {
    @SuppressWarnings("unused")
    int x;
    
    // none of these are protected
    parentThisField = 0;
    x = parentThisField;
    
    thisField = 0;
    x = thisField;
    
    staticClassField = 0;
    x = staticClassField;
    
    staticOtherClassField = 0;
    x = staticOtherClassField;
    
    parentFieldField = 0;
    x = parentFieldField;
    
    fieldField = 0;
    x = fieldField;
    
    parentFieldParentField = 0;
    x = parentFieldParentField;
    
    parentFieldField2 = 0;
    x = parentFieldField2;
    
    staticFieldField = 0;
    x = staticFieldField;
    
    otherStaticFieldField1 = 0;
    x = otherStaticFieldField1;
    
    otherStaticFieldField2 = 0;
    x = otherStaticFieldField2;
  }

  
  
  public synchronized void synchronizedMethod() {
    @SuppressWarnings("unused")
    int x;
    
    // protected
    parentThisField = 0;
    x = parentThisField;
      
    thisField = 0;
    x = thisField;
  }
  
  
  
  @RequiresLock("ParentThisLock")
  public void requiresParentThisLock() {
    @SuppressWarnings("unused")
    int x;
    
    // protected
    parentThisField = 0;
    x = parentThisField;
    
    // not protected
    thisField = 0;
    x = thisField;
  }
  
  @RequiresLock("ThisLock")
  public void requiresThisLock() {
    @SuppressWarnings("unused")
    int x;
    
    // not protected
    parentThisField = 0;
    x = parentThisField;
    
    // protected
    thisField = 0;
    x = thisField;
  }
  

  
  @RequiresLock("ParentFieldLock")
  public void requiresParentFieldLock() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldField = 0; // good
    x = parentFieldField;
    
    fieldField = 0; // bad
    x = fieldField;
  }
  
  @RequiresLock("FieldLock")
  public void requiresFieldLock() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldField = 0; // bad
    x = parentFieldField;
    
    fieldField = 0; // good
    x = fieldField;
  }

  
  
  @RequiresLock("ParentFieldParentFieldLock")
  public void requiresParentFieldParentFieldLock() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldParentField = 0;
    x = parentFieldParentField;
    
    parentFieldField2 = 0;
    x = parentFieldField2;
  }
  
  @RequiresLock("ParentFieldFieldLock")
  public void requiresParentFieldFieldLock() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldParentField = 0;
    x = parentFieldParentField;
    
    parentFieldField2 = 0;
    x = parentFieldField2;
  }

  
  
  @RequiresLock("test.intrinsic.Test:StaticFieldLock")
  public void requiresStaticFieldLock() {
    @SuppressWarnings("unused")
    int x;
    
    staticFieldStaticField = 0;
    x = staticFieldStaticField;
    
    staticFieldField = 0;
    x = staticFieldField;
  }

  
  
  @RequiresLock("test.intrinsic.Test:OtherStaticFieldLock1")
  public void requiresOtherStaticFieldLock1() {
    @SuppressWarnings("unused")
    int x;
    
    otherStaticFieldStaticField1 = 0;
    x = otherStaticFieldStaticField1;
    
    otherStaticFieldField1 = 0;
    x = otherStaticFieldField1;
  }

  
  
  @RequiresLock("test.intrinsic.Test:OtherStaticFieldLock2")
  public void requiresOtherStaticFieldLock2() {
    @SuppressWarnings("unused")
    int x;
    
    otherStaticFieldStaticField2 = 0;
    x = otherStaticFieldStaticField2;
    
    otherStaticFieldField2 = 0;
    x = otherStaticFieldField2;
  }

  
  
  public static synchronized void synchronizedStaticMethod() {
    @SuppressWarnings("unused")
    int x;

    // protected
    staticClassStaticField = 0;
    x = staticClassStaticField;
  }
  
  @RequiresLock("StaticClassLock")
  public void requiresStaticClassLock() {
    @SuppressWarnings("unused")
    int x;

    // all protected
    staticClassStaticField = 0;
    x = staticClassStaticField;
    
    staticClassField = 0;
    x = staticClassField;    
  }

  
  
  @RequiresLock("OtherStaticClassLock")
  public void requiresOtherStaticClassLock() {
    @SuppressWarnings("unused")
    int x;

    // all protected
    staticOtherClassStaticField = 0;
    x = staticOtherClassStaticField;
    
    staticOtherClassField = 0;
    x = staticOtherClassField;
  }

  
  
  public void doStuff() {
    @SuppressWarnings("unused")
    int x;
    
    // protected
    synchronized (this) {
      parentThisField = 0;
      x = parentThisField;
      
      thisField = 0;
      x = thisField;
    }
    
    // not protected
    parentThisField = 0;
    x = parentThisField;
    
    thisField = 0;
    x = thisField;
    
    
    
    // protected
    synchronized (Test.class) {
      staticClassStaticField = 0;
      x = staticClassStaticField;
      
      staticClassField = 0;
      x = staticClassField;
    }
 
    // not protected
    staticClassStaticField = 0;
    x = staticClassStaticField;
    
    staticClassField = 0;
    x = staticClassField;
    
    
    
    // protected
    synchronized (Other.class) {
      staticOtherClassStaticField = 0;
      x = staticOtherClassStaticField;
      
      staticOtherClassField = 0;
      x = staticOtherClassField;
    }
    
    // not protected
    staticOtherClassStaticField = 0;
    x = staticOtherClassStaticField;
    
    staticOtherClassField = 0;
    x = staticOtherClassField;

    
    
    // protected
    synchronized (this.fieldLock) {
      parentFieldField = 0;
      x = parentFieldField;
      
      fieldField = 0;
      x = fieldField;
    }
    
    // not protected
    parentFieldField = 0;
    x = parentFieldField;
    
    fieldField = 0;
    x = fieldField;
    

    
    synchronized (this.parentFieldLock) {
      parentFieldParentField = 0;
      x = parentFieldParentField;
      
      parentFieldField2 = 0;
      x = parentFieldField2;
    }
    
    // not protected
    parentFieldParentField = 0;
    x = parentFieldParentField;
    
    parentFieldField2 = 0;
    x = parentFieldField2;

    
    
    // protected
    synchronized (Test.staticFieldLock) {
      staticFieldStaticField = 0;
      x = staticFieldStaticField;
      
      staticFieldField = 0;
      x = staticFieldField;
    }
    
    // not protected
    staticFieldStaticField = 0;
    x = staticFieldStaticField;
    
    staticFieldField = 0;
    x = staticFieldField;

    
    
    // protected
    synchronized (Parent.parentStaticLock) {
      otherStaticFieldStaticField1 = 0;
      x = otherStaticFieldStaticField1;
      
      otherStaticFieldField1 = 0;
      x = otherStaticFieldField1;
    }

    // not protected
    otherStaticFieldStaticField1 = 0;
    x = otherStaticFieldStaticField1;
    
    otherStaticFieldField1 = 0;
    x = otherStaticFieldField1;

    
    
    // protected
    synchronized (Other.otherStaticLock) {
      otherStaticFieldStaticField2 = 0;
      x = otherStaticFieldStaticField2;
      
      otherStaticFieldField2 = 0;
      x = otherStaticFieldField2;
    }
    
    // not protected
    otherStaticFieldStaticField2 = 0;
    x = otherStaticFieldStaticField2;
    
    otherStaticFieldField2 = 0;
    x = otherStaticFieldField2;
  }
  
  
  public void testRequiresLock() {
    final Test otherTest = new Test();
    
    synchronized (this) {
      requiresParentThisLock_implicitThis(otherTest);
    }
    // not protected
    requiresParentThisLock_implicitThis(otherTest);

    synchronized (this) {
      requiresParentThisLock_explicitThis(otherTest);
    }
    // not protected
    requiresParentThisLock_explicitThis(otherTest);
    
    synchronized (this) {
      requiresParentThisLock_qualifiedThis(otherTest);
    }
    // not protected 
    requiresParentThisLock_qualifiedThis(otherTest);
    
    synchronized (otherTest) {
      requiresParentThisLock_parameter(otherTest);
    }
    // not protected
    requiresParentThisLock_parameter(otherTest);

    
    
    synchronized (this) {
      requiresThisLock_implicitThis(otherTest);
    }
    // not protected
    requiresThisLock_implicitThis(otherTest);

    synchronized (this) {
      requiresThisLock_explicitThis(otherTest);
    }
    // not protected
    requiresThisLock_explicitThis(otherTest);

    synchronized (this) {
      requiresThisLock_qualifiedThis(otherTest);
    }
    // not protected
    requiresThisLock_qualifiedThis(otherTest);

    synchronized (otherTest) {
      requiresThisLock_parameter(otherTest);
    }
    // not protected
    requiresThisLock_parameter(otherTest);
    
    
    
    synchronized (Test.class) {
      requiresStaticClassLock_implicit();
    }
    // not protected
    requiresStaticClassLock_implicit();

    synchronized (Test.class) {
      requiresStaticClassLock_explicit();
    }
    // not protected
    requiresStaticClassLock_explicit();
    
    
    synchronized (Other.class) {
      requiresOtherStaticClassLock_implicit();
    }
    // not protected
    requiresOtherStaticClassLock_implicit();
    
    synchronized (Other.class) {
      requiresOtherStaticClassLock_explicit();
    }
    // not protected
    requiresOtherStaticClassLock_explicit();
    
    synchronized (Other.otherStaticLock) {
      requiresOtherLock();
    }
    // not protected
    requiresOtherLock();
    
    
    
    synchronized (this.fieldLock) {
      requiresParentFieldLock_receiver();
      requiresFieldLock_receiver();
    }
    // not protected
    requiresParentFieldLock_receiver();
    requiresFieldLock_receiver();
    
    synchronized (otherTest.fieldLock) {
      requiresParentFieldLock_param(otherTest);
      requiresFieldLock_param(otherTest);
    }
    // not protected
    requiresParentFieldLock_param(otherTest);
    requiresFieldLock_param(otherTest);
    
    
    
    synchronized (this.parentFieldLock) {
      requiresParentFieldParentFieldLock_receiver();
      requiresParentFieldFieldLock_receiver();
    }
    // not protected
    requiresParentFieldParentFieldLock_receiver();
    requiresParentFieldFieldLock_receiver();
    
    synchronized (otherTest.parentFieldLock) {
      requiresParentFieldParentFieldLock_param(otherTest);
      requiresParentFieldFieldLock_param(otherTest);
    }
    // not protected
    requiresParentFieldParentFieldLock_param(otherTest);
    requiresParentFieldFieldLock_param(otherTest);

    
    
    synchronized (Test.staticFieldLock) {
      requiresStaticFieldLock_go();
    }
    // not protected
    requiresStaticFieldLock_go();

    
    
    synchronized (Parent.parentStaticLock) {
      requiresOtherStaticFieldLock1_go();
    }
    // not protected
    requiresOtherStaticFieldLock1_go();

    
    
    synchronized (Other.otherStaticLock) {
      requiresOtherStaticFieldLock2_go();
    }
    // not protected
    requiresOtherStaticFieldLock2_go();
  }
  
  @RequiresLock("ParentThisLock")
  private void requiresParentThisLock_implicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("this:ParentThisLock")
  private void requiresParentThisLock_explicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("Test.this:ParentThisLock")
  private void requiresParentThisLock_qualifiedThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("other:ParentThisLock")
  private void requiresParentThisLock_parameter(Test other) {
    // do nothing
  }
  
  @RequiresLock("ThisLock")
  private void requiresThisLock_implicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("this:ThisLock")
  private void requiresThisLock_explicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("Test.this:ThisLock")
  private void requiresThisLock_qualifiedThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("other:ThisLock")
  private void requiresThisLock_parameter(Test other) {
    // do nothing
  }

  @RequiresLock("StaticClassLock")
  private void requiresStaticClassLock_implicit() {
    // do nothing
  }

  @RequiresLock("test.intrinsic.Test:StaticClassLock")
  private void requiresStaticClassLock_explicit() {
    // do nothing
  }

  @RequiresLock("OtherStaticClassLock")
  private void requiresOtherStaticClassLock_implicit() {
    // do nothing
  }

  @RequiresLock("test.intrinsic.Test:OtherStaticClassLock")
  private void requiresOtherStaticClassLock_explicit() {
    // do nothing
  }

  @RequiresLock("test.intrinsic.Test.Other:OtherLock")
  private void requiresOtherLock() {
    // do nothing
  }
  
  @RequiresLock("ParentFieldLock")
  private void requiresParentFieldLock_receiver() {
    // do nothing
  }
  
  @RequiresLock("other:ParentFieldLock")
  private void requiresParentFieldLock_param(Test other) {
    // do nothing
  }
  
  @RequiresLock("FieldLock")
  private void requiresFieldLock_receiver() {
    // do nothing
  }
  
  @RequiresLock("other:FieldLock")
  private void requiresFieldLock_param(Test other) {
    // do nothing
  }
  
  @RequiresLock("ParentFieldParentFieldLock")
  private void requiresParentFieldParentFieldLock_receiver() {
    // do nothing
  }
  
  @RequiresLock("other:ParentFieldParentFieldLock")
  private void requiresParentFieldParentFieldLock_param(Test other) {
    // do nothing
  }
  
  @RequiresLock("ParentFieldFieldLock")
  private void requiresParentFieldFieldLock_receiver() {
    // do nothing
  }
  
  @RequiresLock("other:ParentFieldFieldLock")
  private void requiresParentFieldFieldLock_param(Test other) {
    // do nothing
  }
  
  @RequiresLock("test.intrinsic.Test:StaticFieldLock")
  private void requiresStaticFieldLock_go() {
    // do nothing
  }
  
  @RequiresLock("test.intrinsic.Test:OtherStaticFieldLock1")
  private void requiresOtherStaticFieldLock1_go() {
    // do nothing
  }
  
  @RequiresLock("test.intrinsic.Test:OtherStaticFieldLock2")
  private void requiresOtherStaticFieldLock2_go() {
    // do nothing
  }
  
  
  
  @RegionLock("OtherLock is class protects R")
  @Region("public static R")
  public static class Other {
    public static final Object otherStaticLock = new Object();
    // empty
    
    
    static {
      @SuppressWarnings("unused")
      int x;
      
      // protected
      Test.staticOtherClassStaticField = 0;
      x = staticOtherClassStaticField;
    }
    
    public static synchronized void staticSynchronizedMethod() {
      @SuppressWarnings("unused")
      int x;
      
      // protected
      Test.staticOtherClassStaticField = 0;
      x = staticOtherClassStaticField;
    }
  }
}
