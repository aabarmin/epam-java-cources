package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;

public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {

        if (sourceString == null) {
            throw new IllegalArgumentException();
        }


        ArrayList<Integer> list = new ArrayList<>();
        if (sourceString.length() < 2) {
            return list;
        }

//        char[] chars = sourceString.toCharArray();

//        StringBuilder sb = new StringBuilder("");
        /*for (int i = 1; i < sourceString.length(); i++) {
            if (i == 1) {
                sb.append(chars[i - 1]);
                first = Integer.parseInt(sb.toString());
                sb.delete(0, sb.length());
                sb.append(chars[i]);
                second = Integer.parseInt(sb.toString());
                continue;
            }
            if (second - first == 1) {
                if (!list.contains(first)) {
                    list.add(first);
                }
                list.add(second);
                first = second;
                sb.delete(0, sb.length());
                sb.append(chars[i]);
                second = Integer.parseInt(sb.toString());
                if (i == sourceString.length() - 1){
                    if (second - first == 1) {
                        if (!list.contains(first)) {
                            list.add(first);
                        }
                        list.add(second);
                        first = second;
                    }
                }

                continue;
            }
            if (first > second) {
                sb.delete(0, sb.length());
                sb.append(second);
                sb.append(chars[i]);
                second = Integer.parseInt(sb.toString());
            } else {
                sb.delete(0, sb.length());
                sb.append(first);
                sb.append(second);
                first = Integer.parseInt(sb.toString());
                sb.delete(0, sb.length());
                sb.append(chars[i]);
                second = Integer.parseInt(sb.toString());
            }


        }*/
        int firstBegin = 0;
        int firstEnd = 1;
        int secondBegin = 1;
        int secondEnd = 2;

        int first;
        int second;

        for (int i = 1; i < sourceString.length(); i++) {
            first = Integer.parseInt(sourceString.substring(firstBegin, firstEnd).trim());
            second = Integer.parseInt(sourceString.substring(secondBegin, secondEnd).trim());

            if (first == 0){
                return list;
            }
            if (second - first == 1) {
                if (!list.contains(first)) {
                    list.add(first);
                }
                list.add(second);
                firstBegin = secondBegin;
                firstEnd = secondEnd;
                secondBegin = secondEnd;
                secondEnd = secondEnd + 1;
                continue;
            }

            if (first > second) {
                if (second == 0) {
                    firstEnd++;
                    secondBegin++;
                    secondEnd++;
                } else {
                    secondEnd++;
                }
            } else {
                secondBegin++;
                secondEnd++;
                firstEnd++;

            }


        }
        String str = "";
        for (Integer num : list) {
            str += num;
        }
        if (str.length() != sourceString.length()) {
            return new ArrayList<Integer>();
        }

        return list;
    }
}
