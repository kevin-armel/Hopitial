
package vue.malade;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class FenRep_malade extends JFrame{
    
    private final JButton btnBack = new JButton("Retour");
    /**
     * constructeur de la classe
     */
    public FenRep_malade(){
        JPanel panelGeneral = new JPanel(new GridLayout(2, 1));
        panelGeneral.add(btnBack);
        panelGeneral.add(new JButton("Vous changer Ce contenu ci."));
        setContentPane(panelGeneral);
        setTitle("Reporting malade");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public JButton getBtnBack() {
        return btnBack;
    }
        
}
