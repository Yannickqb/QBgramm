package Models;

//import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */
public class Team {
    private ArrayList<Player> player;
    private ArrayList<Coach> coaches;
    private ArrayList<Match> history;
    private String name;
    private Date gruendungsdatum;
    private String location;
    private String stadion;
    //private BufferedImage logo;

    public Team(ArrayList<Player> player, ArrayList<Coach> coaches, ArrayList<Match> history, String name, Date gruendungsdatum, String location, String stadion) {
        this.player = player;
        this.coaches = coaches;
        this.history = history;
        this.name = name;
        this.gruendungsdatum = gruendungsdatum;
        this.location = location;
        this.stadion = stadion;
    }

    public ArrayList<Player> getPlayer() {
        return player;
    }

    public ArrayList<Coach> getCoaches() {
        return coaches;
    }

    public ArrayList<Match> getHistory() {
        return history;
    }

    public String getName() {
        return name;
    }

    public Date getGruendungsdatum() {
        return gruendungsdatum;
    }

    public String getLocation() {
        return location;
    }

    public String getStadion() {
        return stadion;
    }

    //public BufferedImage getLogo() {
       // return logo;
    //}

    public float winningRecord(int season){
        int zaeler = 0;
        float winning = 0;
        for (Match m: history
             ) {
            if (season == m.getSeason()){
                zaeler ++;
                if (m.getWinner() == this){
                    winning++;
                }
            }
        }
        return winning / zaeler;
    }

    public void addPlayer(Player player){
        this.player.add(player);
    }

    public void addCoache(Coach coach){
        coaches.add(coach);
    }
    public void addMatch(Match match){
        history.add(match);
    }
}
