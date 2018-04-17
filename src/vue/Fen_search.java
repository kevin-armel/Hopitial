
package vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import static vue.Fen_accueil.btnBack;


public class Fen_search extends JDialog{
    
    private final JButton btnC_search = new JButton("Effectuer la recherche");
    private final JButton btnRUD_search = new JButton("deuxieme bouton");
    
    /**
     * constructeur de la classe
     */
    public Fen_search(){
        JPanel panelGeneral = new JPanel(new GridLayout(4, 1));
        panelGeneral.add(btnBack);
        panelGeneral.add(btnC_search);
        panelGeneral.add(btnRUD_search);
        setContentPane(panelGeneral);
        setTitle("Recherche");
        setVisible(true);
        setBounds(100, 50, 500, 450);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        
        //Connecter les actions liées aux boutons à la fenêtre, pour qu'elle puisse interpréter les évènements de ceux-ci
        
        btnC_search.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
            }
        });
        
        
        btnRUD_search.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
            }
        });
       
    }
    
    
}
