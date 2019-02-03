package project.additional;

import org.apache.commons.lang3.RandomStringUtils;

public class passwordgenerator {

    public static String generatepassword(int length){
        // Characters used as a pool for generating a password => Your password exists of these chars.
        String pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIKLMNOPQRSTUVWXYZ0123456789!\"§$%&/()=?`´+*~#'-_.:,;<>|^[]{}\\€@";
        //Generates the password | uses length from class MainWindow as Input

        return RandomStringUtils.random(length, pool);

    }


}
