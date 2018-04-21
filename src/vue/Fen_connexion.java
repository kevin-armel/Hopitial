
package vue;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Fen_connexion extends JFrame{
    
    private final JButton btnConnexion = new JButton("Connexion");
    private final JButton btnAnnuler = new JButton("Annuler");
    private final JTextField fieldLogin = new JTextField();
    private final JPasswordField fieldPass = new JPasswordField();
    private final JTextField fieldBDD = new JTextField("hopital");
    private final JPasswordField fieldBDDPass = new JPasswordField();
    private final JCheckBox checkOption = new JCheckBox("Cocher pour Plus d'option d'authentification");
    private final JCheckBox checkDistant = new JCheckBox("Cocher pour se connecter sur le serveur distant");
    private final JLabel labelIcon = new JLabel("Ici l'Icone");
    private final JLabel labelTextHaut = new JLabel("Ici texte en haut");
    private final JLabel labelNom = new JLabel("Nom utilisateur: ");
    private final JLabel labelPass = new JLabel("Mots de passe: ");
    private final JLabel labelBDD = new JLabel("Nom de la base de donées: ");
    private final JLabel labelBDDPass = new JLabel("Mots de passe accès distant:");
    
    
    /**
     * constructeur de la classe
     */
    public Fen_connexion(){
        fieldPass.setColumns(12);
        fieldBDD.setColumns(12);
        fieldBDDPass.setColumns(12);
        fieldLogin.setColumns(12);
        labelBDD.setVisible(false);
        labelBDDPass.setVisible(false);
        fieldBDD.setVisible(false);
        fieldBDDPass.setVisible(false);
        checkDistant.setVisible(false);
        
        JPanel panCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbcLayout = new GridBagConstraints();
        gbcLayout.weightx = 0;
        gbcLayout.weighty = 2;
        //initialisation du positionnement à 0 en x et y
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 0;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        panCentral.add(labelNom, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        panCentral.add(fieldLogin, gbcLayout); // je l'ajoute à cette position de départ
        
        //initialisation du positionnement à 0 en x et y
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 1;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        panCentral.add(labelPass, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        panCentral.add(fieldPass, gbcLayout); // je l'ajoute à cette position de départ
        
        //initialisation du positionnement à 0 en x et y
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 2;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        panCentral.add(checkOption, gbcLayout); // je l'ajoute à cette position de départ
        
        //initialisation du positionnement à 0 en x et y
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 3;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        panCentral.add(labelBDD, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        panCentral.add(fieldBDD, gbcLayout); // je l'ajoute à cette position de départ
        
        //initialisation du positionnement à 0 en x et y
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 4;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.gridwidth = 1;
        gbcLayout.gridheight = 1;
        panCentral.add(labelBDDPass, gbcLayout); // je l'ajoute à cette position de départ
        gbcLayout.gridx = 1;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        panCentral.add(fieldBDDPass, gbcLayout); // je l'ajoute à cette position de départ
        
        //initialisation du positionnement à 0 en x et y
        gbcLayout.gridx = 0;
        gbcLayout.gridy = 5;
        //initialisation du pas, ou déplacement, ou pas en largeur et hauteur
        gbcLayout.fill = GridBagConstraints.HORIZONTAL;
        gbcLayout.gridwidth = GridBagConstraints.REMAINDER;
        gbcLayout.gridheight = 1;
        panCentral.add(checkDistant, gbcLayout); // je l'ajoute à cette position de départ
        
        JPanel panB = new JPanel(new BorderLayout(80, 80));
        panB.add(btnConnexion, BorderLayout.WEST);
        panB.add(btnAnnuler, BorderLayout.EAST);
        
        JPanel panelGeneral = new JPanel(new BorderLayout(50, 50));
        panelGeneral.add(labelTextHaut, BorderLayout.NORTH);
        panelGeneral.add(labelIcon, BorderLayout.WEST);
        panelGeneral.add(panCentral, BorderLayout.CENTER);
        panelGeneral.add(panB, BorderLayout.SOUTH);
        
        setContentPane(panelGeneral);
        setTitle("Connexion au serveur");
        //setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getBtnConnexion() {
        return btnConnexion;
    }

    public JButton getBtnAnnuler() {
        return btnAnnuler;
    }

    public JTextField getFieldLogin() {
        return fieldLogin;
    }

    public JPasswordField getFieldPass() {
        return fieldPass;
    }

    public JTextField getFieldBDD() {
        return fieldBDD;
    }

    public JPasswordField getFieldBDDPass() {
        return fieldBDDPass;
    }

    public JCheckBox getCheckOption() {
        return checkOption;
    }

    public JCheckBox getCheckDistant() {
        return checkDistant;
    }

    public JLabel getLabelIcon() {
        return labelIcon;
    }

    public JLabel getLabelTextHaut() {
        return labelTextHaut;
    }

    public JLabel getLabelNom() {
        return labelNom;
    }

    public JLabel getLabelPass() {
        return labelPass;
    }

    public JLabel getLabelBDD() {
        return labelBDD;
    }

    public JLabel getLabelBDDPass() {
        return labelBDDPass;
    }
    
    
}
