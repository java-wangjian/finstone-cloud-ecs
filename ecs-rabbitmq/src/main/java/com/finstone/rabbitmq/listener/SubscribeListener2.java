package com.finstone.rabbitmq.listener;

import com.finstone.rabbitmq.entity.Mail;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Author: wangjian
 * Date:   19-12-13
 * Time:   下午5:05
 * Description:
 */
@Component
public class SubscribeListener2 {
    @RabbitListener(queues = "queue2")
    public void subscribe(Mail mail) throws IOException {
        System.out.println("订阅者2收到消息" + mail.toString());
    }
}
