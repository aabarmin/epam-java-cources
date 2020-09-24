package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Task029Impl implements Task029 {
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        if (rows == null || words == null){
            throw new IllegalArgumentException();
        }
        ArrayList<String> crossWord = new ArrayList<>(rows);

        LinkedList<String> cities = new LinkedList<>(words);


        char[][] points = new char[10][10];

        for (int i = 0; i < 10; i++) {
            String line = crossWord.get(i);
            char[] lineChars = line.toCharArray();
            for (int j = 0; j < 10; j++) {
                points[i][j] = lineChars[j];
            }
        }

        LinkedList<Integer> verticalWords = countVerticalWords(points);
        LinkedList<Integer> horizontalWords = countHorizontalWords(points);


        boolean vertical = true;
        for (int i = 0; i < cities.size(); i++) {
            char[] city = cities.get(i).toCharArray();

            int beginLineIndex = 0;
            int beginRawIndex = 0;

            if (verticalWords.size() != 0 && city.length == verticalWords.get(0)) {
                beginLineIndex = verticalWords.get(1);
                beginRawIndex = verticalWords.get(2);
                verticalWords.remove(0);
                verticalWords.remove(0);
                verticalWords.remove(0);
                vertical = true;
            } else if (city.length == horizontalWords.get(0)) {
                beginLineIndex = horizontalWords.get(1);
                beginRawIndex = horizontalWords.get(2);
                horizontalWords.remove(0);
                horizontalWords.remove(0);
                horizontalWords.remove();
                vertical = false;
            }

            for (int j = 0; j < city.length; j++) {
                points[beginLineIndex][beginRawIndex] = city[j];
                if (vertical) {
                    beginLineIndex++;
                } else {
                    beginRawIndex++;
                }
            }
        }

        crossWord = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            char[] buf = new char[10];
            for (int j = 0; j < 10; j++) {
                buf[j] = points[i][j];
            }
            crossWord.add(new String(buf));
        }
        return crossWord;
    }

    private LinkedList<Integer> countVerticalWords(char[][] points) {

        LinkedList<Integer> list = new LinkedList<>();
        int length;
        int beginLineIndex;
        int beginRawIndex;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 9; i++) {
                boolean found = false;
                if (points[i][j] == '-' && points[i + 1][j] == '-') {
                    length = 0;
                    beginLineIndex = i;
                    beginRawIndex = j;
                    while (points[i][j] != '+' || i == 10) {
                        found = true;
                        i++;
                        length++;
                        if (i > 9) {
                            break;
                        }
                    }
                    if (found) {
                        list.add(length);
                        list.add(beginLineIndex);
                        list.add(beginRawIndex);

                    }
                }
            }
        }
        return list;
    }

    private LinkedList<Integer> countHorizontalWords(char[][] points) {


        LinkedList<Integer> list = new LinkedList<>();
        int length;
        int beginRowIndex;
        int beginLineIndex;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boolean found = false;
                if (points[i][j] == '-' && points[i][j + 1] == '-') {
                    length = 0;
                    beginLineIndex = i;
                    beginRowIndex = j;
                    while (points[i][j] != '+' || j == 10) {
                        found = true;
                        j++;
                        length++;
                    }
                    if (found) {
                        list.add(length);
                        list.add(beginLineIndex);
                        list.add(beginRowIndex);
                    }
                }
            }
        }
        return list;
    }
}
