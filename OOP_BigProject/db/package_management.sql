-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 27, 2023 lúc 12:22 PM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `package_management`
--
CREATE DATABASE IF NOT EXISTS `package_management` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `package_management`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `address`
--

INSERT INTO `address` (`id`, `location`) VALUES
(1, 'Ha Noi'),
(2, 'HCM'),
(3, 'Hoa Binh'),
(4, 'Son La'),
(5, 'Dien Bien'),
(6, 'Lao Cai'),
(7, 'Yen Bai'),
(8, 'Phu Tho'),
(9, 'Ba Ria Vung Tau'),
(10, 'Bac Kan'),
(11, 'Bac Ninh'),
(12, 'Ben Tre');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  `address` int(11) NOT NULL,
  `role` enum('sender','receiver') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `name`, `phoneNumber`, `address`, `role`) VALUES
(1, 'Nguyen Van Sender', '0123456789', 1, 'sender'),
(2, 'Nguyen Van Receiver', '0987654321', 2, 'receiver'),
(3, 'Santo Crescenzo', '0122357725', 3, 'sender'),
(4, 'Signý Nadzieja', '0857936303', 8, 'sender'),
(5, 'Maria Hammond', '0921750125', 7, 'receiver'),
(6, 'Trafford Edmonda', '0622130454', 4, 'receiver'),
(7, 'Pyrrhus Alf', '0135792468', 1, 'sender'),
(8, 'Atticus Jon', '0975136543', 5, 'sender'),
(9, 'Nguyen Van Sender', '0123456789', 10, 'sender'),
(10, 'Cyril Piia', '0935778113', 4, 'receiver'),
(11, 'Brecht Omari', '0156899987', 11, 'sender'),
(12, 'Nou Élodie', '0251223751', 12, 'sender');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `package`
--

CREATE TABLE `package` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT 'package',
  `weight` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `package`
--

INSERT INTO `package` (`id`, `description`, `weight`) VALUES
(1, 'Apple iPhone 11 64GB', 24),
(2, 'Apple iPhone 13 128GB', 30),
(3, 'Apple iPhone 12 64GB', 29),
(4, 'Điện Thoại Apple iPhone 13 128Gb', 22),
(5, 'Apple iPhone 13 - Green', 22),
(6, 'Apple iPhone 13 Pro Max Clear Case (Ốp lưng iPhone)', 22),
(7, 'Điện thoại_iphone_12 pro 256GB hàng quốc tế mới bảo hành 12 tháng hoàn tiền trong 7 ngày -Mobile St0re', 21),
(8, 'Apple iPhone 14 Pro Max Chính hãng VN/A', 30),
(9, 'Galaxy S21 Ultra 6.1inch 12GB + 512GB sim kép giá rẻ điện thoại sinh viên giá rẻ hỗ trợ 4G / 5G wifi điện thoại COD', 25),
(10, 'Điện thoại Samsung Galaxy A53 5G (8GB/128GB) - Hàng chính hãng', 24),
(11, 'Áo nữ trung niên thêu hoa cotton cao cấp Thiều Hoa B0530', 50),
(12, 'Áo Trung Niên Nữ Phong Cách Thanh Lịch Cho Phụ Nữ Tuổi Trung Niên Thương Hiệu Thiều Hoa K667', 30),
(13, 'Áo sơ mi nữ trung niên, thiết kế trang nhã lịch sự, chất liệu cotton xước mềm mại, thoáng mát Thiều Hoa P0421', 45),
(14, 'Quần thun Linen trung niên nữ Thiều Hoa kiểu dáng trẻ trung P0320', 35),
(15, 'Áo thiết kế họa tiết hoa cho nữ trung niên, điểm nhấn trên eo tinh tế siêu tôn dáng, lịch sự, sang trọng Thiều Hoa L0805', 40),
(16, 'Madam Sotoni - Thời trang trung niên - Đầm trung niên - DVL1402', 50),
(17, 'Madam Sotoni - Thời trang trung niên - Đầm trung niên - DVCB703', 20),
(18, 'Đầm Thiết Kế Mỏng Kiểu Dáng Mới Thời Trang Mùa Hè Dành Cho Phụ Nữ Trung Niên 2022', 30),
(19, 'Giày air force 1 af1 trắng thể thao sneaker nam nữ cổ thấp full box', 40),
(20, 'Dép bánh mì quai ngang nữ hình gấu SƯỜN, dép nữ thời trang đi trong nhà đế nhẹ êm chống trơn trượt', 50),
(21, 'Bộ bàn phím kèm chuột gaming có dây giả cơ tích hợp bật tắt chế độ đèn led tiện lợi dành cho game thủ, văn phòng', 20),
(22, 'Bàn phím giả cơ gaming G21 kèm chuột có dây với đèn Led 7 màu chuyên dùng cho máy tính PC và Laptop', 15),
(23, 'Bao Da Kèm Bàn Phím Có Dây Cho Điện Thoại Di Động/ Ipad/ Máy Tính Bảng Android Kết Nối', 10),
(24, 'Bộ Bàn Phím Kèm Chuột Gaming TF200 Có Dây, Phong Cách Hiện Đại, Ấn Tượng LED Nhiều Màu - Bảo hành', 15),
(25, 'Bàn phím kiêm chuột mini cảm ứng không dây I8 cho Ps4 / Google / Android / Tv Box / chơi game', 25),
(26, 'Bàn phím MIXIE - X7, X7s: đẹp, bấm êm, không tiếng kêu (kết nối có dây) - Bảo hành hãng 12 tháng', 30),
(27, 'Bàn phím có dây Logitech K120 - Bảo hành chính hãng 36 Tháng', 18);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `transport`
--

