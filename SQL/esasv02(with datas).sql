/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50130
Source Host           : localhost:3306
Source Database       : esasv02

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2012-03-30 19:12:59
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `absentees`
-- ----------------------------
DROP TABLE IF EXISTS `absentees`;
CREATE TABLE `absentees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentregno` varchar(20) NOT NULL,
  `examid` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of absentees
-- ----------------------------

-- ----------------------------
-- Table structure for `batches`
-- ----------------------------
DROP TABLE IF EXISTS `batches`;
CREATE TABLE `batches` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `schemeid` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of batches
-- ----------------------------

-- ----------------------------
-- Table structure for `departments`
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments` (
  `id` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of departments
-- ----------------------------

-- ----------------------------
-- Table structure for `examdutystaffs`
-- ----------------------------
DROP TABLE IF EXISTS `examdutystaffs`;
CREATE TABLE `examdutystaffs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staffid` varchar(20) NOT NULL,
  `examid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of examdutystaffs
-- ----------------------------

-- ----------------------------
-- Table structure for `exams`
-- ----------------------------
DROP TABLE IF EXISTS `exams`;
CREATE TABLE `exams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `date` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of exams
-- ----------------------------

-- ----------------------------
-- Table structure for `examsubjectandbatches`
-- ----------------------------
DROP TABLE IF EXISTS `examsubjectandbatches`;
CREATE TABLE `examsubjectandbatches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examid` int(11) NOT NULL,
  `subjectid` int(11) NOT NULL,
  `batchid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of examsubjectandbatches
-- ----------------------------

-- ----------------------------
-- Table structure for `halls`
-- ----------------------------
DROP TABLE IF EXISTS `halls`;
CREATE TABLE `halls` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `noofrow` int(11) NOT NULL,
  `noofcol` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of halls
-- ----------------------------

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `uname` varchar(50) NOT NULL,
  `upass` varchar(50) NOT NULL,
  `uloginname` varchar(50) NOT NULL,
  `utype` varchar(50) NOT NULL,
  `udescription` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('admin', 'admin', '111111', 'admin', 'qewfrasfas');
INSERT INTO `login` VALUES ('qwqawde', '[C@da4b71', 'sdfvdfv', 'staff', 'dsfsdfsdf45646');
INSERT INTO `login` VALUES ('user', 'user', 'asdfasdfasdf', 'staff', 'asfdasd');

-- ----------------------------
-- Table structure for `nonregisteredstudents`
-- ----------------------------
DROP TABLE IF EXISTS `nonregisteredstudents`;
CREATE TABLE `nonregisteredstudents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentregno` varchar(20) NOT NULL,
  `examid` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of nonregisteredstudents
-- ----------------------------

-- ----------------------------
-- Table structure for `schemes`
-- ----------------------------
DROP TABLE IF EXISTS `schemes`;
CREATE TABLE `schemes` (
  `id` varchar(20) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of schemes
-- ----------------------------

-- ----------------------------
-- Table structure for `seatings`
-- ----------------------------
DROP TABLE IF EXISTS `seatings`;
CREATE TABLE `seatings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examid` int(11) NOT NULL,
  `studentregno` varchar(20) NOT NULL,
  `hallname` varchar(20) NOT NULL,
  `seatno` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of seatings
-- ----------------------------

-- ----------------------------
-- Table structure for `selectedexamhalls`
-- ----------------------------
DROP TABLE IF EXISTS `selectedexamhalls`;
CREATE TABLE `selectedexamhalls` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hallname` varchar(20) NOT NULL,
  `examid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of selectedexamhalls
-- ----------------------------

-- ----------------------------
-- Table structure for `staffs`
-- ----------------------------
DROP TABLE IF EXISTS `staffs`;
CREATE TABLE `staffs` (
  `id` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `deptid` varchar(20) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of staffs
-- ----------------------------

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `regno` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `batchid` int(11) NOT NULL,
  `deptid` varchar(20) NOT NULL,
  PRIMARY KEY (`regno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of students
-- ----------------------------

-- ----------------------------
-- Table structure for `subjects`
-- ----------------------------
DROP TABLE IF EXISTS `subjects`;
CREATE TABLE `subjects` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `schemeid` varchar(20) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of subjects
-- ----------------------------
