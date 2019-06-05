package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "email_confirmation")
    private Integer emailConfirmation;

    public User(){}

    public User(String name, String email, String password, Boolean isAdmin, Integer emailConfirmation) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.emailConfirmation = emailConfirmation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Integer getEmailConfirmation() {
        return emailConfirmation;
    }

    public void setEmailConfirmation(Integer emailConfirmation) {
        this.emailConfirmation = emailConfirmation;
    }
}
