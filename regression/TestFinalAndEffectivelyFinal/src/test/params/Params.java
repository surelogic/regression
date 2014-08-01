package test.params;

import java.io.IOException;

import com.surelogic.Vouch;

public class Params {
  private void m() throws InterruptedException {}
  
  private void n() throws IOException {}
  
  private class R implements AutoCloseable {
    public void close() {}
  }
  
  public void m(final int p1, int p2, final Object p3, String p4) {
    try {
      m();
      n();
    } catch(final InterruptedException e) { // explicitly final
    } catch(IOException e) { // effectively final
    }
    
    try {
      m();
      n();
    } catch (InterruptedException | IOException e) { // implicitly final
    }
    
    try (R r = new R();
        R r2 = new R()) {
      System.out.println("foo");
    }
  }
  
  
  public void m(int p1, int p2, int p3) {
    p1++; 
    
    try {
      m();
      n();
    } catch(InterruptedException e) { // not final
      e = null;
    } catch(IOException e) { // effectively final
    }
    
    p2 += 4;
    
    try {
      m();
      n();
    } catch (InterruptedException | IOException e) { // implicitly final
    }
    
    p3 = 6;
    
    try (R r = new R();
        R r2 = new R()) {
      System.out.println("foo");
    }
  }
}
