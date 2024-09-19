package org.example.model.dto;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class OrderItemsDTO {
    @Id
    private int seq;
    private int orderId;
    private int productId;
    private String category;
    private int price;
    private int quantity;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public OrderItemsDTO() {}

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "OrderItemsDTO [seq=" + seq + ", orderId=" + orderId + ", productId=" + productId + ", category=" + category
                + ", price=" + price + ", quantity=" + quantity + ", created_at=" + created_at + "]";
    }
}
