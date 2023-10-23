package com.campushare.join.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinNotification {
    private Integer postID;
    private Integer userID;
    private Integer timeAdded;
    // private MapObj addressPin;
}
