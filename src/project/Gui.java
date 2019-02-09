package project;

import java.util.LinkedList;

import javax.swing.*;

import project.gui.WindowModule;

/**
 * Sollten sich in den Kommentaren sowohl Rechtschreib- als auch Grammatik- und Satzzeichenfehler finden, möchte ich (Daniel)
 * Eventuelle Schäden meines Gehirns durch das Lesen von "Iphigenie auf Tauris" nicht ausschließen.
 *
 * @author DanielderErbauer
 * @author N13P4
 * @author Ernst
 *
 */
public class Gui extends JFrame {
    private boolean isExpanded = false;
    private Main handler;
    private JButton btnCryptcopy2clipboard;
    private JButton btnDecrypt;
    private JButton btnEncrypt;
    private JButton btnExpand;
    private JButton btnMinus;
    private JButton btnPlus;
    private JButton buttonpassword;
    private JButton copyhash;
    private JButton copypassword;
    private JButton generatehash;
    private JCheckBox MD2checkbox;
    private JCheckBox MD5checkbox;
    private JCheckBox SHA1checkbox;
    private JCheckBox SHA224checkbox;
    private JCheckBox SHA256checkbox;
    private JCheckBox SHA384checkbox;
    private JCheckBox SHA512checkbox;
    private JLabel hashinput;
    private JLabel hashoutput;
    private JLabel labelAesKey;
    private JLabel labelInput;
    private JLabel labelpassword;
    private JLabel labelPasswordLength;
    private JLabel labelResult;
    private JLabel labelVigenere;
    private JLabel MD2label;
    private JLabel MD5label;
    private JLabel SHA1label;
    private JLabel SHA224label;
    private JLabel SHA256label;
    private JLabel SHA384label;
    private JLabel SHA512label;
    private JTextField textFieldAesKey;
    private JTextField textfieldhashinput;
    private JTextField textfieldhashoutput;
    private JTextField textFieldInput;
    private JTextField textfieldpasswordoutput;
    private JTextField textFieldResult;
    private JTextField textfieldVigenere;
    private JTextField textPasswordLength;
    public static JFrame popup = new JFrame();
    public LinkedList<WindowModule> wmList;

    /**
     * Konstruktor der Hauptklasse des ganzen Programms.
     */
    public Gui(Main main) {
        handler = main;
        wmList = new LinkedList<>();
        initWindow();
    }

