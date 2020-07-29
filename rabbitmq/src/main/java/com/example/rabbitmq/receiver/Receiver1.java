package com.example.rabbitmq.receiver;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
    public class Receiver1 {



        // 通过注解自动创建 spring.work.queue 队列
        @RabbitListener(queuesToDeclare = @Queue("message"))
        public void listen(String msg) {
            System.out.println("work模式 接收到消息：" + msg);
        }

        // 创建两个队列共同消费
        @RabbitListener(queuesToDeclare = @Queue("message"))
        public void listen2(String msg) {
            System.out.println("work模式二 接收到消息：" + msg);
        }


}
