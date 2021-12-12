package com.example.demo1.dao;

import com.example.demo1.connection.DatabaseConnection;

import java.sql.Connection;

public class ClientDAO {
    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection("mutuelle_centralisee","root","tooor");


}
