drop database if exists usermanger;

create DATABASE if not exists usermanger  character set utf8;

use usermanger;

drop table if exists usermessage;
create table `usermessage` (
	`id` INT PRIMARY KEY auto_increment,
	`name` varchar (60),
	`username` varchar (60) default 'bit',
	`password` varchar (60) default '123456',
	`gender` varchar (4),
	`age` int,
	`address` varchar (90),
	`qq` varchar (20),
	`email` varchar (30)
);

INSERT INTO usermessage VALUES(1,'张飞','zhangfei','123','男',18,'成都','1262913815','126@qq.com');
INSERT INTO usermessage VALUES(2,'关羽','guanyu','1234','男',18,'陕西','1262913816','1262@qq.com');
INSERT INTO usermessage VALUES(3,'张三','zhangsan','1235','女',19,'陕西','1262913817','1263@qq.com');
INSERT INTO usermessage VALUES(4,'李四','lisi','1236','男',20,'北京','1262913818','1264@qq.com');
INSERT INTO usermessage VALUES(5,'王五','wangwu','1237','女',21,'陕西','1262913819','1265@qq.com');
INSERT INTO usermessage VALUES(6,'孙权','sunquan','1238','男',22,'上海','1262913814','1266@qq.com');
INSERT INTO usermessage VALUES(7,'孙悟空','sunwukong','1239','男',23,'陕西','1262913813','1267@qq.com');
