package com.example.demo1.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

public class ClientTest {

    @Mock private  Client client;

    @Rule public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception{

    }
    @Test
    public void getBadgenumber() {

    }

    @Test
    public void setBadgeNumber() {
    }
}