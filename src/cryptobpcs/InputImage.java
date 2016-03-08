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
public class InputImage {
    static BufferedImage img = null;
    static String filename;
    
    public static void setImage(String path) {
        try {
            img = ImageIO.read(new File(path));
            filename = path;
        } catch (IOException e) {
        
        }    
    }
    
    public static BufferedImage getImage() {
        return img;
    }
    
    public static String getFilename() {
        return filename;
    }
    
    public static Boolean isNull() {
        return img==null;
    }
}
