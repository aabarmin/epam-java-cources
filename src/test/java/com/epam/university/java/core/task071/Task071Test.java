package com.epam.university.java.core.task071;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Task071Test {
    private com.epam.university.java.core.task071.Task071 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(com.epam.university.java.core.task071.Task071.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        instance.datesBetween(null, null);
    }

    @Test
    public void testOfWeeks() {
        List<String> result = instance.datesBetween("WEEK", "2020-11-07 2020-11-22");
        assertNotNull("The list is null", result);
        List<String> target = List.of(
                "2020-11-07 2020-11-08",
                "2020-11-09 2020-11-15",
                "2020-11-16 2020-11-22"
        );

        assertEquals("Wrong amount of weeks", target.size(), result.size());
        assertEquals("Wrong week periods", target, result);
    }

    @Test
    public void testOfYears() {
        List<String> result = instance.datesBetween("YEAR", "2018-01-01 2020-11-26");
        assertNotNull("The list is null", result);
        List<String> target = List.of(
                "2018-01-01 2018-12-31",
                "2018-12-31 2019-12-31",
                "2019-12-31 2020-11-26"
        );

        assertEquals("Wrong amount of years", target.size(), result.size());
        assertEquals("Wrong year periods", target, result);
    }

    @Test
    public void testOfMonth() {
        List<String> result = instance.datesBetween("MONTH", "2020-03-01 2020-11-26");
        assertNotNull("The list is null", result);
        List<String> target = List.of(
                "2020-03-01 2020-04-01",
                "2020-04-01 2020-05-01",
                "2020-05-01 2020-06-01",
                "2020-06-01 2020-07-01",
                "2020-07-01 2020-08-01",
                "2020-08-01 2020-09-01",
                "2020-09-01 2020-10-01",
                "2020-10-01 2020-11-01",
                "2020-11-01 2020-11-26"
        );
        assertEquals("Wrong amount of months", target.size(), result.size());
        assertEquals("Wrong month periods", target, result);
    }

    @Test
    public void testOfQuarters() {
        List<String> result = instance.datesBetween("QUARTER", "2019-10-01 2020-11-26");
        assertNotNull("The list is null", result);
        List<String> target = List.of(
                "2019-10-01 2019-12-31",
                "2020-01-01 2020-03-31",
                "2020-04-01 2020-06-30",
                "2020-07-01 2020-09-30",
                "2020-10-01 2020-11-26"
        );

        assertEquals("Wrong amount of quarters", target.size(), result.size());
        assertEquals("Wrong quarter periods", target, result);
    }




}



