/*
Navicat MySQL Data Transfer

Source Server         : sa
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : ceptp

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-01-09 15:53:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ceptp_dic_privilege
-- ----------------------------
DROP TABLE IF EXISTS `ceptp_dic_privilege`;
CREATE TABLE `ceptp_dic_privilege` (
  `privilege_id` int(4) NOT NULL AUTO_INCREMENT,
  `privilege_name` varchar(50) NOT NULL,
  PRIMARY KEY (`privilege_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ceptp_dic_privilege
-- ----------------------------
INSERT INTO `ceptp_dic_privilege` VALUES ('1', 'qq');
INSERT INTO `ceptp_dic_privilege` VALUES ('2', 'ee');
INSERT INTO `ceptp_dic_privilege` VALUES ('3', 'rr');
INSERT INTO `ceptp_dic_privilege` VALUES ('4', 'hh');

-- ----------------------------
-- Table structure for ceptp_role
-- ----------------------------
DROP TABLE IF EXISTS `ceptp_role`;
CREATE TABLE `ceptp_role` (
  `role_id` varchar(20) NOT NULL,
  `role_name` varchar(20) NOT NULL,
  `parent_role_id` varchar(20) NOT NULL,
  `delete_flg` bit(1) NOT NULL,
  `create_user` varchar(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_user` varchar(20) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`role_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ceptp_role
-- ----------------------------
INSERT INTO `ceptp_role` VALUES ('A', 'admin', '', '\0', 'admin', '2018-01-04 14:22:44', 'admin', '2018-01-04 14:22:51');
INSERT INTO `ceptp_role` VALUES ('AA', 'hello', '', '\0', 'A', '2018-01-04 14:29:32', 'A', '2018-01-04 14:29:32');
INSERT INTO `ceptp_role` VALUES ('AB', 'hello', '', '\0', 'A', '2018-01-04 14:30:28', 'A', '2018-01-04 14:30:28');
INSERT INTO `ceptp_role` VALUES ('ABA', 'hello', '', '\0', 'AB', '2018-01-04 14:31:26', 'AB', '2018-01-04 14:31:26');
INSERT INTO `ceptp_role` VALUES ('ABB', 'hello', '', '\0', 'AB', '2018-01-04 14:31:46', 'AB', '2018-01-04 14:31:46');
INSERT INTO `ceptp_role` VALUES ('AC', 'hello', '', '\0', 'A', '2018-01-04 14:31:03', 'A', '2018-01-04 14:31:03');
INSERT INTO `ceptp_role` VALUES ('ADA', 'hello', '', '\0', 'AD', '2018-01-08 22:32:49', 'AD', '2018-01-08 22:32:49');
INSERT INTO `ceptp_role` VALUES ('ADB', 'hello', '', '\0', 'AD', '2018-01-08 22:55:48', 'AD', '2018-01-08 22:55:48');
INSERT INTO `ceptp_role` VALUES ('ADC', 'hello', '', '\0', 'AD', '2018-01-08 22:56:52', 'AD', '2018-01-08 22:56:52');
INSERT INTO `ceptp_role` VALUES ('CA', 'hello', 'C', '\0', '152056138', '2018-01-09 15:35:50', '152056138', '2018-01-09 15:35:50');
INSERT INTO `ceptp_role` VALUES ('CB', 'hello', 'C', '\0', '152056138', '2018-01-09 15:49:34', '152056138', '2018-01-09 15:49:34');

-- ----------------------------
-- Table structure for ceptp_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `ceptp_role_privilege`;
CREATE TABLE `ceptp_role_privilege` (
  `role_id` varchar(20) NOT NULL,
  `privilege_id` int(4) NOT NULL,
  `create_user` varchar(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_user` varchar(20) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`role_id`,`privilege_id`),
  KEY `privilege_id` (`privilege_id`) USING BTREE,
  CONSTRAINT `privilege_id` FOREIGN KEY (`privilege_id`) REFERENCES `ceptp_dic_privilege` (`privilege_id`),
  CONSTRAINT `roleId` FOREIGN KEY (`role_id`) REFERENCES `ceptp_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ceptp_role_privilege
-- ----------------------------
INSERT INTO `ceptp_role_privilege` VALUES ('AA', '1', 'A', '2018-01-04 14:29:32', 'A', '2018-01-04 14:29:32');
INSERT INTO `ceptp_role_privilege` VALUES ('AA', '2', 'A', '2018-01-05 12:03:50', 'A', '2018-01-05 12:03:50');
INSERT INTO `ceptp_role_privilege` VALUES ('AA', '3', 'A', '2018-01-04 14:29:32', 'A', '2018-01-04 14:29:32');
INSERT INTO `ceptp_role_privilege` VALUES ('AB', '1', 'A', '2018-01-04 14:30:28', 'A', '2018-01-04 14:30:28');
INSERT INTO `ceptp_role_privilege` VALUES ('AB', '2', 'A', '2018-01-04 14:30:28', 'A', '2018-01-04 14:30:28');
INSERT INTO `ceptp_role_privilege` VALUES ('AB', '3', 'A', '2018-01-04 14:30:28', 'A', '2018-01-04 14:30:28');
INSERT INTO `ceptp_role_privilege` VALUES ('ABA', '1', 'AB', '2018-01-04 14:31:26', 'AB', '2018-01-04 14:31:26');
INSERT INTO `ceptp_role_privilege` VALUES ('ABB', '1', 'AB', '2018-01-04 14:31:46', 'AB', '2018-01-04 14:31:46');
INSERT INTO `ceptp_role_privilege` VALUES ('AC', '1', 'A', '2018-01-04 14:31:03', 'A', '2018-01-04 14:31:03');
INSERT INTO `ceptp_role_privilege` VALUES ('Ac', '2', 'A', '2018-01-05 19:56:21', 'A', '2018-01-05 19:56:21');
INSERT INTO `ceptp_role_privilege` VALUES ('ADA', '1', 'AD', '2018-01-08 22:32:49', 'AD', '2018-01-08 22:32:49');
INSERT INTO `ceptp_role_privilege` VALUES ('ADB', '1', 'AD', '2018-01-08 22:55:49', 'AD', '2018-01-08 22:55:49');
INSERT INTO `ceptp_role_privilege` VALUES ('ADC', '1', 'AD', '2018-01-08 22:56:52', 'AD', '2018-01-08 22:56:52');
INSERT INTO `ceptp_role_privilege` VALUES ('CA', '1', '152056138', '2018-01-09 15:35:50', '152056138', '2018-01-09 15:35:50');
INSERT INTO `ceptp_role_privilege` VALUES ('CB', '1', '152056138', '2018-01-09 15:49:34', '152056138', '2018-01-09 15:49:34');

-- ----------------------------
-- Table structure for ceptp_role_user
-- ----------------------------
DROP TABLE IF EXISTS `ceptp_role_user`;
CREATE TABLE `ceptp_role_user` (
  `role_id` varchar(20) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `create_user` varchar(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_user` varchar(20) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `ceptp_role` (`role_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `ceptp_staff` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ceptp_role_user
-- ----------------------------

-- ----------------------------
-- Table structure for ceptp_staff
-- ----------------------------
DROP TABLE IF EXISTS `ceptp_staff`;
CREATE TABLE `ceptp_staff` (
  `staff_id` varchar(20) NOT NULL,
  `staff_name` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sex` bit(1) NOT NULL,
  `degree_id` int(4) DEFAULT NULL,
  `pro_title_id` int(4) DEFAULT NULL,
  `college_id` int(4) NOT NULL,
  `dept_id` int(4) NOT NULL,
  `pro_id` int(4) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `is_dimission` bit(1) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `is_firstLogin` bit(1) DEFAULT NULL,
  `delete_flg` bit(1) NOT NULL,
  `create_user` varchar(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_user` varchar(20) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ceptp_staff
-- ----------------------------

-- ----------------------------
-- Table structure for ceptp_student
-- ----------------------------
DROP TABLE IF EXISTS `ceptp_student`;
CREATE TABLE `ceptp_student` (
  `stu_id` varchar(20) NOT NULL,
  `stu_name` varchar(20) NOT NULL,
  `sex` bit(1) NOT NULL,
  `password` varchar(50) NOT NULL,
  `class_id` varchar(9) NOT NULL,
  `pro_id` int(4) NOT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `role_id` varchar(20) DEFAULT NULL,
  `college_id` int(4) NOT NULL,
  `dept_id` int(4) NOT NULL,
  `delete_flg` bit(1) NOT NULL,
  `create_user` varchar(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_user` varchar(20) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ceptp_student
-- ----------------------------