CREATE TABLE `transport` (
  `sender` int(11) NOT NULL,
  `receiver` int(11) NOT NULL,
  `fee` float NOT NULL,
  `transportType` enum('road','air') NOT NULL,
  `sendDate` datetime NOT NULL,
  `receiveDateEstimation` datetime NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `distance` float NOT NULL,
  `package` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `transport`
--

INSERT INTO `transport` (`sender`, `receiver`, `fee`, `transportType`, `sendDate`, `receiveDateEstimation`, `status`, `distance`, `package`) VALUES
(1, 2, 201200, 'road', '2023-01-01 00:00:00', '2023-01-03 00:00:00', 'Finished', 1000, 1),
(1, 2, 1230000, 'air', '2023-01-03 00:00:00', '2023-01-05 00:00:00', 'Finished', 1000, 2),
(1, 2, 201450, 'road', '2023-01-05 00:00:00', '2023-01-07 00:00:00', 'Finished', 1000, 3),
(1, 2, 1222000, 'air', '2023-01-07 00:00:00', '2023-01-09 00:00:00', 'Finished', 1000, 4),
(1, 2, 201100, 'road', '2023-01-09 00:00:00', '2023-01-11 00:00:00', 'Finished', 1000, 5),
(1, 2, 1222000, 'air', '2023-01-11 00:00:00', '2023-01-13 00:00:00', 'Finished', 1000, 6),
(1, 2, 201050, 'road', '2023-01-13 00:00:00', '2023-01-15 00:00:00', 'Canceled', 1000, 7),
(1, 2, 1230000, 'air', '2023-01-15 00:00:00', '2023-01-17 00:00:00', 'Finished', 1000, 8),
(1, 2, 201250, 'road', '2023-01-17 00:00:00', '2023-01-19 00:00:00', 'Finished', 1000, 9),
(1, 2, 1224000, 'air', '2023-01-19 00:00:00', '2023-01-21 00:00:00', 'On Going', 1000, 10),
(3, 5, 280000, 'air', '2023-01-01 14:47:48', '2023-01-02 14:47:48', 'Finished', 30, 11),
(3, 5, 260000, 'air', '2023-01-03 14:47:48', '2023-01-04 14:47:48', 'Finished', 30, 12),
(3, 5, 275000, 'air', '2023-01-05 14:47:48', '2023-01-06 14:47:48', 'Canceled', 30, 13),
(4, 6, 11750, 'road', '2023-01-05 14:47:48', '2023-01-06 14:47:48', 'Finished', 50, 14),
(4, 6, 12000, 'road', '2023-01-06 14:47:48', '2023-01-07 14:47:48', 'Finished', 50, 15),
(4, 6, 12500, 'road', '2023-01-07 14:47:48', '2023-01-08 14:47:48', 'Finished', 50, 16),
(4, 6, 11000, 'road', '2023-01-09 14:47:48', '2023-01-10 14:47:48', 'Canceled', 50, 17),
(4, 6, 11500, 'road', '2023-01-11 14:47:48', '2023-01-12 14:47:48', 'Finished', 50, 18),
(4, 6, 12000, 'road', '2023-01-12 14:47:48', '2023-01-13 14:47:48', 'Finished', 50, 19),
(4, 6, 12500, 'road', '2023-01-13 14:47:48', '2023-01-14 14:47:48', 'Finished', 50, 20),
(8, 10, 13000, 'road', '2023-01-13 20:30:00', '2023-01-14 14:47:48', 'On Going', 60, 21),
(11, 12, 10750, 'road', '2023-01-13 15:45:00', '2023-01-15 15:45:00', 'On Going', 50, 22),
(11, 12, 10500, 'road', '2023-01-13 15:45:00', '2023-01-15 15:45:00', 'On Going', 50, 23),
(11, 12, 10750, 'road', '2023-01-15 15:45:00', '2023-01-17 15:45:00', 'Finished', 50, 24),
(11, 12, 11250, 'road', '2023-01-17 15:45:00', '2023-01-19 15:45:00', 'On Going', 50, 25),
(11, 12, 11500, 'road', '2023-01-19 15:45:00', '2023-01-21 15:45:00', 'On Going', 50, 26),
(11, 12, 10900, 'road', '2023-01-21 15:45:00', '2023-01-23 15:45:00', 'On Going', 50, 27);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `address` (`address`);

--
-- Chỉ mục cho bảng `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `transport`
--
ALTER TABLE `transport`
  ADD KEY `sender` (`sender`),
  ADD KEY `receiver` (`receiver`),
  ADD KEY `package` (`package`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=0;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=0;

--
-- AUTO_INCREMENT cho bảng `package`
--
ALTER TABLE `package`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=0;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`address`) REFERENCES `address` (`id`);

--
-- Các ràng buộc cho bảng `transport`
--
ALTER TABLE `transport`
  ADD CONSTRAINT `transport_ibfk_1` FOREIGN KEY (`sender`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `transport_ibfk_2` FOREIGN KEY (`receiver`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `transport_ibfk_3` FOREIGN KEY (`package`) REFERENCES `package` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
