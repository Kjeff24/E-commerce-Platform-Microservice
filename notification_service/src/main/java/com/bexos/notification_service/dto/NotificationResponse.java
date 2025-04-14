package com.bexos.notification_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponse {
    private Integer id;
    private String event;
    private String title;
    private String message;
    private boolean read;
    private String timeAgo;
    private LocalDateTime createdAt;



    private String getTimeAgo() {
        Duration duration = Duration.between(createdAt, LocalDateTime.now());

        if (duration.toMinutes() < 1) {
            return duration.getSeconds() + "s ago";
        } else if (duration.toHours() < 1) {
            return duration.toMinutes() + "m ago";
        } else if (duration.toDays() < 1) {
            return duration.toHours() + "h ago";
        } else if (duration.toDays() == 1) {
            return "1 day ago";
        } else {
            return duration.toDays() + " days ago";
        }
    }
}
