package com.campushare.join.manager;

import com.campushare.join.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserManager {
    @Autowired
    private RestTemplate restTemplate;
    private final String USER_ENDPOINT_URL = "http://localhost:8091/users/";
    public User getUserDetails(String userID){
        String url = String.format("%s%s", USER_ENDPOINT_URL, userID);
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
