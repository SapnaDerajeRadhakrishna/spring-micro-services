# spring-micro-services

#### Introduction

In this application, tried to put in some of my learning of spring-micro-service. The challenges with spring-micro-services are   
  1.  Bounded Context
  2.  Configuration Management
  3.  Dynamic Scale-Up and Scale-down
  4.  Visibility (Centralised log) and Monitoring
  5.  Fault Tolerance

##### Implementation Details

In order to resolve the above challenges, I have tried to implement

1. Configuration Management: Used the **Spring Cloud Config Service** - See [repo](https://github.com/SapnaDerajeRadhakrishna/spring-micro-services/tree/master/spring-cloud-config)

2. Dynamic Scale-up and Scale-Down: To achieve this feature, I've used 
   **Feign** for easier rest clients 
   **Ribbon** for client side load balancing
   **Eureka** for Naming server
   See [repo1](https://github.com/SapnaDerajeRadhakrishna/spring-micro-services/tree/master/currency-conversion-service) [repo2](https://github.com/SapnaDerajeRadhakrishna/spring-micro-services/tree/master/currency-exchange-service) [repo3](https://github.com/SapnaDerajeRadhakrishna/spring-micro-services/tree/master/netflix-eurekha-naming-server)
   

3. Visibility (Centralised log): To achieve this feature, I have tried both ELK stack and Zipkin Distributed Tracing
   Monitoring: Used **Netflix API Gateway** ** Zuul** See [repo](https://github.com/SapnaDerajeRadhakrishna/spring-micro-services/tree/master/netflix-zuul-api-gateway-server)

4. Fault Tolerance:
   Used **Netflix API Hystrix** See [repo](https://github.com/SapnaDerajeRadhakrishna/spring-micro-services/tree/master/limit-services)



##### Other features tried

1. Used the `spring cloud bus`  and `RabbitMQ` feature 
Spring Cloud Bus links nodes of a distributed system with a lightweight message broker. This can then be used to broadcast state changes (e.g. configuration changes) or other management instructions.
   
