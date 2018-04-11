
package controleur;
import java.util.ArrayList;
import java.util.Iterator;
import model.Connexion;
import model.SSHTunnel;
import vue.Fen_accueil;

public class Main {
    public static Fen_accueil fenetre;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        fenetre = new Fen_accueil();
        
        
        //Test de connexion a la base de donnees
        try {
            Connexion connex = new Connexion("hopital", "root", "");
            ArrayList<String> liste = new ArrayList<String>();
            //insertion dans la base de donnée
            /* Cette requette ne marche pas, c'est juste pour vous aider à comprendre comment fonctionne la fonction du prof
            connex.ajouterRequeteMaj("INSERT INTO table(les_elements_de_la_table) values(les_valeurs_a_inserer);");
            */
            //exemple pour montrer une selection
            liste = connex.remplirChampsRequete("SELECT * FROM employe;");
            Iterator itemListe = liste.iterator();
            while(itemListe.hasNext()){
                System.out.println(itemListe.next());
            }
            connex.deconectBDD();
        } catch (Exception e) {
            e.getMessage();
        }
        
    }
    
}
