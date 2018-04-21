
package vue.malade;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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


public class FenRUD_malade extends JFrame{

    private final JButton btnBack = new JButton("Retour");
    private final JButton btnAide = new JButton("Aide");
    private final JButton btnRecherche = new JButton("Rechercher une information");
    private final JButton btnModifier = new JButton("Modifier");
    private final JButton btnRaz = new JButton("Vider les champs");
    private final JButton btnSupression = new JButton("Supprimer");
    private final JButton btnReporting = new JButton("Prise de décision");
    private final JButton btnUpdate = new JButton("Appliquer les modifications");
    
    private final JLabel labNom = new JLabel("Nom: ");
    private final JLabel labPrenom = new JLabel("Prénom: ");
    private final JLabel labTel = new JLabel("Téléphone: ");
    private final JLabel labAdress = new JLabel("Adresse: ");
    private final JLabel labMutuelle = new JLabel("La mutuelle: ");
    
    private final JTextField fieldNom = new JTextField();
    private final JTextField fieldPrenom = new JTextField();
    private final JTextField fieldTel = new JTextField();
    private final JTextField fieldAdresse = new JTextField();
    private final JTextField fieldAge = new JTextField(); //creation champ age
    
    private final JSpinner spinTaille = new JSpinner(new SpinnerNumberModel(0, 0, 9.99, 0.01)); //creation champ taille
    private final JSpinner spinPoids = new JSpinner(new SpinnerNumberModel(0, 0, 999.99, 0.01)); //creation champ poids
    
    private final JComboBox comboMutuelle = new JComboBox();
    private final JComboBox comboSexe = new JComboBox();
    
    private final JCheckBox checkOnModif = new JCheckBox("Autoriser la modification des données");
    
    private final JTable tableDonnees = new JTable(17, 5);
    
    public FenRUD_malade() {
        
        fieldNom.setEnabled(false);
        fieldPrenom.setEnabled(false);
        fieldTel.setEnabled(false);
        fieldAdresse.setEnabled(false);
        comboMutuelle.setEnabled(false);
        btnRaz.setEnabled(false);
        btnModifier.setEnabled(false);
        btnUpdate.setEnabled(false);
        
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
        
        JPanel pan_0 = new JPanel(new BorderLayout());
        pan_0.add(checkOnModif, BorderLayout.CENTER);
        //initialisation du positionnement à 0 en x et y
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 0;
        gbcLayout.fill = GridBagConstraints.VERTICAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(checkOnModif, gbcLayout); // je l'ajoute à cette position de départ
        
        //initialisation du positionnement à 0 en x et y
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 1;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(labNom, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(fieldNom, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 2;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(labPrenom, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(fieldPrenom, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 3;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(labTel, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(fieldTel, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 4;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(labAdress, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(fieldAdresse, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 5;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(new JLabel("Age:"), gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(fieldAge, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 6;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(new JLabel("Sexe:"), gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(comboSexe, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 7;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(new JLabel("Poids:"), gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(spinPoids, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 8;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(new JLabel("Taille:"), gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(fieldAdresse, gbcLayout); // je l'ajoute à cette position de départ
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 9;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        pan_1.add(labMutuelle, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        pan_1.add(comboMutuelle, gbcLayout); // je l'ajoute à cette position de départ
        
        JPanel panelTempo = new JPanel(new BorderLayout(50, 30));
        JSeparator separe1 = new JSeparator(JSeparator.HORIZONTAL);
        separe1.setPreferredSize(new Dimension(50, 0));
        panelTempo.add(separe1, BorderLayout.NORTH);
        panelTempo.add(btnRaz, BorderLayout.EAST);
        panelTempo.add(btnUpdate, BorderLayout.WEST);
        
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 10;
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
        setTitle("RUD Malade");
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

    public JComboBox getComboMutuelle() {
        return comboMutuelle;
    }

    public JCheckBox getCheckOnModif() {
        return checkOnModif;
    }

    public JTable getTableDonnees() {
        return tableDonnees;
    }

    public JTextField getFieldAge() {
        return fieldAge;
    }

    public JSpinner getSpinTaille() {
        return spinTaille;
    }

    public JSpinner getSpinPoids() {
        return spinPoids;
    }

    public JComboBox getComboSexe() {
        return comboSexe;
    }
    
    
}
