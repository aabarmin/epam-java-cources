package com.epam.university.java.core.task046;

import com.epam.university.java.core.helper.TestHelper;
import com.epam.university.java.core.task045.Task045;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task046Test {
    private Task046 instance;


    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task046.class);
    }

    public void assembleWithNullArgument() throws Exception {
        instance.assembleMatryoshka(null, null);
    }

    @Test
    public void findAllCombinations1() {
        final List<String> target = Arrays.asList(
                "0"
        );
        assertEquals("it is impossible to assemble a matryoshka",
                instance.assembleMatryoshka(1, 1), target);
    }

    @Test
    public void findAllCombinations2() {
        final List<String> target = Arrays.asList(
                "0 1", "0 2", "1 2"
        );
        List<String> result = instance.assembleMatryoshka(2, 3);
        assertTrue(target.containsAll(result)
                && result.containsAll(target)
                && target.size() == result.size());
    }

    @Test
    public void findAllCombinations3() {
        final List<String> target = Arrays.asList(
                "0 1 2", "0 1 3", "0 2 3", "1 2 3"
        );
        List<String> result = instance.assembleMatryoshka(3, 4);
        assertTrue(target.containsAll(result)
                && result.containsAll(target)
                && target.size() == result.size());
    }

    @Test
    public void findAllCombinations4() {
        final List<String> target = Arrays.asList(
                "0 1 2 3", "0 1 2 4", "0 1 2 5", "0 1 3 4",
                "0 1 3 5", "0 1 4 5", "0 2 3 4", "0 2 3 5",
                "0 2 4 5", "0 3 4 5", "1 2 3 4", "1 2 3 5",
                "1 2 4 5", "1 3 4 5", "2 3 4 5"
        );
        List<String> result = instance.assembleMatryoshka(4, 6);
        assertTrue(target.containsAll(result)
                && result.containsAll(target)
                && target.size() == result.size());
    }
}
