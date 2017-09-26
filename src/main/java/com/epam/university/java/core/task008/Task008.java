package com.epam.university.java.core.task008;

/**
 * Strings and braces.
 */
public interface Task008 {
    /**
     * Given a string with mathematical expression like "(1 + 2) * {[-3] - 4}". You need to check,
     * are all braces correct. Ex:
     * <p>
     *     "(1 + 2) * {[-3] - 4}" - correct
     *     "(1 + [2) + 3 - 4]" - incorrect
     *     In expression can be used the following kinds of braces: {}, (), [].
     *     Tip: it's better to implement stack structure.
     *     Tip: You also can use Stack class but it's not recommended.
     * </p>
     *
     * @param sourceString string to check
     * @return is braces valid or source string is empty
     */
    boolean isValid(String sourceString);
}
