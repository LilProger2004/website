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
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "seller_id", nullable = false)
    String sellerId;

    @ManyToOne
    Role sellerRole;

    @ManyToOne
    Status sellerStatus;

    @Column(name = "seller_name", nullable = false)
    String sellerName;

    @Column(name = "seller_login", nullable = false)
    String sellerLogin;

    @Column(name = "seller_password", nullable = false)
    String sellerPassword;

    @Column(name = "seller_email", nullable = false)
    String sellerEmail;

    @Column(name = "seller_mobile_number")
    String sellerMobileNumber;

    @Column(name = "seller_city")
    String sellerCity;

    @Column(name = "seller_country")
    String sellerCountry;

    @OneToMany(mappedBy = "seller")
    List<Product> sellerProducts;

    @Column(name = "seller_hash")
    String sellerHash;
}
