package com.example.join.manager;


import com.example.join.model.JoinNotification;
import org.springframework.stereotype.Component;

@Component
public class NotificationManger {

    public void notifyDriver(Integer recipientUserID,JoinNotification notificationBody) {
        // Call Notification service
    }
}
