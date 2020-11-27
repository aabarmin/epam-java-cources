package com.epam.university.java.core.task072;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task072Test {
    private Task072 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task072.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageNumberWithNull() {
        instance.averageNum(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTheLongestWordWithNull() {
        instance.theLongestWord(null, null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testLogicalOperationWithNull() {
        instance.logicalOperations(null, null, null);
    }

    @Test
    public void testAverageNumber() {
        double result = instance.averageNum(2, 252, 23, 432, 21, -15);
        double target = 119.17;
        assertEquals("Average number is incorrect", target, result, 0.01);
    }


    @Test
    public void testTheLongestWord() {
        String result = instance.theLongestWord("I", "Love", "Epam", "And", "I", "am",
                "going", "to", "work", "there");
        String target = "going";
        assertEquals("The longest word is incorrect", target, result);
    }


    @Test
    public void testLogicalOperationAndFalse() {
        boolean result = instance.logicalOperations("AND", false, false, false);
        boolean target = false;
        assertEquals("Incorrect average number", target, result);
    }

    @Test
    public void testLogicalOperationAndTrue() {
        boolean result = instance.logicalOperations("AND", true, true);
        boolean target = true;
        assertEquals("Incorrect average number", target, result);
    }

    @Test
    public void testLogicalOperationOrFalse() {
        boolean result = instance.logicalOperations("OR", false, false, false, false);
        boolean target = false;
        assertEquals("Incorrect average number", target, result);
    }

    @Test
    public void testLogicalOperationOrTrue() {
        boolean result = instance.logicalOperations("OR", true, false, false);
        boolean target = true;
        assertEquals("Incorrect average number", target, result);
    }

    @Test
    public void testLogicalOperationXorTrue() {
        boolean result = instance.logicalOperations("XOR", true, false, false, true);
        boolean target = true;
        assertEquals("Incorrect average number", target, result);
    }

    @Test
    public void testLogicalOperationXorFalse() {
        boolean result = instance.logicalOperations("XOR", true, true, true);
        boolean target = false;
        assertEquals("Incorrect average number", target, result);
    }
}