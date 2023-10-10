package com.lab.logic;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PlayerGamesTableFrame extends JFrame {

    private static final long serialVersionUID = 1L;

	public PlayerGamesTableFrame(Player player, List<String> playerGames) {
        setTitle("Player and Played Games");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 400));

    
        JPanel playerDetailsPanel = new JPanel();
        
        
        playerDetailsPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

    
        
        
	if(player==null) {
		JOptionPane.showMessageDialog(null, "Error No Player","Error",JOptionPane.ERROR_MESSAGE);
	}
     
        
        
        
        

        // Panel for the JTable
        JPanel tablePanel = new JPanel(new BorderLayout());

        String[] columnNames = {"Game ID", "Game Title", "Playing Date", "Score"};
        Object[][] data = new Object[playerGames.size()][4];

        for (int i = 0; i < playerGames.size(); i++) {
            String[] gameInfo = playerGames.get(i).split(",");
            for (int j = 0; j < 4; j++) {
                data[i][j] = gameInfo[j];
            }
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to the main frame
        getContentPane().add(playerDetailsPanel, BorderLayout.NORTH);
        playerDetailsPanel.setLayout(new GridLayout(8, 0, 0, 0));
        
  
        
        
         JLabel playerIdLabelX = new JLabel("Player ID");
         playerDetailsPanel.add(playerIdLabelX);
         
		 JLabel playerIdLabel = new JLabel("" + player.playerId);
		 playerDetailsPanel.add(playerIdLabel);
		 
		 JLabel first_nameX  = new JLabel("Player First Name");
		 playerDetailsPanel.add(first_nameX);
		 JLabel first_name = new JLabel("" + player.first_name);
		 playerDetailsPanel.add(first_name);
		 JLabel last_nameX = new JLabel("Player Last Name");
	       playerDetailsPanel.add(last_nameX);
		 JLabel last_name = new JLabel("" + player.last_name);
	        playerDetailsPanel.add(last_name);
		 JLabel addressX = new JLabel("Player Address");
	        playerDetailsPanel.add(addressX);
		 JLabel address = new JLabel(" " + player.address);
	        playerDetailsPanel.add(address);
		 JLabel postal_codeX = new JLabel("Player Postal Code");
	      playerDetailsPanel.add(postal_codeX);
		 JLabel postal_code = new JLabel("" + player.postal_code);
	      playerDetailsPanel.add(postal_code);
		 JLabel provinceX = new JLabel("Player Province");
	     playerDetailsPanel.add(provinceX);
		 JLabel province = new JLabel("" +  player.province);
	     playerDetailsPanel.add(province);
		 JLabel phone_numberX = new JLabel("Player Phone Number");
	        playerDetailsPanel.add(phone_numberX);
		 JLabel phone_number = new JLabel("" + player.phone_number);
	     playerDetailsPanel.add(phone_number);
			
        getContentPane().add(tablePanel, BorderLayout.CENTER);

        pack();
    }
}
