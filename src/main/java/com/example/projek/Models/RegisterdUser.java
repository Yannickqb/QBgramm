package com.example.projek.Models;

//import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */

/**
 * this class is to generate registerd users to give them the full adwentage of the site
 */
public class RegisterdUser extends User {
    protected Date geburtsdatum;
    protected Date dateRegisterd;
    protected String vorname;
    protected String nachname;
    protected String email;
    //protected BufferedImage profilePicture;


    /**
     * @param username
     * @param password
     * @param geburtsdatum
     * @param dateRegisterd
     * @param vorname
     * @param nachname
     * @param email
     */
    public RegisterdUser(String username, String password, Date geburtsdatum, Date dateRegisterd, String vorname, String nachname, String email) {
        super(username, password);
        this.geburtsdatum = geburtsdatum;
        this.dateRegisterd = dateRegisterd;
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;

    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public Date getDateRegisterd() {
        return dateRegisterd;
    }

    /**
     * getter
     * @return first name of the user
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * getter
     * @return familyname of user
     */
    public String getNachname() {
        return nachname;
    }

    public String getEmail() {
        return email;
    }

    /**
     * getter
     * @return userneme of user
     */
    public String getUsername(){
        return username;
    }


    /**
     * getter
     * @param username to check the username for login
     * @param password the password fro login
     * @return the login data
     */
    public boolean getLogin(String username, String password){
        return (username.equals(this.username )&& password.equals(this.password));
    }

   // public BufferedImage getProfilePicture() {
       // return profilePicture;
    //}
}
