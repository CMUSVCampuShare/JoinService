package com.campushare.join.model;

import lombok.Data;

@Data
public class Notification {
    private String passengerID;
    private String postId;
    private String postTitle;
    private Object notificationBody;
}
