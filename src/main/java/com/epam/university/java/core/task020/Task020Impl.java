package com.epam.university.java.core.task020;

import java.util.*;
import java.util.stream.IntStream;

public class Task020Impl implements Task020 {

    @Override
    public int calculate(Collection<String> stones) {

        if (stones == null || stones.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<String> list = new ArrayList<String>(stones);
        int gems = 0;
        String firstStone = deleteDuplicates(list.get(0));
        for (int i = 0; i < firstStone.length(); i++) {
            char charOfFirstStone = firstStone.charAt(i);
            int result = 0;
            for (int j = 1; j < list.size(); j++) {
                String currentStone = deleteDuplicates(list.get(j));
                if (currentStone.indexOf(charOfFirstStone) != -1) {
                    result++;
                }
            }
            if (result == list.size() - 1) {
                gems++;
            }
        }
        return gems;
    }

    /**
     * Delete duplicates characters
     *
     * @param string with duplicates
     * @return new string without duplicates
     */
    public String deleteDuplicates(String string) {
        Set<Character> charSet = new HashSet<>();
        char[] charArrayInput = string.toCharArray();
        for (Character character : charArrayInput) {
            charSet.add(character);
        }
        Object[] charArrayOutput = charSet.toArray();
        StringBuilder result = new StringBuilder();
        for (Object obj : charArrayOutput) {
            result.append(obj);
        }
        return result.toString();
    }
}

