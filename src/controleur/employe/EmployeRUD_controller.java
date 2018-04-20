
package controleur.employe;

import controleur.SearchController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.naming.directory.SearchControls;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Employe;
import model.Recherche;
import vue.employe.FenRUD_employe;


public class EmployeRUD_controller implements ActionListener, ListSelectionListener, KeyListener, EmployeRUD_Interface {


    private Employe modelEmploye = new Employe();
    private final FenRUD_employe fenRUD_employe = new FenRUD_employe();

    public EmployeRUD_controller(Employe e) {
        this.modelEmploye = e;
        
        fenRUD_employe.getTableDonnees().setModel(e.getModelDataTable());
        fenRUD_employe.getComboSexe().setModel(e.getModelSexe());
        fenRUD_employe.getComboDSpecialite().setModel(e.getModelSpecialite());
        fenRUD_employe.getComboInfRot().setModel(e.getModelRotationInf());
        setCellReadOnly(fenRUD_employe.getTableDonnees());
        fenRUD_employe.getTableDonnees().getColumnModel().getColumn(0).setMaxWidth(0);
        fenRUD_employe.getTableDonnees().getColumnModel().getColumn(0).setMinWidth(0);
        fenRUD_employe.getTableDonnees().getColumnModel().getColumn(0).setPreferredWidth(0);
        fenRUD_employe.getBtnReporting().addActionListener(this);
        fenRUD_employe.getBtnSupression().addActionListener(this);
        fenRUD_employe.getBtnRecherche().addActionListener(this);
        fenRUD_employe.getBtnModifier().addActionListener(this);
        fenRUD_employe.getBtnUpdate().addActionListener(this);
        fenRUD_employe.getBtnBack().addActionListener(this);
        fenRUD_employe.getBtnRaz().addActionListener(this);
        fenRUD_employe.getCheckOnModif().addActionListener(this);
        fenRUD_employe.getBtnAide().addActionListener(this);
        fenRUD_employe.getFieldTel().addKeyListener(this);
        configStart();
        fenRUD_employe.setVisible(true);
        fenRUD_employe.repaint();
    }
    
    private void configStart(){
        fenRUD_employe.getSpinSalaire().setVisible(false);
        fenRUD_employe.getLabIRotaion().setVisible(false);
        fenRUD_employe.getLabISalair().setVisible(false);
        fenRUD_employe.getComboInfRot().setVisible(false);
        fenRUD_employe.getLabDSpecialite().setVisible(false);
        fenRUD_employe.getComboDSpecialite().setVisible(false);
    }
    
    private void showChampsDoc(){
        fenRUD_employe.getSpinSalaire().setVisible(false);
        fenRUD_employe.getLabIRotaion().setVisible(false);
        fenRUD_employe.getLabISalair().setVisible(false);
        fenRUD_employe.getComboInfRot().setVisible(false);
        fenRUD_employe.getFieldCodeS().setVisible(false);
        fenRUD_employe.getLabICodeSer().setVisible(false);
        fenRUD_employe.getLabDSpecialite().setVisible(true);
        fenRUD_employe.getComboDSpecialite().setVisible(true);
    }
    
    private void showChampsInf(){
        fenRUD_employe.getSpinSalaire().setVisible(true);
        fenRUD_employe.getLabIRotaion().setVisible(true);
        fenRUD_employe.getLabISalair().setVisible(true);
        fenRUD_employe.getComboInfRot().setVisible(true);
        fenRUD_employe.getFieldCodeS().setVisible(true);
        fenRUD_employe.getLabICodeSer().setVisible(true);
        fenRUD_employe.getLabDSpecialite().setVisible(false);
        fenRUD_employe.getComboDSpecialite().setVisible(false);
    }
    
    @Override
    public void setCellReadOnly(JTable table){
        for (int i=0; i < table.getColumnCount(); i++){
            Class<?> col_class = table.getColumnClass(i);
            table.setDefaultEditor(col_class, null);
        }
    }   
    
