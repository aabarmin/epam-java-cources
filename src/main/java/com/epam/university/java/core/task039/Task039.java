package com.epam.university.java.core.task039;


import java.util.Map;

/**
 * Huffman coding.
 * Tip: mind that in heap child equal to parent goes to its right side.
 * Another tip: pay attention when equals frequencies are given. In some situations
 * order of processing is important, as it may give slightly different encodings,
 * but only one may pass tests.
 */

public interface Task039 {

    /**
     * Create Huffman encoding for given characters and assigned frequencies.
     * @param charFrequencies map with characters as keys and frequencies as values
     * @return map with characters as keys and its binary encoding (in string format) as values
     */
    Map<Character, String> getEncoding(Map<Character, Integer> charFrequencies);

    /**
     * Encode given string with Huffman coding. Mind that frequencies is already given,
     * so you don't need to count it. Imagine that you encode part of some message.
     * @param charFrequencies map with characters as keys and frequencies as values
     * @param string string to encode
     * @return binary encoding of the given string (in string format)
     */
    String getEncodedString(Map<Character, Integer> charFrequencies,
                            String string);

    /**
     * Decode given binary string with Huffman coding. Mind that frequencies is already given,
     * so you don't need to count it. Imagine that you decode part of some message.
     * @param charFrequencies map with characters as keys and frequencies as values
     * @param encodedString string to decode
     * @return decoded string
     */
    String getDecodedString(Map<Character, Integer> charFrequencies,
                            String encodedString);

}
