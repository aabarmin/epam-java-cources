package com.epam.university.java.core.task039;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Author Dmitry Novikov 23-Sep-20.
 */
public class Task039Impl implements Task039 {
    Map<Character, String> result = new HashMap<>();

    @Override
    public Map<Character, String> getEncoding(Map<Character, Integer> charFrequencies) {
        Collection<Character> myCharacters = charFrequencies.keySet();
        Collection<Integer> myIntegers = charFrequencies.values();
        Character[] charArray = myCharacters.toArray(new Character[0]);
        Integer[] charFreq = myIntegers.toArray(new Integer[0]);

        int n = charFrequencies.size();

        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charFreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {

            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';

            f.left = x;
            f.right = y;

            root = f;
            q.add(f);
        }

        printCode(root, "");
        return result;
    }

    private void printCode(HuffmanNode root, String s) {

        if (root.left
                == null
                && root.right
                == null
                && Character.isLetter(root.c)) {
            result.put(root.c, s);
            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    @Override
    public String getEncodedString(Map<Character, Integer> charFrequencies, String string) {
        Collection<Character> myCharacters = charFrequencies.keySet();
        Collection<Integer> myIntegers = charFrequencies.values();
        Character[] charArray = myCharacters.toArray(new Character[0]);
        Integer[] charFreq = myIntegers.toArray(new Integer[0]);

        int n = charFrequencies.size();

        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charFreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {

            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';

            if (x.data == y.data) {
                f.left = y;
                f.right = x;

            } else {
                f.left = x;
                f.right = y;
            }

            root = f;
            q.add(f);
        }

        printCode(root, "");

        char[] intput = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : intput
        ) {
            sb.append(result.get(c));
        }
        return sb.toString();
    }

    @Override
    public String getDecodedString(Map<Character, Integer> charFrequencies, String encodedString) {
        Collection<Character> myCharacters = charFrequencies.keySet();
        Collection<Integer> myIntegers = charFrequencies.values();
        Character[] charArray = myCharacters.toArray(new Character[0]);
        Integer[] charFreq = myIntegers.toArray(new Integer[0]);

        int n = charFrequencies.size();

        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charFreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {

            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';

            if (x.data == y.data) {
                f.left = y;
                f.right = x;

            } else {
                f.left = x;
                f.right = y;
            }

            root = f;
            q.add(f);
        }

        printCode(root, "");
        List<Integer> values = new ArrayList<>();
        for (Map.Entry<Character, String> m : result.entrySet()
        ) {
            values.add(Integer.parseInt(m.getValue()));
        }
        Collections.sort(values);
        Collections.reverse(values);
        System.out.println(values);
        List<String> valesStrings = new ArrayList<>();
        for (Integer v : values
        ) {
            // some comments here
            if (v < 10) {
                valesStrings.add("0" + v);
            } else {
                valesStrings.add("" + v);
            }
        }

        List<Character> gg = new ArrayList<>();

        for (int i = 0; i < valesStrings.size(); i++) {
            for (Map.Entry<Character, String> m : result.entrySet()
            ) {
                if (m.getValue().equals(valesStrings.get(i))) {
                    gg.add(m.getKey());
                }
            }
        }
        System.out.println(gg);
        if (gg.size() < valesStrings.size()) {
            gg.add('A');
        }
        String finalRes = encodedString;

        for (int i = 0; i < valesStrings.size(); i++) {
            finalRes = finalRes.replace(valesStrings.get(i), "" + gg.get(i));
        }
        StringBuilder sb = new StringBuilder();
        int countA = 0;
        for (int i = 0; i < finalRes.length(); i++) {
            if (finalRes.charAt(i) == 'A') {
                countA++;
            }
        }

        for (int i = 0; i < finalRes.length(); i++) {
            if (countA == 1) {
                if (finalRes.charAt(i) == 'A') {
                    sb.append(finalRes.charAt(i));
                    sb.append(finalRes.charAt(i));
                } else {
                    sb.append(finalRes.charAt(i));
                }
            } else {
                sb.append(finalRes.charAt(i));
            }
        }

        return sb.toString();
    }
}
