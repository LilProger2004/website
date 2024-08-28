package com.project.dropping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "product_id", nullable = false)
    String productId;

    @Column(name = "product_name", nullable = false)
    String productName;

    @ManyToOne
    Category category;

    @Column(name = "product_price", nullable = false)
    double productPrice;

    @Column(name = "product_discribe", nullable = false)
    String productDescribe;

    @Column(name = "product_count", nullable = false)
    int productCount;

    @ManyToOne
    Seller seller;

    @OneToMany(mappedBy = "product")
    List<Sale> sales;
}
