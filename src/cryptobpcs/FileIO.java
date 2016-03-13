/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptobpcs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author atia
 */

public class FileIO {
	
	public static void openFile(String path) throws IOException {
		message = Files.readAllBytes(Paths.get(path));
	}
    public static void setMessage(byte[] msg) {
        
		message = msg;
    }
    
    public static byte[] getMessage() {
        return message;
    }
    
    public static void saveFile(String path, byte[] message) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(path)) {
			fos.write(message);
		}
    }
    
    private static byte[] message;
}
