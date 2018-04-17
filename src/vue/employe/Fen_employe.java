
package vue.employe;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fen_employe extends JFrame{
    
    private final JButton btnBack = new JButton("Retour");
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
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
    
     public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnC_employ() {
        return btnC_employ;
    }

    public JButton getBtnRUD_employ() {
        return btnRUD_employ;
    }

    public JButton getBtnRep_employ() {
        return btnRep_employ;
    }
    
}
