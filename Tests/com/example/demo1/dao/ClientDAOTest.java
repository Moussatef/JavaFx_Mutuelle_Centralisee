package com.example.demo1.dao;

import com.example.demo1.model.Client;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class ClientDAOTest {

    private List<Client> clients;
    private Client client;


     Client clientTest =  new Client("89-3861550",  "WI5803020", null,  "Barry", "Gillebride","+62 734 892 0947" , "Barry.GilleKide@gmail.com",  "11272 Hermina Crossing",  "Babbleopia" ,  LocalDate.parse("2021-11-13"), 5, LocalDate.now());



    @Before
    public void setUp(){

        clients = FactoryDAO.getListClientForOfficial(5);


    }
    @Test
    public void TestGetClientByIdOfficial() {
        //assertNotNull(clients);
        assertTrue(clients.size() > 0);
    }

    @Before
    public void setClient(){

        client = FactoryDAO.insertClient(clientTest);
        //System.out.println(clientTest.getDateStart());
    }
    @Test
    public void create() {

        assertNotNull(client);
    }
}