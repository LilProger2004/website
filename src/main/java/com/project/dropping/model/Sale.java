package com.project.dropping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "sale_id", nullable = false)
    String saleId;

    @ManyToOne
    Buyer buyer;
    @ManyToOne
    Product product;
    @ManyToOne
    Seller seller;
    @ManyToOne
    SaleStatus saleStatus;
}
