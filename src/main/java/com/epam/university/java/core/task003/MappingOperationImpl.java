package com.epam.university.java.core.task003;

/** Created by ilya on 02.09.17. */
public class MappingOperationImpl implements MappingOperation {
  @Override
  public String map(String source) {
    StringBuilder sb = new StringBuilder(source);
    sb.reverse();
    return sb.toString();
  }
}
