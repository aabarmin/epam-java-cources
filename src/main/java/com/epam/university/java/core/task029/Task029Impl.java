package com.epam.university.java.core.task029;

import java.util.*;

/**
 * Created by Daniil Smirnov on 08.10.2017.
 * All copy registered MF.
 */
public class Task029Impl implements Task029 {

    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        ArrayList<String> AL = new ArrayList<>(rows);


        Map<String, Mark> markMapHorizontal = new HashMap<>();
        Map<String, Mark> markMapVertical = new HashMap<>();


        for (int i = 0; i < AL.size(); i++) {
            String[] strings = AL.get(i).split("");
            String stringI = String.valueOf(i);
            for (int j = 0; j < strings.length; j++) {
                String stringCoordinats = stringI + String.valueOf(j);

                //For horizontal adding
                if (strings[j].equals("-")) {
                    if (AL.size() > i+1) {
                    if (AL.get(i+1).split("")[j].equals("-")) {
                        markMapHorizontal.put(stringCoordinats, new Mark(i, j));
                    } else if (AL.get(i-1).split("")[j].equals("-")) {
                        markMapHorizontal.put(stringCoordinats, new Mark(i, j));
                    }

                    } else if (AL.get(i-1).split("")[j].equals("-")) {
                        markMapHorizontal.put(stringCoordinats, new Mark(i,j));
                    }
                }

                //For vertical adding
                if (strings[j].equals("-")) {
                    if (strings[j+1].equals("-")) {
                        markMapVertical.put(stringCoordinats,new Mark(i,j));
                    } else if (strings[j-1].equals("-")) {
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
                            crossingValues.add(String.valueOf(hor.get(i).getX())+String.valueOf(hor.get(i).getY()));
                        }
                    }
                }
            }
        }


        ArrayList<ArrayList<Mark>> optionsForHorizontalWords = new ArrayList<>();
        ArrayList<ArrayList<Mark>> optionsForVerticalWords = new ArrayList<>();

        ArrayList<String> opFHW = new ArrayList<>();
        ArrayList<String> opFVW = new ArrayList<>();


        for (String word : words) {
            for (int i = 0; i < horizontalWords.size(); i++) {
                if (word.length() == horizontalWords.get(i).size()) {
                    opFHW.add(word);
                }
            }
            for (int i = 0; i < verticalWords.size(); i++) {
                if (word.length() == verticalWords.get(i).size()) {
                    opFVW.add(word);
                }
            }
        }

        //crossingValues.forEach(System.out::println);
        System.out.println(opFHW.size());
        System.out.println(opFVW.size());


/*
        Set<String> st = markMapVertical.keySet();
        ArrayList<String> s = new ArrayList<>(st);
        Collections.sort(s);
        s.forEach(System.out::println);*/

        /*horizontalWords.forEach(marks ->
            marks.forEach(h -> System.out.print(h + " ")));
        System.out.println("");

        System.out.println("-------------------------");

        verticalWords.forEach(marks ->
            marks.forEach(v -> System.out.print(v + " ")));*/

        return null;
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
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Mark mark = (Mark) o;

            if (x != mark.x) return false;
            return y == mark.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "Mark{" +
                    "x=" + x +
                    ", y=" + y +

                    '}';
        }
    }
}
