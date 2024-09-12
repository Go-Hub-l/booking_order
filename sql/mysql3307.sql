-- 创建复制用户
CREATE USER 'repl'@'%' IDENTIFIED BY 'XIAObing321.';
-- 赋予主从复制的权限
GRANT REPLICATION SLAVE ON *.* TO 'repl'@'%';

-- 获取主服务器的二进制日志文件名和位置
SHOW MASTER STATUS;

-- 8.0.23之前的版本，执行下面的语句
CHANGE MASTER TO 
  MASTER_HOST='localhost', 
  MASTER_PORT=3306, 
  MASTER_USER='root', 
  MASTER_PASSWORD='XIAObing321.', 
  MASTER_LOG_FILE='DESKTOP-BLBBQ2P-bin.000068', 
  MASTER_LOG_POS=3033;
  
  
-- 8.0.23之后的版本，执行下面的语句
-- CHANGE REPLICATION SOURCE TO SOURCE_HOST='XXX.XXX',
-- SOURCE_USER='XXX',
-- SOURCE_PASSWORD='XXX',
-- SOURCE_LOG_FILE='XXX',
-- SOURCE_LOG_POS=XXX;

--   8.0.23之前
START SLAVE;

-- 8.0.23之后
-- START replica; 

STOP SLAVE;

SHOW SLAVE STATUS;

show databases;

select *from station_info;
SELECT *FROM station_info WHERE station_name = '测试2';