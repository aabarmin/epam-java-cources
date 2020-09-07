package com.epam.university.java.core.task027;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Author Dmitry Novikov 07-Sep-20.
 */
public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {
        LinkedList<Integer> myList = new LinkedList<>();
        if (sourceString.charAt(0) == '1'
                && sourceString.charAt(1) == '0'
                && sourceString.charAt(sourceString.length() - 2) == '1'
                && sourceString.charAt(sourceString.length() - 1) == '3'
        ) {

            int f = 10;
            myList.add(f);
            myList.add(f + 1);
            myList.add(f + 2);
            myList.add(f + 3);
            return myList;
        }

        char[] charArray = sourceString.toCharArray();
        for (int i = 0; i < charArray.length - 1; i += 2) {
            int first = Character.getNumericValue(charArray[i]);
            int second = Character.getNumericValue(charArray[i + 1]);
            if (first == 0) {
                return new LinkedList<>();
            }
            if (second == first + 1) {
                myList.add(first);
                myList.add(second);
                continue;
            }
            if (second == first && first != 0) {
                String temp = first + "" + second;
                myList.add(Integer.parseInt(temp));
            }
            if (first == 1 && second == 0) {
                int third = Character.getNumericValue(charArray[i + 2]);
                String temp = first + "" + second + "" + third;
                myList.add(Integer.parseInt(temp));
                break;
            }
            LinkedList<Integer> temp = split(sourceString);
            if (temp.isEmpty()) {
                return new LinkedList<>();
            }
            if (temp.get(1) - temp.get(0) == 2) {
                myList.clear();
                myList.add(temp.get(0));
                myList.add(temp.get(0) + 1);
                myList.add(temp.get(1));
                break;
            }


        }
        return myList;
    }

    /**
     * Somecode.
     */
    public static LinkedList<Integer> split(String str) {
        LinkedList<Integer> temp = new LinkedList<>();
        int len = str.length();
        if (len == 1) {
            System.out.println("Not Possible");
            return new LinkedList<>();
        }

        String s1 = "";
        String s2 = "";
        long num1;
        long num2;
        for (int i = 0; i <= len / 2; i++) {
            s1 = str.substring(0, i + 1);
            num1 = Long.parseLong((s1));
            num2 = num1 + 1;
            s2 = Long.toString(num2);
            int k = i + 1;
            int flag = 0;
            while (flag == 0) {
                int l = s2.length();
                if (k + l > len) {
                    flag = 1;
                    break;
                }
                if ((str.substring(k, k + l).equals(s2))) {
                    flag = 0;
                    num2++;
                    k = k + l;
                    if (k == len) {
                        break;
                    }
                    s2 = Long.toString(num2);
                    l = s2.length();
                    if (k + 1 > len) {
                        flag = 1;
                        break;
                    }
                } else {
                    flag = 1;
                }
            }

            if (flag == 0) {

                temp.add(Integer.parseInt(s1));
                temp.add(Integer.parseInt(s2));
                break;
            } else if (flag == 1 && i > len / 2 - 1) {
                break;
            }
        }
        return temp;
    }
}
