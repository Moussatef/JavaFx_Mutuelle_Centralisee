package com.example.demo1.controller;

import com.example.demo1.model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PanelController implements Initializable {
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
    @FXML
    private ComboBox<Object> cmbN;
    @FXML
    private Button btn_exit;
    @FXML
    private Label lbPhone;
    @FXML
    private TextField inpPhone;
    @FXML
    private Label msgDate;

    public int cmp = 0;

    private List<Client> clientList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillCmb();
    }

    public void saveInfo(){
        cmp = 0;
        msgBadg.setText(badgeCk());
        msgCompany.setText(companyCk());
        msgAdrress.setText(addressCk());
        msgFname.setText(fnameCk());
        msgLname.setText(lnameCk());
        msgEmail.setText(emailCk());
        lbPhone.setText(phoneCk());
        msgDate.setText(dateCk());

        System.out.println(cmbN.getSelectionModel().getSelectedItem());
        if (cmp == 0){

            clientList.add(new Client());

        }


    }

    public void fillCmb(){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("C:\\Users\\otman\\IdeaProjects\\demo1\\src\\main\\resources\\com\\example\\demo1\\json\\paysCode.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;
            cmbN.getItems().clear();
            for (Object o : employeeList) {
                JSONObject employee = (JSONObject) o;
                cmbN.getItems().add(employee.get("code")+" "+employee.get("dial_code"));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String dateCk(){
        if(  inpDateStart.getValue().toString().isEmpty()){
            cmp++;
            return "you must be enter date start !!";
        }
        return "";
    }

    public String badgeCk(){
        if( inpBadge.getText().length() < 10 || inpBadge.getText().isEmpty()){
            cmp++;
            return "Badge must be 10 characters !!";
        }
        return "";
    }
    public String fnameCk(){
        if( inpBadge.getText().length() > 50 || inpBadge.getText().isEmpty()){
            cmp++;
            return "first name not valide !!";
        }
        return "";
    }
    public String lnameCk(){
        if( inpBadge.getText().length() > 50 || inpBadge.getText().isEmpty()){
            cmp++;
            return "last name not valide  !!";
        }
        return "";
    }


    public String companyCk(){
        if( inpCompany.getText().length() > 50   || inpCompany.getText().isEmpty()){
            cmp++;
            return "not accept !!";
        }
        return "";
    }
    public String addressCk(){
        if(  inpAddress.getText().isEmpty()){
            cmp++;
            return "you must be enter address !!";
        }
        return "";
    }
    public String cinCk(){
        if( inpCin.getText().isEmpty() || !inpCin.getText().matches("[a-zA-Z]{2}\\d{6}")){
            cmp++;
            return "cin not valide!!";
        }
        return "";
    }
    public String passportCk(){
        if( inpCin.getText().isEmpty() || !inpCin.getText().matches("[a-zA-Z]{2}\\d{7}")){
            return "cin is not valide!!";
        }
        return "";
    }
    public String emailCk(){
       String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if( inpEmail.getText().isEmpty() || !inpEmail.getText().matches(regexPattern)){
            cmp++;
            return "Email is not valide!!";
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

    public String phoneCk(){

        if(inpPhone.getText().isEmpty() || inpPhone.getText().length() != 9 ){
            cmp++;

            return "Phone number in not valid";
        }
        if(cmbN.getSelectionModel().getSelectedItem().equals("MA +212") && (inpPhone.getText().charAt(0) != '6' && inpPhone.getText().charAt(0) != '7')){
            cmp++;
            System.out.println(inpPhone.getText().charAt(0));
            return "Phone number in not valid first 6 or 7";
        }
        return "";
    }

    public void onExitClick(ActionEvent event) {
        Stage stage = (Stage) btn_exit.getScene().getWindow();
        stage.close();
    }
}
