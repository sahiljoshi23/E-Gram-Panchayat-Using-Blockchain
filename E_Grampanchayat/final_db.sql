# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     gram_fund_distribution_application_db
# Server version:               5.1.73-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2025-04-12 15:05:05
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for gram_fund_distribution_application_db
CREATE DATABASE IF NOT EXISTS `gram_fund_distribution_application_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gram_fund_distribution_application_db`;


# Dumping structure for table gram_fund_distribution_application_db.complaints
CREATE TABLE IF NOT EXISTS `complaints` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` text,
  `Gram_Panchayat_Name` text,
  `Gram_Panchayat_Email` text,
  `subject` text,
  `description` text,
  `status` text,
  `Current_Date_Time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Response_date` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table gram_fund_distribution_application_db.complaints: 2 rows
/*!40000 ALTER TABLE `complaints` DISABLE KEYS */;
INSERT INTO `complaints` (`id`, `user_id`, `Gram_Panchayat_Name`, `Gram_Panchayat_Email`, `subject`, `description`, `status`, `Current_Date_Time`, `Response_date`) VALUES (1, 'om@gmail.com', 'jitu', 'jitu@gmail.com', 'tree', 'best', 'Resolved', '2025-04-09 18:41:43', '10/04/2025 11:10:19'), (2, 'om@gmail.com', 'jitu', 'jitu@gmail.com', 'school', 'jds', 'Resolved', '2025-04-12 14:49:41', '12-04-2025 02:49:57');
/*!40000 ALTER TABLE `complaints` ENABLE KEYS */;


# Dumping structure for table gram_fund_distribution_application_db.tax_notice
CREATE TABLE IF NOT EXISTS `tax_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `holder_name` text,
  `email_id` text,
  `Tax_Name` text,
  `Tax_Description` text,
  `tax_amount` text,
  `due_date` text,
  `status` text,
  `Gram_Panchayat_Email` text,
  `Discount_Percent` text,
  `Discount_Amount` text,
  `Final_Amount` text,
  `Payment_Date` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table gram_fund_distribution_application_db.tax_notice: 2 rows
/*!40000 ALTER TABLE `tax_notice` DISABLE KEYS */;
INSERT INTO `tax_notice` (`id`, `holder_name`, `email_id`, `Tax_Name`, `Tax_Description`, `tax_amount`, `due_date`, `status`, `Gram_Panchayat_Email`, `Discount_Percent`, `Discount_Amount`, `Final_Amount`, `Payment_Date`) VALUES (1, 'om', 'om@gmail.com', 'Property Tax', 'urgent paid Property Tax', '2000', '2025-04-30', 'Paid', 'jitu@gmail.com', '30%', '600.0', '1400.0', '12/04/2025 02:08:34'), (2, 'om', 'om@gmail.com', 'water tax', 'sag', '3000', '2025-04-30', 'Paid', 'jitu@gmail.com', '30%', '900.0', '2100.0', '12/04/2025 02:53:04');
/*!40000 ALTER TABLE `tax_notice` ENABLE KEYS */;


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
  `Transfer_Funds` text,
  `Status_msg` text,
  `Response_date` text,
  PRIMARY KEY (`F_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

# Dumping data for table gram_fund_distribution_application_db.tbl_user_fund_info: 3 rows
/*!40000 ALTER TABLE `tbl_user_fund_info` DISABLE KEYS */;
INSERT INTO `tbl_user_fund_info` (`F_ID`, `Panchayat_Name`, `Panchayat_Email_ID`, `U_Fund_name`, `U_Fund_cost`, `U_Fund_Description`, `U_Fund_Date`, `Transfer_Funds`, `Status_msg`, `Response_date`) VALUES (5, 'jitu', 'jitu@gmail.com', 'tree', '5000', 'best', '09/04/2025 06:39:54', '2500', 'Transfer_Funds', '10-04-2025 12:03:51'), (4, 'pune', 'pune@gmail.com', 'school', '12000', 'kjgh', '06/11/2024 04:52:55', NULL, 'Waiting', NULL), (6, 'jitu', 'jitu@gmail.com', 'hospital', '100000', 'building update', '12/04/2025 02:45:27', '5500', 'Transfer_Funds', '12-04-2025 03:04:09');
/*!40000 ALTER TABLE `tbl_user_fund_info` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
