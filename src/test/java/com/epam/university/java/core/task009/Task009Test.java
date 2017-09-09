package com.epam.university.java.core.task009;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Aleksandr_Barmin on 9/8/2017.
 */
public class Task009Test {
    private Task009 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test
    //I count with my hands here would be 62
    public void countWords() throws Exception {
        final String filePath = getClass().getResource("/task009/words.txt").getFile();
        final File file = new File(filePath);
        final Collection<String> words = instance.countWords(file);
        assertEquals("Error in words count",
                62,
                words.size());
    }
}