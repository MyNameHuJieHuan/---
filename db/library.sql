/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 20/08/2022 16:02:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book_address
-- ----------------------------
DROP TABLE IF EXISTS `book_address`;
CREATE TABLE `book_address`  (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '书籍存放地址ID',
  `library_id` bigint(11) NULL DEFAULT NULL COMMENT '图书馆ID',
  `door` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门号',
  `pressmark` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书架号',
  `book_row` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书架行号',
  `book_line` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书架列号',
  `status` int(1) NULL DEFAULT NULL COMMENT '是否存在书籍（0:存在，1：不存在）',
  `category_id` bigint(30) NULL DEFAULT NULL COMMENT '图书混合类别编码',
  `address_code` bigint(20) NULL DEFAULT NULL COMMENT '地址编码（和地址ID一样）',
  `deleted` bigint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `insert_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增联系人',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '新增时间',
  `update_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改联系人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1367 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_address
-- ----------------------------
INSERT INTO `book_address` VALUES (1263, 6, '101', '1', '1', '1', 0, 99, 1, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1264, 6, '101', '1', '1', '2', 1, 99, 2, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1265, 6, '101', '1', '1', '3', 1, 99, 3, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1266, 6, '101', '1', '1', '4', 1, 99, 4, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1267, 6, '101', '1', '1', '5', 1, 99, 5, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1268, 6, '101', '1', '1', '6', 1, 99, 6, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1269, 6, '101', '1', '1', '7', 1, 99, 7, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1270, 6, '101', '1', '1', '8', 1, 99, 8, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1271, 6, '101', '1', '1', '9', 1, 99, 9, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1272, 6, '101', '1', '1', '10', 1, 99, 10, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1273, 6, '101', '1', '1', '11', 1, 99, 11, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1274, 6, '101', '1', '1', '12', 1, 99, 12, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1275, 6, '101', '1', '1', '13', 1, 99, 13, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1276, 6, '101', '1', '1', '14', 1, 99, 14, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1277, 6, '101', '1', '1', '15', 1, 99, 15, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1278, 6, '101', '1', '2', '1', 1, 99, 16, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1279, 6, '101', '1', '2', '2', 1, 99, 17, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1280, 6, '101', '1', '2', '3', 1, 99, 18, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1281, 6, '101', '1', '2', '4', 1, 99, 19, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1282, 6, '101', '1', '2', '5', 1, 99, 20, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1283, 6, '101', '1', '2', '6', 1, 99, 21, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1284, 6, '101', '1', '2', '7', 1, 99, 22, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1285, 6, '101', '1', '2', '8', 1, 99, 23, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1286, 6, '101', '1', '2', '9', 1, 99, 24, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1287, 6, '101', '1', '2', '10', 1, 99, 25, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1288, 6, '101', '1', '2', '11', 1, 99, 26, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1289, 6, '101', '1', '2', '12', 1, 99, 27, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1290, 6, '101', '1', '2', '13', 1, 99, 28, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1291, 6, '101', '1', '2', '14', 1, 99, 29, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1292, 6, '101', '1', '2', '15', 1, 99, 30, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1293, 6, '101', '1', '3', '1', 1, 99, 31, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1294, 6, '101', '1', '3', '2', 1, 99, 32, 0, 'admin', '2022-05-15 13:09:12', NULL, NULL);
INSERT INTO `book_address` VALUES (1295, 6, '101', '1', '3', '3', 1, 99, 33, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1296, 6, '101', '1', '3', '4', 1, 99, 34, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1297, 6, '101', '1', '3', '5', 1, 99, 35, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1298, 6, '101', '1', '3', '6', 1, 99, 36, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1299, 6, '101', '1', '3', '7', 1, 99, 37, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1300, 6, '101', '1', '3', '8', 1, 99, 38, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1301, 6, '101', '1', '3', '9', 1, 99, 39, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1302, 6, '101', '1', '3', '10', 1, 99, 40, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1303, 6, '101', '1', '3', '11', 1, 99, 41, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1304, 6, '101', '1', '3', '12', 1, 99, 42, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1305, 6, '101', '1', '3', '13', 1, 99, 43, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1306, 6, '101', '1', '3', '14', 1, 99, 44, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1307, 6, '101', '1', '3', '15', 1, 99, 45, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1308, 6, '101', '1', '4', '1', 1, 99, 46, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1309, 6, '101', '1', '4', '2', 1, 99, 47, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1310, 6, '101', '1', '4', '3', 1, 99, 48, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1311, 6, '101', '1', '4', '4', 1, 99, 49, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1312, 6, '101', '1', '4', '5', 1, 99, 50, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1313, 6, '101', '1', '4', '6', 1, 99, 51, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1314, 6, '101', '1', '4', '7', 1, 99, 52, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1315, 6, '101', '1', '4', '8', 1, 99, 53, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1316, 6, '101', '1', '4', '9', 1, 99, 54, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1317, 6, '101', '1', '4', '10', 1, 99, 55, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1318, 6, '101', '1', '4', '11', 1, 99, 56, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1319, 6, '101', '1', '4', '12', 1, 99, 57, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1320, 6, '101', '1', '4', '13', 1, 99, 58, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1321, 6, '101', '1', '4', '14', 1, 99, 59, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1322, 6, '101', '1', '4', '15', 1, 99, 60, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1323, 6, '101', '1', '5', '1', 1, 99, 61, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1324, 6, '101', '1', '5', '2', 1, 99, 62, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1325, 6, '101', '1', '5', '3', 1, 99, 63, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1326, 6, '101', '1', '5', '4', 1, 99, 64, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1327, 6, '101', '1', '5', '5', 1, 99, 65, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1328, 6, '101', '1', '5', '6', 1, 99, 66, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1329, 6, '101', '1', '5', '7', 1, 99, 67, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1330, 6, '101', '1', '5', '8', 1, 99, 68, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1331, 6, '101', '1', '5', '9', 1, 99, 69, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1332, 6, '101', '1', '5', '10', 1, 99, 70, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1333, 6, '101', '1', '5', '11', 1, 99, 71, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1334, 6, '101', '1', '5', '12', 1, 99, 72, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1335, 6, '101', '1', '5', '13', 1, 99, 73, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1336, 6, '101', '1', '5', '14', 1, 99, 74, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1337, 6, '101', '1', '5', '15', 1, 99, 75, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1338, 6, '101', '1', '6', '1', 1, 99, 76, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1339, 6, '101', '1', '6', '2', 1, 99, 77, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1340, 6, '101', '1', '6', '3', 1, 99, 78, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1341, 6, '101', '1', '6', '4', 1, 99, 79, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1342, 6, '101', '1', '6', '5', 1, 99, 80, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1343, 6, '101', '1', '6', '6', 1, 99, 81, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1344, 6, '101', '1', '6', '7', 1, 99, 82, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1345, 6, '101', '1', '6', '8', 1, 99, 83, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1346, 6, '101', '1', '6', '9', 1, 99, 84, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1347, 6, '101', '1', '6', '10', 1, 99, 85, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1348, 6, '101', '1', '6', '11', 1, 99, 86, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1349, 6, '101', '1', '6', '12', 1, 99, 87, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1350, 6, '101', '1', '6', '13', 1, 99, 88, 0, 'admin', '2022-05-15 13:09:13', NULL, NULL);
INSERT INTO `book_address` VALUES (1351, 6, '101', '1', '6', '14', 1, 99, 89, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1352, 6, '101', '1', '6', '15', 1, 99, 90, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1353, 6, '101', '1', '7', '1', 1, 99, 91, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1354, 6, '101', '1', '7', '2', 1, 99, 92, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1355, 6, '101', '1', '7', '3', 1, 99, 93, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1356, 6, '101', '1', '7', '4', 1, 99, 94, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1357, 6, '101', '1', '7', '5', 1, 99, 95, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1358, 6, '101', '1', '7', '6', 1, 99, 96, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1359, 6, '101', '1', '7', '7', 1, 99, 97, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1360, 6, '101', '1', '7', '8', 1, 99, 98, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1361, 6, '101', '1', '7', '9', 1, 99, 99, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1362, 6, '101', '1', '7', '10', 1, 99, 100, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1363, 6, '101', '1', '7', '11', 1, 99, 101, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1364, 6, '101', '1', '7', '12', 1, 99, 102, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1365, 6, '101', '1', '7', '13', 1, 99, 103, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1366, 6, '101', '1', '7', '14', 1, 99, 104, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);
INSERT INTO `book_address` VALUES (1367, 6, '101', '1', '7', '15', 1, 99, 105, 0, 'admin', '2022-05-15 13:09:14', NULL, NULL);

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info`  (
  `book_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '书籍ID',
  `book_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书名称',
  `book_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书ISBN编码',
  `book_press` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书出版社',
  `category_code` bigint(30) NULL DEFAULT NULL COMMENT '图书分类Id',
  `library_id` bigint(10) NULL DEFAULT NULL COMMENT '图书馆ID',
  `address_id` bigint(20) NULL DEFAULT NULL COMMENT '书籍馆存地址ID',
  `book_imageUrl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书籍照片存储地址',
  `deleted` bigint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `insert_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增联系人',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '新增时间',
  `update_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改联系人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `pricing` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '定价',
  `press_time` datetime(0) NULL DEFAULT NULL COMMENT '出版时间',
  `language` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '正文语种',
  `book_txt_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书txt文件地址',
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES (20, '新视野大学英语(第三版)视听说教程\r\n', '9787513590228', '外语教学与研究出版社\r\n', 105, 6, NULL, '20220515b2cf7600-5d0a-4606-a1f7-2a7035cae345.jpg', 0, '张三', '2022-05-15 10:49:48', 'admin', '2022-05-15 15:35:27', '郑树棠总主编\r\n', '55.9\r\n', '2017-06-01 09:21:08', NULL, NULL);
INSERT INTO `book_info` VALUES (21, '高等数学(上)\r\n', '\r\n9787309115079  ', '复旦大学出版社\r\n', 106, 6, NULL, '20220522f16b4e91-2853-47d4-b952-0fce11e6cc79.jpg', 0, '张三', '2022-05-22 00:20:59', 'admin', '2022-05-22 00:21:29', '黄立宏\r\n', '30', '2018-05-14 09:23:09', NULL, NULL);
INSERT INTO `book_info` VALUES (22, '中国商品交易市场运行学\r\n', '9787548727088', '中南大学出版社\r\n', 107, 6, NULL, '2022052241251ebc-299c-4354-bb32-db32ba896c1e.png', 0, '张三', '2022-05-22 00:23:03', 'admin', '2022-05-22 00:23:18', '刘天祥\r\n', '32.5', '2019-05-01 09:25:03', NULL, NULL);
INSERT INTO `book_info` VALUES (23, '编译原理\r\n', '9787030246950', '科学出版社\r\n', 108, 6, 1263, '2022052294a8283f-67a0-4b7a-b649-c1b180093f4a.png', 0, '张三', '2022-05-22 00:25:12', 'admin', '2022-05-22 00:27:20', '王磊\r\n', '43.2', '2019-06-14 09:27:08', NULL, NULL);
INSERT INTO `book_info` VALUES (24, '数据库系统概论\r\n', '9787040406641', '高等教育出版社\r\n', 109, 6, 1263, '20220522885ade83-1c65-4dfa-80b7-492a938cd401.png', 0, '张三', '2022-05-22 00:27:45', 'admin', '2022-05-22 00:28:04', '王珊等\r\n', '37.8', '2017-06-14 09:27:18', NULL, NULL);
INSERT INTO `book_info` VALUES (25, '西方经济学\r\n', '9787040464269', '高等教育出版社\r\n', 110, 6, NULL, '20220522492edaa4-19ab-4ce4-a313-73896dfeb62b.png', 0, '张三', '2022-05-22 00:28:26', 'admin', '2022-05-22 00:28:40', '《西方经济学》编写组\r\n', '34.2', '2016-01-01 09:27:27', NULL, NULL);

-- ----------------------------
-- Table structure for book_recommend
-- ----------------------------
DROP TABLE IF EXISTS `book_recommend`;
CREATE TABLE `book_recommend`  (
  `recommend_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '推荐表主键',
  `book_id` bigint(10) NULL DEFAULT NULL COMMENT '书籍ID',
  `user_id` bigint(10) NULL DEFAULT NULL COMMENT '读者ID',
  `correlationIntensity` bigint(30) NULL DEFAULT NULL COMMENT '读者对该书籍的相关强度',
  `status` int(1) NULL DEFAULT NULL COMMENT '是否已经加入书架收藏（0表示未收藏，1表示已收藏）',
  PRIMARY KEY (`recommend_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_recommend
-- ----------------------------

-- ----------------------------
-- Table structure for bookrack_info
-- ----------------------------
DROP TABLE IF EXISTS `bookrack_info`;
CREATE TABLE `bookrack_info`  (
  `bookrack_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'app书架id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `book_id` bigint(20) NULL DEFAULT NULL COMMENT '书籍id',
  `deleted` int(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '新增时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`bookrack_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bookrack_info
-- ----------------------------
INSERT INTO `bookrack_info` VALUES (2, 4, 20, 0, '2022-05-15 18:59:19', NULL);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `category_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类编码',
  `category_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `deleted` bigint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `insert_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增联系人',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '新增时间',
  `update_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改联系人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (82, 'A', '马克思主义、列宁主义、毛泽东思想、邓小平理论', 0, 'admin', '2022-05-14 09:09:42', NULL, NULL);
INSERT INTO `category` VALUES (83, 'B', '哲学、宗教', 0, 'admin', '2022-05-14 09:10:00', NULL, NULL);
INSERT INTO `category` VALUES (84, 'C', '社会科学总论', 0, 'admin', '2022-05-14 09:10:14', NULL, NULL);
INSERT INTO `category` VALUES (85, 'D', '政治、法律', 0, 'admin', '2022-05-14 09:10:29', NULL, NULL);
INSERT INTO `category` VALUES (86, 'E', '军事', 0, 'admin', '2022-05-14 09:10:51', NULL, NULL);
INSERT INTO `category` VALUES (87, 'F', '经济', 0, 'admin', '2022-05-14 09:11:11', NULL, NULL);
INSERT INTO `category` VALUES (88, 'G', '文化、科学、教育、体育', 0, 'admin', '2022-05-14 09:11:34', NULL, NULL);
INSERT INTO `category` VALUES (89, 'H', '语言、文字', 0, 'admin', '2022-05-14 09:11:50', NULL, NULL);
INSERT INTO `category` VALUES (90, 'I', '文学', 0, 'admin', '2022-05-14 09:12:02', NULL, NULL);
INSERT INTO `category` VALUES (91, 'J', '艺术', 0, 'admin', '2022-05-14 09:12:25', NULL, NULL);
INSERT INTO `category` VALUES (92, 'K', '历史、地理', 0, 'admin', '2022-05-14 09:13:11', NULL, NULL);
INSERT INTO `category` VALUES (93, 'N', '自然科学总论', 0, 'admin', '2022-05-14 09:13:37', NULL, NULL);
INSERT INTO `category` VALUES (94, 'O', '数理科学和化学', 0, 'admin', '2022-05-14 09:13:58', NULL, NULL);
INSERT INTO `category` VALUES (95, 'P', '天文学、地球科学', 0, 'admin', '2022-05-14 09:14:13', NULL, NULL);
INSERT INTO `category` VALUES (96, 'Q', '生物科学', 0, 'admin', '2022-05-14 09:14:27', NULL, NULL);
INSERT INTO `category` VALUES (97, 'R', '医药、卫生', 0, 'admin', '2022-05-14 09:14:44', NULL, NULL);
INSERT INTO `category` VALUES (98, 'S', '农业科学', 0, 'admin', '2022-05-14 09:14:58', NULL, NULL);
INSERT INTO `category` VALUES (99, 'T', '工业技术', 0, 'admin', '2022-05-14 09:15:09', NULL, NULL);
INSERT INTO `category` VALUES (100, 'U', '交通运输', 0, 'admin', '2022-05-14 09:15:21', NULL, NULL);
INSERT INTO `category` VALUES (101, 'V', '航空、航天', 0, 'admin', '2022-05-14 09:15:35', NULL, NULL);
INSERT INTO `category` VALUES (102, 'X', '环境科学、安全科学', 0, 'admin', '2022-05-14 09:15:58', NULL, NULL);
INSERT INTO `category` VALUES (103, 'Z', '综合性图书', 0, 'admin', '2022-05-14 09:16:11', NULL, NULL);
INSERT INTO `category` VALUES (105, 'H319.9', '英语', 0, 'admin', '2022-05-14 09:29:09', NULL, NULL);
INSERT INTO `category` VALUES (106, 'O13', '高等数学–高等学校–教材\n', 0, 'admin', '2022-05-22 00:20:59', NULL, NULL);
INSERT INTO `category` VALUES (107, 'F23', '商品市场–市场运行–研究–中国\n', 0, 'admin', '2022-05-22 00:23:03', NULL, NULL);
INSERT INTO `category` VALUES (108, 'TP314\n', '编译程序–程序设计–高等学校-教材\n', 0, 'admin', '2022-05-22 00:25:12', NULL, NULL);
INSERT INTO `category` VALUES (109, 'TP311.13\n', '数据库系统–高等学校–教材\n', 0, 'admin', '2022-05-22 00:27:45', NULL, NULL);
INSERT INTO `category` VALUES (110, 'F091.3\n', '西方经济学–高等学校-教材\n', 0, 'admin', '2022-05-22 00:28:26', NULL, NULL);

-- ----------------------------
-- Table structure for circulation_info
-- ----------------------------
DROP TABLE IF EXISTS `circulation_info`;
CREATE TABLE `circulation_info`  (
  `circulation_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '借还书记录ID',
  `borrow_time` datetime(0) NULL DEFAULT NULL COMMENT '借书时间',
  `return_time` datetime(0) NULL DEFAULT NULL COMMENT '还书时间',
  `status` bigint(1) NULL DEFAULT NULL COMMENT '0表示借书，1表示还书',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '读者ID',
  `book_id` bigint(10) NULL DEFAULT NULL COMMENT '书籍ID',
  `deleted` bigint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `insert_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增联系人',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '新增时间',
  `update_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改联系人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`circulation_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of circulation_info
-- ----------------------------
INSERT INTO `circulation_info` VALUES (10, '2022-05-15 19:34:58', '2022-05-15 19:35:46', 1, 4, 20, 1, 'admin', '2022-05-15 19:34:58', 'admin', '2022-05-15 19:35:46');

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify`  (
  `classify_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '类别ID',
  `classify_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名',
  `deleted` bigint(1) NOT NULL COMMENT '逻辑删除',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '新增时间',
  `insert_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增联系人',
  `update_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改联系人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`classify_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classify
-- ----------------------------

-- ----------------------------
-- Table structure for correlation
-- ----------------------------
DROP TABLE IF EXISTS `correlation`;
CREATE TABLE `correlation`  (
  `correlation_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(30) NULL DEFAULT NULL COMMENT '关联用户ID',
  `category_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联分类编码',
  `correlation_strength` double(20, 2) NULL DEFAULT NULL COMMENT '与分类的相关强度',
  PRIMARY KEY (`correlation_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of correlation
-- ----------------------------
INSERT INTO `correlation` VALUES (22, 4, 'H', 0.01);
INSERT INTO `correlation` VALUES (23, 4, 'H319.9', 0.06);
INSERT INTO `correlation` VALUES (24, 4, 'TP311.13\n', 0.08);
INSERT INTO `correlation` VALUES (25, 4, 'T', 0.02);
INSERT INTO `correlation` VALUES (26, 4, 'TP314\n', 0.12);

-- ----------------------------
-- Table structure for debit_info
-- ----------------------------
DROP TABLE IF EXISTS `debit_info`;
CREATE TABLE `debit_info`  (
  `debit_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '借记卡ID',
  `debit_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借记卡编码',
  `debit_validity` datetime(0) NULL DEFAULT NULL COMMENT '借记卡有效期',
  `status` bigint(1) NULL DEFAULT NULL COMMENT '借记卡状态（0表示正常，1表示已经停用）',
  `debit_level` int(2) NULL DEFAULT NULL COMMENT '借记卡级别',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '读者ID',
  `deleted` bigint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `insert_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增联系人',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '新增时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改联系人',
  PRIMARY KEY (`debit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of debit_info
-- ----------------------------
INSERT INTO `debit_info` VALUES (6, '20220514094823612', '2022-10-01 19:13:51', 0, 1, 4, 0, 'admin', '2022-05-14 09:48:24', NULL, NULL);

-- ----------------------------
-- Table structure for debit_level
-- ----------------------------
DROP TABLE IF EXISTS `debit_level`;
CREATE TABLE `debit_level`  (
  `debit_level_id` int(10) NOT NULL AUTO_INCREMENT,
  `debit_level_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借记卡段位名称',
  `deleted` int(11) NULL DEFAULT NULL COMMENT '逻辑删除',
  `debit_number` int(11) NULL DEFAULT NULL COMMENT '可借记的最大数量',
  PRIMARY KEY (`debit_level_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of debit_level
-- ----------------------------
INSERT INTO `debit_level` VALUES (1, '青铜读者', 0, 5);
INSERT INTO `debit_level` VALUES (2, '白银读者', 0, 7);
INSERT INTO `debit_level` VALUES (3, '黄金读者', 0, 9);
INSERT INTO `debit_level` VALUES (4, '铂金读者', 0, 11);
INSERT INTO `debit_level` VALUES (5, '钻石读者', 0, 13);
INSERT INTO `debit_level` VALUES (6, '星耀读者', 0, 15);
INSERT INTO `debit_level` VALUES (7, '王者读者', 0, 17);

-- ----------------------------
-- Table structure for forward_info
-- ----------------------------
DROP TABLE IF EXISTS `forward_info`;
CREATE TABLE `forward_info`  (
  `forward_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '预约记录ID',
  `forward_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预约记录编码',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '读者ID',
  `library_id` bigint(10) NULL DEFAULT NULL COMMENT '图书馆ID',
  `deleted` bigint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `insert_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增联系人',
  `update_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改联系人',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '新增时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `forward_time` datetime(0) NULL DEFAULT NULL COMMENT '预约时间',
  PRIMARY KEY (`forward_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forward_info
-- ----------------------------
INSERT INTO `forward_info` VALUES (21, '20220514095636279', 4, 6, 0, '王五', NULL, '2022-05-14 09:56:36', NULL, '2022-05-14 00:00:00');
INSERT INTO `forward_info` VALUES (22, '20220514095637672', 4, 6, 1, '王五', NULL, '2022-05-14 09:56:37', NULL, '2022-05-14 00:00:00');

-- ----------------------------
-- Table structure for library_info
-- ----------------------------
DROP TABLE IF EXISTS `library_info`;
CREATE TABLE `library_info`  (
  `library_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '图书馆ID',
  `library_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书馆名称',
  `address` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书馆地址',
  `library_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书馆编码',
  `deleted` bigint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '新增时间',
  `insert_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增联系人',
  `update_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改联系人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`library_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of library_info
-- ----------------------------
INSERT INTO `library_info` VALUES (6, '湖南工商大学图书馆', '湖南省长沙市岳麓区咸嘉湖街道桐梓坡西路359号', '1311151516', 0, '2022-05-14 09:55:54', 'admin', NULL, NULL);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `send_id` bigint(20) NULL DEFAULT NULL COMMENT '发送方ID',
  `receive_id` bigint(20) NULL DEFAULT NULL COMMENT '接收方ID',
  `message_info` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '新建时间',
  `deleted` int(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `insert_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增联系人',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (12, 2, 4, '你好', '2022-05-22 00:50:23', 0, '张三');
INSERT INTO `message` VALUES (14, 2, 4, '您借阅的书籍预计3天后到期', '2022-05-22 00:54:13', 0, '张三');
INSERT INTO `message` VALUES (15, 2, 4, '请在规定时间内还书', '2022-05-22 00:54:24', 0, '张三');
INSERT INTO `message` VALUES (16, 4, 2, '好的', '2022-05-22 00:54:48', 0, '王五');

-- ----------------------------
-- Table structure for offical_book
-- ----------------------------
DROP TABLE IF EXISTS `offical_book`;
CREATE TABLE `offical_book`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ISBN编码',
  `book_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书名',
  `book_press` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书出版社',
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `press_time` datetime(0) NULL DEFAULT NULL COMMENT '出版时间',
  `pricing` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '定价',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类Id',
  `category_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `language` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '正文语种',
  `image_url` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书照片地址',
  `bookTxt_url` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书txt文件地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of offical_book
-- ----------------------------
INSERT INTO `offical_book` VALUES (1, '9787513590228', '新视野大学英语(第三版)视听说教程\r\n', '外语教学与研究出版社\r\n', '\r\n郑树棠总主编\r\n', '2017-06-01 09:21:08', '55.9\r\n', 'H319.9\r\n', '英语\r\n', 'English\r\n', NULL, NULL);
INSERT INTO `offical_book` VALUES (2, '\r\n9787309115079  ', '高等数学(上)\r\n', '复旦大学出版社\r\n', '黄立宏\r\n', '2018-05-14 09:23:09', '30', 'O13', '高等数学–高等学校–教材\n', '中文', NULL, NULL);
INSERT INTO `offical_book` VALUES (3, '9787548727088', '中国商品交易市场运行学\r\n', '中南大学出版社\r\n', '刘天祥\r\n', '2019-05-01 09:25:03', '32.5', 'F23', '商品市场–市场运行–研究–中国\n', NULL, NULL, NULL);
INSERT INTO `offical_book` VALUES (4, '9787030246950', '编译原理\r\n', '科学出版社\r\n', '王磊\r\n', '2019-06-14 09:27:08', '43.2', 'TP314\n', '编译程序–程序设计–高等学校-教材\n', NULL, NULL, NULL);
INSERT INTO `offical_book` VALUES (5, '9787040406641', '数据库系统概论\r\n', '高等教育出版社\r\n', '王珊等\r\n', '2017-06-14 09:27:18', '37.8', 'TP311.13\n', '数据库系统–高等学校–教材\n', NULL, NULL, NULL);
INSERT INTO `offical_book` VALUES (6, '9787040464269', '西方经济学\r\n', '高等教育出版社\r\n', '《西方经济学》编写组\r\n', '2016-01-01 09:27:27', '34.2', 'F091.3\n', '西方经济学–高等学校-教材\n', NULL, NULL, NULL);
INSERT INTO `offical_book` VALUES (7, '9787560855943', '大学物理\r\n', '同济大学出版社\r\n', '渊小春\r\n', '2017-06-01 09:27:46', '35.9', 'O4\n', '物理学–高等学校–教材\n', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BLOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `SCHED_NAME`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ENTRY_ID` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TRIG_INST_NAME`(`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY`(`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_FT_J_G`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_T_G`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TG`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_DURABLE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_J_REQ_RECOVERY`(`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_J_GRP`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', NULL, 'io.renren.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002E696F2E72656E72656E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000180BB8285D87874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672656E72656E74000CE58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOCK_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', 'DESKTOP-KP203B51653368349144', 1653369493613, 15000);

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STR_PROP_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INT_PROP_1` int(11) NULL DEFAULT NULL,
  `INT_PROP_2` int(11) NULL DEFAULT NULL,
  `LONG_PROP_1` bigint(20) NULL DEFAULT NULL,
  `LONG_PROP_2` bigint(20) NULL DEFAULT NULL,
  `DEC_PROP_1` decimal(13, 4) NULL DEFAULT NULL,
  `DEC_PROP_2` decimal(13, 4) NULL DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PRIORITY` int(11) NULL DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) NULL DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) NULL DEFAULT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_J`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_C`(`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_T_G`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_STATE`(`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_STATE`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_G_STATE`(`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME`(`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST`(`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', NULL, 1653370200000, 1653368400000, 5, 'WAITING', 'CRON', 1652414383000, 0, NULL, 2, 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002E696F2E72656E72656E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000180BB8285D87874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672656E72656E74000CE58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '定时任务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES (1, 'testTask', 'renren', '0 0/30 * * * ?', 0, '参数测试', '2022-05-13 11:42:15');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log`  (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE,
  INDEX `job_id`(`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '定时任务日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES (1, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-13 12:30:00');
INSERT INTO `schedule_job_log` VALUES (2, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-13 13:00:00');
INSERT INTO `schedule_job_log` VALUES (3, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-13 13:30:00');
INSERT INTO `schedule_job_log` VALUES (4, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-13 14:00:00');
INSERT INTO `schedule_job_log` VALUES (5, 1, 'testTask', 'renren', 0, NULL, 2, '2022-05-13 14:30:00');
INSERT INTO `schedule_job_log` VALUES (6, 1, 'testTask', 'renren', 0, NULL, 2, '2022-05-13 21:00:00');
INSERT INTO `schedule_job_log` VALUES (7, 1, 'testTask', 'renren', 0, NULL, 2, '2022-05-14 09:30:00');
INSERT INTO `schedule_job_log` VALUES (8, 1, 'testTask', 'renren', 0, NULL, 2, '2022-05-14 10:00:00');
INSERT INTO `schedule_job_log` VALUES (9, 1, 'testTask', 'renren', 0, NULL, 2, '2022-05-14 10:30:00');
INSERT INTO `schedule_job_log` VALUES (10, 1, 'testTask', 'renren', 0, NULL, 2, '2022-05-15 10:30:00');
INSERT INTO `schedule_job_log` VALUES (11, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-15 19:00:00');
INSERT INTO `schedule_job_log` VALUES (12, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-15 19:30:00');
INSERT INTO `schedule_job_log` VALUES (13, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-15 20:00:00');
INSERT INTO `schedule_job_log` VALUES (14, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-15 22:30:00');
INSERT INTO `schedule_job_log` VALUES (15, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-21 21:30:00');
INSERT INTO `schedule_job_log` VALUES (16, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-21 22:00:00');
INSERT INTO `schedule_job_log` VALUES (17, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-21 23:30:00');
INSERT INTO `schedule_job_log` VALUES (18, 1, 'testTask', 'renren', 0, NULL, 7, '2022-05-22 00:00:00');
INSERT INTO `schedule_job_log` VALUES (19, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-22 00:30:00');
INSERT INTO `schedule_job_log` VALUES (20, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-22 01:00:00');
INSERT INTO `schedule_job_log` VALUES (21, 1, 'testTask', 'renren', 0, NULL, 2, '2022-05-22 10:00:00');
INSERT INTO `schedule_job_log` VALUES (22, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-22 10:30:00');
INSERT INTO `schedule_job_log` VALUES (23, 1, 'testTask', 'renren', 0, NULL, 1, '2022-05-22 11:00:00');
INSERT INTO `schedule_job_log` VALUES (24, 1, 'testTask', 'renren', 0, NULL, 2, '2022-05-24 13:00:00');

-- ----------------------------
-- Table structure for standrad_book_info
-- ----------------------------
DROP TABLE IF EXISTS `standrad_book_info`;
CREATE TABLE `standrad_book_info`  (
  `ISBN_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书ISBN编码',
  `book_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书名称',
  `book_press` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书出版社',
  PRIMARY KEY (`ISBN_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of standrad_book_info
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `subject_id` int(20) NOT NULL AUTO_INCREMENT,
  `suject_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目名称',
  `subject_option` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目选项',
  `deleted` int(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `insert_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增联系人',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '新增时间',
  PRIMARY KEY (`subject_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for sys_captcha
-- ----------------------------
DROP TABLE IF EXISTS `sys_captcha`;
CREATE TABLE `sys_captcha`  (
  `uuid` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'uuid',
  `code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '验证码',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统验证码' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_captcha
-- ----------------------------
INSERT INTO `sys_captcha` VALUES ('02da03bd-0196-4057-8411-62e88e6406f0', '462ny', '2022-05-22 08:19:18');
INSERT INTO `sys_captcha` VALUES ('11df2edd-8fd4-41ba-805c-7e9200a9f324', '7d4w4', '2022-05-13 12:06:34');
INSERT INTO `sys_captcha` VALUES ('1ed86692-d7f3-4071-82be-adfcf5496c66', 'nxbwm', '2022-05-15 10:01:02');
INSERT INTO `sys_captcha` VALUES ('412e2abf-7b7a-4eb5-8794-15593852220e', 'w8cg5', '2022-05-14 09:13:45');
INSERT INTO `sys_captcha` VALUES ('969efcfe-4538-4e66-8ffc-e79b7982a189', '3g72m', '2022-05-21 21:10:51');
INSERT INTO `sys_captcha` VALUES ('c3f1893a-8cde-46a7-8c4c-fb63724dd11e', 'yp36g', '2022-05-13 12:06:07');
INSERT INTO `sys_captcha` VALUES ('ff8b9c64-fbf5-4ed3-8f3f-59c92095e577', 'yd4xf', '2022-05-13 20:47:25');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `param_key`(`param_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统配置信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', 0, '云存储配置信息');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '[30]', 0, '0:0:0:0:0:0:0:1', '2022-05-13 12:03:03');
INSERT INTO `sys_log` VALUES (2, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":31,\"parentId\":1,\"name\":\"图书管理\",\"url\":\"bookmanager/bookinfo\",\"type\":1,\"icon\":\"config\",\"orderNum\":6,\"list\":[]}]', 32, '0:0:0:0:0:0:0:1', '2022-05-13 12:11:29');
INSERT INTO `sys_log` VALUES (3, 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '[{\"menuId\":46,\"parentId\":0,\"name\":\"书籍管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"log\",\"orderNum\":0,\"list\":[]}]', 25, '0:0:0:0:0:0:0:1', '2022-05-13 12:11:54');
INSERT INTO `sys_log` VALUES (4, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":31,\"parentId\":46,\"name\":\"图书管理\",\"url\":\"bookmanager/bookinfo\",\"type\":1,\"icon\":\"config\",\"orderNum\":6,\"list\":[]}]', 32, '0:0:0:0:0:0:0:1', '2022-05-13 12:12:08');
INSERT INTO `sys_log` VALUES (5, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":36,\"parentId\":46,\"name\":\"图书分类管理\",\"url\":\"bookmanager/category\",\"type\":1,\"icon\":\"config\",\"orderNum\":6,\"list\":[]}]', 35, '0:0:0:0:0:0:0:1', '2022-05-13 12:12:26');
INSERT INTO `sys_log` VALUES (6, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":41,\"parentId\":1,\"name\":\"官方书籍数据维护\",\"url\":\"bookmanager/officalbook\",\"type\":1,\"icon\":\"config\",\"orderNum\":6,\"list\":[]}]', 35, '0:0:0:0:0:0:0:1', '2022-05-13 12:12:46');
INSERT INTO `sys_log` VALUES (7, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":41,\"parentId\":46,\"name\":\"官方书籍数据维护\",\"url\":\"bookmanager/officalbook\",\"type\":1,\"icon\":\"config\",\"orderNum\":6,\"list\":[]}]', 32, '0:0:0:0:0:0:0:1', '2022-05-13 12:12:55');
INSERT INTO `sys_log` VALUES (8, 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '[{\"menuId\":77,\"parentId\":0,\"name\":\"借记管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"\",\"orderNum\":0,\"list\":[]}]', 21, '0:0:0:0:0:0:0:1', '2022-05-13 12:17:06');
INSERT INTO `sys_log` VALUES (9, 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '[{\"menuId\":78,\"parentId\":0,\"name\":\"图书馆管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"\",\"orderNum\":0,\"list\":[]}]', 22, '0:0:0:0:0:0:0:1', '2022-05-13 12:17:24');
INSERT INTO `sys_log` VALUES (10, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":77,\"parentId\":0,\"name\":\"借记管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"sql\",\"orderNum\":0,\"list\":[]}]', 22, '0:0:0:0:0:0:0:1', '2022-05-13 12:18:00');
INSERT INTO `sys_log` VALUES (11, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":78,\"parentId\":0,\"name\":\"图书馆管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"menu\",\"orderNum\":0,\"list\":[]}]', 21, '0:0:0:0:0:0:0:1', '2022-05-13 12:18:16');
INSERT INTO `sys_log` VALUES (12, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":47,\"parentId\":77,\"name\":\"借记卡管理\",\"url\":\"bookmanager/debitinfo\",\"type\":1,\"icon\":\"tubiao\",\"orderNum\":6,\"list\":[]}]', 32, '0:0:0:0:0:0:0:1', '2022-05-13 12:19:41');
INSERT INTO `sys_log` VALUES (13, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":57,\"parentId\":77,\"name\":\"借还管理\",\"url\":\"bookmanager/circulationinfo\",\"type\":1,\"icon\":\"tixing\",\"orderNum\":6,\"list\":[]}]', 30, '0:0:0:0:0:0:0:1', '2022-05-13 12:20:12');
INSERT INTO `sys_log` VALUES (14, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":52,\"parentId\":77,\"name\":\"题目管理\",\"url\":\"bookmanager/topic\",\"type\":1,\"icon\":\"shezhi\",\"orderNum\":6,\"list\":[]}]', 26, '0:0:0:0:0:0:0:1', '2022-05-13 12:20:31');
INSERT INTO `sys_log` VALUES (15, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":62,\"parentId\":78,\"name\":\"入馆预约管理\",\"url\":\"bookmanager/forwardinfo\",\"type\":1,\"icon\":\"admin\",\"orderNum\":6,\"list\":[]}]', 31, '0:0:0:0:0:0:0:1', '2022-05-13 12:21:03');
INSERT INTO `sys_log` VALUES (16, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":67,\"parentId\":78,\"name\":\"图书馆管理\",\"url\":\"bookmanager/libraryinfo\",\"type\":1,\"icon\":\"config\",\"orderNum\":6,\"list\":[]}]', 29, '0:0:0:0:0:0:0:1', '2022-05-13 12:21:24');
INSERT INTO `sys_log` VALUES (17, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":72,\"parentId\":78,\"name\":\"书室管理\",\"url\":\"bookmanager/bookaddress\",\"type\":1,\"icon\":\"config\",\"orderNum\":6,\"list\":[]}]', 27, '0:0:0:0:0:0:0:1', '2022-05-13 12:21:47');
INSERT INTO `sys_log` VALUES (18, 'admin', '保存角色', 'io.renren.modules.sys.controller.SysRoleController.save()', '[{\"roleId\":1,\"roleName\":\"图书馆管理员\",\"remark\":\"\",\"createUserId\":1,\"menuIdList\":[15,46,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,77,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,78,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,-666666,1,2],\"createTime\":\"May 13, 2022 8:47:51 PM\"}]', 895, '0:0:0:0:0:0:0:1', '2022-05-13 20:47:52');
INSERT INTO `sys_log` VALUES (19, 'admin', '保存角色', 'io.renren.modules.sys.controller.SysRoleController.save()', '[{\"roleId\":2,\"roleName\":\"读者\",\"remark\":\"\",\"createUserId\":1,\"menuIdList\":[47,48,49,50,51,57,58,59,60,61,62,63,64,65,66,-666666,77,78],\"createTime\":\"May 13, 2022 8:48:20 PM\"}]', 248, '0:0:0:0:0:0:0:1', '2022-05-13 20:48:20');
INSERT INTO `sys_log` VALUES (20, 'admin', '保存用户', 'io.renren.modules.sys.controller.SysUserController.save()', '[{\"userId\":2,\"username\":\"张三\",\"password\":\"7947b3b1bf742f593711ff3c6666795f8f7321fbf2d9d056c029217c59be62cc\",\"salt\":\"1gr85HYHbo1eZLmXlvaf\",\"email\":\"1314111@qq.com\",\"mobile\":\"13132345676\",\"status\":1,\"roleIdList\":[1],\"createUserId\":1,\"createTime\":\"May 13, 2022 8:52:28 PM\"}]', 388, '0:0:0:0:0:0:0:1', '2022-05-13 20:52:29');
INSERT INTO `sys_log` VALUES (21, 'admin', '保存用户', 'io.renren.modules.sys.controller.SysUserController.save()', '[{\"userId\":3,\"username\":\"李四\",\"password\":\"fadd2d84f340a53c9c79a004eb5814148c0a461cb2273ef0c933ecaa2c6675a8\",\"salt\":\"jNr1gErUwO4HwQ9TUGUM\",\"email\":\"14151616@qq.com\",\"mobile\":\"13123234565\",\"status\":1,\"roleIdList\":[2],\"createUserId\":1,\"createTime\":\"May 13, 2022 8:58:39 PM\"}]', 369, '0:0:0:0:0:0:0:1', '2022-05-13 20:58:39');
INSERT INTO `sys_log` VALUES (22, 'admin', '修改用户', 'io.renren.modules.sys.controller.SysUserController.update()', '[{\"userId\":3,\"username\":\"李四\",\"password\":\"fadd2d84f340a53c9c79a004eb5814148c0a461cb2273ef0c933ecaa2c6675a8\",\"salt\":\"jNr1gErUwO4HwQ9TUGUM\",\"email\":\"14151616@qq.com\",\"mobile\":\"13123234565\",\"status\":0,\"roleIdList\":[2],\"createUserId\":1}]', 351, '0:0:0:0:0:0:0:1', '2022-05-15 19:37:15');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', NULL, NULL, 0, 'system', 0);
INSERT INTO `sys_menu` VALUES (2, 1, '管理员列表', 'sys/user', NULL, 1, 'admin', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'sys/role', NULL, 1, 'role', 2);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', 'sys/menu', NULL, 1, 'menu', 3);
INSERT INTO `sys_menu` VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (31, 46, '图书管理', 'bookmanager/bookinfo', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (32, 31, '查看', NULL, 'bookmanager:bookinfo:list,bookmanager:bookinfo:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (33, 31, '新增', NULL, 'bookmanager:bookinfo:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (34, 31, '修改', NULL, 'bookmanager:bookinfo:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (35, 31, '删除', NULL, 'bookmanager:bookinfo:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (36, 46, '图书分类管理', 'bookmanager/category', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (37, 36, '查看', NULL, 'bookmanager:category:list,bookmanager:category:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (38, 36, '新增', NULL, 'bookmanager:category:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (39, 36, '修改', NULL, 'bookmanager:category:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (40, 36, '删除', NULL, 'bookmanager:category:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (41, 46, '官方书籍数据维护', 'bookmanager/officalbook', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (42, 41, '查看', NULL, 'bookmanager:officalbook:list,bookmanager:officalbook:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (43, 41, '新增', NULL, 'bookmanager:officalbook:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (44, 41, '修改', NULL, 'bookmanager:officalbook:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (45, 41, '删除', NULL, 'bookmanager:officalbook:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (46, 0, '书籍管理', '', '', 0, 'log', 0);
INSERT INTO `sys_menu` VALUES (47, 77, '借记卡管理', 'bookmanager/debitinfo', NULL, 1, 'tubiao', 6);
INSERT INTO `sys_menu` VALUES (48, 47, '查看', NULL, 'bookmanager:debitinfo:list,bookmanager:debitinfo:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (49, 47, '新增', NULL, 'bookmanager:debitinfo:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (50, 47, '修改', NULL, 'bookmanager:debitinfo:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (51, 47, '删除', NULL, 'bookmanager:debitinfo:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (52, 77, '题目管理', 'bookmanager/topic', NULL, 1, 'shezhi', 6);
INSERT INTO `sys_menu` VALUES (53, 52, '查看', NULL, 'bookmanager:topic:list,bookmanager:topic:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (54, 52, '新增', NULL, 'bookmanager:topic:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (55, 52, '修改', NULL, 'bookmanager:topic:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (56, 52, '删除', NULL, 'bookmanager:topic:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (57, 77, '借还管理', 'bookmanager/circulationinfo', NULL, 1, 'tixing', 6);
INSERT INTO `sys_menu` VALUES (58, 57, '查看', NULL, 'bookmanager:circulationinfo:list,bookmanager:circulationinfo:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (59, 57, '新增', NULL, 'bookmanager:circulationinfo:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (60, 57, '修改', NULL, 'bookmanager:circulationinfo:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (61, 57, '删除', NULL, 'bookmanager:circulationinfo:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (62, 78, '入馆预约管理', 'bookmanager/forwardinfo', NULL, 1, 'admin', 6);
INSERT INTO `sys_menu` VALUES (63, 62, '查看', NULL, 'bookmanager:forwardinfo:list,bookmanager:forwardinfo:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (64, 62, '新增', NULL, 'bookmanager:forwardinfo:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (65, 62, '修改', NULL, 'bookmanager:forwardinfo:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (66, 62, '删除', NULL, 'bookmanager:forwardinfo:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (67, 78, '图书馆管理', 'bookmanager/libraryinfo', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (68, 67, '查看', NULL, 'bookmanager:libraryinfo:list,bookmanager:libraryinfo:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (69, 67, '新增', NULL, 'bookmanager:libraryinfo:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (70, 67, '修改', NULL, 'bookmanager:libraryinfo:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (71, 67, '删除', NULL, 'bookmanager:libraryinfo:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (72, 78, '书室管理', 'bookmanager/bookaddress', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (73, 72, '查看', NULL, 'bookmanager:bookaddress:list,bookmanager:bookaddress:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (74, 72, '新增', NULL, 'bookmanager:bookaddress:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (75, 72, '修改', NULL, 'bookmanager:bookaddress:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (76, 72, '删除', NULL, 'bookmanager:bookaddress:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (77, 0, '借记管理', '', '', 0, 'sql', 0);
INSERT INTO `sys_menu` VALUES (78, 0, '图书馆管理', '', '', 0, 'menu', 0);

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文件上传' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '图书馆管理员', '', 1, '2022-05-13 20:47:51');
INSERT INTO `sys_role` VALUES (2, '读者', '', 1, '2022-05-13 20:48:20');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 15);
INSERT INTO `sys_role_menu` VALUES (2, 1, 46);
INSERT INTO `sys_role_menu` VALUES (3, 1, 31);
INSERT INTO `sys_role_menu` VALUES (4, 1, 32);
INSERT INTO `sys_role_menu` VALUES (5, 1, 33);
INSERT INTO `sys_role_menu` VALUES (6, 1, 34);
INSERT INTO `sys_role_menu` VALUES (7, 1, 35);
INSERT INTO `sys_role_menu` VALUES (8, 1, 36);
INSERT INTO `sys_role_menu` VALUES (9, 1, 37);
INSERT INTO `sys_role_menu` VALUES (10, 1, 38);
INSERT INTO `sys_role_menu` VALUES (11, 1, 39);
INSERT INTO `sys_role_menu` VALUES (12, 1, 40);
INSERT INTO `sys_role_menu` VALUES (13, 1, 41);
INSERT INTO `sys_role_menu` VALUES (14, 1, 42);
INSERT INTO `sys_role_menu` VALUES (15, 1, 43);
INSERT INTO `sys_role_menu` VALUES (16, 1, 44);
INSERT INTO `sys_role_menu` VALUES (17, 1, 45);
INSERT INTO `sys_role_menu` VALUES (18, 1, 77);
INSERT INTO `sys_role_menu` VALUES (19, 1, 47);
INSERT INTO `sys_role_menu` VALUES (20, 1, 48);
INSERT INTO `sys_role_menu` VALUES (21, 1, 49);
INSERT INTO `sys_role_menu` VALUES (22, 1, 50);
INSERT INTO `sys_role_menu` VALUES (23, 1, 51);
INSERT INTO `sys_role_menu` VALUES (24, 1, 52);
INSERT INTO `sys_role_menu` VALUES (25, 1, 53);
INSERT INTO `sys_role_menu` VALUES (26, 1, 54);
INSERT INTO `sys_role_menu` VALUES (27, 1, 55);
INSERT INTO `sys_role_menu` VALUES (28, 1, 56);
INSERT INTO `sys_role_menu` VALUES (29, 1, 57);
INSERT INTO `sys_role_menu` VALUES (30, 1, 58);
INSERT INTO `sys_role_menu` VALUES (31, 1, 59);
INSERT INTO `sys_role_menu` VALUES (32, 1, 60);
INSERT INTO `sys_role_menu` VALUES (33, 1, 61);
INSERT INTO `sys_role_menu` VALUES (34, 1, 78);
INSERT INTO `sys_role_menu` VALUES (35, 1, 62);
INSERT INTO `sys_role_menu` VALUES (36, 1, 63);
INSERT INTO `sys_role_menu` VALUES (37, 1, 64);
INSERT INTO `sys_role_menu` VALUES (38, 1, 65);
INSERT INTO `sys_role_menu` VALUES (39, 1, 66);
INSERT INTO `sys_role_menu` VALUES (40, 1, 67);
INSERT INTO `sys_role_menu` VALUES (41, 1, 68);
INSERT INTO `sys_role_menu` VALUES (42, 1, 69);
INSERT INTO `sys_role_menu` VALUES (43, 1, 70);
INSERT INTO `sys_role_menu` VALUES (44, 1, 71);
INSERT INTO `sys_role_menu` VALUES (45, 1, 72);
INSERT INTO `sys_role_menu` VALUES (46, 1, 73);
INSERT INTO `sys_role_menu` VALUES (47, 1, 74);
INSERT INTO `sys_role_menu` VALUES (48, 1, 75);
INSERT INTO `sys_role_menu` VALUES (49, 1, 76);
INSERT INTO `sys_role_menu` VALUES (50, 1, -666666);
INSERT INTO `sys_role_menu` VALUES (51, 1, 1);
INSERT INTO `sys_role_menu` VALUES (52, 1, 2);
INSERT INTO `sys_role_menu` VALUES (53, 2, 47);
INSERT INTO `sys_role_menu` VALUES (54, 2, 48);
INSERT INTO `sys_role_menu` VALUES (55, 2, 49);
INSERT INTO `sys_role_menu` VALUES (56, 2, 50);
INSERT INTO `sys_role_menu` VALUES (57, 2, 51);
INSERT INTO `sys_role_menu` VALUES (58, 2, 57);
INSERT INTO `sys_role_menu` VALUES (59, 2, 58);
INSERT INTO `sys_role_menu` VALUES (60, 2, 59);
INSERT INTO `sys_role_menu` VALUES (61, 2, 60);
INSERT INTO `sys_role_menu` VALUES (62, 2, 61);
INSERT INTO `sys_role_menu` VALUES (63, 2, 62);
INSERT INTO `sys_role_menu` VALUES (64, 2, 63);
INSERT INTO `sys_role_menu` VALUES (65, 2, 64);
INSERT INTO `sys_role_menu` VALUES (66, 2, 65);
INSERT INTO `sys_role_menu` VALUES (67, 2, 66);
INSERT INTO `sys_role_menu` VALUES (68, 2, -666666);
INSERT INTO `sys_role_menu` VALUES (69, 2, 77);
INSERT INTO `sys_role_menu` VALUES (70, 2, 78);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '盐',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', 1, 1, '2016-11-11 11:11:11');
INSERT INTO `sys_user` VALUES (2, '张三', '7947b3b1bf742f593711ff3c6666795f8f7321fbf2d9d056c029217c59be62cc', '1gr85HYHbo1eZLmXlvaf', '1314111@qq.com', '13132345676', 1, 1, '2022-05-13 20:52:29');
INSERT INTO `sys_user` VALUES (3, '李四', 'fadd2d84f340a53c9c79a004eb5814148c0a461cb2273ef0c933ecaa2c6675a8', 'jNr1gErUwO4HwQ9TUGUM', '14151616@qq.com', '13123234565', 0, 1, '2022-05-13 20:58:39');
INSERT INTO `sys_user` VALUES (4, '王五', 'dcf2cfc82a1b5dc330cdc07432eec9ece9a856727f167af725207c0c612fb1aa', 'KMYrEKPhvifhg8TIQfJ2', '194433257@qq.com', '13142385657', 1, 1, '2022-05-14 09:48:24');

-- ----------------------------
-- Table structure for sys_user_library
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_library`;
CREATE TABLE `sys_user_library`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NULL DEFAULT NULL,
  `libraryId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_library
-- ----------------------------
INSERT INTO `sys_user_library` VALUES (1, 2, 6);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 2, 1);
INSERT INTO `sys_user_role` VALUES (3, 4, 2);
INSERT INTO `sys_user_role` VALUES (4, 3, 2);

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token`  (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'token',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统用户Token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES (1, '23a076bc7ddb7df52868817f84714769', '2022-05-22 22:41:00', '2022-05-22 10:41:00');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `topic_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目',
  `optionA` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项A',
  `optionB` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项B',
  `optionC` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项C',
  `optionD` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项D',
  `deleted` int(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` datetime(0) NULL DEFAULT NULL COMMENT '新增时间',
  `insert_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增联系人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_name` datetime(0) NULL DEFAULT NULL COMMENT '修改联系人',
  PRIMARY KEY (`topic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES (11, '你喜欢看哪一类的书籍', '哲学艺术', '语言文化', '工业科学', '综合', 0, '2022-05-14 09:47:12', 'admin', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
