
package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

//import static vue.employe.



public class Fen_accueil extends JFrame{

    private final JButton btnBack = new JButton("Retour");
    public static int posiFenetre = 1;
    private final JButton btnEmploy = new JButton("Employés");
    private final JButton btnRoom = new JButton("Chambres");
    private final JButton btnMalad = new JButton("Malades");
    private final JButton btnSearch = new JButton("Recherche");
    private final JButton btnServic = new JButton("Services");
    private final JButton btnPlusConfig = new JButton("Autres configurations"); 
    
    /**
     * constructeur de la classe
     */
    public Fen_accueil(){
        setIconImage(getToolkit().getImage("img/exec3.png"));
        //Configuration du panel pour le mode d'affichage des boutons
        JPanel panelHaut = new JPanel(new BorderLayout());
        panelHaut.add(btnBack, BorderLayout.WEST);
        //panelHaut.add(this)
        
        JPanel panelBas = new JPanel(new BorderLayout());
        panelBas.add(btnPlusConfig, BorderLayout.EAST);
                
        JPanel panelSousHaut = new JPanel(new BorderLayout(75,0));
        panelSousHaut.add(btnEmploy, BorderLayout.WEST);
        panelSousHaut.add(btnMalad, BorderLayout.EAST);
        
        JPanel panelSousCentre = new JPanel(new BorderLayout(130,30));
        JSeparator separeV = new JSeparator(JSeparator.VERTICAL);
        separeV.setPreferredSize(new Dimension(0, 80));
        JSeparator separeH = new JSeparator(JSeparator.HORIZONTAL);
        separeH.setPreferredSize(new Dimension(0, 80));
        JSeparator separeV2 = new JSeparator(JSeparator.VERTICAL);
        separeV.setPreferredSize(new Dimension(30, 0));
        JSeparator separeH2 = new JSeparator(JSeparator.HORIZONTAL);
        separeH.setPreferredSize(new Dimension(30, 0));
        panelSousCentre.add(separeV, BorderLayout.NORTH);
        panelSousCentre.add(separeH, BorderLayout.SOUTH);
        panelSousCentre.add(btnSearch, BorderLayout.CENTER);
        panelSousCentre.add(separeH2, BorderLayout.EAST);
        panelSousCentre.add(separeV2, BorderLayout.WEST);
        
        JPanel panelSousBas = new JPanel(new BorderLayout(75, 0));
        panelSousBas.add(btnRoom, BorderLayout.WEST);
        panelSousBas.add(btnServic, BorderLayout.EAST);
        
        //JPanel panelCentre = new JPanel(new BorderLayout(80, 80));
        
        
        JPanel panelSousGeneral = new JPanel(new BorderLayout());
        panelSousGeneral.add(panelSousHaut, BorderLayout.NORTH);
        panelSousGeneral.add(panelSousCentre, BorderLayout.CENTER);
        panelSousGeneral.add(panelSousBas, BorderLayout.SOUTH);
        
        JPanel panelGeneral = new JPanel(new BorderLayout(0, 20));
        panelGeneral.add(panelHaut, BorderLayout.NORTH);
        panelGeneral.add(panelSousGeneral, BorderLayout.CENTER);
        panelGeneral.add(panelBas, BorderLayout.SOUTH);
        
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

    public JButton getBtnPlusConfig() {
        return btnPlusConfig;
    }
    
}
