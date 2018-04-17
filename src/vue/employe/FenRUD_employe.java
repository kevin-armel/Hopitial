
package vue.employe;

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
import javax.swing.SpinnerNumberModel;



public class FenRUD_employe  extends JFrame{
    
    private final JButton btnBack = new JButton("Retour");
    private final JButton btnAide = new JButton("Aide");
    private final JButton btnRecherche = new JButton("Rechercher une information");
    private final JButton btnRaz = new JButton("Vider les champs");
    private final JButton btnSupression = new JButton("Supprimer");
    private final JButton btnReporting = new JButton("Prise de décision");
    private final JButton btnUpdate = new JButton("Appliquer les modifications");
    
    private final JLabel labNom = new JLabel("Nom: ");
    private final JLabel labPrenom = new JLabel("Prénom: ");
    private final JLabel labTel = new JLabel("Téléphone: ");
    private final JLabel labAdress = new JLabel("Adresse: ");
    private final JLabel labEmail = new JLabel("E-mail: ");
    private final JLabel labDSpecialite = new JLabel("Spécialité: ");
    private final JLabel labIRotaion = new JLabel("Rotation: ");
    private final JLabel labISalair = new JLabel("Salaire: ");
    
    private final JTextField fieldNom = new JTextField();
    private final JTextField fieldPrenom = new JTextField();
    private final JTextField fieldTel = new JTextField();
    private final JTextField fieldAdresse = new JTextField();
    private final JTextField fieldEmail = new JTextField();
    private final JSpinner spinSalaire = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 99999999.99, 0.01));
    
    private final JComboBox comboDSpecialite = new JComboBox();
    private final JComboBox comboIRotation = new JComboBox();
    
    private final JCheckBox checkOnModif = new JCheckBox("Autoriser la modification des données");
    
    private final JTable tableDonnees = new JTable(17, 5);
        
    /**
     * constructeur de la classe
     */
    public FenRUD_employe(){
        
        fieldNom.setPreferredSize(new Dimension(100, 30));
        fieldNom.setEnabled(false);
        fieldPrenom.setPreferredSize(new Dimension(100, 30));
        fieldPrenom.setEnabled(false);
        fieldTel.setPreferredSize(new Dimension(100, 30));
        fieldTel.setEnabled(false);
        fieldAdresse.setPreferredSize(new Dimension(100, 30));
        fieldAdresse.setEnabled(false);
        spinSalaire.setPreferredSize(new Dimension(100, 30));
        spinSalaire.setEnabled(false);
        fieldEmail.setPreferredSize(new Dimension(100, 30));
        fieldEmail.setEnabled(false);
        comboDSpecialite.setPreferredSize(new Dimension(100, 30));
        comboDSpecialite.setEnabled(false);
        comboIRotation.setPreferredSize(new Dimension(100, 30));
        comboIRotation.setEnabled(false);
        
        btnRaz.setEnabled(false);
        btnUpdate.setEnabled(false);
        
        JPanel panelHaut = new JPanel(new BorderLayout(30, 30));
        panelHaut.add(btnBack, BorderLayout.WEST);
        panelHaut.add(btnRecherche, BorderLayout.CENTER);
        panelHaut.add(btnAide, BorderLayout.EAST);
        
        JScrollPane panelTable = new JScrollPane(tableDonnees);
        
        JPanel pan_1 = new JPanel();
        pan_1.setLayout(new GridBagLayout());
        GridBagConstraints gbcLayout = new GridBagConstraints();
        //initialisation du positionnement à 0 en x et y
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 0;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 2;
        gbcLayout.gridheight = 1;
        pan_1.add(labNom, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 2;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(fieldNom, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 1;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 2;
        gbcLayout.gridheight = 1;
        pan_1.add(labPrenom, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 2;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(fieldPrenom, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 2;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 2;
        gbcLayout.gridheight = 1;
        pan_1.add(labAdress, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 2;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(fieldAdresse, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 3;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 2;
        gbcLayout.gridheight = 1;
        pan_1.add(labEmail, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 2;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(fieldEmail, gbcLayout); // je l'ajoute à cette position de départ

        gbcLayout.gridx = 0;
        gbcLayout.gridy = 4;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 2;
        gbcLayout.gridheight = 1;
        pan_1.add(labTel, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 2;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(fieldTel, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 5;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 2;
        gbcLayout.gridheight = 1;
        pan_1.add(labDSpecialite, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 2;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(comboDSpecialite, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 6;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 2;
        gbcLayout.gridheight = 1;
        pan_1.add(labIRotaion, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 2;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(comboIRotation, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 7;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 2;
        gbcLayout.gridheight = 1;
        pan_1.add(labISalair, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 2;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(spinSalaire, gbcLayout); // je l'ajoute à cette position de départ
        
        JPanel panelTempo = new JPanel(new BorderLayout(50, 30));
        JSeparator separe1 = new JSeparator(JSeparator.HORIZONTAL);
        separe1.setPreferredSize(new Dimension(50, 0));
        panelTempo.add(separe1, BorderLayout.NORTH);
        panelTempo.add(btnRaz, BorderLayout.EAST);
        panelTempo.add(btnUpdate, BorderLayout.WEST);
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 8;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(panelTempo, gbcLayout); // je l'ajoute à cette position de départ
        
        JPanel panelBtn = new JPanel(new BorderLayout(80, 30));
        JSeparator separe2 = new JSeparator(JSeparator.HORIZONTAL);
        separe2.setPreferredSize(new Dimension(50, 0));
        panelBtn.add(btnSupression, BorderLayout.CENTER);
        panelBtn.add(checkOnModif, BorderLayout.WEST);
        panelBtn.add(btnReporting, BorderLayout.EAST);
        
        JPanel panelGeneral = new JPanel(new BorderLayout(30, 30));
        panelGeneral.add(panelHaut, BorderLayout.NORTH);
        panelGeneral.add(pan_1, BorderLayout.EAST);
        panelGeneral.add(panelTable, BorderLayout.CENTER);
        panelGeneral.add(panelBtn, BorderLayout.SOUTH);
        setContentPane(panelGeneral);
        setTitle("RUD employe");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public JButton getBtnAide() {
        return btnAide;
    }

    public JButton getBtnRecherche() {
        return btnRecherche;
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

    public JTextField getFieldNom() {
        return fieldNom;
    }

    public JTextField getFieldPrenom() {
        return fieldPrenom;
    }

    public JTextField getFieldTel() {
        return fieldTel;
    }

    public JTextField getFieldAdresse() {
        return fieldAdresse;
    }

    public JTextField getFieldEmail() {
        return fieldEmail;
    }

    public JSpinner getSpinSalaire() {
        return spinSalaire;
    }

    public JComboBox getComboDSpecialite() {
        return comboDSpecialite;
    }

    public JComboBox getComboIRotation() {
        return comboIRotation;
    }

    public JCheckBox getCheckOnModif() {
        return checkOnModif;
    }

    public JTable getTableDonnees() {
        return tableDonnees;
    }
        
}
