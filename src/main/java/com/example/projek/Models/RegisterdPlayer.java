package com.example.projek.Models;

import java.util.Date;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */
public class RegisterdPlayer extends RegisterdUser {
    private Player reference = null;
    private Stats stats;



    /**
     * @param username      username
     * @param password      password
     * @param geburtsdatum  birtdate of the player
     * @param dateRegisterd date on which the player has registerd
     * @param vorname       firstnmae of the player
     * @param nachname      familyname of the player
     * @param email         email of the player
     */
    public RegisterdPlayer(String username, String password, Date geburtsdatum, Date dateRegisterd, String vorname, String nachname, String email) {
        super(username, password, geburtsdatum, dateRegisterd, vorname, nachname, email);
        this.stats = null;
    }


    /**
     * getter
     *
     * @return reference to player
     */
    public Player getReference() {
        return reference;
    }

    /**
     * @return the Email of the player
     */
    public String getMail() {
        getEmail();
        return null;
    }

    /**
     * setter
     *
     * @param p player to stet the reference on
     */
    public void setReference(Player p) {
        this.reference = p;
        this.stats = p.getStats();
    }


    public String getStatsYards(){
        String output =  stats.getYards(reference);
        return output + " yards";
    }

    public String getStatsComp(){
        String output =  stats.getCompletion(reference);
        return output + " complitions";
    }

    public String getStatsRushing(){
        String output =  stats.getRushing(reference);
        return output + " rushing Yards";
    }

    public String getStatsTd(){
        String output =  stats.getTd(reference);
        return output + " TD";
    }

    public String getStatsInt(){
        String output =  stats.getInterception(reference);
        return output + " Int";
    }


}
