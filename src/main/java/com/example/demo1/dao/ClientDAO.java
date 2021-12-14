package com.example.demo1.dao;

import com.example.demo1.connection.DatabaseConnection;
import com.example.demo1.controller.PanelController;
import com.example.demo1.model.Client;
import com.example.demo1.model.Entity;
import com.example.demo1.model.Officials;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO<Client>{


    public List<Client> getClientByIdOfficial(int id){
        String query = "select * from client where official_id ="+ id;
        List<Client> clientList = new ArrayList<>();
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            while (queryResult.next()) {
                clientList.add(new Client(queryResult.getInt("client_id"),queryResult.getString("work_badge"),queryResult.getString("cin"),queryResult.getString("passport"),queryResult.getString("firstname"),queryResult.getString("lastname"),queryResult.getString("phone"),queryResult.getString("email"),queryResult.getString("address"),queryResult.getString("company_name"),LocalDate.parse(queryResult.getDate("hire_date").toString()),queryResult.getInt("official_id"),LocalDate.parse(queryResult.getDate("created_at").toString())));
            }
            return clientList;

        }catch (Exception e){
        e.printStackTrace();
        e.getCause();
        }
        return null;
    }

    public List<Client> findClient(String badge,String cin , String passport,String email){
        String query = "select * from client where work_badge=? or cin =? or passport =? or email =? ";
        List<Client> clientList = new ArrayList<>();
        try{
            PreparedStatement  statement = connectDB.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1,badge);
            statement.setString(2, cin);
            statement.setString(3,passport);
            statement.setString(4,email);
            ResultSet queryResult = statement.executeQuery();
            while (queryResult.next()) {
                System.out.println(queryResult.getString("email"));
                 clientList.add(new Client(queryResult.getInt("client_id"),queryResult.getString("work_badge"),queryResult.getString("cin"),queryResult.getString("passport"),queryResult.getString("firstname"),queryResult.getString("lastname"),queryResult.getString("phone"),queryResult.getString("email"),queryResult.getString("address"),queryResult.getString("company_name"),LocalDate.parse(queryResult.getDate("hire_date").toString()),queryResult.getInt("official_id"),LocalDate.parse(queryResult.getDate("created_at").toString())));
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }


        return clientList;


    }

    @Override
    public Client find(int id) {

        return null;
    }

    @Override
    public Client create(Client client) {

        List<Client> clients = findClient(client.getBadgenumber(), client.getCin(), client.getPassport(), client.getEmail());
        System.out.println(clients.size());
        if(!clients.isEmpty()){
            System.out.println("client already exists");
            return null;
        }
        else {
        String query = "insert into client(firstname, lastname, email, work_badge, company_name, hire_date, cin, passport, phone, address, created_at, official_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try{
            PreparedStatement  statement = connectDB.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1,client.getFirstname());
            statement.setString(2, client.getLastname());
            statement.setString(3,client.getEmail());
            statement.setString(4,client.getBadgenumber());
            statement.setString(5, client.getCompanyName());
            statement.setDate(6,  Date.valueOf(client.getDateStart()));
            statement.setString(7, client.getCin());
            statement.setString(8, client.getPassport());
            statement.setString(9, client.getPhone());
            statement.setString(10,client.getAddress());
            statement.setDate(11, Date.valueOf(client.getCreated_at()));
            statement.setInt(12, PanelController.id);
            statement.executeUpdate();
            return client;

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        }
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
