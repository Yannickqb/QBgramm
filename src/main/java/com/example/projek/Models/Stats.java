package com.example.projek.Models;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */
public class Stats {
    private Player player;
    private int yards;
    private int completion;
    private int td;
    private int interception;
    private int rushing;
    private Team team;

    public Stats(Player player, int yards, int completion, int td, int interception, int rushing, Team team) {
        this.player = player;
        this.yards = yards;
        this.completion = completion;
        this.td = td;
        this.interception = interception;
        this.rushing = rushing;
        this.team = team;
    }



    public Player getPlayer(){
        return player;
    }

    public int getYards(Player player) {
        return yards;
    }

    public int getCompletion(Player player) {
        return completion;
    }

    public int getTd(Player player) {
        return td;
    }

    public int getInterception(Player player) {
        return interception;
    }

    public int getRushing(Player player) {
        return rushing;
    }

    public Team getTeam(Player player) {
        return team;
    }



}
