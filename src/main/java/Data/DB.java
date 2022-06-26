package Data;

import Models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

/**
 * @author Yannick Ledermann
 * @version 1.0
 */
public class DB {
    ArrayList<RegisterdUser> registerdUsers = new ArrayList<>();
    ArrayList<RegisterdPlayer> registerdPlayers = new ArrayList<>();
    ArrayList<RegisterdCoach> registerdCoaches = new ArrayList<>();


    public DB() {
        Team t1 = new Team(new ArrayList<Player>(), new ArrayList<Coach>(), new ArrayList<Match>(), "Sharks", new Date(2009,7,11), "Schaffhausen", "Shark Tank" );
        Team t2 = new Team(new ArrayList<Player>(), new ArrayList<Coach>(), new ArrayList<Match>(), "Invaders", new Date(2013,8,1), "Langental", "Langental Stadion" );
        Player p1 = new Player(new Date(2003,7,11),"Ledermann", "Yannick", t1, new ArrayList<Match>(), Position.QB);
        Player p2 = new Player(new Date(2000,11,7),"gg", "ff", t2, new ArrayList<Match>(), Position.QB);
        Coach c1 = new Coach(new Date(1989,12,11), "Jens", "Urben", t1, new ArrayList<Match>(), CoachPosition.HC);
        Stats st1 = new Stats(p1, 200, 20, 5, 0, 50, t1);
        Stats st2 = new Stats(p2, 100, 12, 2, 3, 20, t2);
        Match m1 = new Match(t1, t2, 60, 30, new Date(2022, 05, 8), new ArrayList<Stats>(), 1);
        RegisterdPlayer rp1 = new RegisterdPlayer("qbled", "110703", new Date(2003, 07, 11), new Date(2022, 1, 7), "Yannick", "Ledermann", "yanni.ledermann@gmail.com");
        this.registerdUsers.add(rp1);
        this.registerdPlayers.add(rp1);
        rp1.setReference(p1);
        RegisterdCoach rc1 = new RegisterdCoach("coach", "1234", new Date(1989,12,11), new Date(2020, 10, 20), "Jens", "Urben", "jens.urben@gmail.com");
        this.registerdUsers.add(rc1);
        this.registerdCoaches.add(rc1);
        rc1.setReference(c1);


    }

    public Optional<RegisterdUser> isRegisterd(String username, String password){
        for (RegisterdUser ru: registerdUsers
             ) {
            if (ru.getLogin(username, password)){
                return Optional.of(ru);
            }
        }
        return Optional.empty();
    }

    public Optional<RegisterdUser> checkUsername(String username){
        for (RegisterdUser ru: registerdUsers
        ) {
            if (ru.getUsername().equals(username)){
                return Optional.of(ru);
            }
        }
        return Optional.empty();
    }

    public void addUser (String username, String password, Date geburtsdatum, String vorname, String nachname, String email){
        Date registerdate = new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
        RegisterdUser neu = new RegisterdUser(username, password, geburtsdatum, registerdate, vorname, nachname, email);
        registerdUsers.add(neu);
    }

    public ArrayList<RegisterdPlayer> getPlayers(){
        return registerdPlayers;
    }
    public ArrayList<RegisterdCoach> getCoaches(){
        return registerdCoaches;
    }

}
