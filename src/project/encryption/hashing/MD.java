package project.encryption.hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MD {

    private static String getString(String input, MessageDigest md) {
        byte[] hashinbytes = md.digest(input.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashinbytes) {
            sb.append(String.format("%02x", b));

        }
        return sb.toString();
    }


    public static String getMD5Hash(String input) throws Exception{

       MessageDigest md = MessageDigest.getInstance("MD5");
        return getString(input, md);
    }

    public static String getMD2Hash(String input) throws Exception{

        MessageDigest md = MessageDigest.getInstance("MD2");
        return getString(input, md);
    }





}
