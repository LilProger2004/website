package com.project.dropping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client implements UserDetails {
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

    @Column(name = "client_login", nullable = false)
    String clientLogin;

    @Column(name = "client_password", nullable = false)
    String clientPassword;

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

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    List<Sale> purchasedProducts;

    public Client(String clientId, String clientEmail, String clientName, String clientLogin, String clientPassword, Role clientRole) {
        this.clientId = clientId;
        this.clientEmail = clientEmail;
        this.clientName = clientName;
        this.clientLogin = clientLogin;
        this.clientPassword = clientPassword;
        this.clientRole = clientRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.clientPassword;
    }

    @Override
    public String getUsername() {
        return this.clientLogin;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
