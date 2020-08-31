package com.epam.university.java.core.task008;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Aleksandr_Barmin on 9/8/2017.
 */
public class Task008Test {
    private Task008 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void bracesSourceStringIsNull() throws Exception {
        instance.isValid(null);
    }

    @Test
    public void bracesAreCorrect() throws Exception {
        final String source = "(1 + 2) * {[-3] - 4}";
        assertTrue("Error in correct braces", instance.isValid(source));
    }

    @Test
    public void bracesIncorrect() throws Exception {
        final String source = "(1 + [2) + 3 - 4]";
        assertFalse("Error in incorrect braces", instance.isValid(source));
    }

    @Test
    public void emptySourceString() throws Exception {
        assertTrue("Error with empty string", instance.isValid(""));
    }

    @Test
    public void singleCloseBracket() throws Exception {
        final String source = "-3] - 4";
        assertFalse("Error in correct braces", instance.isValid(source));
    }

    @Test
    public void singleOpenBracket() throws Exception {
        final String source = "1 + (2";
        assertFalse("Error in correct braces", instance.isValid(source));
    }
}