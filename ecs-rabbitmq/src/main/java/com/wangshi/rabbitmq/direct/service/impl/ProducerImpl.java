package com.wangshi.rabbitmq.direct.service.impl;

import com.wangshi.rabbitmq.direct.service.Producer;
import com.wangshi.rabbitmq.entity.Mail;
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