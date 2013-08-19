package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.Raw;

public class TestArrayToObject {
  // Nullable
  public Object maybeNullImplied(int x,
      int[] intArray, String[] stringArray,
      @Nullable int[] intArray2, @Nullable String[] stringArray2,
      @NonNull int[] intArray3, @NonNull String[] stringArray3) {
    boolean[] b = null;
    
    switch (x) {
    case 0:
      return intArray; // good: @Nullable int[]
    case 1:
      return stringArray; // good @Nullable String[]
    case 2:
      return intArray2; // good: @Nullable int[]
    case 3:
      return stringArray2; // good: @Nullable String[]
    case 4:
      return intArray3; // good: @NonNull int[]
    case 5:
      return stringArray3; // good: @NonNull String[]
    case 6:
      return new int[10]; // good: @NonNull int[]
    case 7:
      return new String[5][4][3][2][1]; // good: NonNull String[][][][][]
    case 8:
      return b; // good: NULL boolean[]
    default:
      return null; // good NULL
    }
  }

  @Nullable
  public Object maybeNull(int x,
      int[] intArray, String[] stringArray,
      @Nullable int[] intArray2, @Nullable String[] stringArray2,
      @NonNull int[] intArray3, @NonNull String[] stringArray3) {
    boolean[] b = null;
    
    switch (x) {
    case 0:
      return intArray; // good: @Nullable int[]
    case 1:
      return stringArray; // good @Nullable String[]
    case 2:
      return intArray2; // good: @Nullable int[]
    case 3:
      return stringArray2; // good: @Nullable String[]
    case 4:
      return intArray3; // good: @NonNull int[]
    case 5:
      return stringArray3; // good: @NonNull String[]
    case 6:
      return new int[10]; // good: @NonNull int[]
    case 7:
      return new String[5][4][3][2][1]; // good: NonNull String[][][][][]
    case 8:
      return b; // good: NULL boolean[]
    default:
      return null; // good NULL
    }
  }

  @NonNull
  public Object nonNull(int x,
      int[] intArray, String[] stringArray,
      @Nullable int[] intArray2, @Nullable String[] stringArray2,
      @NonNull int[] intArray3, @NonNull String[] stringArray3) {
    boolean[] b = null;
    
    switch (x) {
    case 0:
      return intArray; // bad: @Nullable int[]
    case 1:
      return stringArray; // bad @Nullable String[]
    case 2:
      return intArray2; // bad: @Nullable int[]
    case 3:
      return stringArray2; // bad: @Nullable String[]
    case 4:
      return intArray3; // good: @NonNull int[]
    case 5:
      return stringArray3; // good: @NonNull String[]
    case 6:
      return new int[10]; // good: @NonNull int[]
    case 7:
      return new String[5][4][3][2][1]; // good: NonNull String[][][][][]
    case 8:
      return b; // bad: NULL boolean[]
    default:
      return null; // bad NULL
    }
  }

  @Raw("return")
  public Object rawStar(int x,
      int[] intArray, String[] stringArray,
      @Nullable int[] intArray2, @Nullable String[] stringArray2,
      @NonNull int[] intArray3, @NonNull String[] stringArray3) {
    boolean[] b = null;
    
    switch (x) {
    case 0:
      return intArray; // bad: @Nullable int[]
    case 1:
      return stringArray; // bad @Nullable String[]
    case 2:
      return intArray2; // bad: @Nullable int[]
    case 3:
      return stringArray2; // bad: @Nullable String[]
    case 4:
      return intArray3; // good: @NonNull int[]
    case 5:
      return stringArray3; // good: @NonNull String[]
    case 6:
      return new int[10]; // good: @NonNull int[]
    case 7:
      return new String[5][4][3][2][1]; // good: NonNull String[][][][][]
    case 8:
      return b; // bad: NULL boolean[]
    default:
      return null; // bad NULL
    }
  }

  @Raw(upTo="java.lang.Object", value="return")
  public Object rawObject(int x,
      int[] intArray, String[] stringArray,
      @Nullable int[] intArray2, @Nullable String[] stringArray2,
      @NonNull int[] intArray3, @NonNull String[] stringArray3) {
    boolean[] b = null;
    
    switch (x) {
    case 0:
      return intArray; // bad: @Nullable int[]
    case 1:
      return stringArray; // bad @Nullable String[]
    case 2:
      return intArray2; // bad: @Nullable int[]
    case 3:
      return stringArray2; // bad: @Nullable String[]
    case 4:
      return intArray3; // good: @NonNull int[]
    case 5:
      return stringArray3; // good: @NonNull String[]
    case 6:
      return new int[10]; // good: @NonNull int[]
    case 7:
      return new String[5][4][3][2][1]; // good: NonNull String[][][][][]
    case 8:
      return b; // bad: NULL boolean[]
    default:
      return null; // bad NULL
    }
  }
}
