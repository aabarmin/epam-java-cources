package com.epam.university.java.core.task057;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task057Test {
    Task057 instance;

    /**
     * Instantiate class.
     *
     * @throws Exception in case of Runtime Exceptions.
     */
    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task057.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void substringIsNull() {
        String path = getClass().getResource("/task057/").getPath();
        instance.find(path, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pathIsNull() {
        instance.find(null, "test1");
    }

    @Test
    public void oneFile() {
        String path = getClass().getResource("/task057/").getPath();
        List<String> result = instance.find(path, "test2");
        assertTrue("Incorrect list size or result isn't contain target",
                result.size() == 1
                        && result.contains(getClass().getResource("/task057/test.txt").getPath()));
    }

    @Test
    public void severalFiles() {
        String path = getClass().getResource("/task057/").getPath();
        String target1 = getClass().getResource("/task057/subdir1/test1.txt").getPath();
        String target2 = getClass().getResource("/task057/subdir2/test2.txt").getPath();
        String target3 = getClass().getResource("/task057/subdir2/subsubdir/test3.txt").getPath();
        List<String> result = instance.find(path, "test3");
        assertTrue("Incorrect list size or result isn't contain target",
                result.size() == 3
                        && result.contains(target1)
                        && result.contains(target2)
                        && result.contains(target3));
    }

    @Test
    public void substringNotFound() {
        String path = getClass().getResource("/task057/").getPath();
        List<String> result = instance.find(path, "test4");
        assertEquals("Not empty list", 0, result.size());
    }
}