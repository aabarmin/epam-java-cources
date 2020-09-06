package com.epam.university.java.core.task009;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Aleksandr_Barmin on 9/8/2017.
 */
public class Task009Test {
    private Task009 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sourceIsNull() throws Exception {
        instance.countWords(null);
    }

    @Test
    public void countWords() throws Exception {
        final URI fileUri = getClass().getResource("/task009/words.txt").toURI();
        final File file = new File(fileUri);
        final Collection<String> words = instance.countWords(file);
        assertEquals("Error in words count",
                62,
                words.size());
    }

    @Test
    public void countWordsWithExtraSpaces() throws Exception {
        final URI fileUri = getClass().getResource("/task009/words_spaced.txt").toURI();
        final File file = new File(fileUri);
        final Collection<String> words = instance.countWords(file);
        assertEquals("Error in words count",
                62,
                words.size());
    }

}