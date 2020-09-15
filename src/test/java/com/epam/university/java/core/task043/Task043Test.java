package com.epam.university.java.core.task043;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task043Test {
    private Task043 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task043.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void encodeWithNullString() throws Exception {
        instance.encode(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decodeWithNullString() throws Exception {
        instance.decode(null);
    }

    @Test
    public void firstTest() throws Exception {
        final String decodedText = "HEY JUDE";
        final String encodedText = ".... . -.--   .--- ..- -.. .";
        assertEquals(
                "Invalid encoding",
                encodedText,
                instance.encode(decodedText)
        );
        assertEquals(
                "Invalid encoding",
                decodedText,
                instance.decode(encodedText)
        );
    }

    @Test
    public void secondTest() throws Exception {
        final String decodedText = "SOS";
        final String encodedText = "... --- ...";
        assertEquals(
                "Invalid encoding",
                encodedText,
                instance.encode(decodedText)
        );
        assertEquals(
                "Invalid encoding",
                decodedText,
                instance.decode(encodedText)
        );
    }

    @Test
    public void thirdTest() throws Exception {
        final String decodedText = "TO BE OR NOT TO BE, THAT IS THE QUESTION";
        final String encodedText
                = "- ---   -... .   --- .-.   -. --- -   - ---   "
                + "-... . --..--   - .... .- -   .. ...   - .... .   "
                + "--.- ..- . ... - .. --- -.";
        assertEquals(
                "Invalid encoding",
                encodedText,
                instance.encode(decodedText)
        );
        assertEquals(
                "Invalid encoding",
                decodedText,
                instance.decode(encodedText)
        );
    }
}
