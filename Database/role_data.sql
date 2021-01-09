-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.5-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping data for table do-an-db.role: ~5 rows (approximately)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `code`, `created_date`, `updated_date`, `description`, `name`) VALUES
	(1, 'SYSADMIN', '2020-10-19 17:06:23.000000', '2020-10-19 17:06:24.000000', 'Quản trị hệ thống', 'Quản trị hệ thống'),
	(2, 'ADEDU', '2020-10-19 17:13:42.000000', '2020-10-19 17:13:43.000000', 'Quản lý đào tạo', 'Quản lý đào tạo'),
	(3, 'ADPOLITIC', '2020-10-19 17:17:09.000000', '2020-10-19 17:17:10.000000', 'Quản lý chính trị', 'Quản lý chính trị'),
	(4, 'ADCOLLEGE', '2020-10-19 17:21:51.000000', '2020-10-19 17:21:52.000000', 'Quản lý khoa', 'Quản lý khoa'),
	(5, 'ADSUBJ', '2020-10-19 17:22:36.000000', '2020-10-19 17:22:37.000000', 'Quản lý bộ môn', 'Quản lý bộ môn'),
	(6, 'TEACH', '2020-10-19 17:23:16.000000', '2020-10-19 17:23:17.000000', 'Giảng viên', 'Giảng viên');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
