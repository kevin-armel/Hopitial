
package vue.malade;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static vue.Fen_accueil.posiFenetre;


public class Fen_malade extends JFrame{
    
    private final JButton btnBack = new JButton("Retour");
    private final JButton btnC_malad = new JButton("Création");
    private final JButton btnRUD_malad = new JButton("Read/update/delate");
    private final JButton btnRep_malad = new JButton("Reporting");
    
    
    public static FenC_malade fenCmal;
    public static FenRUD_malade fenRUDmal;
    public static FenRep_malade fenRepmal;
    
    
    /**
     * constructeur de la classe
     */
    public Fen_malade(){
        JPanel panelGeneral = new JPanel(new GridLayout(4, 1));
        panelGeneral.add(btnBack);
        panelGeneral.add(btnC_malad);
        panelGeneral.add(btnRUD_malad);
        panelGeneral.add(btnRep_malad);
        setContentPane(panelGeneral);
        setTitle("Malade");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnC_malad() {
        return btnC_malad;
    }

    public JButton getBtnRUD_malad() {
        return btnRUD_malad;
    }

    public JButton getBtnRep_malad() {
        return btnRep_malad;
    }
    
    

}
