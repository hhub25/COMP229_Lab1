create database named gamesdb 
Import sql file 

In order to manually create tables use these queries

Game 

CREATE TABLE Game (
    game_id INT AUTO_INCREMENT PRIMARY KEY,
    game_title VARCHAR(255)
);

Player 

CREATE TABLE Player (
    player_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(255),
    postal_code VARCHAR(10),
    province VARCHAR(50),
    phone_number VARCHAR(20)
);

PlayerAndGame

CREATE TABLE PlayerAndGame (
    player_game_id INT AUTO_INCREMENT PRIMARY KEY,
    game_id INT,
    player_id INT,
    playing_date DATE,
    score INT,
    FOREIGN KEY (game_id) REFERENCES Game(game_id),
    FOREIGN KEY (player_id) REFERENCES Player(player_id)
);