    @Override
    public void desactiveModif(){
        fenRUD_employe.getFieldNom().setEnabled(false);
        fenRUD_employe.getFieldPrenom().setEnabled(false);
        fenRUD_employe.getFieldAdresse().setEnabled(false);
        fenRUD_employe.getFieldTel().setEnabled(false);
        fenRUD_employe.getFieldEmail().setEnabled(false);
        fenRUD_employe.getComboDSpecialite().setEnabled(false);
        fenRUD_employe.getComboInfRot().setEnabled(false);
        fenRUD_employe.getTableDonnees().clearSelection();
        fenRUD_employe.getBtnRaz().setEnabled(false);
        fenRUD_employe.getBtnModifier().setEnabled(false);
        fenRUD_employe.getBtnUpdate().setEnabled(false);
    }
    
    @Override
    public void activeModif(){
        fenRUD_employe.getFieldNom().setEnabled(true);
        fenRUD_employe.getFieldPrenom().setEnabled(true);
        fenRUD_employe.getFieldAdresse().setEnabled(true);
        fenRUD_employe.getFieldTel().setEnabled(true);
        fenRUD_employe.getFieldEmail().setEnabled(true);
        fenRUD_employe.getComboDSpecialite().setEnabled(true);
        fenRUD_employe.getComboInfRot().setEnabled(true);
        fenRUD_employe.getBtnRaz().setEnabled(true);
        fenRUD_employe.getBtnUpdate().setEnabled(true);
        fenRUD_employe.getBtnModifier().setEnabled(true);
    }
    
    @Override
    public void remplirFormModif(int posi, boolean isDoctor){
        try {
            fenRUD_employe.getFieldNom().setText(modelEmploye.getModelDataTable().getValueAt(posi, 1).toString());
            fenRUD_employe.getFieldPrenom().setText(modelEmploye.getModelDataTable().getValueAt(posi, 2).toString());
            fenRUD_employe.getFieldAdresse().setText(modelEmploye.getModelDataTable().getValueAt(posi, 3).toString());
            fenRUD_employe.getFieldTel().setText(modelEmploye.getModelDataTable().getValueAt(posi, 4).toString());
            //fenRUD_employe.getComboSexe()
            //fenRUD_employe.getFieldAge()
            //fenRUD_employe.getFieldEmail().setText(modelEmploye.getModelDataTable().getValueAt(i, 4).toString()); // POur l'email
            if(isDoctor){
                fenRUD_employe.getComboDSpecialite().setSelectedItem(modelEmploye.getModelDataTable().getValueAt(posi, 5));
            } else {
                fenRUD_employe.getFieldCodeS().setText(modelEmploye.getModelDataTable().getValueAt(posi, 6).toString());
                fenRUD_employe.getSpinSalaire().setValue(Integer.parseInt(modelEmploye.getModelDataTable().getValueAt(posi, 8).toString()));
                fenRUD_employe.getComboInfRot().setSelectedItem(modelEmploye.getModelDataTable().getValueAt(posi, 7));
            }
        } catch (Exception e) {
        }
    }
    
