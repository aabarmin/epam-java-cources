package com.epam.university.java.core.task049;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Task049Test {
    private Task049 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isFirstNull() {
        instance.getResultList(null, "home");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSecondNull() {
        instance.getResultList("home", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void areNull() {
        instance.getResultList(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void hasOnlySpaces() {
        instance.getResultList("   ", "");
    }

    @Test
    public void firstTest() {
        String expectation = "aba";
        String result = instance.getResultList("abattd", "gdgeaba");
        assertTrue("Incorrect Armstrong numbers collection",
                expectation.equals(result)
        );
    }

    @Test
    public void secondTest() {
        String expectation = "abcba";
        String result = instance.getResultList("abcba", "abcba");
        assertTrue("Incorrect Armstrong numbers collection",
                expectation.equals(result)
        );
    }

    @Test
    public void thirdTest() {
        String expectation = "a";
        String result = instance.getResultList("abc", "sdsad");
        assertTrue("Incorrect Armstrong numbers collection",
                expectation.equals(result)
        );
    }

    @Test
    public void fourthTest() {
        String expectation = "aaa";
        String result = instance.getResultList("thhwerwaaa", "aaa");
        assertTrue("Incorrect Armstrong numbers collection",
                expectation.equals(result)
        );
    }
}