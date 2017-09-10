package com.epam.university.java.core.task005;

/** Created by ilya on 04.09.17. */
public class PiHolderImpl implements PiHolder {
  private final int first;
  private final int second;
  private final double difference;

  public PiHolderImpl(int first, int second, double difference) {
    this.first = first;
    this.second = second;
    this.difference = difference;
  }

  @Override
  public int getFirst() {
    return first;
  }

  @Override
  public int getSecond() {
    return second;
  }

  public double getDifference() {
    return difference;
  }
}
