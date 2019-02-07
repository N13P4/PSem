package project;

import project.additional.passwordgenerator;
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

        /**
         * Überprüft zuerst, ob alle Module angekreuzt wurden, wenn nicht, gibt eine Fehlermeldung in Form
         * Eines JOptionPane aus, sonst, verschlüsselt den Input nach der/den ausgewählte(n) Verschlüsselungsalgorithmen
         * Und gibt in dann über das unter JTextField aus.
         */
        if (event.getSource() == instance.getBtnEncrypt()) {
            for (WindowModule windowModule : instance.getWmList()) {
                if (!windowModule.isSelected()) {
                    JOptionPane.showMessageDialog(instance, "Alle Module müssen angekreuzt sein!");
                    return;
                }
            }
            String textToEncrypt = instance.getTextFieldInput().getText();
            for (WindowModule windowModule : instance.getWmList()) {
                switch (windowModule.getSelected()) {
                    case "Vigenere 2.0":
                        textToEncrypt = Vigenere.encrypt(textToEncrypt, Integer.valueOf(instance.getTextfieldVigenere().getText()));
                        // Verschlüsselt mit Vigenere
                        break;
                    case "AES":
                        if (instance.getTextFieldAesKey().getText().length() != 16) {
                            JFrame popup = new JFrame();
                            JOptionPane.showMessageDialog(popup, "Key must have a length of 16 chars.\nCurrent length is " + instance.getTextFieldAesKey().getText().length());
                        }
                        try {
                            textToEncrypt = AESCipher.aesEncryptString(textToEncrypt, instance.getTextFieldAesKey().getText());
                            //Verschlüsselt mit AES
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    case "MD5":
                        try {
                            // textToEncrypt = MD.generatemd5hash(textToEncrypt);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    default:
                        break;
                }
            }
            instance.getTextFieldResult().setText(textToEncrypt);

        } else if (event.getSource() == instance.getCopypassword()) {
            if (instance.getTextfieldpasswordoutput().getText().equals("")) {
                JFrame popup = new JFrame();
                JOptionPane.showMessageDialog(popup, "Nothing to copy");
            } else {
                String c = instance.getTextfieldpasswordoutput().getText();
                StringSelection stringSelection = new StringSelection(c);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        } else if (event.getSource() == instance.getCopyhash()) {
            if (instance.getTextfieldhashoutput().getText().equals("")) {
                JFrame popup = new JFrame();
                JOptionPane.showMessageDialog(popup, "Nothing to copy");
            } else {
                String c = instance.getTextfieldhashoutput().getText();
                StringSelection stringSelection = new StringSelection(c);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }

        } else if (event.getSource() == instance.getButtonpassword()) {
            try {
                int length = Integer.valueOf(instance.getTextPasswordLength().getText());
                instance.getTextfieldpasswordoutput().setText(passwordgenerator.generatepassword(length));
            } catch (Exception e) {
                JFrame popup = new JFrame();
                JOptionPane.showMessageDialog(popup, "Invalid value - Numbers only!");
            }

        } else if (event.getSource() == instance.getBtnExpand()) {
            if (!instance.isExpanded()) {
                instance.setSize(1200, 225 + (instance.getWmList().size() * 70));
                instance.getBtnExpand().setText("<");
            } else {
                instance.setSize(635, 225 + (instance.getWmList().size() * 70));
                instance.getBtnExpand().setText(">");
            }
            instance.setExpanded(!instance.isExpanded());

        } else if (event.getSource() == instance.getGeneratehash()) {
            //Checks if a checkbox is selected - if not a message will pop up
            if(checktheboxes()){
                JFrame popup = new JFrame();
                JOptionPane.showMessageDialog(popup, "Select a hashing algorithm!");
            }else{
                if (instance.getMD2checkbox().isSelected()) {
                    try {
                        instance.getTextfieldhashoutput().setText(MD.getMD2Hash(instance.getTextfieldhashinput().getText()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (instance.getMD5checkbox().isSelected()) {
                    try {
                        instance.getTextfieldhashoutput().setText(MD.getMD5Hash(instance.getTextfieldhashinput().getText()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (instance.getSHA1checkbox().isSelected()) {
                    try {
                        instance.getTextfieldhashoutput().setText(SHA.getSHA1Hash(instance.getTextfieldhashinput().getText()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (instance.getSHA224checkbox().isSelected()) {
                    try {
                        instance.getTextfieldhashoutput().setText(SHA.getSHA224Hash(instance.getTextfieldhashinput().getText()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (instance.getSHA256checkbox().isSelected()) {
                    try {
                        instance.getTextfieldhashoutput().setText(SHA.getSHA256Hash(instance.getTextfieldhashinput().getText()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (instance.getSHA384checkbox().isSelected()) {
                    try {
                        instance.getTextfieldhashoutput().setText(SHA.getSHA384Hash(instance.getTextfieldhashinput().getText()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (instance.getSHA512checkbox().isSelected()) {
                    try {
                        instance.getTextfieldhashoutput().setText(SHA.getSHA512Hash(instance.getTextfieldhashinput().getText()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } else if (event.getSource() == instance.getButtonpassword()) {
            try {
                //Generates a password using the given length from "textPasswordLength"
                instance.getTextfieldpasswordoutput().setText(passwordgenerator.generatepassword(Integer.valueOf(instance.getTextPasswordLength().getText())));
            } catch (Exception e) {
                System.out.println(e);
            }
            /**
             * Fügt zum JFrame ein neues Verschlüsselungsmodul hinzu, solange der JFrame kleiner als der Bildschirm des Benutzers ist.
             * Bug: Würde das JFrame größer als der Bildschirm werden, würden alle Inhalte der ContentPane nicht mehr gerendert werden.
             */
        } else if (event.getSource() == instance.getBtnPlus()) {
            if (!(instance.getHeight() + 40 > Toolkit.getDefaultToolkit().getScreenSize().height - 40)) {
                instance.getWindowModuleList().add(new WindowModule(instance.getWindowModuleList().size(), 40));
                instance.reload();
            }
            /**
             * Entfernt ein Verschlüsselungsmodul, solange die Anzahl der vorhandenen Module > 1 ist.
             */
        } else if (event.getSource() == instance.getBtnMinus()) {
            if (!(instance.getWmList().size() == 1)) {
                instance.getWindowModuleList().removeLast();
                instance.reload();
            }

        } else if (event.getSource() == instance.getBtnCryptcopy2clipboard()) {
            //Copies the text from "textFieldResult" to your clipboard - if the textfield is empty a message will pop up
            if (instance.getTextFieldResult().getText().equals("")) {
                JFrame popup = new JFrame();
                JOptionPane.showMessageDialog(popup, "Nothing to copy");
            } else {
                String c = instance.getTextFieldResult().getText();
                StringSelection stringSelection = new StringSelection(c);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        } else if (event.getSource() == instance.getBtnDecrypt()) {
            for (WindowModule windowModule1 : instance.getWmList())
                if (!windowModule1.isSelected()) {
                    JOptionPane.showMessageDialog(instance, "Alle Module müssen angekreuzt sein!");
                }
            String textToDecrypt = instance.getTextFieldInput().getText();
            for (WindowModule windowModule : instance.getWmList()) {
                switch (windowModule.getSelected()) {
                    case "Vigenere 2.0":
                        textToDecrypt = Vigenere.decrypt(textToDecrypt, Integer.valueOf(instance.getTextfieldVigenere().getText()));

                        break;
                    case "AES":
                        if (instance.getTextFieldAesKey().getText().length() != 16) {
                            JFrame popup = new JFrame();
                            JOptionPane.showMessageDialog(popup, "Key must have a length of 16 chars.\nCurrent length is " + instance.getTextFieldAesKey().getText().length());
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

            /**
             If a checkbox is selected all the other checkboxes will be disabled and you are not able to select them anymore
             If you deselect the checkbox again the method "enableall()" will enable all checkboxes again
             **/

        } else if (event.getSource() == instance.getSHA1checkbox()) {
            if (instance.getSHA1checkbox().isSelected()) {
                instance.getMD2checkbox().setEnabled(false);
                instance.getMD5checkbox().setEnabled(false);
                instance.getSHA224checkbox().setEnabled(false);
                instance.getSHA256checkbox().setEnabled(false);
                instance.getSHA384checkbox().setEnabled(false);
                instance.getSHA512checkbox().setEnabled(false);
            } else {
                enableall();
            }

        } else if (event.getSource() == instance.getSHA224checkbox()) {
            if (instance.getSHA224checkbox().isSelected()) {
                instance.getMD2checkbox().setEnabled(false);
                instance.getMD5checkbox().setEnabled(false);
                instance.getSHA1checkbox().setEnabled(false);
                instance.getSHA256checkbox().setEnabled(false);
                instance.getSHA384checkbox().setEnabled(false);
                instance.getSHA512checkbox().setEnabled(false);
            } else {
                enableall();
            }

        } else if (event.getSource() == instance.getSHA256checkbox()) {
            if (instance.getSHA256checkbox().isSelected()) {
                instance.getMD2checkbox().setEnabled(false);
                instance.getMD5checkbox().setEnabled(false);
                instance.getSHA1checkbox().setEnabled(false);
                instance.getSHA224checkbox().setEnabled(false);
                instance.getSHA384checkbox().setEnabled(false);
                instance.getSHA512checkbox().setEnabled(false);
            } else {
                enableall();
            }

        } else if (event.getSource() == instance.getSHA384checkbox()) {
            if (instance.getSHA384checkbox().isSelected()) {
                instance.getMD2checkbox().setEnabled(false);
                instance.getMD5checkbox().setEnabled(false);
                instance.getSHA1checkbox().setEnabled(false);
                instance.getSHA224checkbox().setEnabled(false);
                instance.getSHA256checkbox().setEnabled(false);
                instance.getSHA512checkbox().setEnabled(false);
            } else {
                enableall();
            }


        } else if (event.getSource() == instance.getSHA512checkbox()) {
            if (instance.getSHA512checkbox().isSelected()) {
                instance.getMD2checkbox().setEnabled(false);
                instance.getMD5checkbox().setEnabled(false);
                instance.getSHA1checkbox().setEnabled(false);
                instance.getSHA224checkbox().setEnabled(false);
                instance.getSHA256checkbox().setEnabled(false);
                instance.getSHA384checkbox().setEnabled(false);
            } else {
                enableall();
            }
        } else if (event.getSource() == instance.getMD2checkbox()) {
            if (instance.getMD2checkbox().isSelected()) {
                instance.getMD5checkbox().setEnabled(false);
                instance.getSHA1checkbox().setEnabled(false);
                instance.getSHA224checkbox().setEnabled(false);
                instance.getSHA256checkbox().setEnabled(false);
                instance.getSHA384checkbox().setEnabled(false);
                instance.getSHA512checkbox().setEnabled(false);
            } else {
                enableall();
            }
        } else if (event.getSource() == instance.getMD5checkbox()) {
            if (instance.getMD5checkbox().isSelected()) {
                instance.getMD2checkbox().setEnabled(false);
                instance.getSHA1checkbox().setEnabled(false);
                instance.getSHA224checkbox().setEnabled(false);
                instance.getSHA256checkbox().setEnabled(false);
                instance.getSHA384checkbox().setEnabled(false);
                instance.getSHA512checkbox().setEnabled(false);
            } else {
                enableall();
            }
        }
    }

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

    private boolean checktheboxes() {
        //Checks if no checkbox is selected (used above on the create hash method)
        return !instance.getMD2checkbox().isSelected() && !instance.getMD5checkbox().isSelected() && !instance.getSHA224checkbox().isSelected() && !instance.getSHA256checkbox().isSelected() && !instance.getSHA384checkbox().isSelected() && !instance.getSHA384checkbox().isSelected() && !instance.getSHA512checkbox().isSelected();
    }

}
