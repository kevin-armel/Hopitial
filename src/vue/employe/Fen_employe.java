
package vue.employe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static vue.Fen_accueil.btnBack;
import static vue.Fen_accueil.posiFenetre;


public class Fen_employe extends JFrame{
    
    private final JButton btnC_employ = new JButton("Création");
    private final JButton btnRUD_employ = new JButton("Read/update/delate");
    private final JButton btnRep_employ = new JButton("Reporting");
    
    
    public static FenC_employe fenCemp;
    public static FenRUD_employe fenRUDemp;
    public static FenRep_employe fenRepEmp;
    
    /**
     * constructeur de la classe
     */
    public Fen_employe(){
        JPanel panelGeneral = new JPanel(new GridLayout(4, 1));
        panelGeneral.add(btnBack);
        panelGeneral.add(btnC_employ);
        panelGeneral.add(btnRUD_employ);
        panelGeneral.add(btnRep_employ);
        setContentPane(panelGeneral);
        setTitle("employe");
        setVisible(true);
        setBounds(200, 200, 400, 250);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        
        //Connecter les actions liées aux boutons à la fenêtre, pour qu'elle puisse interpréter les évènements de ceux-ci
        
        btnC_employ.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                posiFenetre = 11;
                //setVisible(false);
                fenCemp = new FenC_employe();
            }
        });
        
        
        btnRUD_employ.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 12;
                //setVisible(false);
                fenRUDemp = new FenRUD_employe();
            }
        });
        
        
        btnRep_employ.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 13;
                //setVisible(false);
                fenRepEmp = new FenRep_employe();
            }
        });
        
    }
        
}
