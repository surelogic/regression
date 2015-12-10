package test.read_write;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
  public static final ReadWriteLock parentStaticLock = new ReentrantReadWriteLock();
  public final ReadWriteLock parentFieldLock = new ReentrantReadWriteLock();
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
  @RegionLock("OtherStaticFieldLock2 is test.read_write.Test.Other.otherStaticLock protects OtherStaticFieldRegion2")
})
public class Test extends Parent{
  public static final ReadWriteLock staticFieldLock = new ReentrantReadWriteLock();
  public final ReadWriteLock fieldLock = new ReentrantReadWriteLock();

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
  
  @RequiresLock("ParentFieldLock.readLock()")
  public void requiresParentFieldLock_read() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldField = 0; // bad
    x = parentFieldField; // good
    
    fieldField = 0; // bad
    x = fieldField; // bad
  }
  
  @RequiresLock("ParentFieldLock.writeLock()")
  public void requiresParentFieldLock_write() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldField = 0; // good
    x = parentFieldField; // good
    
    fieldField = 0; // bad
    x = fieldField; // bad
  }
  
  @RequiresLock("FieldLock.readLock()")
  public void requiresFieldLock_read() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldField = 0; // bad
    x = parentFieldField; // bad
    
    fieldField = 0; // bad
    x = fieldField; // good
  }
  
  @RequiresLock("FieldLock.writeLock()")
  public void requiresFieldLock_write() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldField = 0; // bad
    x = parentFieldField; // bad
    
    fieldField = 0; // good
    x = fieldField; // good
  }

  
  
  @RequiresLock("ParentFieldParentFieldLock.readLock()")
  public void requiresParentFieldParentFieldLock_read() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldParentField = 0; // bad
    x = parentFieldParentField; // good
    
    parentFieldField2 = 0; // bad
    x = parentFieldField2; // bad
  }
  
  @RequiresLock("ParentFieldParentFieldLock.writeLock()")
  public void requiresParentFieldParentFieldLock_write() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldParentField = 0; // good
    x = parentFieldParentField; // good
    
    parentFieldField2 = 0; // bad
    x = parentFieldField2; // bad
  }
  
  @RequiresLock("ParentFieldFieldLock.readLock()")
  public void requiresParentFieldFieldLock_read() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldParentField = 0; // bad
    x = parentFieldParentField; // bad
    
    parentFieldField2 = 0; // bad
    x = parentFieldField2; // good
  }
  
  @RequiresLock("ParentFieldFieldLock.writeLock()")
  public void requiresParentFieldFieldLock_write() {
    @SuppressWarnings("unused")
    int x;
    
    parentFieldParentField = 0; // bad
    x = parentFieldParentField; // bad
    
    parentFieldField2 = 0; // good
    x = parentFieldField2; // good
  }

  
  
  @RequiresLock("test.read_write.Test:StaticFieldLock.readLock()")
  public void requiresStaticFieldLock_read() {
    @SuppressWarnings("unused")
    int x;
    
    staticFieldStaticField = 0; // bad
    x = staticFieldStaticField; // good
    
    staticFieldField = 0; // bad
    x = staticFieldField; // good
  }
  
  @RequiresLock("test.read_write.Test:StaticFieldLock.writeLock()")
  public void requiresStaticFieldLock_write() {
    @SuppressWarnings("unused")
    int x;
    
    staticFieldStaticField = 0; // good
    x = staticFieldStaticField; // good
    
    staticFieldField = 0; // good
    x = staticFieldField; // good
  }

  
  

  
  
  @RequiresLock("test.read_write.Test:OtherStaticFieldLock1.readLock()")
  public void requiresOtherStaticFieldLock1_read() {
    @SuppressWarnings("unused")
    int x;
    
    otherStaticFieldStaticField1 = 0; // bad
    x = otherStaticFieldStaticField1; // good
    
    otherStaticFieldField1 = 0; // bad
    x = otherStaticFieldField1; // good
  }
  
  @RequiresLock("test.read_write.Test:OtherStaticFieldLock1.writeLock()")
  public void requiresOtherStaticFieldLock1() {
    @SuppressWarnings("unused")
    int x;
    
    otherStaticFieldStaticField1 = 0; // good
    x = otherStaticFieldStaticField1; // good
    
    otherStaticFieldField1 = 0; // good
    x = otherStaticFieldField1; // good
  }

  
  
  @RequiresLock("test.read_write.Test:OtherStaticFieldLock2.readLock()")
  public void requiresOtherStaticFieldLock2_read() {
    @SuppressWarnings("unused")
    int x;
    
    otherStaticFieldStaticField2 = 0; // bad
    x = otherStaticFieldStaticField2; // good
    
    otherStaticFieldField2 = 0; // bad
    x = otherStaticFieldField2; // good
  }
  
  @RequiresLock("test.read_write.Test:OtherStaticFieldLock2.writeLock()")
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
    
    fieldLock.readLock().lock();
    try {
      parentFieldField = 0;
      x = parentFieldField;
      
      fieldField = 0;
      x = fieldField;
    } finally {
      fieldLock.readLock().unlock();
    }
    
    fieldLock.writeLock().lock();
    try {
      parentFieldField = 0;
      x = parentFieldField;
      
      fieldField = 0;
      x = fieldField;
    } finally {
      fieldLock.writeLock().unlock();
    }
    
    parentFieldField = 0;
    x = parentFieldField;
    
    fieldField = 0;
    x = fieldField;
    
    
    
    parentFieldLock.readLock().lock();
    try {
      parentFieldParentField = 0;
      x = parentFieldParentField;
      
      parentFieldField2 = 0;
      x = parentFieldField2;
    } finally {
      parentFieldLock.readLock().unlock();
    }
    
    parentFieldLock.writeLock().lock();
    try {
      parentFieldParentField = 0;
      x = parentFieldParentField;
      
      parentFieldField2 = 0;
      x = parentFieldField2;
    } finally {
      parentFieldLock.writeLock().unlock();
    }
    
    parentFieldParentField = 0;
    x = parentFieldParentField;
    
    parentFieldField2 = 0;
    x = parentFieldField2;

    
    staticFieldLock.readLock().lock();
    try {
      staticFieldStaticField = 0;
      x = staticFieldStaticField;
      
      staticFieldField = 0;
      x = staticFieldField;
    } finally {
      staticFieldLock.readLock().unlock();
    }
    
    staticFieldLock.writeLock().lock();
    try {
      staticFieldStaticField = 0;
      x = staticFieldStaticField;
      
      staticFieldField = 0;
      x = staticFieldField;
    } finally {
      staticFieldLock.writeLock().unlock();
    }
    
    staticFieldStaticField = 0;
    x = staticFieldStaticField;
    
    staticFieldField = 0;
    x = staticFieldField;
    
    
    
    Parent.parentStaticLock.readLock().lock();
    try {
      otherStaticFieldStaticField1 = 0;
      x = otherStaticFieldStaticField1;
      
      otherStaticFieldField1 = 0;
      x = otherStaticFieldField1;
    } finally {
      Parent.parentStaticLock.readLock().unlock();
    }
    
    Parent.parentStaticLock.writeLock().lock();
    try {
      otherStaticFieldStaticField1 = 0;
      x = otherStaticFieldStaticField1;
      
      otherStaticFieldField1 = 0;
      x = otherStaticFieldField1;
    } finally {
      Parent.parentStaticLock.writeLock().unlock();
    }
    
    otherStaticFieldStaticField1 = 0;
    x = otherStaticFieldStaticField1;
    
    otherStaticFieldField1 = 0;
    x = otherStaticFieldField1;
    

    
    Other.otherStaticLock.readLock().lock();
    try {
      otherStaticFieldStaticField2 = 0;
      x = otherStaticFieldStaticField2;
      
      otherStaticFieldField2 = 0;
      x = otherStaticFieldField2;
    } finally {
      Other.otherStaticLock.readLock().unlock();
    }
    
    Other.otherStaticLock.writeLock().lock();
    try {
      otherStaticFieldStaticField2 = 0;
      x = otherStaticFieldStaticField2;
      
      otherStaticFieldField2 = 0;
      x = otherStaticFieldField2;
    } finally {
      Other.otherStaticLock.writeLock().unlock();
    }
    
    otherStaticFieldStaticField2 = 0;
    x = otherStaticFieldStaticField2;
    
    otherStaticFieldField2 = 0;
    x = otherStaticFieldField2;
  }
  
  
  public void testRequiresLock() {
    final Test otherTest = new Test();
    
    fieldLock.readLock().lock();
    try {
      requiresParentFieldLock_read_implicitThis(otherTest);
      requiresParentFieldLock_read_explicitThis(otherTest);
      requiresParentFieldLock_read_qualifiedThis(otherTest);
      
      requiresParentFieldLock_write_implicitThis(otherTest);
      requiresParentFieldLock_write_explicitThis(otherTest);
      requiresParentFieldLock_write_qualifiedThis(otherTest);

      requiresFieldLock_read_implicitThis(otherTest);
      requiresFieldLock_read_explicitThis(otherTest);
      requiresFieldLock_read_qualifiedThis(otherTest);
      
      requiresFieldLock_write_implicitThis(otherTest);
      requiresFieldLock_write_explicitThis(otherTest);
      requiresFieldLock_write_qualifiedThis(otherTest);
    } finally {
      fieldLock.readLock().unlock();
    }
    
    fieldLock.writeLock().lock();
    try {
      requiresParentFieldLock_read_implicitThis(otherTest);
      requiresParentFieldLock_read_explicitThis(otherTest);
      requiresParentFieldLock_read_qualifiedThis(otherTest);
      
      requiresParentFieldLock_write_implicitThis(otherTest);
      requiresParentFieldLock_write_explicitThis(otherTest);
      requiresParentFieldLock_write_qualifiedThis(otherTest);

      requiresFieldLock_read_implicitThis(otherTest);
      requiresFieldLock_read_explicitThis(otherTest);
      requiresFieldLock_read_qualifiedThis(otherTest);
      
      requiresFieldLock_write_implicitThis(otherTest);
      requiresFieldLock_write_explicitThis(otherTest);
      requiresFieldLock_write_qualifiedThis(otherTest);
    } finally {
      fieldLock.writeLock().unlock();
    }
    
    requiresParentFieldLock_read_implicitThis(otherTest);
    requiresParentFieldLock_read_explicitThis(otherTest);
    requiresParentFieldLock_read_qualifiedThis(otherTest);
    
    requiresParentFieldLock_write_implicitThis(otherTest);
    requiresParentFieldLock_write_explicitThis(otherTest);
    requiresParentFieldLock_write_qualifiedThis(otherTest);

    requiresFieldLock_read_implicitThis(otherTest);
    requiresFieldLock_read_explicitThis(otherTest);
    requiresFieldLock_read_qualifiedThis(otherTest);
    
    requiresFieldLock_write_implicitThis(otherTest);
    requiresFieldLock_write_explicitThis(otherTest);
    requiresFieldLock_write_qualifiedThis(otherTest);

    
    
    otherTest.fieldLock.readLock().lock();
    try {
      requiresParentFieldLock_read_parameter(otherTest);
      requiresParentFieldLock_write_parameter(otherTest);
      
      requiresFieldLock_read_parameter(otherTest);
      requiresFieldLock_write_parameter(otherTest);
    } finally {
      otherTest.fieldLock.readLock().unlock();
    }
    
    otherTest.fieldLock.writeLock().lock();
    try {
      requiresParentFieldLock_read_parameter(otherTest);
      requiresParentFieldLock_write_parameter(otherTest);
      
      requiresFieldLock_read_parameter(otherTest);
      requiresFieldLock_write_parameter(otherTest);
    } finally {
      otherTest.fieldLock.writeLock().unlock();
    }
    
    requiresParentFieldLock_read_parameter(otherTest);
    requiresParentFieldLock_write_parameter(otherTest);
    
    requiresFieldLock_read_parameter(otherTest);
    requiresFieldLock_write_parameter(otherTest);

    
    
    parentFieldLock.readLock().lock();
    try {
      requiresParentFieldParentFieldLock_read_receiver();
      requiresParentFieldFieldLock_read_receiver();

      requiresParentFieldParentFieldLock_write_receiver();
      requiresParentFieldFieldLock_write_receiver();
    } finally {
      parentFieldLock.readLock().unlock();
    }

    parentFieldLock.writeLock().lock();
    try {
      requiresParentFieldParentFieldLock_read_receiver();
      requiresParentFieldFieldLock_read_receiver();

      requiresParentFieldParentFieldLock_write_receiver();
      requiresParentFieldFieldLock_write_receiver();
    } finally {
      parentFieldLock.writeLock().unlock();
    }

    // not protected
    requiresParentFieldParentFieldLock_read_receiver();
    requiresParentFieldFieldLock_read_receiver();

    requiresParentFieldParentFieldLock_write_receiver();
    requiresParentFieldFieldLock_write_receiver();

    
    
    otherTest.parentFieldLock.readLock().lock();
    try {
      requiresParentFieldParentFieldLock_read_param(otherTest);
      requiresParentFieldFieldLock_read_param(otherTest);

      requiresParentFieldParentFieldLock_write_param(otherTest);
      requiresParentFieldFieldLock_write_param(otherTest);
    } finally {
      otherTest.parentFieldLock.readLock().unlock();
    }

    otherTest.parentFieldLock.writeLock().lock();
    try {
      requiresParentFieldParentFieldLock_read_param(otherTest);
      requiresParentFieldFieldLock_read_param(otherTest);

      requiresParentFieldParentFieldLock_write_param(otherTest);
      requiresParentFieldFieldLock_write_param(otherTest);
    } finally {
      otherTest.parentFieldLock.writeLock().unlock();
    }

    // not protected
    requiresParentFieldParentFieldLock_read_param(otherTest);
    requiresParentFieldFieldLock_read_param(otherTest);

    requiresParentFieldParentFieldLock_write_param(otherTest);
    requiresParentFieldFieldLock_write_param(otherTest);

    
    
    staticFieldLock.readLock().lock();
    try {
      requiresStaticClassLock_read_implicit();
      requiresStaticClassLock_read_explicit();
      requiresStaticClassLock_write_implicit();
      requiresStaticClassLock_write_explicit();
    } finally {
      staticFieldLock.readLock().unlock();
    }
    
    staticFieldLock.writeLock().lock();
    try {
      requiresStaticClassLock_read_implicit();
      requiresStaticClassLock_read_explicit();
      requiresStaticClassLock_write_implicit();
      requiresStaticClassLock_write_explicit();
    } finally {
      staticFieldLock.writeLock().unlock();
    }

    requiresStaticClassLock_read_implicit();
    requiresStaticClassLock_read_explicit();
    requiresStaticClassLock_write_implicit();
    requiresStaticClassLock_write_explicit();

    
    
    Parent.parentStaticLock.readLock().lock();
    try {
      requiresOtherStaticFieldLock1_read_go();
      requiresOtherStaticFieldLock1_write_go();
    } finally {
      Parent.parentStaticLock.readLock().unlock();
    }
    
    Parent.parentStaticLock.writeLock().lock();
    try {
      requiresOtherStaticFieldLock1_read_go();
      requiresOtherStaticFieldLock1_write_go();
    } finally {
      Parent.parentStaticLock.writeLock().unlock();
    }
    
    requiresOtherStaticFieldLock1_read_go();
    requiresOtherStaticFieldLock1_write_go();

    
    
    Other.otherStaticLock.readLock().lock();
    try {
      requiresOtherStaticFieldLock2_read_go();
      requiresOtherStaticFieldLock2_write_go();
      
      requiresOtherStaticClassLock_read();
      requiresOtherStaticClassLock_write();
    } finally {
      Other.otherStaticLock.readLock().unlock();
    }
    
    Other.otherStaticLock.writeLock().lock();
    try {
      requiresOtherStaticFieldLock2_read_go();
      requiresOtherStaticFieldLock2_write_go();
      
      requiresOtherStaticClassLock_read();
      requiresOtherStaticClassLock_write();
    } finally {
      Other.otherStaticLock.writeLock().unlock();
    }
    
    requiresOtherStaticFieldLock2_read_go();
    requiresOtherStaticFieldLock2_write_go();
    
    requiresOtherStaticClassLock_read();
    requiresOtherStaticClassLock_write();
  }
  
  @RequiresLock("ParentFieldLock.readLock()")
  private void requiresParentFieldLock_read_implicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("this:ParentFieldLock.readLock()")
  private void requiresParentFieldLock_read_explicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("Test.this:ParentFieldLock.readLock()")
  private void requiresParentFieldLock_read_qualifiedThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("other:ParentFieldLock.readLock()")
  private void requiresParentFieldLock_read_parameter(Test other) {
    // do nothing
  }
  
  @RequiresLock("ParentFieldLock.writeLock()")
  private void requiresParentFieldLock_write_implicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("this:ParentFieldLock.writeLock()")
  private void requiresParentFieldLock_write_explicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("Test.this:ParentFieldLock.writeLock()")
  private void requiresParentFieldLock_write_qualifiedThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("other:ParentFieldLock.writeLock()")
  private void requiresParentFieldLock_write_parameter(Test other) {
    // do nothing
  }

  
  
  
  @RequiresLock("FieldLock.readLock()")
  private void requiresFieldLock_read_implicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("this:FieldLock.readLock()")
  private void requiresFieldLock_read_explicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("Test.this:FieldLock.readLock()")
  private void requiresFieldLock_read_qualifiedThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("other:FieldLock.readLock()")
  private void requiresFieldLock_read_parameter(Test other) {
    // do nothing
  }
  
  @RequiresLock("FieldLock.writeLock()")
  private void requiresFieldLock_write_implicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("this:FieldLock.writeLock()")
  private void requiresFieldLock_write_explicitThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("Test.this:FieldLock.writeLock()")
  private void requiresFieldLock_write_qualifiedThis(Test other) {
    // do nothing
  }
  
  @RequiresLock("other:FieldLock.writeLock()")
  private void requiresFieldLock_write_parameter(Test other) {
    // do nothing
  }

  
  
  
  @RequiresLock("ParentFieldParentFieldLock.readLock()")
  private void requiresParentFieldParentFieldLock_read_receiver() {
    // do nothing
  }
  
  @RequiresLock("ParentFieldParentFieldLock.writeLock()")
  private void requiresParentFieldParentFieldLock_write_receiver() {
    // do nothing
  }
  
  @RequiresLock("other:ParentFieldParentFieldLock.readLock()")
  private void requiresParentFieldParentFieldLock_read_param(Test other) {
    // do nothing
  }
  
  @RequiresLock("other:ParentFieldParentFieldLock.writeLock()")
  private void requiresParentFieldParentFieldLock_write_param(Test other) {
    // do nothing
  }
  
  @RequiresLock("ParentFieldFieldLock.readLock()")
  private void requiresParentFieldFieldLock_read_receiver() {
    // do nothing
  }
  
  @RequiresLock("ParentFieldFieldLock.writeLock()")
  private void requiresParentFieldFieldLock_write_receiver() {
    // do nothing
  }
  
  @RequiresLock("other:ParentFieldFieldLock.readLock()")
  private void requiresParentFieldFieldLock_read_param(Test other) {
    // do nothing
  }
  
  @RequiresLock("other:ParentFieldFieldLock.writeLock()")
  private void requiresParentFieldFieldLock_write_param(Test other) {
    // do nothing
  }

  
  
  @RequiresLock("StaticFieldLock.readLock()")
  private void requiresStaticClassLock_read_implicit() {
    
  }

  @RequiresLock("test.read_write.Test:StaticFieldLock.readLock()")
  private void requiresStaticClassLock_read_explicit() {
    
  }

  @RequiresLock("StaticFieldLock.writeLock()")
  private void requiresStaticClassLock_write_implicit() {
    
  }

  @RequiresLock("test.read_write.Test:StaticFieldLock.writeLock()")
  private void requiresStaticClassLock_write_explicit() {
    
  }

  @RequiresLock("test.read_write.Test:OtherStaticFieldLock1.readLock()")
  private void requiresOtherStaticFieldLock1_read_go() {
    // do nothing
  }

  @RequiresLock("test.read_write.Test:OtherStaticFieldLock1.writeLock()")
  private void requiresOtherStaticFieldLock1_write_go() {
    // do nothing
  }

  @RequiresLock("test.read_write.Test:OtherStaticFieldLock2.readLock()")
  private void requiresOtherStaticFieldLock2_read_go() {
    // do nothing
  }

  @RequiresLock("test.read_write.Test:OtherStaticFieldLock2.writeLock()")
  private void requiresOtherStaticFieldLock2_write_go() {
    // do nothing
  }

  
  
  
  @RequiresLock("test.read_write.Test.Other:OtherLock.readLock()")
  private void requiresOtherStaticClassLock_read() {
    
  }

  @RequiresLock("test.read_write.Test.Other:OtherLock.writeLock()")
  private void requiresOtherStaticClassLock_write() {
    
  }
  
  
  
  @RegionLock("OtherLock is otherStaticLock protects R")
  @Region("public static R")
  public static class Other {
    public static final ReadWriteLock otherStaticLock = new ReentrantReadWriteLock();
    // empty
  }
}
