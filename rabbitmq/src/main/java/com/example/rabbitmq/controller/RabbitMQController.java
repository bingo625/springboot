package com.example.rabbitmq.controller;

import com.example.rabbitmq.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Autowired
    private Sender sender;

    @GetMapping("hello/mq")
    public String helloTest(){
        sender.send();
        return "success";
    }
    @GetMapping("hello/fanout")
    public String fanout(){
        try {
            sender.fanout();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
