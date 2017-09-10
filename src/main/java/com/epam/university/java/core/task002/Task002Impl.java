package com.epam.university.java.core.task002;

/** Created by ilya on 02.09.17. */
public class Task002Impl implements Task002 {
  private final Checker checker;

  public Task002Impl() {
    this.checker = new StringNotNullChecker();
  }

  @Override
  public boolean isEquals(String firstString, String secondString) {
    checker.check(firstString, secondString);
    return firstString.equals(secondString);
  }

  @Override
  public String left(String sourceString, int number) {
    checker.check(sourceString);
    String result = "";
    try {
      result = sourceString.substring(0, number);
    } catch (StringIndexOutOfBoundsException e) {
      if (number < 0) {
        throw new IllegalArgumentException("incorrect position ");
      } else {
        result = sourceString;
      }
    }

    return result;
  }

  @Override
  public String right(String sourceString, int number) {
    checker.check(sourceString);
    String result = "";
    try {
      result = sourceString.substring(sourceString.length() - number, sourceString.length());
    } catch (StringIndexOutOfBoundsException e) {
      if (sourceString.length() - number > sourceString.length()) {
        throw new IllegalArgumentException("incorrect position ");
      } else {
        result = sourceString;
      }
    }

    return result;
  }

  @Override
  public String left(String sourceString, String separator) {
    String[] strings = split(sourceString, separator);
    return strings[0];
  }

  @Override
  public String right(String sourceString, String separator) {
    String[] strings = split(sourceString, separator);
    return strings[strings.length - 1];
  }

  @Override
  public String[] split(String sourceString, String split) {
    checker.check(sourceString);

    String[] result = sourceString.split(split);

    return result;
  }

  @Override
  public String join(String[] sourceCollection, String glue) {
    checker.check(sourceCollection);
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(sourceCollection[0]);
    for (int i = 1; i < sourceCollection.length; i++) {
      stringBuilder.append(glue).append(sourceCollection[i]);
    }

    return stringBuilder.toString();
  }
}
