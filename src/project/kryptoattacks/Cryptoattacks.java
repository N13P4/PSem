package project.kryptoattacks;

import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class Cryptoattacks {

    private static final ArrayList<String> words = loadWords();

    public static String decryptCaesar(String text) {
        //DEBUG: Zeit zum berechnen des Schlüssels
        Instant tmpTime1 = Instant.now();
        String[] textWords = text.split(" ");
        for(int i = 0; i < textWords.length; i++) {

        }
        return "";
    }

    private static ArrayList<String> loadWords() {
        ArrayList<String> output = new ArrayList<>();
        try {
            File file = new File(Cryptoattacks.class.getClassLoader().getResource("project/kryptoattacks/words.txt").toURI());
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                output.add(sc.next());
            }
        } catch (Exception e) {

        }
        return output;
    }

}
