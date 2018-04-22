
package vue.chambre;

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


public class FenC_chambre extends JFrame{
    
    
    //variables
    private final JSpinner spinNumChambre = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
    public static JTextField fieldCleInfirm = new JTextField();
    
    private final JSpinner spinNumLit = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
    
    private final JComboBox comboCodeServ = new JComboBox();
    
    private final JButton btnBack = new JButton("Retour"); //creation bouton retour
    private final JButton btnAide = new JButton("Aide"); ; //creation bouton aide
    private final JButton btnValider = new JButton("Valider");; //creation bouton valider
    private final JButton btnAnnuler = new JButton("Annuler"); //creation bouton annuler
    private final JButton btnCleInfirm = new JButton("Numéro Surveillant"); //creation bouton annuler
    
    /**
     * constructeur de la classe
     */
    public FenC_chambre(){
        
        setIconImage(getToolkit().getImage("img/exec3.png"));
        
        JPanel panelGeneral = new JPanel(new BorderLayout(50,50)); //creation du panel general
        JPanel panelHaut = new JPanel(new BorderLayout()); //creation du panel haut
        JPanel panelCentre = new JPanel (new GridBagLayout()); //creation du panel centre
         //creation du constructeur permettant de placer les elements dans la grille de la fenetre
        JPanel panelBas = new JPanel(new BorderLayout()); //creation du panel bas
        fieldCleInfirm.setPreferredSize(new Dimension(100, 20));
        spinNumChambre.setPreferredSize(new Dimension(100, 20));
        spinNumLit.setPreferredSize(new Dimension(100, 20));
        comboCodeServ.setPreferredSize(new Dimension(100, 20));
//panel haut

        panelHaut.add(btnBack,BorderLayout.WEST); //ajout bouton retour au panel du haut
        panelHaut.add(btnAide,BorderLayout.EAST); //ajout bouton aide au panel du haut          
        panelGeneral.add(panelHaut, BorderLayout.NORTH); //ajout du panel haut au panel general
        
        GridBagConstraints gbc = new GridBagConstraints();
        //panel centre
        gbc.weightx =1;
        gbc.weighty = 2;
        
        //label et spinner numero chambre
        gbc.gridx=0; //initialisation du positionnement en x
        gbc.gridy=0; //initialisation du positionnement en y
        gbc.gridwidth=1; //initialisation de la largeur 
        gbc.gridheight=1; //initialisation de la hauteur 
        panelCentre.add(new JLabel("Numéro de la chambre: "),gbc); //
        gbc.gridx=1; //prochain positionnement x = x précédent + width
        gbc.gridwidth=GridBagConstraints.REMAINDER; //
        panelCentre.add(spinNumChambre,gbc);
        
        //label et spinner numero chambre
        gbc.gridx=0; //initialisation du positionnement en x
        gbc.gridy=1; //initialisation du positionnement en y
        gbc.gridwidth=1; //initialisation de la largeur 
        gbc.gridheight=1; //initialisation de la hauteur 
        panelCentre.add(new JLabel("Code du service: "),gbc); //
        gbc.gridx=1; //prochain positionnement x = x précédent + width
        gbc.gridwidth=GridBagConstraints.REMAINDER; //
        panelCentre.add(comboCodeServ,gbc);
        
        //label et spinner nombre de lits present au sein de la chambre
        gbc.gridx=0; 
        gbc.gridy=2; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Nombre de lits: "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(spinNumLit,gbc);
        
        //label et spinner numero du surveillant affecté a la chombre
        gbc.gridx=0; 
        gbc.gridy=3; 
        gbc.gridwidth=1;  
        gbc.gridheight=1; 
        panelCentre.add(btnCleInfirm,gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(fieldCleInfirm,gbc);
        
        panelGeneral.add(panelCentre, BorderLayout.CENTER); //ajout du panel centre au panel general
        
        
        //panel bas
        panelBas.add(btnValider,BorderLayout.CENTER); //ajout bouton Valider au panel du bas
        panelBas.add(btnAnnuler,BorderLayout.EAST); //ajout bouton Annuler au panel du bas
        panelGeneral.add(panelBas, BorderLayout.SOUTH); //ajout du panel bas au panel general

        //methodes
        setContentPane(panelGeneral); //methode affichant l'ensemble du contenu affecte au panel general 
        setTitle("Creation chambre"); //titre panel general
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fermeture juste de la fenetre en question 
  
    }
    
    
    //getteurs des boutons 
    /**
     * methode permettant de reuperer le bouton retour 
     * @return 
     */
    public JButton getBtnBack() {
        return btnBack;
    }
    
    /**
     * methode permettant de reuperer le bouton de creation
     * @return 
     */
    public JButton getBtnAide() {
        return btnAide;
    }

    public JButton getBtnValider() {
        return btnValider;
    }

    public JButton getBtnAnnuler() {
        return btnAnnuler;
    }

    public JSpinner getSpinNumChambre() {
        return spinNumChambre;
    }

    public JTextField getFieldCleInfirm() {
        return fieldCleInfirm;
    }

    public JSpinner getSpinNumLit() {
        return spinNumLit;
    }

    public JButton getBtnCleInfirm() {
        return btnCleInfirm;
    }

    public JComboBox getComboCodeServ() {
        return comboCodeServ;
    }
    
}
