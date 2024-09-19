package org.example.model.dto;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class ProductsDTO {

    @Id
    private int productId;
    private String productName;
    private String category;
    private int price;
    private String description;
    LocalDate created_at;
    LocalDate updated_at;

    public ProductsDTO() {}

    public ProductsDTO(String name, String category, int price, LocalDate created_at, LocalDate updated_at) {
        this.productName = name;
        this.category = category;
        this.price = price;
        this.created_at = LocalDate.now();
        this.updated_at = updated_at;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return LocalDate.now();
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "ProductsDTO [productId=" + productId + ", productName=" + productName + ", category="
                + category + ", price=" + price + ", description=" + description + ", created_at=" + created_at
                + ", updated_at=" + updated_at + "]";
    }
}

