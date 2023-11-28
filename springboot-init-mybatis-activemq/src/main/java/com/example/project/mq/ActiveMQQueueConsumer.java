package com.example.project.mq;


import com.alibaba.fastjson2.JSONObject;
import com.example.project.constant.Constant;
import com.example.project.domain.User;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;



@Component
public class ActiveMQQueueConsumer {

    @JmsListener(destination = Constant.USER_UPDATE_LOG,containerFactory = "queueListenerFactory")
    public void receiveLoginInfoQueue(Message message) throws JMSException {
        String value = message.getStringProperty("value");
        User user = JSONObject.parseObject(value, User.class);
        System.out.println("Queue Consumer 接收被更改的用户信息：" + user.toString());
    }

    @JmsListener(destination = Constant.USER_UPDATE_LOG,containerFactory = "queueListenerFactory")
    public void receiveLoginInfoQueue2(Message message) throws JMSException {
        String value = message.getStringProperty("value");
        User user = JSONObject.parseObject(value, User.class);
        System.out.println("Queue Consumer2 接收被更改的用户信息：" + user.toString());
    }

}
