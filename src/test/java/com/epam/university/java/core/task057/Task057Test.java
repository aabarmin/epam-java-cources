package com.epam.university.java.core.task057;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task057Test {
    private Task057 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task057.class);
    }

    @Test
    public void test1() {
        final int numberOfFlat = 1;
        final int levels = 1;
        final int entrances = 1;
        assertEquals(
                "Invalid level of window",
                1,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.FRONT_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                6,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test
    public void test2() {
        final int numberOfFlat = 6;
        final int levels = 1;
        final int entrances = 1;
        assertEquals(
                "Invalid level of window",
                1,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.BACK_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                8,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test
    public void test3() {
        final int numberOfFlat = 6;
        final int levels = 1;
        final int entrances = 2;
        assertEquals(
                "Invalid level of window",
                1,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.BACK_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                16,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test
    public void test4() {
        final int numberOfFlat = 12;
        final int levels = 2;
        final int entrances = 2;
        assertEquals(
                "Invalid level of window",
                2,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.BACK_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                12,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test
    public void test5() {
        final int numberOfFlat = 215;
        final int levels = 5;
        final int entrances = 6;
        assertEquals(
                "Invalid level of window",
                2,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.FRONT_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                42,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test
    public void test6() {
        final int numberOfFlat = 188;
        final int levels = 5;
        final int entrances = 6;
        assertEquals(
                "Invalid level of window",
                4,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.BACK_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                12,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test
    public void test7() {
        final int numberOfFlat = 1498;
        final int levels = 36;
        final int entrances = 24;
        assertEquals(
                "Invalid level of window",
                8,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.FRONT_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                48,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test
    public void test8() {
        final int numberOfFlat = 9996;
        final int levels = 48;
        final int entrances = 52;
        assertEquals(
                "Invalid level of window",
                2,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.BACK_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                204,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test
    public void test9() {
        final int numberOfFlat = 1996794;
        final int levels = 480;
        final int entrances = 520;
        assertEquals(
                "Invalid level of window",
                480,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.FRONT_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                4160,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test
    public void test10() {
        final int numberOfFlat = 3838;
        final int levels = 480;
        final int entrances = 520;
        assertEquals(
                "Invalid level of window",
                480,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.BACK_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                4160,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testError1() {
        final int numberOfFlat = 9;
        final int levels = 1;
        final int entrances = 1;
        assertEquals(
                "Invalid level of window",
                480,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.BACK_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                4160,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testError2() {
        final int numberOfFlat = 9;
        final int levels = 0;
        final int entrances = 1;
        assertEquals(
                "Invalid level of window",
                480,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.BACK_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                4160,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testError4() {
        final int numberOfFlat = 9;
        final int levels = 1;
        final int entrances = 0;
        assertEquals(
                "Invalid level of window",
                480,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.BACK_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                4160,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testError5() {
        final int numberOfFlat = 0;
        final int levels = 1;
        final int entrances = 1;
        assertEquals(
                "Invalid level of window",
                480,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getLevelNumber()
        );
        assertEquals(
                "Invalid side of Window",
                SideType.BACK_SIDE,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getSide()
        );
        assertEquals(
                "Invalid number of Window",
                4160,
                instance.getWindowForDelivery(levels, entrances, numberOfFlat).getNumberOfWindow()
        );
    }
}
