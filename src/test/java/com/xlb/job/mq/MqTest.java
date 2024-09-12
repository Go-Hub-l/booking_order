package com.xlb.job.mq;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MqTest {
    @Autowired
    private ProducerTest producer;

    @Test
    public void run() throws Exception {
        producer.sendMessage("test-topic", "Hello, RocketMQ!");

        while(true);
    }
}
