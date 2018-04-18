
package vue.chambre;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class FenC_chambre extends JFrame {
    
    //variables
    private final JSpinner noCh = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
    private final JSpinner noLit = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
    
    private final JButton btnBack = new JButton("Retour"); //creation bouton retour
    private final JButton btnAide = new JButton("Aide"); //creation bouton aide
    private final JButton btnValider = new JButton("Valider"); //creation bouton valider
    private final JButton btnAnnuler = new JButton("Annuler"); //creation bouton annuler
    private final JButton btnAffectInf = new JButton("Affecter l'infirmier"); //creation bouton annuler
    private final JButton btnAffectServ = new JButton("Annuler"); //creation bouton annuler
    
    private final JLabel labCleInfirm = new JLabel("Affectation infirmier");
    
    /**
     * constructeur de la classe
     */
    public FenC_chambre(){
        
        JPanel panelGeneral = new JPanel(new BorderLayout()); //creation du panel general
        JPanel panelHaut = new JPanel(new BorderLayout()); //creation du panel haut
        JPanel panelCentre = new JPanel (new GridBagLayout()); //creation du panel centre
        GridBagConstraints gbc = new GridBagConstraints(); //creation du constructeur permettant de placer les elements dans la grille de la fenetre
        JPanel panelBas = new JPanel(new BorderLayout()); //creation du panel bas BL
        
        //panel haut
        panelGeneral.add(btnBack);
        panelHaut.add(btnBack,BorderLayout.WEST); //ajout bouton retour au panel du haut
        panelHaut.add(btnAide,BorderLayout.EAST); //ajout bouton aide au panel du haut          
        panelGeneral.add(panelHaut, BorderLayout.NORTH); //ajout du panel haut au panel general
        
        
        //panel centre
        //label et spinner numero chambre
        gbc.gridx=0; //initialisation du positionnement en x
        gbc.gridy=0; //initialisation du positionnement en y
        gbc.gridwidth=1; //initialisation de la largeur 
        gbc.gridheight=1; //initialisation de la hauteur 
        panelCentre.add(new JLabel("Numéro de la chambre : "),gbc); 
        gbc.gridx=1; //prochain positionnement x = x précédent + width
        gbc.gridwidth=GridBagConstraints.REMAINDER; //
        panelCentre.add(noCh,gbc);
        //label et spinner nombre de lits present au sein de la chambre
        gbc.gridx=0; 
        gbc.gridy=2; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Nombre de lits : "),gbc); 
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(noLit,gbc);
        
        //label et spinner nombre de lits present au sein de la chambre
        gbc.gridx=0; 
        gbc.gridy=3; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(btnAffectInf,gbc); 
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(labCleInfirm,gbc);
        
        panelGeneral.add(panelCentre, BorderLayout.CENTER); //ajout du panel centre au panel general
                
        //panel bas
        panelBas.add(btnValider,BorderLayout.WEST); //ajout bouton Valider au panel du bas
        panelBas.add(btnAnnuler,BorderLayout.EAST); //ajout bouton Annuler au panel du bas
        panelGeneral.add(panelBas, BorderLayout.SOUTH); //ajout du panel bas au panel general  
        
        //methodes
        setContentPane(panelGeneral); //methode affichant l'ensemble du contenu affecte au panel general 
        setTitle("Creation chambre"); //titre panel general
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fermeture juste de la fenetre en question 
  
    }
    
    //getteurs des zones valeurs
    public JSpinner getnoCh(){ 
        return noCh;
    }
    public JSpinner getnoLit(){
        return noLit;
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

    public JButton getBtnAffectInf() {
        return btnAffectInf;
    }

    public JButton getBtnAffectServ() {
        return btnAffectServ;
    }
    //gerrter label
    public JLabel getLabCleInfirm() {
        return labCleInfirm;
    }
     
}
