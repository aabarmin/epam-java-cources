package com.epam.university.java.core.task026;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task026Test {
    private static final String SOURCE_STRING = "To be or not to be, That is the question";

    private Task026 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task026.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullString() throws Exception {
        instance.encrypt(
                null,
                0
        );
    }

    @Test
    public void encrypt0() throws Exception {
        final String target = SOURCE_STRING;
        assertEquals(
                "Invalid encryption",
                target,
                instance.encrypt(
                        SOURCE_STRING,
                        0
                )
        );
        assertEquals(
                "Invalid decryption",
                SOURCE_STRING,
                instance.decrypt(
                        target,
                        0
                )
        );
    }

    @Test
    public void encrypt1() throws Exception {
        final String target = "Up cf ps opu up cf, Uibu jt uif rvftujpo";
        assertEquals(
                "Invalid encryption",
                target,
                instance.encrypt(
                        SOURCE_STRING,
                        1
                )
        );
        assertEquals(
                "Invalid decryption",
                SOURCE_STRING,
                instance.decrypt(
                        target,
                        1
                )
        );
    }

    @Test
    public void encrypt2() throws Exception {
        final String target = "Vq dg qt pqv vq dg, Vjcv ku vjg swguvkqp";
        assertEquals(
                "Invalid encryption",
                target,
                instance.encrypt(
                        SOURCE_STRING,
                        2
                )
        );
        assertEquals(
                "Invalid decryption",
                SOURCE_STRING,
                instance.decrypt(
                        target,
                        2
                )
        );
    }

    @Test
    public void encrypt10() throws Exception {
        final String target = "Dy lo yb xyd dy lo, Drkd sc dro aeocdsyx";
        assertEquals(
                "Invalid encryption",
                target,
                instance.encrypt(
                        SOURCE_STRING,
                        10
                )
        );
        assertEquals(
                "Invalid decryption",
                SOURCE_STRING,
                instance.decrypt(
                        target,
                        10
                )
        );
    }

    @Test
    public void encrypt20() throws Exception {
        final String target = "Ni vy il hin ni vy, Nbun cm nby koymncih";
        assertEquals(
                "Invalid encryption",
                target,
                instance.encrypt(
                        SOURCE_STRING,
                        20
                )
        );
        assertEquals(
                "Invalid decryption",
                SOURCE_STRING,
                instance.decrypt(
                        target,
                        20
                )
        );
    }

}