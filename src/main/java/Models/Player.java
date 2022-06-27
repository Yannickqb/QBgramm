package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */
public class Player {
    private Team team;
    private ArrayList <Match> history;
    private Position position;
    private String vorname;
    private String name;
    private Date geburtsdatum;

    public Player(Date geburtsdatum, String vorname, String nachname, Team team, ArrayList<Match> history, Position position) {
        this.team = team;
        team.addPlayer(this);
        this.history = history;
        this.position = position;
        this.geburtsdatum = geburtsdatum;
        this.name = nachname;
        this.vorname = vorname;
    }

    public Team getTeamReference() {
        return team;
    }

    public String getTeam(){return team.getName();}

    public ArrayList<Match> getHistory() {
        return history;
    }

    public Position getPosition() {
        return position;
    }

    public String getVorname() {
        return vorname;
    }

    public String getName() {
        return name;
    }

    public float averigeSeasonRushing(int season){
        int zaeler = 0;
        float summ = 0;
        for (Match m: history
             ) {
            if (season == m.getSeason()){
                Optional<Stats> os = m.getPlayerStats(this);
                if (! os.isEmpty()) {
                    Stats s = os.get();
                    summ += s.getRushing(s.getPlayer());
                    zaeler++;
                }
            }
        }
        return summ / (float) zaeler;
    }

    public float getWinningrec(int season, Team team){
        return team.winningRecord(season);
    }

    public void addGame(Match match){
        history.add(match);
    }
}
