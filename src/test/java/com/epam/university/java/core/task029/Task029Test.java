package com.epam.university.java.core.task029;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

public class Task029Test {
    private Task029 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task029.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullLists() throws Exception {
        instance.fillCrossword(null, null);
    }

    @Test
    public void testFirst() throws Exception {
        final Collection<String> source = Arrays.asList(
                "+-++++++++",
                "+-++++++++",
                "+-++++++++",
                "+-----++++",
                "+-+++-++++",
                "+-+++-++++",
                "+++++-++++",
                "++------++",
                "+++++-++++",
                "+++++-++++"
        );
        final Collection<String> target = Arrays.asList(
                "+L++++++++",
                "+O++++++++",
                "+N++++++++",
                "+DELHI++++",
                "+O+++C++++",
                "+N+++E++++",
                "+++++L++++",
                "++ANKARA++",
                "+++++N++++",
                "+++++D++++"
        );
        final Collection<String> words = Arrays.asList(
                "LONDON",
                "DELHI",
                "ICELAND",
                "ANKARA"
        );
        assertArrayEquals("Incorrect answer",
                target.toArray(new String[0]),
                instance.fillCrossword(source, words).toArray(new String[0])
        );
    }

    @Test
    public void testSecond() throws Exception {
        final Collection<String> source = Arrays.asList(
                "+-++++++++",
                "+-++++++++",
                "+-------++",
                "+-++++++++",
                "+-++++++++",
                "+------+++",
                "+-+++-++++",
                "+++++-++++",
                "+++++-++++",
                "++++++++++"
        );
        final Collection<String> target = Arrays.asList(
                "+E++++++++",
                "+N++++++++",
                "+GWALIOR++",
                "+L++++++++",
                "+A++++++++",
                "+NORWAY+++",
                "+D+++G++++",
                "+++++R++++",
                "+++++A++++",
                "++++++++++"
        );
        final Collection<String> words = Arrays.asList(
                "ENGLAND",
                "GWALIOR",
                "NORWAY",
                "AGRA"
        );
        assertArrayEquals("Incorrect answer",
                target.toArray(new String[0]),
                instance.fillCrossword(source, words).toArray(new String[0])
        );
    }
}