package com.example.NotificationServiceApplication.controller;

import com.example.NotificationServiceApplication.model.Notification;
import com.example.NotificationServiceApplication.model.NotificationType;
import com.example.NotificationServiceApplication.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("notification")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping("/notifications")
    public ResponseEntity<Notification> sendNotification(@RequestBody Map<String, String> payload) {
        Long userId = Long.parseLong(payload.get("userId"));
        String message = payload.get("message");
        String typeStr = payload.get("type");

        NotificationType type = NotificationType.valueOf(typeStr.toUpperCase());

        Notification notification = service.sendNotification(userId, message, type);
        return ResponseEntity.ok(notification);
    }


    @GetMapping("/users/{id}/notifications")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(service.getUserNotifications(userId));
    }
}
