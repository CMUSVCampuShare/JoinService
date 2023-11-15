package com.campushare.join.service;

import com.campushare.join.manager.GeoLocationManager;
import com.campushare.join.manager.NotificationManger;
import com.campushare.join.manager.UserManager;
import com.campushare.join.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    @Autowired
    private UserManager userManager;

    @Autowired
    private GeoLocationManager geoLocationManager;

    @Autowired
    private NotificationManger notificationManger;

    public void manageJoinRequest(String postID, JoinRequest joinRequest){
        User driver = userManager.getUserDetails(joinRequest.getDriverID());
        User passenger = userManager.getUserDetails(joinRequest.getPassengerID());
        System.out.println("Driver");
        System.out.println(driver);
        System.out.println("passenger");
        System.out.println(passenger);
        if (driver.getAddress() != null && passenger.getAddress() != null) {
            GeoLocationData location = geoLocationManager.getGeoLocationInfo(driver, passenger);

            JoinNotification joinNotification = new JoinNotification(postID, passenger.getUserId(), location);

            notificationManger.notifyDriver(driver.getUserId(), joinNotification);
        }
        else {
            System.out.println("Driver had empty Address");
            throw new NullPointerException();
        }

    }

    public void manageFoodOrderRequest(String postID, OrderPickupRequest orderPickupRequest){
        OrderPickupNotification orderPickupNotification = new OrderPickupNotification(postID, orderPickupRequest.getPassengerID(), orderPickupRequest.getRestaurantOrderNumber());
        notificationManger.notifyDriver(orderPickupRequest.getDriverID(), orderPickupNotification);
    }

    public void manageLunchCarpool(String postID, JoinRequest joinRequest){
        LunchCarpoolNotification lunchCarpoolNotification = new LunchCarpoolNotification(postID, joinRequest.getPassengerID());
        notificationManger.notifyDriver(joinRequest.getDriverID(), lunchCarpoolNotification);
    }
}
