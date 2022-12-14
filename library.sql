/*
 Navicat Premium Data Transfer

 Source Server         : librarySys
 Source Server Type    : MySQL
 Source Server Version : 50650 (5.6.50-log)
 Source Host           : 1.15.47.70:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50650 (5.6.50-log)
 File Encoding         : 65001

 Date: 09/12/2022 17:22:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `b_IBSN` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'IBSN',
  `b_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '书名',
  `b_publication_date` date NULL DEFAULT NULL COMMENT '出版日期',
  `b_author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作者',
  `b_price` float(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `b_page_number` int(5) NULL DEFAULT NULL COMMENT '总页数',
  `b_classification` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图书分类',
  `b_publication_status` int(10) NULL DEFAULT NULL COMMENT '出版状态(0:未出版,1:已出版,2:出版中)',
  `b_ordered` int(1) NOT NULL COMMENT '图书显示排序',
  `b_status` int(1) NOT NULL COMMENT '是否启用(0:禁用,1:启用)',
  PRIMARY KEY (`b_IBSN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `l_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `u_card_id` int(11) NOT NULL COMMENT '卡号',
  `l_start_time` datetime NULL DEFAULT NULL COMMENT '起始日期',
  `l_end_time` datetime NULL DEFAULT NULL COMMENT '终止日期',
  `l_type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '日志类型',
  `l_remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志备注',
  PRIMARY KEY (`l_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_card_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '卡号',
  `u_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `u_password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `u_deposit` int(11) NOT NULL COMMENT '已缴纳押金',
  `u_money` float(20, 2) NOT NULL DEFAULT 0.00 COMMENT '卡内余额',
  `u_birthday` date NULL DEFAULT NULL COMMENT '生日',
  `u_identification_number` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号码',
  `u_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `u_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电子邮件',
  `u_address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '住址',
  `u_status` int(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '账户状态(0:封禁,1:正常)',
  `u_identity` int(1) NOT NULL COMMENT '账户权限(0:用户,1:超级管理员)',
  PRIMARY KEY (`u_card_id`) USING BTREE,
  UNIQUE INDEX `邮箱不可重复`(`u_email`) USING BTREE,
  UNIQUE INDEX `身份证号不可重复`(`u_identification_number`) USING BTREE,
  UNIQUE INDEX `手机号不可重复`(`u_phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000003 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1000000, '摩尔', '123321', 100, 162569.00, '2002-07-22', '340000000000000001', '1582616876', 'me@mole9630.top', NULL, 1, 1);
INSERT INTO `user` VALUES (1000001, '王小北', '130966', 0, 0.00, '2002-11-17', '340000000000000002', '2012130966', '2012130966@qq.com', '河南省永城市', 1, 0);
INSERT INTO `user` VALUES (1000002, '辛帅豪', '021205', 0, 0.00, '2003-01-01', '340000000000000003', '457731376', '457731376@qq.com', '安徽省阜阳市', 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
