package com.example.projek.Data;

import com.example.projek.Models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */
public class DB {
    ArrayList<RegisterdUser> registerdUsers = new ArrayList<>();
    ArrayList<RegisterdPlayer> registerdPlayers = new ArrayList<>();
    ArrayList<RegisterdCoach> registerdCoaches = new ArrayList<>();


    public DB() {
        Team t1 = new Team(new ArrayList<Player>(), new ArrayList<Coach>(), new ArrayList<Match>(), "Sharks", new Date(2009, 7, 11), "Schaffhausen", "Shark Tank");
        Team t2 = new Team(new ArrayList<Player>(), new ArrayList<Coach>(), new ArrayList<Match>(), "Invaders", new Date(2013, 8, 1), "Langental", "Langental Stadion");
        Stats st1 = new Stats("200", "20", "5", "0", "50", t1);
        Stats st2 = new Stats("100", "12", "2", "3", "20", t2);
        Stats st3 = new Stats("100", "12", "2", "3", "20", t2);
        Stats st4 = new Stats("100", "12", "2", "3", "20", t2);
        Stats st5 = new Stats("100", "12", "2", "3", "20", t2);
        Stats st6 = new Stats("100", "12", "2", "3", "20", t2);
        Stats st7 = new Stats("100", "12", "2", "3", "20", t2);
        Stats st8 = new Stats("100", "12", "2", "3", "20", t2);
        Player p1 = new Player(new Date(2003, 7, 11), "Ledermann", "Yannick", t1, new ArrayList<Match>(), Position.QB, st1);
        Player p2 = new Player(new Date(2000, 11, 7), "Oli", "Oswald", t1, new ArrayList<Match>(), Position.RB, st2);
        Player p3 = new Player(new Date(2000, 11, 7), "Diego", "Shindele", t1, new ArrayList<Match>(), Position.RB, st3);
        Player p4 = new Player(new Date(2000, 11, 7), "Ael", "Banyard", t1, new ArrayList<Match>(), Position.TE, st4);
        Player p5 = new Player(new Date(2000, 11, 7), "Leandro", "Carwalio", t1, new ArrayList<Match>(), Position.OL, st5);
        Player p6 = new Player(new Date(2000, 11, 7), "Daniel", "Barot", t1, new ArrayList<Match>(), Position.WR, st6);
        Player p7 = new Player(new Date(2000, 11, 7), "Roman", "Frank", t1, new ArrayList<Match>(), Position.WR, st7);
        Player p8 = new Player(new Date(2000, 11, 7), "Emil", "Utubuzay", t1, new ArrayList<Match>(), Position.WR, st8);
        Coach c1 = new Coach(new Date(1989, 12, 11), "Jens", "Urben", t1, new ArrayList<Match>(), CoachPosition.HC);
        Match m1 = new Match(t1, t2, 60, 30, new Date(2022, 05, 8), new ArrayList<Stats>(), 1);
        RegisterdPlayer rp1 = new RegisterdPlayer("qbled", "110703", new Date(2003, 07, 11), new Date(2022, 1, 7), "Yannick", "Ledermann", "yanni.ledermann@gmail.com");
        this.registerdUsers.add(rp1);
        this.registerdPlayers.add(rp1);
        rp1.setReference(p1);
        RegisterdPlayer rp2 = new RegisterdPlayer("gg", "1234", new Date(2000, 05, 11), new Date(2022, 2, 20), "Oliver", "Oswald", "oliver.os@fmail.com");
        this.registerdUsers.add(rp2);
        this.registerdPlayers.add(rp2);
        rp2.setReference(p2);
        RegisterdPlayer rp3 = new RegisterdPlayer("qbled", "110703", new Date(2003, 07, 11), new Date(2022, 1, 7), "Diego", "Shindele", "diege.sh@gmail.com");
        this.registerdUsers.add(rp3);
        this.registerdPlayers.add(rp3);
        rp3.setReference(p3);
        RegisterdPlayer rp4 = new RegisterdPlayer("qbled", "110703", new Date(2003, 07, 11), new Date(2022, 1, 7), "Ael", "Banyard", "Ael.ba@gmail.com");
        this.registerdUsers.add(rp4);
        this.registerdPlayers.add(rp4);
        rp4.setReference(p4);
        RegisterdPlayer rp5 = new RegisterdPlayer("qbled", "110703", new Date(2003, 07, 11), new Date(2022, 1, 7), "Leandro", "Carvalio", "Leandro.ca@gmail.com");
        this.registerdUsers.add(rp5);
        this.registerdPlayers.add(rp5);
        rp5.setReference(p5);
        RegisterdPlayer rp6 = new RegisterdPlayer("qbled", "110703", new Date(2003, 07, 11), new Date(2022, 1, 7), "Daniel", "Barot", "daniel.ba@gmail.com");
        this.registerdUsers.add(rp6);
        this.registerdPlayers.add(rp6);
        rp6.setReference(p6);
        RegisterdPlayer rp7 = new RegisterdPlayer("qbled", "110703", new Date(2003, 07, 11), new Date(2022, 1, 7), "Roman", "Frank", "roman.fr@gmail.com");
        this.registerdUsers.add(rp7);
        this.registerdPlayers.add(rp7);
        rp7.setReference(p7);
        RegisterdPlayer rp8 = new RegisterdPlayer("qbled", "110703", new Date(2003, 07, 11), new Date(2022, 1, 7), "Emil", "Utupuzay", "emil.ut@gmail.com");
        this.registerdUsers.add(rp8);
        this.registerdPlayers.add(rp8);
        rp8.setReference(p8);
        RegisterdCoach rc1 = new RegisterdCoach("coach", "1234", new Date(1989, 12, 11), new Date(2020, 10, 20), "Jens", "Urben", "jens.urben@gmail.com");
        this.registerdUsers.add(rc1);
        this.registerdCoaches.add(rc1);
        rc1.setReference(c1);


    }

    public Optional<RegisterdUser> isRegisterd(String username, String password) {
        for (RegisterdUser ru : registerdUsers
        ) {
            if (ru.getLogin(username, password)) {
                return Optional.of(ru);
            }
        }
        return Optional.empty();
    }

    public Optional<RegisterdUser> checkUsername(String username) {
        for (RegisterdUser ru : registerdUsers
        ) {
            if (ru.getUsername().equals(username)) {
                return Optional.of(ru);
            }
        }
        return Optional.empty();
    }

    public void addUser(String username, String password, Date geburtsdatum, String vorname, String nachname, String email) {
        Date registerdate = new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
        RegisterdUser neu = new RegisterdUser(username, password, geburtsdatum, registerdate, vorname, nachname, email);
        registerdUsers.add(neu);
    }

    public ArrayList<RegisterdPlayer> getPlayers() {
        return registerdPlayers;
    }

    public ArrayList<RegisterdCoach> getCoaches() {
        return registerdCoaches;
    }

}
