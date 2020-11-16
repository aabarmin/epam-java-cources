package com.epam.university.java.core.task024;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;

public class Task024Test {
    private Task024 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task024.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullArray() throws Exception {
        instance.getWordsCount(null);
    }

    @Test
    public void emptyString() throws Exception {
        assertArrayEquals("Invalid result",
                Collections.emptyList().toArray(),
                instance.getWordsCount("").toArray()
        );
    }

    @Test
    public void oneWord() throws Exception {
        assertArrayEquals("Invalid result",
                Collections.singleton("one").toArray(),
                instance.getWordsCount("one").toArray()
        );
    }

    @Test
    public void twoWords() throws Exception {
        assertArrayEquals("Invalid result",
                new String[]{"two", "words"},
                instance.getWordsCount("twoWords").toArray()
        );
    }

    @Test
    public void moreWords() throws Exception {
        assertArrayEquals("Invalid result",
                new String[]{"two", "words", "and", "other", "one"},
                instance.getWordsCount("twoWordsAndOtherOne").toArray()
        );
    }

    @Test
    public void startsWithUppercase() throws Exception {
        assertArrayEquals("Invalid result",
            new String[]{"two", "words"},
            instance.getWordsCount("TwoWords").toArray()
        );
    }

    @Test
    public void cyrillicWords() throws Exception {
        assertArrayEquals("Invalid result",
            new String[]{"привет", "мир"},
            instance.getWordsCount("приветМир").toArray()
        );
    }

    @Test
    public void unicodeWords() throws Exception {
        assertArrayEquals("Invalid result",
            new String[] {"testen", "in", "deutsch", "über", "österreich"},
            instance.getWordsCount("testenInDeutschÜberÖsterreich").toArray()
        );
    }

    @Test
    public void frenchWords() throws Exception {
        assertArrayEquals("Invalid result",
                new String[] {"tests", "en", "français"},
                instance.getWordsCount("testsEnFrançais").toArray()
        );
    }
}