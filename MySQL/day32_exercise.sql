## trip.sql#############################################################################################################
/*
SQLlog Ultimate v8.32
MySQL - 5.6.40-log : Database - spring_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spring_db`;

/*Table structure for table `tb_trip` */

DROP TABLE IF EXISTS `tb_trip`;

CREATE TABLE `tb_trip` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                           `username` varchar(35) DEFAULT NULL COMMENT '用户名称',
                           `gender` int(1) DEFAULT NULL COMMENT '用户性别 0:女 1:男',
                           `idcard` varchar(15) DEFAULT NULL COMMENT '身份证',
                           `from_address` varchar(255) DEFAULT NULL COMMENT '出发地',
                           `to_address` varchar(255) DEFAULT NULL COMMENT '到达地',
                           `start_time` datetime DEFAULT NULL COMMENT '出发时间',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `tb_trip` */

insert  into `tb_trip`(`id`,`username`,`gender`,`idcard`,`from_address`,`to_address`,`start_time`) values (1,'张伟',1,'610112200002029','北京','西安','2022-01-22 21:36:20'),(2,'王伟',1,'610112200002024','天津','南京','2022-01-22 21:36:20'),(3,'张敏',0,'610112200002023','西安','深圳','2022-01-22 21:36:20'),(4,'王磊',1,'610112200002028','太原','西安','2022-01-22 21:36:20'),(5,'王强',1,'610112200002024','吉林','长春','2022-01-22 21:36:20'),(6,'张艳',0,'610112200101015','西安','广州','2022-01-22 21:36:20'),(7,'李明',1,'610112200101019','长沙','武汉','2022-01-22 21:36:20'),(8,'刘敏',0,'610112200101017','成都','重庆','2022-01-22 21:36:20'),(9,'王平',1,'610112200101019','石家庄','郑州','2022-01-22 21:36:20'),(10,'李桂英',0,'610112200101014','杭州','西安','2022-01-22 21:36:20'),(11,'张强',1,'110101199003074','南京','南宁','2022-01-22 21:36:20'),(12,'王杰',1,'110101199003077','西宁','西安','2022-01-22 21:36:20'),(13,'王静',0,'110101199003074','贵阳','贵州','2022-01-22 21:36:20'),(14,'张丽',0,'110101199003075','杭州','福州','2022-01-22 21:36:20'),(15,'王娟',0,'110101199003070','厦门','长春','2022-01-22 21:36:20');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

## user.sql#############################################################################################################
/*
SQLlog Ultimate v8.32
MySQL - 5.6.40-log : Database - spring_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spring_db`;

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                           `username` varchar(35) DEFAULT NULL COMMENT '用户名称',
                           `gender` int(1) DEFAULT NULL COMMENT '用户性别 0:女 1:男',
                           `idcard` varchar(15) DEFAULT NULL COMMENT '身份证',
                           `in_time` date DEFAULT NULL COMMENT '入职时间',
                           `status` int(2) DEFAULT NULL COMMENT '员工状态1:正常，2:离职',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`username`,`gender`,`idcard`,`in_time`,`status`) values (1,'张伟',1,'610112200002029','2020-01-22',1),(2,'王伟',1,'610112200002024','2019-01-22',1),(3,'张敏',0,'610112200002023','2018-02-02',1),(4,'王磊',1,'610112200002028','2010-03-11',1),(5,'王强',1,'610112200002024','2022-01-22',1),(6,'张艳',0,'610112200101015','2022-01-08',1),(7,'李明',1,'610112200101019','2021-01-23',1),(8,'刘敏',0,'610112200101017','2021-01-22',1),(9,'王平',1,'610112200101019','2021-01-22',1),(10,'李桂英',0,'610112200101014','2019-04-05',1),(11,'张强',1,'110101199003074','2019-08-05',1),(12,'王杰',1,'110101199003077','2019-08-22',1),(13,'王静',0,'110101199003074','2021-06-22',1),(14,'张丽',0,'110101199003075','2020-01-22',1),(15,'王娟',0,'110101199003070','2021-01-01',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

## 构建表tb_trip_new,需要将tb_trip表中的冗余数据，使用用户ID来替换##############################################################
CREATE TABLE `tb_trip_new` (
                               `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                               `user_id` BIGINT(20) DEFAULT NULL COMMENT '员工ID',
                               `from_address` VARCHAR(255) DEFAULT NULL COMMENT '出发地',
                               `to_address` VARCHAR(255) DEFAULT NULL COMMENT '到达地',
                               `start_time` DATETIME DEFAULT NULL COMMENT '出发时间',
                               PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8

## 编写Sql语句完成数据的导入，用户的身份证号是一致的，可以使用身份证号进行关联查询#####################################################
INSERT INTO tb_trip_new (user_id,from_address,to_address,start_time)
SELECT u.id,p.from_address,p.to_address,p.start_time
FROM tb_user u LEFT JOIN tb_trip p ON u.idcard = p.idcard