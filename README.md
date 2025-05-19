# 📣 Notification Service

This is a **Spring Boot-based Notification Service** using **RabbitMQ** and **MongoDB**. It supports multiple notification types like **In-App**, and is extendable to **Email** and **SMS**. The service uses a message queue for scalability and decoupling.

## 🚀 Features

- 📨 Asynchronous Notification Processing with RabbitMQ
- 🧾 JSON serialization using Jackson
- 💾 In-App notification persistence with MongoDB
- 🔁 Retry mechanism for failed notifications
- 📡 Easily extensible for Email/SMS
- 🐳 Docker support
- 🧪 Postman Collection for API testing

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring AMQP (RabbitMQ)
- MongoDB
- Maven
- Docker (optional)

---

## 📦 Project Structure

NotificationServiceApplication/
├── config/ # RabbitMQ Configuration
├── model/ # Notification data model
├── repository/ # MongoDB repository
├── NotificationProducer.java # Publishes messages to RabbitMQ
├── NotificationConsumer.java # Listens to queue and processes notifications
└── NotificationServiceApplication.java-

## ⚙️ Setup Instructions

### ✅ Prerequisites

- Java 17+
- Maven
- MongoDB running (default port: 27017)
- RabbitMQ running (default port: 5672)

---

### 📄 Configuration (`application.properties`)

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/notificationdb
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

---

###Running locally
# Clone the repository
git clone https://github.com/ShivikaAg4/Notification.git
cd Notification

# Build the app
mvn clean install

# Run the app
mvn spring-boot:run

###POST
REST API Documentation
🔹 Send Notification
{
  "userId": "user123",
  "message": "Welcome to the app!",
  "type": "IN_APP",
  "timestamp": "2025-05-19T12:00:00"
}

Postman
You can test this API using Postman:
Import the request manually or create a collection.
Use the /send endpoint with the above JSON.
Make sure RabbitMQ and MongoDB are running locally.

Assumptions Made
The system currently handles only IN_APP notifications by saving them in MongoDB.
Retry logic is hardcoded to 3 attempts for failed deliveries.
Jackson is used for serializing/deserializing notification messages.



