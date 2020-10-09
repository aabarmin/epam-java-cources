package com.epam.university.java.core.task044;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task044Test {

    private Task044 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task044.class);
    }


    @Test(expected = IllegalArgumentException.class)
    public void countWithNullArgument() throws Exception {
        instance.findCountOfTraces(null, null);
    }

    @Test
    public void getAllFootprints1() {
        final List<String> footprints = Arrays.asList(
                "1 2", "2 3", "3 4", "5 6"
        );
        assertEquals("invalid number of prints", instance.findCountOfTraces(7, footprints), 3);
    }

    @Test
    public void getAllFootprints2() {
        final List<String> footprints = new ArrayList<>();
        assertEquals("invalid number of prints", instance.findCountOfTraces(5, footprints), 5);
    }

    @Test
    public void getAllFootprints3() {
        final List<String> footprints = Arrays.asList(
                "1 2", "2 3", "3 4", "4 1"
        );
        assertEquals("invalid number of prints", instance.findCountOfTraces(4, footprints), 1);
    }

    @Test
    public void getAllFootprints4() {
        final List<String> footprints = Arrays.asList(
                "1 2", "2 3", "3 4", "4 1", "8 5", "5 6", "6 7"
        );
        assertEquals("invalid number of prints", instance.findCountOfTraces(8, footprints), 2);
    }
}
