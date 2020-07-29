package com.example.rabbitmq.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopicListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.topic.queue", durable = "true"),
            exchange = @Exchange(
                    value = "spring.topic.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key = {"person.*"}
    ))
    public void listen(String msg) {
        log.info("person 接收到消息：" + msg);
    }

    // 通配规则不同，接收不到消息
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.topic.queue", durable = "true"),
            exchange = @Exchange(
                    value = "spring.topic.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key = {"money.*"}
    ))
    public void listen2(String msg) {
        log.info("money Student 接收到消息：" + msg);
    }
}

