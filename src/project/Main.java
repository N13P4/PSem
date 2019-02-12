package project;

import project.additional.Passwordgenerator;
import project.encryption.AESCipher;
import project.encryption.Vigenere;
import project.encryption.hashing.MD;
import project.encryption.hashing.SHA;
import project.gui.WindowModule;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main implements ActionListener {


    public static void main(String[] args) {
        new Main();
    }

    private Gui instance;

    private Main() {
        this.instance = new Gui(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        //First checks if all modules are selected (not selected -> popup warning)

        if (event.getSource() == instance.getBtnEncrypt()) {
            btnencryptmethod();
        } else if (event.getSource() == instance.getCopypassword()) {
          btncopypasswordmethod();
        } else if (event.getSource() == instance.getCopyhash()) {
          btncopyhashmethod();
        } else if (event.getSource() == instance.getButtonpassword()) {
            btngetpasswordmethod();
        } else if (event.getSource() == instance.getBtnExpand()) {
            btnexpandmethod();
        } else if (event.getSource() == instance.getGeneratehash()) {
            btnhashmethod();
        } else if (event.getSource() == instance.getBtnPlus()) {
            btnplusmethod();
        } else if (event.getSource() == instance.getBtnMinus()) {
            btnminusmethod();
        } else if (event.getSource() == instance.getBtnCryptcopy2clipboard()) {
          copycryptomethod();
        } else if (event.getSource() == instance.getBtnDecrypt()) {
            btndecryptmethod();
        } else if (event.getSource() == instance.getSHA1checkbox()) {
            SHA1checkboxmethod();
        } else if (event.getSource() == instance.getSHA224checkbox()) {
            SHA224checkboxmethod();
        } else if (event.getSource() == instance.getSHA256checkbox()) {
            SHA256checkboxmethod();
        } else if (event.getSource() == instance.getSHA384checkbox()) {
            SHA384checkboxmethod();
        } else if (event.getSource() == instance.getSHA512checkbox()) {
            SHA512checkboxmethod();
        } else if (event.getSource() == instance.getMD2checkbox()) {
            MD2checkboxmethod();
        } else if (event.getSource() == instance.getMD5checkbox()) {
            MD5checkboxmethod();
        }
    }


    //Following are the methods are the ones of the eventhandler above

    private void btnencryptmethod(){

        for (WindowModule windowModule : instance.getWmList()) {
            if (!windowModule.isSelected()) {
                JOptionPane.showMessageDialog(instance, "All modules have to be selected!");
                return;
            }
        }
        String textToEncrypt = instance.getTextFieldInput().getText();
        for (WindowModule windowModule : instance.getWmList()) {
            String key = windowModule.getKey();
            switch (windowModule.getSelected()) {
                case "Vigenere 2.0":
                    if(key.equals("")){
                        key = "0";
                    }
                    try{
                        textToEncrypt = Vigenere.encrypt(textToEncrypt, Integer.valueOf(key));
                        // Verschlüsselt mit Vigenere
                        break;
                    }catch(Exception e){
                        JFrame vigenerepopup = new JFrame();
                        JOptionPane.showMessageDialog(vigenerepopup, "Key must be numeric!\n Error message: " + e.getMessage());
                        break;
                    }
                case "AES":
                    if (key.length() != 16) {
                        JFrame popup = new JFrame();
                        JOptionPane.showMessageDialog(popup, "Key must have a length of 16 chars.\nCurrent length is " + key.length());
                    }
                    try {
                        textToEncrypt = AESCipher.aesEncryptString(textToEncrypt, key);
                        //Verschlüsselt mit AES
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }

             /*   case "MD5":
                    try {
                        // textToEncrypt = MD.generatemd5hash(textToEncrypt);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break; */
                default:
                    break;
            }
        }
        instance.getTextFieldResult().setText(textToEncrypt);
    }
    private void btndecryptmethod(){
        for (WindowModule windowModule1 : instance.getWmList())
            if (!windowModule1.isSelected()) {
                JOptionPane.showMessageDialog(instance, "Alle Module müssen angekreuzt sein!");
            }
        String textToDecrypt = instance.getTextFieldInput().getText();
        for (WindowModule windowModule : instance.getWmList()) {
            String key = windowModule.getKey();
            switch (windowModule.getSelected()) {
                case "Vigenere 2.0":
                    if(key.equals("")){
                        JOptionPane.showMessageDialog(Gui.popup, "Key mustn't be empty.");
                        break;
                    }
                    try {
                        textToDecrypt = Vigenere.decrypt(textToDecrypt, Integer.valueOf(key));
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(Gui.popup, "Key must be numeric!\n Error message: " + e.getMessage());
                    }
                    break;
                case "AES":
                    if (instance.getTextFieldAesKey().getText().length() != 16) {
                        JOptionPane.showMessageDialog(Gui.popup, "Key must have a length of 16 chars.\nCurrent length is " + instance.getTextFieldAesKey().getText().length());
                    }
                    try {
                        textToDecrypt = AESCipher.aesDecryptString(textToDecrypt, instance.getTextFieldAesKey().getText());
                        //Verschlüsselt mit AES
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                case "MD5":

                    break;
                default:
                    break;
            }
        }
        instance.getTextFieldResult().setText(textToDecrypt);
    }
    private void btnhashmethod(){
        //Checks if a checkbox is selected - if not a message will pop up
        if(checktheboxes()){
            JOptionPane.showMessageDialog(Gui.popup, "Select a hashing algorithm!");
        }else{
            if (instance.getMD2checkbox().isSelected()) {
                try {
                    instance.getTextfieldhashoutput().setText(MD.getMD2Hash(instance.getTextfieldhashinput().getText()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Gui.popup, "Error message: " + e.getMessage());
                }
            } else if (instance.getMD5checkbox().isSelected()) {
                try {
                    instance.getTextfieldhashoutput().setText(MD.getMD5Hash(instance.getTextfieldhashinput().getText()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Gui.popup, "Error message: " + e.getMessage());
                }
            } else if (instance.getSHA1checkbox().isSelected()) {
                try {
                    instance.getTextfieldhashoutput().setText(SHA.getSHA1Hash(instance.getTextfieldhashinput().getText()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Gui.popup, "Error message: " + e.getMessage());
                }
            } else if (instance.getSHA224checkbox().isSelected()) {
                try {
                    instance.getTextfieldhashoutput().setText(SHA.getSHA224Hash(instance.getTextfieldhashinput().getText()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Gui.popup, "Error message: " + e.getMessage());
                }
            } else if (instance.getSHA256checkbox().isSelected()) {
                try {
                    instance.getTextfieldhashoutput().setText(SHA.getSHA256Hash(instance.getTextfieldhashinput().getText()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Gui.popup, "Error message: " + e.getMessage());
                }
            } else if (instance.getSHA384checkbox().isSelected()) {
                try {
                    instance.getTextfieldhashoutput().setText(SHA.getSHA384Hash(instance.getTextfieldhashinput().getText()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Gui.popup, "Error message: " + e.getMessage());
                }
            } else if (instance.getSHA512checkbox().isSelected()) {
                try {
                    instance.getTextfieldhashoutput().setText(SHA.getSHA512Hash(instance.getTextfieldhashinput().getText()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Gui.popup, "Error message: " + e.getMessage());
                }
            }
        }
    }
    private void btncopypasswordmethod(){
        if (instance.getTextfieldpasswordoutput().getText().equals("")) {
            JOptionPane.showMessageDialog(Gui.popup, "Nothing to copy");
        } else {
            String c = instance.getTextfieldpasswordoutput().getText();
            StringSelection stringSelection = new StringSelection(c);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
    }
    private void btncopyhashmethod(){
        if (instance.getTextfieldhashoutput().getText().equals("")) {
            JOptionPane.showMessageDialog(Gui.popup, "Nothing to copy");
        } else {
            String c = instance.getTextfieldhashoutput().getText();
            StringSelection stringSelection = new StringSelection(c);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
    }
    private void btngetpasswordmethod(){
       try{
           instance.getTextfieldpasswordoutput().setText(Passwordgenerator.execute(instance.getTextPasswordLength().getText()));
       }catch(Exception e){
           JOptionPane.showMessageDialog(Gui.popup, "Error message: " + e.getMessage());
       }
    }
    private void btnexpandmethod(){
        if (!instance.isExpanded()) {
            instance.setSize(1200, 225 + (instance.getWmList().size() * 70));
            instance.getBtnExpand().setText("<");
        } else {
            instance.setSize(635, 225 + (instance.getWmList().size() * 70));
            instance.getBtnExpand().setText(">");
        }
        instance.setExpanded(!instance.isExpanded());
    }
    private void btnplusmethod(){
        if (!(instance.getHeight() + 40 > Toolkit.getDefaultToolkit().getScreenSize().height - 40)) {
            instance.getWindowModuleList().add(new WindowModule(instance.getWindowModuleList().size(), 40));
            instance.reload();
        }
    }
    private void btnminusmethod(){
        if (!(instance.getWmList().size() == 1)) {
            instance.getWindowModuleList().removeLast();
            instance.reload();
        }
    }
    private void copycryptomethod(){
        //Copies the text from "textFieldResult" to your clipboard - if the textfield is empty a message will pop up
        if (instance.getTextFieldResult().getText().equals("")) {
            JOptionPane.showMessageDialog(Gui.popup, "Nothing to copy");
        } else {
            String c = instance.getTextFieldResult().getText();
            StringSelection stringSelection = new StringSelection(c);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
    }

    // Below are the methods for the hashing checkboxes. If one checkbox is enabled all others will be disabled.
    private void SHA1checkboxmethod(){
        if (instance.getSHA1checkbox().isSelected()) {
            disableall();
            instance.getSHA1checkbox().setEnabled(true);
        } else {
            enableall();
        }
    }
    private void SHA224checkboxmethod(){
        if (instance.getSHA224checkbox().isSelected()) {
            disableall();
            instance.getSHA224checkbox().setEnabled(true);
        } else {
            enableall();
        }
    }
    private void SHA256checkboxmethod(){
        if (instance.getSHA256checkbox().isSelected()) {
           disableall();
           instance.getSHA256checkbox().setEnabled(true);
        } else {
            enableall();
        }
    }
    private void SHA384checkboxmethod(){
        if (instance.getSHA384checkbox().isSelected()) {
            disableall();
            instance.getSHA384checkbox().setEnabled(true);
        } else {
            enableall();
        }
    }
    private void SHA512checkboxmethod(){
        if (instance.getSHA512checkbox().isSelected()) {
           disableall();
           instance.getSHA512checkbox().setEnabled(true);
        } else {
            enableall();
        }
    }
    private void MD2checkboxmethod(){
        if (instance.getMD2checkbox().isSelected()) {
           disableall();
           instance.getMD2checkbox().setEnabled(true);
        } else {
            enableall();
        }
    }
    private void MD5checkboxmethod(){
        if (instance.getMD5checkbox().isSelected()) {
            disableall();
            instance.getMD5checkbox().setEnabled(true);
        } else {
            enableall();
        }
    }
    //This method enables all checkboxes again
    private void enableall() {
        //Enables all checkboxes again
        instance.getMD2checkbox().setEnabled(true);
        instance.getMD5checkbox().setEnabled(true);
        instance.getSHA1checkbox().setEnabled(true);
        instance.getSHA224checkbox().setEnabled(true);
        instance.getSHA256checkbox().setEnabled(true);
        instance.getSHA384checkbox().setEnabled(true);
        instance.getSHA512checkbox().setEnabled(true);
    }
    private void disableall(){
        instance.getMD2checkbox().setEnabled(false);
        instance.getMD5checkbox().setEnabled(false);
        instance.getSHA1checkbox().setEnabled(false);
        instance.getSHA224checkbox().setEnabled(false);
        instance.getSHA256checkbox().setEnabled(false);
        instance.getSHA384checkbox().setEnabled(false);
        instance.getSHA512checkbox().setEnabled(false);
    }
    //Checks if no checkbox is selected
    private boolean checktheboxes() {
        return !instance.getMD2checkbox().isSelected() && !instance.getMD5checkbox().isSelected() && !instance.getSHA224checkbox().isSelected() && !instance.getSHA256checkbox().isSelected() && !instance.getSHA384checkbox().isSelected() && !instance.getSHA384checkbox().isSelected() && !instance.getSHA512checkbox().isSelected();
    }
    // End of "hashing-checkbox-methods"


    //End of "eventhandler-methods"
}
