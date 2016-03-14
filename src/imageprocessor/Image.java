/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.imageio.ImageIO;

/**
 *
 * @author Dalva
 */
public class Image {
	
	BufferedImage img;
	BytePlane red;
	BytePlane green;
	BytePlane blue;
	String filename;
	
	public Image() {
		img = null;
		red = null;
		green = null;
		blue = null;
	}
	
	public void load(String loc) {
		try {
			img = ImageIO.read(new File(loc));
			filename = loc;
		} catch (IOException e) {
			e.printStackTrace(System.out);
			System.exit(1);
		}
		regenerateBytePlane();
	}
	
	public BufferedImage getBI() {
		return img;
	}
	
	public String getLoc() {
		return filename;
	}
	
	public void copy(Image img) {
		this.img = img.getBI();
		regenerateBytePlane();
	}
	
	public void save(String loc) {
		try {
			File outputfile = new File(loc);
			ImageIO.write(img, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	public void regenerateBytePlane() {
		int width = img.getWidth();
		int height = img.getHeight();
		red = new BytePlane(width, height, 8);
		green = new BytePlane(width, height, 8);
		blue = new BytePlane(width, height, 8);
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				int rgb = img.getRGB(i,j);
				int r = (rgb >> 16) & 0xFF;
				int g = (rgb >>  8) & 0xFF;
				int b = (rgb      ) & 0xFF;
				red.setByteAtLoc(i, j, r);
				green.setByteAtLoc(i, j, g);
				blue.setByteAtLoc(i, j, b);
			}
		}
		if (false) { //write planes debug
			red.writePlanes("r");
			green.writePlanes("g");
			blue.writePlanes("b");
		}
	}
	
	public void reconstructBI() {
		int width = img.getWidth();
		int height = img.getHeight();
		int rgb;
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				rgb = blue.getByteAtLoc(i, j);
				rgb = rgb & (green.getByteAtLoc(i, j)<<8);
				rgb = rgb & (blue.getByteAtLoc(i, j)<<16);
				img.setRGB(i, j, rgb);
			}
		}
	}
	
	public int getPossibleInsertions(int thresh) {
		int num = 0;
		num += red.getPossibleInsertions(thresh);
		num += green.getPossibleInsertions(thresh);
		num += blue.getPossibleInsertions(thresh);
		return num;
	}
	
    public Boolean isNull() {
        return img==null;
    }
	
	public void insertData(int thresh, String message) throws java.lang.Exception {
		assert (message.length()%8==0);
		byte[] msg = message.getBytes(Charset.defaultCharset());
		int Rtot = red.getPossibleInsertions(thresh);
		int Gtot = green.getPossibleInsertions(thresh);
		int Btot = blue.getPossibleInsertions(thresh);
		int len = msg.length;
		int Rcur = 1;
		int Gcur = 1;
		int Bcur = 1;
		boolean stillworking;
		for (int i=0; i<len;) {
			stillworking = false;
			if (Rcur <= Rtot) {
				red.insert(Rcur, thresh, msg);
				i++;
				Rcur++;
				stillworking = true;
			}
			if (Gcur <= Gtot) {
				green.insert(Rcur, thresh, msg);
				i++;
				Gcur++;
				stillworking = true;
			}
			if (Bcur <= Btot) {
				blue.insert(Rcur, thresh, msg);
				i++;
				Bcur++;
				stillworking = true;
			}
			if (!stillworking) {
				throw new Exception("run out of insertion space");
			}
		}
		reconstructBI();
	}
	
	public String getData(int thresh) throws java.lang.Exception {
		String retval;
		int len = getPossibleInsertions(thresh)-300;
		byte[] msg = new byte[len+1000];
		byte[] msgnew;
		int Rtot = red.getPossibleInsertions(thresh)-100;
		int Gtot = green.getPossibleInsertions(thresh)-100;
		int Btot = blue.getPossibleInsertions(thresh)-100;
		int Rcur = 1;
		int Gcur = 1;
		int Bcur = 1;
		boolean stillworking;
		for (int i=0; i<len;) {
			stillworking = false;
			if (Rcur <= Rtot) {
				msgnew = red.get(Rcur, thresh);
				for (int mln=0; mln<8; mln++) {
					msg[i+mln] = msgnew[mln];
				}
				i++;
				Rcur++;
				stillworking = true;
			}
			if (Gcur <= Gtot) {
				msgnew = green.get(Rcur, thresh);
				for (int mln=0; mln<8; mln++) {
					msg[i+mln] = msgnew[mln];
				}
				i++;
				Gcur++;
				stillworking = true;
			}
			if (Bcur <= Btot) {
				msgnew = blue.get(Rcur, thresh);
				for (int mln=0; mln<8; mln++) {
					msg[i+mln] = msgnew[mln];
				}
				i++;
				Bcur++;
				stillworking = true;
			}
			if (!stillworking) {
				throw new Exception("something wrong... loop not responding");
			}
		}
		retval = new String (msg, Charset.defaultCharset());
		return retval;
	}
}
