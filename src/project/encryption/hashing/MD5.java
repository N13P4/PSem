package project.encryption.hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MD5 {

    public static String generatemd5hash(String in) throws Exception{

       String input = in;

       MessageDigest md = MessageDigest.getInstance("MD5");
       byte[] hashInBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));

       StringBuilder sb = new StringBuilder();
       for(byte b : hashInBytes){
           //%02x is a format specifier used to convert one character to a hexadecimal string
           sb.append(String.format("%02x", b));
       }

        return sb.toString();
    }

}
