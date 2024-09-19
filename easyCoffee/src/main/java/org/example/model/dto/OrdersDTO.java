package org.example.model.dto;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class OrdersDTO {
    @Id
    private int orderId;
    private String email;
    private String address;
    private String postCode;
    private String orderStatus;

    LocalDateTime created_at;
    LocalDateTime updated_at;

    public OrdersDTO() {}

    public OrdersDTO(int orderId, String email, String address, String postCode) {
        this.orderId = orderId;
        this.email = email;
        this.address = address;
        this.postCode = postCode;
    }

    public OrdersDTO(String email, String address, String postCode, String orderStatus) {
        this.email = email;
        this.address = address;
        this.postCode = postCode;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setMyOrderStatus(LocalDateTime now) {
        if (now.getHour() > 14) {
            this.orderStatus = "출고전";
        }
        else {
            this.orderStatus = "출고완료";
        }
    }



    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime now) {
        this.created_at = now;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "OrdersDTO [orderId=" + orderId + ", email=" + email + ", address=" + address
                + ", postCode=" + postCode + ", orderStatus=" + orderStatus + ", created_at="
                + created_at + ", updated_at=" + updated_at + "]";
    }
}
