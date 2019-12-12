package com.finstone.rabbitmq.controller;

import com.finstone.rabbitmq.direct.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: wangjian
 * Date:   19-12-11
 * Time:   上午11:00
 * Description:
 */

@RestController
public class DemoController {

    @Autowired
    Sender helloSender;

    /**
     * 最简单的生产和消费实现（单生产者和单消费者）
     */
    @RequestMapping("/hello")
    public String hello(@RequestParam String str) {
        helloSender.send(str);
        return str;
    }
}
