package test_returns_lock;

/**
 * (These tests are all really Lock Name sanity tests.)
 * 
 * @Region R
 * @RegionLock Exists is this protects R
 * 
 * @Region static StaticRegion
 * @Region NonStaticRegion
 * @RegionLock StaticLock is class protects StaticRegion
 * @RegionLock NonStaticLock is this protects NonStaticRegion
 */
public class StateLock {
  /**
   * BAD: cannot qualify a static lock with this
   * @TestResult is UNASSOCIATED: Cannot qualify a static lock with this
   * @ReturnsLock this:StaticLock
   */
  public Object getLock_thisQualified_staticLock() {
    return StateLock.class;
  }
  
  /**
   * GOOD: Can ref static lock from instance method
   * @TestResult is CONSISTENT
   * @ReturnsLock StaticLock
   */
  public Object getLock_implicit_staticLock() {
    return StateLock.class;
  }
  
  /**
   * GOOD: Can ref static lock from instance method
   * @TestResult is CONSISTENT
   * @returnsLock test_returns_lock.StateLock:StaticLock
   */
  public Object getLock_typeQualified_staticLock() {
    return StateLock.class;
  }
  
  /**
   * BAD: type-qualified instance lock
   * @TestResult is UNASSOCIATED: Cannot type-qualify an instance lock
   * @ReturnsLock test_returns_lock.StateLock:Exists
   */
  public Object getLock_typeQualifiedInstance() {
    return null;
  }
  
  /**
   * BAD: Lock doesn't exist
   * @TestResult is UNBOUND
   * @ReturnsLock DoesntExist
   */
  public Object getLock_doesntExist() {
    return null;
  }
  
  /**
   * GOOD: Lock exists
   * @TestResult is CONSISTENT
   * @ReturnsLock Exists
   */
  public Object getLock_exists() {
    return this;
  }
  
  /**
   * GOOD: Lock Exists.  Test with qualified this
   * @TestResult is CONSISTENT
   * @ReturnsLock this:Exists
   */
  public Object getLock_exists2() {
    return this;
  }

  /**
   * BAD: parameter doesn't exist.
   * @TestResult is UNBOUND: parameter p doesn't exist
   * @ReturnsLock p:DoesntExist
   */
  public Object getLock_bad_param(final Object o) {
    return o;
  }
  
  /**
   * BAD: parameter exists, but the lock doesn't exist
   * @TestResult is UNBOUND
   * @ReturnsLock p:DoesntExist 
   */
  public Object getLock_param_doesntExist(final StateLock p) {
    return p;
  }
    
  /**
   * BAD: parameter exists; lock exists; but param is non-final
   * @TestResult is UNASSOCIATED: parameter is non-final
   * @ReturnsLock p:Exists 
   */
  public Object getLock_param_nonfinal(StateLock p) {
    return p;
  }
  
  /**
   * GOOD: parameter exists; lock exists; param is final
   * @TestResult is CONSISTENT
   * @returnsLock p:Exists 
   */
  public Object getLock_param_good(final StateLock p) {
    return p;
  }
  
  
  
  
  
  
  
  
  /**
   * BAD: cannot bind "this"!  Irrelevant that lock otherwise exists.
   * This is a syntactic check on the QualifiedLockName.
   * @TestResult is UNASSOCIATED: Cannot refer to 'this' on static method
   * @ReturnsLock this:NonStaticLock
   */
  public static Object getLock_staticMethod_instanceRegion1() {
    return new Object();
  }

  /**
   * BAD: cannot bind "this"!  Irrelevant that lock otherwise does exist.
   * This is a semantic check on the protected region: Check that it is static.
   *
   * @TestResult is UNASSOCIATED: Cannot refer to 'this' (implicitly) on static method
   * @ReturnsLock NonStaticLock
   */
  public static Object getLock_staticMethod_instanceRegion1a() {
    return new Object();
  }
  
  /**
   * GOOD: Returns lock that protects a static region.
   * @TestResult is CONSISTENT
   * @ReturnsLock StaticLock 
   */
  public static Object getLock_staticMethod_staticRegion1() {
    return StateLock.class;
  }
  
  /**
   * GOOD: Returns lock that protects a static region.  Here we explicitly 
   * name the class.
   * @TestResult is CONSISTENT
   * @ReturnsLock test_returns_lock.StateLock:StaticLock 
   */
  public static Object getLock_staticMethod_staticRegion1a() {
    return StateLock.class;
  }
  
  /**
   * BAD: Lock does not exist; doesn't matter that we cannot refer to 'this'
   * @TestResult is UNBOUND: Lock does not exist
   * @ReturnsLock this:DoesntExist
   */
  public static Object getLock_staticMethod_unknownRegionWithThis() {
    return new Object();
  }

  /**
   * BAD: Lock doesn't exist, so doesn't matter if it is static or not.
   * @TestResult is UNBOUND: Lock doesn't exist 
   * @ReturnsLock DoesntExist
   */
  public static Object getLock_staticMethod_unknownRegion() {
    return new Object();
  }
  
  /**
   * BAD: The named class doesn't exist.  (Default package)
   * @TestResult is UNBOUND: Class doesn't exist (Default package)
   * @ReturnsLock NoSuchClass:DoesntExist
   */
  public static Object getLock_staticMethod_unknownClass1() {
    return null;
  }
  
  /**
   * BAD: The named class doesn't exist.  (Named package)
   * @TestResult is UNBOUND: Class doesn't exist
   * @ReturnsLock no.such.pkg.NoSuchClass:DoesntExist
   */
  public static Object getLock_staticMethod_unknownClass1a() {
    return null;
  }

  /**
   * GOOD: Static method returns an instance lock of a parameter.
   * @TestResult is CONSISTENT
   * @ReturnsLock p:NonStaticLock
   */
  public static Object getLock_staticMethod_paramLock(final StateLock p) {
    return p;
  }
}
