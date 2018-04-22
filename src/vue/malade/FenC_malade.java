
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
     
    private final JTextField fieldAge = new JTextField(); //creation champ age
    private final JSpinner spinTaille = new JSpinner(new SpinnerNumberModel(0, 0, 9.99, 0.01)); //creation champ taille
    private final JSpinner spinPoids = new JSpinner(new SpinnerNumberModel(0, 0, 999.99, 0.01)); //creation champ poids
    private final JButton btnBack = new JButton("Retour"); //creation bouton retour
    private final JButton btnAide = new JButton("Aide"); ; //creation bouton aide
    private final JButton btnValider = new JButton("Valider");; //creation bouton valider
    private final JButton btnAnnuler = new JButton("Annuler"); //creation bouton annuler
    private final JTextField fieldNom = new JTextField(); //creation zone de texte 
    private final JTextField fieldPrenom = new JTextField(); //creation zone de texte 
    private final JTextField fieldAddresse = new JTextField(); //creation zone de texte 
    private final JTextField fieldTel = new JTextField(); //creation zone de texte 
    private final JComboBox comboMutuelle = new JComboBox(); //creation zone de texte 
    private final JComboBox comboSexe = new JComboBox(); //creation zone de texte 
    
    /**
     * constructeur de la classe
     */
    public FenC_malade(){
        
        setIconImage(getToolkit().getImage("img/exec3.png"));
        JPanel panelGeneral = new JPanel(new BorderLayout(30,30)); //creation du panel general
        JPanel panelHaut = new JPanel(new BorderLayout()); //creation du panel haut
        JPanel panelCentre = new JPanel (new GridBagLayout()); //creation du panel centre
        GridBagConstraints gbc = new GridBagConstraints(); //creation du constructeur permettant de placer les elements dans la grille de la fenetre
        JPanel panelBas = new JPanel(new BorderLayout()); //creation du panel bas
        
        fieldNom.setColumns(12);
        fieldPrenom.setColumns(12);
        fieldAddresse.setColumns(12);
        fieldTel.setColumns(12);  
        fieldAge.setColumns(12);
        //panel haut
        
        panelHaut.add(btnBack,BorderLayout.WEST); //ajout bouton retour au panel du haut
        panelHaut.add(btnAide,BorderLayout.EAST); //ajout bouton aide au panel du haut          
        
        
        //panel centre
        gbc.weightx =0;
        gbc.weighty = 2;
        /*//label et spinner numero malade
        gbc.gridx=0; //initialisation du positionnement en x
        gbc.gridy=0; //initialisation du positionnement en y
        gbc.gridwidth=1; //initialisation de la largeur 
        gbc.gridheight=1; //initialisation de la hauteur 
        panelCentre.add(new JLabel("Numéro du malade : "),gbc); //
        gbc.gridx=1; //prochain positionnement x = x précédent + width
        gbc.gridwidth=GridBagConstraints.REMAINDER; //
        panelCentre.add(fieldTel,gbc);*/
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
        panelCentre.add(new JLabel("Prénom malade: "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(fieldPrenom,gbc);

        //label et field addresse malade
        gbc.gridx=0; 
        gbc.gridy=3; 
        gbc.gridwidth=1;  
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Adresse du malade: "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(fieldAddresse,gbc);

        //label et field mutuelle du malade
        gbc.gridx=0; 
        gbc.gridy=4; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Mutuelle du malade: "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(comboMutuelle,gbc);
        
        //label et field age du malade
        gbc.gridx=0; 
        gbc.gridy=5; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Age: "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(fieldAge,gbc);

        //label et field sexe du malade
        gbc.gridx=0; 
        gbc.gridy=6; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Sexe: "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(comboSexe,gbc);

        //label et field taille du malade
        gbc.gridx=0; 
        gbc.gridy=7; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Taille: "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(spinTaille,gbc);

        //label et field poids du malade
        gbc.gridx=0; 
        gbc.gridy=8; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Poids: "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(spinPoids,gbc);

        gbc.gridx=0; 
        gbc.gridy=9; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Numero de tel: "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(fieldTel,gbc);
        
        panelGeneral.add(panelHaut, BorderLayout.NORTH); //ajout du panel centre au panel general
        panelGeneral.add(panelCentre, BorderLayout.CENTER);
        //panel bas
        panelBas.add(btnValider,BorderLayout.WEST); //ajout bouton Valider au panel du bas
        panelBas.add(btnAnnuler,BorderLayout.EAST); //ajout bouton Annuler au panel du bas
        panelGeneral.add(panelBas, BorderLayout.SOUTH); //ajout du panel bas au panel general
        
        //methodes
        setContentPane(panelGeneral); //methode affichant l'ensemble du contenu affecte au panel general 
        setTitle("Creation malade"); //titre panel general 
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fermeture juste de la fenetre en question 
        
    }

    public JTextField getFieldTel() {
        return fieldTel;
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

    public JTextField getFieldAge() {
        return fieldAge;
    }

}
