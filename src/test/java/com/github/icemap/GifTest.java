package com.github.icemap;

import com.github.icemap.ConvertGif;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author Icemap
 * @date 2019-10-08 17:51
 */
public class GifTest {
    @Test
    public void testGifConvert () throws Exception {
        ConvertGif convertGif = new ConvertGif(20);
        String testResPath = this.getClass().getResource("/").getPath();
        convertGif.gifTo4K(new FileInputStream(new File(testResPath + "sakura.gif")), testResPath + "sakura-2x.gif");
        convertGif.gifTo4K(new FileInputStream(new File(testResPath + "hamster.gif")), testResPath + "hamster-2x.gif");
    }
}
