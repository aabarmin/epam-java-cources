package com.epam.university.java.core.task039;


import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Arrays;


import static org.junit.Assert.assertEquals;

public class Task039Test {
    private Task039 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task039.class);
    }

    @Test
    public void getEncoding1() {
        final Map<Character, String> targetEncoding = Map.of(
                'A', "11",
                'B', "10",
                'C', "00",
                'D', "011",
                'E', "0100",
                'F', "0101");
        final Map<Character, String> resultEncoding = instance.getEncoding(
                new HashMap<>(Map.of(
                        'A', 100,
                        'B', 99,
                        'C', 50,
                        'D', 45,
                        'E', 10,
                        'F', 10)));
        assertEquals("Incorrect encoding", targetEncoding, resultEncoding);
    }

    @Test
    public void getEncoding2() {
        final Map<Character, String> targetEncoding = Map.of(
                'A', "0",
                'B', "10",
                'C', "110",
                'D', "1111",
                'E', "11101",
                'F', "11100");
        final Map<Character, String> resultEncoding = instance.getEncoding(
                new HashMap<>(Map.of(
                        'A', 100,
                        'B', 40,
                        'C', 30,
                        'D', 20,
                        'E', 10,
                        'F', 5)));
        assertEquals("Incorrect encoding", targetEncoding, resultEncoding);
    }

    @Test
    public void getEncodingWithEqualFrequencies1() {
        final Set<String> encodedValues = new HashSet<>(
                Arrays.asList(
                        "00",
                        "01",
                        "100",
                        "101",
                        "110",
                        "111")
        );
        final Map<Character, String> resultEncoding = instance.getEncoding(
                new HashMap<>(Map.of(
                        'A', 5,
                        'B', 5,
                        'C', 5,
                        'D', 5,
                        'E', 5,
                        'F', 5)));
        final Set<String> resultValues = new HashSet<>(resultEncoding.values());
        assertEquals("Incorrect encoding", encodedValues, resultValues);
    }

    @Test
    public void getEncodingWithEqualFrequencies2() {
        final Set<String> resultEncodedValues = new HashSet<>(
                Arrays.asList(
                        "00",
                        "010",
                        "011",
                        "100",
                        "101",
                        "110",
                        "111")
        );
        final Map<Character, String> resultEncoding = instance.getEncoding(
                new HashMap<>(Map.of(
                        'A', 5,
                        'B', 5,
                        'C', 5,
                        'D', 5,
                        'E', 5,
                        'F', 5,
                        'G', 5)));
        final Set<String> resultValues = new HashSet<>(resultEncoding.values());
        assertEquals("Incorrect encoding", resultEncodedValues, resultValues);
    }

    @Test
    public void getEncodedString1() {
        final String targetEncodedString = "1001100011001000011001101";
        final String resultEncodedString = instance.getEncodedString(
                new HashMap<>(Map.of(
                        'A', 5,
                        'B', 34,
                        'C', 23,
                        'D', 15,
                        'E', 23,
                        'F', 6)), "FABCAEFD");
        assertEquals("Incorrect encoding", targetEncodedString, resultEncodedString);
    }

    @Test
    public void getEncodedString2() {
        final String targetEncodedString = "111111000111001000101";
        final String resultEncodedString = instance.getEncodedString(
                new HashMap<>(Map.of(
                        'A', 45,
                        'B', 45,
                        'C', 23,
                        'D', 20,
                        'E', 14,
                        'F', 1)), "BBBCDAFE");
        assertEquals("Incorrect encoding", targetEncodedString, resultEncodedString);
    }

    @Test
    public void getDecodedString1() {
        final String targetDecodedString = "AAAFECBD";
        final String resultDecodedString = instance.getDecodedString(
                new HashMap<>(Map.of(
                        'A', 30,
                        'B', 25,
                        'C', 20,
                        'D', 15,
                        'E', 10,
                        'F', 5)), "111111100010010001101");
        assertEquals("Incorrect encoding", targetDecodedString, resultDecodedString);
    }

    @Test
    public void getDecodedString2() {
        final String targetDecodedString = "CAAFDEB";
        final String resultDecodedString = instance.getDecodedString(
                new HashMap<>(Map.of(
                        'A', 62,
                        'B', 61,
                        'C', 20,
                        'D', 15,
                        'E', 10,
                        'F', 5)), "100001010010111010111");
        assertEquals("Incorrect encoding", targetDecodedString, resultDecodedString);
    }

}
