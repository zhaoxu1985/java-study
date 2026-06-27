/*
 Navicat Premium Dump SQL

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 90300 (9.3.0)
 Source Host           : localhost:3306
 Source Schema         : spring-study

 Target Server Type    : MySQL
 Target Server Version : 90300 (9.3.0)
 File Encoding         : 65001

 Date: 01/07/2026 18:00:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除 0-未删除 1-已删除',
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `username`, `age`, `create_time`, `update_time`, `deleted`, `version`) VALUES (2069706731180486657, 'zx', NULL, '2026-06-24 16:58:33', '2026-07-01 17:19:19', 0, 1);
INSERT INTO `user` (`id`, `username`, `age`, `create_time`, `update_time`, `deleted`, `version`) VALUES (2069706959853940738, 'zx1', 24, '2026-06-24 16:59:27', '2026-06-24 17:45:15', 1, 0);
INSERT INTO `user` (`id`, `username`, `age`, `create_time`, `update_time`, `deleted`, `version`) VALUES (2069706992422711297, 'zx2', 24, '2026-06-24 16:59:35', '2026-06-24 16:59:35', 0, 0);
INSERT INTO `user` (`id`, `username`, `age`, `create_time`, `update_time`, `deleted`, `version`) VALUES (2069707015046787074, 'zx3', 24, '2026-06-24 16:59:40', '2026-06-24 16:59:40', 0, 0);
INSERT INTO `user` (`id`, `username`, `age`, `create_time`, `update_time`, `deleted`, `version`) VALUES (2069707028728606721, 'zx4', 24, '2026-06-24 16:59:44', '2026-06-24 16:59:44', 0, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