    @Override
    public void videzChamp(){
        fenRUD_employe.getFieldNom().setText("");
        fenRUD_employe.getFieldPrenom().setText("");
        fenRUD_employe.getFieldAdresse().setText("");
        fenRUD_employe.getFieldTel().setText("");
        fenRUD_employe.getFieldEmail().setText("");
        fenRUD_employe.getFieldCodeS().setText("");
        fenRUD_employe.getComboDSpecialite().setSelectedIndex(0);
        fenRUD_employe.getComboInfRot().setSelectedIndex(0);
        fenRUD_employe.getTableDonnees().clearSelection();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("employeRUD");
        if(ae.getSource().equals(fenRUD_employe.getBtnBack())){
            fenRUD_employe.dispose();
            EmployerController ec = new EmployerController(modelEmploye);
        }
        else if(ae.getSource().equals(fenRUD_employe.getBtnAide())){
            
        }
        else if(ae.getSource() == fenRUD_employe.getBtnRaz()){
            if(fenRUD_employe.getCheckOnModif().isSelected())
                videzChamp();
        }
        else if(ae.getSource().equals(fenRUD_employe.getCheckOnModif())){
            if(fenRUD_employe.getCheckOnModif().isSelected()){
                activeModif();
                fenRUD_employe.repaint();
            }else if(!(fenRUD_employe.getCheckOnModif().isSelected())){
                desactiveModif();
                fenRUD_employe.repaint();
            }
        }
        else if(ae.getSource().equals(fenRUD_employe.getBtnModifier())){
            int i = fenRUD_employe.getTableDonnees().getSelectedRow();
            //System.out.println(Integer.parseInt(fenRUD_employe.getTableDonnees().getValueAt(i, 0).toString()));
            if(modelEmploye.isDocteur(Integer.parseInt(fenRUD_employe.getTableDonnees().getValueAt(i, 0).toString()))){
                showChampsDoc();
                remplirFormModif(i, true);
            }else{
                showChampsInf();
                remplirFormModif(i,false);
            }
            fenRUD_employe.repaint();
        }
        else if(ae.getSource().equals(fenRUD_employe.getBtnUpdate())){
            if(fenRUD_employe.getCheckOnModif().isSelected()){
                int i = fenRUD_employe.getTableDonnees().getSelectedRow();
                if(i>=0){
                    int reponse = JOptionPane.showOptionDialog(fenRUD_employe, "Voulez-vous enregister vos modifications?", "Mise à jour des données", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if(reponse == JOptionPane.YES_OPTION){
                        int numero = Integer.parseInt(fenRUD_employe.getTableDonnees().getValueAt(i, 0).toString());
                        String nom = fenRUD_employe.getFieldNom().getText();
                        String prenom = fenRUD_employe.getFieldPrenom().getText();
                        String adresse = fenRUD_employe.getFieldAdresse().getText();
                        String tel = fenRUD_employe.getFieldTel().getText();
                        String specialite = (String)fenRUD_employe.getComboDSpecialite().getSelectedItem();
                        String codeS = fenRUD_employe.getFieldCodeS().getText();
                        String rotation = (String)fenRUD_employe.getComboInfRot().getSelectedItem();
                        double salaire = (double)fenRUD_employe.getSpinSalaire().getValue();
                        
                        if(modelEmploye.updateDataEmploye(numero, nom, prenom, adresse, tel) && modelEmploye.updateDataDoc(numero, specialite)){
                            JOptionPane.showMessageDialog(fenRUD_employe, "Les informations de l'employé ont été correctement mis à jour.", "Mise à jour données - succès", JOptionPane.INFORMATION_MESSAGE);
                            //fenRUD_employe.getTableDonnees().getModel()
                            fenRUD_employe.repaint();
                        }
                        else if(modelEmploye.updateDataEmploye(numero, nom, prenom, adresse, tel) && modelEmploye.updateDataInf(numero, codeS, rotation,salaire)){
                            JOptionPane.showMessageDialog(fenRUD_employe, "Les informations de l'employé ont été correctement mis à jour.", "Mise à jour données - succès", JOptionPane.INFORMATION_MESSAGE);
                            fenRUD_employe.repaint();
                        }else{
                            JOptionPane.showMessageDialog(fenRUD_employe, "Impossible de mettre à jour l'employé. Une erreur c'est produite.", "Mise à jour données - erreur", JOptionPane.OK_OPTION);
                        }
                    }else
                        JOptionPane.showMessageDialog(fenRUD_employe, "Les modifications n'ont pas été sauvegardées.", "Mise à jour des données", JOptionPane.WARNING_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(fenRUD_employe, "Impossible de mettre à jour, aucune donnée n'est sélectionée.", "Mise à jour données", JOptionPane.OK_OPTION);
            }
        }
        else if(ae.getSource().equals(fenRUD_employe.getBtnSupression())){
            int i = fenRUD_employe.getTableDonnees().getSelectedRow();
            if(i>=0){
                
            }else
                JOptionPane.showMessageDialog(fenRUD_employe, "Impossible de suprimer, aucune donnée n'est sélectionée.", "Supression de données", JOptionPane.OK_OPTION);
        }
        else if(ae.getSource().equals(fenRUD_employe.getBtnRecherche())){
            Recherche r = new Recherche();
            SearchController sc = new SearchController(r);
        }
    }

    public void mouseClicked(MouseEvent me) {
        System.out.println("mouse");
       
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getSource().equals(fenRUD_employe.getFieldTel())){
            char keyChar = ke.getKeyChar();
            if(!(Character.isDigit(keyChar) || (KeyEvent.VK_SPACE == keyChar) || (KeyEvent.VK_DELETE == keyChar) || (KeyEvent.VK_LEFT == keyChar) || (KeyEvent.VK_RIGHT == keyChar))){
                ke.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
