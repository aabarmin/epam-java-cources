package com.epam.university.java.core.task017;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Task017Test {
    private Task017 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task017.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void formatNullStrings() throws Exception {
        instance.formatString(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyStringArgs() throws Exception {
        instance.formatString();
    }

    @Test(expected = IllegalArgumentException.class)
    public void formatNullNumbers() throws Exception {
        instance.formatNumbers(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyNumbersArgs() throws Exception {
        instance.formatNumbers();
    }

    @Test(expected = IllegalArgumentException.class)
    public void formatNullDates() throws Exception {
        instance.formatDates(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyDatesArgs() throws Exception {
        instance.formatDates();
    }

    @Test
    public void formatStrings() throws Exception {
        final String resultString = instance.formatString("nothing", "John Snow");
        assertEquals("Strings formatted incorrectly",
                "You know nothing, John Snow!",
                resultString);
    }

    @Test
    public void formatNumbers() throws Exception {
        final String resultString = instance.formatNumbers(20d);
        assertEquals("Numbers formatted incorrectly",
                "20.0, 20.00, +20.00, 0x1.4p4",
                resultString);
    }

    @Test
    public void formatDates() throws Exception {
        final Date targetDate = new Date();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        final String resultString = instance.formatDates(targetDate);
        assertEquals("Dates formatted incorrectly",
                dateFormat.format(targetDate),
                resultString);
    }
}