DELETE FROM `user_infor`;
DELETE FROM `department`;
DELETE FROM `unit`;
DELETE FROM `user`;

INSERT INTO `user` (`id`, `code`, `created_date`, `updated_date`, `account_non_locked`, `account_non_expired`, `enabled`, `password`, `username`) VALUES
	(1, 'ACC20201015249', '2020-10-15 14:49:36.000000', '2020-10-15 14:49:36.000000', 1, 1, 1, '$2a$10$h3uXvu8iiiPeZIsOaH5Gu.8mquUuGa/JjD61mBVAomMC9GXGOs5eG', 'sysadmin'),
	(2, 'ACC20201029939', '2020-10-29 09:39:45.000000', '2021-01-01 03:22:56.644000', 0, 1, 1, '$2a$10$h3uXvu8iiiPeZIsOaH5Gu.8mquUuGa/JjD61mBVAomMC9GXGOs5eG', 'hieptm'),
	(5, 'UTC20210101765', '2021-01-01 07:06:35.426000', '2021-01-01 07:06:35.426000', 1, 1, 1, '$2a$10$IcONv.3ymMo5R6/FgHIKo.TuUljyM1MDqyFzB9r3B2CL8.nGGDTJO', 'landt');

INSERT INTO `unit` (`id`, `code`, `created_date`, `updated_date`, `date_founding`, `description`, `name`, `user_deputy_manager_id`, `user_manager_id`) VALUES
	(1, 'PDT', '2020-10-29 09:42:49.000000', '2020-10-29 09:42:50.000000', NULL, 'Phòng đào tạo', 'Phòng Đào tạo', NULL, 2),
	(2, 'PCT', '2020-10-30 11:39:24.000000', '2020-10-30 11:39:25.000000', NULL, 'Phòng chính trị', 'Phòng Chính trị', NULL, NULL),
	(3, 'KCB', '2020-10-30 11:43:37.000000', '2020-10-30 11:43:37.000000', NULL, 'Khoa cơ bản', 'Khoa Cơ bản', NULL, NULL),
	(4, 'CNTT', '2020-10-30 11:40:13.000000', '2020-10-30 11:40:14.000000', NULL, 'Khoa công nghệ thông tin', 'Khoa Công nghệ thông tin', NULL, NULL),
	(5, 'KTVT', '2020-10-30 11:40:55.000000', '2020-10-30 11:40:56.000000', NULL, 'Khoa kinh tế vận tải', 'Khoa Kinh tế vận tải', NULL, NULL),
	(8, 'SYS', '2020-11-25 11:21:21.000000', '2020-11-25 11:21:23.000000', NULL, 'Quản trị hệ thống', 'Quản trị hệ thống', NULL, NULL);

INSERT INTO `department` (`id`, `code`, `created_date`, `updated_date`, `date_founding`, `description`, `name`, `unit_id`, `user_manager_id`) VALUES
	(1, 'NN', '2020-12-09 11:22:23.000000', '2020-12-09 11:22:24.000000', NULL, 'Bộ môn ngoại ngữ', 'Bộ môn Ngoại Ngữ', 3, NULL),
	(2, 'CNTTTH', '2021-01-06 11:34:03.000000', '2021-01-06 11:34:04.000000', NULL, 'Bộ môn CNTT Tổng hợp', 'Bộ môn CNTT Tổng hợp', 4, NULL);

INSERT INTO `user_infor` (`id`, `code`, `created_date`, `updated_date`, `address`, `dob`, `email`, `gender`, `number_phone`, `role_id`, `first_name`, `last_name`, `unit_id`, `user_id`, `qualifications`, `work_end_date`, `work_start_date`, `nation_id`, `district_id`, `province_id`, `ward_id`, `department_id`) VALUES
	(1, 'ACC20201015249', '2020-10-19 17:07:44.000000', '2020-10-19 17:07:45.000000', 'Hải Dương', '1996-01-15 00:00:00.000000', 'tranminhhiep.1996@gmail.com', 0, '0123456789', 1, 'Trần', 'Minh Hiệp', 8, 1, 0, NULL, NULL, 232, NULL, NULL, NULL, NULL),
	(2, 'ACC20201029939', '2020-10-29 09:40:43.000000', '2020-10-29 09:40:43.000000', 'Hà Nội', '1990-01-01 00:00:00.000000', 'hieptm@gmail.com', 0, '0123456789', 2, 'Trần', 'Minh Hiệp', 1, 2, 0, NULL, NULL, 232, NULL, NULL, NULL, NULL),
	(5, 'UTC20210101765', '2021-01-01 07:06:35.456000', '2021-01-01 07:06:35.456000', NULL, NULL, 'landt@gmail.com', 0, NULL, 6, 'Đặng', 'Thị Lan', 4, 5, 0, NULL, NULL, NULL, NULL, NULL, NULL, 1);
