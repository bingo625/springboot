package com.example.rabbitmq.sender;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Slf4j
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(){
        String context = "简单消息发送";
        log.info("简单消息发送时间："+new Date());
        amqpTemplate.convertAndSend("message", context);
        return "发送成功";
    }
    /*订阅模型-Fanout*/
    public void fanout() throws InterruptedException {
        String msg = "订阅模式";
        for (int i = 0; i < 10; i++) {
            // 这里注意细节，第二个参数需要写，否则第一个参数就变成routingKey了
            amqpTemplate.convertAndSend("spring.fanout.exchange", "", msg + i);
        }
        Thread.sleep(5000);
    }
    /*订阅模型-Direct (路由模式)*/
    public void direct() throws InterruptedException {
        String msg = "路由模式";
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("spring.direct.exchange", "direct", msg + i);
        }
        Thread.sleep(5000);
    }
    /* 订阅模型-Topic (主题模式)*/
    public void topic() throws InterruptedException {
        amqpTemplate.convertAndSend("spring.topic.exchange", "person.insert", "增加人员");
        amqpTemplate.convertAndSend("spring.topic.exchange", "person.delete", "删除人员");
        amqpTemplate.convertAndSend("spring.topic.exchange", "money.insert", "加钱");
        amqpTemplate.convertAndSend("spring.topic.exchange", "money.delete", "减钱");
        Thread.sleep(5000);
    }



}

