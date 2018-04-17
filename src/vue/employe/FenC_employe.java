
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
    
    private final JTextField nom = new JTextField();
    private final JTextField prenom = new JTextField();
    private final JTextField adresse = new JTextField(); //Creation des champs de saisie pour l'utilisateur
    private final JTextField specialite = new JTextField(); //Champs de saisie propre aux docteurs  
 
    private final JLabel labSpecialite = new JLabel("Specialite: ");
    private final JLabel labRotation = new JLabel("Rotation: ");
    private final JLabel labSalaire = new JLabel("Salaire: "); //Label ajouter en fonction de si docteur ou infirmier choisis   
    
    private final JComboBox rotation = new JComboBox(); 
    private final JComboBox choixEmploye = new JComboBox();
    
    private final JSpinner salaire = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 0.1));
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
        
        
        choixEmploye.addItem("Employe");
        choixEmploye.addItem("Docteur");
        choixEmploye.addItem("Infirmier"); //Création du combobox et ajout des items
        
        rotation.addItem("Jour");
        rotation.addItem("Nuit"); //Initialisation du combobox poour rotation
   
        
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
        panelCentre.add(choixEmploye, gbc); // Ligne 1 du pannel central
        
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(new JLabel("Nom: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        nom.setPreferredSize(new Dimension(100,30));
        panelCentre.add(nom, gbc); //Ligne 2 du pannel centrale
        
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(new JLabel("Prenom: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        prenom.setPreferredSize(new Dimension(100,30));
        panelCentre.add(prenom, gbc); //Ligne 3 du pannel centrale
        
        
        
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
        adresse.setPreferredSize(new Dimension(100,30));
        panelCentre.add(adresse, gbc); //Ligne 5 du pannel centrale
        
        gbc.gridx=0;
        gbc.gridy=8;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(labSpecialite, gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        specialite.setPreferredSize(new Dimension(100,30));
        panelCentre.add(specialite, gbc); //Ligne 6 du pannel centrale (si docteur choisis)
        labSpecialite.setVisible(false);
        specialite.setVisible(false); //Pas affiché car employé par defaut
        
        gbc.gridx=0;
        gbc.gridy=6;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(labRotation, gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(rotation, gbc); //Ligne  du pannel 7 centrale 
        labRotation.setVisible(false);
        rotation.setVisible(false); //Pas affiché car employé par defaut        
        
        gbc.gridx=0;
        gbc.gridy=7;
        gbc.gridwidth=1;
        gbc.gridheight=1; 
        panelCentre.add(labSalaire, gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(salaire, gbc); //Ligne 8 du pannel centrale (si docteur choisis)
        labSalaire.setVisible(false);
        salaire.setVisible(false); //Pas affiché car employé par defaut        
        
        panelGeneral.add(panelCentre, BorderLayout.CENTER); //ajout du panel central au panel general
        
        
         
        setContentPane(panelGeneral);
        setTitle("Creation employe");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                         
    }
        
    
   // Getter des textfield
    
    public JTextField getnom(){
        return nom;
    }
    
    public JTextField getprenom(){
        return prenom;
    }
    
    public JTextField getadresse(){
        return adresse;
    }
    
    public JTextField getspecialite(){
        return specialite;
    }
    
    
     //getter des JSpinner
    
    public JSpinner getsalaire(){
        return salaire;
    }
    
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
    
   
    //getter des Jcombobox
    
    public JComboBox getchoixEmploye(){
        return choixEmploye;
    }
    
    public JComboBox getrotation(){
        return rotation;
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
    
    
    //Getter des Jlabel
    
    public JLabel getlabSpecialite(){
        return labSpecialite;
    }
    
    public JLabel getlabRotation(){
        return labRotation;
    }
    
    public JLabel getlabSalaire(){
        return labSalaire;
    }
    
    
  }    
 
