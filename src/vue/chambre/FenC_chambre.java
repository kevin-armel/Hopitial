
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import static vue.Fen_accueil.btnBack;


public class FenC_chambre extends JFrame implements ActionListener{
    
    //variables
    private final JSpinner noCh = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1));
    private final JSpinner noSur = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1));
    private final JSpinner noLit = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1));
    private final JButton btnAide = new JButton("Aide"); ; //creation bouton aide
    private final JButton btnValider = new JButton("Valider");; //creation bouton valider
    private final JButton btnAnnuler = new JButton("Annuler"); //creation bouton annuler
    
    /**
     * constructeur de la classe
     */
    public FenC_chambre(){
        
        JPanel panelGeneral = new JPanel(new BorderLayout()); //creation du panel general
        JPanel panelHaut = new JPanel(new BorderLayout()); //creation du panel haut
        JPanel panelCentre = new JPanel (new GridBagLayout()); //creation du panel centre
        GridBagConstraints gbc = new GridBagConstraints(); //creation du constructeur permettant de placer les elements dans la grille de la fenetre
        JPanel panelBas = new JPanel(new BorderLayout()); //creation du panel bas
        
        
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
        panelCentre.add(new JLabel("Numéro de la chambre : "),gbc); //
        gbc.gridx=1; //prochain positionnement x = x précédent + width
        gbc.gridwidth=GridBagConstraints.REMAINDER; //
        panelCentre.add(noCh,gbc);
        //label et spinner numero du surveillant affecté a la chombre
        gbc.gridx=0; 
        gbc.gridy=1; 
        gbc.gridwidth=1;  
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Numéro du surveillant : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(noSur,gbc);
        //label et spinner nombre de lits present au sein de la chambre
        gbc.gridx=0; 
        gbc.gridy=3; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Nombre de lits : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(noLit,gbc);
        
        panelGeneral.add(panelCentre, BorderLayout.CENTER); //ajout du panel centre au panel general
        
        
        //panel bas
        panelBas.add(btnValider,BorderLayout.CENTER); //ajout bouton Valider au panel du bas
        panelBas.add(btnAnnuler,BorderLayout.EAST); //ajout bouton Annuler au panel du bas
        panelGeneral.add(panelBas, BorderLayout.SOUTH); //ajout du panel bas au panel general

        
        //bouton sur ecoute
        btnAide.addActionListener(this);
        btnAnnuler.addActionListener(this);
        btnValider.addActionListener(this);
                
        
        //methodes
        setContentPane(panelGeneral); //methode affichant l'ensemble du contenu affecte au panel general 
        setTitle("Creation chambre"); //titre panel general 
        setVisible(true); //panel general visible 
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //fermeture juste de la fenetre en question 
  
    }
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == btnAnnuler){
            noCh.setValue(0);
            noSur.setValue(0);
            noLit.setValue(0);
        }
        if(e.getSource() == btnAide){
            JOptionPane.showMessageDialog(null, "Débrouille toi !", "Aide création chambre", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    //getteurs des zones valeurs
    public JSpinner getnoCh(){ 
        return noCh;
    }
    public JSpinner getnoSur(){
        return noSur;
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
}
