package com.bexos.notification_service.service;

import com.bexos.notification_service.dto.NotificationResponse;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface NotificationService {
    SseEmitter subscribe();
    void notifyUser(Integer userId, String message);
    void notifyUser(Integer userId, NotificationResponse message);
    void notifyAllUsers(String message);
    NotificationResponse getNotification(Integer notificationId);

}
