
package vue.chambre;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;



public class Fen_chambre extends JFrame{
    
    private final JButton btnBack = new JButton("Retour");
    private final JButton btnC_chambre = new JButton("Création");
    private final JButton btnRUD_chambre = new JButton("Read/update/delate");
    private final JButton btnRep_chambre = new JButton("Reporting");
    
    
    public static FenC_chambre fenCroom;
    public static FenRUD_chambre fenRUDroom;
    public static FenRep_chambre fenRepRoom;
    
    /**
     * constructeur de la classe
     */
    public Fen_chambre(){

        //Configuration du panel pour le mode d'affichage des boutons
        JPanel panelHaut = new JPanel(new BorderLayout());
        panelHaut.add(btnBack, BorderLayout.WEST);
     
        JPanel panelSousHaut = new JPanel(new BorderLayout(75,0));
        panelSousHaut.add(btnC_chambre, BorderLayout.WEST);
        
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
        panelSousCentre.add(btnRUD_chambre, BorderLayout.CENTER);
        panelSousCentre.add(separeH2, BorderLayout.EAST);
        panelSousCentre.add(separeV2, BorderLayout.WEST);
        
        JPanel panelSousBas = new JPanel(new BorderLayout(75, 0));

        panelSousBas.add(btnRep_chambre, BorderLayout.EAST);

        JPanel panelSousGeneral = new JPanel(new BorderLayout());
        panelSousGeneral.add(panelSousHaut, BorderLayout.NORTH);
        panelSousGeneral.add(panelSousCentre, BorderLayout.CENTER);
        panelSousGeneral.add(panelSousBas, BorderLayout.SOUTH);
        
        JPanel panelGeneral = new JPanel(new BorderLayout(0, 20));
        panelGeneral.add(panelHaut, BorderLayout.NORTH);
        panelGeneral.add(panelSousGeneral, BorderLayout.CENTER);
        
        
        setContentPane(panelGeneral);
        setTitle("Chambre");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setIconImage(getToolkit().getImage("img/exec3.png"));    
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnC_chambre() {
        return btnC_chambre;
    }

    public JButton getBtnRUD_chambre() {
        return btnRUD_chambre;
    }

    public JButton getBtnRep_chambre() {
        return btnRep_chambre;
    }
    
    
}
