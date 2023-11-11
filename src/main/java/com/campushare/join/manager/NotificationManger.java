package com.campushare.join.manager;


import com.campushare.join.dto.NotifyDriverEvent;
import com.campushare.join.kafka.NotifyDriverProducer;
import com.campushare.join.model.JoinNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationManger {

    @Autowired
    private NotifyDriverProducer notifyDriverProducer;

    public void notifyDriver(String userID, Object notification) {
        NotifyDriverEvent notifyDriverEvent = new NotifyDriverEvent();
        notifyDriverEvent.setMessage("Notification has been created");
        notifyDriverEvent.setStatus("CREATED");
        notifyDriverEvent.setRecipientUserID(userID);
        notifyDriverEvent.setJoinNotification(notification);
        notifyDriverProducer.sendMessage(notifyDriverEvent);
    }
}
