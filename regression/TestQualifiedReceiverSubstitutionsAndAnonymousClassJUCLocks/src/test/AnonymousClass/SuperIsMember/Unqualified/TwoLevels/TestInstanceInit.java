package test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.surelogic.Borrowed;
import com.surelogic.RegionLock;
import com.surelogic.RegionLocks;
import com.surelogic.RequiresLock;

@RegionLocks({
  @RegionLock("T1 is lockT1 protects t1"),
  @RegionLock("T2 is lockT2 protects t2")
})
public class TestInstanceInit {
  public final Lock lockT1 = new ReentrantLock();
  public final Lock lockT2 = new ReentrantLock();
  public int t1;
  public int t2;
  

  @RegionLocks({
    @RegionLock("C1 is lockC1 protects c1"),
    @RegionLock("C2 is lockC2 protects c2")
  })
  public class Container {
    public final Lock lockC1 = new ReentrantLock();
    public final Lock lockC2 = new ReentrantLock();
    public int c1;
    public int c2;
    
    @RegionLock("F is lockF protects f")
    public class Super {
      public final Lock lockF = new ReentrantLock();
      public int f;
      
      { 
        Container.this.c1 = 10;
      }
      
      @Borrowed("this")
      @RequiresLock("TestInstanceInit.this:T1, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.TestInstanceInit.Container.this:C1")
      public Super() {
        // do stuff
        TestInstanceInit.this.t1 = 5;
        this.f = 10;
      }
    }
  

    
    {
      /* The immediately enclosing instance of s1 is "this" (a Container object)
       * The immediately enclosing instance with respect to Super is Container.this.
       * 
       * Writes TestInstanceInit.this.t1, TestInstanceInit.this.t2, this.c1, this.c2
       */
      lockC1.lock();
      try {
        lockC2.lock();
        try {
          final Super s1 = new Super() { 
            private int g = 10;
            { t2 += 1; }
            { c2 = 9; }
          };
        } finally {
          lockC2.unlock();
        }
      } finally {
        lockC2.unlock();
      }
    }
    
    @RequiresLock("TestInstanceInit.this:T1, TestInstanceInit.this:T2")
    public Container() {
      // Effects from instance init
    }
  
    
    
    @RegionLock("M1 is lockM1 protects m1")
    public class Middle1 {
      public final Lock lockM1 = new ReentrantLock();
      public int m1;
      
      {
        /* The immediately enclosing instance of s3 is "this" (a Middle1 object)
         * The immediately enclosing instance with respect to Super is Container.this.
         * 
         * Writes TestInstanceInit.this.t1, TestInstanceInit.this.t2, Container.this.c1, Container.this.c2, this.m1
         */
        lockM1.lock();
        try {
          final Super s3 = new Super() { 
            private int g = 10;
            { m1 = 10; }
            { t2 += 1; }
            { c2 = 9; }
          };
        } finally {
          lockM1.unlock();
        }
      }
      
      @RequiresLock("TestInstanceInit.this:T1, TestInstanceInit.this:T2, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.TestInstanceInit.Container.this:C1, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.TestInstanceInit.Container.this:C2")
      public Middle1() {
        // Effects from instance init
      }
  
    
    
      @RegionLock("M2 is lockM2 protects m2")
      public class Middle2 {
        public final Lock lockM2 = new ReentrantLock();
        public int m2;
        
        {
          /* The immediately enclosing instance of s5 is "this" (a Middle2 object)
           * The immediately enclosing instance with respect to Super is Container.this.
           * 
           * Writes TestInstanceInit.this.t1, TestInstanceInit.this.t2, TestInstanceInit.this.m1, Container.this.c1, Container.this.c2, this.m2
           */
          lockM2.lock();
          try {
            final Super s5 = new Super() { 
              private int g = 10;
              { m1 = 10; }
              { m2 = 20; }
              { t2 += 1; }
              { c2 = 9; }
            };
          } finally {
            lockM2.unlock();
          }
        }
        
        @RequiresLock("TestInstanceInit.this:T1, TestInstanceInit.this:T2, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.TestInstanceInit.Container.Middle1.this:M1, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.TestInstanceInit.Container.this:C1, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.TestInstanceInit.Container.this:C2")
        public Middle2() {
          // effects from instance init
        }
      }
    }
  }
}
