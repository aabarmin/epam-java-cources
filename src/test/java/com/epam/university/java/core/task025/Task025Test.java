package com.epam.university.java.core.task025;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task025Test {
    private Task025 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task025.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullString() throws Exception {
        instance.getAmountOfAlteredLetters(null);
    }

    @Test
    public void allCorrect() throws Exception {
        assertEquals("Invalid result",
                0,
                instance.getAmountOfAlteredLetters("SOSSOS")
        );
    }

    @Test
    public void oneError() throws Exception {
        assertEquals("Invalid result",
                1,
                instance.getAmountOfAlteredLetters("SOSSAS")
        );
    }

    @Test
    public void twoErrors() throws Exception {
        assertEquals("Invalid result",
                2,
                instance.getAmountOfAlteredLetters("SASSBS")
        );
    }

    @Test
    public void threeErrors() throws Exception {
        assertEquals("Invalid result",
                3,
                instance.getAmountOfAlteredLetters("SOSABCSOS")
        );
    }

    @Test
    public void moreErrors() throws Exception {
        assertEquals("Invalid result",
                4,
                instance.getAmountOfAlteredLetters("SOSSOSABCDOS")
        );
    }

    @Test
    public void emptyMessage() throws Exception {
        assertEquals("Invalid result",
            0,
            instance.getAmountOfAlteredLetters("")
        );
    }

    @Test
    public void shuffledMessage() throws Exception {
        assertEquals("Invalid result",
            4,
            instance.getAmountOfAlteredLetters("SSOOSS")
        );
    }

}