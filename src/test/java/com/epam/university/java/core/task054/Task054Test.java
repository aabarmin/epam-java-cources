package com.epam.university.java.core.task054;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task054Test {
    Task054 instance;
    String input;
    String output;

    /**
     * Instantiate class.
     * @throws Exception in case of Runtime Exceptions.
     */
    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task054.class);
        input = getClass().getResource("/task054/original.jpg").getPath();
        output = getClass().getResource("/task054/").getPath();
    }

    @Test
    public void grayscale() {
        output = output + "gray.jpg";
        File f = new File(output);
        if (f.exists()) {
            f.delete();
        }
        BufferedImage image = instance.grayscaleFilter(input, output);
        int pixel;
        assertTrue("Output image doesn't exist", f.exists());
        for (int i = 0; i < image.getHeight(); i++) {
            pixel = image.getRGB((int) (Math.random() * image.getWidth()),
                    (int) (Math.random() * image.getHeight()));
            assertTrue("Incorrect grayscale filtering, red, green and blue values aren't equal",
                    instance.getGreen(pixel) == instance.getBlue(pixel)
                            && instance.getBlue(pixel) == instance.getRed(pixel));
            assertTrue("Value of some color can't be greater then 255",
                    (instance.getRed(pixel) <= 255) && (instance.getGreen(pixel) <= 255)
                            && (instance.getBlue(pixel) <= 255));
        }
    }

    @Test
    public void sepia() {
        output = output + "sepia.jpg";
        File f = new File(output);
        if (f.exists()) {
            f.delete();
        }
        BufferedImage image = instance.sepiaFilter(input, output);
        BufferedImage original = instance.originalImage(input);
        int processedPixel;
        int originalPixel;
        int x;
        int y;
        int redOrig;
        int greenOrig;
        int blueOrig;
        int redExpected;
        int greenExpected;
        int blueExpected;
        assertTrue("Output image doesn't exist", f.exists());
        for (int i = 0; i < image.getHeight(); i++) {
            x = (int) (Math.random() * image.getWidth());
            y = (int) (Math.random() * image.getHeight());
            processedPixel = image.getRGB(x, y);
            originalPixel = original.getRGB(x, y);
            redOrig = instance.getRed(originalPixel);
            greenOrig = instance.getGreen(originalPixel);
            blueOrig = instance.getBlue(originalPixel);
            redExpected = (((int) (0.393 * redOrig + 0.769 * greenOrig + 0.189 * blueOrig)));
            greenExpected = ((int) (0.349 * redOrig + 0.686 * greenOrig + 0.168 * blueOrig));
            blueExpected = ((int) (0.272 * redOrig + 0.534 * greenOrig + 0.131 * blueOrig));
            if (redExpected > 255) {
                redExpected = 255;
            }
            if (greenExpected > 255) {
                greenExpected = 255;
            }
            if (blueExpected > 255) {
                blueExpected = 255;
            }
            assertEquals("Incorrect Sepia filtering, wrong red value",
                    redExpected, instance.getRed(processedPixel));
            assertEquals("Incorrect Sepia filtering, wrong green value",
                    greenExpected, instance.getGreen(processedPixel));
            assertEquals("Incorrect Sepia filtering, wrong blue value",
                    blueExpected, instance.getBlue(processedPixel));
            assertTrue("Value of some color can't be greater then 255",
                    (instance.getRed(processedPixel) <= 255)
                            && (instance.getGreen(processedPixel) <= 255)
                            && (instance.getBlue(processedPixel) <= 255));
        }
    }

    @Test
    public void reflect() {
        output = output + "reflect.jpg";
        File f = new File(output);
        if (f.exists()) {
            f.delete();
        }
        BufferedImage image = instance.reflectFilter(input, output);
        BufferedImage original = instance.originalImage(input);
        int x;
        int y;
        for (int i = 0; i < image.getWidth(); i++) {
            x = (int) (Math.random() * image.getWidth());
            y = (int) (Math.random() * image.getHeight());
            assertEquals("Incorrect reflect filter",
                    original.getRGB(original.getWidth() - x - 1, y),
                    image.getRGB(x, y));
        }
    }


    @Test
    public void colourValueGetters() {
        int[] pixelValues = {-5964, -14541288, -10197916, -16777216, -1};
        int[] redValues = {255, 34, 100, 0, 255};
        int[] greenValues = {232, 30, 100, 0, 255};
        int[] blueValues = {180, 24, 100, 0, 255};
        for (int i = 0; i < pixelValues.length; i++) {
            assertTrue("Color value can't be greater then 255",
                    (instance.getRed(pixelValues[i]) < 256
                    && instance.getGreen(pixelValues[i]) < 256
                    && instance.getBlue(pixelValues[i]) < 256));
            assertEquals("Incorrect value of red",
                    redValues[i], instance.getRed(pixelValues[i]));
            assertEquals("Incorrect value of green",
                    greenValues[i], instance.getGreen(pixelValues[i]));
            assertEquals("Incorrect value of blue",
                    blueValues[i], instance.getBlue(pixelValues[i]));
        }
    }
}
