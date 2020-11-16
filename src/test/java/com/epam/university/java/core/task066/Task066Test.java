package com.epam.university.java.core.task066;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task066Test {
    private com.epam.university.java.core.task066.Task066 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(com.epam.university.java.core.task066.Task066.class);
    }

    @Test
    public void test1() {
        assertEquals("Invalid result", 7, instance.repeatString("aba", 10));
    }

    @Test
    public void test2() {
        assertEquals("Invalid result", 588525, instance.repeatString("aab", 882787));
    }

    @Test
    public void test3() {
        assertEquals("Invalid result", 0, instance.repeatString("ceebbcb", 817723));
    }

    @Test
    public void test4() {
        assertEquals("Invalid result", 51574523448L, instance.repeatString(
                "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenwei"
                        + "rknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400L));
    }

    @Test
    public void test5() {
        assertEquals("Invalid result", 2, instance.repeatString("ababa", 3));
    }
}
