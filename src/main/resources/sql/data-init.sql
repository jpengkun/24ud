-- MySQL dump 10.13  Distrib 5.6.46, for Win64 (x86_64)
--
-- Host: 39.99.139.66    Database: qincang
-- ------------------------------------------------------
-- Server version	5.6.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `authority_id` varchar(64) NOT NULL,
  `name` varchar(128) NOT NULL,
  `code` varchar(64) NOT NULL,
  `type` varchar(64) NOT NULL,
  `parent_id` varchar(64) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`authority_id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `authority_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `authority` (`authority_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

INSERT INTO `authority` VALUES ('0695a3e57b2448f0aa995ccf2223d5b0','用户修改','USER_UPDATE','ACTION','55dfc988415d42f79ed4e85af60785d5','2019-10-12 15:02:44'),('1285ea2373ba4f0ca955ca2622d2d37b','委托管理修改','ENTRUST_UPDATE','MENU','eab537e9ab7445f4932eced6b17c398b','2019-11-09 10:35:16'),('1874c9cdc0dc4a5daf330564ddd3d0f1','轮播图修改','BANNER_UPDATE','ACTION','d961897d714041148e4bc24f2f72507b','2019-11-08 16:09:15'),('25cd190ecf3f4060a150309e665b9996','字典项修改','DICTIONARY_UPDATE','ACTION','c60250b96fb44fd0a35917555698ff76','2019-10-12 15:04:52'),('2746d1bc282846a080b64f5385adb720','客户管理','CUSTOM_MANAGE','PAGE',NULL,'2019-10-16 10:40:20'),('2996886f4d07459496912fb594914684','面积条件修改','SPACE_COND_UPDATE','ACTION','c541c69c2a2f4941aee189d1f4ade0ef','2019-11-15 09:06:16'),('2b31f97e9c614407960c66e8bafe6dd4','客户修改','CUSTOM_UPDATE','ACTION','2746d1bc282846a080b64f5385adb720','2019-10-16 10:41:45'),('2ba5aafb6d1542c69ab83ecd24dcc8ed','找仓管理删除','LOOKING_DELETE','ACTION','ef4c0228288c4fefa5e31112ba8ae974','2019-11-12 16:52:54'),('2f7a108ee4a74cee84bd73461ce8e946','角色新增','ROLE_ADD','ACTION','8e32ed2502a441d6a11e662af0db0668','2019-10-12 15:03:31'),('3020baa041cd43ee9ccd83e808d51e7c','预约删除','RESERVE_DELETE','ACTION','3d2aef5e62fa4a01b8f08b7e2e3df3d6','2019-11-15 09:08:02'),('3161e25a68c14840bad2e52a0ba7b728','仓库修改','WAREHOUSE_UPDATE','ACTION','f3b4d5f9147d44d9b2f33368dc87addb','2019-10-24 11:06:57'),('35a218fbcab14b2b9641e7ddc8c1f0cc','仓库新增','WAREHOUSE_ADD','ACTION','f3b4d5f9147d44d9b2f33368dc87addb','2019-10-24 11:06:27'),('3d2aef5e62fa4a01b8f08b7e2e3df3d6','预约管理','RESERVE_MANAGE','PAGE',NULL,'2019-11-15 09:07:14'),('439b658ed5da4ff3bc8387d268198ca1','意见反馈新增','FEEDBACK_ADD','ACTION','64796127161348408e4dab0ea5ce9286','2019-11-15 09:08:39'),('55dfc988415d42f79ed4e85af60785d5','用户管理','USER_MANAGE','PAGE',NULL,'2019-10-12 15:02:29'),('56d40dbbc7614261bd6c79d3c9355e9a','角色删除','ROLE_DELETE','ACTION','8e32ed2502a441d6a11e662af0db0668','2019-10-12 15:03:43'),('5fe1579048a9458dbf5204e6c0172599','轮播图删除','BANNER_DELETE','ACTION','d961897d714041148e4bc24f2f72507b','2019-11-08 16:09:00'),('616a365aa7e24c06bb6faf1af3787fd7','轮播图新增','BANNER_ADD','ACTION','d961897d714041148e4bc24f2f72507b','2019-11-08 16:08:27'),('64796127161348408e4dab0ea5ce9286','意见反馈','FEEDBACK_MANAGE','PAGE',NULL,'2019-11-08 17:36:22'),('660bf4a4bf96400ba74bd444713c6bde','字典项删除','DICTIONARY_DELETE','ACTION','c60250b96fb44fd0a35917555698ff76','2019-10-12 15:04:58'),('68c0244d4b904cbf8a5bcecd6922fdeb','意见反馈删除','FEEDBACK_DELETE','ACTION','64796127161348408e4dab0ea5ce9286','2019-11-08 17:38:09'),('696530012d3347eab22e22876bbead3c','权限管理','AUTHORITY_MANAGE','PAGE',NULL,'2019-10-12 15:04:14'),('69f2912174d74bbda9dc88bbfee769c8','客户新增','CUSTOM_ADD','ACTION','2746d1bc282846a080b64f5385adb720','2019-10-16 10:41:35'),('7021e4da9d374306813e059875a45257','找仓管理添加','LOOKING_ADD','ACTION','ef4c0228288c4fefa5e31112ba8ae974','2019-11-12 16:50:48'),('721c820142e2453ca7308c53171193d6','意见反馈修改','FEEDBACK_UPDATE','ACTION','64796127161348408e4dab0ea5ce9286','2019-11-08 17:36:53'),('8314df81d6a041869076eb34a338cc4a','找仓管理修改','LOOKING_UPDATE','ACTION','ef4c0228288c4fefa5e31112ba8ae974','2019-11-12 16:52:06'),('848e220b728c41a1847f9f19d4eb0cd8','角色修改','ROLE_UPDATE','ACTION','8e32ed2502a441d6a11e662af0db0668','2019-10-12 15:03:37'),('8e32ed2502a441d6a11e662af0db0668','角色管理','ROLE_MANAGE','PAGE',NULL,'2019-10-12 15:02:59'),('98485d1811b14fd080726a19196c50d6','字典项新增','DICTIONARY_ADD','ACTION','c60250b96fb44fd0a35917555698ff76','2019-10-12 15:04:43'),('9e246dcc68ec4a6c9f3adb723d1fb9af','权限删除','AUTHORITY_DELETE','ACTION','696530012d3347eab22e22876bbead3c','2019-10-12 15:04:37'),('a6ab73df13e1423a8b07076aa8ee131b','权限修改','AUTHORITY_UPDATE','PAGE','696530012d3347eab22e22876bbead3c','2019-10-12 15:04:29'),('a829cb16d92c4d3c9bccc48094ef702b','预约修改','RESERVE_UPDATE','ACTION','3d2aef5e62fa4a01b8f08b7e2e3df3d6','2019-11-15 09:07:49'),('b7c360daad8445c195373455dbb95e69','用户新增','USER_ADD','ACTION','55dfc988415d42f79ed4e85af60785d5','2019-10-12 15:02:38'),('bab69bb98656409d8356d4e69de45b16','委托管理添加','ENTRUST_ADD','PAGE','eab537e9ab7445f4932eced6b17c398b','2019-11-09 10:31:49'),('c541c69c2a2f4941aee189d1f4ade0ef','面积条件管理','SPACE_COND_MANAGE','PAGE',NULL,'2019-11-15 09:05:35'),('c60250b96fb44fd0a35917555698ff76','数据字典','DICTIONARY_MANAGE','PAGE',NULL,'2019-10-12 15:04:01'),('cae47c2a08a54665806eed3cfa219dc3','面积条件删除','SPACE_COND_DELETE','ACTION','c541c69c2a2f4941aee189d1f4ade0ef','2019-11-15 09:06:28'),('d2a6ea7e3fe6442185d5a1ac1dece4da','客户删除','CUSTOM_DELETE','ACTION','2746d1bc282846a080b64f5385adb720','2019-10-16 10:42:00'),('d961897d714041148e4bc24f2f72507b','轮播图管理','BANNER_MANAGE','PAGE',NULL,'2019-11-08 15:47:37'),('dddb989ca49749c79a1734fd7eca4b5d','预约新增','RESERVE_ADD','ACTION','3d2aef5e62fa4a01b8f08b7e2e3df3d6','2019-11-15 09:07:37'),('ded4d6134e624faea7d4bd6e74eeacff','委托管理删除','ENTRUST_DELETE','ACTION','eab537e9ab7445f4932eced6b17c398b','2019-11-09 10:33:13'),('e1fbc73fe03040b4869e0e8cc4e2dc31','用户删除','USER_DELETE','ACTION','55dfc988415d42f79ed4e85af60785d5','2019-10-12 15:02:50'),('e41b2a843d0747e7bd10637e5bbf90a5','面积条件新增','SPACE_COND_ADD','ACTION','c541c69c2a2f4941aee189d1f4ade0ef','2019-11-15 09:06:01'),('eab537e9ab7445f4932eced6b17c398b','委托管理','ENTRUST_MANAGE','PAGE',NULL,'2019-11-09 10:31:12'),('ec27bf51312b45e3b63625d1adf72991','权限新增','AUTHORITY_ADD','ACTION','696530012d3347eab22e22876bbead3c','2019-10-12 15:04:24'),('ec5310b9806a405cbf7ea81bcf09b7df','仓库删除','WAREHOUSE_DELETE','ACTION','f3b4d5f9147d44d9b2f33368dc87addb','2019-10-24 11:07:09'),('ef4c0228288c4fefa5e31112ba8ae974','找仓管理','LOOKING_MANAGE','PAGE',NULL,'2019-11-12 16:49:40'),('f3b4d5f9147d44d9b2f33368dc87addb','仓库管理','WAREHOUSE_MANAGE','PAGE',NULL,'2019-10-24 11:05:35'),('f5f22b2e50c24342b34ab7ab4259296a','收藏管理','WH_COLLECTION_MANAGE','PAGE',NULL,'2019-11-20 17:18:07'),('f680b708a261407ea4db6b93c6f30f8d','接口文档','API_DOCUMENT','PAGE',NULL,'2019-10-12 15:04:09'),('ffe70c72909f41c797f0662b9c8ce7f7','公共资源','COMMON_RESOURCE','MENU',NULL,'2019-10-12 15:03:51');

--
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banner` (
  `bid` varchar(64) NOT NULL DEFAULT '' COMMENT '主键',
  `img` varchar(256) NOT NULL COMMENT '图片路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否展示',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='轮播图';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

INSERT INTO `banner` VALUES ('6efebb42be7342d28880d7576d1add28','/img/banner/4d78d1cbd5494f4383c8382cb2179b18.png','2019-11-15 15:08:14',1),('9d2958ac633a4aa982db1c91f368a1b5','/img/banner/33b51867e9db400c9d1d49fe604e6685.jpg','2019-11-15 15:07:27',1),('dbbb2d1aa54d4e518a381e581ba3e895','/img/banner/86e878449db548c18c3450d8402b5f3a.jpg','2019-11-15 15:07:53',1);

--
-- Table structure for table `custom`
--

DROP TABLE IF EXISTS `custom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `custom` (
  `custom_id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(64) DEFAULT NULL COMMENT 'qq号',
  `company` varchar(64) DEFAULT NULL COMMENT '公司',
  `company_region` varchar(64) DEFAULT NULL COMMENT '公司位置',
  `company_address` varchar(128) DEFAULT NULL COMMENT '公司地址',
  `reg_time` datetime NOT NULL COMMENT '注册时间',
  `last_login_location` varchar(32) DEFAULT NULL COMMENT '上次登录地点',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `login_count` int(11) NOT NULL DEFAULT '0' COMMENT '累计登录次数',
  `open_id` varchar(128) NOT NULL COMMENT '微信openid',
  `tel` varchar(64) DEFAULT NULL COMMENT '手机号',
  `auth_status` int(1) NOT NULL DEFAULT '0' COMMENT '认证状态',
  `auth_img` varchar(512) DEFAULT NULL COMMENT '认证图片',
  `nickname` varchar(64) NOT NULL COMMENT '昵称',
  `session_key` varchar(64) DEFAULT NULL COMMENT '微信session_key',
  PRIMARY KEY (`custom_id`),
  UNIQUE KEY `open_id` (`open_id`),
  UNIQUE KEY `custom_tel_uindex` (`tel`),
  UNIQUE KEY `custom_company_uindex` (`company`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custom`
--

INSERT INTO `custom` VALUES ('0c5a844a0b6e4202a2307301551d3fe7',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-20 18:06:07','上海市浦东新区世纪大道8号','2019-11-20 18:06:08',1,'onh0a43c1939FNpayrQF_gPj8zpw',NULL,0,NULL,'nick',NULL),('365ad77167ad4fe5a919f4000ea0a122',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-21 15:19:17','广东省广州市越秀区府前路1号','2019-11-21 15:21:31',3,'onh0a43peu4q7NVDIAeapLOvM6wY',NULL,0,NULL,'袁俊宏',NULL),('49de67b797a142258b3d5c286decbdb3',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-22 09:15:29','江苏省苏州市吴江区中鲈大道','2019-11-22 09:28:12',5,'onh0a48Jbx6QeRKEcbpoNL-bmu8c',NULL,0,NULL,'（空中来客）陶勇',NULL),('56fcfad92d284828b20fc5817beb9ba1',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-21 18:11:01','江苏省苏州市吴江区50国道','2019-11-22 14:52:32',9,'onh0a4_DxFJlUfiwPxsP57SAPFss',NULL,0,NULL,'不一样的烟火','mRTUFpR7Foi0bu+FIaRWNA=='),('6137f53fc47943098e5705aec6b0b8ca',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-20 10:54:41','江苏省苏州市吴江区震新北路','2019-11-21 21:38:14',5,'onh0a46yDSMtIjyuk69UcIbTxXKw',NULL,0,NULL,'秦仓 秦俭','l+adWxFzftZo7qmM4sE37g=='),('6d1c821e7d384243b687186468547d0b',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-22 10:22:05','江苏省苏州市吴江区云创路','2019-11-22 10:22:19',1,'onh0a4zwH6StD3ER3qVkzP9iJqHg',NULL,0,NULL,'Cao Fei',NULL),('778b64d34f5c4f57a9ae7fda95dfe983','陈勇',NULL,NULL,'博匠智能','江苏省,苏州市,吴江区','金鹰材质中心','2019-11-20 14:50:56','江苏省苏州市吴江区鲈乡南路','2019-11-22 09:15:10',23,'onh0a45t6G1WRxbSwot_IpS-Y17M','15501507955',2,'/img/778b64d34f5c4f57a9ae7fda95dfe983/auth/7a548f90b4e64128bbb835beb74dbaa4.jpg','Ace','O3Y4GDBqLm+xBGYpSs+9kA=='),('81f9e2b63422451e9480b645e58628c0','薛彬',NULL,NULL,'秦仓互联','江苏省,苏州市,吴江区','金鹰财智广场','2019-11-20 11:12:07','江苏省苏州市吴江区中鲈大道','2019-11-22 14:21:08',19,'onh0a47mA-jry7s8N_NwK3Dzis4g','18112748629',2,'/img/81f9e2b63422451e9480b645e58628c0/auth/cae44af20aec4468a8010591c3d6ddb3.jpg','领英物流---薛彬','u/jXGIGsHPAgnPzZgHhqwQ=='),('82181c77275c4075b1026547118c379a',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-20 18:23:08',NULL,NULL,0,'onh0a4zqZk3FUSoK4DEzT8bvhCtw',NULL,0,NULL,'许志霖',NULL),('84039da1f9c5443aa5536ef4c1d1acde',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-20 21:48:34','江苏省苏州市吴江区江陵西路1333号','2019-11-20 21:50:06',2,'onh0a426uMZLLPbXgjQanmXIH8VU',NULL,0,NULL,'施清华¹⁵⁸⁶²⁵⁶⁶⁵⁵⁵吴江',NULL),('8ada94544465419284e4a71c705e3ff8',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-21 19:51:24','江苏省苏州市吴中区星海街199号','2019-11-21 19:53:33',4,'onh0a492hTM5pGQdHhGD0TrBuqjw',NULL,0,NULL,'罗勋','tuGTBvxxhbfWkyhlem2l9g=='),('95047cb38eb04e1aaef82370b5d2f433',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-20 12:55:54','广东省广州市越秀区府前路1号','2019-11-20 12:55:55',1,'onh0a42HQxiadkCAR0hOLPeY7IN0',NULL,0,NULL,'洪宗翰',NULL),('a5da541ce5be4d12aad3808dbef62df9',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-22 15:30:19',NULL,NULL,0,'onh0a44jDB_h5_zp79hXUu_Ybo18',NULL,0,NULL,'章卢',NULL),('b9f0ebf334c2469889b6c8ca71fafa61',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-20 14:39:40','江苏省苏州市吴江区人民路1000号','2019-11-21 09:04:41',47,'onh0a4482J_mgPxBnYDlS2bzyynQ',NULL,0,NULL,'handsome','GJpbgrqgyJ4rCbLHRk2viw=='),('c09fdd0177cf4e8fb2d954afd4394889',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-20 16:59:02','江苏省苏州市吴江区鲈乡南路','2019-11-20 17:06:39',3,'onh0a4xFM6j2usFua-PYL7Jl-VQo',NULL,0,NULL,'冷风',NULL),('c67af0d939b64090ae78740dde37a218',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-20 16:40:42','江苏省苏州市吴江区鲈乡南路','2019-11-20 16:57:33',7,'onh0a44w-xFJi3_ojNPF9EFZVKto',NULL,0,NULL,'晚风记秋凉','TeuusO8CGJYCnn6j9ocARw=='),('dec222ff9dff440ea3227c86783442a2',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-21 19:29:36','黑龙江省哈尔滨市阿城区哈阿公路','2019-11-21 19:44:41',2,'onh0a42BGd8Ah12lIkvFvukiZ88g',NULL,0,NULL,'珊珊',NULL),('ebd924f7cb284147acdc91d9d641b904',NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-20 19:06:17','江苏省苏州市吴江区鲈乡南路','2019-11-20 19:06:19',1,'onh0a4-GODHXgGAj4QEe11h8BrOI',NULL,0,NULL,'outas',NULL);

--
-- Table structure for table `dictionary`
--

DROP TABLE IF EXISTS `dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dictionary` (
  `dictionary_id` varchar(64) NOT NULL,
  `name` varchar(128) NOT NULL,
  `value` varchar(128) NOT NULL,
  `detail` varchar(512) DEFAULT NULL,
  `parent_id` varchar(64) DEFAULT NULL,
  `root_id` varchar(64) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`dictionary_id`),
  KEY `parent_id` (`parent_id`),
  KEY `fk_dictionary_root_id` (`root_id`),
  CONSTRAINT `fk_dictionary_parent_id` FOREIGN KEY (`parent_id`) REFERENCES `dictionary` (`dictionary_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_dictionary_root_id` FOREIGN KEY (`root_id`) REFERENCES `dictionary` (`dictionary_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictionary`
--

INSERT INTO `dictionary` VALUES ('08b89ec18cec41608872b69ab600a27d','联系人身份','CONT_ROLE',NULL,NULL,'08b89ec18cec41608872b69ab600a27d','2019-11-13 11:29:44'),('08bf8a69324740729dacf30109672f3d','服务方式','SERVICE_TYPE',NULL,NULL,'08bf8a69324740729dacf30109672f3d','2019-11-13 11:33:33'),('1','性别','GENDER','性别是公用字典',NULL,'1','2018-01-22 21:48:38'),('2','保密','SECRET','保密或未知','1','1','2018-01-22 22:53:21'),('2aa59c5c1e8b45879679799206bfc1b1','水泥','CEMENT',NULL,'658dddf5bed44e63a24c0c7a0d748748','658dddf5bed44e63a24c0c7a0d748748','2019-11-13 11:47:00'),('3','男','MALE','男孩、男士、雄性','1','1','2018-01-22 22:53:35'),('3733a5fb27b144a8acc64748027c0715','仓库业主','WH_OWNER',NULL,'08b89ec18cec41608872b69ab600a27d','08b89ec18cec41608872b69ab600a27d','2019-11-13 11:31:54'),('3960aabbe8444aa6bff22079425c034c','适用于丙一类','C1',NULL,'d2d8ec22e4004e30bc84f79e6975004d','d2d8ec22e4004e30bc84f79e6975004d','2019-11-13 11:42:46'),('3c207a2233bf48b28d3f7556989450c3','运营方','OPERATE',NULL,'08b89ec18cec41608872b69ab600a27d','08b89ec18cec41608872b69ab600a27d','2019-11-13 11:32:22'),('4','女','FEMALE','女孩、女士、雌性','1','1','2018-01-22 22:53:45'),('434137eefb1b4805bbcc8a89ddfc6bdf','适用于丙二类','C2',NULL,'d2d8ec22e4004e30bc84f79e6975004d','d2d8ec22e4004e30bc84f79e6975004d','2019-11-13 11:42:37'),('4f5ab389abb24989ba6db0451b3491a9','其他','OTHER',NULL,'d2d8ec22e4004e30bc84f79e6975004d','d2d8ec22e4004e30bc84f79e6975004d','2019-11-13 11:41:57'),('5','权限类型','AUTHORITY_TYPE','权限的类型',NULL,'5','2018-01-22 22:54:26'),('53167877808f401c87c5546003d9a3f2','环氧','EPOXY-',NULL,'658dddf5bed44e63a24c0c7a0d748748','658dddf5bed44e63a24c0c7a0d748748','2019-11-13 11:45:53'),('57d20201f800437ea82488ab794c2611','冷冻仓','FREEZE',NULL,'e03bfcf1fd724d698e3fad9ed72f63ca','e03bfcf1fd724d698e3fad9ed72f63ca','2019-11-13 11:24:40'),('6','菜单','MENU','一级菜单项及相关接口权限','5','5','2018-01-22 22:54:55'),('658dddf5bed44e63a24c0c7a0d748748','地坪材质','FLOOR_MATERIAL',NULL,NULL,'658dddf5bed44e63a24c0c7a0d748748','2019-11-13 11:44:02'),('6a1070f7aa614d1d8f9a1554a01694ab','中介','AGENCY',NULL,'08b89ec18cec41608872b69ab600a27d','08b89ec18cec41608872b69ab600a27d','2019-11-13 11:33:12'),('6a93d3d43b9f4d359dfd4820d779a245','恒温仓','CONST_TEMP',NULL,'e03bfcf1fd724d698e3fad9ed72f63ca','e03bfcf1fd724d698e3fad9ed72f63ca','2019-11-13 11:24:09'),('7','页面','PAGE','页面菜单项及相关接口权限','5','5','2018-01-22 22:55:28'),('8','操作','ACTION','操作及相关接口权限','5','5','2018-01-22 22:55:40'),('81357983bac54b27b817bc851916f97d','委托类型','ENTRUST_TYPE',NULL,NULL,'81357983bac54b27b817bc851916f97d','2019-11-13 11:14:38'),('84747ec34f2948c0b77fbbea781915cc','危险品仓','DANGER',NULL,'e03bfcf1fd724d698e3fad9ed72f63ca','e03bfcf1fd724d698e3fad9ed72f63ca','2019-11-13 11:25:08'),('8b38c7310afe4259be245d167fc8838a','仓库租赁','WH_RENT',NULL,'08bf8a69324740729dacf30109672f3d','08bf8a69324740729dacf30109672f3d','2019-11-13 11:34:54'),('8cc40c47bb8249128146692f519bd9cc','地砖','TILE',NULL,'658dddf5bed44e63a24c0c7a0d748748','658dddf5bed44e63a24c0c7a0d748748','2019-11-13 11:45:23'),('934c5cc01a524493b14be0ca7f4a36a0','化工仓','CHEMICAL',NULL,'e03bfcf1fd724d698e3fad9ed72f63ca','e03bfcf1fd724d698e3fad9ed72f63ca','2019-11-13 11:25:22'),('93aea611b4a742d8a46b2aa300e1bd89','成为合作社','COOP',NULL,'81357983bac54b27b817bc851916f97d','81357983bac54b27b817bc851916f97d','2019-11-13 11:22:27'),('9a2ebf36562e4762ace09ab1bc6b54de','委托招商','BUSINESS',NULL,'81357983bac54b27b817bc851916f97d','81357983bac54b27b817bc851916f97d','2019-11-13 11:21:08'),('a3e54b77ffc24b28bc7aec6aa8fcaf39','电子商务','EC',NULL,'08bf8a69324740729dacf30109672f3d','08bf8a69324740729dacf30109672f3d','2019-11-13 11:37:40'),('a8e8c9029a234a45a3fb110c2f45fa9c','普通仓','NORMAL',NULL,'e03bfcf1fd724d698e3fad9ed72f63ca','e03bfcf1fd724d698e3fad9ed72f63ca','2019-11-13 11:23:31'),('b1fd9c6184c84c399e7c6a120fb92b78','混凝土','CONCRETE',NULL,'658dddf5bed44e63a24c0c7a0d748748','658dddf5bed44e63a24c0c7a0d748748','2019-11-13 11:44:49'),('bb9ded66a76d41e2baf86e57730ce750','仓配一体服务','DELY_STORE',NULL,'08bf8a69324740729dacf30109672f3d','08bf8a69324740729dacf30109672f3d','2019-11-13 11:36:32'),('cdbb15a458ac4bb3887b6c1c5b3e565d','无','NULL',NULL,'d2d8ec22e4004e30bc84f79e6975004d','d2d8ec22e4004e30bc84f79e6975004d','2019-11-13 11:43:18'),('d2d8ec22e4004e30bc84f79e6975004d','适用类型','SUIT_TYPE',NULL,NULL,'d2d8ec22e4004e30bc84f79e6975004d','2019-11-13 11:41:42'),('e03bfcf1fd724d698e3fad9ed72f63ca','存储类型','STORE_TYPE',NULL,NULL,'e03bfcf1fd724d698e3fad9ed72f63ca','2019-11-13 11:23:15'),('ebf67740cfc643ffa29c28a776e7ed82','金刚砂','CORUNDUM',NULL,'658dddf5bed44e63a24c0c7a0d748748','658dddf5bed44e63a24c0c7a0d748748','2019-11-13 11:46:32');

--
-- Table structure for table `entrust`
--

DROP TABLE IF EXISTS `entrust`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrust` (
  `et_id` varchar(64) NOT NULL COMMENT '主键',
  `custom_id` varchar(64) NOT NULL COMMENT '客户id',
  `et_no` varchar(32) NOT NULL COMMENT '招商单号',
  `space` decimal(10,2) NOT NULL COMMENT '面积',
  `type` varchar(16) NOT NULL COMMENT '类型',
  `wh_region` varchar(64) NOT NULL COMMENT '区域',
  `cont_tel` varchar(32) DEFAULT NULL COMMENT '联系人电话',
  `processed` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否处理',
  `start_rent_date` datetime DEFAULT NULL COMMENT '租用日期',
  `end_rent_date` datetime DEFAULT NULL COMMENT '到期日期',
  `remarks` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `service` varchar(32) DEFAULT NULL COMMENT '服务方式',
  PRIMARY KEY (`et_id`),
  UNIQUE KEY `business_invitation_zs_no_uindex` (`et_no`),
  KEY `FK_bsiv_custom` (`custom_id`),
  CONSTRAINT `FK_bsiv_custom` FOREIGN KEY (`custom_id`) REFERENCES `custom` (`custom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='委托';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrust`
--

INSERT INTO `entrust` VALUES ('b72368b1c7ff419a9ccc13161e2e696d','8ada94544465419284e4a71c705e3ff8','ZS0000000009',35000.00,'COOP','江苏省,苏州市,吴江区','18662159068',0,'2019-11-21 00:00:00','2026-11-21 00:00:00','','2019-11-21 19:53:33','仓库租赁,仓配一体服务,电商服务'),('da5326d9bc5542d09ad75c8d345dd95b','778b64d34f5c4f57a9ae7fda95dfe983','ZS0000000008',115.00,'BUSINESS','北京市,北京市,东城区','15501507955',0,'2019-11-15 00:00:00','2019-11-20 00:00:00','','2019-11-20 17:06:49','');

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `feed_id` varchar(64) NOT NULL COMMENT '主键',
  `custom_id` varchar(64) NOT NULL COMMENT '反馈用户的id',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '反馈类型',
  `detail` varchar(256) DEFAULT NULL COMMENT '建议内容',
  `img1` varchar(512) DEFAULT NULL COMMENT '反馈图片1',
  `img2` varchar(512) DEFAULT NULL COMMENT '反馈图片2',
  `img3` varchar(512) DEFAULT NULL COMMENT '反馈图片3',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已阅',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`feed_id`),
  KEY `fk_feedback_custom` (`custom_id`),
  CONSTRAINT `fk_feedback_custom` FOREIGN KEY (`custom_id`) REFERENCES `custom` (`custom_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='意见反馈';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--


--
-- Table structure for table `look4wh`
--

DROP TABLE IF EXISTS `look4wh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `look4wh` (
  `fwh_id` varchar(64) NOT NULL COMMENT '主键',
  `custom_id` varchar(64) NOT NULL COMMENT '客户id',
  `zc_no` varchar(32) NOT NULL COMMENT '找仓单号',
  `space` decimal(10,2) NOT NULL COMMENT '面积',
  `wh_region` varchar(64) NOT NULL COMMENT '区域',
  `cont_tel` varchar(32) DEFAULT NULL COMMENT '联系人电话',
  `processed` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否处理',
  `service_type` varchar(64) DEFAULT NULL COMMENT '服务方式',
  `start_rent_date` datetime DEFAULT NULL COMMENT '租用日期',
  `end_rent_date` datetime DEFAULT NULL COMMENT '到期日期',
  `remarks` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`fwh_id`),
  UNIQUE KEY `find_warehouse_zc_no_uindex` (`zc_no`),
  KEY `FK_findwh_custom` (`custom_id`),
  CONSTRAINT `FK_findwh_custom` FOREIGN KEY (`custom_id`) REFERENCES `custom` (`custom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='找仓';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `look4wh`
--

INSERT INTO `look4wh` VALUES ('05d430e00ee94d08be8b0efef7d787b8','778b64d34f5c4f57a9ae7fda95dfe983','ZC0000000006',3928.00,'北京市,北京市,东城区','15501501472',0,'仓库租赁','2019-11-19 00:00:00','2019-11-20 00:00:00','123456','2019-11-20 16:41:49'),('c72bff871d40403ca95fe22b14a7e309','778b64d34f5c4f57a9ae7fda95dfe983','ZC0000000005',300.00,'江苏省,苏州市,吴江区','15501507955',0,'仓库租赁','2019-11-16 00:00:00','2019-11-20 00:00:00',NULL,'2019-11-20 15:31:05'),('e134b580d08c48c798cffb6b77d06a1c','c67af0d939b64090ae78740dde37a218','ZC0000000007',111.00,'北京市,北京市,东城区','18157233033',0,'仓配一体服务','2019-11-20 00:00:00','2019-12-20 00:00:00',NULL,'2019-11-20 16:49:13');

--
-- Table structure for table `reserve`
--

DROP TABLE IF EXISTS `reserve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserve` (
  `rs_id` varchar(64) NOT NULL COMMENT '主键',
  `custom_id` varchar(64) NOT NULL COMMENT '客户id',
  `wh_id` varchar(64) DEFAULT NULL COMMENT '仓库id',
  `yy_no` varchar(32) NOT NULL COMMENT '预约单号',
  `rent` int(11) NOT NULL COMMENT '预计租期',
  `service` varchar(32) NOT NULL COMMENT '需求服务',
  `cont` varchar(32) DEFAULT NULL COMMENT '联系人',
  `cont_tel` varchar(32) DEFAULT NULL COMMENT '联系人电话',
  `company_name` varchar(32) DEFAULT NULL COMMENT '公司名',
  `from_time` datetime DEFAULT NULL COMMENT '看仓日期从',
  `to_time` datetime DEFAULT NULL COMMENT '看仓日期到',
  `goods` varchar(32) DEFAULT NULL COMMENT '货物名',
  `remarks` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `processed` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已处理',
  PRIMARY KEY (`rs_id`),
  UNIQUE KEY `reserve_yy_no_uindex` (`yy_no`),
  KEY `FK_reserve_custom` (`custom_id`),
  KEY `FK_reserve_warehouse` (`wh_id`),
  CONSTRAINT `FK_reserve_custom` FOREIGN KEY (`custom_id`) REFERENCES `custom` (`custom_id`),
  CONSTRAINT `FK_reserve_warehouse` FOREIGN KEY (`wh_id`) REFERENCES `warehouse` (`wh_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='预约管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserve`
--

INSERT INTO `reserve` VALUES ('6247e4c1087b4161893a1e8fd056784b','778b64d34f5c4f57a9ae7fda95dfe983','b8733e51c68c451296c5d8dfe187d083','YY0000000029',19,'租赁服务','陈先生','15502501988','博匠','2019-11-21 00:00:00','2019-11-21 00:00:00','化工产品',NULL,'2019-11-21 09:29:26',1);

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

INSERT INTO `role` VALUES ('5d8de0659e56477e8fa5dfccdc3a5bad','超级管理员','2019-10-12 15:37:00'),('86a36022806f4e5a859b15444fbc737f','吴江区','2019-11-20 14:43:00');

--
-- Table structure for table `role_authority`
--

DROP TABLE IF EXISTS `role_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_authority` (
  `role_id` varchar(64) NOT NULL,
  `authority_id` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`role_id`,`authority_id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `role_authority_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`authority_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_authority`
--

INSERT INTO `role_authority` VALUES ('5d8de0659e56477e8fa5dfccdc3a5bad','0695a3e57b2448f0aa995ccf2223d5b0','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','1285ea2373ba4f0ca955ca2622d2d37b','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','1874c9cdc0dc4a5daf330564ddd3d0f1','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','25cd190ecf3f4060a150309e665b9996','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','2746d1bc282846a080b64f5385adb720','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','2996886f4d07459496912fb594914684','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','2b31f97e9c614407960c66e8bafe6dd4','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','2ba5aafb6d1542c69ab83ecd24dcc8ed','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','2f7a108ee4a74cee84bd73461ce8e946','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','3020baa041cd43ee9ccd83e808d51e7c','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','3161e25a68c14840bad2e52a0ba7b728','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','35a218fbcab14b2b9641e7ddc8c1f0cc','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','3d2aef5e62fa4a01b8f08b7e2e3df3d6','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','439b658ed5da4ff3bc8387d268198ca1','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','55dfc988415d42f79ed4e85af60785d5','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','56d40dbbc7614261bd6c79d3c9355e9a','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','5fe1579048a9458dbf5204e6c0172599','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','616a365aa7e24c06bb6faf1af3787fd7','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','64796127161348408e4dab0ea5ce9286','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','660bf4a4bf96400ba74bd444713c6bde','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','68c0244d4b904cbf8a5bcecd6922fdeb','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','696530012d3347eab22e22876bbead3c','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','69f2912174d74bbda9dc88bbfee769c8','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','7021e4da9d374306813e059875a45257','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','721c820142e2453ca7308c53171193d6','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','8314df81d6a041869076eb34a338cc4a','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','848e220b728c41a1847f9f19d4eb0cd8','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','8e32ed2502a441d6a11e662af0db0668','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','98485d1811b14fd080726a19196c50d6','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','9e246dcc68ec4a6c9f3adb723d1fb9af','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','a6ab73df13e1423a8b07076aa8ee131b','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','a829cb16d92c4d3c9bccc48094ef702b','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','b7c360daad8445c195373455dbb95e69','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','bab69bb98656409d8356d4e69de45b16','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','c541c69c2a2f4941aee189d1f4ade0ef','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','c60250b96fb44fd0a35917555698ff76','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','cae47c2a08a54665806eed3cfa219dc3','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','d2a6ea7e3fe6442185d5a1ac1dece4da','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','d961897d714041148e4bc24f2f72507b','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','dddb989ca49749c79a1734fd7eca4b5d','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','ded4d6134e624faea7d4bd6e74eeacff','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','e1fbc73fe03040b4869e0e8cc4e2dc31','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','e41b2a843d0747e7bd10637e5bbf90a5','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','eab537e9ab7445f4932eced6b17c398b','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','ec27bf51312b45e3b63625d1adf72991','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','ec5310b9806a405cbf7ea81bcf09b7df','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','ef4c0228288c4fefa5e31112ba8ae974','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','f3b4d5f9147d44d9b2f33368dc87addb','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','f5f22b2e50c24342b34ab7ab4259296a','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','f680b708a261407ea4db6b93c6f30f8d','2019-11-20 17:21:26'),('5d8de0659e56477e8fa5dfccdc3a5bad','ffe70c72909f41c797f0662b9c8ce7f7','2019-11-20 17:21:26'),('86a36022806f4e5a859b15444fbc737f','0695a3e57b2448f0aa995ccf2223d5b0','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','1285ea2373ba4f0ca955ca2622d2d37b','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','1874c9cdc0dc4a5daf330564ddd3d0f1','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','25cd190ecf3f4060a150309e665b9996','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','2746d1bc282846a080b64f5385adb720','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','2b31f97e9c614407960c66e8bafe6dd4','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','2ba5aafb6d1542c69ab83ecd24dcc8ed','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','2f7a108ee4a74cee84bd73461ce8e946','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','3020baa041cd43ee9ccd83e808d51e7c','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','3161e25a68c14840bad2e52a0ba7b728','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','35a218fbcab14b2b9641e7ddc8c1f0cc','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','3d2aef5e62fa4a01b8f08b7e2e3df3d6','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','439b658ed5da4ff3bc8387d268198ca1','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','55dfc988415d42f79ed4e85af60785d5','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','56d40dbbc7614261bd6c79d3c9355e9a','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','5fe1579048a9458dbf5204e6c0172599','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','616a365aa7e24c06bb6faf1af3787fd7','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','64796127161348408e4dab0ea5ce9286','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','660bf4a4bf96400ba74bd444713c6bde','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','68c0244d4b904cbf8a5bcecd6922fdeb','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','696530012d3347eab22e22876bbead3c','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','69f2912174d74bbda9dc88bbfee769c8','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','7021e4da9d374306813e059875a45257','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','721c820142e2453ca7308c53171193d6','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','8314df81d6a041869076eb34a338cc4a','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','848e220b728c41a1847f9f19d4eb0cd8','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','8e32ed2502a441d6a11e662af0db0668','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','98485d1811b14fd080726a19196c50d6','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','9e246dcc68ec4a6c9f3adb723d1fb9af','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','a6ab73df13e1423a8b07076aa8ee131b','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','a829cb16d92c4d3c9bccc48094ef702b','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','b7c360daad8445c195373455dbb95e69','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','bab69bb98656409d8356d4e69de45b16','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','c60250b96fb44fd0a35917555698ff76','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','d2a6ea7e3fe6442185d5a1ac1dece4da','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','d961897d714041148e4bc24f2f72507b','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','dddb989ca49749c79a1734fd7eca4b5d','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','ded4d6134e624faea7d4bd6e74eeacff','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','e1fbc73fe03040b4869e0e8cc4e2dc31','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','eab537e9ab7445f4932eced6b17c398b','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','ec27bf51312b45e3b63625d1adf72991','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','ec5310b9806a405cbf7ea81bcf09b7df','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','ef4c0228288c4fefa5e31112ba8ae974','2019-11-20 14:56:16'),('86a36022806f4e5a859b15444fbc737f','f3b4d5f9147d44d9b2f33368dc87addb','2019-11-20 14:56:16');

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence` (
  `name` varchar(50) NOT NULL,
  `current_val` int(11) NOT NULL,
  `increment_val` int(11) NOT NULL DEFAULT '1',
  `desc` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COMMENT='序列表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

INSERT INTO `sequence` VALUES ('ZC',7,1,'找仓审核流水号序列'),('ZS',9,1,'招商审核流水号序列'),('CO',1,1,'合作仓审核流水号序列'),('YY',29,1,'预约管理流水号序列'),('QC',5,1,'仓库流水号');

--
-- Table structure for table `space_cond`
--

DROP TABLE IF EXISTS `space_cond`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `space_cond` (
  `sc_id` varchar(64) NOT NULL DEFAULT '' COMMENT '主键',
  `label` varchar(32) NOT NULL COMMENT '标签',
  `space` bigint(20) NOT NULL COMMENT '查询用的值',
  PRIMARY KEY (`sc_id`),
  UNIQUE KEY `space_cond_label_uindex` (`label`),
  UNIQUE KEY `space_cond_value_uindex` (`space`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='面积条件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `space_cond`
--

INSERT INTO `space_cond` VALUES ('13af73fb56c9427dab9c027aaa3ca8a1','≥5000㎡',5000),('18868088060c498f86724698a2c10821','≥200㎡',200),('2a44d2af3a7146c983975c60511e0dbf','≥1000万㎡',10000000),('386c3318f6704246b21b99d5815c9232','≥10㎡',10),('5452ce28684e4d7baedb81d6b2322694','≥100㎡',100),('e1b4f42cb979442d86dd5b0397afec7a','≥10万㎡',100000),('ede90598ff8d486785e9e799a978909f','≥1万㎡',10001);

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(256) NOT NULL,
  `nickname` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

INSERT INTO `user` VALUES ('17c7e0bf3f1441f794dd162f08f04c05','ACECHEN','$2a$10$wqkKxmCxrzqeN5BB3m3YKOwXaqVLP3CllAgbUHX8Xu2lnn7pPoD16','CC','2019-11-20 14:44:11'),('4d273232b0c947b0a0b450b96531acbd','outas','$2a$10$ZK5TO0MRt7fFy9ORZbFKg.k9tnuvym9tRsYdziIYIY2u5OseP5zPG','outas','2019-11-20 14:37:10'),('74b60d8441244183a304d4244d83d2aa','123456','$2a$10$thPtIW.us6pbx3ayuXOFn.XUvdMQpvCln.TUp0rx7bGipV75oj3ea','1','2019-11-20 14:57:20'),('9975041831644691acbd837d12be6a3d','admin','$2a$10$G3gWKllX0jupgjq6MWpP0eZE6Q.9RRm49A1VMY2Oz2OzXVDnOOa9G','系统管理员','2019-10-12 15:16:09');

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `role_id` varchar(64) NOT NULL,
  `user_id` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_role_user` (`role_id`),
  KEY `FK_user_role` (`user_id`),
  CONSTRAINT `FK_role_user` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_role` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` VALUES ('86a36022806f4e5a859b15444fbc737f','17c7e0bf3f1441f794dd162f08f04c05','2019-11-20 14:44:11'),('5d8de0659e56477e8fa5dfccdc3a5bad','4d273232b0c947b0a0b450b96531acbd','2019-11-20 14:37:52'),('5d8de0659e56477e8fa5dfccdc3a5bad','74b60d8441244183a304d4244d83d2aa','2019-11-20 14:57:20'),('5d8de0659e56477e8fa5dfccdc3a5bad','9975041831644691acbd837d12be6a3d','2019-11-04 16:57:14');

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouse` (
  `wh_id` varchar(64) NOT NULL COMMENT '仓库ID',
  `wh_no` varchar(64) NOT NULL COMMENT '仓库流水号',
  `custom_id` varchar(64) DEFAULT NULL COMMENT '客户id',
  `wh_name` varchar(64) DEFAULT NULL COMMENT '仓库名称',
  `wh_region` varchar(64) NOT NULL COMMENT '仓库所属区域',
  `wh_location_lng` decimal(16,8) DEFAULT NULL COMMENT '仓库位置经度',
  `wh_location_lat` decimal(16,8) DEFAULT NULL COMMENT '仓库位置纬度',
  `wh_address` varchar(128) DEFAULT NULL COMMENT '仓库详细地址',
  `wh_att` varchar(256) DEFAULT NULL COMMENT '仓库属性',
  `cont_role` varchar(16) DEFAULT NULL COMMENT '联系人身份',
  `cont_name` varchar(16) DEFAULT NULL COMMENT '联系人姓名',
  `cont_tel` varchar(32) DEFAULT NULL COMMENT '联系人电话',
  `cont_email` varchar(64) DEFAULT NULL COMMENT '联系人邮箱',
  `company_name` varchar(64) DEFAULT NULL COMMENT '企业名',
  `auth_status` int(11) NOT NULL DEFAULT '0' COMMENT '认证状态',
  `auth_remarks` varchar(512) DEFAULT NULL COMMENT '认证备注',
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '优先级',
  `auth_time` datetime DEFAULT NULL COMMENT '认证时间',
  `self_run` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否自营',
  `min_price` decimal(10,2) DEFAULT NULL COMMENT '租赁起价',
  `min_space` decimal(10,2) DEFAULT NULL COMMENT '起租面积',
  `avail_space` decimal(10,2) DEFAULT NULL COMMENT '可租面积',
  `total_space` decimal(10,2) DEFAULT NULL COMMENT '总面积',
  `store_type` varchar(64) DEFAULT NULL COMMENT '存储类型',
  `service_type` varchar(64) DEFAULT NULL COMMENT '服务类型',
  `wh_type` varchar(64) DEFAULT NULL COMMENT '仓库类型',
  `suit_type` varchar(32) DEFAULT NULL COMMENT '适用类型',
  `bottom_high` decimal(10,2) DEFAULT NULL COMMENT '底层层高',
  `min_rent` int(11) DEFAULT NULL COMMENT '起租期限',
  `bounded` tinyint(1) DEFAULT '0' COMMENT '是否保税',
  `builded_year` varchar(16) DEFAULT NULL COMMENT '建造年代',
  `building_state` varchar(64) DEFAULT NULL COMMENT '建设状态',
  `safety` int(11) DEFAULT NULL COMMENT '耐火等级',
  `fire_inspected` tinyint(1) DEFAULT NULL COMMENT '消防校验',
  `fire_grade` int(11) DEFAULT NULL COMMENT '消防等级',
  `floor_material` varchar(64) DEFAULT NULL COMMENT '地坪材质',
  `floor_function` varchar(64) DEFAULT NULL COMMENT '地坪功能',
  `security` varchar(64) DEFAULT NULL COMMENT '园区安保',
  `facilities` varchar(128) DEFAULT NULL COMMENT '仓库设施',
  `power_method` varchar(64) DEFAULT NULL COMMENT '供电方式',
  `power_voltage` varchar(64) DEFAULT NULL COMMENT '供电电压',
  `structure` varchar(64) DEFAULT NULL COMMENT '建筑结构',
  `brand` varchar(32) DEFAULT NULL COMMENT '品牌商',
  `invoiced` tinyint(1) NOT NULL DEFAULT '0' COMMENT '开具发票',
  `gate_count` int(11) DEFAULT NULL COMMENT '出入口个数',
  `gate_size` decimal(10,2) DEFAULT NULL COMMENT '出入口宽高',
  `des` varchar(1024) DEFAULT NULL COMMENT '仓库详情描述',
  `base_img1` varchar(512) DEFAULT NULL COMMENT '基本信息图片1',
  `base_img2` varchar(512) DEFAULT NULL COMMENT '基本信息图片2',
  `base_img3` varchar(512) DEFAULT NULL COMMENT '基本信息图片3',
  `base_img4` varchar(512) DEFAULT NULL COMMENT '基本信息图片4',
  `base_img5` varchar(512) DEFAULT NULL COMMENT '基本信息图片5',
  `base_img6` varchar(512) DEFAULT NULL COMMENT '基本信息图片6',
  `base_img7` varchar(512) DEFAULT NULL COMMENT '基本信息图片7',
  `base_img8` varchar(512) DEFAULT NULL COMMENT '基本信息图片8',
  `auth_img1` varchar(512) DEFAULT NULL COMMENT '认证信息图片1',
  `auth_img3` varchar(512) DEFAULT NULL COMMENT '认证信息图片3',
  `auth_img2` varchar(512) DEFAULT NULL COMMENT '认证信息图片2',
  `auth_img4` varchar(512) DEFAULT NULL COMMENT '认证信息图片4',
  `auth_img5` varchar(512) DEFAULT NULL COMMENT '认证信息图片5',
  `auth_img6` varchar(512) DEFAULT NULL COMMENT '认证信息图片6',
  `auth_img7` varchar(512) DEFAULT NULL COMMENT '认证信息图片7',
  `auth_img8` varchar(512) DEFAULT NULL COMMENT '认证信息图片8',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`wh_id`),
  KEY `FK_warehouse_custom` (`custom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='仓库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

INSERT INTO `warehouse` VALUES ('0ac49e7440d743e99b58f2bebb234614','QC0000000005','81f9e2b63422451e9480b645e58628c0','秦仓贰号-中鲈仓','江苏省,苏州市,吴江区',120.64040000,31.02668600,'欧盛大道五号',NULL,'仓库业主','薛彬','18112748629','ace@bojumper.com','秦仓互联',1,NULL,0,'2019-11-22 14:53:38',1,0.80,1.00,5000.00,10000.00,'普通仓','仓配一体服务','楼库','适用于丙类二类',4.00,1,0,'2006年','已建设',1,1,1,'金刚砂','耐磨','园区保安,视频监控','办公室,停车场,宿舍,食堂,电梯','双电路','220V,380V','钢混结构','无',1,0,0.00,'交通便利，距离G50沪渝高速1.5公里，G318国道3公里，处于上海、苏州和浙江嘉兴交汇处，距离苏州市30公里，苏州工业园区25公里，上海50公里，嘉兴30公里，内部设有超市饭店宿舍停车场及公共娱乐设施','/img/81f9e2b63422451e9480b645e58628c0/warehouse/info/50dd538cff794621a6fc7e050e687538.jpg','/img/81f9e2b63422451e9480b645e58628c0/warehouse/info/36f26986f3ee4fd497d1357b7440c702.jpg','/img/81f9e2b63422451e9480b645e58628c0/warehouse/info/235ea3e3efc442c99926cd45e6a2bc63.jpg','/img/81f9e2b63422451e9480b645e58628c0/warehouse/info/0d316466236b4140a15b37ac77153d1c.jpg','','','','','/img/81f9e2b63422451e9480b645e58628c0/warehouse/auth/05c911d09ab349768a1d60fc31322e72.jpg','','','','','','','','2019-11-22 14:17:26',NULL),('b8733e51c68c451296c5d8dfe187d083','QC0000000002','81f9e2b63422451e9480b645e58628c0','秦仓壹号-吴江综保仓','江苏省,苏州市,吴江区',120.67989000,31.09891100,'庞金路688号',NULL,'仓库业主','薛彬','18112748629','ACE@163.com','秦仓互联',1,NULL,0,'2019-11-21 10:47:01',1,0.75,1.00,3600.00,4000.00,'普通仓','仓库租赁,仓配一体服务','平库,高台库','适用于丙类二类',8.00,1,1,'2010','已建设',1,1,1,'环氧','耐磨','园区保安','月台,办公室,停车场,宿舍','双电路,单电路','220V,380V','钢混结构','无',1,0,0.00,'离吴江南出口0.5公里，交通方便，场地大','/img/81f9e2b63422451e9480b645e58628c0/warehouse/info/7b9fb05b0eee4b5f8557ebeb1a2acc5a.jpg','/img/81f9e2b63422451e9480b645e58628c0/warehouse/info/ce44046fe80c495ca0e3ea27e6500187.jpg','/img/81f9e2b63422451e9480b645e58628c0/warehouse/info/01e2649a6a2341ee819643dddf8cf10f.jpg','/img/81f9e2b63422451e9480b645e58628c0/warehouse/info/c95f6f02b6c542b39119856cac5c96d7.jpg','/img/81f9e2b63422451e9480b645e58628c0/warehouse/info/6642644fe2074001b1a757b4a9e12290.jpg','','','','/img/81f9e2b63422451e9480b645e58628c0/warehouse/auth/2da440cb39d241bbbbcd494216648835.jpg','','','','','','','','2019-11-20 13:34:02',NULL);

--
-- Table structure for table `wh_collection`
--

DROP TABLE IF EXISTS `wh_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wh_collection` (
  `custom_id` varchar(64) NOT NULL COMMENT '用户id',
  `wh_id` varchar(64) NOT NULL COMMENT '仓库id',
  `create_time` datetime DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`custom_id`,`wh_id`),
  KEY `FK_wh_custom` (`wh_id`),
  KEY `FK_customa_wh` (`custom_id`),
  CONSTRAINT `FK_custom_wh` FOREIGN KEY (`custom_id`) REFERENCES `custom` (`custom_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_wh_custom` FOREIGN KEY (`wh_id`) REFERENCES `warehouse` (`wh_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户收藏的仓库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wh_collection`
--

INSERT INTO `wh_collection` VALUES ('365ad77167ad4fe5a919f4000ea0a122','b8733e51c68c451296c5d8dfe187d083','2019-11-21 15:20:43'),('778b64d34f5c4f57a9ae7fda95dfe983','b8733e51c68c451296c5d8dfe187d083','2019-11-20 15:35:58'),('81f9e2b63422451e9480b645e58628c0','b8733e51c68c451296c5d8dfe187d083','2019-11-22 09:47:58'),('c67af0d939b64090ae78740dde37a218','b8733e51c68c451296c5d8dfe187d083','2019-11-20 16:47:54');
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-22 15:32:16
