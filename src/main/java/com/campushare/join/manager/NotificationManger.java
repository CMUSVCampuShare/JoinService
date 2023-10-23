package com.campushare.join.manager;


import com.campushare.join.model.JoinNotification;
import org.springframework.stereotype.Component;

@Component
public class NotificationManger {

    public void notifyDriver(Integer recipientUserID, JoinNotification notificationBody) {
        // Call Notification service
    }
}
