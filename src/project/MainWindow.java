package project;

import java.awt.datatransfer.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;
import javax.tools.Tool;

import project.encryption.AESCipher;
import project.encryption.Vigenere;
import project.encryption.hashing.MD;
import project.encryption.hashing.SHA;
import project.gui.WindowModule;
import project.additional.passwordgenerator;

/**
 * Sollten sich in den Kommentaren sowohl Rechtschreib- als auch Grammatik- und Satzzeichenfehler finden, möchte ich (Daniel)
 * Eventuelle Schäden meines Gehirns durch das Lesen von "Iphigenie auf Tauris" nicht ausschließen.
 *
 * @author DanielderErbauer
 * @author N13P4
 * @author Ernst
 *
 */
public class MainWindow extends JFrame {
    private JButton copypassword;
    private JButton copyhash;
    private JCheckBox SHA224checkbox;
    private JCheckBox SHA256checkbox;
    private JCheckBox SHA384checkbox;
    private JCheckBox SHA512checkbox;
    private JLabel SHA224label;
    private JLabel SHA384label;
    private JLabel SHA256label;
    private JLabel SHA512label;
    private JLabel MD2label;
    private JCheckBox MD2checkbox;
    private JLabel MD5label;
    private JLabel SHA1label;
    private JCheckBox MD5checkbox;
    private JCheckBox SHA1checkbox;
    private JButton btnCryptcopy2clipboard;
    private JButton generatehash;
    private JLabel hashinput;
    private JLabel hashoutput;
    private JTextField textfieldhashinput;
    private JTextField textfieldhashoutput;
    private JButton buttonpassword;
    private JLabel labelpassword;
    private JTextField textfieldpasswordoutput;
    private JLabel labelPasswordLength;
    private JTextField textPasswordLength;
    private JLabel labelVigenere;
    private JTextField textfieldVigenere;
    private JButton btnExpand;
    private JLabel labelInput;
    private JTextField textFieldInput;
    private JLabel labelAesKey;
    private JTextField textFieldAesKey;
    private JButton btnEncrypt;
    private JButton btnDecrypt;
    private JButton btnPlus;
    private JButton btnMinus;
    private JLabel labelResult;
    private JTextField textFieldResult;

    private EventHandler handler;
    private LinkedList<WindowModule> wmList;

    private boolean isExpanded = false;

    /**
     * Konstruktor der Hauptklasse des ganzen Programms.
     */
    public MainWindow() {
        handler = new EventHandler(this);
        wmList = new LinkedList<>();
        initWindow();
    }

