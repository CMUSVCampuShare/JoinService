package com.campushare.join.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String userId;
    private String username;
    private String password;
    private String email;
    private Integer rewardpts;
    private Role role;
    private Schedule schedule;
    private String address;
}

class Schedule {
    private Date mondayEntry;
    private Date mondayExit;
    private Date tuesdayEntry;
    private Date tuesdayExit;
    private Date wednesdayEntry;
    private Date wednesdayExit;
    private Date thursdayEntry;
    private Date thursdayExit;
    private Date fridayEntry;
    private Date fridayExit;

}
