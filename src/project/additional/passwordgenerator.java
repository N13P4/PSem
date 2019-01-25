package project.additional;

import org.apache.commons.lang3.RandomStringUtils;

public class passwordgenerator {

    public static String generatepassword(int length) throws Exception{
        // Characters used as a pool for generating a password => Your password exists of these chars.
        String pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIKLMNOPQRSTUVWXYZ0123456789!\"§$%&/()=?`´+*~#'-_.:,;<>|^[]{}\\€@";
        //Generates the password | uses length from class MainWindow as Input
        String password = RandomStringUtils.random(length, pool);

        return password;

    }


}