    public void initWindow() {
        copyhash = new JButton("Copy");
        copyhash.setBounds(850, 160, 110, 20);
        copypassword = new JButton("Copy");
        copypassword.setBounds(850, 60, 110, 20);
        SHA512label = new JLabel("SHA512");
        SHA512label.setBounds(1070, 200, 70, 20);
        SHA512checkbox = new JCheckBox("SHA512");
        SHA512checkbox.setBounds(1050, 200, 20, 20);
        SHA512checkbox.addActionListener(handler);
        SHA384label = new JLabel("SHA384");
        SHA384label.setBounds(1070, 175, 70, 20);
        SHA384checkbox = new JCheckBox();
        SHA384checkbox.setBounds(1050, 175, 20, 20);
        SHA384checkbox.addActionListener(handler);
        SHA256label = new JLabel("SHA256");
        SHA256label.setBounds(1070, 150, 70, 20);
        SHA256checkbox = new JCheckBox();
        SHA256checkbox.setBounds(1050, 150, 20, 20);
        SHA256checkbox.addActionListener(handler);
        SHA224label = new JLabel("SHA224");
        SHA224label.setBounds(1130, 125, 70, 20);
        SHA224checkbox = new JCheckBox();
        SHA224checkbox.setBounds(1110, 125, 20, 20);
        SHA224checkbox.addActionListener(handler);
        MD2label = new JLabel("MD2");
        MD2label.setBounds(1130, 100, 50, 20);
        MD2checkbox = new JCheckBox();
        MD2checkbox.setBounds(1110, 100, 20, 20);
        MD2checkbox.addActionListener(handler);
        MD5label = new JLabel("MD5");
        MD5label.setBounds(1070, 100, 50, 20);
        SHA1label = new JLabel("SHA1");
        SHA1label.setBounds(1070, 125, 50, 20);
        MD5checkbox = new JCheckBox();
        MD5checkbox.setBounds(1050, 100, 20, 20);
        MD5checkbox.addActionListener(handler);
        SHA1checkbox = new JCheckBox();
        SHA1checkbox.setBounds(1050, 125, 20, 20);
        SHA1checkbox.addActionListener(handler);
        btnCryptcopy2clipboard = new JButton("Copy");
        btnCryptcopy2clipboard.addActionListener(handler);
        generatehash = new JButton("Generate");
        generatehash.setBounds(700, 160, 110, 20);
        generatehash.addActionListener(handler);
        hashoutput = new JLabel("Output:");
        hashoutput.setBounds(700, 130, 120, 20);
        textfieldhashinput = new JTextField();
        textfieldhashinput.setBounds(770, 100, 255, 20);
        textfieldhashoutput = new JTextField();
        textfieldhashoutput.setBounds(770, 130, 255, 20);
        hashinput = new JLabel("Input:");
        hashinput.setBounds(700, 100, 120, 20);
        buttonpassword = new JButton("Generate");
        buttonpassword.setBounds(700, 60, 110, 20);
        buttonpassword.addActionListener(handler);
        labelpassword = new JLabel("Password:");
        labelpassword.setBounds(700, 35, 125, 20);
        textfieldpasswordoutput = new JTextField();
        textfieldpasswordoutput.setBounds(835, 35, 200, 20);
        labelPasswordLength = new JLabel("Password length:");
        labelPasswordLength.setBounds(700, 10, 125, 20);
        textPasswordLength = new JTextField();
        textPasswordLength.setBounds(835, 10, 200, 20);
        textfieldVigenere = new JTextField();
        textfieldVigenere.setBounds(395, 130, 180, 20);
        labelVigenere = new JLabel("Key (numeric):");
        labelVigenere.setBounds(395, 110, 190, 20);
        btnExpand = new JButton(">");
        btnExpand.setBounds(580, 175, 44, 15);
        btnExpand.addActionListener(handler);
        labelInput = new JLabel("Input: ");
        labelInput.setBounds(10, 10, 80, 20);
        copypassword.addActionListener(handler);
        copyhash.addActionListener(handler);
        textFieldInput = new JTextField();
        textFieldInput.setBounds(60, 10, 325, 20);
        labelAesKey = new JLabel("En-/Decryption Key: ");
        labelAesKey.setBounds(395, 65, 190, 20);
        textFieldAesKey = new JTextField();
        textFieldAesKey.setBounds(395, 90, 180, 20);
        textFieldAesKey.addActionListener(handler);
        btnEncrypt = new JButton("Encrypt");
        btnEncrypt.setBounds(395, 10, 100, 20);
        btnEncrypt.addActionListener(handler);
        btnDecrypt = new JButton("Decrypt");
        btnDecrypt.setBounds(505, 10, 100, 20);
        btnDecrypt.addActionListener(handler);
        btnPlus = new JButton("+");
        btnPlus.setBounds(395, 40, 100, 20);
        btnPlus.addActionListener(handler);
        btnMinus = new JButton("-");
        btnMinus.setBounds(505, 40, 100, 20);
        btnMinus.addActionListener(handler);
        labelResult = new JLabel("Out:");
        labelResult.setBounds(10, 85, 40, 20);
        textFieldResult = new JTextField();
        textFieldResult.setBounds(60, 85, 325, 20);
        wmList.add(new WindowModule(0, 40));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("P-Sem Kryptographie 2018-2020");
        this.setLocation(0, 40);
        this.setResizable(false);
        reload();
        this.setVisible(true);
    }

