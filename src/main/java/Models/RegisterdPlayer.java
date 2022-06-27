package Models;

import java.util.Date;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */
public class RegisterdPlayer extends RegisterdUser{
    private Player reference = null;

    public RegisterdPlayer(String username, String password, Date geburtsdatum, Date dateRegisterd, String vorname, String nachname, String email) {
        super(username, password, geburtsdatum, dateRegisterd, vorname, nachname, email);
    }


    public Player getReference() {
        return reference;
    }

    public void setReference(Player p){this.reference = p;}
}
