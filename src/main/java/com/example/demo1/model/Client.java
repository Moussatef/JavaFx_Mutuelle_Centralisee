package com.example.demo1.model;

public class Client {
    private String badgeNumber;
    private String cin;
    private String passport;
    private String Fname;
    private String Lname;
    private String phoneNumber;
    private String email;
    private String address;
    private String companyName;

    public Client(String badgeNumber, String cin, String passport, String fname, String lname, String phoneNumber, String email, String address, String companyName) {
        this.badgeNumber = badgeNumber;
        this.cin = cin;
        this.passport = passport;
        Fname = fname;
        Lname = lname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.companyName = companyName;
    }

    public String getBadgeNumber() {
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

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
