package com.bexos.notification_service.controller;

import com.bexos.notification_service.dto.NotificationResponse;
import com.bexos.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/api/v1/notification-service")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping(value = "/subscribe/{userId}", consumes = MediaType.ALL_VALUE)
    public SseEmitter subscribe((@PathVariable Long userId) {
        return notificationService.subscribe(userId);
    }

    @PostMapping("/notify/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void notifyUser(@PathVariable Long userId, @RequestBody String message) {
        notificationService.notifyUser(userId, message);
    }

    @PostMapping("/notify")
    @ResponseStatus(HttpStatus.CREATED)
    public void notifyAllUsers(@RequestBody String message) {
        notificationService.notifyAllUsers(message);
    }

    @GetMapping("/get-notification/{notificationId}")
    @ResponseStatus(HttpStatus.OK)
    public NotificationResponse getNotification(@PathVariable Long notificationId) {
        return notificationService.getNotification(notificationId);
    }
}
