package com.example.demo1.mpl;

import com.example.demo1.dao.ClientDAO;
import com.example.demo1.model.Client;

import java.util.List;

public class ClientMpl {
    public List<Client> getListClientForOfficial(int id){

        return new ClientDAO().getClientByIdOfficial(id);

    }
}
