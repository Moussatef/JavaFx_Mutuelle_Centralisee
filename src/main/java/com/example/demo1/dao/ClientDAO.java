package com.example.demo1.dao;

import com.example.demo1.connection.DatabaseConnection;
import com.example.demo1.controller.PanelController;
import com.example.demo1.model.Client;
import com.example.demo1.model.Entity;
import com.example.demo1.model.Officials;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO<Client>{


    public List<Client> getClientByIdOfficial(int id){
        String verifyLogin = "select * from client where official_id ="+ id;
        List<Client> clientList = new ArrayList<>();

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()) {
                clientList.add(new Client(queryResult.getInt("client_id"),queryResult.getString("work_badge"),queryResult.getString("cin"),queryResult.getString("passport"),queryResult.getString("firstname"),queryResult.getString("lastname"),queryResult.getString("phone"),queryResult.getString("email"),queryResult.getString("address"),queryResult.getString("company_name"),queryResult.getDate("hire_date"),queryResult.getInt("official_id"),queryResult.getDate("created_at")));
            }
            return clientList;

        }catch (Exception e){
        e.printStackTrace();
        e.getCause();
    }
        return null;
    }
    @Override
    public Client find(int id) {
        return null;
    }

    @Override
    public Client create(Client obj) {
        return null;
    }

    @Override
    public Client update(Client obj) {
        return null;
    }

    @Override
    public void delete(Client obj) {

    }
}
