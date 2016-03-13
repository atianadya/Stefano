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
public class ImageProcessor {
	

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Image img = new Image();
		img.load("1noised.png");
		System.out.println(img.getPossibleInsertions(4));
		try {
		img.insertData(1, "asdfghjk");
		String extracted = img.getData(1);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
	
}
