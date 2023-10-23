package com.campushare.join.manager;

import com.campushare.join.model.Location;
import com.campushare.join.model.User;
import org.springframework.stereotype.Component;

@Component
public class GeoLocationManager {
    public Location getGeoLocationInfo(User driver, User passenger){
        // Call geolocation Service to get Details
        return new Location();
    }
}
