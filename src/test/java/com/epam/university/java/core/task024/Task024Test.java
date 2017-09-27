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
}