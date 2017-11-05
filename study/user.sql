/*
Navicat MySQL Data Transfer

Source Server         : PMS
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-03-07 16:14:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `mail` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '曾子墨', '123456', '25', 'zimo@163.com');
INSERT INTO `user` VALUES ('2', '吴神', '234456', '24', 'shentong@alibaba.com');
INSERT INTO `user` VALUES ('3', '张岩', '654321', '23', 'zhangyan@qq.com');
INSERT INTO `user` VALUES ('4', '武松', '12wsas', '45', 'wusong@qq.com');
INSERT INTO `user` VALUES ('5', '孙悟空', 'qwert', '5000', 'wukong@163.com');
INSERT INTO `user` VALUES ('6', '孙燕姿', 'yanzi', '29', 'lvguang@meili.com');
INSERT INTO `user` VALUES ('7', '京东', 'JD', '15', 'jd@jd.com');
INSERT INTO `user` VALUES ('8', '淘宝', 'taobao', '19', 'mayun@taobao.com');
INSERT INTO `user` VALUES ('9', '蘑菇街', 'mogujie', '6', 'mogujie@mg.com');
INSERT INTO `user` VALUES ('10', '当当', 'dangdang', '11', 'dangdang@wuxi.com');
INSERT INTO `user` VALUES ('11', 'facebook', 'facebook', '12', 'facebook@fb.com');
