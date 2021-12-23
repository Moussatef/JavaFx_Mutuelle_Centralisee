package com.example.demo1.log;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import java.io.IOException;
import java.sql.SQLException;



public class log4j {

    public log4j(){
    }

    static final Logger log = Logger.getLogger(log4j.class.getName());
    public static void main(String[] args)throws IOException,SQLException{

        log.warn("TEST");
        log.debug("user login" );
        log.info("Info");
        log.error("Not good");
    }

}
