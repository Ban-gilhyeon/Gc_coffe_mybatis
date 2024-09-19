# Gc_coffe_mybatis
데브코스 1차 개인 프로젝트 mybatis 

## 개발 환경 
### 버전관리 
### 개발도구 
### 백엔드 기술 스택 
- Spring boot 3.3.3
- dependencies
  - Spring Boot DevTools
  - Sprting Web
  - Spring Data JDBC
  - MyBatis Framework
  - MySQL Driver
  - CycloneDX SBOM support
- 빌드 도구
  - gradle
### 패키지 구조 
```
  📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂org
 ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersController.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductsController.java
 ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderItemsDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductsDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderItemsRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductsRepository.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductsService.java
 ┃ ┃ ┃ ┃ ┗ 📜EasyCoffeeApplication.java
 ┃ ┗ 📂resources
 ┃ ┃ ┣ 📂mappers
 ┃ ┃ ┃ ┣ 📜OrderItemsRepository.xml
 ┃ ┃ ┃ ┣ 📜OrdersRepository.xml
 ┃ ┃ ┃ ┗ 📜ProductsRepository.xml
 ┃ ┃ ┣ 📂static
 ┃ ┃ ┗ 📜application.properties
 ┗ 📂test
 ┃ ┗ 📂java
 ┃ ┃ ┗ 📂org
 ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┗ 📂serivce
 ┃ ┃ ┃ ┃ ┗ 📜EasyCoffeeApplicationTests.java
```

 
