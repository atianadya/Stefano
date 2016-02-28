/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptobpcs;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author atia
 */
public class CryptoBPCS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedImage img1 = null;
        BufferedImage img2 = null;

        try {
            img1 = ImageIO.read(new File("C:\\Users\\User\\Pictures\\a ref\\tumblr_njke98ZPdK1rqlgm2o1_500.jpg"));
            img2 = ImageIO.read(new File("C:\\Users\\User\\Pictures\\a ref\\tumblr_njke98ZPdK1rqlgm2o1_500-min.jpg"));
        } catch (IOException e) {

        }

        PSNR.calculatePSNR(img1,img2);
    }
    
}
