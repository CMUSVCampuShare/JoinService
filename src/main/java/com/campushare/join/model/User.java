package com.campushare.join.model;

import lombok.Data;

@Data
public class User {
    private Integer userID;
    private String name;
    private String streetAddress;
    private String city;
    private Integer zipCode;
    private String role;
}
