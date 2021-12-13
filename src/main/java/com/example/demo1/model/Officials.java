package com.example.demo1.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Officials {
    private int official_id;
    private String firstname;
    private String lastname;
    private String cin;
    private String phone;
    private String email;
    private String password;
    private int entity;

    public Officials(int official_id, String firstname, String lastname, String cin, String phone, String email, String password, int entity) {
        this.official_id = official_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.cin = cin;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.entity = entity;
    }

    public Officials(String firstname, String lastname, String cin, String phone, String email, String password, int entity) {
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setCin(cin);
        this.setPhone(phone);
        this.setEmail(email);
        this.setPassword(password);
        this.setEntity(entity);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEntity() {
        return entity;
    }

    public void setEntity(int entity) {
        this.entity = entity;
    }

    public int getOfficial_id() {
        return official_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
