
package model;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import static model.Accueil.connex;


public abstract class Abstract_Personne {
    protected int numero;
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected String tel;

    public Abstract_Personne() {
    }
    
    public int getNumero() {
        return lastNumPerson();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
        public int lastNumPerson() {
        //Test de connexion a la base de donnees
        try {
            ArrayList<String> liste = new ArrayList<String>();
            liste = connex.remplirChampsRequete("SELECT numero FROM employe ORDER BY numero DESC;");
            String res = new String();
            res = liste.get(0).replace("\n", "");
            connex.deconectBDD();
            return Integer.parseInt(res);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossible d'ajouter d'obtenir la liste \n\n"+ e.getMessage(), "Erreur de lecture", JOptionPane.ERROR);
            return 0;
        }
    }
    
}
