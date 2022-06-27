package Models;

//import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Yannick Ledermann
 * @version 1.3
 */
public class RegisterdUser extends User {
    protected Date geburtsdatum;
    protected Date dateRegisterd;
    protected String vorname;
    protected String nachname;
    protected String email;
    //protected BufferedImage profilePicture;


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

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername(){
        return username;
    }
    public boolean getLogin(String username, String password){
        return (username.equals(this.username )&& password.equals(this.password));
    }

   // public BufferedImage getProfilePicture() {
       // return profilePicture;
    //}
}
