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

-- Dumping data for table do-an-db.user: ~3 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `code`, `created_date`, `updated_date`, `account_non_locked`, `account_non_expired`, `enabled`, `password`, `username`) VALUES
	(1, 'ACC20201015249', '2020-10-15 14:49:36.000000', '2020-10-15 14:49:36.000000', 1, 1, 1, '$2a$10$h3uXvu8iiiPeZIsOaH5Gu.8mquUuGa/JjD61mBVAomMC9GXGOs5eG', 'sysadmin'),
	(2, 'ACC20201029939', '2020-10-29 09:39:45.000000', '2021-01-01 03:22:56.644000', 0, 1, 1, '$2a$10$h3uXvu8iiiPeZIsOaH5Gu.8mquUuGa/JjD61mBVAomMC9GXGOs5eG', 'hieptm'),
	(5, 'UTC20210101765', '2021-01-01 07:06:35.426000', '2021-01-01 07:06:35.426000', 1, 1, 1, '$2a$10$IcONv.3ymMo5R6/FgHIKo.TuUljyM1MDqyFzB9r3B2CL8.nGGDTJO', 'landt');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping data for table do-an-db.user_infor: ~3 rows (approximately)
DELETE FROM `user_infor`;
/*!40000 ALTER TABLE `user_infor` DISABLE KEYS */;
INSERT INTO `user_infor` (`id`, `code`, `created_date`, `updated_date`, `address`, `dob`, `email`, `gender`, `number_phone`, `role_id`, `first_name`, `last_name`, `unit_id`, `user_id`, `qualifications`, `work_end_date`, `work_start_date`, `nation_id`, `district_id`, `province_id`, `ward_id`, `department_id`) VALUES
	(1, 'ACC20201015249', '2020-10-19 17:07:44.000000', '2020-10-19 17:07:45.000000', 'Hải Dương', '1996-01-15 00:00:00.000000', 'tranminhhiep.1996@gmail.com', 0, '0123456789', 1, 'Trần', 'Minh Hiệp', 8, 1, 0, NULL, NULL, 232, NULL, NULL, NULL, NULL),
	(2, 'ACC20201029939', '2020-10-29 09:40:43.000000', '2020-10-29 09:40:43.000000', 'Hà Nội', '1990-01-01 00:00:00.000000', 'hieptm@gmail.com', 0, '0123456789', 2, 'Trần', 'Minh Hiệp', 1, 2, 0, NULL, NULL, 232, NULL, NULL, NULL, NULL),
	(5, 'UTC20210101765', '2021-01-01 07:06:35.456000', '2021-01-01 07:06:35.456000', NULL, NULL, 'landt@gmail.com', 0, NULL, 6, 'Đặng', 'Thị Lan', 4, 5, 0, NULL, NULL, NULL, NULL, NULL, NULL, 1);
/*!40000 ALTER TABLE `user_infor` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
