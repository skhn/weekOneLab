
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `week_1_lab`
--
USE `week_1_lab`;

--
-- Drop tables if they already exist
--

DROP TABLE IF EXISTS `stocks`;
-- --------------------------------------------------------

--
-- Table structure for table `Stocks`
--

CREATE TABLE IF NOT EXISTS `stocks` (
  `stockId` INT(11) NOT NULL AUTO_INCREMENT,
  `symbol` VARCHAR(4) NOT NULL,
  `price` DECIMAL(11,2) NOT NULL,
  `volume` INT(11) NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`stockId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--


-- --------------------------------------------------------

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
