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
    private TextField inpPasport;
    @FXML
    private RadioButton checkCin;
    @FXML
    private RadioButton checkPasport;
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
    @FXML
    private Label lbPassport;
    @FXML
    private Label lbCin;


    public void saveInfo(){
        msgBadg.setText(badgeCk());
        msgCompany.setText(companyCk());
        msgAdrress.setText(addressCk());

    }

    public String badgeCk(){
        if( inpBadge.getText().length() < 10 || inpBadge.getText().isEmpty()){
            return "Badge must be 10 characters !!";
        }
        return "";
    }

    public String companyCk(){
        if( inpCompany.getText().length() > 50   || inpCompany.getText().isEmpty()){
            return "not accept !!";
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
        if( inpCin.getText().isEmpty() || !inpCin.getText().matches("[a-zA-Z]{2}\\d{6}")){
            return "cin not valide!!";
        }
        return "";
    }
    public String passportCk(){
        if( inpCin.getText().isEmpty() || !inpCin.getText().matches("[a-zA-Z]{2}\\d{7}")){
            return "cin not valide!!";
        }
        return "";
    }
    public void cinInp(){
        inpCin.visibleProperty().setValue(true);
        lbCin.visibleProperty().setValue(true);

        inpPasport.visibleProperty().setValue(false);
        lbPassport.visibleProperty().setValue(false);

    }
    public void passInp(){
        inpPasport.visibleProperty().setValue(true);
        lbPassport.visibleProperty().setValue(true);

        inpCin.visibleProperty().setValue(false);
        lbCin.visibleProperty().setValue(false);

    }


}
