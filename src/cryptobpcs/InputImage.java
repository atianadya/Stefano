/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptobpcs;

import imageprocessor.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author atia
 */
public class InputImage {
    public static Image img = new Image();
    
    public static void setImage(String path) {
        img.load(path);
    }
    
    public static BufferedImage getImage() {
        return img.getBI();
    }
	
	public static String getFilename() {
		return img.getLoc();
	}
    
    public static Boolean isNull() {
        return img.isNull();
    }
}
