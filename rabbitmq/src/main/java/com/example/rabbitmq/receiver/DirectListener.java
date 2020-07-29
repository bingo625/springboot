package com.example.rabbitmq.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component@Slf4j
public class DirectListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.direct.queue", durable = "true"),
            exchange = @Exchange(
                    value = "spring.direct.exchange",
                    ignoreDeclarationExceptions = "true"
            ),
            key = {"direct"}
    ))
    public void listen(String msg) {
        log.info("路由模式1 接收到消息：" + msg);
    }

    // 队列2（第二个人），key值不同，接收不到消息
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.direct2.queue", durable = "true"),
            exchange = @Exchange(
                    value = "spring.direct.exchange",
                    ignoreDeclarationExceptions = "true"
            ),
            key = {"direct-test"}
    ))
    public void listen2(String msg) {
        log.info("路由模式2 接收到消息：" + msg);
    }
}

