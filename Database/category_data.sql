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

-- Dumping structure for table do-an-db.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `category_parent_id` bigint(20) DEFAULT NULL,
  `have_children` bit(1) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_acatplu22q5d1andql2jbvjy7` (`code`),
  KEY `FKgbowg38afm73793kwnokn0203` (`category_parent_id`),
  CONSTRAINT `FKgbowg38afm73793kwnokn0203` FOREIGN KEY (`category_parent_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table do-an-db.category: ~8 rows (approximately)
DELETE FROM `category`;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `code`, `created_date`, `updated_date`, `description`, `name`, `url`, `category_parent_id`, `have_children`, `icon`) VALUES
	(1, 'label.students', '2020-10-30 11:55:32.000000', '2020-10-30 11:55:33.000000', 'Xem danh sách sinh viên', 'Danh sách sinh viên', '/home/students', NULL, b'0', ''),
	(2, 'label.organization', '2020-10-30 11:57:08.000000', '2020-10-30 11:57:09.000000', 'Quản lý cơ cấu', 'Quản lý cơ cấu', NULL, NULL, b'1', ''),
	(3, 'label.units', '2020-10-30 11:58:40.000000', '2020-10-30 11:58:41.000000', 'Xem danh sách các phòng ban, khoa', 'Quản lý khoa', '/home/structure/units', 2, b'0', NULL),
	(5, 'label.department', '2020-10-30 12:01:35.000000', '2020-10-30 12:01:36.000000', 'Xem danh sách các bộ môn', 'Quản lý bộ môn', '/home/structure/departments', 2, b'0', NULL),
	(6, 'label.subjects', '2020-10-30 12:02:01.000000', '2020-10-30 12:02:04.000000', 'Xem danh sách các môn học', 'Quản lý môn học', '/home/structure/subjects', 2, b'0', NULL),
	(7, 'label.class.subjects', '2020-10-30 12:02:44.000000', '2020-10-30 12:02:45.000000', 'Xem danh sách các học phần', 'Quản lý học phần', '/home/class-subject', NULL, b'0', ''),
	(8, 'label.teaches', '2020-10-30 15:57:50.000000', '2020-10-30 15:57:51.000000', 'Xem danh sách giảng viên', 'Quản lý giảng viên', '/home/teachers', NULL, b'0', ''),
	(11, 'label.courses', '2020-12-30 02:27:07.000000', '2020-12-30 02:27:08.000000', 'Xem danh sách các khóa học', 'Quản lý khóa học', '/home/structure/courses', 2, b'0', NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
