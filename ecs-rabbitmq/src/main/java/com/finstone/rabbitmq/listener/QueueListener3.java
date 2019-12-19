package com.finstone.rabbitmq.listener;

import com.finstone.rabbitmq.entity.Mail;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Author: wangjian
 * Date:   19-12-13
 * Time:   下午1:24
 * Description:
 */
@Component
public class QueueListener3 {

    @RabbitListener(queues = "myqueue")
    public void displayMail(Mail mail) throws Exception {
        System.out.println("队列监听器3号收到消息" + mail.toString());
    }
}
