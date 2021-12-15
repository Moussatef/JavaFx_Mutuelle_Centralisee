package com.example.demo1.dao;

import com.example.demo1.connection.DatabaseConnection;
import com.example.demo1.controller.PanelController;
import com.example.demo1.model.Client;
import com.example.demo1.model.Entity;
import com.example.demo1.model.Officials;
import javafx.scene.chart.XYChart;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientDAO extends DAO<Client>{


    public List<Client> getClientByIdOfficial(int id){
        String query = "select * from client where official_id ="+ id;
        List<Client> clientList = new ArrayList<>();
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            while (queryResult.next()) {
                fetch(clientList, queryResult);
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
                clientList.add(new Client(queryResult.getInt("client_id"),queryResult.getString("work_badge"),queryResult.getString("cin"),queryResult.getString("passport"),queryResult.getString("firstname"),queryResult.getString("lastname"),queryResult.getString("phone"),queryResult.getString("email"),queryResult.getString("address"),queryResult.getString("company_name"), LocalDate.parse(queryResult.getDate("hire_date").toString()),queryResult.getInt("official_id"),LocalDate.parse(queryResult.getDate("created_at").toString())));

            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return clientList;
    }

    private void fetch(List<Client> clientList, ResultSet queryResult) throws SQLException {
        clientList.add(new Client(queryResult.getInt("client_id"),queryResult.getString("work_badge"),queryResult.getString("cin"),queryResult.getString("passport"),queryResult.getString("firstname"),queryResult.getString("lastname"),queryResult.getString("phone"),queryResult.getString("email"),queryResult.getString("address"),queryResult.getString("company_name"), LocalDate.parse(queryResult.getDate("hire_date").toString()),queryResult.getInt("official_id"),LocalDate.parse(queryResult.getDate("created_at").toString())));
    }

    public List<Client> filterClient(String badge,String fName,String lName,String cin,String email){
        List<Client> clientList = new ArrayList<>();
        String query = null ;
/*
        query = badge != null ? "SELECT * FROM client WHERE work_badge LIKE '"+badge+"%'  and official_id="+PanelController.id : query;

        query = fName != null ? "SELECT * FROM client WHERE firstname LIKE '"+fName+"%'  and official_id="+PanelController.id : query;

        query = lName != null ? "SELECT * FROM client WHERE lastname LIKE '"+lName+"%'  and official_id="+PanelController.id : query;

        query = cin != null ? "SELECT * FROM client WHERE cin LIKE '"+cin+"%'  and official_id="+PanelController.id : query;

        query = email != null ? "SELECT * FROM client WHERE email LIKE '"+email+"%'  and official_id="+PanelController.id : query;

 */
        /*
        if(fName.length() > 0)

        if (lName.length() > 0)

        if(cin.length() > 0)

        if (email.length() > 0)

         */

         if (badge != null || fName != null || lName != null || cin != null || email != null ){
             query = "SELECT * FROM client WHERE work_badge LIKE '"+badge+"%' or firstname LIKE '"+fName+"%' or lastname LIKE '"+lName+"%' or cin LIKE '"+cin+"%' or email LIKE '"+email+"%' and official_id ="+PanelController.id;
             //query = "SELECT * FROM client  WHERE work_badge LIKE '"+badge+"%' and firstname LIKE '"+fName+"%' and lastname LIKE '"+lName+"%' and cin LIKE '"+cin+"%' and email LIKE '"+email+"%' and official_id ="+PanelController.id;

         }

         if (badge!= null && fName!= null && lName!= null && cin!= null && email!= null ){
             query = "SELECT * FROM client   WHERE work_badge LIKE '"+badge+"%' and firstname LIKE '"+fName+"%' and lastname LIKE '"+lName+"%' and cin LIKE '"+cin+"%' and email LIKE '"+email+"%' and official_id ="+PanelController.id;

         }

        System.out.println(query);


        if(query != null)
            try{
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(query);
                while (queryResult.next()) {
                    System.out.println(queryResult.getString("cin"));
                    clientList.add(new Client(queryResult.getInt("client_id"),queryResult.getString("work_badge"),queryResult.getString("cin"),queryResult.getString("passport"),queryResult.getString("firstname"),queryResult.getString("lastname"),queryResult.getString("phone"),queryResult.getString("email"),queryResult.getString("address"),queryResult.getString("company_name"), LocalDate.parse(queryResult.getDate("hire_date").toString()),queryResult.getInt("official_id"),LocalDate.parse(queryResult.getDate("created_at").toString())));

                }
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        return clientList;
    }

    public XYChart.Series getStaticMonthStartWork(){
        String query = "SELECT MONTHNAME(hire_date) as \"months\" ,MONTH(hire_date),count(*) as \"nb_client\" FROM client WHERE official_id ="+PanelController.id+"   GROUP BY  MONTH(hire_date)ORDER BY MONTH(hire_date);";

        XYChart.Series series = new XYChart.Series();
        series.setName("NB Client hire by month");
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            while (queryResult.next()) {
                System.out.println(queryResult.getString("months")+" "+queryResult.getInt(3));
                series.getData().add(new XYChart.Data(queryResult.getString(1),queryResult.getInt(3)));
            }
            return series;
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return null;

    }

    public XYChart.Series getStaticDaysCreated(){
        String query = "SELECT  DAYNAME(created_at) as \"day\" , DAY(created_at) ,count(*) as \"nb_client\" FROM client WHERE official_id ="+PanelController.id+"   GROUP BY DAY(created_at) ORDER BY DAY(created_at);";

        XYChart.Series series = new XYChart.Series();
        series.setName("NB client created by day");
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            while (queryResult.next()) {
                System.out.println(queryResult.getString(1)+" "+queryResult.getInt(3));
                series.getData().add(new XYChart.Data(queryResult.getString(1),queryResult.getInt(3)));
            }
            return series;
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return null;

    }

    public XYChart.Series getStaticYearCreated(){
        String query = "SELECT  year(hire_date) as \"year\" , count(*) as \"nb_client\" FROM client WHERE official_id ="+PanelController.id+"   GROUP BY year(hire_date) ORDER BY year(hire_date);";

        XYChart.Series series = new XYChart.Series();
        series.setName("NB client created by year");
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            while (queryResult.next()) {
                System.out.println(queryResult.getString(1)+" "+queryResult.getInt(2));
                series.getData().add(new XYChart.Data(queryResult.getString(1),queryResult.getInt(2)));
            }
            return series;
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
