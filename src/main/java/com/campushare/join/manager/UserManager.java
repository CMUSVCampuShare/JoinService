package com.campushare.join.manager;

import com.campushare.join.model.GeoLocationData;
import com.campushare.join.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserManager {
    private final String USER_ENDPOINT_URL = "http://localhost:8090/user";
    public User getUserDetails(Integer userID){
        String url = String.format("%s?userid=%s", USER_ENDPOINT_URL, userID);
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
