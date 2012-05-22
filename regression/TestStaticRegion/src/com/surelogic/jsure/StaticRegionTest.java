package com.surelogic.jsure;

import java.math.BigInteger;

import com.surelogic.RegionEffects;

public class StaticRegionTest {

  private static int foo = 1;

  @RegionEffects("reads Static")
  public static int getFoo() {
    return foo;
  }

  @RegionEffects("writes Static")
  public static void setFoo(int value) {
    foo = value;
  }

  private static int bar = 1;

  @RegionEffects("reads com.surelogic.jsure.StaticRegionTest:Static")
  public static int getBar() {
    return bar;
  }

  @RegionEffects("writes com.surelogic.jsure.StaticRegionTest:Static")
  public static void setBar(int value) {
    bar = value;
  }

  /*
   * Should fail and propose "writes java.lang.Thread:Static"
   */
  @RegionEffects("none")
  static void setDefaultBad() {
    Thread.setDefaultUncaughtExceptionHandler(null);
  }

  /*
   * Should verify okay.
   */
  @RegionEffects("writes java.lang.Thread:Static")
  static void setDefaultGood() {
    Thread.setDefaultUncaughtExceptionHandler(null);
  }

  /*
   * Should fail and propose "reads java.lang.Thread:Static"
   */
  @RegionEffects("none")
  static void getDefaultBad() {
    Thread.getDefaultUncaughtExceptionHandler();
  }

  /*
   * Should verify okay.
   */
  @RegionEffects("writes java.lang.Thread:Static")
  static void getDefaultGood() {
    Thread.getDefaultUncaughtExceptionHandler();
  }

  /*
   * Should fail and propose "reads java.math.BigInteger:Static"
   */
  @RegionEffects("none")
  static void getBigIntBad() {
    BigInteger.valueOf(42);
  }

  /*
   * Should verify okay.
   */
  @RegionEffects("writes java.math.BigInteger:Static")
  static void getBigIntGood() {
    BigInteger.valueOf(42);
  }

  /*
   * Should fail and propose
   * "reads java.math.BigInteger:Static; writes java.lang.Thread:Static"
   */
  @RegionEffects("none")
  static void bigBangBad() {
    Thread.setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
    BigInteger.valueOf(42);
  }

  /*
   * Should verify okay.
   */
  @RegionEffects("reads java.math.BigInteger:Static; writes java.lang.Thread:Static")
  static void bigBangGood() {
    Thread.setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
    BigInteger.valueOf(42);
  }
}
