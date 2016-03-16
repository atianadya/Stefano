/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessor;



/**
 *
 * @author Dalva
 */
public class BitPlane {
	
	boolean bp[][];
	int width;
	int height;
	int bs;
	int sbwidth;
	int sbheight;
	
	// (0,0) = top left
	BitPlane(int x, int y, int blocksize) {
		width = x;
		height = y;
		bp = new boolean[width][height];
		bs = blocksize;
		sbwidth = width/bs;
		sbheight = height/bs;
	}
	
	public void setBit(boolean value, int x, int y) {
		bp[x][y] = value;
	}
	
	public void insert88Bit(int x, int y, byte[] data) {
		assert(width == 8 && height == 8);
		int dx = (x)*bs;
		int dy = (y)*bs;
		for (int i=0; i<bs; i++) {
			for (int j=0; j<bs; j++) {
				bp[dx+i][dy+j] = byte2bool(data[i])[j];
			}
		}
	}
	
	public byte[] read88bit() {
		assert(width == 8 && height == 8);
		byte[] retval = new byte[8];
		for (int i=0; i<8; i++){ 
			boolean[] bool = new boolean[8];
			for (int j=0; j<8; j++){ 
				bool[j] = bp[j][i];
			}
			retval[i] = bool2byte(bool);
		}
		return retval;
	}
	
	public static boolean[] byte2bool(byte x) {
		boolean[] boolArr = new boolean[8];
		boolArr[0] = ((x & 0x01) != 0);
		boolArr[1] = ((x & 0x02) != 0);
		boolArr[2] = ((x & 0x04) != 0);
		boolArr[3] = ((x & 0x08) != 0);
		boolArr[4] = ((x & 0x10) != 0);
		boolArr[5] = ((x & 0x20) != 0);
		boolArr[6] = ((x & 0x40) != 0);
		boolArr[7] = ((x & 0x80) != 0);
		return boolArr;
	}
	
	public static byte bool2byte(boolean[] x) {
		byte retval = 0;
		for (int i=0; i<8; i++) {
			if (x[i]) {
				retval = (byte) (retval | (1<<i));
			}
		}
		return retval;
	}
	
	public int getBitInt(int x, int y) {
		try {
			if (bp[x][y]) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception ex) {
			System.out.println("ERROR");
			System.out.println("wanted: "+x+","+y);
			System.out.println("max: "+width+","+height);
			ex.printStackTrace(System.out);
			System.exit(1);
			return 0;
		}
	}
	
	public boolean getBit(int x, int y) {
		try {
			return bp[x][y];
		} catch (Exception ex) {
			System.out.println("ERROR");
			System.out.println("wanted: "+x+","+y);
			System.out.println("max: "+width+","+height);
			ex.printStackTrace(System.out);
			System.exit(1);
			return false;
		}
	}
	
	public float getComplexity() {
		int totalBorder = 0;
		int totalPossibleBorder = (width-1)*(height)+(height-1)*(width);
		boolean current;
		current = bp[0][0];
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				if (current != bp[j][i]) {
					totalBorder++;
					current = bp[j][i];
				}
			}
		}
		current = bp[0][0];
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				if (current != bp[i][j]) {
					totalBorder++;
					current = bp[i][j];
				}
			}
		}
		return (float)totalBorder/(float)totalPossibleBorder;
	}
	
	public int getSBwidth() {
		return sbwidth;
	}
	
	public int getSBheight() {
		return sbheight;
	}
	
	public BitPlane getBlock(int x, int y) {
		BitPlane retval = new BitPlane(bs,bs,1);
		int dx = (x)*bs;
		int dy = (y)*bs;
		for (int i=0; i<bs; i++) {
			for (int j=0; j<bs; j++) {
				retval.setBit(this.getBit(dx+i, dy+j), i, j);
			}
		}
		return retval;
	}
}
