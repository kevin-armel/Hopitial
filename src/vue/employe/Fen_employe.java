
package vue.employe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;


public class Fen_employe extends JFrame{
    
    private final JButton btnBack = new JButton("Retour");
    private final JButton btnC_employ = new JButton("Création");
    private final JButton btnRUD_employ = new JButton("Read/update/delate");
    private final JButton btnRep_employ = new JButton("Reporting");
    
    
    public static FenC_employe fenCemp;
    public static FenRUD_employe fenRUDemp;
    public static FenRep_employe fenRepEmp;
    
    /**
     * constructeur de la classe
     */
    public Fen_employe(){

        //Configuration du panel pour le mode d'affichage des boutons
        JPanel panelHaut = new JPanel(new BorderLayout());
        panelHaut.add(btnBack, BorderLayout.WEST);
     
        JPanel panelSousHaut = new JPanel(new BorderLayout(75,0));
        panelSousHaut.add(btnC_employ, BorderLayout.WEST);
        
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
        panelSousCentre.add(btnRUD_employ, BorderLayout.CENTER);
        panelSousCentre.add(separeH2, BorderLayout.EAST);
        panelSousCentre.add(separeV2, BorderLayout.WEST);
        
        JPanel panelSousBas = new JPanel(new BorderLayout(75, 0));

        panelSousBas.add(btnRep_employ, BorderLayout.EAST);

        JPanel panelSousGeneral = new JPanel(new BorderLayout());
        panelSousGeneral.add(panelSousHaut, BorderLayout.NORTH);
        panelSousGeneral.add(panelSousCentre, BorderLayout.CENTER);
        panelSousGeneral.add(panelSousBas, BorderLayout.SOUTH);
        
        JPanel panelGeneral = new JPanel(new BorderLayout(0, 20));
        panelGeneral.add(panelHaut, BorderLayout.NORTH);
        panelGeneral.add(panelSousGeneral, BorderLayout.CENTER);
        
        setContentPane(panelGeneral);
        setIconImage(getToolkit().getImage("img/exec3.png"));
        setTitle("employe");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
    
     public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnC_employ() {
        return btnC_employ;
    }

    public JButton getBtnRUD_employ() {
        return btnRUD_employ;
    }

    public JButton getBtnRep_employ() {
        return btnRep_employ;
    }
    
}
