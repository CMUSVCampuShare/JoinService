package com.campushare.join.dto;

import com.campushare.join.model.JoinNotification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotifyDriverEvent {

    private String message;
    private String status;
    private JoinNotification joinNotification;
}
