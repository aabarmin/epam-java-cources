package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * {@inheritDoc}
 */
public class Task029Impl implements Task029 {
    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        ArrayList<Holder> listOfHolders = (ArrayList) Holder.holderBuilder(rows);
        List<String> listOfWords = new ArrayList<>(words);
        listOfHolders.get(0).setWord(listOfWords.remove(0));
        List<Holder> resultList = new ArrayList<>();

        final int width = new ArrayList<String>(rows).get(0).length();
        final int height = rows.size();

        Holder currentHolder = listOfHolders.get(0);
        resultList.add(currentHolder);
        for (int j = 0; j < listOfWords.size(); j++) {
            String tempWord = listOfWords.get(j);
            char[] wordChars = tempWord.toCharArray();
            label:
            for (int k = 0; k < wordChars.length; k++) {
                for (Holder h : listOfHolders) {
                    if (h.hasWord()) {
                        int[] letterCoors = h.getLetterCoors(wordChars[k]);
                        if (letterCoors != null) {
                            Holder temp = holderHasCoords(listOfHolders, letterCoors);
                            if (temp == null) {
                                int[] cordd = h.getLetterCoors(wordChars[k], true);
                                temp = holderHasCoords(listOfHolders, cordd);
                            }
                            if (temp != null && temp.isSuitableWord(tempWord)) {
                                temp.setWord(tempWord);
                                resultList.add(temp);
                                break label;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }


        return resultRows(resultList, width, height);
    }

    /**
     * Some checking.
     *
     * @param list   list of holders
     * @param coords coords to check them
     * @return Holder which has given coords
     */
    private Holder holderHasCoords(List<Holder> list, int[] coords) {
        Holder result = null;
        for (Holder h : list) {
            if (h.hasCoords(coords) && !h.hasWord()) {
                result = h;
            }
        }
        return result;
    }

    /**
     * Getting result array by filling strings in array with letters and pluses.
     *
     * @param holders list of filled holders
     * @param width   width of result array
     * @param height  height of result array
     * @return result list of words and pluses
     */
    private Collection<String> resultRows(Collection<Holder> holders, int width, int height) {
        List<String> mainList = new ArrayList<>();
        char[][] chars = new char[height][width];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                chars[i][j] = '+';
            }
        }
        for (Holder h : holders) {
            h.putMyselfInArr(chars);
        }
        for (int i = 0; i < chars.length; i++) {
            mainList.add(new String(chars[i]));
        }
        return mainList;
    }
}
