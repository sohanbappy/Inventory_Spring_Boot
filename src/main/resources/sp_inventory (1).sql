-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 20, 2019 at 07:22 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sp_inventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_tb`
--

CREATE TABLE `admin_tb` (
  `id` int(11) NOT NULL,
  `uname` varchar(200) NOT NULL,
  `pass` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `category_tb`
--

CREATE TABLE `category_tb` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `org_id` varchar(250) NOT NULL,
  `creation_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category_tb`
--

INSERT INTO `category_tb` (`id`, `name`, `org_id`, `creation_date`) VALUES
(1, 'Pen', '101', '2019-05-13'),
(2, 'Notebook', '101', '2019-05-14');

-- --------------------------------------------------------

--
-- Table structure for table `item_tb`
--

CREATE TABLE `item_tb` (
  `id` int(11) NOT NULL,
  `cat_id` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `quantity` varchar(200) NOT NULL,
  `price` varchar(200) NOT NULL,
  `creation_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_tb`
--

INSERT INTO `item_tb` (`id`, `cat_id`, `name`, `quantity`, `price`, `creation_date`) VALUES
(1, '1', 'dsfdfh', '40', '6', '2019-05-24'),
(5, '1', 'Stand', '50', '25', '2019-05-26');

-- --------------------------------------------------------

--
-- Table structure for table `org_tb`
--

CREATE TABLE `org_tb` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `phone` varchar(200) NOT NULL,
  `address` varchar(250) NOT NULL,
  `uname` varchar(200) NOT NULL,
  `pass` varchar(200) NOT NULL,
  `creation_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `org_tb`
--

INSERT INTO `org_tb` (`id`, `name`, `phone`, `address`, `uname`, `pass`, `creation_date`) VALUES
(5, 'RST gr', '01766334885', 'dhaka', 'aaaaaaaa', '22222', '2019-05-21');

-- --------------------------------------------------------

--
-- Table structure for table `sell_tb`
--

CREATE TABLE `sell_tb` (
  `id` int(11) NOT NULL,
  `inv_no` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `item_id` varchar(200) NOT NULL,
  `quantity` varchar(200) NOT NULL,
  `sub_total` varchar(200) NOT NULL,
  `creation_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sell_tb`
--

INSERT INTO `sell_tb` (`id`, `inv_no`, `name`, `item_id`, `quantity`, `sub_total`, `creation_date`) VALUES
(1, 'D-112121', 'Rayhan', '5', '2', '50.0', '2019-05-26');

-- --------------------------------------------------------

--
-- Table structure for table `settle_tb`
--

CREATE TABLE `settle_tb` (
  `id` int(11) NOT NULL,
  `inv_no` varchar(200) NOT NULL,
  `price` varchar(200) NOT NULL,
  `settle_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_tb`
--
ALTER TABLE `admin_tb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category_tb`
--
ALTER TABLE `category_tb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item_tb`
--
ALTER TABLE `item_tb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `org_tb`
--
ALTER TABLE `org_tb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sell_tb`
--
ALTER TABLE `sell_tb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `settle_tb`
--
ALTER TABLE `settle_tb`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_tb`
--
ALTER TABLE `admin_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `category_tb`
--
ALTER TABLE `category_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `item_tb`
--
ALTER TABLE `item_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `org_tb`
--
ALTER TABLE `org_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sell_tb`
--
ALTER TABLE `sell_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `settle_tb`
--
ALTER TABLE `settle_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
