
package vue.service;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import static vue.Fen_accueil.posiFenetre;


public class Fen_service extends JFrame{
    private final JButton btnBack = new JButton("Retour");
    private final JButton btnC_servic = new JButton("Création");
    private final JButton btnRUD_servic = new JButton("Read/update/delate");
    private final JButton btnRep_servic = new JButton("Reporting");
    
    
    public static FenC_service fenCserv;
    public static FenRUD_service fenRUDserv;
    public static FenRep_service fenRepServ;
    

    /**
     * constructeur de la classe
     */
    public Fen_service(){
        //Fen_accueil.btnBack
        //Configuration du panel pour le mode d'affichage des boutons
        //Configuration du panel pour le mode d'affichage des boutons
        JPanel panelHaut = new JPanel(new BorderLayout());
        panelHaut.add(btnBack, BorderLayout.WEST);
     
        JPanel panelSousHaut = new JPanel(new BorderLayout(75,0));
        panelSousHaut.add(btnC_servic, BorderLayout.WEST);
        
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
        panelSousCentre.add(btnRUD_servic, BorderLayout.CENTER);
        panelSousCentre.add(separeH2, BorderLayout.EAST);
        panelSousCentre.add(separeV2, BorderLayout.WEST);
        
        JPanel panelSousBas = new JPanel(new BorderLayout(75, 0));

        panelSousBas.add(btnRep_servic, BorderLayout.EAST);

        JPanel panelSousGeneral = new JPanel(new BorderLayout());
        panelSousGeneral.add(panelSousHaut, BorderLayout.NORTH);
        panelSousGeneral.add(panelSousCentre, BorderLayout.CENTER);
        panelSousGeneral.add(panelSousBas, BorderLayout.SOUTH);
        
        JPanel panelGeneral = new JPanel(new BorderLayout(0, 20));
        panelGeneral.add(panelHaut, BorderLayout.NORTH);
        panelGeneral.add(panelSousGeneral, BorderLayout.CENTER);
        
        
        
        setContentPane(panelGeneral);
        setTitle("Service");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              setIconImage(getToolkit().getImage("img/exec3.png"));  
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnC_servic() {
        return btnC_servic;
    }

    public JButton getBtnRUD_servic() {
        return btnRUD_servic;
    }

    public JButton getBtnRep_servic() {
        return btnRep_servic;
    }
    
}
