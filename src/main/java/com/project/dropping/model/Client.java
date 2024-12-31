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
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "client_id", nullable = false)
    String clientId;

    @ManyToOne
    Role clientRole;

    @ManyToOne
    Status clientStatus;

    @Column(name = "client_name", nullable = false)
    String clientName;

    @Column(name = "username", nullable = false)
    @JsonProperty("username")
    String username;

    @Column(name = "password", nullable = false)
    @JsonProperty("password")
    String password;

    @Column(name = "client_email", nullable = false)
    String clientEmail;

    @Column(name = "client_mobile_number")
    String clientMobileNumber;

    @Column(name = "client_city")
    String clientCity;

    @Column(name = "client_country")
    String clientCountry;

    @Column(name = "client_refresh_token")
    String clientRefreshToken;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    List<Sale> purchasedProducts;

    public Client(String clientId, String clientEmail, String clientName, String username, String password, Role clientRole) {
        this.clientId = clientId;
        this.clientEmail = clientEmail;
        this.clientName = clientName;
        this.username = username;
        this.password = password;
        this.clientRole = clientRole;
    }
}