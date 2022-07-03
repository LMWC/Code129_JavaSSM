CREATE DATABASE day32;
USE day32;

-- 如果字段名和MySQL中的关键字重复，则加上``【tab键上面】，取消转义作用，作为普通的字段使用
-- 因为MySQL数据  字段名在windows环境下不区分大小写，但是在Linux环境下区分大小写
-- 所以：MySQL数据库表字段名一般都使用小写，如果有多个单词组成，则通过下划线_进行拼接

CREATE TABLE account(
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        `name` VARCHAR(40),
                        money INT
);

INSERT INTO account(`name`,money) VALUES('zs',1000);
INSERT INTO account(`name`,money) VALUES('ls',1000);
INSERT INTO account(`name`,money) VALUES('ww',1000);