
package vue.chambre;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;



public class FenRUD_chambre extends JFrame{
    
    private final JButton btnBack = new JButton("Retour");
    private final JButton btnAide = new JButton("Aide");
    private final JButton btnRecherche = new JButton("Rechercher une information");
    private final JButton btnModifier = new JButton("Modifier");
    private final JButton btnRaz = new JButton("Vider les champs");
    private final JButton btnSupression = new JButton("Supprimer");
    private final JButton btnReporting = new JButton("Prise de décision");
    private final JButton btnUpdate = new JButton("Appliquer les modifications");
    private final JButton btnCleSurveil = new JButton("Choix Surveillant");
    private final JLabel labCodeServ = new JLabel("Code du service");
    
    private final JTable tableDonnees = new JTable(17, 5);
    
    private final JLabel labNumChambre = new JLabel("Numéro de la chambre: ");
    private final JLabel labNbrLits = new JLabel("Nombre de lits: ");
    
    private final JTextField fieldCleServic = new JTextField("Choix du service et surveillant: ");
    private final JComboBox comboCodeServ = new JComboBox();
    
    private final JSpinner spinNumChambree = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
    private final JSpinner spinNbrLits = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
    
    private final JCheckBox checkOnModif = new JCheckBox("Autoriser la modification des données");
    
    /**
     * constructeur de la classe
     */
    public FenRUD_chambre(){
        
        btnRaz.setEnabled(false);
        btnModifier.setEnabled(false);
        btnUpdate.setEnabled(false);
        spinNumChambree.setEnabled(false);
        spinNbrLits.setEnabled(false);
        btnCleSurveil.setEnabled(false);
        comboCodeServ.setEnabled(false);
        fieldCleServic.setColumns(12);
        fieldCleServic.setEnabled(false);

        
        tableDonnees.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JPanel panelHaut = new JPanel(new BorderLayout(30, 30));
        panelHaut.add(btnBack, BorderLayout.WEST);
        panelHaut.add(btnRecherche, BorderLayout.CENTER);
        panelHaut.add(btnAide, BorderLayout.EAST);
        
        JScrollPane panelTable = new JScrollPane(tableDonnees);
        
        JPanel pan_1 = new JPanel();
        pan_1.setLayout(new GridBagLayout());
        GridBagConstraints gbcLayout = new GridBagConstraints();
        
        gbcLayout.weightx =0;
        gbcLayout.weighty = 2;
        //initialisation du positionnement à 0 en x et y
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 0;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(new JLabel("    "), gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(checkOnModif, gbcLayout); // je l'ajoute à cette position de départ
        
        //initialisation du positionnement à 0 en x et y
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 1;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(labNumChambre, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(spinNumChambree, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 2;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(labCodeServ, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(comboCodeServ, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 3;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(btnCleSurveil, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(fieldCleServic, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 4;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(labNbrLits, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(spinNbrLits, gbcLayout); // je l'ajoute à cette position de départ
        
        JPanel panelTempo = new JPanel(new BorderLayout(50, 30));
        JSeparator separe1 = new JSeparator(JSeparator.HORIZONTAL);
        separe1.setPreferredSize(new Dimension(50, 0));
        panelTempo.add(separe1, BorderLayout.NORTH);
        panelTempo.add(btnRaz, BorderLayout.EAST);
        panelTempo.add(btnUpdate, BorderLayout.WEST);
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 5;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(panelTempo, gbcLayout); // je l'ajoute à cette position de départ
        
        JPanel panelBtn = new JPanel(new BorderLayout(80, 30));
        JSeparator separe2 = new JSeparator(JSeparator.HORIZONTAL);
        separe2.setPreferredSize(new Dimension(50, 0));
        panelBtn.add(btnSupression, BorderLayout.CENTER);
        panelBtn.add(btnModifier, BorderLayout.WEST);
        panelBtn.add(btnReporting, BorderLayout.EAST);
        
        JPanel panelGeneral = new JPanel(new BorderLayout(30, 30));
        panelGeneral.add(panelHaut, BorderLayout.NORTH);
        panelGeneral.add(pan_1, BorderLayout.EAST);
        panelGeneral.add(panelTable, BorderLayout.CENTER);
        panelGeneral.add(panelBtn, BorderLayout.SOUTH);
        setContentPane(panelGeneral);
        setTitle("RUD chambre");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnAide() {
        return btnAide;
    }

    public JButton getBtnRecherche() {
        return btnRecherche;
    }

    public JButton getBtnModifier() {
        return btnModifier;
    }

    public JButton getBtnRaz() {
        return btnRaz;
    }

    public JButton getBtnSupression() {
        return btnSupression;
    }

    public JButton getBtnReporting() {
        return btnReporting;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnCleSurveil() {
        return btnCleSurveil;
    }

    public JTable getTableDonnees() {
        return tableDonnees;
    }

    public JLabel getLabNumChambre() {
        return labNumChambre;
    }

    public JLabel getLabNbrLits() {
        return labNbrLits;
    }

    public JTextField getFieldCleServic() {
        return fieldCleServic;
    }

    public JSpinner getSpinNumChambree() {
        return spinNumChambree;
    }

    public JSpinner getSpinNbrLits() {
        return spinNbrLits;
    }

    public JCheckBox getCheckOnModif() {
        return checkOnModif;
    }

    public JComboBox getComboCodeServ() {
        return comboCodeServ;
    }
    
}
