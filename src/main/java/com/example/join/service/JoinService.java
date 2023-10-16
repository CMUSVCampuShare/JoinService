package com.example.join.service;

import com.example.join.manager.GeoLocationManager;
import com.example.join.manager.NotificationManger;
import com.example.join.manager.UserManager;
import com.example.join.model.JoinNotification;
import com.example.join.model.JoinRequest;
import com.example.join.model.Location;
import com.example.join.model.User;
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

    public void manageJoinRequest(Integer postID, JoinRequest joinRequest){
        User driver = userManager.getUserDetails(joinRequest.getDriverID());
        User passenger = userManager.getUserDetails(joinRequest.getPassengerID());

        Location location = geoLocationManager.getGeoLocationInfo(driver, passenger);

        JoinNotification joinNotification = new JoinNotification(postID, passenger.getUserID(), location.getTimeIncrease());

        notificationManger.notifyDriver(driver.getUserID(), joinNotification);

    }
}
