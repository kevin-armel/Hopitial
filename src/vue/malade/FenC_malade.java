
package vue.malade;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private final JSpinner age = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1)); //creation champ age
    private final JSpinner tail = new JSpinner(new SpinnerNumberModel(0, 0, 9.99, 0.01)); //creation champ taille
    private final JSpinner poids = new JSpinner(new SpinnerNumberModel(0, 0, 999.99, 0.01)); //creation champ poids
    private final JButton btnBack = new JButton("Retour"); //creation bouton retour
    private final JButton btnAide = new JButton("Aide"); ; //creation bouton aide
    private final JButton btnValider = new JButton("Valider");; //creation bouton valider
    private final JButton btnAnnuler = new JButton("Annuler"); //creation bouton annuler
    private final JTextField nom = new JTextField(); //creation zone de texte 
    private final JTextField pre = new JTextField(); //creation zone de texte 
    private final JTextField add = new JTextField(); //creation zone de texte 
    private final JTextField mut = new JTextField(); //creation zone de texte 
    private final JTextField sex = new JTextField(); //creation zone de texte 
    
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
        panelCentre.add(nom,gbc);
        nom.setPreferredSize(new Dimension(100,20));
        //label et field prénom malade
        gbc.gridx=0; 
        gbc.gridy=2; 
        gbc.gridwidth=1;  
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Prénom malade : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(pre,gbc);
        pre.setPreferredSize(new Dimension(100,20));
        //label et field addresse malade
        gbc.gridx=0; 
        gbc.gridy=3; 
        gbc.gridwidth=1;  
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Adresse du malade : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(add,gbc);
        add.setPreferredSize(new Dimension(100,20));
        //label et field mutuelle du malade
        gbc.gridx=0; 
        gbc.gridy=4; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Mutuelle du malade : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(mut,gbc);
        mut.setPreferredSize(new Dimension(100,20));
        //label et field age du malade
        gbc.gridx=0; 
        gbc.gridy=5; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Age : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(age,gbc);
        age.setPreferredSize(new Dimension(100,20));
        //label et field sexe du malade
        gbc.gridx=0; 
        gbc.gridy=6; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Sexe : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(sex,gbc);
        sex.setPreferredSize(new Dimension(100,20));
        //label et field taille du malade
        gbc.gridx=0; 
        gbc.gridy=7; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Taille : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(tail,gbc);
        tail.setPreferredSize(new Dimension(100,20));
        //label et field poids du malade
        gbc.gridx=0; 
        gbc.gridy=8; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Poids : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(poids,gbc);
        poids.setPreferredSize(new Dimension(100,20));
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
    
    //getteurs des zones textes
    public JTextField getnom(){ 
        return nom;
    }
    public JTextField getpre(){
        return pre;
    }
    public JTextField getadd(){
        return add;
    }
    public JTextField getmut(){
        return mut;
        
    }
    public JTextField getsex(){
        return sex;
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
    }public JSpinner gettail(){
        return tail;
    }
    public JSpinner getpoids(){
        return poids;
    }
    public JSpinner getage(){
        return age;
    }
    
    
    //getteurs des boutons 
    public JButton getbtnAide(){
        return btnAide;
    }
    public JButton getbtnAnnuler(){
        return btnAnnuler;
    }
    public JButton getbtnValider(){
        return btnValider;
    }
}
