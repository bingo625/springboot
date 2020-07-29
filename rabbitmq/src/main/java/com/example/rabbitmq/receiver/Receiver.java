package com.example.rabbitmq.receiver;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
    //@RabbitListener(queues = "message")
    public class Receiver {
        @RabbitHandler
        public void process(String Str) {
            log.info("接收消息："+Str);
            log.info("接收消息时间："+String.format("%1$tF %1$tT",new Date()));
        }


}
