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
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "buyer_id", nullable = false)
    String buyerId;

    @ManyToOne
    Role buyerRole;

    @ManyToOne
    Status buyerStatus;

    @Column(name = "buyer_name", nullable = false)
    String buyerName;

    @Column(name = "buyer_login", nullable = false)
    String buyerLogin;

    @Column(name = "buyer_password", nullable = false)
    String buyerPassword;

    @Column(name = "buyer_email", nullable = false)
    String buyerEmail;

    @Column(name = "buyer_mobile_number")
    String buyerMobileNumber;

    @Column(name = "buyer_city")
    String buyerCity;

    @Column(name = "buyer_country")
    String buyerCountry;

    @Column(name = "buyer_hash")
    String buyerHash;

    @OneToMany(cascade = CascadeType.ALL)
    List<Product> purchasedProducts;

    @OneToMany(mappedBy = "buyer")
    List<Sale> sales;

    public Buyer(String buyerId, Role buyerRole, String buyerLogin, String buyerPassword) {
        this.buyerId = buyerId;
        this.buyerRole = buyerRole;
        this.buyerLogin = buyerLogin;
        this.buyerPassword = buyerPassword;
    }
}
