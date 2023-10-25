package com.campushare.join.service;

import com.campushare.join.manager.GeoLocationManager;
import com.campushare.join.manager.NotificationManger;
import com.campushare.join.manager.UserManager;
import com.campushare.join.model.JoinNotification;
import com.campushare.join.model.JoinRequest;
import com.campushare.join.model.Location;
import com.campushare.join.model.User;
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

        Location location = geoLocationManager.getGeoLocationInfo(driver, passenger);

        JoinNotification joinNotification = new JoinNotification(postID, passenger.getUserID(), location.getTimeIncrease());

        notificationManger.notifyDriver(driver.getUserID() ,joinNotification);

    }
}
