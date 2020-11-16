package com.epam.university.java.core.task064;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Task064Test {
    private Task064 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task064.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void firstTestWithNoHands() throws Exception {
        instance.determineWinner(null, "7s,3d", "7s,3d,3s,Js,Ad");
    }

    @Test(expected = IllegalArgumentException.class)
    public void secondTestWithNoHands() throws Exception {
        instance.determineWinner("7s,3d", null, "7s,3d,3s,Js,Ad");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNoBoard() throws Exception {
        instance.determineWinner("7s,3d", "Js,Ad", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void firstTestWithWrongHand() throws Exception {
        instance.determineWinner("7s,3d,3s", "Js,Ad", "7c,3c,8d,Js,Ad");
    }

    @Test(expected = IllegalArgumentException.class)
    public void secondTestWithWrongHand() throws Exception {
        instance.determineWinner("7s", "7d,3d", "Ac,Kc,Qd,Js,Ad");
    }

    @Test(expected = IllegalArgumentException.class)
    public void thirdTestWithWrongHand() throws Exception {
        instance.determineWinner("7s,3d", "7d,3d", "Ac,Kc,Qd,Js,Ad");
    }

    @Test(expected = IllegalArgumentException.class)
    public void fourthTestWithWrongHand() throws Exception {
        instance.determineWinner("7s,3d", "7d,3s", "Ac,Kc,3d,Js,Ad");
    }

    @Test(expected = IllegalArgumentException.class)
    public void fifthTestWithWrongHand() throws Exception {
        instance.determineWinner("first hand", "7d,3s", "Ac,Kc,3d,Js,Ad");
    }

    @Test(expected = IllegalArgumentException.class)
    public void sixthTestWithWrongHand() throws Exception {
        instance.determineWinner("7d,3s", "second hand", "Ac,Kc,3d,Js,Ad");
    }

    @Test(expected = IllegalArgumentException.class)
    public void seventhTestWithWrongHand() throws Exception {
        instance.determineWinner("Ac,Kc", "7d,3s", "board");
    }

    @Test(expected = IllegalArgumentException.class)
    public void firstTestWithWrongBoard() throws Exception {
        instance.determineWinner("Ac,Kc", "7d,3s", "Ac,Kh,3d,Js,Ad,As");
    }

    @Test(expected = IllegalArgumentException.class)
    public void secondTestWithWrongBoard() throws Exception {
        instance.determineWinner("Ac,Kc", "7d,3s", "Ac,Kh,3d,Js");
    }

    @Test(expected = IllegalArgumentException.class)
    public void thirdTestWithWrongBoard() throws Exception {
        instance.determineWinner("Ac,Kc", "7d,3s", "10c,10d,10h,10s,10c");
    }

    @Test
    public void highCardTest() throws Exception {
        assertEquals(
                "The winner is wrong",
                1,
                instance.determineWinner("Ac,Kc", "Kd,Qs", "10c,10d,10h,10s,Js").getId()
        );
    }

    @Test
    public void splitTest() throws Exception {
        assertNull("Pot should be split",
                instance.determineWinner("9s,9c", "Kd,Qs", "10c,10d,10h,10s,As")
        );
    }

    @Test
    public void straightFlushTest() throws Exception {
        assertEquals(
                "The winner is wrong",
                1,
                instance.determineWinner("9s,8s", "Kd,Qs", "Jd,6s,7s,As,10s").getId()
        );
    }

    @Test
    public void fullHousesTest() throws Exception {
        assertEquals(
                "The winner is wrong",
                1,
                instance.determineWinner("Js,Qh", "2c,7d", "2d,2s,7h,Qc,Qs").getId()
        );
    }

    @Test
    public void flushVsStraightTest() throws Exception {
        assertEquals(
                "The winner is wrong",
                1,
                instance.determineWinner("5d,6d", "Qd,Kh", "10d,Jd,As,2d,3s").getId()
        );
    }

    @Test
    public void setVsTwoPairsTest() throws Exception {
        assertEquals(
                "The winner is wrong",
                1,
                instance.determineWinner("5d,5s", "Qd,Kh", "Qs,Ks,5h,8h,9h").getId()
        );
    }

    @Test
    public void flushRoyalVsFourOfKindTest() throws Exception {
        assertEquals(
                "The winner is wrong",
                2,
                instance.determineWinner("5d,5s", "Qd,Kd", "10d,Jd,Ad,5h,5c").getId()
        );
    }

    @Test
    public void straightFromAceToFiveVsTwoPairs() throws Exception {
        assertEquals(
                "The winner is wrong",
                1,
                instance.determineWinner("3d,4s", "8d,9s", "Ad,2h,5c,8s,9h").getId()
        );
    }
}
