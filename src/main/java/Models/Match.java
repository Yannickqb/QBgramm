package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

/**
 * @author Yannick Ledermann
 * @version 1.0
 */
public class Match {
    private Team home;
    private Team guest;
    private int scoreHome;
    private int scoreGuest;
    private Date datum;
    private ArrayList<Stats> stats;
    private int season;

    public Match(Team home, Team guest, int scoreHome, int scoreGuest, Date datum, ArrayList<Stats> stats, int season) {
        this.home = home;
        this.guest = guest;
        this.scoreHome = scoreHome;
        home.addMatch(this);
        for (Player player: home.getPlayer()
             ) {
            player.addGame(this);
        }
        this.scoreGuest = scoreGuest;
        guest.addMatch(this);
        for (Player player: guest.getPlayer()
        ) {
            player.addGame(this);
        }
        this.datum = datum;
        this.stats = stats;
        this.season = season;
    }

    public Optional<Stats> getPlayerStats(Player player){
        for (Stats s: stats
             ) {
            if (player == s.getPlayer()){
                return Optional.of (s);
            }
        }
            return Optional.empty();
    }

    public Team getWinner(){
        if (scoreGuest < scoreHome){
            return home;
        }
        else {
            return guest;
        }
    }

    public Team getHome() {
        return home;
    }

    public Team getGuest() {
        return guest;
    }

    public int getScoreHome() {
        return scoreHome;
    }

    public int getScoreGuest() {
        return scoreGuest;
    }

    public Date getDatum() {
        return datum;
    }

    public ArrayList<Stats> getStats() {
        return stats;
    }

    public int getSeason() {
        return season;
    }

    public void addStats(Stats stats){
        this.stats.add(stats);
    }
}
