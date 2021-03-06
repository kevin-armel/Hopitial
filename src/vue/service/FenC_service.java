
package vue.service;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FenC_service extends JFrame {
    
    private final JButton btnBack = new JButton("Retour");
    private final JButton btnAide = new JButton("Aide");
    private final JButton btnAnnuler = new JButton("Annuler");
    private final JButton btnValider = new JButton("Valider"); //Création des Bouttons
    
    private final JTextField fieldCode = new JTextField();
    private final JTextField fieldNom = new JTextField();
    private final JComboBox ComboBatiment = new JComboBox();
    
    private final JSpinner directeur = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        
    /**
     * constructeur de la classe
     */
    public FenC_service(){
        JPanel panelGeneral = new JPanel(new BorderLayout());
        JPanel panelHaut = new JPanel(new BorderLayout());
        JPanel panelCentre = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel panelBas = new JPanel(new BorderLayout()); //Création des pannels
        
        panelHaut.add(btnBack, BorderLayout.WEST);
        panelHaut.add(btnAide, BorderLayout.EAST);    //mise en forme du pannel du haut
        
        panelGeneral.add(panelHaut, BorderLayout.NORTH); //ajout du pannel au pannel général
        
        panelBas.add(btnAnnuler, BorderLayout.EAST);
        panelBas.add(btnValider, BorderLayout.CENTER); //mise en forme du pannel du bas
        
        panelGeneral.add(panelBas, BorderLayout.SOUTH); //ajout du pannnel au pannel général
        
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;       
        panelCentre.add(new JLabel("Code: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        fieldCode.setPreferredSize(new Dimension(100,30));
        panelCentre.add(fieldCode, gbc); // Ligne 1 du pannel central
        
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(new JLabel("Nom: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        fieldNom.setPreferredSize(new Dimension(100,30));
        panelCentre.add(fieldNom, gbc); //Ligne 2 du pannel centrale
        
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(new JLabel("Batiment: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        ComboBatiment.setPreferredSize(new Dimension(100,30));
        panelCentre.add(ComboBatiment, gbc); //Ligne 3 du pannel centrale
        
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        panelCentre.add(new JLabel("Numero Directeur: "), gbc);
        gbc.gridx=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        directeur.setPreferredSize(new Dimension(100,30));
        panelCentre.add(directeur, gbc); //Ligne 4 du pannel centrale
        
        panelGeneral.add(panelCentre, BorderLayout.CENTER);
        
        
        setContentPane(panelGeneral);
        setTitle("Creation service");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
    }

    
    //getter des Jspinner
    
    public JSpinner getdirecteur(){
        return directeur;
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

    public JTextField getFieldCode() {
        return fieldCode;
    }

    public JTextField getFieldNom() {
        return fieldNom;
    }

    public JComboBox getComboBatiment() {
        return ComboBatiment;
    }

    
    
}
