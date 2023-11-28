package com.example.project.mq;

import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;


/**
 * 消息队列发送工具类
 *
 * @author ty
 */
@Slf4j
@Component
public class ActiveMQSender {

    @Resource
    private JmsMessagingTemplate jmsTemplate;

    //发送队列
    public void publishQueue(String queue, Object message) {
        sendByAMQQueue(queue, message);
    }

    //发送广播
    public void publishTopic(String topic, Object message) {
        sendByAMQTopic(topic, message);
    }

    private void sendByAMQQueue(String queue, Object message) {
        try {
            String msg = JSON.toJSONString(message);
            log.info("====MESSAGE====queue：{}===message:{}", queue, message);
            ActiveMQMessage activeMQMessage = new ActiveMQMessage();
            activeMQMessage.setStringProperty("value", msg);
            jmsTemplate.convertAndSend(new ActiveMQQueue(queue), activeMQMessage);
        } catch (Exception e) {
            log.error("====MESSAGE====sendByAMQ failed: {}", e.getMessage(), e);
        }
    }

    private void sendByAMQTopic(String topic, Object message) {
        try {
            String msg = JSON.toJSONString(message);
            log.info("====MESSAGE====topic：{}===message:{}", topic, message);
            ActiveMQMessage activeMQMessage = new ActiveMQMessage();
            activeMQMessage.setStringProperty("value", msg);
            jmsTemplate.convertAndSend(new ActiveMQTopic(topic), activeMQMessage);
        } catch (Exception e) {
            log.error("====MESSAGE====sendByAMQ failed: {}", e.getMessage(), e);
        }
    }

}
