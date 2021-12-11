package com.example.demo1.controller;

import com.example.demo1.HelloApplication;
import com.example.demo1.connection.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloController {
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
        validateLogin();
    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = " SELECT * FROM officials WHERE official_id  = 1 " ;

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    System.out.println(queryResult.getString("firstname"));
                    System.out.println(Long.parseLong(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"))+(long)(Math.random()*(100000))));
                }else {
                    System.out.println("Invalid Login, try again");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
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


}