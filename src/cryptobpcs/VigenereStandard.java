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
public class VigenereStandard {
    
    // encipher
    // format mode 1 == nospace
    // format mode 2 == with space
    public static String encipher(String plaintext, String keyword,
            int formatmode) {
        if (formatmode!=1 && formatmode!=2) {
            throw new IllegalArgumentException("Wrong format mode: "+ formatmode);
        }
        
        String ciphertext = "";
        
        plaintext = plaintext.toUpperCase();
        keyword = keyword.toUpperCase();
        
        for (int i=0, j=0; i<plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            if ((ch < 'A' || ch > 'Z') && formatmode==1){
            } else if ((ch < 'A' || ch > 'Z') && formatmode==2) {
                if (ch == ' ') 
                    ciphertext += ch;
            } else {
                ciphertext += (char)((ch + keyword.charAt(j)) % 26 + 'A');
                j = ++j % keyword.length();
            }
        }
        
        return ciphertext;
    }
    
    // decipher
    public static String decipher(String ciphertext, String keyword) {
        String plaintext = "";
        
        ciphertext = ciphertext.toUpperCase();
        keyword = keyword.toUpperCase();
        
        for (int i=0, j=0; i<ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);
            plaintext += (char)(((ch - keyword.charAt(j)) % 26 + 26) % 26 + 'A');
            j = ++j % keyword.length();
        }
        
        return plaintext;
    }
    
}
