package com.example.demo1.dao;

import com.example.demo1.model.Officials;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class OfficialsDAOTest {


    Officials officials ;



    @Before
    public void setUp() throws Exception {
        officials = FactoryDAO.getOfficialByEmailAndPassword("yc.a.moussatef@gmail.com","moussatef");
    }

    @Test
    public void TestGetOfficialByEmailAndPassword() {
        assertNotNull(officials);
    }


}