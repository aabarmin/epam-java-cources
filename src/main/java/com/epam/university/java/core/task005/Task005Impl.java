package com.epam.university.java.core.task005;

import static java.lang.Math.PI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/** Created by ilya on 04.09.17. */
public class Task005Impl implements Task005 {

  @Override
  public PiHolder findPi(int digits) {
    int[] range = getArrayFromDigits(digits);

    Optional<PiHolderImpl> min =
        Arrays.stream(range)
            .mapToObj(
                n ->
                    new PiHolderImpl(
                        n, (int) (n / PI) + 1, Math.abs(PI - (double) n / ((int) (n / PI) + 1))))
            .flatMap(
                n ->
                    Stream.of(
                        n,
                        new PiHolderImpl(
                            n.getFirst(),
                            n.getSecond() - 1,
                            Math.abs(PI - (double) n.getFirst() / (n.getSecond() - 1)))))
            .min(Comparator.comparingDouble(n -> n.getDifference()));

    return min.get();
  }

  private int[] getArrayFromDigits(int digits) {
    int first;
    int last;
    if (digits < 10 && digits > 0) {
      first = (int) ((Math.pow(10, digits) - 1) / Math.PI);
      last = (int) (Math.pow(10, digits) - 1);
    } else if (digits == 10) {
      first = (int) (Integer.MAX_VALUE / Math.PI);
      last = Integer.MAX_VALUE;
    } else {
      throw new IllegalArgumentException("incorrect value");
    }

    int[] range = new int[last - first + 1];
    for (int i = first; i <= last; i++) {
      range[i - first] = i;
    }

    return range;
  }
}
