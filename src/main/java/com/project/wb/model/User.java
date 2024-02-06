package com.project.wb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public User(byte id_Role,String user_login, String user_password) {
        this.id_Role = id_Role;
        this.user_login = user_login;
        this.user_password = user_password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private byte id_Role;
    private byte id_Status;
    private String user_name;
    private String user_login;
    private String user_password;
    private String user_email;

    public User(Long id, byte id_Role, byte id_Status, String user_name, String user_login, String user_password, String user_email) {
        this.id = id;
        this.id_Role = id_Role;
        this.id_Status = id_Status;
        this.user_name = user_name;
        this.user_login = user_login;
        this.user_password = user_password;
        this.user_email = user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public User(){};

    public byte getId_Role() {
        return id_Role;
    }

    public void setId_Role(byte id_Role) {
        this.id_Role = id_Role;
    }

    public byte getId_Status() {
        return id_Status;
    }

    public void setId_Status(byte id_Status) {
        this.id_Status = id_Status;
    }
}
