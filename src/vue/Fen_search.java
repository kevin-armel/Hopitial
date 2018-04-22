
package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class Fen_search extends JDialog{
    
    private final JButton btnAide = new JButton("Aide");
    private final JButton btnRecherche = new JButton("Exécuter la recherche");
    
    private final JLabel labRecherche = new JLabel("Entrez l'expression:");
    private final JTextField fieldRecherche = new JTextField();
    private final JRadioButton radioEmploy = new JRadioButton("Employés");
    private final JRadioButton radioChambre = new JRadioButton("Chambres");
    private final JRadioButton radioMalade = new JRadioButton("Malades");
    private final JRadioButton radioService = new JRadioButton("Services");
    private final JRadioButton radioSoigne = new JRadioButton("Soins des malades");
    private final JRadioButton radioHospitalisation= new JRadioButton("Hospitalisation");
    
    private final ButtonGroup grpRadioBtn = new ButtonGroup();
    
    private final JTable tableResultat = new JTable(20, 7);
    
    /**
     * constructeur de la classe
     */
    public Fen_search(){
        setIconImage(getToolkit().getImage("img/exec3.png"));
        grpRadioBtn.add(radioEmploy);
        grpRadioBtn.add(radioMalade);
        grpRadioBtn.add(radioChambre);
        grpRadioBtn.add(radioService);
        grpRadioBtn.add(radioSoigne);
        grpRadioBtn.add(radioHospitalisation);
        radioEmploy.setSelected(true);
        
        JPanel panel_1 = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        panel_1.add(btnAide);
        JPanel panel_2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_2.add(labRecherche);
        fieldRecherche.setPreferredSize(new Dimension(200, 30));
        panel_2.add(fieldRecherche);
        panel_2.add(btnRecherche);
        JPanel panel_3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_3.add(radioEmploy);
        panel_3.add(radioChambre);
        panel_3.add(radioMalade);
        panel_3.add(radioService);
        panel_3.add(radioSoigne);
        panel_3.add(radioHospitalisation);
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

    public JRadioButton getRadioEmploy() {
        return radioEmploy;
    }

    public JRadioButton getRadioChambre() {
        return radioChambre;
    }

    public JRadioButton getRadioMalade() {
        return radioMalade;
    }

    public JRadioButton getRadioService() {
        return radioService;
    }

    public JRadioButton getRadioSoigne() {
        return radioSoigne;
    }

    public JRadioButton getRadioHospitalisation() {
        return radioHospitalisation;
    }

    public ButtonGroup getGrpRadioBtn() {
        return grpRadioBtn;
    }

    public JTable getTableResultat() {
        return tableResultat;
    }
    
}
