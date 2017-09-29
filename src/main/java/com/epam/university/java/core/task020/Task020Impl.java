package com.epam.university.java.core.task020;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        return stones.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char) c))
                .collect(HashMap::new, (m, c) -> m.put(c, m.containsKey(c)
                        ? ((int) m.get(c) + 1) : 1), HashMap::putAll)
                .entrySet()
                .stream()
                .filter(i -> (int) i.getValue() == stones.size())
                .map(Map.Entry::getKey)
                .collect(ArrayList::new, ArrayList::add,
                        ArrayList::addAll).size();
    }
}
