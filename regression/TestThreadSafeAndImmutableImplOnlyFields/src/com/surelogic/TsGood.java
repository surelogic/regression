package com.surelogic;

@ThreadSafe
public class TsGood {

  // Okay because field is initialized to a class whose implementation is thread safe
  static private final Object SO = new Object();

  // Okay because field is initialized to a class whose implementation is thread safe
  private final Object o = new Object();

}