    private void initWindow() {
        btnCryptcopy2clipboard = new JButton("Copy");
        btnCryptcopy2clipboard.addActionListener(handler);
        btnDecrypt = new JButton("Decrypt");
        btnDecrypt.addActionListener(handler);
        btnDecrypt.setBounds(505, 10, 100, 20);
        btnEncrypt = new JButton("Encrypt");
        btnEncrypt.addActionListener(handler);
        btnEncrypt.setBounds(395, 10, 100, 20);
        btnExpand = new JButton(">");
        btnExpand.addActionListener(handler);
        btnExpand.setBounds(580, 175, 44, 15);
        btnMinus = new JButton("-");
        btnMinus.addActionListener(handler);
        btnMinus.setBounds(505, 40, 100, 20);
        btnPlus = new JButton("+");
        btnPlus.addActionListener(handler);
        btnPlus.setBounds(395, 40, 100, 20);
        buttonpassword = new JButton("Generate");
        buttonpassword.addActionListener(handler);
        buttonpassword.setBounds(700, 60, 110, 20);
        copyhash = new JButton("Copy");
        copyhash.addActionListener(handler);
        copyhash.setBounds(850, 160, 110, 20);
        copypassword = new JButton("Copy");
        copypassword.addActionListener(handler);
        copypassword.setBounds(850, 60, 110, 20);
        generatehash = new JButton("Generate");
        generatehash.addActionListener(handler);
        generatehash.setBounds(700, 160, 110, 20);
        hashinput = new JLabel("Input:");
        hashinput.setBounds(700, 100, 120, 20);
        hashoutput = new JLabel("Output:");
        hashoutput.setBounds(700, 130, 120, 20);
        labelInput = new JLabel("Input: ");
        labelInput.setBounds(10, 10, 80, 20);
        labelpassword = new JLabel("Password:");
        labelpassword.setBounds(700, 35, 125, 20);
        labelPasswordLength = new JLabel("Password length:");
        labelPasswordLength.setBounds(700, 10, 125, 20);
        labelResult = new JLabel("Out:");
        labelResult.setBounds(10, 85, 40, 20);
        MD2checkbox = new JCheckBox();
        MD2checkbox.addActionListener(handler);
        MD2checkbox.setBounds(1110, 100, 20, 20);
        MD2label = new JLabel("MD2");
        MD2label.setBounds(1130, 100, 50, 20);
        MD5checkbox = new JCheckBox();
        MD5checkbox.addActionListener(handler);
        MD5checkbox.setBounds(1050, 100, 20, 20);
        MD5label = new JLabel("MD5");
        MD5label.setBounds(1070, 100, 50, 20);
        SHA1checkbox = new JCheckBox();
        SHA1checkbox.addActionListener(handler);
        SHA1checkbox.setBounds(1050, 125, 20, 20);
        SHA1label = new JLabel("SHA1");
        SHA1label.setBounds(1070, 125, 50, 20);
        SHA224checkbox = new JCheckBox();
        SHA224checkbox.addActionListener(handler);
        SHA224checkbox.setBounds(1110, 125, 20, 20);
        SHA224label = new JLabel("SHA224");
        SHA224label.setBounds(1130, 125, 70, 20);
        SHA256checkbox = new JCheckBox();
        SHA256checkbox.addActionListener(handler);
        SHA256checkbox.setBounds(1050, 150, 20, 20);
        SHA256label = new JLabel("SHA256");
        SHA256label.setBounds(1070, 150, 70, 20);
        SHA384checkbox = new JCheckBox();
        SHA384checkbox.addActionListener(handler);
        SHA384checkbox.setBounds(1050, 175, 20, 20);
        SHA384label = new JLabel("SHA384");
        SHA384label.setBounds(1070, 175, 70, 20);
        SHA512checkbox = new JCheckBox("SHA512");
        SHA512checkbox.addActionListener(handler);
        SHA512checkbox.setBounds(1050, 200, 20, 20);
        SHA512label = new JLabel("SHA512");
        SHA512label.setBounds(1070, 200, 70, 20);
        textFieldAesKey = new JTextField();
        textfieldhashinput = new JTextField();
        textfieldhashinput.setBounds(770, 100, 255, 20);
        textfieldhashoutput = new JTextField();
        textfieldhashoutput.setBounds(770, 130, 255, 20);
        textFieldInput = new JTextField();
        textFieldInput.setBounds(60, 10, 325, 20);
        textfieldpasswordoutput = new JTextField();
        textfieldpasswordoutput.setBounds(835, 35, 200, 20);
        textFieldResult = new JTextField();
        textFieldResult.setBounds(60, 85, 325, 20);
        textPasswordLength = new JTextField();
        textPasswordLength.setBounds(835, 10, 200, 20);
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
        this.getContentPane().add(btnCryptcopy2clipboard);
        this.getContentPane().add(btnDecrypt);
        this.getContentPane().add(btnEncrypt);
        this.getContentPane().add(btnExpand);
        this.getContentPane().add(btnMinus);
        this.getContentPane().add(btnPlus);
        this.getContentPane().add(buttonpassword);
        this.getContentPane().add(copyhash);
        this.getContentPane().add(copypassword);
        this.getContentPane().add(generatehash);
        this.getContentPane().add(hashinput);
        this.getContentPane().add(hashoutput);
        this.getContentPane().add(labelInput);
        this.getContentPane().add(labelpassword);
        this.getContentPane().add(labelPasswordLength);
        this.getContentPane().add(MD2checkbox);
        this.getContentPane().add(MD2label);
        this.getContentPane().add(MD5checkbox);
        this.getContentPane().add(MD5label);
        this.getContentPane().add(SHA1checkbox);
        this.getContentPane().add(SHA1label);
        this.getContentPane().add(SHA224checkbox);
        this.getContentPane().add(SHA224label);
        this.getContentPane().add(SHA256checkbox);
        this.getContentPane().add(SHA256label);
        this.getContentPane().add(SHA384checkbox);
        this.getContentPane().add(SHA384label);
        this.getContentPane().add(SHA512checkbox);
        this.getContentPane().add(SHA512label);
        this.getContentPane().add(textfieldhashinput);
        this.getContentPane().add(textfieldhashoutput);
        this.getContentPane().add(textFieldInput);
        this.getContentPane().add(textfieldpasswordoutput);
        this.getContentPane().add(textPasswordLength);
        this.getContentPane().add(labelResult);
        this.getContentPane().add(textFieldResult);
        this.getContentPane().add(btnCryptcopy2clipboard);
        this.getContentPane().setLayout(null);
        if(!isExpanded) {
            this.setSize(635, 225 + (wmList.size() * 70));
        } else {
            this.setSize(1200, 225 + (wmList.size() * 70));
        }
        for (WindowModule windowModule : wmList) {
            this.getContentPane().add(windowModule);
        }
        textFieldResult.setBounds(60, 50 + (wmList.size() * 70), 325, 20);
        labelResult.setBounds(10, 50 + (wmList.size() * 70), 40, 20);
        btnCryptcopy2clipboard.setBounds(10, 80 + (wmList.size() * 70), 100, 20);
    }


