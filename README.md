# Practical Microservices in spring cloud

+ [Microservices Simple](microservices) - Microservices Client and Fraud, connected via http rest
```mermaid
---
config:
  theme: 'dark'
---
architecture-beta
    service client_service(server)[Microservice Client]
    service fraud_service(server)[Microservice Fraud]

    client_service:R --> L:fraud_service
```
+ [Microservices with Eureka Server Discover](microservices-with-eureka-service-discover) - Microservices with Eureka Server Discover
```mermaid
---
config:
  theme: 'dark'
---
architecture-beta
    service client_service(server)[Microservice Client]
    service fraud_service(server)[Microservice Fraud]
    service eureka_server(server)[Eureka Service Discover]
    junction junction_eureka_server

    client_service:R --> L:fraud_service
    client_service:B -- T:junction_eureka_server
    fraud_service:B -- T:junction_eureka_server
    junction_eureka_server:B --> T:eureka_server
    
```
+ [Microservices with Menssage Broker](microservices-with-message-queue) - Microservices with Kafka Message Broker and Microservice Notification 
```mermaid
---
config:
  theme: 'dark'
---
architecture-beta
    service client_service(server)[Microservice Client]
    service fraud_service(server)[Microservice Fraud]
    service notification_service(server)[Microservice Notification]

    service eureka_server(server)[Eureka Service Discover]
    junction junction_eureka_server

    service kafka_message_broker(server)[Kafka Message Broker]
    junction junction_kafka_message_broker


    client_service:R --> L:fraud_service

    client_service:B -- T:junction_eureka_server
    fraud_service:B -- T:junction_eureka_server
    junction_eureka_server:B --> T:eureka_server

    kafka_message_broker:R --> L:notification_service
    client_service:B -- T:junction_kafka_message_broker
    fraud_service:B -- T:junction_kafka_message_broker
    junction_kafka_message_broker:B --> T:kafka_message_broker
    
```

+ [Microservices with Menssage Broker RabbitMQ](microservices-with-message-queue-in-rabbitmq) - Microservices with RabbitMQ Message Broker

```mermaid
---
config:
  theme: 'dark'
---
architecture-beta
    service client_service(server)[Microservice Client]
    service fraud_service(server)[Microservice Fraud]
    service notification_service(server)[Microservice Notification]

    service eureka_server(server)[Eureka Service Discover]
    junction junction_eureka_server

    service rabbit_message_broker(server)[RabbitMQ Message Broker]
    junction junction_rabbit_message_broker


    client_service:R --> L:fraud_service

    client_service:B -- T:junction_eureka_server
    fraud_service:B -- T:junction_eureka_server
    junction_eureka_server:B --> T:eureka_server

    rabbit_message_broker:R --> L:notification_service
    client_service:B -- T:junction_rabbit_message_broker
    fraud_service:B -- T:junction_rabbit_message_broker
    junction_rabbit_message_broker:B --> T:rabbit_message_broker
    
```

+ [Microservices with Config Server](microservices-with-config-server) - Microservices with Config Server

```mermaid
---
config:
  theme: 'dark'
---
architecture-beta
    service client_service(server)[Microservice Client]
    service fraud_service(server)[Microservice Fraud]
    service notification_service(server)[Microservice Notification]

    service eureka_server(server)[Eureka Service Discover]
    junction junction_eureka_server

    service rabbit_message_broker(server)[RabbitMQ Message Broker]
    junction junction_rabbit_message_broker

    service config_server_service(server)[Config Server]
    junction junction_config_server

    client_service:R --> L:fraud_service

    client_service:B -- T:junction_eureka_server
    fraud_service:B -- T:junction_eureka_server
    junction_eureka_server:B --> T:eureka_server

    client_service:T -- L:junction_config_server
    junction_config_server:R --> T:config_server_service

    rabbit_message_broker:R --> L:notification_service
    client_service:B -- T:junction_rabbit_message_broker
    fraud_service:B -- T:junction_rabbit_message_broker
    junction_rabbit_message_broker:B --> T:rabbit_message_broker
    
```
  
+ Spring Cloud API Gateway IN PROGRESS
+ Spring Cloud Zookeeper IN PROGRESS
