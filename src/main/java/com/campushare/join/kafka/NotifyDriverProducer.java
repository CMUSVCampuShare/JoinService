package com.campushare.join.kafka;

import com.campushare.join.dto.NotifyDriverEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

@Service
public class NotifyDriverProducer {
    private static final Logger LOGGER = Logger.getLogger(NotifyDriverProducer.class);

    @Autowired
    private NewTopic topic;

    @Autowired
    private KafkaTemplate<String, NotifyDriverEvent> kafkaTemplate;

    public void sendMessage(NotifyDriverEvent event) {
        LOGGER.info(String.format("Notify Driver Event => %s", event.toString()));

        Message<NotifyDriverEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }
}
