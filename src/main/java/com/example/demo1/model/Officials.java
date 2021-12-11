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
    private Entity entity;

    public Officials(String firstname, String lastname, String cin, String phone, String email, Entity entity) {
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setCin(cin);
        this.setPhone(phone);
        this.setEmail(email);
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

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public int getOfficial_id() {
        return official_id;
    }
}
