package testBinder;

import java.io.*;
import java.lang.reflect.Method;

class TestVarargs {
	static void testVarargsWithCharArray(DataInputStream dataIn, int size) throws Exception {
    	byte[] data = new byte[size];
        dataIn.readFully(data);
        Method parseMethod = null;
        // Previously confusing because same # of formals and arguments
        // and because data is an array
        parseMethod.invoke(null, data);
    }

  public void testConversion() {
    verifyShares(10, 10, 10, 0);
  }
  
  /**
   * Test that being called on an empty list doesn't confuse the algorithm.
   */
  public void testEmptyList() {
    verifyShares();
  }
  
  /**
   * Check that a given list of shares have been assigned to this.scheds.
   */
  private void verifyShares(double... shares) {
  }
  
  public void testVarargs() {
	  setRightAlign(1, 2, 3, 4);
  }
  
  public void setRightAlign(int ... indexes) {	  
  }
}