package com.epam.university.java.core.task003;

import java.util.*;
import java.util.stream.Collectors;

/** Created by ilya on 02.09.17. */
public class Task003Impl implements Task003 {
  private final NullChecker checker;

  public Task003Impl() {
    this.checker = new SimpleNullChecker();
  }

  @Override
  public String[] invert(String[] source) {
    checker.check(source);

    String[] result = new String[source.length];

    for (int i = 0; i < source.length; i++) {
      result[source.length - i - 1] = source[i];
    }

    return result;
  }

  @Override
  public String[] join(String[] first, String[] second) {
    checker.check(first, second);

    List<String> resultList = new ArrayList<>();
    resultList.addAll(Arrays.asList(first));
    resultList.addAll(Arrays.asList(second));

    return resultList.toArray(new String[0]);
  }

  @Override
  public int findMax(int[] source) {
    checker.check(source);

    return Arrays.stream(source).max().getAsInt();
  }

  @Override
  public String[] filter(String[] source, FilteringCondition condition) {
    checker.check(source, condition);

    List<String> resultList =
        Arrays.stream(source).filter(n -> condition.isValid(n)).collect(Collectors.toList());

    return resultList.toArray(new String[0]);
  }

  @Override
  public String[] removeElements(String[] source, String[] toRemote) {
    checker.check(source, toRemote);

    List<String> resultList =
        Arrays.stream(source)
            .filter(n -> !Arrays.asList(toRemote).contains(n))
            .collect(Collectors.toList());

    return resultList.toArray(new String[0]);
  }

  @Override
  public String[] map(String[] source, MappingOperation operation) {
    checker.check(source, operation);

    List<String> resultList =
        Arrays.stream(source).map(n -> operation.map(n)).collect(Collectors.toList());

    return resultList.toArray(new String[0]);
  }

  @Override
  public String[] flatMap(String[] source, FlatMappingOperation operation) {
    checker.check(source, operation);

    List<String> sourceList =
        Arrays.stream(source)
            .flatMap(p -> Arrays.stream(operation.flatMap(p)))
            .distinct()
            .mapToInt(n -> Integer.parseInt(n))
            .sorted()
            .mapToObj(n -> Integer.toString(n))
            .collect(Collectors.toList());

    return invert(sourceList.toArray(new String[0]));
  }
}
