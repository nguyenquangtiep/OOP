-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 19, 2023 lúc 10:43 AM
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
(2, 'HCM');

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
(2, 'Nguyen Van Receiver', '0987654321', 2, 'receiver');

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
(10, 'Điện thoại Samsung Galaxy A53 5G (8GB/128GB) - Hàng chính hãng', 24);

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
(1, 2, 1000, 'road', '2023-01-01 00:00:00', '2023-01-03 00:00:00', 'Finished', 1000, 1),
(1, 2, 2000, 'air', '2023-01-03 00:00:00', '2023-01-05 00:00:00', 'Finished', 1000, 2),
(1, 2, 3000, 'road', '2023-01-05 00:00:00', '2023-01-07 00:00:00', 'Finished', 1000, 3),
(1, 2, 1000, 'air', '2023-01-07 00:00:00', '2023-01-09 00:00:00', 'Finished', 1000, 4),
(1, 2, 2000, 'road', '2023-01-09 00:00:00', '2023-01-11 00:00:00', 'Finished', 1000, 5),
(1, 2, 3000, 'air', '2023-01-11 00:00:00', '2023-01-13 00:00:00', 'Finished', 1000, 6),
(1, 2, 1000, 'road', '2023-01-13 00:00:00', '2023-01-15 00:00:00', 'Canceled', 1000, 7),
(1, 2, 2000, 'air', '2023-01-15 00:00:00', '2023-01-17 00:00:00', 'Finished', 1000, 8),
(1, 2, 3000, 'road', '2023-01-17 00:00:00', '2023-01-19 00:00:00', 'Finished', 1000, 9),
(1, 2, 1000, 'air', '2023-01-19 00:00:00', '2023-01-21 00:00:00', 'On Going', 1000, 10);

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
