
package vue.malade;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static vue.Fen_accueil.btnBack;
import static vue.Fen_accueil.posiFenetre;


public class Fen_malade extends JFrame{
    
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
        setVisible(true);
        setBounds(200, 200, 400, 250);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //Connecter les actions liées aux boutons à la fenêtre, pour qu'elle puisse interpréter les évènements de ceux-ci
        
        btnC_malad.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 21;
                //setVisible(false);
                fenCmal = new FenC_malade();
            }
        });
        
        
        btnRUD_malad.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 22;
                //setVisible(false);
                fenRUDmal = new FenRUD_malade();
            }
        });
        
        
        btnRep_malad.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 23;
                //setVisible(false);
                fenRepmal = new FenRep_malade();
            }
        });
        
    }

}
