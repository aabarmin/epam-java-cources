package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Entity which hold lines and words with it.
 */
public class Holder {
    private int[] xCoords;
    private int[] yCoords;


    public char[] getWordInCharArr() {
        return word.toCharArray();
    }

    private String word;

    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Constructor.
     *
     * @param xCoords array x coordinates
     * @param yCoords array y coordinates
     */
    public Holder(int[] xCoords, int[] yCoords) {
        this.xCoords = xCoords;
        this.yCoords = yCoords;
    }

    /**
     * Get coords of letter.
     *
     * @param letter given letter
     * @return array of x y coords
     */
    public int[] getLetterCoors(char letter) {
        int[] coords = null;
        if (word.indexOf(letter) < 0) {
            return coords;
        }

        coords = new int[2];
        coords[0] = xCoords[word.indexOf(letter)];
        coords[1] = yCoords[word.indexOf(letter)];
        return coords;
    }

    /**
     * Another method for getting coords of letter.
     * Honestly just Kostyl.
     *
     * @param letter given letter
     * @param end    magic key
     * @return array of x y coords
     */
    public int[] getLetterCoors(char letter, boolean end) {
        int[] coords = null;
        if (word.indexOf(letter) < 0) {
            return coords;
        }

        coords = new int[2];
        coords[0] = xCoords[word.lastIndexOf(letter)];
        coords[1] = yCoords[word.lastIndexOf(letter)];
        return coords;
    }

    /**
     * Check if word can be put in line.
     *
     * @param word given word
     * @return true if line has word
     */
    public boolean isSuitableWord(String word) {
        if (word.length() == xCoords.length) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * check if line has word.
     *
     * @return true if has or flase if not
     */
    public boolean hasWord() {
        return word != null;
    }

    /**
     * Check if line has given coords.
     *
     * @param coords given coords
     * @return true if has or false if not
     */
    public boolean hasCoords(int[] coords) {
        boolean x = false;
        boolean y = false;
        for (int i = 0; i < xCoords.length; i++) {
            if (xCoords[i] == coords[0]) {
                x = true;
            }
            if (yCoords[i] == coords[1]) {
                y = true;
            }

        }
        return x && y;
    }

    /**
     * Build skelet of crossword without word by given strings.
     *
     * @param rows given list of string with pluses and minuses
     * @return collection of lines with coords with minuses
     */
    public static Collection<Holder> holderBuilder(Collection<String> rows) {
        List<Holder> holders = new ArrayList<>();
        List<String> listOfRows = new ArrayList<>(rows);
        //check vertical first
        for (int x = 0; x < listOfRows.get(0).length(); x++) {
            List<Integer> xCor = new ArrayList<>();
            List<Integer> yCor = new ArrayList<>();

            for (int y = 0; y < listOfRows.size(); y++) {
                char minus = listOfRows.get(y).charAt(x);
                if (minus == '-') {
                    xCor.add(x);
                    yCor.add(y);
                } else if (yCor.size() == 1) {
                    xCor.removeAll(xCor);
                    yCor.removeAll(yCor);
                    continue;
                }
            }
            if (xCor.size() > 1) {
                int[] xTemp = xCor.stream().mapToInt(i -> i).toArray();
                int[] yTemp = yCor.stream().mapToInt(i -> i).toArray();
                Holder holder = new Holder(xTemp, yTemp);
                holders.add(holder);
            }
        }
        //check horizontally
        for (int x = 0; x < listOfRows.get(0).length(); x++) {
            List<Integer> xCor = new ArrayList<>();
            List<Integer> yCor = new ArrayList<>();

            for (int y = 0; y < listOfRows.size(); y++) {
                char minus = listOfRows.get(x).charAt(y);
                if (minus == '-') {
                    xCor.add(y);
                    yCor.add(x);
                } else if (xCor.size() > 0) {
                    break;
                }
            }
            if (xCor.size() > 1) {
                int[] xTemp = xCor.stream().mapToInt(i -> i).toArray();
                int[] yTemp = yCor.stream().mapToInt(i -> i).toArray();
                Holder holder = new Holder(xTemp, yTemp);
                holders.add(holder);
            }
        }
        return holders;
    }

    /**
     * Lines goes to arrays for beauty.
     *
     * @param result place to put all words
     * @return given array but with words
     */
    public char[][] putMyselfInArr(char[][] result) {
        for (int y = 0; y < word.length(); y++) {
            result[yCoords[y]][xCoords[y]] = word.charAt(y);
        }
        return result;
    }
}
