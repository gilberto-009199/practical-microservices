# Practica Microservicos

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
