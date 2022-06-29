package com.example.projek;

import com.example.projek.Data.DB;
import com.example.projek.Exceptions.NothingSelectedException;
import com.example.projek.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Date;
import java.util.Optional;

/**
 * @author Yannick Ledermann
 * @version 1.3
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

    @FXML
    public Label namepv;

    @FXML
    public Label testn;

    @FXML
    public Label teampv;

    @FXML
    public Label qbr;

    @FXML
    public Label interseptions;

    @FXML
    public Label td;

    @FXML
    public Label yardsrushing;

    @FXML
    public Label yards;

    @FXML
    public Label namepvc;

    @FXML
    public Label teampvc;

    @FXML
    public Label namecd;

    @FXML
    public TextArea text;

    @FXML
    public ListView namet;

    private Stage stage;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField output;

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

    static private RegisterdPlayer selectedPlayer = null;

    static private RegisterdCoach selectedCoach = null;

    static private Stats selectedStats = null;

    static private Team selectedTeam = null;

    static private User currentUser;

    /**
     * @param event
     * @throws IOException
     * checks the log in data
     */
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

    /**
     * generates the list of all the players
     */
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

    /**
     * generates the list of all the coaches
     */
    @FXML
    public void generatec(){
        namec.getItems().clear();
        teamc.getItems().clear();
        for (RegisterdCoach rc: data.getCoaches()
        ) {
            if(rc.getReference()!=null){
                namec.getItems().add(rc.getReference().getName() + " " + rc.getReference().getVorname());
                teamc.getItems().add(rc.getReference().getTeam());
            }
        }
    }


    /**
     * @param view the Gui that should be opend
     * @param title the titel of this view
     * @param stage
     * @throws IOException
     * to go to a diverent view in general so I didn't have to write this for every view change.
     */
    @FXML
    private void goToView(String view, String title, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(view));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param stage
     * is used to set the stage so the view can change
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private DB data = new DB();


    /**
     * @param event
     * @throws IOException is thrown if something is wrong with the input or the output
     * goes to the registration
     */
    public void goregister(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        goToView("register-view.fxml", "Registration", stage);
    }

    /**
     * @param event
     * @throws IOException is thrown if something is wrong with the input or the output
     * confirms the new user details
     */
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

    /**
     * @param event
     * @throws IOException is thrown if something is wrong with the input or the output
     * goes to the list of players
     */
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

    /**
     * @param event
     * @throws IOException is thrown if something is wrong with the input or the output
     * goes to the list of Coaches
     */
    public void coachview(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        goToView("coaches-view.fxml", "Coach", stage);
    }


    /**
     * @param event
     * @throws IOException is thrown if something is wrong with the input or the output
     * goes back to the home view
     */
    public void home(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage =(Stage) b.getScene().getWindow();
        goToView("selection-view.fxml", "Selection", stage);
    }

    public void onMouseClickedP(MouseEvent mouseEvent) throws IOException {
        int index = name.getSelectionModel().getSelectedIndex();
        selectedPlayer = data.getPlayers().get(index);
        testn.setText(selectedPlayer.getVorname());
    }



    public void gen(ActionEvent event) throws NothingSelectedException {
        if (selectedPlayer == null) throw new NothingSelectedException("no player selected");
        namepv.setText(selectedPlayer.getVorname() + " " + selectedPlayer.getNachname());



    }

    /**
     * @param event
     * @throws IOException is thrown if something is wrong with the input or the output
     * opens the Player view
     */
    public void gopers(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage =(Stage) b.getScene().getWindow();
        //if (selectedPlayer != null) {
        goToView("person-view.fxml", "Person", stage);

    }


    /**
     * @param event
     * @throws NothingSelectedException this exception is thrown if nothing is selected
     * shows the stats of the selected player
     */
    public void showstats(ActionEvent event) throws NothingSelectedException {
        if (selectedPlayer == null) throw new NothingSelectedException("no player selected");
        namepv.setText(selectedPlayer.getVorname() + " " + selectedPlayer.getNachname());
        teampv.setText(selectedPlayer.getReference().getTeam());
        yards.setText(selectedPlayer.getMail());
        //yardsrushing.setText(selectedPlayer);

    }

    public void dm(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage =(Stage) b.getScene().getWindow();
        goToView("send-view.fxml", "DM", stage);
    }

    public void onMouseClickedC(MouseEvent mouseEvent) throws IOException {
        int index = namec.getSelectionModel().getSelectedIndex();
        selectedCoach = data.getCoaches().get(index);
        testn.setText(selectedCoach.getVorname());
    }

    /**
     * @param event
     * @throws IOException is thrown if something is wrong with the input or the output
     */
    public void goPersc(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage =(Stage) b.getScene().getWindow();
        //if (selectedPlayer != null) {
        goToView("personc-view.fxml", "Person", stage);
    }

    /**
     * @param event
     * @throws NothingSelectedException this exception is thrown if nothing is selected
     */
    public void showstatsc(ActionEvent event) throws NothingSelectedException {
        if (selectedCoach == null) throw new NothingSelectedException("no coach selected");
        namepvc.setText(selectedCoach.getVorname() + " " + selectedCoach.getNachname());
        teampvc.setText(selectedCoach.getReference().getTeam());
    }

    public void send(ActionEvent event) {

    }

    /**
     * @param event
     * @throws IOException is thrown if something is wrong with the input or the output
     */
    public void teamview(ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        goToView("team-view.fxml", "Team", stage);
    }

    /**
     * @param mouseEvent
     * @throws NothingSelectedException this exception is thrown if nothing is selected
     */
    public void onMouseClickedT(MouseEvent mouseEvent) throws NothingSelectedException {
        if (selectedTeam == null) throw new NothingSelectedException("no team selected");
        namepvc.setText(selectedTeam.getName());
        ;
    }


    /**
     * @param event
     * opens the Person view for the Team
     */
    public void goperst(ActionEvent event) {
        namet.setAccessibleText(selectedTeam.getName());
    }
}