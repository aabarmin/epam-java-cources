package com.epam.university.java.core.task065;

import com.epam.university.java.core.helper.TestHelper;
import com.epam.university.java.core.task064.Task064;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task065Test {
    private Task065 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task065.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNoField() throws Exception {
        instance.determineTheResultOfGame(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithWrongArgs() throws Exception {
        instance.determineTheResultOfGame("firstLine", "secondLine", "thirdLine");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithIncorrectField() throws Exception {
        instance.determineTheResultOfGame("XXO", "XXO", "###");
    }

    @Test
    public void crossesWinTest() throws Exception {
        assertEquals(
                "The winner is wrong",
                "Crosses win",
                instance.determineTheResultOfGame("XXO", "XOO", "###")
        );
    }

    @Test
    public void noughtsWinTest() throws Exception {
        assertEquals(
                "The winner is wrong",
                "Noughts win",
                instance.determineTheResultOfGame("XXO", "#X#", "#OO")
        );
    }

    @Test
    public void drawTest() throws Exception {
        assertEquals(
                "The winner is wrong",
                "Draw",
                instance.determineTheResultOfGame("O#O", "#X#", "XOX")
        );
    }
}
