package com.finstone.rabbitmq.controller;

import com.finstone.rabbitmq.direct.service.impl.ProducerImpl;
import com.finstone.rabbitmq.direct.service.impl.PublisherImpl;
import com.finstone.rabbitmq.entity.Mail;
import com.finstone.rabbitmq.entity.TopicMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: wangjian
 * Date:   19-12-12
 * Time:   下午3:41
 * Description:
 */
@Controller
public class RabbitMQController {


    @Autowired
    ProducerImpl producer;

    @Autowired
    PublisherImpl publisher;

    @RequestMapping(value = "/produce", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void produce(@ModelAttribute("mail") Mail mail) throws Exception {
        producer.sendMail("myqueue", mail);
    }

    @RequestMapping(value = "/topic", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void topic(@ModelAttribute("mail") Mail mail) throws Exception {
        publisher.publishMail(mail);
    }

    @RequestMapping(value = "/direct", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void direct(@ModelAttribute("mail") TopicMail mail) {
        Mail m = new Mail(mail.getMailId(), mail.getCountry(), mail.getWeight());
        publisher.senddirectMail(m, mail.getRoutingkey());
    }

    @RequestMapping(value = "/mytopic", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void topic(@ModelAttribute("mail") TopicMail mail) {
        Mail m = new Mail(mail.getMailId(), mail.getCountry(), mail.getWeight());
        publisher.sendtopicMail(m, mail.getRoutingkey());
    }

    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }
}