    public LinkedList<WindowModule> getWindowModuleList() {
        return wmList;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public Main getHandler() {
        return handler;
    }

    public void setHandler(Main handler) {
        this.handler = handler;
    }

    public JButton getBtnCryptcopy2clipboard() {
        return btnCryptcopy2clipboard;
    }

    public void setBtnCryptcopy2clipboard(JButton btnCryptcopy2clipboard) {
        this.btnCryptcopy2clipboard = btnCryptcopy2clipboard;
    }

    public JButton getBtnDecrypt() {
        return btnDecrypt;
    }

    public void setBtnDecrypt(JButton btnDecrypt) {
        this.btnDecrypt = btnDecrypt;
    }

    public JButton getBtnEncrypt() {
        return btnEncrypt;
    }

    public void setBtnEncrypt(JButton btnEncrypt) {
        this.btnEncrypt = btnEncrypt;
    }

    public JButton getBtnExpand() {
        return btnExpand;
    }

    public void setBtnExpand(JButton btnExpand) {
        this.btnExpand = btnExpand;
    }

    public JButton getBtnMinus() {
        return btnMinus;
    }

    public void setBtnMinus(JButton btnMinus) {
        this.btnMinus = btnMinus;
    }

    public JButton getBtnPlus() {
        return btnPlus;
    }

    public void setBtnPlus(JButton btnPlus) {
        this.btnPlus = btnPlus;
    }

    public JButton getButtonpassword() {
        return buttonpassword;
    }

    public void setButtonpassword(JButton buttonpassword) {
        this.buttonpassword = buttonpassword;
    }

    public JButton getCopyhash() {
        return copyhash;
    }

    public void setCopyhash(JButton copyhash) {
        this.copyhash = copyhash;
    }

    public JButton getCopypassword() {
        return copypassword;
    }

    public void setCopypassword(JButton copypassword) {
        this.copypassword = copypassword;
    }

    public JButton getGeneratehash() {
        return generatehash;
    }

    public void setGeneratehash(JButton generatehash) {
        this.generatehash = generatehash;
    }

    public JCheckBox getMD2checkbox() {
        return MD2checkbox;
    }

    public void setMD2checkbox(JCheckBox MD2checkbox) {
        this.MD2checkbox = MD2checkbox;
    }

    public JCheckBox getMD5checkbox() {
        return MD5checkbox;
    }

    public void setMD5checkbox(JCheckBox MD5checkbox) {
        this.MD5checkbox = MD5checkbox;
    }

    public JCheckBox getSHA1checkbox() {
        return SHA1checkbox;
    }

    public void setSHA1checkbox(JCheckBox SHA1checkbox) {
        this.SHA1checkbox = SHA1checkbox;
    }

    public JCheckBox getSHA224checkbox() {
        return SHA224checkbox;
    }

    public void setSHA224checkbox(JCheckBox SHA224checkbox) {
        this.SHA224checkbox = SHA224checkbox;
    }

    public JCheckBox getSHA256checkbox() {
        return SHA256checkbox;
    }

    public void setSHA256checkbox(JCheckBox SHA256checkbox) {
        this.SHA256checkbox = SHA256checkbox;
    }

    public JCheckBox getSHA384checkbox() {
        return SHA384checkbox;
    }

    public void setSHA384checkbox(JCheckBox SHA384checkbox) {
        this.SHA384checkbox = SHA384checkbox;
    }

    public JCheckBox getSHA512checkbox() {
        return SHA512checkbox;
    }

    public void setSHA512checkbox(JCheckBox SHA512checkbox) {
        this.SHA512checkbox = SHA512checkbox;
    }

    public JLabel getHashinput() {
        return hashinput;
    }

    public void setHashinput(JLabel hashinput) {
        this.hashinput = hashinput;
    }

    public JLabel getHashoutput() {
        return hashoutput;
    }

    public void setHashoutput(JLabel hashoutput) {
        this.hashoutput = hashoutput;
    }

    public JLabel getLabelAesKey() {
        return labelAesKey;
    }

    public void setLabelAesKey(JLabel labelAesKey) {
        this.labelAesKey = labelAesKey;
    }

    public JLabel getLabelInput() {
        return labelInput;
    }

    public void setLabelInput(JLabel labelInput) {
        this.labelInput = labelInput;
    }

    public JLabel getLabelpassword() {
        return labelpassword;
    }

    public void setLabelpassword(JLabel labelpassword) {
        this.labelpassword = labelpassword;
    }

    public JLabel getLabelPasswordLength() {
        return labelPasswordLength;
    }

    public void setLabelPasswordLength(JLabel labelPasswordLength) {
        this.labelPasswordLength = labelPasswordLength;
    }

    public JLabel getLabelResult() {
        return labelResult;
    }

    public void setLabelResult(JLabel labelResult) {
        this.labelResult = labelResult;
    }

    public JLabel getLabelVigenere() {
        return labelVigenere;
    }

    public void setLabelVigenere(JLabel labelVigenere) {
        this.labelVigenere = labelVigenere;
    }

    public JLabel getMD2label() {
        return MD2label;
    }

    public void setMD2label(JLabel MD2label) {
        this.MD2label = MD2label;
    }

    public JLabel getMD5label() {
        return MD5label;
    }

    public void setMD5label(JLabel MD5label) {
        this.MD5label = MD5label;
    }

    public JLabel getSHA1label() {
        return SHA1label;
    }

    public void setSHA1label(JLabel SHA1label) {
        this.SHA1label = SHA1label;
    }

    public JLabel getSHA224label() {
        return SHA224label;
    }

    public void setSHA224label(JLabel SHA224label) {
        this.SHA224label = SHA224label;
    }

    public JLabel getSHA256label() {
        return SHA256label;
    }

    public void setSHA256label(JLabel SHA256label) {
        this.SHA256label = SHA256label;
    }

    public JLabel getSHA384label() {
        return SHA384label;
    }

    public void setSHA384label(JLabel SHA384label) {
        this.SHA384label = SHA384label;
    }

    public JLabel getSHA512label() {
        return SHA512label;
    }

    public void setSHA512label(JLabel SHA512label) {
        this.SHA512label = SHA512label;
    }

    public JTextField getTextFieldAesKey() {
        return textFieldAesKey;
    }

    public void setTextFieldAesKey(JTextField textFieldAesKey) {
        this.textFieldAesKey = textFieldAesKey;
    }

    public JTextField getTextfieldhashinput() {
        return textfieldhashinput;
    }

    public void setTextfieldhashinput(JTextField textfieldhashinput) {
        this.textfieldhashinput = textfieldhashinput;
    }

    public JTextField getTextfieldhashoutput() {
        return textfieldhashoutput;
    }

    public void setTextfieldhashoutput(JTextField textfieldhashoutput) {
        this.textfieldhashoutput = textfieldhashoutput;
    }

    public JTextField getTextFieldInput() {
        return textFieldInput;
    }

    public void setTextFieldInput(JTextField textFieldInput) {
        this.textFieldInput = textFieldInput;
    }

    public JTextField getTextfieldpasswordoutput() {
        return textfieldpasswordoutput;
    }

    public void setTextfieldpasswordoutput(JTextField textfieldpasswordoutput) {
        this.textfieldpasswordoutput = textfieldpasswordoutput;
    }

    public JTextField getTextFieldResult() {
        return textFieldResult;
    }

    public void setTextFieldResult(JTextField textFieldResult) {
        this.textFieldResult = textFieldResult;
    }

    public JTextField getTextfieldVigenere() {
        return textfieldVigenere;
    }

    public void setTextfieldVigenere(JTextField textfieldVigenere) {
        this.textfieldVigenere = textfieldVigenere;
    }

    public JTextField getTextPasswordLength() {
        return textPasswordLength;
    }

    public void setTextPasswordLength(JTextField textPasswordLength) {
        this.textPasswordLength = textPasswordLength;
    }

    public LinkedList<WindowModule> getWmList() {
        return wmList;
    }

    public void setWmList(LinkedList<WindowModule> wmList) {
        this.wmList = wmList;
    }
}