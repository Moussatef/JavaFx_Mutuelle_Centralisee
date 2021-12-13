package com.example.demo1.dao;

import com.example.demo1.connection.DatabaseConnection;
import com.example.demo1.model.Officials;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OfficialsDAO extends DAO<Officials>{

    public Officials getOfficialByEmailAndPassword(String email,String password){
         String verifyLogin = " SELECT * FROM officials WHERE email  ='"+email+"' and password='"+password+"';";
            try{
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(verifyLogin);
                System.out.println(verifyLogin);
                while (queryResult.next()) {

                    if (queryResult.getInt("official_id") > 0) {
                        System.out.println(queryResult.getString("firstname"));
                       return new Officials(queryResult.getInt("official_id"), queryResult.getString("firstname"), queryResult.getString("lastname"), queryResult.getString("cin"), queryResult.getString("phone"), queryResult.getString("email"), queryResult.getString("password"), queryResult.getInt("ent_id"));
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
