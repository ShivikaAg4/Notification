package com.example.NotificationServiceApplication.service;

import com.example.NotificationServiceApplication.model.Notification;
import com.example.NotificationServiceApplication.model.NotificationType;
import com.example.NotificationServiceApplication.repository.NotificationRepository;
import com.example.NotificationServiceApplication.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repository;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public NotificationService(NotificationRepository repository, RabbitTemplate rabbitTemplate) {
        this.repository = repository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public Notification sendNotification(Long userId, String message, NotificationType type) {
        Notification notification = new Notification(userId, message, type);

        // Save to DB (optional, or can be moved to consumer)
        repository.save(notification);

        // Send to RabbitMQ queue
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE, notification);

        return notification;
    }

    public List<Notification> getUserNotifications(Long userId) {
        return repository.findByUserId(userId);
    }
}
