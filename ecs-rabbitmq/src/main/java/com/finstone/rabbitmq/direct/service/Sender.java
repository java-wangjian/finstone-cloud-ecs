package com.finstone.rabbitmq.direct.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: wangjian
 * Date:   19-12-11
 * Time:   下午1:54
 * Description: 消息发送--生产消息
 */
@Component
public class Sender {

    @Autowired
    AmqpTemplate rabbitmqTemplate;

    public void send(String message) {
        System.out.println("发送消息：" + message);
        rabbitmqTemplate.convertAndSend("direct", message);
    }
}
