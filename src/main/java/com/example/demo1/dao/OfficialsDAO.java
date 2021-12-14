package com.example.demo1.dao;

import com.example.demo1.connection.DatabaseConnection;
import com.example.demo1.controller.PanelController;
import com.example.demo1.model.Entity;
import com.example.demo1.model.Officials;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OfficialsDAO extends DAO<Officials>{

    public Officials getOfficialByEmailAndPassword(String email,String password){
         String verifyLogin = " SELECT * FROM officials inner join entity on officials.ent_id = entity.ent_id WHERE email  ='"+email+"' and password='"+password+"';";
            try{
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(verifyLogin);
                while (queryResult.next()) {
                    if (queryResult.getInt("official_id") > 0) {
                        PanelController.id = queryResult.getInt("official_id");
                       return new Officials(queryResult.getInt("official_id"), queryResult.getString("firstname"), queryResult.getString("lastname"), queryResult.getString("cin"), queryResult.getString("phone"), queryResult.getString("email"), queryResult.getString("password"), new Entity(queryResult.getInt("ent_id"),queryResult.getString("ent_name"),queryResult.getString("ent_addresse"),queryResult.getString("ent_phone"),queryResult.getString("ent_site")));
                    } else {
                        System.out.println("Invalid Login, try again dao");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        return null;
    }
    @Override
    public Officials find(int id) {
        String verifyLogin = " SELECT * FROM officials inner join entity on officials.ent_id = entity.ent_id WHERE official_id ="+id;
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()) {

                if (queryResult.getRow() > 0) {
                    PanelController.id = queryResult.getInt("official_id");
                    return new Officials(queryResult.getInt("official_id"), queryResult.getString("firstname"), queryResult.getString("lastname"), queryResult.getString("cin"), queryResult.getString("phone"), queryResult.getString("email"), queryResult.getString("password"), new Entity(queryResult.getInt("ent_id"),queryResult.getString("ent_name"),queryResult.getString("ent_addresse"),queryResult.getString("ent_phone"),queryResult.getString("ent_site")));
                } else {
                    System.out.println("Invalid Login, try again dao");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return null;
    }

    @Override
    public Officials create(Officials obj) {
        return null;
    }

    @Override
    public Officials update(Officials obj) {
        return null;
    }

    @Override
    public void delete(Officials obj) {

    }

}
