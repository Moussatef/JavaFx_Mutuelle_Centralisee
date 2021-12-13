package com.example.demo1.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Client {
    private int client_id;
    private String badgeNumber;
    private String cin;
    private String passport;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String address;
    private String company_name;
    private Date hire_date;
    private int official_id;
    private Date created_at;

    public Client(){
    }

    public Client(int client_id, String badgeNumber, String cin, String passport, String firstname, String lastname, String phone, String email, String address, String company_name, Date hire_date, int official_id, Date created_at) {
        this.client_id = client_id;
        this.badgeNumber = badgeNumber;
        this.cin = cin;
        this.passport = passport;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.company_name = company_name;
        this.hire_date = hire_date;
        this.official_id = official_id;
        this.created_at = created_at;
    }

    public Client(String badgeNumber, String cin, String passport, String firstname, String lastname, String phone, String email, String address, String company_name, Date hire_date, int official_id, Date created_at) {
        this.badgeNumber = badgeNumber;
        this.cin = cin;
        this.passport = passport;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.company_name = company_name;
        this.hire_date = hire_date;
        this.official_id = official_id;
        this.created_at = created_at;
    }

    public String getBadgenumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String companyName) {
        this.company_name = companyName;
    }

    public Date getDateStart() {
        return hire_date;
    }

    public void setDateStart(Date dateStart) {
        this.hire_date = dateStart;
    }

    public int getClient_id() {
        return client_id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getOfficial_id() {
        return official_id;
    }

    public void setOfficial_id(int official_id) {
        this.official_id = official_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
