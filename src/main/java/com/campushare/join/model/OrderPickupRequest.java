package com.campushare.join.model;

import lombok.Data;

@Data
public class OrderPickupRequest {
    private String driverID;
    private String passengerID;
    private String restaurantOrderNumber;
}
