package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Collection;

public class Task007Impl implements Task007 {

    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {
        class ValueX {
            private int rank;

            private ValueX(int rank) {
                this.rank = rank;
            }
        }

        ArrayList<ValueX> firstList = new ArrayList<>();
        int maxRankFirst = first.size() - 1;
        for (Integer integer : first) {
            int countX = integer;
            for (int i = 0; i < countX; i++) {
                firstList.add(new ValueX(maxRankFirst));
            }
            maxRankFirst--;
        }

        ArrayList<ValueX> secondList = new ArrayList<>();
        int maxRankSecond = second.size() - 1;
        for (Integer integer : second) {
            int countX = integer;
            for (int i = 0; i < countX; i++) {
                secondList.add(new ValueX(maxRankSecond));
            }
            maxRankSecond--;
        }

        ArrayList<ValueX> allValues = new ArrayList<>();
        for (ValueX valueFirstX : firstList) {
            for (ValueX valueSecondX : secondList) {
                int rankX1 = valueFirstX.rank;
                int rankX2 = valueSecondX.rank;
                allValues.add(new ValueX(rankX1 + rankX2));
            }
        }

        int maxRank = 0;
        for (ValueX valueX : allValues) {
            int rank = valueX.rank;
            if (rank > maxRank) {
                maxRank = rank;
            }
        }

        int[] result = new int[maxRank + 1];
        for (ValueX valueX : allValues) {
            int position = maxRank - valueX.rank;
            int count = result[position];
            result[position] = ++count;
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for (Integer integer : result) {
            resultList.add(integer);
        }

        return resultList;
    }
}
