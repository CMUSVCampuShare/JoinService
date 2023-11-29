package com.campushare.join.manager;

import com.campushare.join.model.GeoLocationData;
import com.campushare.join.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GeoLocationManager {

    private final String GEO_LOCATION_ENDPOINT_URL = "http://localhost:8087/location";
    public GeoLocationData getGeoLocationInfo(String startAddress, String endAddress, String passengerAddress){

        String url = String.format("%s?origin=%s&destination=%s&stop=%s", GEO_LOCATION_ENDPOINT_URL, startAddress, endAddress, passengerAddress);

        RestTemplate restTemplate = new RestTemplate();
        GeoLocationData geoLocationData = restTemplate.getForObject(url, GeoLocationData.class);

        return geoLocationData;
    }
}
