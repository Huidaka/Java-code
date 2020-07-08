create database blogdemo2

use database

drop table if exists user;
create table user(
    userid int primary key auto_increment,
    username varchar(50) not null,
    password varchar(50) not null
);

drop table if exists article;
create table article(
    articleid int primary key auto_increment,
    title varchar(255) not null,
    content text not null,
    userid int not null,
    foreign key (userid) references user(userid)
);