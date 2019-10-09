package com.github.icemap;


import com.github.icemap.kernel.ImageKernel;
import com.github.icemap.kernel.KernelPool;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Icemap
 * @date 2019-10-08 15:26
 */
public class ConvertPic {
    KernelPool pool;

    public ConvertPic(int poolSize) {
        pool = new KernelPool(poolSize);
    }

    public BufferedImage picTo4K (BufferedImage pic) throws Exception {
        return picTo4K(pic, 2.0f);
    }

    public BufferedImage picTo4K (BufferedImage pic, Float scaleIndex) throws Exception {
        float pushStrength = scaleIndex / 6f;
        float pushGradStrength = scaleIndex / 2f;
        return picTo4K(pic, scaleIndex, pushStrength, pushGradStrength);
    }

    public BufferedImage picTo4K (BufferedImage pic, Float scaleIndex, Float pushStrength, Float pushGradStrength) throws Exception {
        pic = scale(pic, (int)(pic.getWidth() * scaleIndex), (int)(pic.getHeight() * scaleIndex));

        ImageKernel kernel = pool.borrowKernel();
        kernel.setPushStrength(pushStrength);
        kernel.setPushGradStrength(pushGradStrength);
        kernel.setBufferedImage(pic);
        kernel.process();
        kernel.updateBufferedImage();
        pool.returnKernel(kernel);

        return pic;
    }

    static BufferedImage scale(BufferedImage bi, int width, int height) {
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D)newImage.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.drawImage(bi, 0, 0, width, height, null);
        return newImage;
    }
}
