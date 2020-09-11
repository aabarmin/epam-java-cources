package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;

public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {

        ArrayList<String> list = new ArrayList<>();

        char[] chars = source.toCharArray();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                sb.append(chars[i]);
                continue;
            }
            if (Character.isUpperCase(chars[i])) {
                list.add(sb.toString().toLowerCase());
                sb.delete(0, sb.length());
                sb.append(chars[i]);
            }
            if (Character.isLowerCase(chars[i])) {
                sb.append(chars[i]);
            }
            if (i == chars.length - 1){
                list.add(sb.toString().toLowerCase());
            }
        }


        return list;
    }
}
