/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptobpcs;

/**
 *
 * @author atia
 */
public class VigenereExtended {
    public static String encipher(String plaintext, String keyword) {
        String ciphertext = "";
        
        for(int i=0, j=0; i<plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            ciphertext += (char)((ch + keyword.charAt(j)) % 256);
            j = ++j % keyword.length();
        }
        
        return ciphertext;
    }
    
    public static String decipher (String ciphertext, String keyword) {
        String plaintext = "";
        
        for (int i=0, j=0; i<ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);
            plaintext += (char)(((ch - keyword.charAt(j)) % 256 + 256) % 256);
            j = ++j % keyword.length();
        }
        
        return plaintext;
    }
}
