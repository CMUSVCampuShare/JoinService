package com.campushare.join.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinNotification {
    private String postID;
    private String userID;
    private GeoLocationData geoLocationData;
}
