-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 27, 2023 at 09:52 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gamesdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Game`
--

CREATE TABLE `Game` (
  `game_id` int(11) NOT NULL,
  `game_title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Game`
--

INSERT INTO `Game` (`game_id`, `game_title`) VALUES
(1, 'Game 1'),
(3, 'Nord'),
(4, 'PUBG'),
(5, 'GTA VC'),
(40, 'Grand Theft Auto 5');

-- --------------------------------------------------------

--
-- Table structure for table `Player`
--

CREATE TABLE `Player` (
  `player_id` int(11) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `postal_code` varchar(10) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Player`
--

INSERT INTO `Player` (`player_id`, `first_name`, `last_name`, `address`, `postal_code`, `province`, `phone_number`) VALUES
(1, 'John', 'Doe', '123 Main St', '12345', 'America', '555-123-4567'),
(2, 'SS', 'Sd', 'ddd', '44000', 'P', '0123'),
(6, 'F', 'S', 'H', '11', 'HJ', '123'),
(45, 'XYZ123XYZ', 'Example', 'XYZ', '1100', 'XYZ', '123'),
(99, 'SVD', 'DSV', 'ss', '123s', '123', '123');

-- --------------------------------------------------------

--
-- Table structure for table `PlayerAndGame`
--

CREATE TABLE `PlayerAndGame` (
  `player_game_id` int(11) NOT NULL,
  `game_id` int(11) DEFAULT NULL,
  `player_id` int(11) DEFAULT NULL,
  `playing_date` date DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `PlayerAndGame`
--

INSERT INTO `PlayerAndGame` (`player_game_id`, `game_id`, `player_id`, `playing_date`, `score`) VALUES
(1, 1, 1, '2023-07-27', 100),
(2, 1, 2, '2023-12-12', 12),
(4, 1, 1, '2023-07-27', 100),
(5, 1, 1, '2023-07-27', 100),
(6, 1, 1, '2023-07-27', 100),
(7, 1, 1, '2023-07-27', 100),
(10, 1, 1, '2023-07-27', 100),
(12, 40, 45, '2020-11-11', 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Game`
--
ALTER TABLE `Game`
  ADD PRIMARY KEY (`game_id`);

--
-- Indexes for table `Player`
--
ALTER TABLE `Player`
  ADD PRIMARY KEY (`player_id`);

--
-- Indexes for table `PlayerAndGame`
--
ALTER TABLE `PlayerAndGame`
  ADD PRIMARY KEY (`player_game_id`),
  ADD KEY `game_id` (`game_id`),
  ADD KEY `player_id` (`player_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Game`
--
ALTER TABLE `Game`
  MODIFY `game_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `Player`
--
ALTER TABLE `Player`
  MODIFY `player_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `PlayerAndGame`
--
ALTER TABLE `PlayerAndGame`
  MODIFY `player_game_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `PlayerAndGame`
--
ALTER TABLE `PlayerAndGame`
  ADD CONSTRAINT `playerandgame_ibfk_1` FOREIGN KEY (`game_id`) REFERENCES `Game` (`game_id`),
  ADD CONSTRAINT `playerandgame_ibfk_2` FOREIGN KEY (`player_id`) REFERENCES `Player` (`player_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
