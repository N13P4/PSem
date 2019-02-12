package project.additional;


import java.io.*;
import org.jetbrains.annotations.NotNull;
import project.Gui;
import org.apache.commons.lang3.RandomStringUtils;
import javax.swing.*;


public class Passwordgenerator {

    private static File f = new File("password_pool.cfg");


    public static String execute(String length) throws IOException{

        String pool;
        try{
            int l = Integer.parseInt(length);
            if(l < 1){
                JOptionPane.showMessageDialog(Gui.popup,"Length must be greater than 0.");
            }else{
                if(f.exists() && f.length() != 0){
                    return getString(l);
                }else{
                    JOptionPane.showMessageDialog(Gui.popup, "Either there was no config file or it was empty.\nDefault pool was stored in \"password_pool.cfg\" edit this file to edit the password pool.");
                    FileWriter fw = new FileWriter("password_pool.cfg");
                    fw.write("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"§$%&/()=?´`+*~#'-_.:,;\\}][{€<>");
                    fw.close();
                    return getString(l);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(Gui.popup, "Invalid input!\nError message: " + e.getMessage());
        }
        return "error";
    }

    @NotNull
    private static String getString(int l) throws IOException {
        String pool;
        FileReader fr = new FileReader("password_pool.cfg");
        BufferedReader br = new BufferedReader(fr);
        pool = br.readLine();
        return RandomStringUtils.random(l, pool);
    }
}
