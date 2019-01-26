package project.encryption.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {

    public static String getSHA1Hash(String input) throws NoSuchAlgorithmException{

        MessageDigest md = MessageDigest.getInstance("SHA1");
        byte[] result = md.digest(input.getBytes());
        StringBuffer SB = new StringBuffer();
        for(int i = 0; i < result.length; i++){

            SB.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return SB.toString();
    }

}
