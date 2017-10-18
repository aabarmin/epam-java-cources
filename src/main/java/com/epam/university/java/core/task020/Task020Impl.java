package com.epam.university.java.core.task020;

import java.util.ArrayList;
import java.util.Collection;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        ArrayList<String> list = new ArrayList<>(stones);
        StringBuffer buffer = new StringBuffer();
        for (String element : list) {
            buffer.append(element);
        }
        String allStones = buffer.toString();
        String firstStone = list.get(0);
        int count = 0;
        int check = 0;
        for (int i = 0; i < firstStone.length(); i++) {
            String part = firstStone.substring(i);
            String restStones = allStones.substring(firstStone.length());
            if (restStones.contains(part)) {
                check++;
            }
            if (check == list.size() - 1) {
                count = part.length();
                break;
            }
        }
        return count;
    }
}
