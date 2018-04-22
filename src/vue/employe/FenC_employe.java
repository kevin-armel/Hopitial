
package vue.employe;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    private final JTextField fieldTel = new JTextField();
    private final JTextField fieldAdresse = new JTextField(); //Creation des champs de saisie pour l'utilisateur  
    private final JTextField fieldEmail = new JTextField();
    
    private final JLabel labCodeServ = new JLabel("Code du service: ");
    private final JLabel labSpecialite = new JLabel("Specialite: ");
    private final JLabel labRotation = new JLabel("Rotation: ");
    private final JLabel labSalaire = new JLabel("Salaire: "); //Label ajouter en fonction de si docteur ou infirmier choisis   
    
    private final JComboBox comboRotation = new JComboBox(); 
    private final JComboBox comboTypeEmploye = new JComboBox();
    private final JComboBox comboCodeServ = new JComboBox(); 
    private final JComboBox comboSexe = new JComboBox(); 
    private final JComboBox combodSpecia = new JComboBox(); //Champs de saisie propre aux docteurs  
    
    private final JSpinner spinSalaire = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 0.1));

   
    /**
     * constructeur de la classe
     */
    public FenC_employe(){
        
        setIconImage(getToolkit().getImage("img/exec3.png"));
        JPanel panelGeneral = new JPanel(new BorderLayout());
        JPanel panelHaut = new JPanel(new BorderLayout());
        JPanel panelCentre = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbc2 = new GridBagConstraints();
        JPanel panelBas = new JPanel(new BorderLayout()); //Création des pannels
        fieldNom.setPreferredSize(new Dimension(150, 30));
        fieldPrenom.setPreferredSize(new Dimension(150, 30));
        fieldTel.setPreferredSize(new Dimension(150, 30));
        fieldAdresse.setPreferredSize(new Dimension(150, 30));
        fieldEmail.setPreferredSize(new Dimension(150, 30));
        comboTypeEmploye.setPreferredSize(new Dimension(150, 30));
        comboRotation.setPreferredSize(new Dimension(150, 30));
        comboSexe.setPreferredSize(new Dimension(150, 30));
        combodSpecia.setPreferredSize(new Dimension(150, 30));
        comboCodeServ.setPreferredSize(new Dimension(150, 30));
        spinSalaire.setPreferredSize(new Dimension(150, 30));
        
        comboTypeEmploye.addItem("");
        comboTypeEmploye.addItem("Docteur");
        comboTypeEmploye.addItem("Infirmier"); //Création du combobox et ajout des items
        
        panelHaut.add(btnBack, BorderLayout.WEST);
        panelHaut.add(btnAide, BorderLayout.EAST); //mise en forme du pannel du haut
        
        panelGeneral.add(panelHaut, BorderLayout.NORTH); //ajout du pannel au pannel général
        
        panelBas.add(btnAnnuler, BorderLayout.EAST);
        panelBas.add(btnValider, BorderLayout.WEST); //mise en forme du pannel du bas
        
        panelGeneral.add(panelBas, BorderLayout.SOUTH); //ajout du pannnel au pannel général
        
        gbc.weightx =0;
        gbc.weighty = 2;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;       
        panelCentre.add(new JLabel("Profession "), gbc);
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
        panelCentre.add(fieldNom, gbc); //Ligne 2 du pannel centrale
        
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(new JLabel("Prenom: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(fieldPrenom, gbc); //Ligne 3 du pannel centrale
                
        gbc2.gridx=0; 
        gbc2.gridy=3; 
        gbc2.gridwidth=1; 
        gbc2.gridheight=1; 
        panelCentre.add(new JLabel("Telephone: "),gbc2); 
        gbc2.gridx=1; 
        gbc2.gridwidth=GridBagConstraints.REMAINDER;
        gbc2.gridheight=1;
        panelCentre.add(fieldTel,gbc2);              //Ligne 4 panel centrale
        
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(new JLabel("Adresse: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.gridheight=1;
        panelCentre.add(fieldAdresse, gbc); //Ligne 5 du pannel centrale
        
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(new JLabel("Sexe: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.gridheight=1;
        panelCentre.add(comboSexe, gbc); //Ligne 5 du pannel centrale
        
        gbc.gridx=0;
        gbc.gridy=6;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(new JLabel("E-mail: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.gridheight=1;
        panelCentre.add(fieldEmail, gbc); //Ligne 5 du pannel centrale
        
        gbc.gridx=0;
        gbc.gridy=7;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(labSpecialite, gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.gridheight=1;
        panelCentre.add(combodSpecia, gbc); //Ligne 6 du pannel centrale (si docteur choisis)
        
        gbc.gridx=0;
        gbc.gridy=8;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(labRotation, gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.gridheight=1;
        panelCentre.add(comboRotation, gbc); //Ligne  du pannel 7 centrale 
        
        gbc.gridx=0;
        gbc.gridy=9;
        gbc.gridwidth=1;
        gbc.gridheight=1; 
        panelCentre.add(labSalaire, gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.gridheight=1;
        panelCentre.add(spinSalaire, gbc); //Ligne 8 du pannel centrale (si docteur choisis)
              
        gbc.gridx=0;
        gbc.gridy=10;
        gbc.gridwidth=1;
        gbc.gridheight=1; 
        panelCentre.add(labCodeServ, gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.gridheight=1; 
        panelCentre.add(comboCodeServ, gbc); //Ligne 8 du pannel centrale (si docteur choisis)
        
        panelGeneral.add(panelCentre, BorderLayout.CENTER); //ajout du panel central au panel general

        setContentPane(panelGeneral);
        setTitle("Creation employe");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                         
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

    public JComboBox getCombodSpecia() {
        return combodSpecia;
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

    public JTextField getFieldTel() {
        return fieldTel;
    }

    public JTextField getFieldEmail() {
        return fieldEmail;
    }

    public JLabel getLabCodeServ() {
        return labCodeServ;
    }

    public JComboBox getComboCodeServ() {
        return comboCodeServ;
    }

    public JComboBox getComboSexe() {
        return comboSexe;
    }
    
    
  }    
 
