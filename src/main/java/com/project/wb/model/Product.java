package com.project.wb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Product {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    private String product_name;
    private double product_price;
    private String product_describe;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Getter
    private int user_id;

    public Product(Long id, String product_name, double product_price, String product_describe, int user_id) {
        this.id = id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_describe = product_describe;
        this.user_id = user_id;
    }
    public Product(){};

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public void setProduct_describe(String product_describe) {
        this.product_describe = product_describe;
    }
}
