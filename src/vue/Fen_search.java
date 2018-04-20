
package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class Fen_search extends JDialog{
    
    private final JButton btnAide = new JButton("Aide");
    private final JButton btnRecherche = new JButton("Lancer la recherche");
    
    private final JLabel labRecherche = new JLabel("Entrez l'expression:");
    private final JTextField fieldRecherche = new JTextField();
    private final JCheckBox checkEmploy = new JCheckBox("Employés");
    private final JCheckBox checkChambre = new JCheckBox("Chambres");
    private final JCheckBox checkMalade = new JCheckBox("Malades");
    private final JCheckBox checkService = new JCheckBox("Services");
    
    private final JTable tableResultat = new JTable(20, 7);
    
    /**
     * constructeur de la classe
     */
    public Fen_search(){
        JPanel panel_1 = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        panel_1.add(btnAide);
        JPanel panel_2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_2.add(labRecherche);
        fieldRecherche.setPreferredSize(new Dimension(200, 30));
        panel_2.add(fieldRecherche);
        panel_2.add(btnRecherche);
        JPanel panel_3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_3.add(checkEmploy);
        panel_3.add(checkChambre);
        panel_3.add(checkMalade);
        panel_3.add(checkService);
        JPanel panelMilieu = new JPanel(new BorderLayout());
        panelMilieu.add(panel_2, BorderLayout.NORTH);
        panelMilieu.add(panel_3, BorderLayout.CENTER);
        JScrollPane pan_4 = new JScrollPane(tableResultat);
        
        JPanel panelGeneral = new JPanel(new BorderLayout());
        panelGeneral.add(panel_1, BorderLayout.NORTH);
        panelGeneral.add(panelMilieu, BorderLayout.CENTER);
        panelGeneral.add(pan_4, BorderLayout.SOUTH);
        setContentPane(panelGeneral);
        setTitle("Recherche");
        pack();
        repaint();
        //setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
           
    }

    public JButton getBtnAide() {
        return btnAide;
    }

    public JButton getBtnRecherche() {
        return btnRecherche;
    }

    public JTextField getFieldRecherche() {
        return fieldRecherche;
    }

    public JCheckBox getCheckEmploy() {
        return checkEmploy;
    }

    public JCheckBox getCheckChambre() {
        return checkChambre;
    }

    public JCheckBox getCheckMalade() {
        return checkMalade;
    }

    public JCheckBox getCheckService() {
        return checkService;
    }

    public JTable getTableResultat() {
        return tableResultat;
    }
    
    
    
}
