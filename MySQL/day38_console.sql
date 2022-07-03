CREATE DATABASE day38;

USE day38;

-- 创建表
CREATE TABLE `user` (
                        `id`        BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '编号' ,
                        `name`      VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名' ,
                        `password`  VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码' ,
                        `gender`    VARCHAR(2) NOT NULL COMMENT '性别' ,
                        `age`       INT(3) NOT NULL COMMENT '年龄' ,
                        `tel`       VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话' ,
                        PRIMARY KEY (`id`)
);
-- 插入测试数据
INSERT INTO `user` VALUES(NULL,'zs','123','男',8,'13112345677')
                        ,(NULL,'ls','456','女',18,'13112345678')
                        ,(NULL,'ww','789','男',28,'13112345679')
                        ,(NULL,'传智播客','itcast','男',38,'4001684000');