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
        User passenger = userManager.getUserDetails(joinRequest.getPassengerID());
        System.out.println(passenger);
        GeoLocationData location = geoLocationManager.getGeoLocationInfo(joinRequest.getFrom(), joinRequest.getTo(), passenger.getAddress());
        String message = passenger.getUsername() + " wants to join " + post + "!";

        JoinNotification joinNotification = new JoinNotification(message, location);
        System.out.println(joinNotification);

        Notification newNotification = new Notification();
        newNotification.setNotificationBody(joinNotification);
        newNotification.setPostId(joinRequest.getPostId());
        newNotification.setPassengerID(joinRequest.getPassengerID());
        newNotification.setPostTitle(post);

        notificationManger.notifyDriver(joinRequest.getDriverID(), newNotification);
    }

    public void manageLunchAndFood(String post, FoodRequest foodRequest){
        User requester = userManager.getUserDetails(foodRequest.getPassengerID());
        String message = requester.getUsername() + " wants to join " + post + "!";
        System.out.println(message);

        Notification newNotification = new Notification();
        newNotification.setNotificationBody(message);
        newNotification.setPostId(foodRequest.getPostId());
        newNotification.setPostTitle(post);
        newNotification.setPassengerID(foodRequest.getPassengerID());

        notificationManger.notifyDriver(foodRequest.getDriverID(), newNotification);
    }
}
