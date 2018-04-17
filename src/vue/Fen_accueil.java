
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

    private final JButton btnBack = new JButton("Retour");
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
        panelGeneral.add(btnServic);
        panelGeneral.add(btnSearch);
        setContentPane(panelGeneral);
        setTitle("Accueil");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnEmploy() {
        return btnEmploy;
    }

    public JButton getBtnRoom() {
        return btnRoom;
    }

    public JButton getBtnMalad() {
        return btnMalad;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnServic() {
        return btnServic;
    }
    
    

}
