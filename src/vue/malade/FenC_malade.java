
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
import static vue.Fen_accueil.btnBack;


public class FenC_malade extends JFrame implements ActionListener{

    //variables
    private final JSpinner num = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1)); //creation champ numero 
    private final JSpinner no00 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1)); //creation champ numero telephone 
    private final JSpinner no11 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1)); //creation champ numero telephone 
    private final JSpinner no22 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1)); //creation champ numero telephone 
    private final JSpinner no33 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1)); //creation champ numero telephone 
    private final JSpinner no44 = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1)); //creation champ numero telephone  
    private final JButton btnAide = new JButton("Aide"); ; //creation bouton aide
    private final JButton btnValider = new JButton("Valider");; //creation bouton valider
    private final JButton btnAnnuler = new JButton("Annuler"); //creation bouton annuler
    private final JTextField nom = new JTextField(); //creation zone de texte 
    private final JTextField pre = new JTextField(); //creation zone de texte 
    private final JTextField add = new JTextField(); //creation zone de texte 
    private final JTextField mut = new JTextField(); //creation zone de texte 
    
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
        nom.setPreferredSize(new Dimension(100,30));
        //label et field prénom malade
        gbc.gridx=0; 
        gbc.gridy=2; 
        gbc.gridwidth=1;  
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Prénom malade : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(pre,gbc);
        pre.setPreferredSize(new Dimension(100,30));
        //label et field addresse malade
        gbc.gridx=0; 
        gbc.gridy=3; 
        gbc.gridwidth=1;  
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Adresse du malade : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(add,gbc);
        add.setPreferredSize(new Dimension(100,30));
        //label et field mutuelle du malade
        gbc.gridx=0; 
        gbc.gridy=4; 
        gbc.gridwidth=1; 
        gbc.gridheight=1; 
        panelCentre.add(new JLabel("Nombre de lits : "),gbc); //
        gbc.gridx=1; 
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        panelCentre.add(mut,gbc);
        mut.setPreferredSize(new Dimension(100,30));
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
        gbc.gridy=5; 
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
            num.setValue(0);
            no00.setValue(0);
            no11.setValue(0);
            no22.setValue(0);
            no33.setValue(0);
            no44.setValue(0);
            nom.setText("");
            pre.setText("");
            add.setText("");
            mut.setText("");
        }
        if(e.getSource() == btnAide){
            JOptionPane.showMessageDialog(null, "Débrouille toi !", "Aide création malade", JOptionPane.PLAIN_MESSAGE);
        }           
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
    public JTextField getnmut(){
        return mut;
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