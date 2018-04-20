
package vue.malade;

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


public class FenC_malade extends JFrame{

    //variables
    private final JSpinner num = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1)); //creation champ numero 
    private final JSpinner no00 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1)); //creation champ numero telephone 
    private final JSpinner no11 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1)); //creation champ numero telephone 
    private final JSpinner no22 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1)); //creation champ numero telephone 
    private final JSpinner no33 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1)); //creation champ numero telephone 
    private final JSpinner no44 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1)); //creation champ numero telephone 
    private final JSpinner spinAge = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1)); //creation champ age
    private final JSpinner spinTaille = new JSpinner(new SpinnerNumberModel(0, 0, 9.99, 0.01)); //creation champ taille
    private final JSpinner spinPoids = new JSpinner(new SpinnerNumberModel(0, 0, 999.99, 0.01)); //creation champ poids
    private final JButton btnBack = new JButton("Retour"); //creation bouton retour
    private final JButton btnAide = new JButton("Aide"); ; //creation bouton aide
    private final JButton btnValider = new JButton("Valider");; //creation bouton valider
    private final JButton btnAnnuler = new JButton("Annuler"); //creation bouton annuler
    private final JTextField fieldNom = new JTextField(); //creation zone de texte 
    private final JTextField fieldPrenom = new JTextField(); //creation zone de texte 
    private final JTextField fieldAddresse = new JTextField(); //creation zone de texte 
    private final JComboBox comboMutuelle = new JComboBox(); //creation zone de texte 
    private final JComboBox comboSexe = new JComboBox(); //creation zone de texte 
    
    /**
     * constructeur de la classe
     */
    public FenC_malade(){
        JPanel panelGeneral = new JPanel(new BorderLayout()); //creation du panel general
        JPanel panelHaut = new JPanel(new BorderLayout()); //creation du panel haut
        JPanel panelCentre = new JPanel (new GridBagLayout()); //creation du panel centre
        GridBagConstraints gbc = new GridBagConstraints(); //creation du constructeur permettant de placer les elements dans la grille de la fenetre
        JPanel panelBas = new JPanel(new BorderLayout()); //creation du panel bas
        JPanel panelTel =new JPanel(new GridBagLayout()); //creation du panel pour recuperer les spinners du numero de tel
                
                
        //panel haut
        panelGeneral.add(btnBack);
        panelHaut.add(btnBack,BorderLayout.WEST); //ajout bouton retour au panel du haut
        panelHaut.add(btnAide,BorderLayout.EAST); //ajout bouton aide au panel du haut          
        panelGeneral.add(panelHaut, BorderLayout.NORTH); //ajout du panel haut au panel general
        
        
        //panel centre
        //label et spinner numero malade
        gbc.gridx=0; //initialisation du positionnement en x
        gbc.gridy=0; //initialisation du positionnement en y
        gbc.gridwidth=1; //initialisation de la largeur 
        gbc.gridheight=1; //initialisation de la hauteur 
        panelCentre.add(new JLabel("Numéro du malade : "),gbc); //
        gbc.gridx=1; //prochain positionnement x = x précédent + width
        gbc.gridwidth=GridBagConstraints.REMAINDER; //
        panelCentre.add(num,gbc);
        //label et field nom malade
        gbc.gridx=0; 
        gbc.gridy=1; 
        gbc.gridwidth=1;  
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Nom malade : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(fieldNom,gbc);
        fieldNom.setPreferredSize(new Dimension(100,20));
        //label et field prénom malade
        gbc.gridx=0; 
        gbc.gridy=2; 
        gbc.gridwidth=1;  
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Prénom malade : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(fieldPrenom,gbc);
        fieldPrenom.setPreferredSize(new Dimension(100,20));
        //label et field addresse malade
        gbc.gridx=0; 
        gbc.gridy=3; 
        gbc.gridwidth=1;  
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Adresse du malade : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(fieldAddresse,gbc);
        fieldAddresse.setPreferredSize(new Dimension(100,20));
        //label et field mutuelle du malade
        gbc.gridx=0; 
        gbc.gridy=4; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Mutuelle du malade : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(comboMutuelle,gbc);
        comboMutuelle.setPreferredSize(new Dimension(100,20));
        //label et field age du malade
        gbc.gridx=0; 
        gbc.gridy=5; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Age : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(spinAge,gbc);
        spinAge.setPreferredSize(new Dimension(100,20));
        //label et field sexe du malade
        gbc.gridx=0; 
        gbc.gridy=6; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Sexe : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(comboSexe,gbc);
        comboSexe.setPreferredSize(new Dimension(100,20));
        //label et field taille du malade
        gbc.gridx=0; 
        gbc.gridy=7; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Taille : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(spinTaille,gbc);
        spinTaille.setPreferredSize(new Dimension(100,20));
        //label et field poids du malade
        gbc.gridx=0; 
        gbc.gridy=8; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Poids : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(spinPoids,gbc);
        spinPoids.setPreferredSize(new Dimension(100,20));
        //label et spinner numero de tel 
        gbc.gridx=0; 
        gbc.gridwidth=1; 
        gbc.gridheight=1;  
        panelTel.add(no00,gbc);
        
        gbc.gridx=1; 
        gbc.gridwidth=1; 
        gbc.gridheight=1;  
        panelTel.add(no11,gbc);
       
        gbc.gridx=2; 
        gbc.gridwidth=1; 
        gbc.gridheight=1;  
        panelTel.add(no22,gbc);
         
        gbc.gridx=3; 
        gbc.gridwidth=1; 
        gbc.gridheight=1;  
        panelTel.add(no33,gbc);
        
        gbc.gridx=4; 
        gbc.gridwidth=1; 
        gbc.gridheight=1;  
        panelTel.add(no44,gbc);
        
        gbc.gridx=0; 
        gbc.gridy=9; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Numero de tel: "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(panelTel,gbc);
        
        panelGeneral.add(panelCentre, BorderLayout.CENTER); //ajout du panel centre au panel general
        
        
        //panel bas
        panelBas.add(btnValider,BorderLayout.CENTER); //ajout bouton Valider au panel du bas
        panelBas.add(btnAnnuler,BorderLayout.EAST); //ajout bouton Annuler au panel du bas
        panelGeneral.add(panelBas, BorderLayout.SOUTH); //ajout du panel bas au panel general
        
        
        //methodes
        setContentPane(panelGeneral); //methode affichant l'ensemble du contenu affecte au panel general 
        setTitle("Creation malade"); //titre panel general 
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fermeture juste de la fenetre en question 
        
    }
    
    //getteurs des zones valeurs
    public JSpinner getnum(){ 
        return num;
    }
    public JSpinner getno00(){
        return no00;
    }
    public JSpinner getno11(){
        return no11;
    }
    public JSpinner getno22(){
        return no22;
    }
    public JSpinner getno33(){
        return no33;
    }
    public JSpinner getno44(){
        return no44;
    }

    public JSpinner getSpinAge() {
        return spinAge;
    }

    public JSpinner getSpinTaille() {
        return spinTaille;
    }

    public JSpinner getSpinPoids() {
        return spinPoids;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnAide() {
        return btnAide;
    }

    public JButton getBtnValider() {
        return btnValider;
    }

    public JButton getBtnAnnuler() {
        return btnAnnuler;
    }

    public JTextField getFieldNom() {
        return fieldNom;
    }

    public JTextField getFieldPrenom() {
        return fieldPrenom;
    }

    public JTextField getFieldAddresse() {
        return fieldAddresse;
    }

    public JComboBox getComboMutuelle() {
        return comboMutuelle;
    }

    public JComboBox getComboSexe() {
        return comboSexe;
    }

}
