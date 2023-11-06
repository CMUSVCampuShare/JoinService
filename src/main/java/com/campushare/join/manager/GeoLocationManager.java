package com.campushare.join.manager;

import com.campushare.join.model.Location;
import com.campushare.join.model.User;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GeoLocationManager {

    private final String GEO_LOCATION_ENDPOINT_URL = "http://localhost:8090/location";
    public Location getGeoLocationInfo(User driver, User passenger){
        String driverAddress = "100 Whisman Station Dr, Mountain View, CA 94043";
        String passengerAddress = "585 Franklin St, Mountain View, CA 94041";
        String schoolAddress = "NASA Research Park, Building 23 Moffett Field, CA 94035";
        String url = String.format("%s?origin=%s&destination=%s&stop=%s", GEO_LOCATION_ENDPOINT_URL, driverAddress, schoolAddress, passengerAddress);
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        Long addedTime = restTemplate.getForObject(url, Long.class);
        System.out.println("Got addedTime");
        System.out.println(addedTime);
        return new Location(addedTime);
    }
}
