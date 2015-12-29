/*
Navicat MySQL Data Transfer

Source Server         : haoqi
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : forly

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-12-29 17:35:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_funny
-- ----------------------------
DROP TABLE IF EXISTS `t_funny`;
CREATE TABLE `t_funny` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `publisher` int(11) DEFAULT NULL,
  `publish_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `praise_count` int(11) DEFAULT NULL,
  `store_count` int(11) DEFAULT NULL,
  `category_type` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7930 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `lat` varchar(255) DEFAULT NULL,
  `lng` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
