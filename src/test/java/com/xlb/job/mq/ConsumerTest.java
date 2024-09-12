package com.xlb.job.mq;


import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "test-topic", consumerGroup = "my-consumer-group")
public class ConsumerTest implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        try {
            // 处理消息
            System.out.println("Received message: " + s);
            // 手动确认消息
            // 这里需要手动调用确认方法，但RocketMQ的Spring Boot Starter没有直接提供手动确认的方法
            // 你可以通过RocketMQPushConsumerLifecycleListener来实现
            throw new Exception("Manually confirm message");
        } catch (Exception e) {
            // 处理失败，抛出异常，RocketMQ会自动重试
//            throw new RuntimeException("Message processing failed", e);
        }
    }
}
