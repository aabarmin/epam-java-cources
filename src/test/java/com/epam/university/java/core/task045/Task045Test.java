package com.epam.university.java.core.task045;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task045Test {

    private Task045 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task045.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void first() throws Exception {
        instance.doAnagram(null);
    }

    @Test
    public void second() throws Exception {
        String input = "";
        String expect = "";

        assertEquals("Invalid result", expect, instance.doAnagram(input));
    }

    @Test
    public void third() throws Exception {
        String input = " ";
        String expect = " ";

        assertEquals("Invalid result", expect, instance.doAnagram(input));
    }

    @Test
    public void fourth() throws Exception {
        final String input = "123  123";
        String expect = "123  123";

        assertEquals("Invalid result", expect, instance.doAnagram(input));
    }

    @Test
    public void fifth() throws Exception {
        String input = "w";
        String expect = "w";

        assertEquals("Invalid result", expect, instance.doAnagram(input));
    }

    @Test
    public void sixth() throws Exception {
        String input = "aAAaaaAAA";
        String expect = "AAAaaaAAa";

        assertEquals("Invalid result", expect, instance.doAnagram(input));
    }

    @Test
    public void seventh() throws Exception {
        String input = "hello world";
        String expect = "olleh dlrow";

        assertEquals("Invalid result", expect, instance.doAnagram(input));
    }

    @Test
    public void eighth() throws Exception {
        String input = "hell55o w2orl3d";
        String expect = "olle55h d2lro3w";

        assertEquals("Invalid result", expect, instance.doAnagram(input));
    }

    @Test
    public void ninth() throws Exception {
        String input = "abcd123efg a*b/c-d&e";
        String expect = "gfed123cba e*d/c-b&a";

        assertEquals("Invalid result", expect, instance.doAnagram(input));
    }

    @Test
    public void tenth() throws Exception {
        String input = "HE*LLO W*ORLD I AM A=LI*VE";
        String expect = "OL*LEH D*LROW I MA E=VI*LA";

        assertEquals("Invalid result", expect, instance.doAnagram(input));
    }
}
