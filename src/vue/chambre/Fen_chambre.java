
package vue.chambre;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Fen_chambre extends JFrame{
    
    private final JButton btnBack = new JButton("Retour");
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
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnC_chambre() {
        return btnC_chambre;
    }

    public JButton getBtnRUD_chambre() {
        return btnRUD_chambre;
    }

    public JButton getBtnRep_chambre() {
        return btnRep_chambre;
    }
    
    
}
