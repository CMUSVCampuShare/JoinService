package com.campushare.join.manager;

import com.campushare.join.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserManager {
    private final String USER_ENDPOINT_URL = "http://localhost:8091/users/";
    public User getUserDetails(String userID){
        String url = String.format("%s%s", USER_ENDPOINT_URL, userID);
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
