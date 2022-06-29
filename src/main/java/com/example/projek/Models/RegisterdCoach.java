package com.example.projek.Models;

import java.util.Date;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */

/**
 * this class creates the registerd coaches
 */
public class RegisterdCoach extends RegisterdUser{
    private Coach reference;

    /**
     * @param username username
     * @param password password
     * @param geburtsdatum birthday
     * @param dateRegisterd date on which the Coach has registerd
     * @param vorname firstnmae
     * @param nachname familyname
     * @param email email of the Coach
     */
    public RegisterdCoach(String username, String password, Date geburtsdatum, Date dateRegisterd, String vorname, String nachname, String email) {
        super(username, password, geburtsdatum, dateRegisterd, vorname, nachname, email);

    }

    /**
     * @return the reference to get the team
     */
    public Coach getReference() {
        return reference;
    }

    /**
     * @param c for which coach the reference needs to be set
     */
    public void setReference(Coach c){this.reference = c;}
}
