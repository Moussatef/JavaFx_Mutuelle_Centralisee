package com.example.demo1.mpl;

import com.example.demo1.dao.ClientDAO;
import com.example.demo1.model.Client;

import java.util.List;

public class ClientMpl {


    public List<Client> getListClientForOfficial(int id){

        return new ClientDAO().getClientByIdOfficial(id);

    }

    public List<Client> filterClient(String badge,String fName,String lName,String cin,String email){
        return new ClientDAO().filterClient( badge, fName, lName, cin, email);
    }

    public Client insertClient(Client client){

        return new ClientDAO().create(client);

    }
}
