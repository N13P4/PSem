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
        System.out.println(newText.toString());
        return newText.toString();
    }

}
