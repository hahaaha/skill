/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : skill

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 10/01/2019 22:49:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for allskill
-- ----------------------------
DROP TABLE IF EXISTS `allskill`;
CREATE TABLE `allskill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'skill id',
  `pre_id` int(11) NOT NULL COMMENT '上级技能的id',
  `skill_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '技能名',
  `max_grade` int(11) NULL DEFAULT NULL COMMENT '技能最高等级',
  `status` bigint(1) NOT NULL COMMENT '技能状态0删除1正常',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of allskill
-- ----------------------------
INSERT INTO `allskill` VALUES (1, 0, NULL, 0, 0, '2019-01-05 19:06:38', '2019-01-05 19:06:38');
INSERT INTO `allskill` VALUES (2, 0, NULL, 0, 0, '2019-01-05 19:07:08', '2019-01-05 19:07:08');
INSERT INTO `allskill` VALUES (3, 0, NULL, 0, 0, '2019-01-05 19:11:37', '2019-01-05 19:11:37');
INSERT INTO `allskill` VALUES (4, 0, NULL, 0, 0, '2019-01-05 19:13:56', '2019-01-05 19:13:56');
INSERT INTO `allskill` VALUES (5, 0, NULL, 0, 0, '2019-01-05 19:16:09', '2019-01-05 19:16:09');
INSERT INTO `allskill` VALUES (6, 0, NULL, 0, 0, '2019-01-05 19:20:19', '2019-01-05 19:20:19');
INSERT INTO `allskill` VALUES (7, 0, NULL, 0, 0, '2019-01-05 19:20:27', '2019-01-05 19:20:27');
INSERT INTO `allskill` VALUES (9, 0, 'sdfdxcc', 0, 0, '2019-01-05 19:27:10', '2019-01-05 19:27:10');
INSERT INTO `allskill` VALUES (10, 0, NULL, 0, 0, '2019-01-05 19:31:33', '2019-01-05 19:31:33');
INSERT INTO `allskill` VALUES (11, 0, 'sdfdxcc', 0, 0, '2019-01-05 19:31:40', '2019-01-05 19:31:40');
INSERT INTO `allskill` VALUES (12, 0, 'sdfdxcc', 0, 0, NULL, NULL);
INSERT INTO `allskill` VALUES (13, 0, 'sdfdxcc', 0, 0, NULL, NULL);
INSERT INTO `allskill` VALUES (14, 0, 'sdfdxccv', 0, 0, NULL, NULL);
INSERT INTO `allskill` VALUES (15, 0, 'ddds', 0, 0, NULL, NULL);
INSERT INTO `allskill` VALUES (16, 0, 'dddsxxx', 0, 0, NULL, NULL);
INSERT INTO `allskill` VALUES (17, 0, 'dddsxxzx', 0, 0, NULL, NULL);
INSERT INTO `allskill` VALUES (19, 0, '吧哦哦', 3, 0, '2019-01-06 14:11:55', '2019-01-06 14:11:55');
INSERT INTO `allskill` VALUES (20, 19, 'ceshi', 3, 0, '2019-01-06 16:59:04', '2019-01-06 16:59:04');
INSERT INTO `allskill` VALUES (21, 19, '神奇宝贝', 3, 1, '2019-01-06 17:15:27', '2019-01-06 17:15:27');
INSERT INTO `allskill` VALUES (22, 19, '神奇宝贝1', 3, 1, '2019-01-06 17:15:32', '2019-01-06 17:15:32');
INSERT INTO `allskill` VALUES (23, 19, '神奇宝贝12', 3, 1, '2019-01-06 17:15:34', '2019-01-06 17:15:34');
INSERT INTO `allskill` VALUES (24, 19, '神奇宝贝123', 3, 1, '2019-01-06 17:15:35', '2019-01-06 17:15:35');
INSERT INTO `allskill` VALUES (25, 24, '半边走', 3, 1, '2019-01-08 22:04:47', '2019-01-08 22:04:47');

-- ----------------------------
-- Table structure for skill_user
-- ----------------------------
DROP TABLE IF EXISTS `skill_user`;
CREATE TABLE `skill_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user table id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码，md5加密',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_name_unique`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
