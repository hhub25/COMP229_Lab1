package com.lab.logic;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdatePlayerFrame extends JFrame {

    private static final long serialVersionUID = 1L;
	private JTextField firstNameField, lastNameField, addressField, postalCodeField, provinceField, phoneNumberField;

    public UpdatePlayerFrame(Player player) {
    	
        setTitle("Update Player Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 2));
        setPreferredSize(new Dimension(400, 300));

        // Create components
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);
        firstNameField.setText(player.getFirst_name());
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);
        lastNameField.setText(player.getLast_name());
        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField(40);
        addressField.setText(player.getAddress());
        JLabel postalCodeLabel = new JLabel("Postal Code:");
        postalCodeField = new JTextField(10);
        postalCodeField.setText(player.getPostal_code());
        JLabel provinceLabel = new JLabel("Province:");
        provinceField = new JTextField(20);
        provinceField.setText(player.getProvince());
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField(15);
        phoneNumberField.setText(player.getPhone_number());

        JButton updateButton = new JButton("Update Player");

        // Add components to the JFrame
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(addressLabel);
        add(addressField);
        add(postalCodeLabel);
        add(postalCodeField);
        add(provinceLabel);
        add(provinceField);
        add(phoneNumberLabel);
        add(phoneNumberField);
        add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String address = addressField.getText();
                String postalCode = postalCodeField.getText();
                String province = provinceField.getText();
                String phoneNumber = phoneNumberField.getText();

                GameCRUD.updatePlayer(player.getPlayerId(), firstName, lastName, address, postalCode, province, phoneNumber);
                JOptionPane.showMessageDialog(UpdatePlayerFrame.this, "Player information updated successfully!");
            }
        });

        pack();
    }
}
