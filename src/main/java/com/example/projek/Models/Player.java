package com.example.projek.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */

/**
 * this class creates Players
 */
public class Player {
    private Team team;
    private Stats stats;
    private ArrayList<Match> history;
    private Position position;
    private String vorname;
    private String name;
    private Date geburtsdatum;

    /**
     * @param geburtsdatum birthdate
     * @param vorname      firstname
     * @param nachname     familyname
     * @param team         team
     * @param history      record
     * @param position     Position
     */
    public Player(Date geburtsdatum, String vorname, String nachname, Team team, ArrayList<Match> history, Position position, Stats stats) {
        this.team = team;
        this.stats = stats;
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

    /**
     * @return the name of the team
     */
    public String getTeam() {
        return team.getName();
    }

    public Stats getStats(){return stats;}



    //public String getYards(){};

    //public String getYardsRushing(){return stats.getRushing(selectedPlayer)};
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

   /* public float averigeSeasonRushing(int season) {
        int zaeler = 0;
        float summ = 0;
        for (Match m : history
        ) {
            if (season == m.getSeason()) {
                Optional<Stats> os = m.getPlayerStats(this);
                if (!os.isEmpty()) {
                    Stats s = os.get();
                    summ += s.getRushing(s.getPlayer());
                    zaeler++;
                }
            }
        }
        return summ / (float) zaeler;
    }

    */

    public float getWinningrec(int season, Team team) {
        return team.winningRecord(season);
    }

    public void addGame(Match match) {
        history.add(match);
    }
}
