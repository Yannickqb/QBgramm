package com.example.projek;

import Models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Yannick Ledermann
 * @version 1.0
 */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        HelloController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
        Team t1 = new Team(new ArrayList<Player>(), new ArrayList<Coach>(), new ArrayList<Match>(), "Sharks", new Date(2009,7,11), "Schaffhausen", "Shark Tank" );
        Team t2 = new Team(new ArrayList<Player>(), new ArrayList<Coach>(), new ArrayList<Match>(), "Invaders", new Date(2013,8,1), "Langental", "Langental Stadion" );
        Player p1 = new Player(new Date(2003,7,11),"Ledermann", "Yannick", t1, new ArrayList<Match>(), Position.QB);
        Player p2 = new Player(new Date(2000,11,7),"gg", "ff", t2, new ArrayList<Match>(), Position.QB);
        Coach c1 = new Coach(new Date(1969, 11, 8), "Jens", "Urben", t1, new ArrayList<Match>(), CoachPosition.HC);
        Stats st1 = new Stats(p1, 200, 20, 5, 0, 50, t1);
        Stats st2 = new Stats(p2, 100, 12, 2, 3, 20, t2);
        Match m1 = new Match(t1, t2, 60, 30, new Date(2022, 05, 8), new ArrayList<Stats>(), 1);
        RegisterdPlayer rp1 = new RegisterdPlayer("qbled", "110703", new Date(2003, 07, 11), new Date(2022, 1, 7), "Yannick", "Ledermann", "yanni.ledermann@gmail.com");
        RegisterdCoach rc1 = new RegisterdCoach("coachj", "123456", new Date(1969, 11, 8), new Date(2022, 1, 1), "Jens", "Urben", "jens.urb@gmail.com");

        ArrayList<RegisterdUser> registerdUsers = new ArrayList<>();
        registerdUsers.add(rp1);
        registerdUsers.add(rc1);


    }

}