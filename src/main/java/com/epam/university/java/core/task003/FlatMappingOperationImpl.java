package com.epam.university.java.core.task003;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        if (source == null) {
            return new String[0];
        }
        char[] chars = source.toCharArray();
        LinkedList<String> list = new LinkedList<>();
        String str = "";
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                str += chars[i];
            } else {
                if (!list.contains(str) && !str.isEmpty()) {
                    list.add(str);
                }
                str = "";
            }
        }


        LinkedList<Integer> nums = new LinkedList<>();
        for (String sNum: list) {
            nums.add(Integer.parseInt(sNum));
        }
        Collections.sort(nums);
        Collections.reverse(nums);
        String[] lines = new String[list.size()];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = nums.get(i).toString();
        }

        return lines;
    }
}
