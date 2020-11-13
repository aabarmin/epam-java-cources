package com.epam.university.java.core.task060;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task060Test {
    private Task060 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task060.class);
    }

    @Test
    public void testSet() {
        Cache cache = instance.createCache(4);

        instance.set(cache, 1, "test1");
        instance.set(cache, 2, "test2");
        instance.set(cache, 3, "test3");
        instance.set(cache, 4, "test4");

        assertEquals("Node not found", "test1", instance.get(cache, 1));
        assertEquals("Node not found", "test2", instance.get(cache, 2));
        assertEquals("Node not found", "test3", instance.get(cache, 3));
        assertEquals("Node not found", "test4", instance.get(cache, 4));
    }

    @Test(expected = RuntimeException.class)
    public void testSetWithoutCache() {
        instance.set(null, 1, "test");
    }

    @Test(expected = RuntimeException.class)
    public void testGetWithoutCache() {
        instance.get(null, 1);
    }

    @Test
    public void testMoreThanCacheSize() {
        Cache cache = instance.createCache(4);

        instance.set(cache, 1, "test1");
        instance.set(cache, 2, "test2");
        instance.set(cache, 3, "test3");
        instance.set(cache, 4, "test4");
        instance.set(cache, 5, "test5");
        instance.set(cache, 6, "test6");

        assertEquals("Node not found", "0", instance.get(cache, 1));
        assertEquals("Node not found", "0", instance.get(cache, 2));
        assertEquals("Node not found", "test3", instance.get(cache, 3));
        assertEquals("Node not found", "test4", instance.get(cache, 4));
        assertEquals("Node not found", "test5", instance.get(cache, 5));
        assertEquals("Node not found", "test6", instance.get(cache, 6));
    }

    @Test
    public void testWithUpdate() {
        Cache cache = instance.createCache(4);

        instance.set(cache, 1, "test1");
        instance.set(cache, 2, "test2");
        instance.set(cache, 3, "test3");
        instance.set(cache, 4, "test4");

        instance.set(cache, 1, "newTest1");
        instance.set(cache, 2, "newTest2");

        instance.set(cache, 5, "test5");
        instance.set(cache, 6, "test6");

        assertEquals("Node not found", "newTest1", instance.get(cache, 1));
        assertEquals("Node not found", "newTest2", instance.get(cache, 2));
        assertEquals("Node not found", "0", instance.get(cache, 3));
        assertEquals("Node not found", "0", instance.get(cache, 4));
        assertEquals("Node not found", "test5", instance.get(cache, 5));
        assertEquals("Node not found", "test6", instance.get(cache, 6));
    }

}
