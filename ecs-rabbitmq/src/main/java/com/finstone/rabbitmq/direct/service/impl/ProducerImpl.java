package com.finstone.rabbitmq.direct.service.impl;

import com.finstone.rabbitmq.direct.service.Producer;
import com.finstone.rabbitmq.entity.Mail;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("producer")
public class ProducerImpl implements Producer {
    @Autowired
	RabbitTemplate rabbitTemplate;

    public void sendMail(String queue, Mail mail) {
        rabbitTemplate.setQueue(queue);
        rabbitTemplate.convertAndSend(queue, mail);
    }

}