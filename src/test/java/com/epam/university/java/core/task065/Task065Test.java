package com.epam.university.java.core.task065;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Task065Test {
    private Task065 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task065.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void loadError1() {
        instance.getWayTable("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void loadError2() {
        instance.getWayTable(null);
    }

    @Test
    public void loadTable1() {
        final WayTable table = instance.getWayTable("/task065/wayTable.html");
        assertNotNull("Wrong all distance", table);
    }

    @Test
    public void loadTable2() {
        final WayTable table = instance.getWayTable("/task065/wayTable.html");
        assertEquals("Wrong all distance",
                3876,
                table.getAllDistance()
        );
    }

    @Test
    public void loadTable3() {
        final WayTable table = instance.getWayTable("/task065/wayTable.html");
        assertEquals("Wrong count ways from html file",
                98,
                table.getCountWays()
        );
    }

    @Test
    public void loadTable4() {
        final WayTable table = instance.getWayTable("/task065/wayTable.html");
        assertEquals("Incorrect XML parsing",
                502,
                table.getDistOfDate(LocalDate.parse("2020-10-01"))
        );
        assertEquals("Incorrect XML parsing",
                61,
                table.getDistOfDate(LocalDate.parse("2020-10-13"))
        );
        assertEquals("Incorrect XML parsing",
                335,
                table.getDistOfDate(LocalDate.parse("2020-10-19"))
        );
        assertEquals("Incorrect XML parsing",
                307,
                table.getDistOfDate(LocalDate.parse("2020-10-30"))
        );
    }
}