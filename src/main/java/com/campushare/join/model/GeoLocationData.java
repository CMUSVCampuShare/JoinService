package com.campushare.join.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeoLocationData {
    @JsonProperty("addedTime")
    private Long addedTime;
    @JsonProperty("pin")
    private Coordinates pin;
}
