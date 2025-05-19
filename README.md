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


## 🏃‍♀️ **Running Locally**

**🔧 Clone the repository**
```bash
git clone https://github.com/ShivikaAg4/Notification.git
cd Notification
