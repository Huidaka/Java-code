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

INSERT INTO usermessage VALUES(1,'郭','root','123456','男',21,'河南','258*****370','258****370@qq.com');

