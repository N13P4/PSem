package project.additional;

import java.io.*;

import org.apache.commons.lang3.RandomStringUtils;

import javax.swing.*;


public class Passwordgenerator {





    public static String generatepassword(int length) throws IOException{

        String pool = "";
        File f = new File("password_pool.cfg");
        FileReader fr = new FileReader("password_pool.cfg");
        BufferedReader br = new BufferedReader(fr);
        JFrame popup = new JFrame();

        if(f.exists() && f.length() != 0){
            // If the file password_pool.cfg exists it will read the lines and store it in String pool as the pool for the password.
            pool = br.readLine();
            br.close();
        }else{
            //If the file doesn't exist it will create it and write in the default pool. Then it will generate a password using the pool (as above).
            FileWriter fw = new FileWriter("password_pool.cfg");
            fw.write("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"§$%&/()=?´`+*~#'-_.:,;\\}][{€<>");
            fw.close();
            JOptionPane.showMessageDialog(popup, "Either there was no config file or it was empty.\nDefault pool was stored in \"password_pool.cfg\" edit this file to edit the password pool.");
            pool = br.readLine();
            br.close();
        }





        //Returns password string
        return RandomStringUtils.random(length, pool);

    }


}
