package com.bexos.notification_service.service.impl;

import com.bexos.notification_service.dto.NotificationResponse;
import com.bexos.notification_service.exception.BadRequestException;
import com.bexos.notification_service.model.Notification;
import com.bexos.notification_service.repository.NotificationRepository;
import com.bexos.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();
    private final NotificationRepository notificationRepository;
    private final ModelMapper modelMapper;

    public SseEmitter subscribe(Long userId) {
        SseEmitter emitter = new SseEmitter(3600 * 1000L);

        emitters.put(String.valueOf(userId), emitter);

        emitter.onCompletion(() -> emitters.remove(String.valueOf(userId)));
        emitter.onTimeout(() -> emitters.remove(String.valueOf(userId)));
        emitter.onError(e -> {
            emitter.completeWithError(e);
            emitters.remove(String.valueOf(userId));
        });

        try {
            Notification notification = Notification.builder().title("Connection").message("Connection successful").build();
            emitter.send(SseEmitter.event().data(modelMapper.map(notification, NotificationResponse.class)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return emitter;
    }

    public void notifyUser(Long userId, String message) {
        SseEmitter emitter = emitters.get(String.valueOf(userId));
        if (emitter != null) {
            try {
                Notification notification = notificationRepository.save(Notification.builder().title("New message").message(message).userId(userId).build());
                emitter.send(SseEmitter.event().data(modelMapper.map(notification, NotificationResponse.class)));
            } catch (IOException e) {
                emitter.completeWithError(e);
                emitters.remove(String.valueOf(userId));
            } catch (IllegalStateException e) {
                emitters.remove(String.valueOf(userId));
            }
        }
    }

    public void notifyAllUsers(String message) {
        emitters.forEach((userId, emitter) -> {
            try {
                emitter.send(SseEmitter.event().name("notification").data(message));
            } catch (IOException e) {
                emitter.completeWithError(e);
                emitters.remove(userId);
            }
        });
    }

    public NotificationResponse getNotification(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new BadRequestException("Notification do not exist"));
        return modelMapper.map(notification, NotificationResponse.class);
    }

}
