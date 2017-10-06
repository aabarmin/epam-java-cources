package com.epam.university.java.core.task020;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by Daniil Smirnov on 25.09.2017.
 * All copy registered MF.
 */
public class Task020Impl implements Task020 {

    @Override
    public int calculate(Collection<String> stones) {

        List<String> list = new ArrayList<>();
        list.addAll(stones);
        Set<String> set = new HashSet<>();

        Stream.of(list.get(0).split(""))
                .filter(s -> stones.stream()
                        .allMatch(m -> Pattern.compile(s).matcher(m).find()))
                .forEach(set::add);
        return set.size();
    }
}
