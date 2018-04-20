
package vue.employe;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FenRep_employe extends JFrame{
        private final JButton btnBack = new JButton("Retour");
    /**
     * constructeur de la classe
     */
    public FenRep_employe(){
        JPanel panelGeneral = new JPanel(new GridLayout(2, 1));
        panelGeneral.add(btnBack);
        panelGeneral.add(new JButton("Vous changer Ce contenu ci."));
        setContentPane(panelGeneral);
        setTitle("Reporting employe");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }

    public JButton getBtnBack() {
        return btnBack;
    }
        
}
