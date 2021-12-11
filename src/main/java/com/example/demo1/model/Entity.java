package com.example.demo1.model;

public class Entity {
    private int ent_id;
    private String ent_name;
    private String ent_address;
    private String ent_phone;
    private String ent_site;

    public Entity(String ent_name, String ent_address, String ent_phone, String ent_site) {
        this.setEnt_name(ent_name);
        this.setEnt_address(ent_address);
        this.setEnt_phone(ent_phone);
        this.setEnt_site(ent_site);
    }

    public String getEnt_name() {
        return ent_name;
    }

    public void setEnt_name(String ent_name) {
        this.ent_name = ent_name;
    }

    public String getEnt_address() {
        return ent_address;
    }

    public void setEnt_address(String ent_address) {
        this.ent_address = ent_address;
    }

    public String getEnt_phone() {
        return ent_phone;
    }

    public void setEnt_phone(String ent_phone) {
        this.ent_phone = ent_phone;
    }

    public String getEnt_site() {
        return ent_site;
    }

    public void setEnt_site(String ent_site) {
        this.ent_site = ent_site;
    }

    public int getEnt_id() {
        return ent_id;
    }
}
