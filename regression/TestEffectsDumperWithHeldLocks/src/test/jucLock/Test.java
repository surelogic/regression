package test.jucLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
  @Region("public ParentFieldRegion"),
  
  @Region("public ParentFieldParentFieldRegion")
})
class Parent {
  public static final Lock parentStaticLock = new ReentrantLock();
  public final Lock parentFieldLock = new ReentrantLock();
}


@Regions({
  @Region("public FieldRegion"),
  
  @Region("public ParentFieldFieldRegion"),
  
  @Region("public static StaticFieldRegion"),
  
  @Region("public static OtherStaticFieldRegion1"),
  @Region("public static OtherStaticFieldRegion2")
})
@RegionLocks({
  @RegionLock("ParentFieldLock is fieldLock protects ParentFieldRegion"),
  @RegionLock("FieldLock is fieldLock protects FieldRegion"),
  
  @RegionLock("ParentFieldParentFieldLock is parentFieldLock protects ParentFieldParentFieldRegion"),
  @RegionLock("ParentFieldFieldLock is parentFieldLock protects ParentFieldFieldRegion"),
  
  @RegionLock("StaticFieldLock is staticFieldLock protects StaticFieldRegion"),
  
  @RegionLock("OtherStaticFieldLock1 is Parent.parentStaticLock protects OtherStaticFieldRegion1"),
  @RegionLock("OtherStaticFieldLock2 is test.jucLock.Test.Other.otherStaticLock protects OtherStaticFieldRegion2")
})
public class Test extends Parent{
  public static final Lock staticFieldLock = new ReentrantLock();
  public final Lock fieldLock = new ReentrantLock();

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
    staticFieldStaticField = 0;
    x = staticFieldStaticField;
    
    // protected
    otherStaticFieldStaticField1 = 0;
    x = otherStaticFieldStaticField1;
    
    // protected
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
    
    // not protected
    parentFieldField = 0;
    x = parentFieldField;
    
