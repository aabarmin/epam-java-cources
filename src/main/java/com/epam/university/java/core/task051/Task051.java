package com.epam.university.java.core.task051;

/**
 * Work with Strings.
 */
public interface Task051 {
    /**
     * <p>
     * Write a method that replaces definite article "the" in the sentence
     * with articles "an" or "a". Remember that if the next word begins
     * with a vowel, use "an". In the case of a consonant, use "a".
     * </p>
     *
     * <p>
     * Example: source collection: the dog and the envelope
     * method return: a dog and an envelope
     * replaceThe("the dog and the envelope") ➞ ""
     * </p>
     *
     * @param source source string to replace
     * @return fixed sentence
     */

    String replace(String source);
}