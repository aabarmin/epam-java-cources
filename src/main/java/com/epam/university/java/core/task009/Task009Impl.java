package com.epam.university.java.core.task009;

import java.io.*;
import java.util.*;

/** Created by ilya on 09.09.17. */
public class Task009Impl implements Task009 {
  @Override
  public Collection<String> countWords(File sourceFile) throws IOException {

    BufferedReader reader = new BufferedReader(new FileReader(sourceFile));

    StringBuilder sb = new StringBuilder();

    Map<String, Integer> result = new HashMap<>();

    //And count of every word too

    while (reader.ready()) {
      sb.append(reader.readLine());
      Map<String, Integer> current =
          Arrays.stream(sb.toString().split("[ ,?;:.!’]+"))
              .map(word -> word.toLowerCase())
              .collect(
                  HashMap<String, Integer>::new,
                  (m, k) -> m.put(k, m.containsKey(k) ? m.get(k) + 1 : 1),
                  HashMap::putAll);
      current.forEach((k, v) -> result.merge(k, v, (v1, v2) -> v1 + v2));
    }

    System.out.println(result);

    return result.keySet();
  }
}
