package com.example.NotificationServiceApplication.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification implements Serializable{

    @Id
    private String id;

    private Long userId;
    private String message;
    private LocalDateTime timestamp;

    private NotificationType type;

    public Notification (Long userId, String message, NotificationType type) {
        this.userId = userId;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.type = type;
    }
}
