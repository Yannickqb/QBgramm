package Models;

import java.util.Date;

/**
 * @author Yannick Ledermann
 * @version 1.0
 */
public class RegisterdCoach extends RegisterdUser{
    private Coach reference;

    public RegisterdCoach(String username, String password, Date geburtsdatum, Date dateRegisterd, String vorname, String nachname, String email) {
        super(username, password, geburtsdatum, dateRegisterd, vorname, nachname, email);

    }
    public Coach getReference() {
        return reference;
    }

    public void setReference(Coach c){this.reference = c;}
}
