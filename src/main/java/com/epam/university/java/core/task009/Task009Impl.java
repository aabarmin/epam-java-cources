package com.epam.university.java.core.task009;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
