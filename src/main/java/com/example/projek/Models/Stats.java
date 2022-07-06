package com.example.projek.Models;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */
public class Stats {
    private String  yards;
    private String  completion;
    private String td;
    private String interception;
    private String rushing;
    private Team team;

    public Stats(String yards, String completion, String td, String interception, String rushing, Team team) {
        this.yards = yards;
        this.completion = completion;
        this.td = td;
        this.interception = interception;
        this.rushing = rushing;
        this.team = team;
    }






    public String  getYards(Player player) {
        return yards;
    }

    public String getCompletion(Player player) {
        return completion;
    }

    public String getTd(Player player) {
        return td;
    }

    public String getInterception(Player player) {
        return interception;
    }

    public String getRushing(Player player) {
        return rushing;
    }


}
