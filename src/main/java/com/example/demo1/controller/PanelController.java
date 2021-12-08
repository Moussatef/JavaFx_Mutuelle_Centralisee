package com.example.demo1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PanelController {
    @FXML
    private Button btnSave;
    @FXML
    private TextField inpBadge;
    @FXML
    private TextField inpCompany;
    @FXML
    private TextArea inpAddress;
    @FXML
    private TextField inpCin;
    @FXML
    private TextField inpFname;
    @FXML
    private TextField inpLname;
    @FXML
    private TextField inpEmail;
    @FXML
    private Label msgBadg ;
    @FXML
    private Label msgCompany;
    @FXML
    private Label msgWorkstart;
    @FXML
    private Label msgAdrress;
    @FXML
    private Label msgCin;
    @FXML
    private Label msgFname;
    @FXML
    private Label msgLname;
    @FXML
    private Label msgEmail;
    @FXML
    private DatePicker inpDateStart;


    public void saveInfo(){


        msgBadg.setText(badgeCk());

    }

    public String badgeCk(){
        if( inpBadge.getText().length() < 10 || inpBadge.getText().isEmpty()){
            return "Badge must be 10 characters !!";
        }
        return "";
    }

    public String companyCk(){
        if( inpCompany.getText().length() < 10 || inpCompany.getText().isEmpty()){
            return "Badge must be 10 characters !!";
        }
        return "";
    }
    public String addressCk(){
        if(  inpAddress.getText().isEmpty()){
            return "you must be enter address !!";
        }
        return "";
    }
    public String cinCk(){
        if(  inpBadge.getText().isEmpty()){
            return "you must be enter address !!";
        }
        return "";
    }


}
