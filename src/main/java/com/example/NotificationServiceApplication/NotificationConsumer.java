package com.example.NotificationServiceApplication;

import com.example.NotificationServiceApplication.config.RabbitMQConfig;
import com.example.NotificationServiceApplication.model.Notification;
import com.example.NotificationServiceApplication.repository.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @Autowired
    private NotificationRepository repository;

    @RabbitListener(queues = RabbitMQConfig.QUEUE, containerFactory = "rabbitListenerContainerFactory")
    public void handleNotification(Notification notification) {
        int retries = 0;
        boolean sent = false;

        while (!sent && retries < 3) {
            try {
                System.out.println("📥 Received Notification: " + notification);
                System.out.println("Sending " + notification.getType() + " to user " + notification.getUserId());

                if ("IN_APP".equalsIgnoreCase(notification.getType().toString())) {
                    repository.save(notification);
                }

                sent = true;
            } catch (Exception e) {
                retries++;
                System.out.println("Retry " + retries + " failed. Error: " + e.getMessage());
            }
        }

        if (!sent) {
            System.out.println("❌ Failed to send notification after 3 retries.");
        }
    }
}
