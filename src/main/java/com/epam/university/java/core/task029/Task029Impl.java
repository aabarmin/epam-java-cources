package com.epam.university.java.core.task029;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Daniil Smirnov on 08.10.2017.
 * All copy registered MF.
 */
public class Task029Impl implements Task029 {

    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        ArrayList<String> arrayList = new ArrayList<>(rows);

        Map<String, Mark> markMapHorizontal = new HashMap<>();
        Map<String, Mark> markMapVertical = new HashMap<>();


        for (int i = 0; i < arrayList.size(); i++) {
            String[] strings = arrayList.get(i).split("");
            String stringI = String.valueOf(i);
            for (int j = 0; j < strings.length; j++) {
                String stringCoordinats = stringI + String.valueOf(j);

                //For horizontal adding
                if (strings[j].equals("-")) {
                    if (arrayList.size() > i + 1) {
                        if (arrayList.get(i + 1).split("")[j].equals("-")) {
                            markMapHorizontal.put(stringCoordinats, new Mark(i, j));
                        } else if (arrayList.get(i - 1).split("")[j].equals("-")) {
                            markMapHorizontal.put(stringCoordinats, new Mark(i, j));
                        }
                    } else if (arrayList.get(i - 1).split("")[j].equals("-")) {
                        markMapHorizontal.put(stringCoordinats, new Mark(i,j));
                    }
                }

                //For vertical adding
                if (strings[j].equals("-")) {
                    if (strings[j + 1].equals("-")) {
                        markMapVertical.put(stringCoordinats,new Mark(i,j));
                    } else if (strings[j - 1].equals("-")) {
                        markMapVertical.put(stringCoordinats,new Mark(i,j));
                    }
                }
            }
        }

        ArrayList<ArrayList<Mark>> horizontalWords = new ArrayList<>();
        ArrayList<ArrayList<Mark>> verticalWords = new ArrayList<>();

        Set<String> strings = markMapHorizontal.keySet();
        ArrayList<String> sorted = new ArrayList<>(strings);
        Collections.sort(sorted);

        //Filtration for horizontal words
        for (int i = 0; i < 10; i++) {
            ArrayList<Mark> marks = new ArrayList<>();
            for (String s : sorted) {
                String[] split = s.split("");
                if (split[1].equals(String.valueOf(i))) {
                    marks.add(markMapHorizontal.get(s));
                }
            }
            if (!marks.isEmpty()) {
                horizontalWords.add(marks);
            }
        }

        strings = markMapVertical.keySet();
        sorted = new ArrayList<>(strings);
        Collections.sort(sorted);

        //Filtration for vertical words
        for (int i = 0; i < 10; i++) {
            ArrayList<Mark> marks = new ArrayList<>();
            for (String s : sorted) {
                String[] split = s.split("");
                if (split[0].equals(String.valueOf(i))) {
                    marks.add(markMapVertical.get(s));
                }
            }
            if (!marks.isEmpty()) {
                verticalWords.add(marks);
            }
        }

        ArrayList<String> crossingValues = new ArrayList<>();

        //Where cross words
        for (ArrayList<Mark> hor : horizontalWords) {
            for (ArrayList<Mark> ver : verticalWords) {
                for (int i = 0; i < hor.size(); i++) {
                    for (int j = 0; j < ver.size(); j++) {
                        if (hor.get(i).equals(ver.get(j))) {
                            crossingValues.add(String.valueOf(hor.get(i).getX())
                                    + String.valueOf(hor.get(i).getY()));
                        }
                    }
                }
            }
        }

        //Check what words can be apply for horizontal fields.
        ArrayList<ArrayList<String>> optionsForHorizontalWords =
                checkWordsCanBeApply(horizontalWords,words);

        //Check what words can be apply for vertical fields.
        ArrayList<ArrayList<String>> optionsForVerticalWords =
                checkWordsCanBeApply(verticalWords,words);

        //Mark values that have only one option (Horizontal).
        for (int i = 0; i < optionsForHorizontalWords.size(); i++) {
            markToCollection(arrayList,optionsForHorizontalWords,horizontalWords);
        }

        //Mark values that have only one option (Vertical).
        for (int i = 0; i < optionsForVerticalWords.size(); i++) {
            markToCollection(arrayList,optionsForVerticalWords,verticalWords);
        }

        //Check for crossing values
        for (int i = 0; i < crossingValues.size(); i++) {
            String[] split = crossingValues.get(i).split("");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            String s = arrayList.get(x);
            String[] find = s.split("");
            String point = find[y];


            for (int j = 0; j < optionsForHorizontalWords.size(); j++) {

                if (optionsForHorizontalWords.get(j).size() == 2) {

                    String[] splitedHorizont = optionsForHorizontalWords.get(j).get(0).split("");

                    if (x < splitedHorizont.length) {
                        if (splitedHorizont[x].equals(point)) {
                            String removingString = optionsForHorizontalWords.get(j).get(0);
                            optionsForHorizontalWords.get(j).remove(1);
                            markToCollection(arrayList, optionsForHorizontalWords, horizontalWords);

                            for (int k = 0; k < optionsForVerticalWords.size(); k++) {
                                if (optionsForVerticalWords.get(k).size() == 2) {
                                    optionsForVerticalWords.get(k).remove(removingString);
                                    markToCollection(arrayList,
                                            optionsForVerticalWords,
                                            verticalWords);
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private ArrayList<ArrayList<String>> checkWordsCanBeApply(
            ArrayList<ArrayList<Mark>> pozitionWords,
            Collection<String> words) {

        ArrayList<ArrayList<String>> options = new ArrayList<>();
        for (int i = 0; i < pozitionWords.size(); i++) {
            ArrayList<String> opFpw = new ArrayList<>();
            for (String word : words) {
                if (word.length() == pozitionWords.get(i).size()) {
                    opFpw.add(word);
                }
            }
            if (!opFpw.isEmpty()) {
                options.add(opFpw);
            }
        }
        return options;
    }

    private void markToCollection(ArrayList<String> arrayList,
                                  ArrayList<ArrayList<String>> optionsForWords,
                                  ArrayList<ArrayList<Mark>> pozitionWords) {

        for (int i = 0; i < optionsForWords.size(); i++) {

            if (optionsForWords.get(i).size() == 1) {
                ArrayList<Mark> marks = pozitionWords.get(i);
                String[] toMark = optionsForWords.get(i).get(0).split("");
                for (int j = 0; j < marks.size(); j++) {
                    String s = arrayList.get(marks.get(j).getX());
                    String[] split = s.split("");
                    split[marks.get(j).getY()] = toMark[j];
                    marks.get(j).setWord(toMark[j]);
                    StringBuilder sb = new StringBuilder("");
                    for (int k = 0; k < split.length; k++) {
                        sb.append(split[k]);
                    }
                    arrayList.set(marks.get(j).getX(),sb.toString());
                }
                optionsForWords.get(i).remove(0);
            }
        }
    }

    private class Mark {

        private int x;
        private int y;
        private String word;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public Mark(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Mark mark = (Mark) o;

            if (x != mark.x) {
                return false;
            }
            return y == mark.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
