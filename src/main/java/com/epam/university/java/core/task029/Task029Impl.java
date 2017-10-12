package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Task029Impl implements Task029 {
    public enum Direction {
        RIGHT,
        DOWN
    }

    private class WordPlace {
        public int index;
        public int row;

        public WordPlace(int index, int row) {
            this.index = index;
            this.row = row;
        }
    }

    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {

        for (String word: words) {
            Collection<String> newRows = addWord( rows, word);
            if (words.size()!=1) {
                if (newRows!=null) {
                    Collection<String> newWords = new ArrayList<>(words);
                    newWords.remove(word);
                   return fillCrossword(newRows, newWords);
                }
            }
            else {
                return rows;
            }
        }


        return rows;
    }



    public boolean canAddWordHorizontally(String row, String word, WordPlace place) {
        CharSequence rowSequence = row.subSequence(place.index,place.index+word.length());


        int wordIndex = 0;
        while (wordIndex < rowSequence.length() && wordIndex < word.length()) {
            if (rowSequence.charAt(wordIndex) != '-' && rowSequence.charAt(wordIndex) != word.charAt(wordIndex)) {
                return false;
            }

            wordIndex++;

        }
        return true;
    }
    public boolean canAddWordVertically(ArrayList<String> rows, String word, WordPlace place) {
        int rowIndex = place.row;
        int wordIndex = 0;
        int inRowIndex = place.index;

        while (rowIndex < rows.size() && wordIndex < word.length()) {
            if (rows.get(rowIndex).charAt(inRowIndex) != '-' && rows.get(rowIndex).charAt(inRowIndex) != word.charAt(wordIndex)) {
                return false;
            }
            rowIndex++;
            wordIndex++;
            }

        return true;
    }

    public Collection<String> addWord(Collection<String> rows, String word) {
        ArrayList<String> rowsArr =  new ArrayList(rows);
        Iterator<String> iterator = rows.iterator();
        int index = 0;
        int rowNumber = -1;

        ArrayList<WordPlace> variants = new ArrayList<>();

            while (iterator.hasNext()) {
                String row = iterator.next();
                rowNumber++;
                for (int i = 0; i < row.length(); i++) {
                    if (row.charAt(i) != '+') {

                        if (canAddWordHorizontally(row, word, new WordPlace(i, rowNumber))) {
                            byte[] bytes = row.getBytes();
                            for (int j = i; j < i + word.length(); j++) {
                                bytes[j] = (byte) word.charAt(j - i);
                            }
                            // rowsArr.remove(row);
                            rowsArr.add(rowNumber, new String(bytes));
                            return rowsArr;
                        }

                        byte[] bytes = row.getBytes();
                        if (canAddWordVertically(rowsArr, word, new WordPlace(i, rowNumber))) {
                            for (int j = rowNumber; j < rowNumber + word.length(); j++) {
                                String curRow = rowsArr.get(rowNumber);
                                byte[] rowBytes = curRow.getBytes();
                                rowBytes[i] = (byte) word.charAt(j-rowNumber);
                                rowsArr.add(rowNumber, new String(rowBytes));
                            }
                            return rowsArr;
                        }
                    }
                }


                rowNumber++;
            }



        return null;
    }
}
