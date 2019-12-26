package com.wangshi.rabbitmq.direct.service;

import com.wangshi.rabbitmq.entity.Mail;

public interface Producer {
    public void sendMail(String queue, Mail mail);//向队列queue发送消息
}