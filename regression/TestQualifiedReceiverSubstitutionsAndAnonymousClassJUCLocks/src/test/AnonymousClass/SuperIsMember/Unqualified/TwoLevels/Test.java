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
public class Test {
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
      public final Object lockF = new Object();
      public int f;
      
      { 
        Container.this.c1 = 10;
      }
      
      @Borrowed("this")
      @RequiresLock("Test.this:T1, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.Test.Container.this:C1")
      public Super() {
        // do stuff
        Test.this.t1 = 5;
        this.f = 10;
      }
    }
  
    
    
    @RequiresLock("Test.this:T1, Test.this:T2")
    public Container() {
      /* The immediately enclosing instance of s1 is "this" (a Container object)
       * The immediately enclosing instance with respect to Super is Container.this.
       * 
       * Writes Test.this.t1, Test.this.t2, this.c1, this.c2
       */
      /* Cannot declare this method to be single threaded because it aliases
       * the receiver by creating inner objects and it writes to other objects.
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
        lockC1.unlock();
      }
    }
  
    @RequiresLock("Test.this:T1, Test.this:T2, this:C1, this:C2")
    public void stuff1() {
      /* The immediately enclosing instance of s2 is "this" (a Container object)
       * The immediately enclosing instance with respect to Super is Container.this.
       * 
       * Writes Test.this.t1, Test.this.t2, this.c1, this.c2
       */
      final Super s2 = new Super() { 
        private int g = 10;
        { t2 += 1; }
        { c2 = 9; }
      };
    }

    public void stuff2() {
      Test.this.lockT1.lock();
      try {
        Test.this.lockT2.lock();
        try {
          lockC1.lock();
          try {
            lockC2.lock();
            try {
              /* The immediately enclosing instance of s2 is "this" (a Container object)
               * The immediately enclosing instance with respect to Super is Container.this.
               * 
               * Writes Test.this.t1, Test.this.t2, this.c1, this.c2
               */
              final Super s2 = new Super() { 
                private int g = 10;
                { t2 += 1; }
                { c2 = 9; }
              };
            } finally {
              lockC2.unlock();
            }
          } finally {
            lockC1.unlock();
          }
        } finally {
          Test.this.lockT2.unlock();
        }
      } finally {
        Test.this.lockT1.unlock();
      }
    }

    
    
    @RegionLock("M1 is lockM1 protects m1")
    public class Middle1 {
      public final Lock lockM1 = new ReentrantLock();
      public int m1;
      
      @RequiresLock("Test.this:T1, Test.this:T2, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.Test.Container.this:C1, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.Test.Container.this:C2")
      public Middle1() {
        /* The immediately enclosing instance of s3 is "this" (a Middle1 object)
         * The immediately enclosing instance with respect to Super is Container.this.
         * 
         * Writes Test.this.t1, Test.this.t2, Container.this.c1, Container.this.c2, this.m1
         */
        /* Cannot declare this method to be single threaded because it aliases
         * the receiver by creating inner objects and it writes to other objects.
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
  
      @RequiresLock("Test.this:T1, Test.this:T2, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.Test.Container.this:C1, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.Test.Container.this:C2, this:M1")
      public void stuff1() {
        /* The immediately enclosing instance of s4 is "this" (a Middle1 object)
         * The immediately enclosing instance with respect to Super is Container.this.
         * 
         * Writes Test.this:t1, Test.this:t2, Container.this.c1, Container.this.c2, this.m1
         */
        final Super s4 = new Super() { 
          private int g = 10;
          { m1 = 20; }
          { t2 += 1; }
          { c2 = 9; }
        };
      }
  
      public void stuff2() {
        Test.this.lockT1.lock();
        try {
          Test.this.lockT2.lock();
          try {
            Container.this.lockC1.lock();
            try {
              Container.this.lockC2.lock();
              try {
                lockM1.lock();
                try {
                  /* The immediately enclosing instance of s4 is "this" (a Middle1 object)
                   * The immediately enclosing instance with respect to Super is Container.this.
                   * 
                   * Writes Test.this:t1, Test.this:t2, Container.this.c1, Container.this.c2, this.m1
                   */
                  final Super s4 = new Super() { 
                    private int g = 10;
                    { m1 = 20; }
                    { t2 += 1; }
                    { c2 = 9; }
                  };
                } finally {
                  lockM1.unlock();
                }
              } finally {
                Container.this.lockC2.unlock();
              }
            } finally {
              Container.this.lockC1.unlock();
            }
          } finally {
            Test.this.lockT2.unlock();
          }
        } finally {
          Test.this.lockT1.unlock();
        }
      }
  
    
      
      @RegionLock("M2 is lockM2 protects m2")
      public class Middle2 {
        public final Lock lockM2 = new ReentrantLock();
        public int m2;
        
        @RequiresLock("Test.this:T1, Test.this:T2, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.Test.Container.this:C1, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.Test.Container.this:C2, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.Test.Container.Middle1.this:M1")
        public Middle2() {
          /* The immediately enclosing instance of s5 is "this" (a Middle2 object)
           * The immediately enclosing instance with respect to Super is Container.this.
           * 
           * Writes Test.this:t1, Test.this:t2, Middle1.this.m1, Container.this.c1, Container.this.c2, this.m2
           */
          /* Cannot declare this method to be single threaded because it aliases
           * the receiver by creating inner objects and it writes to other objects.
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
        
        @RequiresLock("Test.this:T1, Test.this:T2, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.Test.Container.this:C1, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.Test.Container.this:C2, test.AnonymousClass.SuperIsMember.Unqualified.TwoLevels.Test.Container.Middle1.this:M1, this:M2")
        public void stuff1() {
          /* The immediately enclosing instance of s6 is "this" (a Middle2 object)
           * The immediately enclosing instance with respect to Super is Container.this.
           * 
           * Writes Test.this:t1, Test.this:t2, Middle1.this.m1, Container.this.c1, Container.this.c2, this.m2
           */
          final Super s6 = new Super() { 
            private int g = 10;
            { m1 = 20; }
            { m2 = 30; }
            { t2 += 1; }
            { c2 = 9; }
          };
        }
        
        public void stuff2() {
          Test.this.lockT1.lock();
          try {
            Test.this.lockT2.lock();
            try {
              Container.this.lockC1.lock();
              try {
                Container.this.lockC2.lock();
                try {
                  Middle1.this.lockM1.lock();
                  try {
                    lockM2.lock();
                    try {
                      /* The immediately enclosing instance of s6 is "this" (a Middle2 object)
                       * The immediately enclosing instance with respect to Super is Container.this.
                       * 
                       * Writes Test.this:t1, Test.this:t2, Middle1.this.m1, Container.this.c1, Container.this.c2, this.m2
                       */
                      final Super s6 = new Super() { 
                        private int g = 10;
                        { m1 = 20; }
                        { m2 = 30; }
                        { t2 += 1; }
                        { c2 = 9; }
                      };
                    } finally {
                      lockM2.unlock();
                    }
                  } finally {
                    Middle1.this.lockM1.unlock();
                  }
                } finally {
                  Container.this.lockC2.unlock();
                }
              } finally {
                Container.this.lockC1.unlock();
              }
            } finally {
              Test.this.lockT2.unlock();
            }
          } finally {
            Test.this.lockT1.unlock();
          }
        }
      }
    }
  }
}
