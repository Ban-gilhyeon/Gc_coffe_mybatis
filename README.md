# Gc_coffe_mybatis
데브코스 1차 개인 프로젝트 mybatis 

## 개요 
**👉**  백엔드 개발을 위한 환경 설정을 진행하고 GET과 POST를 이용해서, 커피 메뉴 데이터를 관리하는 4가지 로직 CRUD(Create, Read, Update,Delete)를 구현하는 프로젝트를 실행해봅니다.

### 🎯 HTTP 메서드 PUT 을 이용, Update, DELETE 를 이용해 Delete 기능을 구현해주세요.

- HTTP 메서드 PUT 를 이용해 Update, DELETE 를 이용해 Delete 기능을 구현해주세요.
    - PUT : 해당하는 id에 해당하는 데이터를 갱신하는 기능을 구현합니다.
    - DELETE : 해당하는 id에 해당하는 데이터를 삭제하는 기능을 구현합니다.
- 새로운 메뉴를 추가하는 POST 영역에서 id가 4로 고정되어있는 문제를 해결합니다.
    - POST 요청이 들어올 때마다 id가 하나씩 증가하여 메뉴 리스트에 추가될 수 있도록 코드를 추가 구현합니다.
    - SQL과 ORM 중 하나를 선택하여 데이터 베이스를 구현하여 제작합니다.
- 구현한 데이터베이스 연동을 구현합니다.

## 프로젝트 명세서

### Background

우리는 작은 로컬 카페 **Grids & Circles** 입니다. 고객들이 Coffe Bean package를 온라인 웹 사이트로 주문합니다. 매일 전날 오후 2시부터 오늘 오후 2시까지의 주문을 모아서 처리합니다.

현재는 총 4개의 상품이 존재합니다.

우리는 별도의 회원을 관리하지 않습니다. email로 고객을 구분해요. 주문을 받을 때 email을 같이 받아서 주문을 받습니다. 하나의 email로 하루에 여러  번 주문을 받더라도 하나로 합쳐서 다음날 배송을 보내면 됩니다. 

<aside>
💡

고객에게 **“당일 오후 2시 이후의 주문은 다음날 배송을 시작합니다.”** 라고 알려 줍니다.

</aside>

## 개발 환경 
- intelliJ 
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
  - MySQL
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

## 테이블
### ERD 
![image](https://github.com/user-attachments/assets/875352f4-2435-49b4-9b27-6e2442497935)


### 쿼리
 ```mysql
drop table products;
CREATE TABLE products
(
    product_id  int primary key auto_increment,
    product_name VARCHAR(20) NOT NULL,
    category     VARCHAR(50) NOT NULL,
    price        bigint      NOT NULL,
    description  VARCHAR(500) DEFAULT NULL,
    created_at   datetime(6) NOT NULL,
    updated_at   datetime(6)  DEFAULT NULL
);

drop table orders;
CREATE TABLE orders
(
    order_id     int primary key auto_increment,
    email        VARCHAR(50)  NOT NULL,
    address      VARCHAR(200) NOT NULL,
    postcode     VARCHAR(200) NOT NULL,
    order_status VARCHAR(50)  NOT NULL,
    created_at   datetime(6)  NOT NULL,
    updated_at   datetime(6) DEFAULT NULL
);

drop table order_items;
CREATE TABLE order_items
(
    seq        bigint      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    order_id  int  NOT NULL,
    product_id int  NOT NULL,
    category   VARCHAR(50) NOT NULL,
    price      bigint      NOT NULL,
    quantity   int         NOT NULL,
    created_at datetime(6) NOT NULL,
    updated_at datetime(6) DEFAULT NULL,
    INDEX (order_id),
    CONSTRAINT fk_order_items_to_order FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE,
    CONSTRAINT fk_order_items_to_product FOREIGN KEY (product_id) REFERENCES products (product_id)
);
 ```

## 1차 프로젝트 구현 내용 
  1. products 테이블 CRUD
     1. create
        - ![image](https://github.com/user-attachments/assets/275f92d4-9c05-4a0e-b35c-35ea7efe62bd)
        - ![image](https://github.com/user-attachments/assets/ae6bf5d7-a4c5-4b41-b4c7-f8f48da27fa5)


     3. read
        - ![image](https://github.com/user-attachments/assets/be39f9ad-7b27-4754-ad5a-0d0f384a658a)

     4. update
        - ![image](https://github.com/user-attachments/assets/c75a1b64-0177-4f16-9f9b-efd3537ec803)

     5. delete
        - ![image](https://github.com/user-attachments/assets/f9dec2fa-8e79-4398-a303-15f92417de73)

   
  2. orders 테이블 CRUD
     1. create
        - ![image](https://github.com/user-attachments/assets/1daf88fb-21e2-4c82-ae1e-2efc34e032c1)
        - ![image](https://github.com/user-attachments/assets/1d920960-5462-4066-b7ad-ead9eedcaf13)


     2. read
        - ![image](https://github.com/user-attachments/assets/934a1b6d-6368-4598-882e-83ae0e75d006)

     3. update
        - ![image](https://github.com/user-attachments/assets/d1963dd7-b8f4-47d2-b18e-546f30dab346)

     4. delete
        - ![image](https://github.com/user-attachments/assets/33f46cf4-ec7e-462f-b1fc-d501f2fde604)

  3. order_items 테이블 CRUD
     1. create
        - ![image](https://github.com/user-attachments/assets/584bc5bf-8b42-4e83-9b11-d233a4ea7dc0)
        - ![image](https://github.com/user-attachments/assets/b2fc25de-3bd2-4df2-99ca-e26a9f44e869)

     2. read
        - ![image](https://github.com/user-attachments/assets/380d14a4-6a72-42f0-9d03-1e2dd58ebb72)

     3. update
        - ![image](https://github.com/user-attachments/assets/58ccde28-f2f2-4cbb-aac6-45833fd939f8)

     4. delete
        - ![image](https://github.com/user-attachments/assets/539fcb4a-4f82-4ad1-9f86-bc48182151ab)


## 트러블 슈팅 

 ### UUID 
 꺽임;; 

 ### setter 이름 문제 
  : DTO 클래스와 Service 클래스에서의 setter 이름으로 인해서 오류가 났음 
  setter에 파라미터 LocalDateTime 객체 넣었다가 인식 못하고 자꾸  스프링 부트에서 String status를 LocalDateTime변환하려다가 오류가 났음 
```java
//DTO
public class OrdersDTO {
    @Id
    private int orderId;
    private String email;
    private String address;
    private String postCode;
    private String orderStatus;

    LocalDateTime created_at;
    LocalDateTime updated_at;

     public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    } 
``` 

 ### 한번에 테이블 두개 인서트할 때 
    : mysql에서는  `int primary key auto_increment` 로 잘 했어서 xml에서는 추가로 수정을 안했었는데 
    `useGeneratedKeys="true" keyProperty="orderId"` 가 없어서 insert 이후에 order.getOrderId가 0으로 계속 나오ㅏㅆ음 
```xml
<insert id="insert" parameterType="org.example.model.dto.OrdersDTO" useGeneratedKeys="true" keyProperty="orderId" >
        Insert into orders(email, address, postcode, order_status, created_at)
        values (#{email}, #{address}, #{postCode}, #{orderStatus}, #{created_at})
    </insert>
```


### 추가로 고민해볼 것들 
- 모든 테이블 update 진행 시 사용자가 update를 한 곳 (어느 부분을 해도) 동적으로 update가 진행되게 하기
- LomBok 활용과 패키징 신경쓰기
- user 관리 기능 


 
