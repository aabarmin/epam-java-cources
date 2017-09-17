package com.epam.university.java.core.task002;

/**
 * Created by Doomsday Device on 17.09.2017.
 * * <p>
 *     Task002
 *  </p>
 */
public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            throw new IllegalArgumentException();
        }

        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }

        if (number > sourceString.length()) {
            return sourceString;
        }
        return sourceString.subSequence(0, number).toString();
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        String[] destString = sourceString.split(separator);

        return destString[0];
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }

        if (number > sourceString.length()) {
            return sourceString;
        }

        int sourceStrLen = sourceString.length();

        return sourceString.subSequence(sourceStrLen - number, sourceStrLen).toString();
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        String[] destString = sourceString.split(separator);

        return destString[1];
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        String[] destString = sourceString.split(split);

        return destString;
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null) {
            throw new IllegalArgumentException();
        }

        String destCollection = "";
        int i = 0;
        while (i < sourceCollection.length) {
            destCollection += sourceCollection[i];
            i++;
            if (i < sourceCollection.length) {
                destCollection += glue;
            }
        }
        return destCollection;
    }
}
