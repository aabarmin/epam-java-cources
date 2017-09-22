package com.epam.university.java.core.task008;

import java.util.ArrayList;

/**
 * Created by Вера on 15.09.2017.
 */
public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        if ("".equals(sourceString)) {
            return true;
        } else {
            char[] chars = sourceString.toCharArray();
            ArrayList<Character> stack = new ArrayList<>();
            // пусть indexStack - индекс элементов листа stack
            int indexStack = 0;

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '[' || chars[i] == '{' || chars[i] == '(') {
                    stack.add(chars[i]);
                    indexStack++;
                }
                if ((chars[i] == ']' || chars[i] == '}' || chars[i] == ')') && stack.size() == 0) {
                    return false;
                }
                if (chars[i] == ']') {
                    if (stack.get(indexStack - 1) == '[') {
                        stack.remove(indexStack - 1);
                        indexStack--;
                    } else {
                        return false;
                    }
                }
                if (chars[i] == '}') {
                    if (stack.get(indexStack - 1) == '{') {
                        stack.remove(indexStack - 1);
                        indexStack--;
                    } else {
                        return false;
                    }
                }
                if (chars[i] == ')') {
                    if (stack.get(indexStack - 1) == '(') {
                        stack.remove(indexStack - 1);
                        indexStack--;
                    } else {
                        return false;
                    }
                }
            }

            if (stack.size() == 0) {
                return true;
            } else {
                return false;
            }

        }
    }
}
