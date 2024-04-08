package com.project.dropping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Salesman {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Salesman(byte id_Role, String user_login, String user_password) {
        this.id_Role = id_Role;
        this.user_login = user_login;
        this.user_password = user_password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Getter
    private byte id_Role;
    @Getter
    private byte id_Status;
    @Getter
    private String user_name;
    @Getter
    private String user_login;
    @Getter
    private String user_password;
    @Getter
    private String user_email;

    @Getter
    private String mobile_number;
    @Getter
    private String city;
    @Getter
    private String country;
    @Getter
    private double amount_spent;
    @Getter
    private String number_items_purchased;

    public Salesman(Long id, byte id_Role, byte id_Status, String user_name, String user_login, String user_password, String user_email, String mobile_number, String city, String country, String user_hash, double amount_spent, String number_items_purchased) {
        this.id = id;
        this.id_Role = id_Role;
        this.id_Status = id_Status;
        this.user_name = user_name;
        this.user_login = user_login;
        this.user_password = user_password;
        this.user_email = user_email;
        this.mobile_number = mobile_number;
        this.city = city;
        this.country = country;
        this.user_hash = user_hash;
        this.amount_spent = amount_spent;
        this.number_items_purchased = number_items_purchased;

    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUser_hash(String user_hash) {
        this.user_hash = user_hash;
    }

    private String user_hash;

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Salesman() {
    }

    ;

    public void setId_Role(byte id_Role) {
        this.id_Role = id_Role;
    }

    public void setId_Status(byte id_Status) {
        this.id_Status = id_Status;
    }

    public void setAmount_spent(double amount_spent) {
        this.amount_spent = amount_spent;
    }

    public void setNumber_items_purchased(String number_items_purchased) {
        this.number_items_purchased = number_items_purchased;
    }

}

