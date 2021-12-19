package com.example.demo1.dao;

import com.example.demo1.model.Officials;
import com.example.demo1.mpl.FactoryDAO;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

public class OfficialsDAOTest {


    Officials officials ;

    @Rule public MockitoRule rule = MockitoJUnit.rule();


    @Before
    public void setUp() throws Exception {
        officials = FactoryDAO.getOfficialByEmailAndPassword("yc.a.moussatef@gmail.com","moussatef");
    }

    @Test
    public void TestGetOfficialByEmailAndPassword() {
        assertNotNull(officials);
    }


}