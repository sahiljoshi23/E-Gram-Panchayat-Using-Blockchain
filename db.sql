# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     gram_fund_distribution_application_db
# Server version:               5.1.73-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2024-11-06 17:00:16
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for gram_fund_distribution_application_db
CREATE DATABASE IF NOT EXISTS `gram_fund_distribution_application_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gram_fund_distribution_application_db`;


# Dumping structure for table gram_fund_distribution_application_db.tblaa
CREATE TABLE IF NOT EXISTS `tblaa` (
  `A_id` int(10) NOT NULL AUTO_INCREMENT,
  `A_Name` text,
  `A_Email_ID` text,
  `A_Password` text,
  `A_Mobile` text,
  `Address` text,
  PRIMARY KEY (`A_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table gram_fund_distribution_application_db.tblaa: 1 rows
/*!40000 ALTER TABLE `tblaa` DISABLE KEYS */;
INSERT INTO `tblaa` (`A_id`, `A_Name`, `A_Email_ID`, `A_Password`, `A_Mobile`, `Address`) VALUES (1, 'gov', 'gov@gmail.com', 'Go@12345', '9874563202', 'pune');
/*!40000 ALTER TABLE `tblaa` ENABLE KEYS */;


# Dumping structure for table gram_fund_distribution_application_db.tblowner
CREATE TABLE IF NOT EXISTS `tblowner` (
  `O_id` int(10) NOT NULL AUTO_INCREMENT,
  `O_Name` text,
  `O_Email_ID` text,
  `O_Password` text,
  `O_Mobile` text,
  `Address` text,
  PRIMARY KEY (`O_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table gram_fund_distribution_application_db.tblowner: 1 rows
/*!40000 ALTER TABLE `tblowner` DISABLE KEYS */;
INSERT INTO `tblowner` (`O_id`, `O_Name`, `O_Email_ID`, `O_Password`, `O_Mobile`, `Address`) VALUES (1, 'jitu', 'jitu@gmail.com', 'Jp@12345', '9874563210', 'pune');
/*!40000 ALTER TABLE `tblowner` ENABLE KEYS */;


# Dumping structure for table gram_fund_distribution_application_db.tbluser
CREATE TABLE IF NOT EXISTS `tbluser` (
  `U_id` int(10) NOT NULL AUTO_INCREMENT,
  `U_Name` text,
  `U_Email_ID` text,
  `U_Password` text,
  `U_Mobile` text,
  `Address` text,
  PRIMARY KEY (`U_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table gram_fund_distribution_application_db.tbluser: 1 rows
/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
INSERT INTO `tbluser` (`U_id`, `U_Name`, `U_Email_ID`, `U_Password`, `U_Mobile`, `Address`) VALUES (1, 'om', 'om@gmail.com', 'Om@123456', '9874563210', 'pune');
/*!40000 ALTER TABLE `tbluser` ENABLE KEYS */;


# Dumping structure for table gram_fund_distribution_application_db.tbl_user_fund_info
CREATE TABLE IF NOT EXISTS `tbl_user_fund_info` (
  `F_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Panchayat_Name` text,
  `Panchayat_Email_ID` text,
  `U_Fund_name` text,
  `U_Fund_cost` text,
  `U_Fund_Description` text,
  `U_Fund_Date` text,
  `A_Email_ID` text,
  `Status_msg` text,
  PRIMARY KEY (`F_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

# Dumping data for table gram_fund_distribution_application_db.tbl_user_fund_info: 1 rows
/*!40000 ALTER TABLE `tbl_user_fund_info` DISABLE KEYS */;
INSERT INTO `tbl_user_fund_info` (`F_ID`, `Panchayat_Name`, `Panchayat_Email_ID`, `U_Fund_name`, `U_Fund_cost`, `U_Fund_Description`, `U_Fund_Date`, `A_Email_ID`, `Status_msg`) VALUES (4, 'pune', 'pune@gmail.com', 'school', '12000', 'kjgh', '06/11/2024 04:52:55', NULL, 'Waiting');
/*!40000 ALTER TABLE `tbl_user_fund_info` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
