package com.epam.university.java.core.task001;

/** Created by ilya on 02.09.17. */
public class NumberTokenizer implements Tokenizer {
  @Override
  public String tokenize(String number) {

    number.replaceAll(" ", "");
    if ("".equals(number)) {
      throw new IllegalArgumentException("empty string");
    }

    return number;
  }
}
