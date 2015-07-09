/*
Navicat MySQL Data Transfer

Source Server         : srtp
Source Server Version : 50543
Source Host           : localhost:3306
Source Database       : srtp

Target Server Type    : MYSQL
Target Server Version : 50543
File Encoding         : 65001

Date: 2015-07-09 20:59:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_achievemen_type
-- ----------------------------
DROP TABLE IF EXISTS `t_achievemen_type`;
CREATE TABLE `t_achievemen_type` (
  `achievementype_id` varchar(36) NOT NULL,
  `achievementype_introduction` varchar(200) DEFAULT NULL,
  `achievementype_name` varchar(50) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`achievementype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_achievemen_type
-- ----------------------------

-- ----------------------------
-- Table structure for t_achievement
-- ----------------------------
DROP TABLE IF EXISTS `t_achievement`;
CREATE TABLE `t_achievement` (
  `achievement_id` varchar(36) NOT NULL,
  `achievement_date` datetime DEFAULT NULL,
  `achievement_introduction` varchar(200) DEFAULT NULL,
  `achievement_journal` varchar(50) DEFAULT NULL,
  `achievement_name` varchar(50) DEFAULT NULL,
  `achievement_owner` varchar(50) DEFAULT NULL,
  `achievement_patent` varchar(50) DEFAULT NULL,
  `achievement_type` varchar(50) DEFAULT NULL,
  `achievement_volume` varchar(50) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `userdefine1` varchar(100) DEFAULT NULL,
  `userdefine10` varchar(100) DEFAULT NULL,
  `userdefine11` varchar(100) DEFAULT NULL,
  `userdefine12` varchar(100) DEFAULT NULL,
  `userdefine13` varchar(100) DEFAULT NULL,
  `userdefine14` varchar(100) DEFAULT NULL,
  `userdefine15` varchar(100) DEFAULT NULL,
  `userdefine16` varchar(100) DEFAULT NULL,
  `userdefine17` varchar(100) DEFAULT NULL,
  `userdefine18` varchar(100) DEFAULT NULL,
  `userdefine19` varchar(100) DEFAULT NULL,
  `userdefine2` varchar(100) DEFAULT NULL,
  `userdefine20` varchar(100) DEFAULT NULL,
  `userdefine21` varchar(100) DEFAULT NULL,
  `userdefine22` varchar(100) DEFAULT NULL,
  `userdefine23` varchar(100) DEFAULT NULL,
  `userdefine24` varchar(100) DEFAULT NULL,
  `userdefine25` varchar(100) DEFAULT NULL,
  `userdefine26` varchar(100) DEFAULT NULL,
  `userdefine27` varchar(100) DEFAULT NULL,
  `userdefine28` varchar(100) DEFAULT NULL,
  `userdefine29` varchar(100) DEFAULT NULL,
  `userdefine3` varchar(100) DEFAULT NULL,
  `userdefine30` varchar(100) DEFAULT NULL,
  `userdefine31` varchar(100) DEFAULT NULL,
  `userdefine32` varchar(100) DEFAULT NULL,
  `userdefine33` varchar(100) DEFAULT NULL,
  `userdefine34` varchar(100) DEFAULT NULL,
  `userdefine35` varchar(100) DEFAULT NULL,
  `userdefine36` varchar(100) DEFAULT NULL,
  `userdefine37` varchar(100) DEFAULT NULL,
  `userdefine38` varchar(100) DEFAULT NULL,
  `userdefine39` varchar(100) DEFAULT NULL,
  `userdefine4` varchar(100) DEFAULT NULL,
  `userdefine40` varchar(100) DEFAULT NULL,
  `userdefine41` varchar(100) DEFAULT NULL,
  `userdefine42` varchar(100) DEFAULT NULL,
  `userdefine43` varchar(100) DEFAULT NULL,
  `userdefine44` varchar(100) DEFAULT NULL,
  `userdefine45` varchar(100) DEFAULT NULL,
  `userdefine46` varchar(100) DEFAULT NULL,
  `userdefine47` varchar(100) DEFAULT NULL,
  `userdefine48` varchar(100) DEFAULT NULL,
  `userdefine49` varchar(100) DEFAULT NULL,
  `userdefine5` varchar(100) DEFAULT NULL,
  `userdefine50` varchar(100) DEFAULT NULL,
  `userdefine6` varchar(100) DEFAULT NULL,
  `userdefine7` varchar(100) DEFAULT NULL,
  `userdefine8` varchar(100) DEFAULT NULL,
  `userdefine9` varchar(100) DEFAULT NULL,
  `achievementype_id` varchar(36) DEFAULT NULL,
  `project_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`achievement_id`),
  KEY `FK_10j8bb6pi6gy0bkdwvpyg5p4p` (`achievementype_id`),
  KEY `FK_t7wau4biwi1umgjymmuw0lln3` (`project_id`),
  CONSTRAINT `FK_10j8bb6pi6gy0bkdwvpyg5p4p` FOREIGN KEY (`achievementype_id`) REFERENCES `t_achievemen_type` (`achievementype_id`),
  CONSTRAINT `FK_t7wau4biwi1umgjymmuw0lln3` FOREIGN KEY (`project_id`) REFERENCES `t_project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_achievement
-- ----------------------------

-- ----------------------------
-- Table structure for t_announ_type
-- ----------------------------
DROP TABLE IF EXISTS `t_announ_type`;
CREATE TABLE `t_announ_type` (
  `announ_type_id` varchar(36) NOT NULL,
  `announ_type_name` varchar(100) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`announ_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_announ_type
-- ----------------------------
INSERT INTO `t_announ_type` VALUES ('1', '教务处公告', 'N');
INSERT INTO `t_announ_type` VALUES ('2', '学院公告', 'N');
INSERT INTO `t_announ_type` VALUES ('3', '学生公告', 'N');
INSERT INTO `t_announ_type` VALUES ('4', '教师公告', 'N');

-- ----------------------------
-- Table structure for t_announcement
-- ----------------------------
DROP TABLE IF EXISTS `t_announcement`;
CREATE TABLE `t_announcement` (
  `announ_id` varchar(36) NOT NULL,
  `announ_content` varchar(4000) DEFAULT NULL,
  `announ_title` varchar(200) DEFAULT NULL,
  `check_state` varchar(2) DEFAULT NULL,
  `check_time` datetime DEFAULT NULL,
  `checker_code` varchar(32) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `publish_state` varchar(2) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `publisher_code` varchar(32) DEFAULT NULL,
  `publisher_role` varchar(32) DEFAULT NULL,
  `announ_type_id` varchar(36) DEFAULT NULL,
  `publisher_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`announ_id`),
  KEY `FK_hkctvy68fhcnaud51do4kgpfh` (`announ_type_id`),
  CONSTRAINT `FK_hkctvy68fhcnaud51do4kgpfh` FOREIGN KEY (`announ_type_id`) REFERENCES `t_announ_type` (`announ_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_announcement
-- ----------------------------
INSERT INTO `t_announcement` VALUES ('ff8081814e72b2e4014e72e15af40012', '<p>输入您的公告内容......</p>', 'stu1', 'CY', null, null, 'N', 'Y', '2015-07-09 20:53:40', '06', '06', '3', 'stu1');

-- ----------------------------
-- Table structure for t_attachment
-- ----------------------------
DROP TABLE IF EXISTS `t_attachment`;
CREATE TABLE `t_attachment` (
  `atta_id` varchar(36) NOT NULL,
  `file_format` varchar(150) DEFAULT NULL,
  `file_name` varchar(100) DEFAULT NULL,
  `file_size` decimal(19,2) DEFAULT NULL,
  `file_url` varchar(150) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `object_code` varchar(36) DEFAULT NULL,
  `upload_time` datetime DEFAULT NULL,
  `uploader_role` varchar(36) DEFAULT NULL,
  `atta_type_id` varchar(36) DEFAULT NULL,
  `uploader_code` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`atta_id`),
  KEY `FK_smog5c8kk7mrh9d741dot3odu` (`atta_type_id`),
  KEY `FK_c2m8luooeo244d0sv8ogiir3c` (`uploader_code`),
  CONSTRAINT `FK_c2m8luooeo244d0sv8ogiir3c` FOREIGN KEY (`uploader_code`) REFERENCES `t_user` (`user_id`),
  CONSTRAINT `FK_smog5c8kk7mrh9d741dot3odu` FOREIGN KEY (`atta_type_id`) REFERENCES `t_attchment_type` (`atta_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for t_attchment_type
-- ----------------------------
DROP TABLE IF EXISTS `t_attchment_type`;
CREATE TABLE `t_attchment_type` (
  `atta_type_id` varchar(36) NOT NULL,
  `atta_type_name` varchar(50) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`atta_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_attchment_type
-- ----------------------------
INSERT INTO `t_attchment_type` VALUES ('1', '申报文档', 'N');
INSERT INTO `t_attchment_type` VALUES ('2', '公告文档', 'N');

-- ----------------------------
-- Table structure for t_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority` (
  `id` varchar(36) NOT NULL,
  `path` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_authority
-- ----------------------------
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0060', 'announcement/mine', '我的公告', '可以查看在自己角色可见的公告');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0061', 'announcement/publish', '发布公告', '可以发布公告');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0064', 'announcement/maintain', '维护公告', '可以维护所有公告');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0070', 'declare/mine', '我的申报', '查看与我相关的申报');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0071', 'declare/apply', '项目申报', '可以进行项目的省报');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0072', 'declare/list', '申报列表', '查看自己可以查看的申报列表');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0073', 'declare/review/mine', '我的评审', '查看与我相关的评审');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0074', 'declare/expert/create', '创建申报专家团队', '有权限创建申请专家团队');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0075', 'declare/expert/list', '查看申报专家团队', '查看申报专家团队');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0076', 'declare/expert/history', '历史申报专家团队', '可以查看申报阶段历史专家团队');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0077', 'declare/expert/distribute', '分配申报专家', '可以将专家团里的专家分配到项目组');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0078', 'declare/review/organize', '组织申报评审', '可以组织申报评审');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0079', 'declare/result/input', '申报结果录入', '可以录入申报结果');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef007a', 'declare/result/review', '申报结果审核', '可以进行申报结果审核');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0080', 'project/mine', '我的项目', '可以查看与我相关的正在运作的项目');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0081', 'project/list', '项目列表', '查看当前角色可以查看的项目列表');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0089', 'final/mine', '我的结题', '查看我的结题');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0090', 'final/apply', '申请结题', '可以进行项目结题的申请');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0091', 'final/list', '结题列表', '查看当前角色可以查看的结题列表');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0092', 'final/review/mine', '我的评审', '可以查看跟我有关系的评审');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0093', 'final/review/organize', '组织结题评审', '可以组织结题评审');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0094', 'final/expert/create', '创建结题专家团队', '可以创建结题专家团队');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0095', 'final/expert/list', '查看结题专家团队', '可以查看结题专家团队');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0096', 'final/expert/history', '历史结题专家团队', '可以查看结题历史专家团队');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0097', 'final/expert/distribute', '分派结题专家', '可以分配结题专家');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0098', 'final/result/input', '结题结果录入', '可以结题结果录入');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef0099', 'final/result/review', '结题结果审核', '可以审核结题结果');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef00a0', 'statistic/grade', '成绩分布', '查看结题项目的成绩分布');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef00a1', 'statistic/index', '指标统计', '可以进行指标统计');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef00b0', 'knowledge', '知识库管理', '知识库管理');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef00e0', 'system/authority', '角色权限管理', '管理角色拥有的权限');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef00e1', 'system/role', '用户角色管理', '管理用户所属的角色');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef00e2', 'system/user', '用户信息维护', '可以进行用户信息维护');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef00e3', 'system/period', '届期管理', '管理当前所在届期');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef00e4', 'system/journal', '日志管理', '可以查看日志');
INSERT INTO `t_authority` VALUES ('4028ab864e54db0c014e54db7bef00f0', 'user/modify', '个人信息修改', '维护自己的个人信息');

-- ----------------------------
-- Table structure for t_code
-- ----------------------------
DROP TABLE IF EXISTS `t_code`;
CREATE TABLE `t_code` (
  `encode_id` varchar(36) NOT NULL,
  `encode_desc` varchar(20) DEFAULT NULL,
  `encode_remark` varchar(20) DEFAULT NULL,
  `encode_value` varchar(2) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`encode_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_code
-- ----------------------------

-- ----------------------------
-- Table structure for t_credit
-- ----------------------------
DROP TABLE IF EXISTS `t_credit`;
CREATE TABLE `t_credit` (
  `credit_id` varchar(36) NOT NULL,
  `credit_contribution` int(11) DEFAULT NULL,
  `credit_score` float DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `project_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`credit_id`),
  KEY `FK_99l30r5812g8xawt2krju4lxe` (`project_id`),
  CONSTRAINT `FK_99l30r5812g8xawt2krju4lxe` FOREIGN KEY (`project_id`) REFERENCES `t_project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_credit
-- ----------------------------

-- ----------------------------
-- Table structure for t_decl_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_decl_comment`;
CREATE TABLE `t_decl_comment` (
  `decl_com_id` varchar(36) NOT NULL,
  `comp_eval` varchar(5) DEFAULT NULL,
  `decl_argument` varchar(500) DEFAULT NULL,
  `decl_score` int(11) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `review_time` datetime DEFAULT NULL,
  `ex_review_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`decl_com_id`),
  KEY `FK_o8g0q9k35nsm10iyycjmv4rm3` (`ex_review_id`),
  CONSTRAINT `FK_o8g0q9k35nsm10iyycjmv4rm3` FOREIGN KEY (`ex_review_id`) REFERENCES `t_expert_review` (`ex_review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_decl_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_decl_fund
-- ----------------------------
DROP TABLE IF EXISTS `t_decl_fund`;
CREATE TABLE `t_decl_fund` (
  `decl_fund_id` varchar(36) NOT NULL,
  `amount` float DEFAULT NULL,
  `fund_content` varchar(200) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `serial_num` varchar(2) DEFAULT NULL,
  `declar_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`decl_fund_id`),
  KEY `FK_8sbv4w9u5fokdbgv5rnho01dv` (`declar_id`),
  CONSTRAINT `FK_8sbv4w9u5fokdbgv5rnho01dv` FOREIGN KEY (`declar_id`) REFERENCES `t_declaration` (`declar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_decl_fund
-- ----------------------------

-- ----------------------------
-- Table structure for t_decl_job
-- ----------------------------
DROP TABLE IF EXISTS `t_decl_job`;
CREATE TABLE `t_decl_job` (
  `job_id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `job_content` varchar(500) DEFAULT NULL,
  `declar_id` varchar(36) DEFAULT NULL,
  `student_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `FK_63a61js7xlj42io05gk4gj4os` (`declar_id`),
  KEY `FK_pdhky77w5h0tubadp92i5w2dx` (`student_id`),
  CONSTRAINT `FK_63a61js7xlj42io05gk4gj4os` FOREIGN KEY (`declar_id`) REFERENCES `t_declaration` (`declar_id`),
  CONSTRAINT `FK_pdhky77w5h0tubadp92i5w2dx` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_decl_job
-- ----------------------------

-- ----------------------------
-- Table structure for t_declaration
-- ----------------------------
DROP TABLE IF EXISTS `t_declaration`;
CREATE TABLE `t_declaration` (
  `declar_id` varchar(36) NOT NULL,
  `check_state` varchar(2) DEFAULT NULL,
  `decl_time` datetime DEFAULT NULL,
  `end_on` datetime DEFAULT NULL,
  `exp_result` varchar(500) DEFAULT NULL,
  `exp_target` varchar(500) DEFAULT NULL,
  `inno_point` varchar(1000) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `lab_level` varchar(20) DEFAULT NULL,
  `lab_name` varchar(50) DEFAULT NULL,
  `member_amount` int(11) DEFAULT NULL,
  `pro_adv` varchar(1000) DEFAULT NULL,
  `PRO_FUND` double DEFAULT NULL,
  `pro_intro` varchar(500) DEFAULT NULL,
  `pro_name` varchar(50) DEFAULT NULL,
  `pro_plan` varchar(1000) DEFAULT NULL,
  `pro_serial` varchar(30) DEFAULT NULL,
  `PRO_TYPE` varchar(2) DEFAULT NULL,
  `res_condition` varchar(1000) DEFAULT NULL,
  `res_content` varchar(1000) DEFAULT NULL,
  `res_program` varchar(1000) DEFAULT NULL,
  `REVIEW_OPINION` varchar(500) DEFAULT NULL,
  `REVIEW_RESULT` varchar(2) DEFAULT NULL,
  `start_on` datetime DEFAULT NULL,
  `jq_id` varchar(36) DEFAULT NULL,
  `leader_code` varchar(36) DEFAULT NULL,
  `member1_code` varchar(36) DEFAULT NULL,
  `member2_code` varchar(36) DEFAULT NULL,
  `teacher1_code` varchar(36) DEFAULT NULL,
  `teacher2_code` varchar(36) DEFAULT NULL,
  `college` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`declar_id`),
  KEY `FK_c5jxvlwwb7jph80ur0cgwsmx3` (`jq_id`),
  KEY `FK_nouy120olsqyf15mosqr8k6yt` (`leader_code`),
  KEY `FK_k6qd7d9guspi87bcs46kk5rg3` (`member1_code`),
  KEY `FK_1940k2p08vcim5jptl3ntoeyr` (`member2_code`),
  KEY `FK_bj4wib541sebl6v0ghyqtls7v` (`teacher1_code`),
  KEY `FK_8i31ktexp4oywwt0rydlyop51` (`teacher2_code`),
  KEY `FK_8lyc76ssowymcrrsusg6ukx89` (`college`),
  CONSTRAINT `FK_1940k2p08vcim5jptl3ntoeyr` FOREIGN KEY (`member2_code`) REFERENCES `t_student` (`student_id`),
  CONSTRAINT `FK_8i31ktexp4oywwt0rydlyop51` FOREIGN KEY (`teacher2_code`) REFERENCES `t_teacher` (`tea_id`),
  CONSTRAINT `FK_8lyc76ssowymcrrsusg6ukx89` FOREIGN KEY (`college`) REFERENCES `t_unit` (`unit_id`),
  CONSTRAINT `FK_bj4wib541sebl6v0ghyqtls7v` FOREIGN KEY (`teacher1_code`) REFERENCES `t_teacher` (`tea_id`),
  CONSTRAINT `FK_c5jxvlwwb7jph80ur0cgwsmx3` FOREIGN KEY (`jq_id`) REFERENCES `t_jieqi` (`jq_id`),
  CONSTRAINT `FK_k6qd7d9guspi87bcs46kk5rg3` FOREIGN KEY (`member1_code`) REFERENCES `t_student` (`student_id`),
  CONSTRAINT `FK_nouy120olsqyf15mosqr8k6yt` FOREIGN KEY (`leader_code`) REFERENCES `t_student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_declaration
-- ----------------------------
INSERT INTO `t_declaration` VALUES ('8a7d2c914e569ca0014e5703416e0002', '03', '2015-07-04 14:35:57', '2015-07-11 00:00:00', '', '', '', 'N', '01', '111', '11', '', '1', '', '11', '', '2015-1-1001', '01', '', '', '', '   ', null, '2015-07-04 00:00:00', '1', '06', null, null, '05', null, '1');

-- ----------------------------
-- Table structure for t_email
-- ----------------------------
DROP TABLE IF EXISTS `t_email`;
CREATE TABLE `t_email` (
  `email_id` varchar(36) NOT NULL,
  `creat_on` datetime DEFAULT NULL,
  `email_content` varchar(1000) DEFAULT NULL,
  `email_secret` varchar(20) DEFAULT NULL,
  `email_title` varchar(200) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `send_on` datetime DEFAULT NULL,
  `send_state` varchar(4) DEFAULT NULL,
  `sender` varchar(100) DEFAULT NULL,
  `jq_id` varchar(36) DEFAULT NULL,
  `tea_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`email_id`),
  KEY `FK_g17qcuv1q9k3ig4lw6b69atun` (`jq_id`),
  KEY `FK_mvptbn4wk3caluam1jemhc55m` (`tea_id`),
  CONSTRAINT `FK_g17qcuv1q9k3ig4lw6b69atun` FOREIGN KEY (`jq_id`) REFERENCES `t_jieqi` (`jq_id`),
  CONSTRAINT `FK_mvptbn4wk3caluam1jemhc55m` FOREIGN KEY (`tea_id`) REFERENCES `t_teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_email
-- ----------------------------
INSERT INTO `t_email` VALUES ('4028ab864e70a456014e70c2cc630000', '2015-07-09 11:01:31', 'sdafasdf', 'zkq.2015', 'sdafasd', 'N', '2015-07-09 11:01:31', 'true', '1191482087@qq.com', '1', '03');
INSERT INTO `t_email` VALUES ('4028ab864e70a456014e70e2b3d40001', '2015-07-09 11:36:22', 'sdafdasfdsafasd', 'zkq.2015', 'sdaf', 'N', '2015-07-09 11:36:22', 'true', '1191482087@qq.com', '1', '00');
INSERT INTO `t_email` VALUES ('4028ab864e70a456014e70e4227f0002', '2015-07-09 11:37:56', 'dsaf', 'zkq.2015', 'asdf', 'N', '2015-07-09 11:37:56', 'true', '1191482087@qq.com', '1', '00');
INSERT INTO `t_email` VALUES ('4028ab864e70a456014e70e676190004', '2015-07-09 11:40:28', 'asdfdas', 'zkq.2015', 'asdf', 'N', '2015-07-09 11:40:28', 'true', '1191482087@qq.com', '1', '00');
INSERT INTO `t_email` VALUES ('4028ab864e70a456014e71804f97000a', '2015-07-09 14:28:31', 'dsafdasf', 'zkq.2015', 'asdfdsa', 'N', '2015-07-09 14:28:31', 'true', '1191482087@qq.com', '1', '00');
INSERT INTO `t_email` VALUES ('4028ab864e70a456014e7181c7c2000b', '2015-07-09 14:30:07', 'sdaf', 'zkq.2015', 'asdfdas', 'N', '2015-07-09 14:30:07', 'true', '1191482087@qq.com', '1', '00');
INSERT INTO `t_email` VALUES ('4028ab864e70a456014e7181d9e4000c', '2015-07-09 14:30:12', 'sdaf', 'zkq.2015', 'asdfdas', 'N', '2015-07-09 14:30:12', 'true', '1191482087@qq.com', '1', '00');
INSERT INTO `t_email` VALUES ('4028ab864e70a456014e71826719000d', '2015-07-09 14:30:48', 'sdafdsa', 'zkq.2015', 'adsfdas', 'N', '2015-07-09 14:30:48', 'true', '1191482087@qq.com', '1', '00');
INSERT INTO `t_email` VALUES ('4028ab864e70a456014e7182ff51000f', '2015-07-09 14:31:27', 'asdfasdf', 'zkq.2015', 'asdf', 'N', '2015-07-09 14:31:27', 'true', '1191482087@qq.com', '1', '00');
INSERT INTO `t_email` VALUES ('4028ab864e718fc9014e7190c5cd0000', '2015-07-09 14:46:30', 'asdfdsaf', 'zkq.2015', 'asdfdas', 'N', '2015-07-09 14:46:30', 'true', '1191482087@qq.com', '1', '00');
INSERT INTO `t_email` VALUES ('4028ab864e718fc9014e719215250001', '2015-07-09 14:47:55', 'dsafdsafasd', 'zkq.2015', 'sdafasd', 'N', '2015-07-09 14:47:55', 'true', '1191482087@qq.com', '1', '00');
INSERT INTO `t_email` VALUES ('8a7df19e4e6646cf014e664831d60000', '2015-07-07 10:11:24', 'derewrewrwrwwerrewr', '101356lichao', '12323', 'N', '2015-07-07 10:11:24', 'true', 'superlee2013@163.com', '1', '03');
INSERT INTO `t_email` VALUES ('8a7df19e4e6655c5014e6659e52b0000', '2015-07-07 10:30:44', 'dasdqweqwadasd', '101356lichao', 'testMail', 'N', '2015-07-07 10:30:44', 'true', 'superlee2013@163.com', '1', '03');
INSERT INTO `t_email` VALUES ('8a7df19e4e6655c5014e665c0b0a0001', '2015-07-07 10:33:05', '邮件群发', 'zkq.2015', 'testMail', 'N', '2015-07-07 10:33:05', 'true', 'superlee2013@163.com', '1', '03');
INSERT INTO `t_email` VALUES ('8a7df19e4e6655c5014e66606fc30002', '2015-07-07 10:37:53', '邮件群发', 'zkq.2015', 'testMail', 'N', '2015-07-07 10:37:53', 'true', 'superlee2013@163.com', '1', '03');
INSERT INTO `t_email` VALUES ('8a7df19e4e666d37014e666e0d8b0000', '2015-07-07 10:52:45', 'adaseqewq', '101356lichao', 'dsda', 'N', '2015-07-07 10:52:45', 'true', 'superlee2013@163.com', '1', '03');
INSERT INTO `t_email` VALUES ('8a7df19e4e666d37014e6670b4e60001', '2015-07-07 10:55:39', '群发邮件', 'zkq.2015', 'testMail', 'N', '2015-07-07 10:55:39', 'true', 'superlee2013@163.com', '1', '03');
INSERT INTO `t_email` VALUES ('8a7df19e4e666d37014e66768d550002', '2015-07-07 11:02:02', '群发邮件', 'zkq.2015', 'testMail', 'N', '2015-07-07 11:02:02', 'true', 'superlee2013@163.com', '1', '03');
INSERT INTO `t_email` VALUES ('8a7df19e4e666d37014e66768d720003', '2015-07-07 11:02:02', '群发邮件', 'zkq.2015', 'testMail', 'N', '2015-07-07 11:02:02', 'true', 'superlee2013@163.com', '1', '03');
INSERT INTO `t_email` VALUES ('8a7df19e4e666d37014e66779a810004', '2015-07-07 11:03:11', '群发邮件', 'zkq.2015', 'testMail', 'N', '2015-07-07 11:03:11', 'true', 'superlee2013@163.com', '1', '03');
INSERT INTO `t_email` VALUES ('8a7df19e4e666d37014e6696417a0005', '2015-07-07 11:34:35', '群发邮件', 'zkq.2015', 'testMail', 'N', '2015-07-07 11:34:36', 'true', 'superlee2013@163.com', '1', '03');

-- ----------------------------
-- Table structure for t_email_receiver
-- ----------------------------
DROP TABLE IF EXISTS `t_email_receiver`;
CREATE TABLE `t_email_receiver` (
  `receiver_id` varchar(36) NOT NULL,
  `email_address` varchar(100) DEFAULT NULL,
  `is_received` varchar(4) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `receiver_code` varchar(32) DEFAULT NULL,
  `receiver_role` varchar(20) DEFAULT NULL,
  `email_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`receiver_id`),
  KEY `FK_6q0u6fs9upjj87e7d89gdjfc1` (`email_id`),
  CONSTRAINT `FK_6q0u6fs9upjj87e7d89gdjfc1` FOREIGN KEY (`email_id`) REFERENCES `t_email` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_email_receiver
-- ----------------------------

-- ----------------------------
-- Table structure for t_end_project
-- ----------------------------
DROP TABLE IF EXISTS `t_end_project`;
CREATE TABLE `t_end_project` (
  `endProject_id` varchar(36) NOT NULL,
  `endProject_comment` varchar(1000) DEFAULT NULL,
  `endProject_content` varchar(1000) DEFAULT NULL,
  `endProject_credit` float DEFAULT NULL,
  `endProject_innovate` varchar(1000) DEFAULT NULL,
  `endProject_introduction` varchar(1000) DEFAULT NULL,
  `endProject_method` varchar(1000) DEFAULT NULL,
  `endProject_name` varchar(50) DEFAULT NULL,
  `endProject_number` varchar(20) DEFAULT NULL,
  `endProject_passApply` varchar(2) DEFAULT NULL,
  `endProject_problem` varchar(1000) DEFAULT NULL,
  `endProject_score` varchar(10) DEFAULT NULL,
  `endProject_sense` varchar(1000) DEFAULT NULL,
  `endProject_state` varchar(2) DEFAULT NULL,
  `endProject_summary` varchar(1000) DEFAULT NULL,
  `endProject_work` varchar(1000) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `last_comment` varchar(1000) DEFAULT NULL,
  `last_score` varchar(10) DEFAULT NULL,
  `SCHOOL_TYPEIN_TIME` datetime DEFAULT NULL,
  `SUBMIT_TIME` datetime DEFAULT NULL,
  `UNIT_TYPEIN_TIME` datetime DEFAULT NULL,
  `jq_id` varchar(36) DEFAULT NULL,
  `project_id` varchar(36) DEFAULT NULL,
  `UNIT_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`endProject_id`),
  KEY `FK_l7mom1i5kw65fjpg93uk4u4nf` (`jq_id`),
  KEY `FK_68qiv9ejkmq59e6etwvs0i4o8` (`project_id`),
  KEY `FK_g9r94drw2kh8kii43bgoxk4fk` (`UNIT_ID`),
  CONSTRAINT `FK_68qiv9ejkmq59e6etwvs0i4o8` FOREIGN KEY (`project_id`) REFERENCES `t_project` (`project_id`),
  CONSTRAINT `FK_g9r94drw2kh8kii43bgoxk4fk` FOREIGN KEY (`UNIT_ID`) REFERENCES `t_unit` (`unit_id`),
  CONSTRAINT `FK_l7mom1i5kw65fjpg93uk4u4nf` FOREIGN KEY (`jq_id`) REFERENCES `t_jieqi` (`jq_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_end_project
-- ----------------------------

-- ----------------------------
-- Table structure for t_end_project_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_end_project_comment`;
CREATE TABLE `t_end_project_comment` (
  `id` varchar(36) NOT NULL,
  `endProjectComment_advise` varchar(200) DEFAULT NULL,
  `endProjectComment_content` varchar(5) DEFAULT NULL,
  `endProjectComment_score` int(11) DEFAULT NULL,
  `endProjectComment_time` datetime DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `EProjectExport_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jxdp69tiyqenifbgl1ncm8gvx` (`EProjectExport_id`),
  CONSTRAINT `FK_jxdp69tiyqenifbgl1ncm8gvx` FOREIGN KEY (`EProjectExport_id`) REFERENCES `t_end_project_export` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_end_project_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_end_project_export
-- ----------------------------
DROP TABLE IF EXISTS `t_end_project_export`;
CREATE TABLE `t_end_project_export` (
  `id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `endProject_id` varchar(36) DEFAULT NULL,
  `expert_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_532mw80la1h898xpnocr09tw9` (`endProject_id`),
  KEY `FK_ik138wrxvaecpu042ypamloow` (`expert_id`),
  CONSTRAINT `FK_532mw80la1h898xpnocr09tw9` FOREIGN KEY (`endProject_id`) REFERENCES `t_end_project` (`endProject_id`),
  CONSTRAINT `FK_ik138wrxvaecpu042ypamloow` FOREIGN KEY (`expert_id`) REFERENCES `t_expert_teacher` (`ex_tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_end_project_export
-- ----------------------------

-- ----------------------------
-- Table structure for t_end_project_job
-- ----------------------------
DROP TABLE IF EXISTS `t_end_project_job`;
CREATE TABLE `t_end_project_job` (
  `job_id` varchar(36) NOT NULL,
  `finished` varchar(50) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `job_content` varchar(500) DEFAULT NULL,
  `endProject_id` varchar(36) DEFAULT NULL,
  `student_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `FK_mt81ifd5c65b043qbrc4hs6ew` (`endProject_id`),
  KEY `FK_a74jqdpvex1u8h5rmejpd8rwf` (`student_id`),
  CONSTRAINT `FK_a74jqdpvex1u8h5rmejpd8rwf` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`),
  CONSTRAINT `FK_mt81ifd5c65b043qbrc4hs6ew` FOREIGN KEY (`endProject_id`) REFERENCES `t_end_project` (`endProject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_end_project_job
-- ----------------------------

-- ----------------------------
-- Table structure for t_expert_lib
-- ----------------------------
DROP TABLE IF EXISTS `t_expert_lib`;
CREATE TABLE `t_expert_lib` (
  `lib_id` varchar(36) NOT NULL,
  `creat_on` datetime DEFAULT NULL,
  `is_assigned` varchar(2) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL,
  `jq_id` varchar(36) DEFAULT NULL,
  `tea_id` varchar(36) DEFAULT NULL,
  `UNIT_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`lib_id`),
  KEY `FK_ogg573phvotqolv55ael43sgf` (`jq_id`),
  KEY `FK_d87tg4etlj379smc0bu0rymnf` (`tea_id`),
  KEY `FK_pvq6diypdbeghrbafe7f3t3dm` (`UNIT_ID`),
  CONSTRAINT `FK_d87tg4etlj379smc0bu0rymnf` FOREIGN KEY (`tea_id`) REFERENCES `t_teacher` (`tea_id`),
  CONSTRAINT `FK_ogg573phvotqolv55ael43sgf` FOREIGN KEY (`jq_id`) REFERENCES `t_jieqi` (`jq_id`),
  CONSTRAINT `FK_pvq6diypdbeghrbafe7f3t3dm` FOREIGN KEY (`UNIT_ID`) REFERENCES `t_unit` (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_expert_lib
-- ----------------------------
INSERT INTO `t_expert_lib` VALUES ('8a7d2c914e57f2d5014e57f856250000', '2015-07-04 15:29:30', null, 'Y', '01', '1', '03', '1');

-- ----------------------------
-- Table structure for t_expert_review
-- ----------------------------
DROP TABLE IF EXISTS `t_expert_review`;
CREATE TABLE `t_expert_review` (
  `ex_review_id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `declar_id` varchar(36) DEFAULT NULL,
  `ex_tea_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`ex_review_id`),
  KEY `FK_1g5yv4dqdix3x23m6t8lmvglh` (`declar_id`),
  KEY `FK_17sa8edchq8uj9icdornmlpby` (`ex_tea_id`),
  CONSTRAINT `FK_17sa8edchq8uj9icdornmlpby` FOREIGN KEY (`ex_tea_id`) REFERENCES `t_expert_teacher` (`ex_tea_id`),
  CONSTRAINT `FK_1g5yv4dqdix3x23m6t8lmvglh` FOREIGN KEY (`declar_id`) REFERENCES `t_declaration` (`declar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_expert_review
-- ----------------------------
INSERT INTO `t_expert_review` VALUES ('8a7d2c914e57f2d5014e57fd81250005', 'N', '8a7d2c914e569ca0014e5703416e0002', '8a7d2c914e57f2d5014e57f856350001');
INSERT INTO `t_expert_review` VALUES ('8a7d2c914e57f2d5014e57fd81320006', 'N', '8a7d2c914e569ca0014e5703416e0002', '8a7d2c914e57f2d5014e57f856360003');
INSERT INTO `t_expert_review` VALUES ('8a7d2c914e57fdfd014e57fecd420000', 'N', '8a7d2c914e569ca0014e5703416e0002', '8a7d2c914e57f2d5014e57f856350001');
INSERT INTO `t_expert_review` VALUES ('8a7d2c914e57fdfd014e57fecd4b0001', 'N', '8a7d2c914e569ca0014e5703416e0002', '8a7d2c914e57f2d5014e57f856360003');

-- ----------------------------
-- Table structure for t_expert_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_expert_teacher`;
CREATE TABLE `t_expert_teacher` (
  `ex_tea_id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `re_decl_num` int(11) DEFAULT NULL,
  `lib_id` varchar(36) DEFAULT NULL,
  `tea_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`ex_tea_id`),
  KEY `FK_o7vreutdr4u9mjloppqc7av08` (`lib_id`),
  KEY `FK_rjq6uyrwmgvykimtljmatu6mc` (`tea_id`),
  CONSTRAINT `FK_o7vreutdr4u9mjloppqc7av08` FOREIGN KEY (`lib_id`) REFERENCES `t_expert_lib` (`lib_id`),
  CONSTRAINT `FK_rjq6uyrwmgvykimtljmatu6mc` FOREIGN KEY (`tea_id`) REFERENCES `t_teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_expert_teacher
-- ----------------------------
INSERT INTO `t_expert_teacher` VALUES ('8a7d2c914e57f2d5014e57f856350001', 'Y', null, '8a7d2c914e57f2d5014e57f856250000', '04');
INSERT INTO `t_expert_teacher` VALUES ('8a7d2c914e57f2d5014e57f856360003', 'Y', null, '8a7d2c914e57f2d5014e57f856250000', '05');

-- ----------------------------
-- Table structure for t_expert_teacher_model
-- ----------------------------
DROP TABLE IF EXISTS `t_expert_teacher_model`;
CREATE TABLE `t_expert_teacher_model` (
  `EX_TEA_ID` varchar(36) NOT NULL,
  `ISDELETED` varchar(1) DEFAULT NULL,
  `JQ_YEAR` decimal(22,0) DEFAULT NULL,
  `QICI` varchar(20) DEFAULT NULL,
  `RE_DECL_NUM` decimal(22,0) DEFAULT NULL,
  `LIB_ID` varchar(36) DEFAULT NULL,
  `TEA_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`EX_TEA_ID`),
  KEY `FK_5vlfdjuafwkxby6a07vo975y8` (`LIB_ID`),
  KEY `FK_ea0l0x0kcuti661cxvhtdv48x` (`TEA_ID`),
  CONSTRAINT `FK_5vlfdjuafwkxby6a07vo975y8` FOREIGN KEY (`LIB_ID`) REFERENCES `t_expert_lib` (`lib_id`),
  CONSTRAINT `FK_ea0l0x0kcuti661cxvhtdv48x` FOREIGN KEY (`TEA_ID`) REFERENCES `t_teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_expert_teacher_model
-- ----------------------------

-- ----------------------------
-- Table structure for t_funds
-- ----------------------------
DROP TABLE IF EXISTS `t_funds`;
CREATE TABLE `t_funds` (
  `ID` varchar(36) NOT NULL,
  `funds_detail` varchar(200) DEFAULT NULL,
  `funds_id` varchar(32) DEFAULT NULL,
  `funds_isReimburse` varchar(2) DEFAULT NULL,
  `funds_money` float DEFAULT NULL,
  `funds_name` varchar(50) DEFAULT NULL,
  `funds_use` varchar(200) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `project_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_t4ktqinyj10mrt49q6fnuvjjr` (`project_id`),
  CONSTRAINT `FK_t4ktqinyj10mrt49q6fnuvjjr` FOREIGN KEY (`project_id`) REFERENCES `t_project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_funds
-- ----------------------------

-- ----------------------------
-- Table structure for t_jieqi
-- ----------------------------
DROP TABLE IF EXISTS `t_jieqi`;
CREATE TABLE `t_jieqi` (
  `jq_id` varchar(36) NOT NULL,
  `DECLARATION_STATE` varchar(2) DEFAULT NULL,
  `end_on` datetime DEFAULT NULL,
  `ENDPROJECT_STATE` varchar(2) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `jq_name` varchar(50) DEFAULT NULL,
  `jq_year` int(11) DEFAULT NULL,
  `jt_end_on` datetime DEFAULT NULL,
  `jt_start_on` datetime DEFAULT NULL,
  `qici` varchar(20) DEFAULT NULL,
  `secondary_Assessment` varchar(1) DEFAULT NULL,
  `secondary_Respondent` varchar(1) DEFAULT NULL,
  `start_on` datetime DEFAULT NULL,
  `zj_end_on` datetime DEFAULT NULL,
  `zj_start_on` datetime DEFAULT NULL,
  PRIMARY KEY (`jq_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jieqi
-- ----------------------------
INSERT INTO `t_jieqi` VALUES ('1', '01', '2015-07-31 22:03:17', '01', 'N', null, '2015', null, null, '1', null, null, '2015-07-01 22:03:26', null, null);
INSERT INTO `t_jieqi` VALUES ('2', '01', null, '', 'N', null, '2015', null, null, '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for t_journal
-- ----------------------------
DROP TABLE IF EXISTS `t_journal`;
CREATE TABLE `t_journal` (
  `journal_id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `journal_loginIp` varchar(50) DEFAULT NULL,
  `journal_logintime` datetime DEFAULT NULL,
  `journal_quitime` datetime DEFAULT NULL,
  `journal_remark` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`journal_id`),
  KEY `FK_g8kb8ugsdelt0euellksqj3kl` (`user_id`),
  CONSTRAINT `FK_g8kb8ugsdelt0euellksqj3kl` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_journal
-- ----------------------------

-- ----------------------------
-- Table structure for t_journal_act
-- ----------------------------
DROP TABLE IF EXISTS `t_journal_act`;
CREATE TABLE `t_journal_act` (
  `journalAct_id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `journalAct_introduction` varchar(100) DEFAULT NULL,
  `journalAct_remark` varchar(100) DEFAULT NULL,
  `journalAct_type` varchar(2) DEFAULT NULL,
  `time` datetime NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `journal_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`journalAct_id`),
  KEY `FK_nchyptna8japwk2ce0y9jgdww` (`journal_id`),
  CONSTRAINT `FK_nchyptna8japwk2ce0y9jgdww` FOREIGN KEY (`journal_id`) REFERENCES `t_journal` (`journal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_journal_act
-- ----------------------------

-- ----------------------------
-- Table structure for t_profession
-- ----------------------------
DROP TABLE IF EXISTS `t_profession`;
CREATE TABLE `t_profession` (
  `profession_id` varchar(36) NOT NULL,
  `profession_class` varchar(64) DEFAULT NULL,
  `profession_isdeleted` varchar(1) DEFAULT NULL,
  `profession_name` varchar(64) DEFAULT NULL,
  `profession_remark` varchar(200) DEFAULT NULL,
  `profession_session` varchar(20) DEFAULT NULL,
  `unit_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`profession_id`),
  KEY `FK_ebyb6gw6chkwqmcr0bcnwtq3c` (`unit_id`),
  CONSTRAINT `FK_ebyb6gw6chkwqmcr0bcnwtq3c` FOREIGN KEY (`unit_id`) REFERENCES `t_unit` (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_profession
-- ----------------------------
INSERT INTO `t_profession` VALUES ('1', '111', 'N', 'engineering', null, null, '1');
INSERT INTO `t_profession` VALUES ('2', '123', 'N', 'Guess', null, null, '1');

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `project_id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `project_achievement` varchar(500) DEFAULT NULL,
  `project_begintime` datetime DEFAULT NULL,
  `project_condition` varchar(500) DEFAULT NULL,
  `project_content` varchar(1000) DEFAULT NULL,
  `project_endtime` datetime DEFAULT NULL,
  `project_fund` float DEFAULT NULL,
  `project_goal` varchar(500) DEFAULT NULL,
  `project_innovate` varchar(500) DEFAULT NULL,
  `project_introduction` varchar(500) DEFAULT NULL,
  `project_labname` varchar(20) DEFAULT NULL,
  `project_labtype` varchar(2) DEFAULT NULL,
  `project_line` varchar(500) DEFAULT NULL,
  `project_name` varchar(50) DEFAULT NULL,
  `project_number` varchar(20) DEFAULT NULL,
  `project_progress` varchar(500) DEFAULT NULL,
  `project_score` varchar(10) DEFAULT NULL,
  `project_sense` varchar(1000) DEFAULT NULL,
  `project_state` varchar(2) DEFAULT NULL,
  `project_work` varchar(500) DEFAULT NULL,
  `redmine_projectid` varchar(10) DEFAULT NULL,
  `declar_id` varchar(36) DEFAULT NULL,
  `jq_id` varchar(36) DEFAULT NULL,
  `project_leader` varchar(36) DEFAULT NULL,
  `project_user1` varchar(36) DEFAULT NULL,
  `project_user2` varchar(36) DEFAULT NULL,
  `project_teacher1` varchar(36) DEFAULT NULL,
  `project_teacher2` varchar(36) DEFAULT NULL,
  `unit_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FK_h4lnly5xcsdm3hhs51va9o5sy` (`declar_id`),
  KEY `FK_8xd6eeeo9mdvb7o3pva5lxi8g` (`jq_id`),
  KEY `FK_e7x495gmgvxnr7fyj5nswwsjj` (`project_leader`),
  KEY `FK_4wli1td18jx5mqe81q8861iyf` (`project_user1`),
  KEY `FK_ec4s9yjodple1fineq89p9i12` (`project_user2`),
  KEY `FK_g5ggfndrutbd9fgtngc1damry` (`project_teacher1`),
  KEY `FK_md475712jeixr004s5nulkwlq` (`project_teacher2`),
  KEY `FK_16ivnma9hgdb32p7bkcefixqi` (`unit_id`),
  CONSTRAINT `FK_16ivnma9hgdb32p7bkcefixqi` FOREIGN KEY (`unit_id`) REFERENCES `t_unit` (`unit_id`),
  CONSTRAINT `FK_4wli1td18jx5mqe81q8861iyf` FOREIGN KEY (`project_user1`) REFERENCES `t_student` (`student_id`),
  CONSTRAINT `FK_8xd6eeeo9mdvb7o3pva5lxi8g` FOREIGN KEY (`jq_id`) REFERENCES `t_jieqi` (`jq_id`),
  CONSTRAINT `FK_e7x495gmgvxnr7fyj5nswwsjj` FOREIGN KEY (`project_leader`) REFERENCES `t_student` (`student_id`),
  CONSTRAINT `FK_ec4s9yjodple1fineq89p9i12` FOREIGN KEY (`project_user2`) REFERENCES `t_student` (`student_id`),
  CONSTRAINT `FK_g5ggfndrutbd9fgtngc1damry` FOREIGN KEY (`project_teacher1`) REFERENCES `t_teacher` (`tea_id`),
  CONSTRAINT `FK_h4lnly5xcsdm3hhs51va9o5sy` FOREIGN KEY (`declar_id`) REFERENCES `t_declaration` (`declar_id`),
  CONSTRAINT `FK_md475712jeixr004s5nulkwlq` FOREIGN KEY (`project_teacher2`) REFERENCES `t_teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_project
-- ----------------------------
INSERT INTO `t_project` VALUES ('1', 'N', null, '2015-07-08 21:06:29', null, null, '2015-07-30 21:06:34', null, null, null, null, null, null, null, 'Test2', '1', null, null, null, null, null, null, '8a7d2c914e569ca0014e5703416e0002', '1', '06', '06', '06', '00', '01', '1');

-- ----------------------------
-- Table structure for t_project_change
-- ----------------------------
DROP TABLE IF EXISTS `t_project_change`;
CREATE TABLE `t_project_change` (
  `projectChange_id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `projectChange_atid` varchar(32) DEFAULT NULL,
  `projectChange_atime` datetime DEFAULT NULL,
  `projectChange_ctid` varchar(32) DEFAULT NULL,
  `projectChange_ctime` datetime DEFAULT NULL,
  `projectChange_date` datetime DEFAULT NULL,
  `projectChange_reason` varchar(200) DEFAULT NULL,
  `projectChange_state` varchar(2) DEFAULT NULL,
  `project_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`projectChange_id`),
  KEY `FK_3fpjv0bfj2bxwhymbh6o74bhf` (`project_id`),
  CONSTRAINT `FK_3fpjv0bfj2bxwhymbh6o74bhf` FOREIGN KEY (`project_id`) REFERENCES `t_project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_project_change
-- ----------------------------

-- ----------------------------
-- Table structure for t_project_change_content
-- ----------------------------
DROP TABLE IF EXISTS `t_project_change_content`;
CREATE TABLE `t_project_change_content` (
  `projectChangeContent_id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `projectChangeContent_field` varchar(100) DEFAULT NULL,
  `projectChangeContent_fieldname` varchar(100) DEFAULT NULL,
  `projectChangeContent_nvalue` varchar(1000) DEFAULT NULL,
  `projectChangeContent_ovalue` varchar(1000) DEFAULT NULL,
  `projectChange_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`projectChangeContent_id`),
  KEY `FK_rrx4jmmeyogkrcot6601h8f0q` (`projectChange_id`),
  CONSTRAINT `FK_rrx4jmmeyogkrcot6601h8f0q` FOREIGN KEY (`projectChange_id`) REFERENCES `t_project_change` (`projectChange_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_project_change_content
-- ----------------------------

-- ----------------------------
-- Table structure for t_result_distribut
-- ----------------------------
DROP TABLE IF EXISTS `t_result_distribut`;
CREATE TABLE `t_result_distribut` (
  `ID` varchar(36) NOT NULL,
  `BADSUM` double DEFAULT NULL,
  `BESTRATE` double DEFAULT NULL,
  `BESTSUM` double DEFAULT NULL,
  `COLLEGE` varchar(32) DEFAULT NULL,
  `COLLEGENAME` varchar(50) DEFAULT NULL,
  `DECSUM` double DEFAULT NULL,
  `DELAYRATE` double DEFAULT NULL,
  `DELAYSUM` double DEFAULT NULL,
  `ENDRATE` double DEFAULT NULL,
  `ENDSUM` double DEFAULT NULL,
  `JQ_ID` varchar(32) DEFAULT NULL,
  `JQNAME` varchar(50) DEFAULT NULL,
  `PRORATE` double DEFAULT NULL,
  `PROSUM` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_result_distribut
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('4028ab864e54db0c014e54db7bef0030', '学生', '未加入到任何项目组，或者项目已完成的学生');
INSERT INTO `t_role` VALUES ('4028ab864e54db0c014e54db7bef0031', '学生（项目成员）', '加入项目的学生');
INSERT INTO `t_role` VALUES ('4028ab864e54db0c014e54db7bef0032', '学生（项目组组长）', '加入了项目并且为组长');
INSERT INTO `t_role` VALUES ('4028ab864e54db0c014e54db7bef0033', '教师', '普通教师');
INSERT INTO `t_role` VALUES ('4028ab864e54db0c014e54db7bef0034', '学院主管教师', '学院主管教师');
INSERT INTO `t_role` VALUES ('4028ab864e54db0c014e54db7bef0035', '学院领导', '学院领导');
INSERT INTO `t_role` VALUES ('4028ab864e54db0c014e54db7bef0036', '评审教师', '可以进行项目评审');
INSERT INTO `t_role` VALUES ('4028ab864e54db0c014e54db7bef0037', '教务处主管教师', '可以进行届期管理，统计分析');
INSERT INTO `t_role` VALUES ('4028ab864e54db0c014e54db7bef0038', '管理', '拥有管理权限，可以执行系统内所有操作');
INSERT INTO `t_role` VALUES ('4028ab864e54db0c014e54db7bef0039', '教务处领导', '我是领导');

-- ----------------------------
-- Table structure for t_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_role_authority`;
CREATE TABLE `t_role_authority` (
  `id` varchar(36) NOT NULL,
  `role` varchar(36) NOT NULL,
  `authority` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_authority_ibfk_1` (`role`),
  KEY `authority` (`authority`),
  CONSTRAINT `role_authority_ibfk_1` FOREIGN KEY (`role`) REFERENCES `t_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_authority_ibfk_2` FOREIGN KEY (`authority`) REFERENCES `t_authority` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_authority
-- ----------------------------
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0000', '4028ab864e54db0c014e54db7bef0030', '4028ab864e54db0c014e54db7bef0060');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0001', '4028ab864e54db0c014e54db7bef0030', '4028ab864e54db0c014e54db7bef0070');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0002', '4028ab864e54db0c014e54db7bef0030', '4028ab864e54db0c014e54db7bef00f0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0004', '4028ab864e54db0c014e54db7bef0031', '4028ab864e54db0c014e54db7bef0060');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0005', '4028ab864e54db0c014e54db7bef0031', '4028ab864e54db0c014e54db7bef0061');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0006', '4028ab864e54db0c014e54db7bef0031', '4028ab864e54db0c014e54db7bef0080');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0007', '4028ab864e54db0c014e54db7bef0031', '4028ab864e54db0c014e54db7bef0089');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0008', '4028ab864e54db0c014e54db7bef0031', '4028ab864e54db0c014e54db7bef00b0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0009', '4028ab864e54db0c014e54db7bef0031', '4028ab864e54db0c014e54db7bef00f0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef000a', '4028ab864e54db0c014e54db7bef0032', '4028ab864e54db0c014e54db7bef0060');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef000b', '4028ab864e54db0c014e54db7bef0032', '4028ab864e54db0c014e54db7bef0061');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef000c', '4028ab864e54db0c014e54db7bef0032', '4028ab864e54db0c014e54db7bef0070');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef000d', '4028ab864e54db0c014e54db7bef0032', '4028ab864e54db0c014e54db7bef0071');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef000e', '4028ab864e54db0c014e54db7bef0031', '4028ab864e54db0c014e54db7bef0070');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef000f', '4028ab864e54db0c014e54db7bef0031', '4028ab864e54db0c014e54db7bef0071');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0010', '4028ab864e54db0c014e54db7bef0032', '4028ab864e54db0c014e54db7bef0080');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0011', '4028ab864e54db0c014e54db7bef0032', '4028ab864e54db0c014e54db7bef0089');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0012', '4028ab864e54db0c014e54db7bef0032', '4028ab864e54db0c014e54db7bef0090');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0013', '4028ab864e54db0c014e54db7bef0032', '4028ab864e54db0c014e54db7bef00b0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0014', '4028ab864e54db0c014e54db7bef0032', '4028ab864e54db0c014e54db7bef00f0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0015', '4028ab864e54db0c014e54db7bef0033', '4028ab864e54db0c014e54db7bef0061');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0016', '4028ab864e54db0c014e54db7bef0033', '4028ab864e54db0c014e54db7bef0070');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0017', '4028ab864e54db0c014e54db7bef0033', '4028ab864e54db0c014e54db7bef0089');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0018', '4028ab864e54db0c014e54db7bef0033', '4028ab864e54db0c014e54db7bef0090');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0019', '4028ab864e54db0c014e54db7bef0033', '4028ab864e54db0c014e54db7bef00b0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef001a', '4028ab864e54db0c014e54db7bef0033', '4028ab864e54db0c014e54db7bef00f0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef001c', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0061');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef001f', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0072');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0020', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0074');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0021', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0075');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0022', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0076');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0023', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0077');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0024', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0078');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0025', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0079');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0026', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0081');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0027', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0091');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0028', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0093');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0029', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0095');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef002a', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0094');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef002b', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0097');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef002c', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0096');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef002d', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef00a0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef002e', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef00f0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef002f', '4028ab864e54db0c014e54db7bef0035', '4028ab864e54db0c014e54db7bef0060');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0030', '4028ab864e54db0c014e54db7bef0035', '4028ab864e54db0c014e54db7bef0061');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0032', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0064');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0035', '4028ab864e54db0c014e54db7bef0072');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0035', '4028ab864e54db0c014e54db7bef0035', '4028ab864e54db0c014e54db7bef007a');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0036', '4028ab864e54db0c014e54db7bef0035', '4028ab864e54db0c014e54db7bef0091');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef0035', '4028ab864e54db0c014e54db7bef00a0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0035', '4028ab864e54db0c014e54db7bef00f0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef0036', '4028ab864e54db0c014e54db7bef0060');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef003a', '4028ab864e54db0c014e54db7bef0036', '4028ab864e54db0c014e54db7bef0061');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef003c', '4028ab864e54db0c014e54db7bef0036', '4028ab864e54db0c014e54db7bef0073');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef003d', '4028ab864e54db0c014e54db7bef0036', '4028ab864e54db0c014e54db7bef0080');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef003e', '4028ab864e54db0c014e54db7bef0036', '4028ab864e54db0c014e54db7bef0092');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef003f', '4028ab864e54db0c014e54db7bef0036', '4028ab864e54db0c014e54db7bef00f0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0040', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef0060');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0041', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef0061');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0045', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef0072');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0046', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef007a');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0047', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef0081');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0048', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef0091');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0049', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef0099');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0050', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef00a0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0051', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef00a1');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0052', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef00e0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0053', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef00e1');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0054', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef00e2');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0055', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef00e3');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0056', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef00e4');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0057', '4028ab864e54db0c014e54db7bef0033', '4028ab864e54db0c014e54db7bef0060');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0058', '4028ab864e54db0c014e54db7bef0035', '4028ab864e54db0c014e54db7bef0099');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef005a', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0060');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef005b', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0061');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef006e', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0064');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef006f', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0070');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0070', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0071');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0071', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0072');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0072', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0073');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0073', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0074');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0074', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0075');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0075', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0076');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0076', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0077');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0077', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0078');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0078', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0079');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0079', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef007a');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0080', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0080');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0081', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0081');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0082', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0089');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0083', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0090');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0084', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0091');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0085', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0092');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0086', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0093');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0087', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0094');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0088', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0095');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0089', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0096');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef008a', '4028ab864e54db0c014e54db7bef0037', '4028ab864e54db0c014e54db7bef00f0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0090', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0097');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0091', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0098');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0092', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef0099');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0093', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef00a0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0094', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef00a1');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0095', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef00b0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0096', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef00e0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0097', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef00e1');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0098', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef00e2');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0099', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef00e3');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0100', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef00e4');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0101', '4028ab864e54db0c014e54db7bef0038', '4028ab864e54db0c014e54db7bef00f0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0102', '4028ab864e54db0c014e54db7bef0036', '4028ab864e54db0c014e54db7bef0070');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0103', '4028ab864e54db0c014e54db7bef0030', '4028ab864e54db0c014e54db7bef0061');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0104', '4028ab864e54db0c014e54db7bef0030', '4028ab864e54db0c014e54db7bef0071');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0105', '4028ab864e54db0c014e54db7bef0033', '4028ab864e54db0c014e54db7bef0080');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0106', '4028ab864e54db0c014e54db7bef0034', '4028ab864e54db0c014e54db7bef0098');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0107', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef0061');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0108', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef0064');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0109', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef0072');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0110', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef0081');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0111', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef0091');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0112', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef0094');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0113', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef0097');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0114', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef0098');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0115', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef00a1');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0116', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef00a0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0117', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef00e2');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0118', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef00e0');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0119', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef00e1');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0120', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef00e4');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0121', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef00e3');
INSERT INTO `t_role_authority` VALUES ('4028ab864e54db0c014e54db7bef0122', '4028ab864e54db0c014e54db7bef0039', '4028ab864e54db0c014e54db7bef00f0');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `student_id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `student_age` varchar(2) DEFAULT NULL,
  `student_email` varchar(100) DEFAULT NULL,
  `student_birthday` datetime DEFAULT NULL,
  `student_degree` varchar(5) DEFAULT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `student_number` varchar(20) DEFAULT NULL,
  `student_remark` varchar(200) DEFAULT NULL,
  `student_sex` varchar(2) DEFAULT NULL,
  `student_telphone` varchar(15) DEFAULT NULL,
  `pro_profession_id` varchar(36) DEFAULT NULL,
  `profession_id` varchar(36) DEFAULT NULL,
  `UNIT_ID` varchar(36) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK_k7rlm5bh5mppxwyv32aebpbn0` (`pro_profession_id`),
  KEY `FK_ix9pgnanfmu7fi4xbc1xo6w3b` (`profession_id`),
  KEY `FK_b7i3er6o1hea8vubtnnso6rs2` (`UNIT_ID`),
  KEY `FK_q2ges2wi3xiuajgh29hbfnglp` (`user_id`),
  CONSTRAINT `FK_b7i3er6o1hea8vubtnnso6rs2` FOREIGN KEY (`UNIT_ID`) REFERENCES `t_unit` (`unit_id`),
  CONSTRAINT `FK_ix9pgnanfmu7fi4xbc1xo6w3b` FOREIGN KEY (`profession_id`) REFERENCES `t_profession` (`profession_id`),
  CONSTRAINT `FK_k7rlm5bh5mppxwyv32aebpbn0` FOREIGN KEY (`pro_profession_id`) REFERENCES `t_profession` (`profession_id`),
  CONSTRAINT `FK_q2ges2wi3xiuajgh29hbfnglp` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('01', 'N', '21', null, null, null, 'LLL', '08', null, null, null, null, '1', '1', '08');
INSERT INTO `t_student` VALUES ('02', 'N', '21', null, null, null, 'Lee', '07', null, null, null, null, '1', '1', '07');
INSERT INTO `t_student` VALUES ('03', 'N', '21', null, null, null, 'OOO', '09', null, null, null, null, '1', '1', '09');
INSERT INTO `t_student` VALUES ('04', 'N', '21', null, null, null, 'PPP', '10', null, null, null, null, '1', '1', '10');
INSERT INTO `t_student` VALUES ('06', 'N', '21', null, null, null, 'zkq', '06', null, null, null, null, '1', '1', '06');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `tea_id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `tea_email` varchar(50) DEFAULT NULL,
  `tea_age` decimal(19,2) DEFAULT NULL,
  `tea_code` varchar(20) DEFAULT NULL,
  `tea_intro` varchar(1000) DEFAULT NULL,
  `tea_name` varchar(50) DEFAULT NULL,
  `tea_remark` varchar(1000) DEFAULT NULL,
  `tea_sex` varchar(2) DEFAULT NULL,
  `tea_state` varchar(2) DEFAULT NULL,
  `tea_tele` varchar(20) DEFAULT NULL,
  `tea_title` varchar(50) DEFAULT NULL,
  `profession_id` varchar(36) DEFAULT NULL,
  `UNIT_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`tea_id`),
  KEY `FK_19673bjcql0ddf6h0pitqubd1` (`profession_id`),
  KEY `FK_g9iu6s3534lr6263fgm1e1m87` (`UNIT_ID`),
  CONSTRAINT `FK_19673bjcql0ddf6h0pitqubd1` FOREIGN KEY (`profession_id`) REFERENCES `t_profession` (`profession_id`),
  CONSTRAINT `FK_g9iu6s3534lr6263fgm1e1m87` FOREIGN KEY (`UNIT_ID`) REFERENCES `t_unit` (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('00', 'N', '1191482087@qq.com', null, '11', null, 'jwc0', null, '1', null, null, null, '1', '1');
INSERT INTO `t_teacher` VALUES ('01', 'N', '1191482087@qq.com', null, '01', null, 'jwc1', null, '1', null, null, null, '1', '1');
INSERT INTO `t_teacher` VALUES ('02', 'N', '1191482087@qq.com', null, '02', null, 'col2', null, '1', null, null, null, '1', '1');
INSERT INTO `t_teacher` VALUES ('03', 'N', '1191482087@qq.com', null, '03', null, 'col3', null, '0', null, null, null, '1', '1');
INSERT INTO `t_teacher` VALUES ('04', 'N', '1191482087@qq.com', null, '04', null, 'pinshen', null, '0', null, null, null, '1', '1');
INSERT INTO `t_teacher` VALUES ('05', 'N', '1191482087@qq.com', null, '05', null, 'commontea', null, '0', null, null, null, '1', '1');
INSERT INTO `t_teacher` VALUES ('06', 'N', '1191482087@qq.com', null, '00', null, 'jwcl', null, '0', null, null, null, '1', '1');

-- ----------------------------
-- Table structure for t_temp_email_reciver
-- ----------------------------
DROP TABLE IF EXISTS `t_temp_email_reciver`;
CREATE TABLE `t_temp_email_reciver` (
  `id` varchar(36) NOT NULL,
  `code` varchar(32) DEFAULT NULL,
  `depart_id` varchar(32) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `jq_id` varchar(32) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_temp_email_reciver
-- ----------------------------
INSERT INTO `t_temp_email_reciver` VALUES ('0af01694-2067-11e5-b8b9-f079598bd102', '03', '1', '1191482087@qq.com', 'Y', '1', 'college', '01');
INSERT INTO `t_temp_email_reciver` VALUES ('18b0213a-207a-11e5-b8b9-f079598bd102', '03', '1', '1191482087@qq.com', 'Y', '1', 'college', '01');
INSERT INTO `t_temp_email_reciver` VALUES ('2d321b55-2096-11e5-b8b9-f079598bd102', '03', '1', '1191482087@qq.com', 'Y', '1', 'college', '01');
INSERT INTO `t_temp_email_reciver` VALUES ('617cf629-2080-11e5-b8b9-f079598bd102', '03', '1', '1191482087@qq.com', 'Y', '1', 'college', '01');
INSERT INTO `t_temp_email_reciver` VALUES ('8a7d2c914e569ca0014e570399170004', '06', '1', '1191482087@qq.com', 'Y', '1', 'zkq', '01');
INSERT INTO `t_temp_email_reciver` VALUES ('8a7d2c914e569ca0014e57039fd40005', '03', '1', '1191482087@qq.com', 'Y', '1', 'col3', '01');
INSERT INTO `t_temp_email_reciver` VALUES ('8a7d2c914e57ce96014e57eae7bd0002', '05', '1', '1191482087@qq.com', 'Y', '1', 'commontea', '01');
INSERT INTO `t_temp_email_reciver` VALUES ('8a7d2c914e57f2d5014e57f856350002', '04', '1', '1191482087@qq.com', 'Y', '1', 'pinshen', '01');
INSERT INTO `t_temp_email_reciver` VALUES ('8a7d2c914e57f2d5014e57f856370004', '05', '1', '1191482087@qq.com', 'Y', '1', 'commontea', '01');
INSERT INTO `t_temp_email_reciver` VALUES ('bb53f7f0-2065-11e5-b8b9-f079598bd102', '03', '1', '1191482087@qq.com', 'Y', '1', 'college', '01');
INSERT INTO `t_temp_email_reciver` VALUES ('cc46601a-2080-11e5-b8b9-f079598bd102', '03', '1', '1191482087@qq.com', 'Y', '1', 'college', '01');
INSERT INTO `t_temp_email_reciver` VALUES ('e145ae8f-2079-11e5-b8b9-f079598bd102', '03', '1', '1191482087@qq.com', 'Y', '1', 'college', '01');

-- ----------------------------
-- Table structure for t_unit
-- ----------------------------
DROP TABLE IF EXISTS `t_unit`;
CREATE TABLE `t_unit` (
  `unit_id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `unit_code` varchar(100) DEFAULT NULL,
  `unit_fatherid` varchar(32) DEFAULT NULL,
  `unit_name` varchar(100) DEFAULT NULL,
  `unit_remark` varchar(200) DEFAULT NULL,
  `unit_type` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_unit
-- ----------------------------
INSERT INTO `t_unit` VALUES ('1', 'N', '1', null, 'software', null, '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` varchar(36) NOT NULL,
  `isdeleted` varchar(1) DEFAULT NULL,
  `user_introduction` varchar(200) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `user_state` varchar(2) DEFAULT NULL,
  `role` varchar(36) DEFAULT NULL,
  `previous_type` varchar(2) DEFAULT NULL,
  `user_type` varchar(2) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `role` (`role`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`role`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('00', 'N', null, 'jwcl', '123', 'YY', '4028ab864e54db0c014e54db7bef0039', null, '00', '11@qq.com');
INSERT INTO `t_user` VALUES ('01', 'N', null, 'jwc1', '123', 'YY', '4028ab864e54db0c014e54db7bef0037', null, '01', '1@qq.com');
INSERT INTO `t_user` VALUES ('02', 'N', null, 'cll', '123', 'YY', '4028ab864e54db0c014e54db7bef0035', null, '02', '2@qq.com');
INSERT INTO `t_user` VALUES ('03', 'N', null, 'clt', '123', 'YY', '4028ab864e54db0c014e54db7bef0034', '03', '03', '3@qq.com');
INSERT INTO `t_user` VALUES ('04', 'N', null, 'ps', '123', 'YY', '4028ab864e54db0c014e54db7bef0036', '04', '04', '4@qq.com');
INSERT INTO `t_user` VALUES ('05', 'N', null, 'ct', '123', 'YY', '4028ab864e54db0c014e54db7bef0033', '05', '05', '5@qq.com');
INSERT INTO `t_user` VALUES ('06', 'N', null, 'stu1', '123', 'YY', '4028ab864e54db0c014e54db7bef0030', null, '06', '6@qq.com');
INSERT INTO `t_user` VALUES ('07', 'N', null, 'stu2', '123', 'YY', '4028ab864e54db0c014e54db7bef0031', null, '07', '7@qq.com');
INSERT INTO `t_user` VALUES ('08', 'N', null, 'stu3', '123', 'YY', '4028ab864e54db0c014e54db7bef0032', null, '08', '8@qq.com');
INSERT INTO `t_user` VALUES ('09', 'N', null, 'stu4', '123', 'YY', '4028ab864e54db0c014e54db7bef0030', null, '06', '9@qq.com');
INSERT INTO `t_user` VALUES ('10', 'N', null, 'stu5', '123', 'YY', '4028ab864e54db0c014e54db7bef0030', null, '06', '10@qq.com');
INSERT INTO `t_user` VALUES ('11', 'N', null, 'jwc0', '123', 'YY', '4028ab864e54db0c014e54db7bef0038', null, '00', '0@qq.com');
