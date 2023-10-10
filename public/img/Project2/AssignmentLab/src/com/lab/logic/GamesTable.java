package com.lab.logic;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.util.List;

public class GamesTable extends JFrame {

    private static final long serialVersionUID = 1L;

	public GamesTable(List<Game> games) {
        setTitle("Searched Games");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setPreferredSize(new Dimension(600, 400));

        String[] columnNames = {"Game ID", "Game Title"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        for (Game game : games) {
            String[] gameData = {Integer.toString(game.getGameId()),game.getGameTitle()};
            tableModel.addRow(gameData);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 550, 320);
        add(scrollPane);

        pack();
        setVisible(true);
    }
}
