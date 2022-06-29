package com.example.projek.Models;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */

/**
 * this class is used to generate all Coaches
 */
public class Coach{
    private Team team;
    private ArrayList<Match> matches;
    private ArrayList<CoachPosition> coachPositions;
    private String vorname;
    private String name;
    private Date geburtsdatum;

    /**
     * @param geburtsdatum for birth date
     * @param vorname for firstname
     * @param name for familiname
     * @param team for the team
     * @param matches for the games
     * @param coachPosition to get the Coaches position
     */
    public Coach(Date geburtsdatum, String vorname, String name, Team team, ArrayList<Match> matches, CoachPosition coachPosition) {
        this.team = team;
        this.matches = matches;
        team.addCoache(this);
        this.coachPositions = coachPositions;
        this.vorname = vorname;
        this.name = name;
        this.geburtsdatum = geburtsdatum;
    }

    public Team getTeamReference() {
        return team;
    }

    /**
     * getter
     * @return the team which is coached by this coach
     */
    public String  getTeam() {return team.getName();}

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public ArrayList<CoachPosition> getCoachPositions() {
        return coachPositions;
    }

    /**
     * @return the firstname of the Coach
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * @return the familiname of the coach
     */
    public String getName() {
        return name;
    }
}
