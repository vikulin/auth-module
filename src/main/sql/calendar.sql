/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : calendar

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2012-03-22 20:55:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ID` bigint(11) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN', '2012-03-22 19:50:33');
INSERT INTO `role` VALUES ('2', 'ROLE_USER', '2012-03-22 20:38:35');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(15) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USERNAME_UNIQUE` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '$2a$10$MIu08ioyhEEfFNogmvgplu0JILl90RqJYPBLnZ6Xxcp4ZsJ/ueDKW', '2012-03-22 19:51:44');
INSERT INTO `user` VALUES ('2', 'user', '$2a$10$MIu08ioyhEEfFNogmvgplu0JILl90RqJYPBLnZ6Xxcp4ZsJ/ueDKW', '2012-03-22 20:39:07');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(11) NOT NULL,
  `ROLE_ID` bigint(11) NOT NULL,
  KEY `ROLE_FK` (`ROLE_ID`),
  KEY `USER_FK` (`USER_ID`),
  PRIMARY KEY (`ID`),
  CONSTRAINT `USER_FK` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`),
  CONSTRAINT `ROLE_FK` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
