
package vue.malade;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static vue.Fen_accueil.btnBack;


public class FenRep_malade extends JFrame{
        
    /**
     * constructeur de la classe
     */
    public FenRep_malade(){
        JPanel panelGeneral = new JPanel(new GridLayout(2, 1));
        panelGeneral.add(btnBack);
        panelGeneral.add(new JButton("Vous changer Ce contenu ci."));
        setContentPane(panelGeneral);
        setTitle("Reporting malade");
        setVisible(true);
        setBounds(200, 200, 200, 250);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        
    }
        
}