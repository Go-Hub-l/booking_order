
ALTER TABLE station_info MODIFY COLUMN tid INT AUTO_INCREMENT;

ALTER TABLE station_info ADD COLUMN create_time TIMESTAMP; 
ALTER TABLE station_info ADD COLUMN datachange_time TIMESTAMP default now(); 

ALTER TABLE station_info ADD CONSTRAINT unique_station_code UNIQUE(station_code);

select *from station_info;

DESC station_info;
delete from station_info;

show master status;

UPDATE station_info set create_time = '2024-09-09 19:50:12' where tid = 10006;

INSERT INTO station_info(station_name) Values('测试');
INSERT INTO station_info(station_name) Values('测试2');

SELECT *FROM station_info WHERE station_name = '测试';
SELECT *FROM station_info WHERE station_code in('hfh', 'AOH', 'ENH', 'TJP');

UPDATE station_info set create_time = '2024-09-10 18:41:57' where tid = 13342;

select *from station_stop_info;

select *from ticket_info;
select count(*) from ticket_info;
select train_number, depart_station_code, arrive_station_code, count(*) FROM ticket_info GROUP BY train_number, depart_station_code, arrive_station_code;

delete from ticket_info;
delete from station_stop_info;