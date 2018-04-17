
package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Accueil {
    public static Connexion connex;

    public Accueil() {
        try {
            connex = new Connexion("hopital", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
