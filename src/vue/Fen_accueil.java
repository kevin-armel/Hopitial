
package vue;

import vue.service.Fen_service;
import vue.malade.Fen_malade;
import vue.employe.Fen_employe;
import vue.chambre.Fen_chambre;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import static vue.employe.Fen_employe.fenCemp;
import static vue.employe.Fen_employe.fenRUDemp;
import static vue.employe.Fen_employe.fenRepEmp;
//import static vue.employe.



public class Fen_accueil extends JFrame{

    public static JButton btnBack = new JButton("Retour");
    public static int posiFenetre = 1;
    private final JButton btnEmploy = new JButton("Employés");
    private final JButton btnRoom = new JButton("Chambres");
    private final JButton btnMalad = new JButton("Malades");
    private final JButton btnSearch = new JButton("Recherche");
    private final JButton btnServic = new JButton("Services");
        
    private Fen_search fenetreR;
    
    private Fen_employe fenetreE;
    private Fen_malade fenetreM;
    private Fen_service fenetreS;
    private Fen_chambre fenetreC;
 
    /**
     * constructeur de la classe
     */
    public Fen_accueil(){
        
        //Configuration du panel pour le mode d'affichage des boutons
        JPanel panelGeneral = new JPanel(new GridLayout(6, 1));
        panelGeneral.add(btnBack);
        panelGeneral.add(btnEmploy);
        panelGeneral.add(btnRoom);
        panelGeneral.add(btnMalad);
        panelGeneral.add(btnSearch);
        panelGeneral.add(btnServic);
        setContentPane(panelGeneral);
        setTitle("Accueil");
        setVisible(true);
        setBounds(200, 200, 450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Connecter les actions liées aux boutons à la fenêtre, pour qu'elle puisse interpréter les évènements de ceux-ci
        
        btnBack.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                positionFenEmploy();
                positionFenMalade();
                positionFenService();
                positionFenChambre();
                
            }
        });
        
        
        btnEmploy.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                posiFenetre = 10;
                //setVisible(false);
                fenetreE = new Fen_employe();
                
            }
        });
        
        btnMalad.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 20;
                //setVisible(false);
                fenetreM = new Fen_malade();
            }
        });
      
        
        btnServic.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 30;
                //setVisible(false);
                fenetreS = new Fen_service();
            }
        });
        
                
        btnRoom.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 40;
                //setVisible(false);
                fenetreC = new Fen_chambre();
            }
        });
        
        
        btnSearch.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                fenetreR = new Fen_search();
            }
        });

    }
    
    public void positionFenEmploy(){
        switch(posiFenetre){
            //1 represente l'employe et 0 represente la position de la fenetre
            case 10:
                fenetreE.dispose();
                posiFenetre = 0;
                //fenetre.setVisible(true);
                break;
            case 11:
                fenCemp.dispose();
                posiFenetre = 10;
                //fenetre.setVisible(true);
                break;
            case 12:
                fenRUDemp.dispose();
                posiFenetre = 11;
                //fenetre.setVisible(true);
                break;
            case 13:
                fenRepEmp.dispose();
                posiFenetre = 12;
                //fenetre.setVisible(true);
                break;
            default:
                break;
        }
    }
    
    public void positionFenMalade(){
        switch(posiFenetre){
            //2 represente le malade et 0 represente la position de la fenetre
                    
            case 20:
                fenetreM.dispose();
                posiFenetre = 0;
                //fenetre.setVisible(true);
                break;
            case 21:
                fenetreM.dispose();
                posiFenetre = 20;
                //fenetre.setVisible(true);
                break;
            case 22:
                fenetreM.dispose();
                posiFenetre = 21;
                //fenetre.setVisible(true);
                break;
            case 23:
                fenetreM.dispose();
                posiFenetre = 22;
                //fenetre.setVisible(true);
                break;
            default:
                break;
        }
    }
    
    public void positionFenService(){
        switch(posiFenetre){
            //3 represente le service et 0 represente la position de la fenetre
                    
            case 30:
                fenetreS.dispose();
                posiFenetre = 0;
                //fenetre.setVisible(true);
                break;
            case 31:
                fenetreS.dispose();
                posiFenetre = 30;
                //fenetre.setVisible(true);
                break;
            case 32:
                fenetreS.dispose();
                posiFenetre = 31;
                //fenetre.setVisible(true);
                break;
            case 33:
                fenetreS.dispose();
                posiFenetre = 32;
                //fenetre.setVisible(true);
                break;
            default:
                break;
        }
    }
    
    public void positionFenChambre(){
        switch(posiFenetre){
            //2 represente le malade et 0 represente la position de la fenetre
                                      
            case 40:
                fenetreC.dispose();
                posiFenetre = 0;
                //fenetre.setVisible(true);
                break;
            case 41:
                fenetreC.dispose();
                posiFenetre = 40;
                //fenetre.setVisible(true);
                break;
            case 42:
                fenetreC.dispose();
                posiFenetre = 41;
                //fenetre.setVisible(true);
                break;
            case 43:
                fenetreC.dispose();
                posiFenetre = 42;
                //fenetre.setVisible(true);
                break;

            default:
                break;
        }
    }

}
