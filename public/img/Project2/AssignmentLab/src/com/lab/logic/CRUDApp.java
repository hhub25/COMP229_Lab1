package com.lab.logic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CRUDApp extends JFrame {

    private static final long serialVersionUID = 1L;
	private JTextField gameIdField, gameTitleField;
    private JTextField playerIdField, firstNameField, lastNameField, addressField, postalCodeField, provinceField, phoneNumberField;
    private JTextField  playingDateField, scoreField;
    private JTextField gameIdField2;
    private JTextField playerIdField2;
    private JComboBox<String> playerDropdown;

    public CRUDApp() {
        // Set up the main JFrame
    	setTitle("CRUD Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null); // Use absolute layout
        setPreferredSize(new Dimension(800, 700));


        // Add components
        JLabel gameIdLabel = new JLabel("Game ID:");
        gameIdField = new JTextField(10);
        JLabel gameTitleLabel = new JLabel("Game Title:");
        gameTitleField = new JTextField(20);
        JButton addGameButton = new JButton("Add Game");

        JLabel playerIdLabel = new JLabel("Player ID:");
        playerIdField = new JTextField(10);
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);
        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField(40);
        JLabel postalCodeLabel = new JLabel("Postal Code:");
        postalCodeField = new JTextField(10);
        JLabel provinceLabel = new JLabel("Province:");
        provinceField = new JTextField(20);
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField(15);
        JButton addPlayerButton = new JButton("Add Player");

     
        JLabel playingDateLabel = new JLabel("Playing Date (YYYY-MM-DD):");
        playingDateField = new JTextField(15);
        JLabel scoreLabel = new JLabel("Score:");
        scoreField = new JTextField(5);
        JButton addGamePlayedByPlayerButton = new JButton("Add Game Played by Player");

        JLabel searchPlayerLabel = new JLabel("Select Player:");
        JTextField searchPlayerIdField = new JTextField(10);

        JLabel searchGameLabel = new JLabel("Search Game by ID or Title :");
        JTextField searchGameTitleField = new JTextField(20);
        JButton searchGameButton = new JButton("Search Game");
        searchGameButton.setForeground(Color.BLACK);
        searchGameButton.setBackground(Color.BLACK);

        JButton searchPlayerButton = new JButton("Search Player");
        JButton btnUpdatePlayer = new JButton("Update Player");
        // Add components to the JFrame
  
        
      
        playerDropdown = new JComboBox<>();
        playerDropdown.setBounds(163, 495, 200, 25);
        getContentPane().add(playerDropdown);

    
        populatePlayerDropdown();
       
   

        gameIdLabel.setBounds(20, 20, 100, 25);
        gameIdField.setBounds(100, 19, 128, 25);
        gameTitleLabel.setBounds(253, 20, 100, 25);
        gameTitleField.setBounds(350, 20, 200, 25);
        addGameButton.setBounds(562, 21, 120, 25);

        playerIdLabel.setBounds(20, 60, 100, 25);
        playerIdField.setBounds(100, 59, 128, 25);
        firstNameLabel.setBounds(20, 97, 100, 25);
        firstNameField.setBounds(100, 96, 200, 25);
        lastNameLabel.setBounds(312, 97, 100, 25);
        lastNameField.setBounds(414, 96, 200, 25);
        addressLabel.setBounds(20, 131, 100, 25);
        addressField.setBounds(100, 131, 200, 25);
        postalCodeLabel.setBounds(312, 131, 100, 25);
        postalCodeField.setBounds(414, 130, 100, 25);
        provinceLabel.setBounds(20, 168, 100, 25);
        provinceField.setBounds(100, 167, 200, 25);
        phoneNumberLabel.setBounds(312, 168, 100, 25);
        phoneNumberField.setBounds(414, 167, 200, 25);
        addPlayerButton.setBounds(6, 205, 150, 25);

      
        playingDateLabel.setBounds(223, 296, 215, 25);
        playingDateField.setBounds(414, 295, 150, 25);
        scoreLabel.setBounds(223, 325, 100, 25);
        scoreField.setBounds(274, 324, 109, 25);
        addGamePlayedByPlayerButton.setBounds(6, 362, 220, 25);

        searchPlayerLabel.setBounds(19, 494, 150, 25);
        searchPlayerIdField.setBounds(162, 445, 100, 25);
        searchPlayerButton.setBounds(274, 447, 150, 25);

        btnUpdatePlayer.setBounds(433, 447, 150, 25);

        searchGameLabel.setBounds(20, 535, 180, 25);
        searchGameTitleField.setBounds(212, 534, 200, 25);
        searchGameButton.setBounds(6, 572, 160, 25);

        // Add components to the JFrame
        getContentPane().add(gameIdLabel);
        getContentPane().add(gameIdField);
        getContentPane().add(gameTitleLabel);
        getContentPane().add(gameTitleField);
        getContentPane().add(addGameButton);

        getContentPane().add(playerIdLabel);
        getContentPane().add(playerIdField);
        getContentPane().add(firstNameLabel);
        getContentPane().add(firstNameField);
        getContentPane().add(lastNameLabel);
        getContentPane().add(lastNameField);
        getContentPane().add(addressLabel);
        getContentPane().add(addressField);
        getContentPane().add(postalCodeLabel);
        getContentPane().add(postalCodeField);
        getContentPane().add(provinceLabel);
        getContentPane().add(provinceField);
        getContentPane().add(phoneNumberLabel);
        getContentPane().add(phoneNumberField);
        getContentPane().add(addPlayerButton);


        getContentPane().add(playingDateLabel);
        getContentPane().add(playingDateField);
        getContentPane().add(scoreLabel);
        getContentPane().add(scoreField);
        getContentPane().add(addGamePlayedByPlayerButton);

        getContentPane().add(searchPlayerLabel);
        getContentPane().add(searchPlayerIdField);
 
  

        getContentPane().add(searchGameLabel);
        getContentPane().add(searchGameTitleField);
        getContentPane().add(searchGameButton);
        
        
        
      
        getContentPane().add(searchPlayerButton);
        
                searchPlayerButton.addActionListener(new ActionListener() {
                	
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	try {
                        int playerId = Integer.parseInt(searchPlayerIdField.getText());
                        GameCRUD.searchPlayerById(playerId);
                        clearFields();
                        showPlayerGames(playerId);
                    	}catch(Exception er) {
                    		JOptionPane.showMessageDialog(null, "Please enter correct details","Error",JOptionPane.ERROR_MESSAGE);
                    	}
                    }
                  
                });
        
   
        getContentPane().add(btnUpdatePlayer);

        
        btnUpdatePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                int playerId = Integer.parseInt(searchPlayerIdField.getText());
                GameCRUD.searchPlayerById(playerId);
                clearFields();
                showUpdatePlayerFrame(playerId);
            	}catch(Exception er) {
            		JOptionPane.showMessageDialog(null, "Please enter correct details","Error",JOptionPane.ERROR_MESSAGE);
            	}
            }
          
        });
        
        getContentPane().add(searchGameLabel);
        getContentPane().add(searchGameTitleField);
        getContentPane().add(searchGameButton);
        
        JLabel gameIdLabel_1 = new JLabel("Game ID:");
        gameIdLabel_1.setBounds(20, 296, 100, 25);
        getContentPane().add(gameIdLabel_1);
        
        JLabel playerIdLabel_1 = new JLabel("Player ID:");
        playerIdLabel_1.setBounds(20, 325, 100, 25);
        getContentPane().add(playerIdLabel_1);
        
        gameIdField2 = new JTextField(10);
        gameIdField2.setBounds(100, 295, 100, 25);
        getContentPane().add(gameIdField2);
        
        playerIdField2 = new JTextField(10);
        playerIdField2.setBounds(100, 324, 100, 25);
        getContentPane().add(playerIdField2);
        
        JLabel lblNewLabel = new JLabel("Add Played Data");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
        lblNewLabel.setBounds(20, 242, 180, 42);
        getContentPane().add(lblNewLabel);
        
        JLabel lblSearchPlayerOr = new JLabel("Search Player or Game");
        lblSearchPlayerOr.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
        lblSearchPlayerOr.setBounds(20, 399, 284, 42);
        getContentPane().add(lblSearchPlayerOr);
        
        JLabel searchPlayerLabel_1 = new JLabel("Search Player by ID:");
        searchPlayerLabel_1.setBounds(20, 446, 150, 25);
        getContentPane().add(searchPlayerLabel_1);

        // Add action listeners to buttons
        addGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                int gameId = Integer.parseInt(gameIdField.getText());
                String gameTitle = gameTitleField.getText();
                GameCRUD.addGame(gameId, gameTitle);
                clearFields();
            	}catch(Exception er) {
            		JOptionPane.showMessageDialog(null, "Please enter correct details","Error",JOptionPane.ERROR_MESSAGE);
            	}
            }
        });

        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                int playerId = Integer.parseInt(playerIdField.getText());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String address = addressField.getText();
                String postalCode = postalCodeField.getText();
                String province = provinceField.getText();
                String phoneNumber = phoneNumberField.getText();
                GameCRUD.addPlayer(playerId, firstName, lastName, address, postalCode, province, phoneNumber);
                clearFields();
            	}catch(Exception er) {
            		JOptionPane.showMessageDialog(null, "Please enter correct details","Error",JOptionPane.ERROR_MESSAGE);
            	}
            }
        });

        addGamePlayedByPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            	try {
                int gameId = Integer.parseInt(gameIdField2.getText());
                int playerId = Integer.parseInt(playerIdField2.getText());
                String playingDate = playingDateField.getText();
                int score = Integer.parseInt(scoreField.getText());
                GameCRUD.addGamePlayedByPlayer( gameId, playerId, playingDate, score);
                clearFields();
            	}catch(Exception er) {
            		JOptionPane.showMessageDialog(null, "Please enter correct details","Error",JOptionPane.ERROR_MESSAGE);
            	}
            }
        });

        searchGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                String gameTitle = searchGameTitleField.getText();
                List<Game> foundGames = GameCRUD.searchGame(gameTitle);
                GamesTable gamesTableFrame = new GamesTable(foundGames);
                gamesTableFrame.setVisible(true);
                clearFields();
                }catch(Exception ex) {
                	JOptionPane.showMessageDialog(null,"Invalid Input", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        playerDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPlayer = (String) playerDropdown.getSelectedItem();
                if (selectedPlayer != null) {
                    int playerId = Integer.parseInt(selectedPlayer.split(":")[0]);
                    GameCRUD.searchPlayerById(playerId);
                    clearFields();
                    showPlayerGames(playerId);
                }
            }
        });

        
        
        pack();
        setVisible(true);
    }
    
    

    private void populatePlayerDropdown() {
    
        playerDropdown.removeAllItems();

       
        List<Player> players = GameCRUD.getAllPlayers();

       
        for (Player player : players) {
            String playerInfo = player.playerId + ": " + player.first_name + " " + player.last_name;
            playerDropdown.addItem(playerInfo);
        }
    }
    
    
    private void clearFields() {
        gameIdField.setText("");
        gameIdField2.setText("");
        gameTitleField.setText("");
        playerIdField.setText("");
        playerIdField2.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        addressField.setText("");
        postalCodeField.setText("");
        provinceField.setText("");
        phoneNumberField.setText("");
       
        playingDateField.setText("");
        scoreField.setText("");
    }
    
    private void showPlayerGames(int playerId) {
        List<String> playerGames = GameCRUD.getPlayerGames(playerId);
       Player p = GameCRUD.searchPlayerById(playerId);

        if (playerGames.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Player with ID " + playerId + " has no played games.");
        } else {
            PlayerGamesTableFrame tableFrame = new PlayerGamesTableFrame(p, playerGames);
            tableFrame.setVisible(true);
        }
    }

    private void showUpdatePlayerFrame(int playerId) {
        Player player = GameCRUD.searchPlayerById(playerId);

        if (player == null) {
            JOptionPane.showMessageDialog(this, "Player with ID " + playerId + " not found.");
            return;
        }
        UpdatePlayerFrame updateFrame = new UpdatePlayerFrame(player);
        updateFrame.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CRUDApp();
            }
        });
    }
}
