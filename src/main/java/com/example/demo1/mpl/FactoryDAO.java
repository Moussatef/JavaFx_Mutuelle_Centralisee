package com.example.demo1.mpl;

import com.example.demo1.dao.ClientDAO;
import com.example.demo1.dao.OfficialsDAO;
import com.example.demo1.model.Client;
import com.example.demo1.model.Officials;

import java.util.List;

public  class FactoryDAO {


    public static Officials getOfficialByEmailAndPassword(String Email, String Password){
        return new OfficialsDAO().getOfficialByEmailAndPassword(Email, Password);
    }
    public static Officials getOfficialById(int id){
        return new OfficialsDAO().find(id);
    }


    public static List<Client> getListClientForOfficial(int id){

        return new ClientDAO().getClientByIdOfficial(id);

    }

    public static List<Client> filterClient(String badge,String fName,String lName,String cin,String email){
        return new ClientDAO().filterClient( badge, fName, lName, cin, email);
    }

    public static Client insertClient(Client client){

        return new ClientDAO().create(client);

    }



}
