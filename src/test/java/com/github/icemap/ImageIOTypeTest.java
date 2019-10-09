package com.github.icemap;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

/**
 * @author Icemap
 * @date 2019-10-08 17:09
 */
public class ImageIOTypeTest {
    @Test
    public void testImageIOType () {
        System.out.println("-----Read Type-----");
        for (String readFormat: ImageIO.getReaderFormatNames()) {
            System.out.println(readFormat);
        }

        System.out.println("-----Read Type-----");
        for (String writeFormat: ImageIO.getWriterFormatNames()) {
            System.out.println(writeFormat);
        }
    }
}
