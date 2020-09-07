package com.epam.university.java.core.task020;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Task020Impl implements Task020 {

    @Override
    public int calculate(Collection<String> stones) {
        if (stones == null || stones.size() == 0) {
            throw new IllegalArgumentException();
        }
        int commonPartsCounter = 0;
        Set<Character> characterSet = new HashSet<>();
        for (String stone : stones) {
            char[] chars = stone.toCharArray();
            for (char c : chars) {
                characterSet.add(c);
            }
        }

        Iterator<Character> iter = characterSet.iterator();
        while (iter.hasNext()) {
            char c = iter.next();
            int colCounter = 0;
            for (String stone : stones) {
                if (stone.contains(c + "")) {
                    colCounter++;
                }
            }
            commonPartsCounter = colCounter == stones.size()
                    ? commonPartsCounter + 1 : commonPartsCounter;
            colCounter = 0;
        }


        return commonPartsCounter;
    }
}