    /**
     * Methode zum Neu-Laden aller Elemente im JFrame.
     * Wird auch im Konstruktor verwendet, um redundanten Code zu vermeiden.
     */
    @SuppressWarnings("Duplicates")
    public void reload() {
        this.getContentPane().removeAll();
        this.setSize(635, 225 + (wmList.size() * 40));
        this.getContentPane().setLayout(null);
        this.getContentPane().add(labelInput);
        this.getContentPane().add(textFieldInput);
        this.getContentPane().add(btnEncrypt);
        this.getContentPane().add(btnDecrypt);
        this.getContentPane().add(btnExpand);
        this.getContentPane().add(btnPlus);
        this.getContentPane().add(btnMinus);
        this.getContentPane().add(textFieldAesKey);
        this.getContentPane().add(labelVigenere);
        this.getContentPane().add(labelAesKey);
        this.getContentPane().add(textfieldVigenere);
        this.getContentPane().add(textPasswordLength);
        this.getContentPane().add(labelPasswordLength);
        this.getContentPane().add(textfieldpasswordoutput);
        this.getContentPane().add(labelpassword);
        this.getContentPane().add(buttonpassword);
        this.getContentPane().add(SHA512label);
        this.getContentPane().add(SHA224checkbox);
        this.getContentPane().add(SHA256checkbox);
        this.getContentPane().add(hashinput);
        this.getContentPane().add(hashoutput);
        this.getContentPane().add(SHA384checkbox);
        this.getContentPane().add(SHA512checkbox);
        this.getContentPane().add(textfieldhashinput);
        this.getContentPane().add(SHA384label);
        this.getContentPane().add(textfieldhashoutput);
        this.getContentPane().add(generatehash);
        this.getContentPane().add(SHA256label);
        this.getContentPane().add(btnCryptcopy2clipboard);
        this.getContentPane().add(MD5checkbox);
        this.getContentPane().add(SHA224label);
        this.getContentPane().add(SHA1checkbox);
        this.getContentPane().add(copyhash);
        this.getContentPane().add(MD2checkbox);
        this.getContentPane().add(MD2label);
        this.getContentPane().add(copypassword);
        this.getContentPane().add(MD5label);
        this.getContentPane().add(SHA1label);
        for (int i = 0; i < wmList.size(); i++) {
            this.getContentPane().add(wmList.get(i));
        }
        textFieldResult.setBounds(60, 50 + (wmList.size() * 40), 325, 20);
        labelResult.setBounds(10, 50 + (wmList.size() * 40), 40, 20);
        btnCryptcopy2clipboard.setBounds(10, 80 + (wmList.size() * 40), 100, 20);
        this.getContentPane().add(labelResult);
        this.getContentPane().add(textFieldResult);
        this.getContentPane().add(btnCryptcopy2clipboard);
    }


    public LinkedList<WindowModule> getWindowModuleList() {
        return wmList;
    }

    /**
     * Interner EventHandler zum handlen aller Events des JFrames(Denglish for se win :P)
     */
    @SuppressWarnings("Duplicates")
    class EventHandler implements ActionListener {

        //Instanz/Referenz zur Hauptklasse
        private final MainWindow instance;

        public EventHandler(MainWindow instance) {
            this.instance = instance;
        }

