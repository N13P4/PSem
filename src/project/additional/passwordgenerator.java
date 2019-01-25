package project.additional;

import org.apache.commons.lang3.RandomStringUtils;

public class passwordgenerator {

    public String generatepassword(int length){

        String pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIKLMNOPQRSTUVWXYZ0123456789!\"§$%&/()=?`´+*~#'-_.:,;<>|^[]{}\\€@";

        String password = RandomStringUtils.random(length, pool);

        return password;

    }


}
