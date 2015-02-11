-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 11, 2015 at 01:07 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cassoft`
--

-- --------------------------------------------------------

--
-- Table structure for table `credentials`
--

CREATE TABLE IF NOT EXISTS `credentials` (
  `c_Id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `credentials`
--

INSERT INTO `credentials` (`c_Id`, `name`, `password`) VALUES
(1, 'prophet', 'cassoft');

-- --------------------------------------------------------

--
-- Table structure for table `guardians`
--

CREATE TABLE IF NOT EXISTS `guardians` (
`guardian_Id` int(10) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `relationship` varchar(255) NOT NULL,
  `telephone` int(10) NOT NULL,
  `postal_address` varchar(255) NOT NULL,
  `residential_address` varchar(255) NOT NULL,
  `education_level` varchar(255) NOT NULL,
  `age` int(11) NOT NULL DEFAULT '0',
  `gender` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicals`
--

CREATE TABLE IF NOT EXISTS `medicals` (
`medical_Id` int(10) NOT NULL,
  `special_conditions` varchar(255) NOT NULL,
  `medications` varchar(255) NOT NULL,
  `notes` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `music`
--

CREATE TABLE IF NOT EXISTS `music` (
`music_id` int(10) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `album` varchar(255) DEFAULT 'unknown',
  `path` tinyblob NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `music`
--

INSERT INTO `music` (`music_id`, `title`, `author`, `time`, `album`, `path`, `date`) VALUES
(1, 'The Scientist', 'Coldplay', '265', 'X&Y', 0x4c4f41445f46494c4528433a557365727349737261656c20416779656d616e2d5072656d704d757369635472617878436f6c64706c617958265954686520536369656e746973742e6d703329, '2014-12-06'),
(2, 'Get Lucky (Feat. Pharrell Will', 'Daft Punk', '369', 'Random Access Memories', 0x4c4f41445f46494c4528433a557365727349737261656c20416779656d616e2d5072656d704d7573696354726178784461667450756e6b446166742050756e6b202d2052616e646f6d20416363657373204d656d6f7269657320283230313329203332306b627073205b476c6f7747617a652e436f6d5d003820446166742050756e6b202d20476574204c75636b792028466561742e205068617272656c6c2057696c6c69616d7329205b476c6f7747617a652e436f6d5d2e6d703329, '2014-12-06'),
(3, 'Tell Me', 'Capital Kings', '224', 'Capital Kings', 0x4c4f41445f46494c4528433a557365727349737261656c20416779656d616e2d5072656d704d7573696354726178784361706974616c204b696e677300392054656c6c204d652e6d703329, '2014-12-06'),
(6, 'On Top of the World', 'Imagine Dragons', '192', 'Night Visions (Deluxe Version)', 0x4c4f41445f46494c4528433a557365727349737261656c20416779656d616e2d5072656d704d757369635472617878496d6167696e6520447261676f6e73202d204e6967687420566973696f6e73202844656c7578652056657273696f6e292032303133203332306b627073205b476c6f7747617a652e436f6d5d0035204f6e20546f70206f662074686520576f726c64205b476c6f7747617a652e436f6d5d2e6d703329, '2014-12-06'),
(7, 'Desperate People', 'Hillsong United', '330', 'All Of The Above', 0x4c4f41445f46494c4528433a557365727349737261656c20416779656d616e2d5072656d704d757369635472617878416c6c206f66207468652041626f76650033202d2048696c6c736f6e6720556e69746564202d204465737065726174652050656f706c652e6d703329, '2014-12-06'),
(8, 'Bones', 'Hillsong United', '376', 'Aftermath', 0x4c4f41445f46494c4528433a557365727349737261656c20416779656d616e2d5072656d704d75736963547261787848696c6c736f6e67202d2032303131202d2041667465726d6174680037202d20426f6e65732e6d703329, '2014-12-06'),
(9, 'Father', 'Hillsong United', '411', 'Aftermath', 0x4c4f41445f46494c4528433a557365727349737261656c20416779656d616e2d5072656d704d75736963547261787848696c6c736f6e67202d2032303131202d2041667465726d6174680038202d204661746865722e6d703329, '2014-12-06');

-- --------------------------------------------------------

--
-- Table structure for table `settings`
--

CREATE TABLE IF NOT EXISTS `settings` (
`setting_Id` int(10) NOT NULL,
  `year` int(4) NOT NULL,
  `term` int(1) NOT NULL,
  `school_fee` double NOT NULL,
  `classes_fee` double NOT NULL,
  `feeding_fee` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `settings`
--

INSERT INTO `settings` (`setting_Id`, `year`, `term`, `school_fee`, `classes_fee`, `feeding_fee`) VALUES
(1, 2014, 1, 100, 50, 50),
(2, 2014, 2, 100, 50, 50),
(3, 2014, 1, 100, 50, 50);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
`student_Id` int(10) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `age` int(3) NOT NULL DEFAULT '0',
  `date_of_birth` date DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `medical_Id` int(10) DEFAULT NULL,
  `guardian_Id` int(10) DEFAULT NULL,
  `graduation_year` int(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`student_Id`, `surname`, `firstname`, `age`, `date_of_birth`, `gender`, `medical_Id`, `guardian_Id`, `graduation_year`) VALUES
(1, 'Agyeman-Prempeh', 'Prophet', 0, NULL, NULL, NULL, NULL, 2025),
(2, 'Vera', 'Asante', 0, NULL, NULL, NULL, NULL, 2026),
(3, 'Acolatse', 'Dzidzor', 0, NULL, NULL, NULL, NULL, 2023),
(4, 'Joseph', 'Otto', 0, NULL, NULL, NULL, NULL, 2018);

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE IF NOT EXISTS `transactions` (
`transaction_Id` int(10) NOT NULL,
  `student_Id` int(10) DEFAULT NULL,
  `term_cost` int(10) NOT NULL DEFAULT '0',
  `amount_paid` int(10) NOT NULL DEFAULT '0',
  `date` date NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `guardians`
--
ALTER TABLE `guardians`
 ADD PRIMARY KEY (`guardian_Id`);

--
-- Indexes for table `medicals`
--
ALTER TABLE `medicals`
 ADD PRIMARY KEY (`medical_Id`);

--
-- Indexes for table `music`
--
ALTER TABLE `music`
 ADD PRIMARY KEY (`music_id`);

--
-- Indexes for table `settings`
--
ALTER TABLE `settings`
 ADD PRIMARY KEY (`setting_Id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
 ADD PRIMARY KEY (`student_Id`), ADD KEY `medical_Id` (`medical_Id`), ADD KEY `guardian_Id` (`guardian_Id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
 ADD PRIMARY KEY (`transaction_Id`), ADD KEY `student_Id` (`student_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `guardians`
--
ALTER TABLE `guardians`
MODIFY `guardian_Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `medicals`
--
ALTER TABLE `medicals`
MODIFY `medical_Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `music`
--
ALTER TABLE `music`
MODIFY `music_id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `settings`
--
ALTER TABLE `settings`
MODIFY `setting_Id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
MODIFY `student_Id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
MODIFY `transaction_Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `students`
--
ALTER TABLE `students`
ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`medical_Id`) REFERENCES `medicals` (`medical_Id`),
ADD CONSTRAINT `students_ibfk_2` FOREIGN KEY (`guardian_Id`) REFERENCES `guardians` (`guardian_Id`);

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`student_Id`) REFERENCES `students` (`student_Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
