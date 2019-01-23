/*
 Navicat Premium Data Transfer

 Source Server         : one
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : 127.0.0.1:8889
 Source Schema         : skill

 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : 65001

 Date: 23/01/2019 12:23:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for allskill
-- ----------------------------
DROP TABLE IF EXISTS `allskill`;
CREATE TABLE `allskill` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'skill id',
  `pre_id` int(11) NOT NULL COMMENT '上级技能的id',
  `skill_name` varchar(50) DEFAULT NULL COMMENT '技能名',
  `image_url` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `max_grade` int(11) DEFAULT NULL COMMENT '技能最高等级',
  `status` bigint(1) NOT NULL COMMENT '技能状态0删除1正常',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of allskill
-- ----------------------------
BEGIN;
INSERT INTO `allskill` VALUES (1, 0, NULL, NULL, 0, 0, '2019-01-05 19:06:38', '2019-01-05 19:06:38');
INSERT INTO `allskill` VALUES (2, 0, NULL, NULL, 0, 0, '2019-01-05 19:07:08', '2019-01-05 19:07:08');
INSERT INTO `allskill` VALUES (3, 0, NULL, NULL, 0, 0, '2019-01-05 19:11:37', '2019-01-05 19:11:37');
INSERT INTO `allskill` VALUES (4, 0, NULL, NULL, 0, 0, '2019-01-05 19:13:56', '2019-01-05 19:13:56');
INSERT INTO `allskill` VALUES (5, 0, NULL, NULL, 0, 0, '2019-01-05 19:16:09', '2019-01-05 19:16:09');
INSERT INTO `allskill` VALUES (6, 0, NULL, NULL, 0, 0, '2019-01-05 19:20:19', '2019-01-05 19:20:19');
INSERT INTO `allskill` VALUES (7, 0, NULL, NULL, 0, 0, '2019-01-05 19:20:27', '2019-01-05 19:20:27');
INSERT INTO `allskill` VALUES (9, 0, 'sdfdxcc', NULL, 0, 0, '2019-01-05 19:27:10', '2019-01-05 19:27:10');
INSERT INTO `allskill` VALUES (10, 0, NULL, NULL, 0, 0, '2019-01-05 19:31:33', '2019-01-05 19:31:33');
INSERT INTO `allskill` VALUES (11, 0, 'sdfdxcc', NULL, 0, 0, '2019-01-05 19:31:40', '2019-01-05 19:31:40');
INSERT INTO `allskill` VALUES (12, 0, 'sdfdxcc', NULL, 0, 0, NULL, NULL);
INSERT INTO `allskill` VALUES (13, 0, 'sdfdxcc', NULL, 0, 0, NULL, NULL);
INSERT INTO `allskill` VALUES (14, 0, 'sdfdxccv', NULL, 0, 0, NULL, NULL);
INSERT INTO `allskill` VALUES (15, 0, 'ddds', NULL, 0, 0, NULL, NULL);
INSERT INTO `allskill` VALUES (16, 0, 'dddsxxx', NULL, 0, 0, NULL, NULL);
INSERT INTO `allskill` VALUES (17, 0, 'dddsxxzx', NULL, 0, 0, NULL, NULL);
INSERT INTO `allskill` VALUES (19, 0, '吧哦哦', NULL, 3, 0, '2019-01-06 14:11:55', '2019-01-06 14:11:55');
INSERT INTO `allskill` VALUES (20, 19, 'ceshi', NULL, 3, 0, '2019-01-06 16:59:04', '2019-01-06 16:59:04');
INSERT INTO `allskill` VALUES (21, 19, '神奇宝贝', NULL, 3, 1, '2019-01-06 17:15:27', '2019-01-06 17:15:27');
INSERT INTO `allskill` VALUES (22, 19, '神奇宝贝1', NULL, 3, 1, '2019-01-06 17:15:32', '2019-01-06 17:15:32');
INSERT INTO `allskill` VALUES (23, 19, '神奇宝贝12', NULL, 3, 1, '2019-01-06 17:15:34', '2019-01-06 17:15:34');
INSERT INTO `allskill` VALUES (24, 19, '神奇宝贝123', NULL, 3, 1, '2019-01-06 17:15:35', '2019-01-06 17:15:35');
INSERT INTO `allskill` VALUES (25, 24, '半边走', NULL, 3, 1, '2019-01-08 22:04:47', '2019-01-08 22:04:47');
INSERT INTO `allskill` VALUES (26, 25, '半此次', NULL, 3, 1, '2019-01-13 10:44:22', '2019-01-13 10:44:22');
INSERT INTO `allskill` VALUES (27, 25, '擦擦擦', NULL, 3, 1, '2019-01-13 10:44:41', '2019-01-13 10:44:41');
COMMIT;

-- ----------------------------
-- Table structure for skill_user
-- ----------------------------
DROP TABLE IF EXISTS `skill_user`;
CREATE TABLE `skill_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user table id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码，md5加密',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT 'username auto generate',
  `status` bigint(1) NOT NULL COMMENT '用户的状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'hei', 0, '2019-01-16 20:55:22', '2019-01-16 20:55:22');
INSERT INTO `user` VALUES (2, 'AA266B1F80310ECA9F34A3668CC51DBA', 0, '2019-01-16 20:55:30', '2019-01-16 20:55:30');
INSERT INTO `user` VALUES (3, '4F3004AD65A8B7C1DA1973B012B349EC', 0, '2019-01-16 22:01:25', '2019-01-16 22:02:04');
INSERT INTO `user` VALUES (4, 'DBB20C5765B53D0F4FFE926B99215794', 0, '2019-01-16 22:03:00', '2019-01-16 22:04:58');
INSERT INTO `user` VALUES (5, '414F61B5C437652F0729649860960E48', 0, '2019-01-19 14:29:29', '2019-01-19 14:59:32');
INSERT INTO `user` VALUES (6, '814C7F37696E4C4196C6446ABFD2FE87', 0, '2019-01-19 15:00:38', '2019-01-19 15:05:47');
INSERT INTO `user` VALUES (7, '957B694C8433E5063D75FB86A731A64C', 0, '2019-01-19 15:07:18', '2019-01-19 15:07:44');
INSERT INTO `user` VALUES (8, '0E7346B541E18F8E1F31C4B0156776E2', 0, '2019-01-19 15:10:29', '2019-01-19 15:10:29');
INSERT INTO `user` VALUES (9, '1F49F85A1A22D0298971D309017F9817', 0, '2019-01-19 15:33:46', '2019-01-19 15:33:46');
INSERT INTO `user` VALUES (10, 'A25A07FC93C86C6C9A7A375E5834CCCC', 0, '2019-01-19 15:36:53', '2019-01-19 15:36:53');
INSERT INTO `user` VALUES (11, '76EA4DA10B9FA4CC24007EC0C7F4F30D', 0, '2019-01-19 19:26:08', '2019-01-19 19:26:08');
INSERT INTO `user` VALUES (12, '284D33FB1BE54D34B80AA31E668C4E6C', 0, '2019-01-19 19:27:49', '2019-01-19 19:30:47');
INSERT INTO `user` VALUES (13, 'CF2B4A93E0C8C4DC46EFCC7D12B917CB', 0, '2019-01-19 19:33:57', '2019-01-19 19:34:40');
INSERT INTO `user` VALUES (14, '1D232EC326555E1FDE35CE91DA1C3185', 0, '2019-01-19 19:36:31', '2019-01-19 19:36:31');
INSERT INTO `user` VALUES (15, '354F324DFFF8295A1CFD8D3737D978A6', 0, '2019-01-19 19:37:16', '2019-01-19 19:37:16');
INSERT INTO `user` VALUES (16, '81A07CD0FC6FE6B514DEA9E8BE946FDF', 0, '2019-01-19 19:43:16', '2019-01-19 19:43:16');
INSERT INTO `user` VALUES (17, 'F6F74479F71A711522AC398F9098148B', 0, '2019-01-19 19:47:24', '2019-01-19 19:47:24');
INSERT INTO `user` VALUES (18, '2AD0DDD9248401B78F7B91BC0BFB02DC', 0, '2019-01-19 19:49:33', '2019-01-19 19:49:33');
INSERT INTO `user` VALUES (19, '7910B4FC5EC64989FC48318804B2A3EB', 0, '2019-01-19 19:58:04', '2019-01-19 19:58:04');
INSERT INTO `user` VALUES (20, '6C86BC6727C0E95AD7A9ED701C8CE3E9', 0, '2019-01-19 20:00:18', '2019-01-19 20:00:18');
INSERT INTO `user` VALUES (21, '02284AFC7130BD9B47A6BD23890DE5A5', 0, '2019-01-19 20:02:58', '2019-01-19 20:02:58');
INSERT INTO `user` VALUES (22, 'A1C3CB4F7BB5E75A28640A969FEFEFAF', 0, '2019-01-19 21:01:26', '2019-01-19 21:01:26');
INSERT INTO `user` VALUES (23, '77844A14E99A7AE6B2412F0E6AB8DE7B', 0, '2019-01-19 21:04:41', '2019-01-19 21:04:41');
INSERT INTO `user` VALUES (24, 'D81B4931CDBE238AA69FF392D6F861B9', 0, '2019-01-19 21:07:26', '2019-01-19 21:07:26');
INSERT INTO `user` VALUES (25, '773134278C25B8112B91E7B44675413D', 0, '2019-01-19 21:13:16', '2019-01-19 21:13:16');
INSERT INTO `user` VALUES (26, 'F78F735BCA12CCC108721376D611DFC7', 0, '2019-01-19 21:26:31', '2019-01-19 21:26:31');
INSERT INTO `user` VALUES (27, '2231AAC033DC6219EFD0F2B5E0EB5520', 0, '2019-01-20 21:35:27', '2019-01-20 21:35:27');
COMMIT;

-- ----------------------------
-- Table structure for user_skill
-- ----------------------------
DROP TABLE IF EXISTS `user_skill`;
CREATE TABLE `user_skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'skillByUser表id',
  `user_id` int(11) NOT NULL COMMENT '技能的所属者id',
  `skill_id` int(11) NOT NULL COMMENT '技能id',
  `grade` int(11) DEFAULT '0' COMMENT '技能的等级，默认为0',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_skill
-- ----------------------------
BEGIN;
INSERT INTO `user_skill` VALUES (1, 18, 19, 1, '2019-01-19 19:49:40', '2019-01-19 19:49:40');
INSERT INTO `user_skill` VALUES (2, 19, 19, 1, '2019-01-19 19:58:07', '2019-01-19 19:58:07');
INSERT INTO `user_skill` VALUES (3, 20, 19, 1, '2019-01-19 20:00:22', '2019-01-19 20:00:22');
INSERT INTO `user_skill` VALUES (4, 21, 19, 1, '2019-01-19 20:03:04', '2019-01-19 20:03:04');
INSERT INTO `user_skill` VALUES (5, 22, 19, 1, '2019-01-19 21:01:31', '2019-01-19 21:01:31');
INSERT INTO `user_skill` VALUES (6, 23, 19, 2, '2019-01-19 21:04:45', '2019-01-19 21:04:45');
INSERT INTO `user_skill` VALUES (7, 24, 19, 1, '2019-01-19 21:07:31', '2019-01-19 21:07:31');
INSERT INTO `user_skill` VALUES (8, 25, 19, 1, '2019-01-19 21:13:21', '2019-01-19 21:13:21');
INSERT INTO `user_skill` VALUES (9, 26, 19, 4, '2019-01-19 21:26:34', '2019-01-19 21:26:34');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
