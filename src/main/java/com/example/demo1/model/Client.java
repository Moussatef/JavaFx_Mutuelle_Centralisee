package com.example.demo1.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDate hire_date;
    private long official_id;
    private LocalDateTime created_at;

    public Client(){
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





    public LocalDate getDateStart() {
        return hire_date;
    }

    public void setDateStart(LocalDate dateStart) {
        this.hire_date = dateStart;
    }
}
