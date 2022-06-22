package com.example.projek;

import Data.DB;
import Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Date;
import java.util.Optional;

/**
 * @author Yannick Ledermann
 * @version 1.0
 */
public class HelloController {

    @FXML
    public DatePicker bday;

    @FXML
    public TextField email;

    @FXML
    public TextField vorname;

    @FXML
    public TextField nachname;

    private Stage stage;

    @FXML
    private Button conf;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField output;

    @FXML
    private Button newconf;

    @FXML
    private TextField newusername;

    @FXML
    private TextField newpassword;

    @FXML
    private ListView name;

    @FXML
    private ListView team;

    @FXML
    private ListView namec;

    @FXML
    private ListView teamc;

    private User currentUser;

    @FXML
    private void login(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        Optional<RegisterdUser> registerdUser;
        String checkUsername = username.getText();
        String checkPassword = password.getText();
        registerdUser = data.isRegisterd(checkUsername, checkPassword);
        if (! registerdUser.isEmpty()){
            currentUser = registerdUser.get();
            goToView("selection-view.fxml", "Selection", stage);
        }
        else {
            output.setText("nicht gehen");
        }
    }

    @FXML
    public void generate(){
        name.getItems().clear();
        team.getItems().clear();
        for (RegisterdPlayer rp: data.getPlayers()
             ) {
            if(rp.getReference()!=null){
                name.getItems().add(rp.getReference().getName() + " " + rp.getReference().getVorname());
                team.getItems().add(rp.getReference().getTeam());
            }
        }
    }

    public void generatec(){
        namec.getItems().clear();
        teamc.getItems().clear();
        for (RegisterdCoach rp: data.getCoaches()
        ) {
            if(rp.getReference()!=null){
                namec.getItems().add(rp.getReference().getName() + " " + rp.getReference().getVorname());
                teamc.getItems().add(rp.getReference().getTeam());
            }
        }
    }




    @FXML
    private void goToView(String view, String title, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(view));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private DB data = new DB();


    public void goregister(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        goToView("register-view.fxml", "Registration", stage);
    }

    public void bestaetigen(ActionEvent event) throws IOException {
        String checkUsername = newusername.getText();
        String checkPassword = newpassword.getText();
        String checkVorname = vorname.getText();
        String checkName = nachname.getText();
        String checkEmail = email.getText();
        Date checkBeday = new Date(bday.getValue().toEpochDay());
        if (data.checkUsername(checkUsername).isEmpty()) {
            data.addUser(checkUsername, checkPassword, checkBeday, checkVorname, checkName, checkEmail);
            Button b =(Button) event.getSource();
            Stage stage = (Stage) b.getScene().getWindow();
            goToView("selection-view.fxml", "Selection", stage);
        }
        else {
            output.setText("Dieser Benutzername existiert bereits");
        }
    }

    public void playerview(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        goToView("player-view.fxml", "Player", stage);
    }

    public void back(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        goToView("hello-view.fxml", "Loggin", stage);
    }

    public void coachview(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        goToView("coaches-view.fxml", "Coach", stage);
    }

    public void goplayer(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        goToView("person-view.fxml", "Person", stage);

    }
}