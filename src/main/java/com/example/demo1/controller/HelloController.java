package com.example.demo1.controller;
import org.apache.log4j.Logger;
import com.example.demo1.HelloApplication;
//import com.example.demo1.interfases.OfficialsInterface;
import com.example.demo1.log.log4j;
import com.example.demo1.mail.MaileSend;
import com.example.demo1.model.Officials;
import com.example.demo1.dao.FactoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button btn_exit;
    @FXML
    private Button btn_login;
    @FXML
    private TextField input_email;
    @FXML
    private PasswordField input_password;
    @FXML
    private Label message;




    public void onExitClick(ActionEvent event) {
        Stage stage = (Stage) btn_exit.getScene().getWindow();
        stage.close();
    }

    public void userLogIn(ActionEvent event) throws IOException {
        if ((this.input_email.getText().isEmpty() || this.input_password.getText().isEmpty())) {
            message.setText("Please fill all the fields");
            log.warn("Warning fields empty");

        }else{
            validateLogin(this.input_email.getText(),this.input_password.getText());
        }
    }

    public void validateLogin(String email,String password) throws IOException {
        HelloApplication form = new HelloApplication();
        Officials officials = FactoryDAO.getOfficialByEmailAndPassword(email,password);

        if (officials != null){
            log.debug(" [login][FORM]" );
            log.info("[ACTION][Login] [STATUS] [successfully] [from] [official] [email] ["+officials.getEmail()+"] [ ID ] ["+officials.getOfficial_id()+"]");

            form.changeScene("panelControlle.fxml");


        }else {
            log.warn("Invalid Login");
            System.out.println("Invalid Login, try again");
            message.setText("Invalide login ,Try again !");
        }



    }

    public void Login() throws IOException {
        HelloApplication m = new HelloApplication();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("C:\\Users\\otman\\IdeaProjects\\demo1\\src\\main\\resources\\com\\example\\demo1\\json\\employees.json"))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            for (Object o : employeeList) {
                JSONObject employee = (JSONObject) o;
                String email = (String) employee.get("email");
                String password = (String) employee.get("password");

                if ((this.input_email.getText().isEmpty() || this.input_password.getText().isEmpty())) {
                    message.setText("Please fill all the fields");
                    break;
                } else if (email.equalsIgnoreCase(this.input_email.getText()) && password.equals(this.input_password.getText())) {
                    message.setText("Success!");
                    m.changeScene("panelControlle.fxml");
                    break;
                } else {
                    message.setText("Invalide login ,Try again !");
                }
            }
        } catch (FileNotFoundException | ParseException e) {

            e.printStackTrace();

        }
    }

    static final Logger log = Logger.getLogger(log4j.class.getName());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        log.debug("Start app " );
        log.info("Application start");


    }
}