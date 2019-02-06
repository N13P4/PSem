package project.encryption.hashing;

import java.security.MessageDigest;

public class SHA {

    private static String getString(String input, MessageDigest md) {
        byte[] result = md.digest(input.getBytes());
        StringBuilder SB = new StringBuilder();
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

    public static String getSHA224Hash(String input) throws Exception{

        MessageDigest md = MessageDigest.getInstance("SHA-224");
        return getString(input, md);
    }

    public static String getSHA384Hash(String input) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-384");
        return getString(input, md);
    }

    public static String getSHA512Hash(String input) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        return getString(input, md);
    }

}
