package com.surelogic;

@Immutable
public class ImGood {

  // Okay because field is initialized to a class whose implementation is immutable
  static private final Other SO = new Other();

  // Okay because field is initialized to a class whose implementation is immutable
  private final Other o = new Other();

}


@Immutable(implementationOnly=true)
class Other {
  // stuff
}