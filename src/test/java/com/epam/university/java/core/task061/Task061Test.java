package com.epam.university.java.core.task061;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Task061Test {
    private Task061 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task061.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongArabicNumber() {
        instance.convertToRoman(5674);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongRomanNumber() {
        instance.convertToArabic("thirty two");
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanNumberWithNull() {
        instance.convertToArabic(null);
    }

    @Test
    public void firstArabic() {
        int arabic = 9;
        String expected = "IX";
        Assert.assertEquals("Wrong conversion", expected, instance.convertToRoman(arabic));
    }

    @Test
    public void secondArabic() {
        int arabic = 1999;
        String expected = "MCMXCIX";
        Assert.assertEquals("Wrong conversion", expected, instance.convertToRoman(arabic));
    }

    @Test
    public void firstRoman() {
        String roman = "XII";
        int expected = 12;
        Assert.assertEquals("Wrong conversion", expected, instance.convertToArabic(roman));
    }

    @Test
    public void secondRoman() {
        String roman = "MMMCCXLV";
        int expected = 3245;
        Assert.assertEquals("Wrong conversion", expected, instance.convertToArabic(roman));
    }
}