        @Override
        public void actionPerformed(ActionEvent event) {

            /**
             * Überprüft zuerst, ob alle Module angekreuzt wurden, wenn nicht, gibt eine Fehlermeldung in Form
             * Eines JOptionPane aus, sonst, verschlüsselt den Input nach der/den ausgewählte(n) Verschlüsselungsalgorithmen
             * Und gibt in dann über das unter JTextField aus.
             */
            if (event.getSource() == btnEncrypt) {
                for (int i = 0; i < wmList.size(); i++) {
                    if (!wmList.get(i).isSelected()) {
                        JOptionPane.showMessageDialog(instance, "Alle Module müssen angekreuzt sein!");
                        return;
                    }
                }
                String textToEncrypt = textFieldInput.getText();
                for (int i = 0; i < wmList.size(); i++) {
                    switch (wmList.get(i).getSelected()) {
                        case "Vigenere 2.0":
                            textToEncrypt = Vigenere.encrypt(textToEncrypt, Integer.valueOf(textfieldVigenere.getText()));
                            // Verschlüsselt mit Vigenere
                            break;
                        case "AES":
                            if (textFieldAesKey.getText().length() != 16) {
                                JFrame popup = new JFrame();
                                JOptionPane.showMessageDialog(popup, "Key must have a length of 16 chars.\nCurrent length is " + textFieldAesKey.getText().length());
                            }
                            try {
                                textToEncrypt = AESCipher.aesEncryptString(textToEncrypt, textFieldAesKey.getText());
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
                textFieldResult.setText(textToEncrypt);

            } else if (event.getSource() == copypassword) {
                if (textfieldpasswordoutput.getText().equals("")) {
                    JFrame popup = new JFrame();
                    JOptionPane.showMessageDialog(popup, "Nothing to copy");
                } else {
                    String c = textfieldpasswordoutput.getText();
                    StringSelection stringSelection = new StringSelection(c);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);
                }
            } else if (event.getSource() == copyhash) {
                if (textfieldhashoutput.getText().equals("")) {
                    JFrame popup = new JFrame();
                    JOptionPane.showMessageDialog(popup, "Nothing to copy");
                } else {
                    String c = textfieldhashoutput.getText();
                    StringSelection stringSelection = new StringSelection(c);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);
                }

            } else if (event.getSource() == buttonpassword) {
                try {
                    int length = Integer.valueOf(textPasswordLength.getText());
                    textfieldpasswordoutput.setText(passwordgenerator.generatepassword(length));
                } catch (Exception e) {
                    JFrame popup = new JFrame();
                    JOptionPane.showMessageDialog(popup, "Invalid value - Numbers only!");
                }

            } else if (event.getSource() == btnExpand) {
                if (!isExpanded) {
                    instance.setSize(1200, 225 + (wmList.size() * 40));
                    btnExpand.setText("<");
                } else {
                    instance.setSize(635, 225 + (wmList.size() * 40));
                    btnExpand.setText(">");
                }
                isExpanded = !isExpanded;

            } else if (event.getSource() == generatehash) {
                if(checktheboxes() == true){
                    JFrame popup = new JFrame();
                    JOptionPane.showMessageDialog(popup, "Select a hashing algorithm!");
                }else{
                    if (MD2checkbox.isSelected()) {
                        try {
                            textfieldhashoutput.setText(MD.getMD2Hash(textfieldhashinput.getText()));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (MD5checkbox.isSelected()) {
                        try {
                            textfieldhashoutput.setText(MD.getMD5Hash(textfieldhashinput.getText()));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (SHA1checkbox.isSelected()) {
                        try {
                            textfieldhashoutput.setText(SHA.getSHA1Hash(textfieldhashinput.getText()));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                     }
                    } else if (SHA224checkbox.isSelected()) {
                        try {
                            textfieldhashoutput.setText(SHA.getSHA224Hash(textfieldhashinput.getText()));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (SHA256checkbox.isSelected()) {
                        try {
                            textfieldhashoutput.setText(SHA.getSHA256Hash(textfieldhashinput.getText()));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                     }
                    } else if (SHA384checkbox.isSelected()) {
                        try {
                            textfieldhashoutput.setText(SHA.getSHA384Hash(textfieldhashinput.getText()));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (SHA512checkbox.isSelected()) {
                        try {
                            textfieldhashoutput.setText(SHA.getSHA512Hash(textfieldhashinput.getText()));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            } else if (event.getSource() == buttonpassword) {
                try {
                    textfieldpasswordoutput.setText(passwordgenerator.generatepassword(Integer.valueOf(textPasswordLength.getText())));
                } catch (Exception e) {
                    System.out.println(e);
                }
                /**
                 * Fügt zum JFrame ein neues Verschlüsselungsmodul hinzu, solange der JFrame kleiner als der Bildschirm des Benutzers ist.
                 * Bug: Würde das JFrame größer als der Bildschirm werden, würden alle Inhalte der ContentPane nicht mehr gerendert werden.
                 */
            } else if (event.getSource() == btnPlus) {
                if (!(instance.getHeight() + 40 > Toolkit.getDefaultToolkit().getScreenSize().height - 40)) {
                    instance.getWindowModuleList().add(new WindowModule(instance.getWindowModuleList().size(), 40));
                    instance.reload();
                }
                return;
                /**
                 * Entfernt ein Verschlüsselungsmodul, solange die Anzahl der vorhandenen Module > 1 ist.
                 */
            } else if (event.getSource() == btnMinus) {
                if (!(wmList.size() == 1)) {
                    instance.getWindowModuleList().removeLast();
                    instance.reload();
                }
                return;

            } else if (event.getSource() == btnCryptcopy2clipboard) {
                if (textFieldResult.getText().equals("")) {
                    JFrame popup = new JFrame();
                    JOptionPane.showMessageDialog(popup, "Nothing to copy");
                } else {
                    String c = textFieldResult.getText();
                    StringSelection stringSelection = new StringSelection(c);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);
                }
            } else if (event.getSource() == btnDecrypt) {
                for (int i = 0; i < wmList.size(); i++) {
                    if (!wmList.get(i).isSelected()) {
                        JOptionPane.showMessageDialog(instance, "Alle Module müssen angekreuzt sein!");
                        return;
                    }
                }
                String textToDecrypt = textFieldInput.getText();
                for (int i = 0; i < wmList.size(); i++) {
                    switch (wmList.get(i).getSelected()) {
                        case "Vigenere 2.0":
                            textToDecrypt = Vigenere.decrypt(textToDecrypt, Integer.valueOf(textfieldVigenere.getText()));

                            break;
                        case "AES":
                            if (textFieldAesKey.getText().length() != 16) {
                                JFrame popup = new JFrame();
                                JOptionPane.showMessageDialog(popup, "Key must have a length of 16 chars.\nCurrent length is " + textFieldAesKey.getText().length());
                            }
                            try {
                                textToDecrypt = AESCipher.aesDecryptString(textToDecrypt, textFieldAesKey.getText());
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
                textFieldResult.setText(textToDecrypt);
            } else if (event.getSource() == SHA1checkbox) {
                if (SHA1checkbox.isSelected()) {
                    MD2checkbox.setEnabled(false);
                    MD5checkbox.setEnabled(false);
                    SHA224checkbox.setEnabled(false);
                    SHA256checkbox.setEnabled(false);
                    SHA384checkbox.setEnabled(false);
                    SHA512checkbox.setEnabled(false);
                } else {
                    enableall();
                }

            } else if (event.getSource() == SHA224checkbox) {
                if (SHA224checkbox.isSelected()) {
                    MD2checkbox.setEnabled(false);
                    MD5checkbox.setEnabled(false);
                    SHA1checkbox.setEnabled(false);
                    SHA256checkbox.setEnabled(false);
                    SHA384checkbox.setEnabled(false);
                    SHA512checkbox.setEnabled(false);
                } else {
                    enableall();
                }

            } else if (event.getSource() == SHA256checkbox) {
                if (SHA256checkbox.isSelected()) {
                    MD2checkbox.setEnabled(false);
                    MD5checkbox.setEnabled(false);
                    SHA1checkbox.setEnabled(false);
                    SHA224checkbox.setEnabled(false);
                    SHA384checkbox.setEnabled(false);
                    SHA512checkbox.setEnabled(false);
                } else {
                    enableall();
                }

            } else if (event.getSource() == SHA384checkbox) {
                if (SHA384checkbox.isSelected()) {
                    MD2checkbox.setEnabled(false);
                    MD5checkbox.setEnabled(false);
                    SHA1checkbox.setEnabled(false);
                    SHA224checkbox.setEnabled(false);
                    SHA256checkbox.setEnabled(false);
                    SHA512checkbox.setEnabled(false);
                } else {
                    enableall();
                }


            } else if (event.getSource() == SHA512checkbox) {
                if (SHA512checkbox.isSelected()) {
                    MD2checkbox.setEnabled(false);
                    MD5checkbox.setEnabled(false);
                    SHA1checkbox.setEnabled(false);
                    SHA224checkbox.setEnabled(false);
                    SHA256checkbox.setEnabled(false);
                    SHA384checkbox.setEnabled(false);
                } else {
                    enableall();
                }
            } else if (event.getSource() == MD2checkbox) {
                if (MD2checkbox.isSelected()) {
                    MD5checkbox.setEnabled(false);
                    SHA1checkbox.setEnabled(false);
                    SHA224checkbox.setEnabled(false);
                    SHA256checkbox.setEnabled(false);
                    SHA384checkbox.setEnabled(false);
                    SHA512checkbox.setEnabled(false);
                } else {
                    enableall();
                }
            } else if (event.getSource() == MD5checkbox) {
                if (MD5checkbox.isSelected()) {
                    MD2checkbox.setEnabled(false);
                    SHA1checkbox.setEnabled(false);
                    SHA224checkbox.setEnabled(false);
                    SHA256checkbox.setEnabled(false);
                    SHA384checkbox.setEnabled(false);
                    SHA512checkbox.setEnabled(false);
                } else {
                    enableall();
                }
            }
        }
    }

    public void enableall() {
        MD2checkbox.setEnabled(true);
        MD5checkbox.setEnabled(true);
        SHA1checkbox.setEnabled(true);
        SHA224checkbox.setEnabled(true);
        SHA256checkbox.setEnabled(true);
        SHA384checkbox.setEnabled(true);
        SHA512checkbox.setEnabled(true);
    }

    public boolean checktheboxes() {
        if (MD2checkbox.isSelected() == false && MD5checkbox.isSelected() == false && SHA1checkbox.isSelected() == false && SHA224checkbox.isSelected() == false && SHA256checkbox.isSelected() == false && SHA384checkbox.isSelected() == false && SHA512checkbox.isSelected() == false) {
          return true;
        } else{
            return false;
        }
    }




    public static void main(String[] args) {
        new MainWindow();
    }
}