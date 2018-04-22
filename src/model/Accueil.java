
package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Accueil {
    public static Connexion connex;

    public Accueil() {
        
    }
    
    public boolean isConnectToServer(String dataBaseName, String userServer, String passServer){
        Boolean b = false;
        System.out.println(dataBaseName);System.out.println(userServer);System.out.println(passServer);
        try {
            connex = new Connexion(dataBaseName, userServer, passServer);
            b = true;
        } catch (SQLException ex) {
            b = false;
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ClassNotFoundException ex) {
            b = false;
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return b;
    }
    
    public boolean isConnectToServer(String dataBaseName, String userServer, String passServer, String passDataBase){
        Boolean b = false;
        try {
            connex = new Connexion(dataBaseName, userServer, passServer, passDataBase);
            b = true;
        } catch (SQLException ex) {
            b = false;
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ClassNotFoundException ex) {
            b = false;
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return b;
    }
}
