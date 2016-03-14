/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessor;

import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_USHORT_GRAY;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.lang.Exception;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dalva
 */
public class BytePlane {
	
	// array 0=LSB, 7=MSB
	BitPlane bp[];
	int width;
	int height;
	
	BytePlane(int x, int y, int blocksize) {
		bp = new BitPlane[8];
		width = x;
		height = y;
		for (int i=0; i<8; i++) {
			bp[i] = new BitPlane(width,height,blocksize);
		}
	}
	
	public void setByteAtLoc(int x, int y, int byt) {
		for (int i=0; i<8; i++) {
			bp[i].setBit(((byt&1) == 1), x, y);
			byt = byt>>1;
		}
	}
	
	public int getByteAtLoc(int x, int y) {
		int retval = 0;
		for (int i=0; i<8; i++) {
			retval = retval & bp[i].getBitInt(x, y);
			retval = retval<<1;
		}
		return retval;
	}
	
	public void writePlanes(String name) {
		for (int b=0; b<8; b++) {
			BufferedImage img = new BufferedImage(width, height, TYPE_USHORT_GRAY);
			for (int i=0; i<width; i++) {
				for (int j=0; j<height; j++) {
					if (bp[b].getBit(i, j)) {
						img.setRGB(i, j, 0xFFFF);
					} else {
						img.setRGB(i, j, 0);
					}
				}
			}
			try {
				File outputfile = new File("bip "+name+" "+b+".png");
				ImageIO.write(img, "png", outputfile);
			} catch (IOException e) {
				e.printStackTrace(System.out);
				System.exit(1);
			}
			System.out.println(name+b+" complexity "+bp[b].getComplexity());
			System.out.println(name+b+" w"+width+" h"+height);
			System.out.println(name+b+" SBw"+bp[b].getSBwidth()+" SBh"+bp[b].getSBheight());
		}
	}
	
	public int getPossibleInsertions(int thresh) {
		int num = 0;
		for (int b=0; b<8; b++) {
			int sbwidth = bp[b].getSBwidth();
			int sbheight = bp[b].getSBheight();
			for (int i=0; i<sbwidth; i++) {
				for (int j=0; j<sbheight; j++) {
					float relativeComplexity = bp[b].getBlock(i, j).getComplexity();
					relativeComplexity -= 0.5;
					relativeComplexity = Math.abs(relativeComplexity);
					relativeComplexity *= 40;
					//System.out.println(i+","+j+" complexity "+relativeComplexity);
					if (relativeComplexity < thresh) {
						num++;
					}
				}
			}
		}
		return num;
	}
	
	public void insert(int n, int thresh, byte[] data) { //can be optimized.
		int num = 0;
		for (int b=7; b>=0; b--) {
			int sbwidth = bp[b].getSBwidth();
			int sbheight = bp[b].getSBheight();
			for (int i=0; i<sbwidth; i++) {
				for (int j=0; j<sbheight; j++) {
					float relativeComplexity = bp[b].getBlock(i, j).getComplexity();
					relativeComplexity -= 0.5;
					relativeComplexity = Math.abs(relativeComplexity);
					relativeComplexity *= 40;
					//System.out.println(i+","+j+" complexity "+relativeComplexity);
					if (relativeComplexity < thresh) {
						num ++;
						if (num == n) {
							//put
							bp[b].getBlock(i, j).insert88Bit(data);
						}
					}
				}
			}
		}
	}
	
	public byte[] get(int n, int thresh) { 
		try {
			//can be optimized.
			int num = 0;
			for (int b=7; b>=0; b--) {
				int sbwidth = bp[b].getSBwidth();
				int sbheight = bp[b].getSBheight();
				for (int i=0; i<sbwidth; i++) {
					for (int j=0; j<sbheight; j++) {
						float relativeComplexity = bp[b].getBlock(i, j).getComplexity();
						relativeComplexity -= 0.5;
						relativeComplexity = Math.abs(relativeComplexity);
						relativeComplexity *= 40;
						//System.out.println(i+","+j+" complexity "+relativeComplexity);
						if (relativeComplexity < thresh) {
							num ++;
							if (num == n) {
								//get
								return bp[b].getBlock(i, j).read88bit();
							}
						}
					}
				}
			}
			throw new Exception("block not found");
		} catch (Exception ex) {
			Logger.getLogger(BytePlane.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			System.exit(1);
		}
		return new byte[1];
	}
}
