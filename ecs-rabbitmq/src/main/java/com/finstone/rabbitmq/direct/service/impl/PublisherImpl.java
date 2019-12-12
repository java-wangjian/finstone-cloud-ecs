package com.finstone.rabbitmq.direct.service.impl;

import com.finstone.rabbitmq.direct.service.Publisher;
import com.finstone.rabbitmq.entity.Mail;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("publisher")
public class PublisherImpl implements Publisher {
    @Autowired
	RabbitTemplate rabbitTemplate;

    public void publishMail(Mail mail) {
        rabbitTemplate.convertAndSend("fanout", "", mail);
    }

    public void senddirectMail(Mail mail, String routingkey) {
        rabbitTemplate.convertAndSend("direct", routingkey, mail);
    }

    public void sendtopicMail(Mail mail, String routingkey) {
        rabbitTemplate.convertAndSend("mytopic", routingkey, mail);
    }


}