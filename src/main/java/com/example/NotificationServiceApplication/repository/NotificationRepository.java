package com.example.NotificationServiceApplication.repository;

import com.example.NotificationServiceApplication.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

    public interface NotificationRepository extends MongoRepository<Notification, String> {
        List<Notification> findByUserId(Long userId);
    }
