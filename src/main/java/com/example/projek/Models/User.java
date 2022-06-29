package com.example.projek.Models;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */
public class User {
    protected int userid;
    protected String username = "Gast";
    protected String password;
    protected static int number = 0;

    public User() {
        userid = number ++;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.userid = number ++;

    }

    protected String getUsername(){
        return username;
    }

    protected String getPassword(){
        return password;
    }
}
