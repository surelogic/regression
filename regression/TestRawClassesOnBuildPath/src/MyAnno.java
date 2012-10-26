import com.surelogic.Immutable;
import com.surelogic.ThreadSafe;

@ThreadSafe
public @interface MyAnno {

  final int foo = 5;

  final Object bar = new String("fooo");

  final Object[] boop = { bar };

  @Immutable
  @interface MyNested {
  }
}
