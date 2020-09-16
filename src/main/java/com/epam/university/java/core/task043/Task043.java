package com.epam.university.java.core.task043;

/**
 * Morse Code.
 *
 * <p>
 *     The Morse code encodes every character as a sequence of "dots" and "dashes".
 *     For example, the letter 'A' is coded as "·−", letter 'Q' is coded as "−−·−",
 *     and digit '1' is coded as "·−−−−". The Morse code is case-insensitive,
 *     traditionally capital letters are used. When the message is written in Morse
 *     code, a single space is used to separate the character codes and 3 spaces are used
 *     to separate words.
 * </p>
 * <p>
 *      Example: "HEY JUDE" in Morse Code is "···· · −·−−   ·−−− ··− −·· ·"
 * </p>
 *
 */
public interface Task043 {
    /**
     * Encode source string with Morse Code.
     * @param sourceString source string
     * @return encoded string
     */
    String encode(String sourceString);

    /**
     * Decode source string with Morse Code.
     * @param sourceString source string
     * @return decoded string
     */
    String decode(String sourceString);
}
