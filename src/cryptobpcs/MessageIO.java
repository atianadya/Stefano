/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptobpcs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author atia
 */

public class MessageIO {
    public static void setMessage(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        message = new String (encoded, encoding);
    }
    
    public static String getMessage() {
        return message;
    }
    
    public static void saveFile(String path, String message) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(path);
        out.println(message);
        out.close();
    }
    
    private static String message;
}
