package test;

import javax.swing.JFrame;

import com.surelogic.Vouch;

@Vouch("Nullable") // bad
public class TestNullable {
  @Vouch("Nullable") // bad
  private Object field;
  
  @Vouch("Nullable") // bad
  public TestNullable() {
    super();
  }
  
  @Vouch("Nullable") // bad
  public void method(@Vouch("Nullable") /* bad */ Object p) {
    @Vouch("Nullable") // bad: primitively typed and non final
    int local01;
    
    @Vouch("Nullable") // bad: non final
    String local02;
    
    @Vouch("Nullable") // bad: non final
    Object local03;
    
    @Vouch("Nullable") // bad: non final
    JFrame local04;

  
  
    @Vouch("Nullable") // bad: primitively typed
    final int local001 = 0;
    
    @Vouch("Nullable") // Good
    final String local002 = "S";
    
    @Vouch("Nullable") // Good
    final Object local003 = "S";
    
    @Vouch("Nullable") // Good
    final JFrame local004 = new JFrame();
  }
}
