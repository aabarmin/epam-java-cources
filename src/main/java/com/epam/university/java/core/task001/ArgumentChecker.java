package com.epam.university.java.core.task001;

/** Created by ilya on 02.09.17. */
public class ArgumentChecker implements Checker {
  @Override
  public void check(String number) {
    if (number == null) {
      throw new IllegalArgumentException("one or both of numbers is null");
    }
  }
}
