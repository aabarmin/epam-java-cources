package com.epam.university.java.core.task010;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Aleksandr_Barmin on 9/11/2017.
 */
public class Task010Test {
    private Task010 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sourceIsNull() throws Exception {
        instance.countWordNumbers(null);
    }

    @Test
    public void testFrequency() throws Exception {
        final URI fileUri = getClass().getResource("/task009/words.txt").toURI();
        final File file = new File(fileUri);
        final Map<String, Integer> results = instance.countWordNumbers(file);
        assertEquals("Error in test frequency",
                2,
                (int) results.get("your")
        );
        assertEquals("Error in test frequency",
                2,
                (int) results.get("from")
        );
        assertEquals("Error in test frequency",
                3,
                (int) results.get("is")
        );
    }
}