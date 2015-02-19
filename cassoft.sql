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


create Database `cassoft`;
use `cassoft`;


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
(1, 'johndoe', 'cassoft');

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
(1, 'Agyeman-Prempeh', 'Israel', 0, NULL, NULL, NULL, NULL, 2025),
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
 -- Indexes for table `credentials`
 --

ALTER TABLE `credentials`
 ADD PRIMARY KEY (`c_Id`), ADD KEY `c_Id` (`c_Id`);



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
-- AUTO_INCREMENT for table `credentials`
--
ALTER TABLE `credentials`
MODIFY `c_Id` int(10) NOT NULL AUTO_INCREMENT;

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
