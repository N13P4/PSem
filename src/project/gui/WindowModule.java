package project.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 * WindowModul Klasse
 *
 */
public class WindowModule extends JPanel{
	
	private JCheckBox cb1;
	private JCheckBox cb2;
	private JCheckBox cb3;

	private JLabel lblKey;
	private JTextField txtKey;
	
	public WindowModule(int pos, int space) {
		
		this.setBackground(Color.DARK_GRAY);
		this.setBounds(10, 70 * pos + space, 375, 70);
		this.setLayout(null);
		
		cb1 = new JCheckBox("Vigenere 2.0");
		cb2 = new JCheckBox("AES");
		cb3 = new JCheckBox("NOT IMPLEMENTED");

		lblKey = new JLabel("Key: ");
		lblKey.setForeground(Color.WHITE);
		txtKey = new JTextField();

		cb1.setBounds(10, 10, 105, 20);
		cb2.setBounds(125, 10, 75, 20);
		cb3.setBounds(210, 10, 150, 20);

		lblKey.setBounds(10, 40, 50, 20);
		txtKey.setBounds(70, 40, 150, 20);

		EventHandler handler = new EventHandler();
		
		cb1.addActionListener(handler);
		cb2.addActionListener(handler);
		cb3.addActionListener(handler);
		
		this.add(cb1);
		this.add(cb2);
		this.add(cb3);

		this.add(lblKey);
		this.add(txtKey);
		
		
	}

	public String getKey() {
		return txtKey.getText();
	}
	
	public boolean isSelected() {
		return cb1.isSelected() || cb2.isSelected() || cb3.isSelected();
	}
	
	public String getSelected() {
		if(cb1.isSelected()) return cb1.getText();
		else if(cb2.isSelected()) return cb2.getText();
		else if(cb3.isSelected()) return cb3.getText();
		else return null;
	}
	
	@SuppressWarnings("Duplicates")
	class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == cb1) {
				if(cb1.isSelected()) {
					cb2.setEnabled(false);
					cb3.setEnabled(false);
				} else {
					cb2.setEnabled(true);
					cb3.setEnabled(true);
				}
			} else if(event.getSource() == cb2) {
				if(cb2.isSelected()) {
					cb1.setEnabled(false);
					cb3.setEnabled(false);
				} else {
					cb1.setEnabled(true);
					cb3.setEnabled(true);
				}
			} else if(event.getSource() == cb3) {
				if(cb3.isSelected()) {
					cb1.setEnabled(false);
					cb2.setEnabled(false);
				} else {
					cb1.setEnabled(true);
					cb2.setEnabled(true);
				}
			}
		}
		
	}
}
