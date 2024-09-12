CREATE DATABASE train_booking;

USE train_booking;

create table station_info (
	tid int primary key auto_increment comment '主键',
	station_name varchar(25) comment '车站名',
    station_code varchar(3) comment '车站三字码',
    station_spell varchar(30) comment '车站名拼音',
    station_szm varchar(10) comment '车站首字母',
    station_count int comment '车站数',
    city_name varchar(30) comment '城市名',
    city_id varchar(10) comment '城市id',
    create_time TIMESTAMP,
    datachange_time TIMESTAMP default now()
) engine=InnoDB;

show databases;