    fieldField = 0;
    x = fieldField;
  }
  
  @RequiresLock("ParentFieldLock")
  public void requiresParentFieldLock_write() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldField = 0; // good
    x = parentFieldField; // good
    
    fieldField = 0; // bad
    x = fieldField; // bad
  }

  @RequiresLock("FieldLock")
  public void requiresFieldLock_write() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldField = 0; // bad
    x = parentFieldField; // bad
    
    fieldField = 0; // good
    x = fieldField; // good
  }

  
  
  @RequiresLock("ParentFieldParentFieldLock")
  public void requiresParentFieldParentFieldLock_write() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldParentField = 0; // good
    x = parentFieldParentField; // good
    
    parentFieldField2 = 0; // bad
    x = parentFieldField2; // bad
  }
  
  @RequiresLock("ParentFieldFieldLock")
  public void requiresParentFieldFieldLock_write() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldParentField = 0; // bad
    x = parentFieldParentField; // bad
    
    parentFieldField2 = 0; // good
    x = parentFieldField2; // good
  }

  
  
  @RequiresLock("test.jucLock.Test:StaticFieldLock")
  public void requiresStaticFieldLock_write() {
    @SuppressWarnings("unused")
    int x;
    
    staticFieldStaticField = 0; // good
    x = staticFieldStaticField; // good
    
    staticFieldField = 0; // good
    x = staticFieldField; // good
  }

  
  

  
  
  @RequiresLock("test.jucLock.Test:OtherStaticFieldLock1")
  public void requiresOtherStaticFieldLock1() {
    @SuppressWarnings("unused")
    int x;
    
    otherStaticFieldStaticField1 = 0; // good
    x = otherStaticFieldStaticField1; // good
    
    otherStaticFieldField1 = 0; // good
    x = otherStaticFieldField1; // good
  }

  
  
  @RequiresLock("test.jucLock.Test:OtherStaticFieldLock2")
  public void requiresOtherStaticFieldLock2_write() {
    @SuppressWarnings("unused")
    int x;
    
    otherStaticFieldStaticField2 = 0; // good
    x = otherStaticFieldStaticField2; // good
    
    otherStaticFieldField2 = 0; // good
    x = otherStaticFieldField2; // good
  }

  
  
  public static synchronized void synchronizedStaticMethod() {
    @SuppressWarnings("unused")
    int x;

    // not protected
    staticFieldStaticField = 0;
    x = staticFieldStaticField;
    
    // not protected
    otherStaticFieldStaticField1 = 0;
    x = otherStaticFieldStaticField1;
    
    // not protected
    otherStaticFieldStaticField2 = 0;
    x = otherStaticFieldStaticField2;
  }


  
  
  public void doStuff() {
    @SuppressWarnings("unused")
    int x;
    
    fieldLock.lock();
    try {
      parentFieldField = 0;
      x = parentFieldField;
      
      fieldField = 0;
      x = fieldField;
    } finally {
      fieldLock.unlock();
    }
    
    parentFieldField = 0;
    x = parentFieldField;
    
    fieldField = 0;
    x = fieldField;
    
    
    
    parentFieldLock.lock();
    try {
      parentFieldParentField = 0;
      x = parentFieldParentField;
      
      parentFieldField2 = 0;
      x = parentFieldField2;
    } finally {
      parentFieldLock.unlock();
    }
    
    parentFieldParentField = 0;
    x = parentFieldParentField;
    
    parentFieldField2 = 0;
    x = parentFieldField2;

    

    staticFieldLock.lock();
    try {
      staticFieldStaticField = 0;
      x = staticFieldStaticField;
      
      staticFieldField = 0;
      x = staticFieldField;
    } finally {
      staticFieldLock.unlock();
    }
    
    staticFieldStaticField = 0;
    x = staticFieldStaticField;
    
    staticFieldField = 0;
    x = staticFieldField;
    
    
    
    Parent.parentStaticLock.lock();
    try {
      otherStaticFieldStaticField1 = 0;
      x = otherStaticFieldStaticField1;
      
      otherStaticFieldField1 = 0;
      x = otherStaticFieldField1;
    } finally {
      Parent.parentStaticLock.unlock();
    }
    
    otherStaticFieldStaticField1 = 0;
    x = otherStaticFieldStaticField1;
    
    otherStaticFieldField1 = 0;
    x = otherStaticFieldField1;
    

    
    Other.otherStaticLock.lock();
    try {
      otherStaticFieldStaticField2 = 0;
      x = otherStaticFieldStaticField2;
      
      otherStaticFieldField2 = 0;
      x = otherStaticFieldField2;
    } finally {
      Other.otherStaticLock.unlock();
    }
    
    otherStaticFieldStaticField2 = 0;
    x = otherStaticFieldStaticField2;
    
    otherStaticFieldField2 = 0;
    x = otherStaticFieldField2;
  }
  
  
  public void testRequiresLock() {
    final Test otherTest = new Test();
    
    fieldLock.lock();
    try {
      requiresParentFieldLock_write_implicitThis(otherTest);
      requiresParentFieldLock_write_explicitThis(otherTest);
      requiresParentFieldLock_write_qualifiedThis(otherTest);
      
      requiresFieldLock_write_implicitThis(otherTest);
      requiresFieldLock_write_explicitThis(otherTest);
      requiresFieldLock_write_qualifiedThis(otherTest);
    } finally {
      fieldLock.unlock();
    }
    
    requiresParentFieldLock_write_implicitThis(otherTest);
    requiresParentFieldLock_write_explicitThis(otherTest);
    requiresParentFieldLock_write_qualifiedThis(otherTest);
    
    requiresFieldLock_write_implicitThis(otherTest);
    requiresFieldLock_write_explicitThis(otherTest);
    requiresFieldLock_write_qualifiedThis(otherTest);

    
    
    otherTest.fieldLock.lock();
    try {
      requiresParentFieldLock_write_parameter(otherTest);
      
      requiresFieldLock_write_parameter(otherTest);
    } finally {
      otherTest.fieldLock.unlock();
    }
    
    requiresParentFieldLock_write_parameter(otherTest);
    
    requiresFieldLock_write_parameter(otherTest);

    
    
    parentFieldLock.lock();
    try {
      requiresParentFieldParentFieldLock_write_receiver();
      requiresParentFieldFieldLock_write_receiver();
    } finally {
      parentFieldLock.unlock();
    }

    // not protected
    requiresParentFieldParentFieldLock_write_receiver();
    requiresParentFieldFieldLock_write_receiver();

    
    
    otherTest.parentFieldLock.lock();
    try {
      requiresParentFieldParentFieldLock_write_param(otherTest);
      requiresParentFieldFieldLock_write_param(otherTest);
    } finally {
      otherTest.parentFieldLock.unlock();
    }

    // not protected
    requiresParentFieldParentFieldLock_write_param(otherTest);
    requiresParentFieldFieldLock_write_param(otherTest);

    
    
    staticFieldLock.lock();
    try {
      requiresStaticClassLock_write_implicit();
      requiresStaticClassLock_write_explicit();
    } finally {
      staticFieldLock.unlock();
    }

    requiresStaticClassLock_write_implicit();
    requiresStaticClassLock_write_explicit();

    
    
    Parent.parentStaticLock.lock();
    try {
      requiresOtherStaticFieldLock1_write_go();
    } finally {
      Parent.parentStaticLock.unlock();
    }
    
    requiresOtherStaticFieldLock1_write_go();

    
    
    Other.otherStaticLock.lock();
    try {
      requiresOtherStaticFieldLock2_write_go();
      
      requiresOtherStaticClassLock_write();
    } finally {
      Other.otherStaticLock.unlock();
    }
    
    requiresOtherStaticFieldLock2_write_go();
    
    requiresOtherStaticClassLock_write();
  }
  
  @RequiresLock("ParentFieldLock")
  private void requiresParentFieldLock_write_implicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("this:ParentFieldLock")
  private void requiresParentFieldLock_write_explicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("Test.this:ParentFieldLock")
  private void requiresParentFieldLock_write_qualifiedThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("other:ParentFieldLock")
  private void requiresParentFieldLock_write_parameter(Test other) {
    // do nothing
  }

  
  
  
  @RequiresLock("FieldLock")
  private void requiresFieldLock_write_implicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("this:FieldLock")
  private void requiresFieldLock_write_explicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("Test.this:FieldLock")
  private void requiresFieldLock_write_qualifiedThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("other:FieldLock")
  private void requiresFieldLock_write_parameter(Test other) {
    // do nothing
  }

  
  
  
  @RequiresLock("ParentFieldParentFieldLock")
  private void requiresParentFieldParentFieldLock_write_receiver() {
    // do nothing
  }
  
  @RequiresLock("other:ParentFieldParentFieldLock")
  private void requiresParentFieldParentFieldLock_write_param(Test other) {
    // do nothing
  }
  
  @RequiresLock("ParentFieldFieldLock")
  private void requiresParentFieldFieldLock_write_receiver() {
    // do nothing
  }
  
  @RequiresLock("other:ParentFieldFieldLock")
  private void requiresParentFieldFieldLock_write_param(Test other) {
    // do nothing
  }

  
  
  @RequiresLock("StaticFieldLock")
  private void requiresStaticClassLock_write_implicit() {
    
  }

  @RequiresLock("test.jucLock.Test:StaticFieldLock")
  private void requiresStaticClassLock_write_explicit() {
    
  }

  @RequiresLock("test.jucLock.Test:OtherStaticFieldLock1")
  private void requiresOtherStaticFieldLock1_write_go() {
    // do nothing
  }

  @RequiresLock("test.jucLock.Test:OtherStaticFieldLock2")
  private void requiresOtherStaticFieldLock2_write_go() {
    // do nothing
  }

  
  
  
  @RequiresLock("test.jucLock.Test.Other:OtherLock")
  private void requiresOtherStaticClassLock_write() {
    
  }
  
  
  
  @RegionLock("OtherLock is otherStaticLock protects R")
  @Region("public static R")
  public static class Other {
    public static final Lock otherStaticLock = new ReentrantLock();
    // empty
  }
}
