package com.campushare.join.manager;


import com.campushare.join.dto.NotifyDriverEvent;
import com.campushare.join.kafka.NotifyDriverProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationManger {

    @Autowired
    private NotifyDriverProducer notifyDriverProducer;

    public void notifyDriver(String userID, Object notification) {
        NotifyDriverEvent notifyDriverEvent = new NotifyDriverEvent();
        notifyDriverEvent.setPassengerId(userID);
        notifyDriverEvent.setMessage(notification);
        notifyDriverProducer.sendMessage(notifyDriverEvent);
    }
}
