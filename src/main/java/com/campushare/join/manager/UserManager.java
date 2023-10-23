package com.campushare.join.manager;

import com.campushare.join.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserManager {
    public User getUserDetails(Integer userID){
        //Call user service to get driver and passenger details
        return new User();
    }
}
