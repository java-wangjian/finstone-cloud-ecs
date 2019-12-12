package com.finstone.rabbitmq.direct.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Author: wangjian
 * Date:   19-12-11
 * Time:   下午1:57
 * Description:
 */
@Component
@RabbitListener(queues = "direct")
public class Receiver {

    @RabbitHandler
    public void handler(String message) {
        System.out.println("接收消息：" + message);
    }

}
