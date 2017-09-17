package com.epam.university.java.core.task002;

/**
 * Class for different operations with Strings.
 * Task002 implementation.
 */
public final class Task002Impl implements Task002 {

    /**
     * * Message for strings not provided error.
     */
    private static final String
            MSG_NULL_STRINGS = "strings not provided";

    /**
     * * Message for strings not provided error.
     */
    private static final String
            MSG_NEGATIVE_NUM = "input number must not be negative";

    @Override
    public boolean isEquals(final String firstString, final String secondString) {
        if ((firstString == null) || (secondString == null)) {
            throw new IllegalArgumentException(MSG_NULL_STRINGS);
        }
        return firstString.equals(secondString);
    }

    @Override
    public String left(final String sourceString, final int number) {
        if (("".equals(sourceString)) || (sourceString == null)) {
            throw new IllegalArgumentException(MSG_NULL_STRINGS);
        } else if (number < 0) {
            throw new IllegalArgumentException((MSG_NEGATIVE_NUM));
        }

        if (sourceString.length() > number) {
            return sourceString.substring(0, number);
        } else {
            return sourceString;
        }
    }

    @Override
    public String right(final String sourceString, final int number) {
        if (("".equals(sourceString)) || (sourceString == null)) {
            throw new IllegalArgumentException(MSG_NULL_STRINGS);
        } else if (number < 0) {
            throw new IllegalArgumentException((MSG_NEGATIVE_NUM));
        }

        if (sourceString.length() > number) {
            return sourceString.substring(sourceString.length() - number, sourceString.length());
        } else {
            return sourceString;
        }
    }

    @Override
    public String left(final String sourceString, final String separator) {
        if (("".equals(sourceString)) || ("".equals(separator))
                || (sourceString == null) || (separator == null)) {
            throw new IllegalArgumentException(MSG_NULL_STRINGS);
        }

        if (sourceString.contains(separator)) {
            return sourceString.split(separator, 2)[0];
        } else {
            return sourceString;
        }
    }

    @Override
    public String right(final String sourceString, final String separator) {
        if (("".equals(sourceString)) || ("".equals(separator))
                || (sourceString == null) || (separator == null)) {
            throw new IllegalArgumentException(MSG_NULL_STRINGS);
        }

        if (sourceString.contains(separator)) {
            String[] substrings = sourceString.split(separator);
            return substrings[substrings.length - 1];
        } else {
            return sourceString;
        }
    }

    @Override
    public String[] split(final String sourceString, final String split) {
        if (("".equals(sourceString)) || ("".equals(split))
                || (sourceString == null) || (split == null)) {
            throw new IllegalArgumentException(MSG_NULL_STRINGS);
        }

        if (sourceString.contains(split)) {
            return sourceString.split(split);
        } else {
            return new String[]{sourceString};
        }
    }

    @Override
    public String join(final String[] sourceCollection, final String glue) {
        if ((sourceCollection == null) || (glue == null)
                || (sourceCollection.length == 0)) {
            throw new IllegalArgumentException(MSG_NULL_STRINGS);
        }
        StringBuilder result = new StringBuilder();
        for (String s : sourceCollection) {
            result.append(s);
            result.append(glue);
        }
        //deleting last glue entrance
        int strLength = result.length();
        int glueLength = glue.length();
        result.delete(strLength - glueLength, strLength);
        return result.toString();
    }
}
