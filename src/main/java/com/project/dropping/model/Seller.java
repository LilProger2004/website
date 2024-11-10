package com.project.dropping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties
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
    @JsonProperty("name")
    String sellerName;

    @Column(name = "seller_login", nullable = false)
    @JsonProperty("login")
    String sellerLogin;

    @Column(name = "seller_password", nullable = false)
    @JsonProperty("password")
    String sellerPassword;

    @Column(name = "seller_email", nullable = false)
    @JsonProperty("email")
    String sellerEmail;

    @Column(name = "seller_mobile_number")
    @JsonProperty("mobileNumber")
    String sellerMobileNumber;

    @Column(name = "seller_city")
    @JsonProperty("city")
    String sellerCity;

    @Column(name = "seller_country")
    @JsonProperty("country")
    String sellerCountry;

    @OneToMany(mappedBy = "seller")
    List<Product> sellerProducts;

    @OneToMany(mappedBy = "seller")
    List<Sale> saleProducts;

    @Column(name = "seller_hash")
    String sellerHash;
}
