package com.surveygen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;

    @Column(name="name")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Transient
    private String passwordConfirm;

    public User(){

    }

    public  User(int id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPasswordConfirm() { return passwordConfirm; }

    public void setPasswordConfirm(String passwordConfirm) { this.passwordConfirm = passwordConfirm; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + username + '\'' +
                ", emailId='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
