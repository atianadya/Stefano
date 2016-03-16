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
		byte asdf = 0;
		asdf =  (byte) (asdf | (1<<3));
		System.out.println(asdf);
		System.out.println(asdf|4);
		
		Image img = new Image();
		img.load("1snoised.png");
		System.out.println(img.getPossibleInsertions(4));
		img.save("test.png");
		try {
			//img.insertData(1, "eAxPc7IXQe2xw38o3G5pKK2sHJsb2wUk1CPN3bFxFxNUk9vLKZjyYKopzn9eMwrxtrbVPnke5f8GehRkeAxPc7IXQe2xw38o3G5pKK2sHJsb2wUk1CPN3bFxFxNUk9vLKZjyYKopzn9eMwrxtrbVPnke5f8GehRk");
			img.insertData(1, "Oj9NyLc1Nul0Ewfd6PC6GSncuYhJUufOa93e2GMe34N0Ly03AXCIzTLPU8PYP7zeiNotfDrWbvspW0cyOj9NyLc1Nul0Ewfd6PC6GSncuYhJUufOa93e2GMe34N0Ly03AXCIzTLPU8PYP7zeiNotfDrWbvspW0cy");
			System.out.println("saved");
			String extracted = img.getData(1);
			System.out.println("getting");
			System.out.println(extracted);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
	
}
