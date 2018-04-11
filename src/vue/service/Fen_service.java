
package vue.service;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static vue.Fen_accueil.btnBack;
import static vue.Fen_accueil.posiFenetre;


public class Fen_service extends JFrame{
    private final JButton btnC_servic = new JButton("Création");
    private final JButton btnRUD_servic = new JButton("Read/update/delate");
    private final JButton btnRep_servic = new JButton("Reporting");
    
    
    public static FenC_service fenCserv;
    public static FenRUD_service fenRUDserv;
    public static FenRep_service fenRepServ;
    

    /**
     * constructeur de la classe
     */
    public Fen_service(){
        //Fen_accueil.btnBack
        //Configuration du panel pour le mode d'affichage des boutons
        JPanel panelGeneral = new JPanel(new GridLayout(4, 1));
        panelGeneral.add(btnBack);
        panelGeneral.add(btnC_servic);
        panelGeneral.add(btnRUD_servic);
        panelGeneral.add(btnRep_servic);
        setContentPane(panelGeneral);
        setTitle("Service");
        setVisible(true);
        setBounds(200, 200, 400, 250);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //Connecter les actions liées aux boutons à la fenêtre, pour qu'elle puisse interpréter les évènements de ceux-ci
        
        btnC_servic.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 31;
                //setVisible(false);
                fenCserv = new FenC_service();
            }
        });
        
        
        btnRUD_servic.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 32;
                //setVisible(false);
                fenRUDserv = new FenRUD_service();
            }
        });
        
        
        btnRep_servic.addActionListener(new ActionListener() {
            /**
            * 
            * @param var_ae est un objet sur lequel java écoute, et cette methode sera appeler automatiquement, donc y mettre le code.
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                posiFenetre = 33;
                //setVisible(false);
                fenRepServ = new FenRep_service();
            }
        });
        
    }
    
}
