package com.epam.university.java.core.task008;

import java.util.ArrayList;

public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        if (sourceString.isEmpty()) {
            return true;
        }
        char[] chars = sourceString.toCharArray();
        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                list.add(chars[i]);
            }
            if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
                if (list.size() == 0) {
                    return false;
                }
                switch (chars[i]) {
                    case ')':
                        if (!(list.get(list.size() - 1) == '(')) {
                            return false;
                        } else {
                            list.remove(list.size() - 1);
                        }
                        break;
                    case '}':
                        if (!(list.get(list.size() - 1) == '{')) {
                            return false;
                        } else {
                            list.remove(list.size() - 1);
                        }
                        break;
                    case ']':
                        if (!(list.get(list.size() - 1) == '[')) {
                            return false;
                        } else {
                            list.remove(list.size() - 1);
                        }
                        break;
                }
            }
        }
        if (list.size() != 0) {
            return false;
        }
        return true;
    }
}
