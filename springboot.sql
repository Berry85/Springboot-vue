/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3316
 Source Server Type    : MariaDB
 Source Server Version : 100135
 Source Host           : localhost:3316
 Source Schema         : springboot

 Target Server Type    : MariaDB
 Target Server Version : 100135
 File Encoding         : 65001

 Date: 30/11/2019 14:47:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `area` double(255, 0) NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `UploadDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `lid`(`lid`) USING BTREE,
  CONSTRAINT `lid` FOREIGN KEY (`lid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES (1, '集美区华侨大学西街A栋', '已出租', 20, 500.00, '2019-11-25 00:00:00', NULL);
INSERT INTO `house` VALUES (7, '华侨大学', NULL, 20, 400.00, NULL, NULL);
INSERT INTO `house` VALUES (18, '集美大学', NULL, 20, 400.00, NULL, 10);

-- ----------------------------
-- Table structure for meet
-- ----------------------------
DROP TABLE IF EXISTS `meet`;
CREATE TABLE `meet`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) NULL DEFAULT NULL,
  `lid` int(11) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `enable` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tenant_meet`(`tid`) USING BTREE,
  INDEX `landlord_meet`(`lid`) USING BTREE,
  CONSTRAINT `landlord_meet` FOREIGN KEY (`lid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tenant_meet` FOREIGN KEY (`tid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `iconCls` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `keepAlive` tinyint(1) NULL DEFAULT NULL,
  `requireAuth` tinyint(1) NULL DEFAULT 1,
  `enable` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '/', NULL, NULL, NULL, '所有', NULL, NULL, NULL, '1');
INSERT INTO `menu` VALUES (2, '/', '/home', 'Home', 1, '个人资料', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (3, '/', '/home', 'Home', 1, '租屋', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (4, '/', '/home', 'Home', 1, '会面', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (5, '/', '/home', 'Home', 1, '用户', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (6, '/info/**', '/info', 'Info', 2, '个人信息', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (8, '/house/ownerlist/**', '/house/ownerlist', 'OwnerList', 3, '拥有房屋', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (9, '/house/insert/**', '/house/insert', 'HouseInsert', 3, '新增房屋', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (10, '/house/list/**', '/house/list', 'HouseList', 3, '房屋列表', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (11, '/meet/apply/**', '/meet/apply', 'MeetApply', 4, '申请会面', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (12, '/meet/applysource/**', '/meet/applysource', 'MeetApplySource', 4, '查看通过申请', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (13, '/meet/applied/**', '/meet/applie', 'MeetApplied', 4, '查看未通过申请', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (14, '/meet/applying/**', '/meet/applying', 'MeetApplying', 4, '查看正在申请的会面', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (15, '/meet/Landlord_apply/**', '/meet/Landlord_apply', 'MeetLandlord', 4, '查看会面信息', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (16, '/meet/ApplyEnable/**', '/meet/ApplyEnable', 'MeetApplyEnable', 4, '查看需批准的申请', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (17, '/meet/AllApply/**', '/meet/AllApply', 'MeetAllApply', 4, '查看所有申请', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (18, '/sys/landlord/**', '/sys/landlord', 'SysLandlord', 5, '房东列表', NULL, NULL, 1, '1');
INSERT INTO `menu` VALUES (19, '/sys/tenant/**', '/sys/tenant', 'SysTenant', 5, '租客列表', NULL, NULL, 1, '1');

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `mid` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `rid` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES (1, 6, 3);
INSERT INTO `menu_role` VALUES (28, 6, 4);
INSERT INTO `menu_role` VALUES (29, 8, 4);
INSERT INTO `menu_role` VALUES (30, 9, 4);
INSERT INTO `menu_role` VALUES (31, 10, 3);
INSERT INTO `menu_role` VALUES (32, 10, 4);
INSERT INTO `menu_role` VALUES (33, 10, 1);
INSERT INTO `menu_role` VALUES (34, 10, 2);
INSERT INTO `menu_role` VALUES (35, 11, 3);
INSERT INTO `menu_role` VALUES (36, 12, 3);
INSERT INTO `menu_role` VALUES (37, 13, 3);
INSERT INTO `menu_role` VALUES (38, 14, 3);
INSERT INTO `menu_role` VALUES (39, 15, 4);
INSERT INTO `menu_role` VALUES (40, 16, 1);
INSERT INTO `menu_role` VALUES (41, 16, 2);
INSERT INTO `menu_role` VALUES (42, 17, 1);
INSERT INTO `menu_role` VALUES (43, 17, 2);
INSERT INTO `menu_role` VALUES (44, 18, 1);
INSERT INTO `menu_role` VALUES (45, 18, 2);
INSERT INTO `menu_role` VALUES (46, 19, 1);
INSERT INTO `menu_role` VALUES (47, 19, 2);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `name_zh` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_admin', '系统管理员');
INSERT INTO `role` VALUES (2, 'ROLE_dba', '数据库管理员');
INSERT INTO `role` VALUES (3, 'ROLE_tenant', '房客');
INSERT INTO `role` VALUES (4, 'ROLE_landlord', '房东');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `phone` int(255) NULL DEFAULT NULL,
  `enable` tinyint(1) NULL DEFAULT 1,
  `locked` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', '$2a$2a$10$yKbvsbp.mwbBmon34q3k/uZdXWbsh/8tDkChKqAbq/3xm7xC2VCTi', NULL, NULL, 1, 0);
INSERT INTO `user` VALUES (2, 'admin', '$2a$10$bvW.9j56BG0XPAA8icJQhuU4qUS7zT.lCayiqBry45HqJMajVV2JC', '', NULL, 1, 0);
INSERT INTO `user` VALUES (3, 'sang', '$2a$10$UCu/YkcMgyvbumqM8unEeOSpDtCVAmCG0pncWS6CxcYSIGpQCcBtm', '', NULL, 1, 0);
INSERT INTO `user` VALUES (5, 'test2', '$2a$10$ubO7zmAQ.yfGZspcRc62a.4T0G0DeWhjwK2CSWLyEqJSsTCdLtpJu', NULL, NULL, 1, 0);
INSERT INTO `user` VALUES (8, 'TenantTest', '$2a$10$KUW4AS4hOKjl7KRoGCZHvOm.szK9Y04LSRr7pUqLavxiNVMDaHD0u', NULL, NULL, 1, 0);
INSERT INTO `user` VALUES (9, 'land', '$2a$10$sbk.NBF9Uuysg/BrCkbT/OoGpM8gR0fNQ7tYS0F1jqnmwEjUEJvxy', NULL, NULL, 1, 0);
INSERT INTO `user` VALUES (10, '13', '$2a$10$omxVFZgyGMpqerihbKaSS.qu5MEUMUT15Ke7uB4gns6bSbr9TmgeK', NULL, NULL, 1, 0);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`rid`) USING BTREE,
  INDEX `user_id`(`uid`) USING BTREE,
  CONSTRAINT `role_id` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 2, 1);
INSERT INTO `user_role` VALUES (2, 3, 3);
INSERT INTO `user_role` VALUES (3, 8, 3);
INSERT INTO `user_role` VALUES (4, 9, 4);
INSERT INTO `user_role` VALUES (5, 10, 4);

SET FOREIGN_KEY_CHECKS = 1;
