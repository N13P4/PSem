package project.kryptoattacks;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CryptoAttacks {

    //Caesar

    private static int caesar_Key(String text) {
        text = text.toLowerCase();
        HashMap<Character, Integer> letters = new HashMap<>();
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(letters.keySet().contains(c)) {
                letters.put(c, letters.get(c) + 1);
            } else {
                letters.put(c, 1);
            }
        }
        int mostLetter = 0;
        char ch = ' ';
        for(Character c : letters.keySet()) {
            if(mostLetter < letters.get(c) && c != ' ') {
                mostLetter = letters.get(c);
                ch = c;
            }
        }
        int len = (ch - 97 - 4);
        if(len >= 0) return len;
        else return 25 - Math.abs(len);
    }

    public static String caesar_decode(String text) {
        int key = caesar_Key(text);
        text = text.toLowerCase();
        StringBuilder newText = new StringBuilder();
        System.out.println(key);
        for(int i = 0; i < text.length(); i++) {
            int cc1 = text.charAt(i);
            if(text.charAt(i) > 96 && text.charAt(i) < 123) {
                 cc1 -= key;
                if(cc1 < 97) {
                    int ab = 97 - cc1;
                    cc1 = 123 - ab;
                }
            }
            newText.append((char)cc1);
        }
        return newText.toString();
    }

    public static String caesar_encode(String text, int key) {
        key = Math.abs(key) % 26;
        text = text.toLowerCase();
        String encrypted_Message = "";
        char chr = ' ';
        for(int i = 0; i < text.length(); i++){
            chr = text.charAt(i);
            if(chr == ' ') {
                encrypted_Message += chr;
                continue;
            }


            if(chr >= 'a' && chr <= 'z'){
                chr = (char)(chr + key);

                if(chr > 'z'){
                    chr = (char)('a' + (chr - 'z'));
                }

                encrypted_Message += chr;
            }
        }
        return encrypted_Message;
    }

    private static String vigenere_key(String text) {
        return null;
    }

    public static String vigenere_decode(String text) {
        String key = vigenere_key(text);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int alphabetSize = alphabet.length();
        int textSize = text.length();
        int keySize = key.length();
        StringBuilder decryptedText = new StringBuilder(textSize);

        for (int i = 0; i < textSize; i++)
        {
            char encyrptChar = text.charAt(i); // get the current character to be shifted
            char keyChar = key.charAt(i % keySize); // use key again if the end is reached
            int plainPos = alphabet.indexOf(encyrptChar); // plain character's position in alphabet string
            // decrypt the input text
            int keyPos = alphabet.indexOf(keyChar); // key character's position in alphabet
            int shiftedPos = plainPos-keyPos;
            if(shiftedPos < 0)
                shiftedPos += alphabetSize;
            decryptedText.append(alphabet.charAt(shiftedPos));
        }

        return decryptedText.toString();
    }

}
