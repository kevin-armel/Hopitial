
package controleur;

import controleur.chambre.ChambreController;
import controleur.employe.EmployerController;
import controleur.malade.MaladeController;
import controleur.service.ServiceC_controller;
import controleur.service.ServiceController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Accueil;
import model.Chambre;
import model.Employe;
import model.Malade;
import model.Recherche;
import model.Service;
import vue.Fen_accueil;
import vue.Fen_connexion;
import vue.Fen_search;
import vue.chambre.Fen_chambre;
import vue.employe.Fen_employe;
import vue.malade.Fen_malade;
import vue.service.Fen_service;


public class AccueilController implements ActionListener, AccueilInterface {
    public static Boolean isConnected = false;
    private final Fen_accueil fen_accueil = new Fen_accueil();
    private final Fen_connexion fen_connexion = new Fen_connexion();
    private final Fen_employe fen_employe = new Fen_employe();
    private final Fen_chambre fen_chambre = new Fen_chambre();
    private final Fen_malade fen_malade = new Fen_malade();
    private final Fen_service fen_service = new Fen_service();
    private final Fen_search fen_search = new Fen_search();
    private Accueil a;
    
    
    public AccueilController(Accueil a, boolean isFirstFen){
        //
        this.a = a;
        if(isFirstFen){
            fen_connexion.setVisible(true); // je dois ensuite ecrire la methode pour me connecter a la base de donnee et faire le lien entre chaque fenetre.
            fen_connexion.repaint();
            
        }else{
            isConnected = true;
            fen_accueil.setVisible(true);
            fen_accueil.repaint();
        }
        activerListener();
    }
    
    private void activerListener(){
        fen_connexion.getBtnConnexion().addActionListener(this);
        fen_connexion.getCheckOption().addActionListener(this);
        fen_connexion.getBtnAnnuler().addActionListener(this);
        fen_accueil.getBtnBack().addActionListener(this);
        fen_accueil.getBtnEmploy().addActionListener(this);
        fen_accueil.getBtnMalad().addActionListener(this);
        fen_accueil.getBtnRoom().addActionListener(this);
        fen_accueil.getBtnSearch().addActionListener(this);
        fen_accueil.getBtnServic().addActionListener(this);
    }

    @Override
    public void affichePlusOption(){
        fen_connexion.getLabelBDD().setVisible(true);
        fen_connexion.getLabelBDDPass().setVisible(true);
        fen_connexion.getFieldBDD().setVisible(true);
        fen_connexion.getFieldBDDPass().setVisible(true);
        fen_connexion.getCheckDistant().setVisible(true);
        fen_connexion.getLabelNom().setText("Nom utilisateur distant: ");
        fen_connexion.getLabelPass().setText("Mots de passe distant: ");
        fen_connexion.pack();
        fen_connexion.repaint();
    }
    
    @Override
    public void cachePlusOption(){
        fen_connexion.getLabelBDD().setVisible(false);
        fen_connexion.getLabelBDDPass().setVisible(false);
        fen_connexion.getFieldBDD().setVisible(false);
        fen_connexion.getFieldBDDPass().setVisible(false);
        fen_connexion.getCheckDistant().setVisible(false);
        fen_connexion.getLabelNom().setText("Nom utilisateur: ");
        fen_connexion.getLabelPass().setText("Mots de passe: ");
        fen_connexion.pack();
        fen_connexion.repaint();
    }
    
    @Override
    public void viderChamps(){
        fen_connexion.getFieldBDD().setText("hopital");
        fen_connexion.getFieldBDDPass().setText("");
        fen_connexion.getFieldLogin().setText("");
        fen_connexion.getFieldPass().setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("accueil");
        if(ae.getSource()== fen_connexion.getBtnConnexion()){
            //on teste la connexion a la base de données avant.
            fen_connexion.setVisible(false);
            isConnected = true;
            fen_accueil.setVisible(true);
            fen_accueil.repaint();
        }else if(ae.getSource()== fen_connexion.getCheckOption()){
            if(fen_connexion.getCheckOption().isSelected()){
                fen_connexion.getCheckOption().setText("Décocher pour moins d'option d'authentification");
                affichePlusOption();
            }else{
                fen_connexion.getCheckOption().setText("Cocher pour Plus d'option d'authentification");
                cachePlusOption();
            }
        }else if(ae.getSource()== fen_connexion.getBtnAnnuler()){
            viderChamps();
        }else if(ae.getSource() == fen_accueil.getBtnBack()){
            int reponse = JOptionPane.showOptionDialog(fen_accueil, "Vous êtes sur le point de vous déconnecter.\nEtes vous certains de l'action que vous exécutez?", "Se déconeter", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(reponse == JOptionPane.YES_OPTION){
                fen_accueil.setVisible(false);
                isConnected = false;
                fen_connexion.setVisible(true);
            }
                
        }else if(ae.getSource() == fen_accueil.getBtnEmploy()){
            fen_accueil.dispose();
            Employe e = new Employe();
            EmployerController ec = new EmployerController(e);
            
        }else if(ae.getSource() == fen_accueil.getBtnMalad()){
            fen_accueil.dispose();
            Malade m = new Malade();
            MaladeController ec = new MaladeController(m);
            
        }else if(ae.getSource() == fen_accueil.getBtnRoom()){
            fen_accueil.dispose();
            Chambre c = new Chambre();
            ChambreController ec = new ChambreController(c);
            
        }else if(ae.getSource() == fen_accueil.getBtnSearch()){
            Recherche r = new Recherche();
            SearchController sc = new SearchController(r);
            
        }else if(ae.getSource() == fen_accueil.getBtnServic()){
            fen_accueil.dispose();
            Service s = new Service();
            ServiceController sc = new ServiceController(s);
        }
    }
    
}
