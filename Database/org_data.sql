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

-- Dumping data for table do-an-db.department: ~2 rows (approximately)
DELETE FROM `department`;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`id`, `code`, `created_date`, `updated_date`, `date_founding`, `description`, `name`, `unit_id`, `user_manager_id`) VALUES
	(1, 'NN', '2020-12-09 11:22:23.000000', '2020-12-09 11:22:24.000000', NULL, 'Bộ môn ngoại ngữ', 'Bộ môn Ngoại Ngữ', 3, NULL),
	(2, 'CNTTTH', '2021-01-06 11:34:03.000000', '2021-01-06 11:34:04.000000', NULL, 'Bộ môn CNTT Tổng hợp', 'Bộ môn CNTT Tổng hợp', 4, NULL);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Dumping data for table do-an-db.unit: ~5 rows (approximately)
DELETE FROM `unit`;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` (`id`, `code`, `created_date`, `updated_date`, `date_founding`, `description`, `name`, `user_deputy_manager_id`, `user_manager_id`) VALUES
	(1, 'PDT', '2020-10-29 09:42:49.000000', '2020-10-29 09:42:50.000000', NULL, 'Phòng đào tạo', 'Phòng Đào tạo', NULL, 2),
	(2, 'PCT', '2020-10-30 11:39:24.000000', '2020-10-30 11:39:25.000000', NULL, 'Phòng chính trị', 'Phòng Chính trị', NULL, NULL),
	(3, 'KCB', '2020-10-30 11:43:37.000000', '2020-10-30 11:43:37.000000', NULL, 'Khoa cơ bản', 'Khoa Cơ bản', NULL, NULL),
	(4, 'CNTT', '2020-10-30 11:40:13.000000', '2020-10-30 11:40:14.000000', NULL, 'Khoa công nghệ thông tin', 'Khoa Công nghệ thông tin', NULL, NULL),
	(5, 'KTVT', '2020-10-30 11:40:55.000000', '2020-10-30 11:40:56.000000', NULL, 'Khoa kinh tế vận tải', 'Khoa Kinh tế vận tải', NULL, NULL),
	(8, 'SYS', '2020-11-25 11:21:21.000000', '2020-11-25 11:21:23.000000', NULL, 'Quản trị hệ thống', 'Quản trị hệ thống', NULL, NULL);
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
