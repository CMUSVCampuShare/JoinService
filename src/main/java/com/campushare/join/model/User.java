package com.campushare.join.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class User {
    private String userID;
    private String username;
    private String password;
    private String paypalEmail;
    private Address location;
    private String email;
    private Enum role;
}

@Data
@AllArgsConstructor
class Address{
    private String streetAddress;
    private String aptNumber;
    private String city;
    private String state;
    private String zipcode;
}
