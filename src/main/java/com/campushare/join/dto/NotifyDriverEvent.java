package com.campushare.join.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotifyDriverEvent {
    private String passengerId;
    private Object message;
}
