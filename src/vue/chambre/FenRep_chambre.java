
package vue.chambre;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static vue.Fen_accueil.btnBack;


public class FenRep_chambre extends JFrame{
        
    /**
     * constructeur de la classe
     */
    public FenRep_chambre(){
        JPanel panelGeneral = new JPanel(new GridLayout(2, 1));
        panelGeneral.add(btnBack);
        panelGeneral.add(new JButton("Vous changer Ce contenu ci."));
        setContentPane(panelGeneral);
        setTitle("Reporting Chambre");
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
    }
        
}