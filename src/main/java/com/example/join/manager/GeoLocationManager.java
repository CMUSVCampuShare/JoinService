package com.example.join.manager;

import com.example.join.model.Location;
import com.example.join.model.User;
import org.springframework.stereotype.Component;

@Component
public class GeoLocationManager {
    public Location getGeoLocationInfo(User driver, User passenger){
        // Call geolocation Service to get Details
        return new Location();
    }
}
