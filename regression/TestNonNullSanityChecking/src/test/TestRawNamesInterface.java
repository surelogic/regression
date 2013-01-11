package test;

import com.surelogic.Raw;

public class TestRawNamesInterface {
//  class C {
//    // empty
//  }
//
//  class D extends C {
//    // empty
//  }
//
//  interface I {
//    // empty
//  }
//
//  interface J extends I {
//    // empty
//  }
//
//  class K implements I {
//    // empty
//  }  
//  
//  
//  public void m(
//      @Raw(upTo="test.TestRawNamesInterface$C") D good, // Good: D extends C
//      @Raw(upTo="test.TestRawNamesInterface$I") J bad1, // Bad: J is an interface
//      @Raw(upTo="test.TestRawNamesInterface$I") K bad2, // Bad: I is an interface
//      @Raw(upTo="test.TestRawNamesInterface$K") D bad3  // Bad: D does not extend K
//      ) {
//    // empty
//  }
  
  public void m(
      @Raw(upTo="test.CC") DD good, // Good: DD extends CC
      @Raw(upTo="test.DD") DD good2, // Good: DD extends DD
      @Raw(upTo="test.II") JJ bad1, // Bad: JJ is an interface
      @Raw(upTo="test.II") KK bad2, // Bad: II is an interface
      @Raw(upTo="test.KK") DD bad3,  // Bad: DD does not extend KK
      @Raw(upTo="bob") Object bad4 // Bad: no type named bob
      ) {
    // empty
  }
}


class CC {
  // empty
}

class DD extends CC {
  // empty
}

interface II {
  // empty
}

interface JJ extends II {
  // empty
}

class KK implements II {
  // empty
}
