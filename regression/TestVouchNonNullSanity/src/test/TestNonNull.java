package test;

import javax.swing.JFrame;

import com.surelogic.Vouch;

@Vouch("NonNull") // bad
public class TestNonNull {
  @Vouch("NonNull") // bad
  private Object field;
  
  @Vouch("NonNull") // bad
  public TestNonNull() {
    super();
  }
  
  @Vouch("NonNull") // bad
  public void method(@Vouch("NonNull") /* bad */ Object p) {
    @Vouch("NonNull") // bad: primitively typed and non final
    int local01;
    
    @Vouch("NonNull") // bad: non final
    String local02;
    
    @Vouch("NonNull") // bad: non final
    Object local03;
    
    @Vouch("NonNull") // bad: non final
    JFrame local04;

  
  
    @Vouch("NonNull") // bad: primitively typed
    final int local001 = 0;
    
    @Vouch("NonNull") // Good
    final String local002 = "S";
    
    @Vouch("NonNull") // Good
    final Object local003 = "S";
    
    @Vouch("NonNull") // Good
    final JFrame local004 = new JFrame();
  }
}
