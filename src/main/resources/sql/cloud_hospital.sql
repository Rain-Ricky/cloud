/*
 Navicat Premium Data Transfer

 Source Server         : Bob
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : cloud_hospital

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 02/06/2020 09:31:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for checkreport
-- ----------------------------
DROP TABLE IF EXISTS `checkreport`;
CREATE TABLE `checkreport`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '检查报告ID',
  `user_id` int(0) NOT NULL COMMENT '患者id',
  `diagnostictype` int(0) NOT NULL COMMENT '诊断类型 1.初诊 2.复诊',
  `Inspectionitems` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '检查项目',
  `Symptom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '症状',
  `diagnosticresult` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '诊断结果',
  `attachment` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '附件',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `me_id` int(0) NULL DEFAULT NULL COMMENT '电子病历ID',
  `seektime` datetime(0) NULL DEFAULT NULL COMMENT '检查时间',
  `de_id` int(0) NULL DEFAULT NULL COMMENT '就诊科室',
  `mianyi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '免疫/组化',
  `datijiancha` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '大体检查',
  `binglizhenduan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '病历诊断',
  `bgys_id` int(0) NULL DEFAULT NULL COMMENT '报告医生',
  `shys_id` int(0) NULL DEFAULT NULL COMMENT '审核医生',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '检查报告表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of checkreport
-- ----------------------------

-- ----------------------------
-- Table structure for consultation
-- ----------------------------
DROP TABLE IF EXISTS `consultation`;
CREATE TABLE `consultation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '患者姓名',
  `gender` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '患者性别',
  `symptom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要症状',
  `drugsused` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所用药物',
  `demand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '你的需求',
  `feedback` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '反馈建议',
  `emp_id` int(0) NULL DEFAULT NULL COMMENT '员工ID',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '健康咨询信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of consultation
-- ----------------------------
INSERT INTO `consultation` VALUES (1, 'bob', '1', '呕吐', '止咳糖浆', NULL, NULL, 33, '2020-05-20 17:05:18', '2020-05-20 17:05:21', 0);
INSERT INTO `consultation` VALUES (2, 'sundy', '1', '头疼', '康比得', NULL, NULL, 34, '2020-05-20 17:06:13', '2020-05-20 17:06:15', 0);
INSERT INTO `consultation` VALUES (3, 'lisi', '0', '拉肚子', '肠炎宁', NULL, NULL, 33, '2020-05-22 14:29:43', '2020-05-22 14:29:45', 0);
INSERT INTO `consultation` VALUES (4, '尔康', '1', '腿抽筋', '拉伸', NULL, NULL, 34, '2020-05-22 14:30:31', '2020-05-22 14:30:35', 0);
INSERT INTO `consultation` VALUES (5, 'demod', NULL, NULL, NULL, NULL, NULL, NULL, '2020-05-27 03:37:17', NULL, 0);
INSERT INTO `consultation` VALUES (6, 'test', NULL, NULL, NULL, NULL, NULL, 33, '2020-05-27 03:37:40', NULL, 0);

-- ----------------------------
-- Table structure for departmentinfo
-- ----------------------------
DROP TABLE IF EXISTS `departmentinfo`;
CREATE TABLE `departmentinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '科室名称',
  `institution_id` int(0) NULL DEFAULT NULL COMMENT '机构id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `departmentname`(`departmentname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '科室信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of departmentinfo
-- ----------------------------
INSERT INTO `departmentinfo` VALUES (33, '骨科', NULL);
INSERT INTO `departmentinfo` VALUES (34, '眼科', NULL);
INSERT INTO `departmentinfo` VALUES (35, '内科', NULL);
INSERT INTO `departmentinfo` VALUES (36, '妇科', NULL);
INSERT INTO `departmentinfo` VALUES (37, '神经科', NULL);
INSERT INTO `departmentinfo` VALUES (38, '精神科', NULL);

-- ----------------------------
-- Table structure for empinfo
-- ----------------------------
DROP TABLE IF EXISTS `empinfo`;
CREATE TABLE `empinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '员工姓名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `birthday` datetime(0) NOT NULL COMMENT '出生日期',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系电话',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '住址',
  `role_id` int(0) NOT NULL COMMENT '角色ID',
  `dep_id` int(0) NULL DEFAULT NULL COMMENT '科室ID',
  `title_id` int(0) NULL DEFAULT NULL COMMENT '职称ID',
  `comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `headimg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '证件照',
  `experience` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工作经历',
  `state` int(0) NOT NULL COMMENT '启用状态 0.禁用 1.启用',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  UNIQUE INDEX `password`(`password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '员工信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of empinfo
-- ----------------------------
INSERT INTO `empinfo` VALUES (33, '张医生', '111111', '2020-04-16 14:40:02', '15700085557', '河南-商丘-夏邑', 1, 33, 33, '医生界的一枝花，抗击新冠肺炎卓有成效', NULL, '5', 1, NULL, NULL);
INSERT INTO `empinfo` VALUES (34, '王医生', '123456', '2020-04-01 15:35:20', '13734741053', '河南-郑州-金水', 1, 34, 33, '医生界的扛把子，抗击新冠肺炎一马当先', NULL, '10', 1, NULL, NULL);

-- ----------------------------
-- Table structure for institutioninfo
-- ----------------------------
DROP TABLE IF EXISTS `institutioninfo`;
CREATE TABLE `institutioninfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `institution_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机构名称',
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `institution_name`(`institution_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '机构信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of institutioninfo
-- ----------------------------

-- ----------------------------
-- Table structure for medicalrecord
-- ----------------------------
DROP TABLE IF EXISTS `medicalrecord`;
CREATE TABLE `medicalrecord`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `record_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '病历编号',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户手机号',
  `department_id` int(0) NULL DEFAULT NULL COMMENT '就诊科室ID',
  `seektime` datetime(0) NULL DEFAULT NULL COMMENT '就诊日期',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '病情描述',
  `checkinfo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '检查结果',
  `guomishi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '过敏史',
  `doc_id` int(0) NULL DEFAULT NULL COMMENT '医生id',
  `diagnosis` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '诊断结果',
  `prescription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处方',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用药详情',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `user_id` int(0) NOT NULL,
  `diagnostictype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '诊断类型',
  `state` int(0) NULL DEFAULT NULL COMMENT '状态  1 启用  0 禁用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  UNIQUE INDEX `record_code`(`record_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '电子病历信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of medicalrecord
-- ----------------------------
INSERT INTO `medicalrecord` VALUES (38, '03797049661', '1500000003', 34, '2019-10-12 00:00:00', '胃部有点炎症', NULL, '无过敏史', 33, '胃穿孔', '吃一些健胃消食片', '一次三片 一天三次', '注意不要喝酒', '2020-04-22 07:17:27', '2020-04-22 07:17:27', 33, NULL, 1);
INSERT INTO `medicalrecord` VALUES (39, '49222424520', '13734741053', 34, '2020-04-16 00:00:00', '眼睛很痛，东西看不清楚', NULL, '无过敏史', 34, '红眼病', '滴光明牌眼药水', '一天三次，一次5ml', '注意不要揉眼睛', '2020-04-22 07:30:08', '2020-04-22 07:30:08', 34, NULL, 1);
INSERT INTO `medicalrecord` VALUES (41, '67359425737', '13734741054', 37, '2020-04-16 00:00:00', '感觉很难受，很恍惚，不清醒', NULL, '无过敏史', 34, '神经衰弱', '住院治疗', '一天一次，一次20分钟', '注意不要情绪过激', '2020-04-22 08:01:28', '2020-04-22 08:01:28', 34, NULL, 1);
INSERT INTO `medicalrecord` VALUES (42, '01179565860', '13734741055', 38, '2020-04-16 00:00:00', '感觉很疼', NULL, '无过敏史', 34, '妇科炎症', '住院治疗', '一天一次，一次20分钟', '注意好好保养', '2020-04-22 08:02:21', '2020-04-22 08:02:21', 34, NULL, 1);
INSERT INTO `medicalrecord` VALUES (44, '38444916294', '17717835504', 38, '2020-01-27 00:00:00', '感冒发烧', NULL, '无过敏史', 34, '轻微感冒', '快克', '一天一次，一次一片', '不要着凉', '2020-04-27 07:09:56', '2020-04-27 07:09:56', 34, NULL, 1);
INSERT INTO `medicalrecord` VALUES (45, '91742568033', '18939268075', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-05-25 09:37:34', NULL, 34, NULL, 1);

-- ----------------------------
-- Table structure for model
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '模块ID',
  `parent_id` int(0) NULL DEFAULT NULL COMMENT '父模块id',
  `model_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模块名称',
  `model_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '跳转页面路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模块信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of model
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `permission_name` int(0) NOT NULL COMMENT '权限名称',
  `model_id` int(0) NOT NULL COMMENT '模块ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '处方ID',
  `user_id` int(0) NOT NULL COMMENT '患者id',
  `record_id` int(0) NOT NULL COMMENT '病历id',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处方内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '处方信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of prescription
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `role_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `permission_id` int(0) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for subsystem
-- ----------------------------
DROP TABLE IF EXISTS `subsystem`;
CREATE TABLE `subsystem`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '子系统ID',
  `system_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '系统名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '子系统信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subsystem
-- ----------------------------

-- ----------------------------
-- Table structure for titleinfo
-- ----------------------------
DROP TABLE IF EXISTS `titleinfo`;
CREATE TABLE `titleinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `titlename` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '职称名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `titlename`(`titlename`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '职称信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of titleinfo
-- ----------------------------
INSERT INTO `titleinfo` VALUES (32, '主任');
INSERT INTO `titleinfo` VALUES (33, '医生');
INSERT INTO `titleinfo` VALUES (34, '护士');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `role_id` int(0) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户姓名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `roleid` int(0) NOT NULL COMMENT '角色ID 1.超级管理员 2.普通用户 3.医生 4.护士',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号码',
  `validatecode` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `cid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `birthday` datetime(0) NOT NULL COMMENT '出生日期',
  `gender` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别 0.女 1.男',
  `di_type` int(0) NULL DEFAULT NULL COMMENT '1.检查/诊断 2. 治疗/手术 3.复诊',
  `frontimg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证正面照',
  `backimg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证反面照',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '住址',
  `bedno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '病床号',
  `departmentid` int(0) NULL DEFAULT NULL COMMENT '科室id',
  `doctorid` int(0) NULL DEFAULT NULL COMMENT '主治医生id',
  `nurseid` int(0) NULL DEFAULT NULL COMMENT '责任护士id',
  `instatus` int(0) NULL DEFAULT NULL COMMENT '住院状态 1.未住院 2.预住院 3.住院中 4.已出院',
  `state` int(0) NOT NULL COMMENT '启用状态 0.禁用 1.启用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  UNIQUE INDEX `cid`(`cid`) USING BTREE,
  UNIQUE INDEX `bedno`(`bedno`) USING BTREE,
  UNIQUE INDEX `departmentid`(`departmentid`) USING BTREE,
  UNIQUE INDEX `doctorid`(`doctorid`) USING BTREE,
  UNIQUE INDEX `nurseid`(`nurseid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (33, 'lisi', '123456', 1, '17717835504', '', '2147483647', '2020-04-01 10:04:08', '1', NULL, 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3497380956,3644779616&fm=26&gp=0.jpg', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3387134982,2837425777&fm=26&gp=0.jpg', '河南省-商丘市', '', NULL, 33, NULL, NULL, 1);
INSERT INTO `userinfo` VALUES (34, 'wangwu', '123456', 1, '13734741053', NULL, '15262919956789003', '2020-04-01 15:33:30', '1', NULL, 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3497380956,3644779616&fm=26&gp=0.jpg', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3387134982,2837425777&fm=26&gp=0.jpg', '河南省-郑州市', NULL, NULL, 34, NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
