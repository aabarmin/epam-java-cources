package com.epam.university.java.core.task002;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Aleksandr_Barmin on 9/1/2017.
 */
public class Task002Test {
    private Task002 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void equalsIsNull() throws Exception {
        instance.isEquals(null, null);
    }

    @Test
    public void equalsIsEmpty() throws Exception {
        assertTrue("Error in equals function",
                instance.isEquals("", ""));
    }

    @Test
    public void equalsWithSymbols() throws Exception {
        final String one = new String("First");
        final String two = "First";
        assertTrue("Error in equals function",
                instance.isEquals(one, two));
    }

    @Test(expected = IllegalArgumentException.class)
    public void leftIsNull() throws Exception {
        instance.left(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void leftNumberIsLessThenZero() throws Exception {
        instance.left("", -1);
    }

    @Test
    public void leftWithNormalAmount() throws Exception {
        assertEquals("Error in left function",
                "Hello",
                instance.left("Hello, World", 5));
    }

    @Test
    public void leftWithExceedAmount() throws Exception {
        assertEquals("Error is left function", 
                "Hello, World",
                instance.left("Hello, World", 50));
    }

    @Test(expected = IllegalArgumentException.class)
    public void rightIsNull() throws Exception {
        instance.right(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rightNumberIsLessThenZero() throws Exception {
        instance.right("", -1);
    }

    @Test
    public void rightWithNormalAmount() throws Exception {
        assertEquals("Error in right function",
                "World",
                instance.right("Hello, World", 5));
    }

    @Test
    public void rightWithExceedAmount() throws Exception {
        assertEquals("Error in right function",
                "Hello, World",
                instance.right("Hello, World", 50));
    }

    @Test(expected = IllegalArgumentException.class)
    public void leftWithCharIsNull() throws Exception {
        instance.left(null, null);
    }

    @Test
    public void leftWithSeparator() throws Exception {
        assertEquals("Error in left with separator function",
                "Hello",
                instance.left("Hello, World", ","));
    }

    @Test(expected = IllegalArgumentException.class)
    public void rightWithCharIsNull() throws Exception {
        instance.right(null, null);
    }

    @Test
    public void rightWithSeparator() throws Exception {
        assertEquals("Error in right function",
                "World",
                instance.right("Hello, World", ", "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void splitIsNull() throws Exception {
        instance.split(null, null);
    }

    @Test
    public void splitCheck() throws Exception {
        final String[] target = {"Hello", "World"};
        assertArrayEquals("Error in split function",
                target,
                instance.split("Hello, World", ", "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void joinIsNull() throws Exception {
        instance.join(null, null);
    }

    @Test
    public void joinCheck() throws Exception {
        final String[] source = {"Hello", "World"};
        assertEquals("Error in join function",
                "Hello, World",
                instance.join(source, ", "));
    }
}
