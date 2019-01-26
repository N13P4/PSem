package project.encryption.hashing;

import java.security.MessageDigest;

public class SHA {

    public static String getString(String input, MessageDigest md) throws Exception {
        byte[] result = md.digest(input.getBytes());
        StringBuffer SB = new StringBuffer();
        for (byte b : result) {

            SB.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return SB.toString();
    }


    public static String getSHA1Hash(String input) throws Exception{

        MessageDigest md = MessageDigest.getInstance("SHA1");
        return getString(input, md);
    }





    public static String getSHA256Hash(String input) throws Exception{

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return getString(input, md);

    }

}
