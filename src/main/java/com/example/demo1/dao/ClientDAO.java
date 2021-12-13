package com.example.demo1.dao;

import com.example.demo1.connection.DatabaseConnection;
import com.example.demo1.model.Client;

import java.sql.Connection;

public class ClientDAO extends DAO<Client>{
    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection("mutuelle_centralisee","root","tooor");

    public void saveClient(Client client){

        try{

        }catch (Exception e){
        e.printStackTrace();
        e.getCause();
    }
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
