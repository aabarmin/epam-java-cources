package com.epam.university.java.core.task059;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task059Test {
    Task059 instance;

    /**
     * Instantiate class.
     *
     * @throws Exception in case of Runtime Exceptions.
     */
    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task059.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void substringIsNull() throws URISyntaxException {
        Path startPath = Paths.get(getClass().getResource("/task059/").toURI());
        instance.find(startPath.toString(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pathIsNull() {
        instance.find(null, "test1");
    }

    @Test
    public void oneFile() throws URISyntaxException {
        Path startPath = Paths.get(getClass().getResource("/task059/").toURI());
        List<String> result = instance.find(startPath.toString(), "test2");

        assertEquals("Incorrect list size", 1, result.size());

        Path target = startPath.resolve("test.txt");
        assertTrue("Result isn't contain target",
                result.contains(target.toString()));
    }

    @Test
    public void severalFiles() throws URISyntaxException {
        Path startPath = Paths.get(getClass().getResource("/task059/").toURI());
        List<String> result = instance.find(startPath.toString(), "test3");

        assertEquals("Incorrect list size", 3, result.size());

        Path target1 = startPath.resolve("subdir1/test1.txt");
        assertTrue("Result isn't contain target",
                result.contains(target1.toString()));

        Path target2 = startPath.resolve("subdir2/test2.txt");
        assertTrue("Result isn't contain target",
                result.contains(target2.toString()));

        Path target3 = startPath.resolve("subdir2/subsubdir/test3.txt");
        assertTrue("Result isn't contain target",
                result.contains(target3.toString()));
    }

    @Test
    public void substringNotFound() throws URISyntaxException {
        Path startPath = Paths.get(getClass().getResource("/task059/").toURI());
        List<String> result = instance.find(startPath.toString(), "test4");

        assertEquals("Not empty list", 0, result.size());
    }
}