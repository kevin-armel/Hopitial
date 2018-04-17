
package vue.chambre;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static vue.Fen_accueil.btnBack;
import static vue.Fen_accueil.posiFenetre;


public class Fen_chambre extends JFrame{
    
    private final JButton btnC_chambre = new JButton("Création");
    private final JButton btnRUD_chambre = new JButton("Read/update/delate");
    private final JButton btnRep_chambre = new JButton("Reporting");
    
    
    public static FenC_chambre fenCroom;
    public static FenRUD_chambre fenRUDroom;
    public static FenRep_chambre fenRepRoom;
    
    /**
     * constructeur de la classe
     */
    public Fen_chambre(){
        JPanel panelGeneral = new JPanel(new GridLayout(4, 1));
        panelGeneral.add(btnBack);
        panelGeneral.add(btnC_chambre);
        panelGeneral.add(btnRUD_chambre);
        panelGeneral.add(btnRep_chambre);
        setContentPane(panelGeneral);
        setTitle("chambre");
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Connecter les actions liées aux boutons à la fenêtre, pour qu'elle puisse interpréter les évènements de ceux-ci
        
        btnC_chambre.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 41;
                //setVisible(false);
                fenCroom = new FenC_chambre();
            }
        });
        
        
        btnRUD_chambre.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 42;
                //setVisible(false);
                fenRUDroom = new FenRUD_chambre();
            }
        });
        
        
        btnRep_chambre.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 43;
                //setVisible(false);
                fenRepRoom = new FenRep_chambre();
            }
        });
        
    }
}
