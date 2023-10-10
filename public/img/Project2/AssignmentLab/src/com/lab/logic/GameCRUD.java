package com.lab.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GameCRUD {

	private static final String url = "jdbc:mysql://localhost:3306/gamesdb";
	private static final String username = "root";
	private static final String password = "";

	// Add Game
	public static void addGame(int gameId, String gameTitle) {
		String insertQuery = "INSERT INTO Game (game_id, game_title) VALUES (?, ?)";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
			pstmt.setInt(1, gameId);
			pstmt.setString(2, gameTitle);
			pstmt.executeUpdate();
			System.out.println("Game added successfully!");
			 JOptionPane.showMessageDialog(null, "Game added successfully!");
		} catch(java.sql.SQLIntegrityConstraintViolationException sqie) {
			JOptionPane.showMessageDialog(null, "Duplicate Entry for ID "+gameId,"Error",JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Add Player 
	public static void addPlayer(int playerId, String firstName, String lastName, String address, String postalCode,
			String province, String phoneNumber) {
		String insertQuery = "INSERT INTO Player (player_id, first_name, last_name, address, postal_code, province, phone_number) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
			pstmt.setInt(1, playerId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, address);
			pstmt.setString(5, postalCode);
			pstmt.setString(6, province);
			pstmt.setString(7, phoneNumber);
			pstmt.executeUpdate();
			System.out.println("Player added successfully!");
			 JOptionPane.showMessageDialog(null, "Player added successfully!");
		} catch(java.sql.SQLIntegrityConstraintViolationException sqie) {
			JOptionPane.showMessageDialog(null, "Duplicate Entry for ID "+playerId,"Error",JOptionPane.ERROR_MESSAGE);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Add Played Game
	public static void addGamePlayedByPlayer( int gameId, int playerId, String playingDate,
			int score) {
		String insertQuery = "INSERT INTO PlayerAndGame (game_id, player_id, playing_date, score) "
				+ "VALUES (?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
			
			pstmt.setInt(1, gameId);
			pstmt.setInt(2, playerId);
			pstmt.setString(3, playingDate);
			pstmt.setInt(4, score);
			pstmt.executeUpdate();
			System.out.println("Game played by player added successfully!");
			JOptionPane.showMessageDialog(null, "Game played by player added successfully!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Data entered is incorrect or IDs not found","ERROR",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	// Search player record by ID
	public static Player searchPlayerById(int playerId) {
		String selectQuery = "SELECT * FROM Player WHERE player_id = ?";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(selectQuery)) {
			pstmt.setInt(1, playerId);
			ResultSet resultSet = pstmt.executeQuery();

			Player player = new Player();

			if (resultSet.next()) {
				player.playerId = resultSet.getInt("player_id");
				player.first_name = resultSet.getString("first_name");
				player.last_name = resultSet.getString("last_name");
				player.address = resultSet.getString("address");
				player.postal_code = resultSet.getString("postal_code");
				player.province = resultSet.getString("province");
				player.phone_number = resultSet.getString("phone_number");

				return player;
			} else {
				System.out.println("Player with ID " + playerId + " not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// Search game by ID or name
	public static List<Game> searchGame(String gameTitle) {
		List<Game> result = new ArrayList<>();
		String selectQuery = "SELECT * FROM Game WHERE game_id LIKE ? OR game_title LIKE ?";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(selectQuery)) {
			pstmt.setString(1, gameTitle);
			pstmt.setString(2, "%"+gameTitle+"%");
			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				int foundGameId = resultSet.getInt("game_id");
				String foundGameTitle = resultSet.getString("game_title");
				Game game=new Game();
				game.setGameId(foundGameId);
				game.setGameTitle(foundGameTitle);
				result.add(game);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// Delete (Delete player by ID)
	public static void deletePlayerById(int playerId) {
		String deleteQuery = "DELETE FROM Player WHERE player_id = ?";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
			pstmt.setInt(1, playerId);
			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Player with ID " + playerId + " has been deleted.");
				JOptionPane.showMessageDialog(null, "Player with ID " + playerId + " has been deleted.");
				
			} else {
				System.out.println("Player with ID " + playerId + " not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<String> getPlayerGames(int playerId) {
		List<String> playerGames = new ArrayList<>();
		String selectQuery = "SELECT g.game_id, g.game_title, pg.playing_date, pg.score " + "FROM Game g "
				+ "JOIN PlayerAndGame pg ON g.game_id = pg.game_id " + "WHERE pg.player_id = ?";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(selectQuery)) {
			pstmt.setInt(1, playerId);
			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				int gameId = resultSet.getInt("game_id");
				String gameTitle = resultSet.getString("game_title");
				String playingDate = resultSet.getString("playing_date");
				int score = resultSet.getInt("score");
				String gameInfo = gameId + "," + gameTitle + "," + playingDate + "," + score;
				playerGames.add(gameInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerGames;
	}

	// Delete (Delete game by ID)
	public static void deleteGameById(int gameId) {
		String deleteQuery = "DELETE FROM Game WHERE game_id = ?";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
			pstmt.setInt(1, gameId);
			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Game with ID " + gameId + " has been deleted.");
				JOptionPane.showMessageDialog(null, "Game with ID " + gameId + " has been deleted.");
			} else {
				System.out.println("Game with ID " + gameId + " not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updatePlayer(int playerId, String firstName, String lastName, String address, String postalCode,
			String province, String phoneNumber) {
		String updateQuery = "UPDATE Player "
				+ "SET first_name = ?, last_name = ?, address = ?, postal_code = ?, province = ?, phone_number = ? "
				+ "WHERE player_id = ?";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, address);
			pstmt.setString(4, postalCode);
			pstmt.setString(5, province);
			pstmt.setString(6, phoneNumber);
			pstmt.setInt(7, playerId);

			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Player with ID " + playerId + " has been updated.");
				JOptionPane.showMessageDialog(null, "Player with ID " + playerId + " has been updated.");
			} else {
				System.out.println("Player with ID " + playerId + " not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	 public static List<Player> getAllPlayers() {
	        List<Player> players = new ArrayList<>();
	        String selectQuery = "SELECT * FROM Player";
	        try (Connection conn = DriverManager.getConnection(url, username, password);
	             PreparedStatement pstmt = conn.prepareStatement(selectQuery);
	             ResultSet resultSet = pstmt.executeQuery()) {

	            while (resultSet.next()) {
	                Player player = new Player();
	                player.playerId = resultSet.getInt("player_id");
	                player.first_name = resultSet.getString("first_name");
	                player.last_name = resultSet.getString("last_name");
	                player.address = resultSet.getString("address");
	                player.postal_code = resultSet.getString("postal_code");
	                player.province = resultSet.getString("province");
	                player.phone_number = resultSet.getString("phone_number");
	                players.add(player);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return players;
	    }

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 




		addGame(1, "Game 1");
		addPlayer(1, "John", "Doe", "123 Main St", "12345", "California", "555-123-4567");
		addGamePlayedByPlayer(1, 1, "2023-07-27", 100);

		searchPlayerById(1);

	

	
		// deletePlayerById(1);
		// deleteGameById(1);
	}
}
