package project.additional;


import java.io.*;
import project.Gui;
import org.apache.commons.lang3.RandomStringUtils;
import javax.swing.*;


public class Passwordgenerator {

    static File f = new File("password_pool.cfg");

    public static String execute(String length){
        try{
            int l = Integer.parseInt(length);
            if(l < 1){
                JOptionPane.showMessageDialog(Gui.popup,"Length must be greater than 0.");
            }else{
                if(f.exists() && f.length() != 0){
                    return generatepassword(l);
                }else{
                    JOptionPane.showMessageDialog(Gui.popup, "Either there was no config file or it was empty.\nDefault pool was stored in \"password_pool.cfg\" edit this file to edit the password pool.");
                    FileWriter fw = new FileWriter("password_pool.cfg");
                    fw.write("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"§$%&/()=?´`+*~#'-_.:,;\\}][{€<>");
                    fw.close();
                    generatepassword(l);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(Gui.popup, "Invalid input!\nError message: " + e.getMessage());
        }
        return "error";
    }




    public static String generatepassword(int length) throws IOException, NumberFormatException {
        String pool = "";
        FileReader fr = new FileReader("password_pool.cfg");
        BufferedReader br = new BufferedReader(fr);
        pool = br.readLine();
        return RandomStringUtils.random(length, pool);

    }
}
