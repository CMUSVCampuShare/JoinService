package com.campushare.join.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderPickupNotification {
    private String postID;
    private String userID;
    private String restaurantOrderNumber;
}
