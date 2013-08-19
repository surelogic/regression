package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;

public class TestPrimitiveArray {
  // Nullable
  public boolean[] maybeNullImplied(int x,
      boolean[] a1, @Nullable boolean a2[], @NonNull boolean a3[]) {
    boolean[] b = null;
    
    switch (x) {
    case 0:
      return a1; // good: @Nullable boolean[]
    case 1:
      return a2; // good @Nullable boolean[]
    case 2:
      return a3; // good: @NonNull boolean[]
    case 3:
      return new boolean[1]; // good: @NonNull boolean[]
    case 4:
      return b; // good: NULL
    default:
      return null; // good NULL
    }
  }

  @Nullable
  public boolean[] maybeNull(int x,
      boolean[] a1, @Nullable boolean a2[], @NonNull boolean a3[]) {
    boolean[] b = null;
    
    switch (x) {
    case 0:
      return a1; // good: @Nullable boolean[]
    case 1:
      return a2; // good @Nullable boolean[]
    case 2:
      return a3; // good: @NonNull boolean[]
    case 3:
      return new boolean[1]; // good: @NonNull boolean[]
    case 4:
      return b; // good: NULL
    default:
      return null; // good NULL
    }
  }

  @NonNull
  public boolean[] nonNull(int x,
      boolean[] a1, @Nullable boolean a2[], @NonNull boolean a3[]) {
    boolean[] b = null;
    
    switch (x) {
    case 0:
      return a1; // bad: @Nullable boolean[]
    case 1:
      return a2; // bad @Nullable boolean[]
    case 2:
      return a3; // good: @NonNull boolean[]
    case 3:
      return new boolean[1]; // good: @NonNull boolean[]
    case 4:
      return b; // bad: NULL
    default:
      return null; // bad NULL
    }
  }
}
