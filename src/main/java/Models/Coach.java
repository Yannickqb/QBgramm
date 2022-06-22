package Models;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Yannick Ledermann
 * @version 1.0
 */
public class Coach{
    private Team team;
    private ArrayList<Match> matches;
    private ArrayList<CoachPosition> coachPositions;
    private String vorname;
    private String name;
    private Date geburtsdatum;

    public Coach(Date geburtsdatum, String vorname, String name, Team team, ArrayList<Match> matches, ArrayList<CoachPosition> coachPositions) {
        this.team = team;
        this.matches = matches;
        team.addCoache(this);
        this.coachPositions = coachPositions;
        this.vorname = vorname;
        this.name = name;
        this.geburtsdatum = geburtsdatum;
    }

    public Team getTeam() {
        return team;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public ArrayList<CoachPosition> getCoachPositions() {
        return coachPositions;
    }

    public String getVorname() {
        return vorname;
    }

    public String getName() {
        return name;
    }
}
