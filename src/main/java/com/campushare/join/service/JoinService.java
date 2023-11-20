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
            System.out.println("User had empty Address");
            throw new NullPointerException();
        }

    }

    public void manageLunchAndFood(String postID, JoinRequest joinRequest){
        User requester = userManager.getUserDetails(joinRequest.getPassengerID());
        LunchCarpoolNotification lunchCarpoolNotification = new LunchCarpoolNotification(postID, requester.getUsername());
        notificationManger.notifyDriver(joinRequest.getDriverID(), lunchCarpoolNotification);
    }
}
