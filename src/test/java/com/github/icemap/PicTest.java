package com.github.icemap;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author Icemap
 * @date 2019-10-08 16:10
 */
public class PicTest {
    @Test
    public void testPicConvert () throws Exception {
        ConvertPic convertPic = new ConvertPic(20);
        String testResPath = this.getClass().getResource("/").getPath();
        BufferedImage img = ImageIO.read(new File(testResPath + "gintama.jpg"));
        img = convertPic.picTo4K(img);
        ImageIO.write(img, "png", new File(testResPath + "gintama-2x.png"));
    }
}
