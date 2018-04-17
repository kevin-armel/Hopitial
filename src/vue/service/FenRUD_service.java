
package vue.service;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class FenRUD_service extends JFrame{
    
    private final JButton btnBack = new JButton("Retour");
    /**
     * constructeur de la classe
     */
    public FenRUD_service(){
        JPanel panelGeneral = new JPanel(new GridLayout(2, 1));
        panelGeneral.add(btnBack);
        panelGeneral.add(new JButton("Vous changer Ce contenu ci."));
        setContentPane(panelGeneral);
        setTitle("RUD service");
        setVisible(true);
        setBounds(200, 200, 200, 250);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        
    }
        
}
