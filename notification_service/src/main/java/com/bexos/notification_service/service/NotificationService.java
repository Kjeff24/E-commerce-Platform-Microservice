package com.bexos.notification_service.service;

import com.bexos.notification_service.dto.NotificationResponse;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface NotificationService {
    SseEmitter subscribe(Long userId);

    void notifyUser(Long userId, String message);

    void notifyAllUsers(String message);

    NotificationResponse getNotification(Long notificationId);
}
