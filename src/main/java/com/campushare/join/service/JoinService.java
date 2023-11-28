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

    public void manageJoinRequest(String post, JoinRequest joinRequest){
        User driver = userManager.getUserDetails(joinRequest.getDriverID());
        User passenger = userManager.getUserDetails(joinRequest.getPassengerID());

        if (driver.getAddress() != null && passenger.getAddress() != null) {
            GeoLocationData location = geoLocationManager.getGeoLocationInfo(driver, passenger);
            String message = passenger.getUsername() + " wants to join " + post + "!";

            JoinNotification joinNotification = new JoinNotification(message, location);

            notificationManger.notifyDriver(driver.getUserId(), joinNotification);
        }
        else {
            System.out.println("User had empty Address");
            throw new NullPointerException();
        }

    }

    public void manageLunchAndFood(String post, JoinRequest joinRequest){
        User requester = userManager.getUserDetails(joinRequest.getPassengerID());
        String message = requester.getUsername() + " wants to join " + post + "!";
        notificationManger.notifyDriver(joinRequest.getDriverID(), message);
    }
}
