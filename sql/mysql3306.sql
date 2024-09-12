use train_booking;

-- 查看主库写入位置
SHOW MASTER STATUS;


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

-- 车票信息 
create table ticket_info (
	tid int primary key auto_increment comment '主键',
	train_number_code varchar(25) comment '车次代号',
    train_number varchar(30) comment '车次',
    start_station_code varchar(10) comment '始发站代号',
    end_station_code varchar(10) comment '终达站代号',
    depart_station_code varchar(10) comment '出发站代号',
    arrive_station_code varchar(10) comment '到达站代号',
    depart_time varchar(30) comment '出发时间 HH:mm',
    arrive_time varchar(30) comment '到达时间 HH:mm',
    spend_time varchar(30) comment '耗时 HH:mm',
    soft_seat_left int comment '软卧余票数',
    no_seat_left int comment '无座余票数',
    hard_bed_left int comment '硬卧余票数',
    hard_seat_left int comment '硬座余票数',
    second_seat_left int comment '二等座余票数',
    first_seat_left int comment '一等座余票数',
    business_seat_left int comment '商务/特等座余票数',
    create_time TIMESTAMP default now(),
    datachange_time TIMESTAMP default now()
) engine=InnoDB;

-- 经停站信息
create table station_stop_info (
	tid int primary key auto_increment comment '主键',
	station_name varchar(25) comment '车站名',
    train_class_name varchar(30) comment '火车类型：高速',
    start_station_name varchar(30) comment '出发站名',
    end_station_name varchar(30) comment '到达站名',
    station_train_code varchar(10) comment '车次号',
    is_enabled TINYINT(1) comment '是否启用',
    start_time int comment '出发时间HH:mm',
    arrive_time int comment '到达时间HH:mm',
    station_no int comment '车站顺序',
    stopover_time varchar(30) comment '经停时间：2分钟',
    create_time TIMESTAMP default now(),
    datachange_time TIMESTAMP default now()
) engine=InnoDB;
