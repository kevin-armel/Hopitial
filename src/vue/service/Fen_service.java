
package vue.service;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static vue.Fen_accueil.posiFenetre;


public class Fen_service extends JFrame{
    private final JButton btnBack = new JButton("Retour");
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
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnC_servic() {
        return btnC_servic;
    }

    public JButton getBtnRUD_servic() {
        return btnRUD_servic;
    }

    public JButton getBtnRep_servic() {
        return btnRep_servic;
    }
    
}
