
package vue.employe;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class FenC_employe extends JFrame {
    
    private final JButton btnBack = new JButton("Retour");
    private final JButton btnAide = new JButton("Aide");
    private final JButton btnAnnuler = new JButton("Annuler");
    private final JButton btnValider = new JButton("Valider"); //Création des Bouttons
    
    private final JTextField fieldNom = new JTextField();
    private final JTextField fieldPrenom = new JTextField();
    private final JTextField fieldAdresse = new JTextField(); //Creation des champs de saisie pour l'utilisateur
    private final JTextField fieldSpecia = new JTextField(); //Champs de saisie propre aux docteurs  
 
    private final JLabel labSpecialite = new JLabel("Specialite: ");
    private final JLabel labRotation = new JLabel("Rotation: ");
    private final JLabel labSalaire = new JLabel("Salaire: "); //Label ajouter en fonction de si docteur ou infirmier choisis   
    
    private final JComboBox comboRotation = new JComboBox(); 
    private final JComboBox comboTypeEmploye = new JComboBox();
    
    private final JSpinner spinSalaire = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 0.1));
    private final JSpinner no1 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
    private final JSpinner no2 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
    private final JSpinner no3 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
    private final JSpinner no4 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
    private final JSpinner no5 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
   
    /**
     * constructeur de la classe
     */
    public FenC_employe(){
        JPanel panelGeneral = new JPanel(new BorderLayout());
        JPanel panelHaut = new JPanel(new BorderLayout());
        JPanel panelCentre = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel panelTel = new JPanel(new GridLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        JPanel panelBas = new JPanel(new BorderLayout()); //Création des pannels
        
        
        comboTypeEmploye.addItem("Employe");
        comboTypeEmploye.addItem("Docteur");
        comboTypeEmploye.addItem("Infirmier"); //Création du combobox et ajout des items
        
        comboRotation.addItem("Jour");
        comboRotation.addItem("Nuit"); //Initialisation du combobox poour rotation
   
        
        panelHaut.add(btnBack, BorderLayout.WEST);
        panelHaut.add(btnAide, BorderLayout.EAST); //mise en forme du pannel du haut
        
        panelGeneral.add(panelHaut, BorderLayout.NORTH); //ajout du pannel au pannel général
        
        panelBas.add(btnAnnuler, BorderLayout.EAST);
        panelBas.add(btnValider, BorderLayout.CENTER); //mise en forme du pannel du bas
        
        panelGeneral.add(panelBas, BorderLayout.SOUTH); //ajout du pannnel au pannel général
        
        
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;       
        panelCentre.add(new JLabel("Proffession "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(comboTypeEmploye, gbc); // Ligne 1 du pannel central
        
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(new JLabel("Nom: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        fieldNom.setPreferredSize(new Dimension(100,30));
        panelCentre.add(fieldNom, gbc); //Ligne 2 du pannel centrale
        
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(new JLabel("Prenom: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        fieldPrenom.setPreferredSize(new Dimension(100,30));
        panelCentre.add(fieldPrenom, gbc); //Ligne 3 du pannel centrale
        
        
        
        gbc2.gridx=0; 
        gbc2.gridwidth=1; 
        gbc2.gridheight=1;  
        panelTel.add(no1,gbc2);
        
        gbc2.gridx=1; 
        gbc2.gridwidth=1; 
        gbc2.gridheight=1;  
        panelTel.add(no2,gbc2);
       
        gbc2.gridx=2; 
        gbc2.gridwidth=1; 
        gbc2.gridheight=1;  
        panelTel.add(no3,gbc2);
         
        gbc2.gridx=3; 
        gbc2.gridwidth=1; 
        gbc2.gridheight=1;  
        panelTel.add(no4,gbc2);
        
        gbc2.gridx=4; 
        gbc2.gridwidth=1; 
        gbc2.gridheight=1;  
        panelTel.add(no5,gbc2);
                
        gbc2.gridx=0; 
        gbc2.gridy=5; 
        gbc2.gridwidth=1; 
        gbc2.gridheight=1; 
        panelCentre.add(new JLabel("Telephone: "),gbc2); 
        gbc2.gridx=1; 
        gbc2.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(panelTel,gbc2);              //Ligne 4 panel centrale
        
       
        
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(new JLabel("Adresse: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        fieldAdresse.setPreferredSize(new Dimension(100,30));
        panelCentre.add(fieldAdresse, gbc); //Ligne 5 du pannel centrale
        
        gbc.gridx=0;
        gbc.gridy=8;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(labSpecialite, gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        fieldSpecia.setPreferredSize(new Dimension(100,30));
        panelCentre.add(fieldSpecia, gbc); //Ligne 6 du pannel centrale (si docteur choisis)
        labSpecialite.setVisible(false);
        fieldSpecia.setVisible(false); //Pas affiché car employé par defaut
        
        gbc.gridx=0;
        gbc.gridy=6;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(labRotation, gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(comboRotation, gbc); //Ligne  du pannel 7 centrale 
        labRotation.setVisible(false);
        comboRotation.setVisible(false); //Pas affiché car employé par defaut        
        
        gbc.gridx=0;
        gbc.gridy=7;
        gbc.gridwidth=1;
        gbc.gridheight=1; 
        panelCentre.add(labSalaire, gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(spinSalaire, gbc); //Ligne 8 du pannel centrale (si docteur choisis)
        labSalaire.setVisible(false);
        spinSalaire.setVisible(false); //Pas affiché car employé par defaut        
        
        panelGeneral.add(panelCentre, BorderLayout.CENTER); //ajout du panel central au panel general
        
        
         
        setContentPane(panelGeneral);
        setTitle("Creation employe");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                         
    }
        
    
     //getter des JSpinner

    public JSpinner getno1(){
        return no1;
    }
    
    public JSpinner getno2(){
        return no2;
    }

    public JSpinner getno3(){
        return no3;
    }

    public JSpinner getno4(){
        return no4;
    }    
    
    public JSpinner getno5(){
        return no5;
    }
    
    //getter des JButton
    
    public JButton getbtnAide(){
        return btnAide;
    }
    
    public JButton getbtnAnnuler(){
        return btnAnnuler;
    }
    
    public JButton getbtnValider(){
        return btnValider;
    }

    public JLabel getlabSpecialite(){
        return labSpecialite;
    }
    
    public JLabel getlabRotation(){
        return labRotation;
    }
    
    public JLabel getlabSalaire(){
        return labSalaire;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnAide() {
        return btnAide;
    }

    public JButton getBtnAnnuler() {
        return btnAnnuler;
    }

    public JButton getBtnValider() {
        return btnValider;
    }

    public JLabel getLabSpecialite() {
        return labSpecialite;
    }

    public JLabel getLabRotation() {
        return labRotation;
    }

    public JLabel getLabSalaire() {
        return labSalaire;
    }

    public JTextField getFieldNom() {
        return fieldNom;
    }

    public JTextField getFieldPrenom() {
        return fieldPrenom;
    }

    public JTextField getFieldAdresse() {
        return fieldAdresse;
    }

    public JTextField getFieldSpecia() {
        return fieldSpecia;
    }

    public JComboBox getComboRotation() {
        return comboRotation;
    }

    public JComboBox getComboTypeEmploye() {
        return comboTypeEmploye;
    }

    public JSpinner getSpinSalaire() {
        return spinSalaire;
    }
    
    
  }    
 
