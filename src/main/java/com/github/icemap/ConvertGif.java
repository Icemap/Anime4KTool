package com.github.icemap;

import com.madgag.gif.fmsware.AnimatedGifEncoder;
import com.madgag.gif.fmsware.GifDecoder;

import java.io.InputStream;

/**
 * @author Icemap
 * @date 2019-10-08 16:57
 */
public class ConvertGif {
    ConvertPic picConvert;

    public ConvertGif(int poolSize) {
        picConvert = new ConvertPic(poolSize);
    }

    public void gifTo4K (InputStream gifStream, String savePath) throws Exception {
        gifTo4K(gifStream, 2.0f, savePath);
    }

    public void gifTo4K (InputStream gifStream, Float scaleIndex, String savePath) throws Exception {
        float pushStrength = scaleIndex / 6f;
        float pushGradStrength = scaleIndex / 2f;
        gifTo4K(gifStream, scaleIndex, pushStrength, pushGradStrength, savePath);
    }

    public void gifTo4K (InputStream gifStream, Float scaleIndex, Float pushStrength, Float pushGradStrength, String savePath) throws Exception {
        GifDecoder decoder = new GifDecoder();
        decoder.read(gifStream);
        int frameSize = decoder.getFrameCount();
        AnimatedGifEncoder encoder = new AnimatedGifEncoder();
        encoder.start(savePath);
        encoder.setRepeat(decoder.getLoopCount());
        for (int i = 0; i < frameSize; i++) {
            encoder.setDelay(decoder.getDelay(i));
            encoder.addFrame(picConvert.picTo4K(decoder.getFrame(i), scaleIndex, pushStrength, pushGradStrength));
        }
        encoder.finish();
    }
}
