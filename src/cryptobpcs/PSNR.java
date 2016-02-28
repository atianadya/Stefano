/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptobpcs;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

/**
 *
 * @author atia
 */
public class PSNR {
    public static double calculatePSNR(BufferedImage image1, BufferedImage image2) {
        int height = image1.getHeight();
        int width = image1.getWidth();
        double psnr, rms = 0;
        
        rms = calculateRMS(image1, image2);
        psnr = 20.0 * log10(256/rms);
        
        System.out.println(psnr);
        
        return psnr;
    }
    
    private static double calculateRMS(BufferedImage image1, BufferedImage image2) {
        double rms = 0;
        
        int height = image1.getHeight();
        int width = image1.getWidth();
        System.out.println("size: " + height + "," + width);
        
        Raster img1 = image1.getRaster();
        Raster img2 = image2.getRaster();
        
        for (int i=0; i<image1.getHeight(); i++) {
            for (int j=0; j<image1.getWidth(); j++) {
                rms += Math.pow(img1.getSample(j, i, 0) - img2.getSample(j, i, 0), 2);
            }
        }
        
        rms /= (double) (height * width);
        rms = Math.pow(rms,0.5);
        
        return rms;
    }
    
    private static double log10(double number) {
        return Math.log(number) / Math.log(10);
    }
}

