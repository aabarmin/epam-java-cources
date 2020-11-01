package com.epam.university.java.core.task054;

import java.awt.image.BufferedImage;

/**
 * In this task you need to implement program that applies filters to jpg image.
 * Result of filtering you can see in "build/resources/main/task054" directory.
 */
public interface Task054 {

    /**
     * Convert an image to black-and-white.
     * Tip: red, green and blue values of pixel have to have the same value.
     * @param inputFilePath - image to apply filter.
     * @param outputFilePath - image after filter applying.
     */
    public BufferedImage grayscaleFilter(String inputFilePath, String outputFilePath);


    /**
     * Implement Sepia filter that make an image old-like looking.
     * Tip: to implement Sepia filter you need to set pixels value by this formulas:
     * Red = 0.393 * originalRed + 0.769 * originalGreen + 0.189 * originalBlue.
     * Green = 0.349 * originalRed + 0.686 * originalGreen + 0.168 * originalBlue.
     * Blue = 0.272 * originalRed + 0.534 * originalGreen + 0.131 * originalBlue.
     * @param inputFilePath - image to apply filter.
     * @param outputFilePath - image after filter applying.
     */
    public BufferedImage sepiaFilter(String inputFilePath, String outputFilePath);


    /**
     * Reflect an image.
     * @param inputFilePath - image to apply filter.
     * @param outputFilePath - image after filter applying.
     */
    public BufferedImage reflectFilter(String inputFilePath, String outputFilePath);


    /**
     * Return original image from path.
     * @param inputFilePath - image to return.
     * @return - original image.
     */
    public BufferedImage originalImage(String inputFilePath);

    /**
     * Return value of red in pixel.
     * @param pixel - integer that represents pixel from ColorModel.class.
     * @return - integer that represents value of red in pixel.
     */
    public int getRed(int pixel);

    /**
     * Return value of green in pixel.
     * @param pixel - integer that represents pixel from ColorModel.class.
     * @return - integer that represents value of green in pixel.
     */
    public int getGreen(int pixel);

    /**
     * Return value of blue in pixel.
     * @param pixel - integer that represents pixel from ColorModel.class.
     * @return - integer that represents value of blue in pixel.
     */
    public int getBlue(int pixel);
}
