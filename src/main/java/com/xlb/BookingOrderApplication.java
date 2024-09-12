package com.xlb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.xlb.dao")
@EnableAspectJAutoProxy
public class BookingOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingOrderApplication.class, args);
    }

}
