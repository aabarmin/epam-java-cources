package com.epam.university.java.core.task027;

import com.epam.university.java.core.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public class Task027Impl implements Task027 {
    private Validator validator = Validator.getInstance();

    @Override
    public Collection<Integer> extract(String sourceString) {
        validator.validate(sourceString);
        final int delta = 1;
        final List<Integer> result = new ArrayList<>();
        if ("0".equals(sourceString.substring(0, 1))) {
            return result;
        }
        final List<Pair<Integer, Integer>> borders = new ArrayList<>();
        int startPos = 0;
        int numOfDigits = 1;
        Pair<Integer, Integer> first = new Pair<>(startPos, startPos + numOfDigits);
        startPos += numOfDigits;
        while (startPos + numOfDigits <= sourceString.length()) {
            Pair<Integer, Integer> second = new Pair<>(startPos, startPos + numOfDigits);
            int currentDelta = getNumber(sourceString, second) - getNumber(sourceString, first);
            if (currentDelta == delta
                    && checkForFirstZero(sourceString, second)
                    && checkForFirstZero(sourceString, first)) {
                borders.add(first);
                borders.add(second);
                first = second;
                startPos += numOfDigits;
            } else {
                if ((first.getFirst() == 0) && getSize(first) < getSize(second)) {
                    first = new Pair<>(0, numOfDigits);
                    startPos = numOfDigits;
                } else {
                    numOfDigits++;
                }
            }
        }
        if (!borders.isEmpty() && borders.get(borders.size() - 1).getSecond()
                == sourceString.length()) {

            for (Pair<Integer, Integer> pair : new LinkedHashSet<>(borders)) {
                result.add(Integer
                        .valueOf(sourceString
                                .substring(pair.getFirst(),
                                        pair.getSecond())));
            }
        }
        return result;
    }

    /**
     * Parsing part of string to int.
     *
     * @param source String from func will cut char to parse to Integer
     * @param pair   contains pointers on which the number will be cut from string
     *               first - include, second - exclude
     * @return int  the number in the line bordered by the pointers
     */
    private static int getNumber(String source, Pair<Integer, Integer> pair) {
        return Integer.valueOf((source.substring(pair.getFirst(), pair.getSecond())));
    }

    private static boolean checkForFirstZero(String source, Pair<Integer, Integer> pair) {
        return (!"0".equals(source.substring(pair.getFirst(), pair.getFirst() + 1)));
    }

    /**
     * Calculate diff of pointers in pair.
     *
     * @param pair contains pointers
     * @return int  diff of pointers in pair
     */
    private static int getSize(Pair<Integer, Integer> pair) {
        return pair.second - pair.first;
    }

    /**
     * immutable container for pair of something.
     */
    class Pair<T, H> {
        private final T first;
        private final H second;

        private Pair(T first, H second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public H getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair<?, ?> pair = (Pair<?, ?>) o;

            return (first != null ? first.equals(pair.first)
                    : pair.first == null)
                    && (second != null
                    ? second.equals(pair.second)
                    : pair.second == null);
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }
    }
}
