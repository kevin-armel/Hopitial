
package vue.service;


import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static vue.Fen_accueil.btnBack;


public class FenC_service extends JFrame{
        
    /**
     * constructeur de la classe
     */
    public FenC_service(){
        JPanel panelGeneral = new JPanel(new GridLayout(2, 1));
        panelGeneral.add(btnBack);
        panelGeneral.add(new JButton("Vous changer Ce contenu ci."));
        setContentPane(panelGeneral);
        setTitle("Creation service");
        setVisible(true);
        setBounds(200, 200, 200, 250);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        
    }
        
}
