
package controleur.employe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Employe;
import vue.employe.FenC_employe;


public class EmployeC_controller implements ActionListener, EmployeC_Interface {
    private Employe modelEmploye = new Employe();
    private final FenC_employe fenC_employe = new FenC_employe();

    public EmployeC_controller(Employe e) {
        this.modelEmploye = e;
        
        fenC_employe.getComboSexe().setModel(e.getModelSexe());
        fenC_employe.getCombodSpecia().setModel(e.getModelSpecialite());
        fenC_employe.getComboRotation().setModel(e.getModelRotationInf());
        fenC_employe.getComboCodeServ().setModel(e.getModelCodeServ());
        noAction(true);
        afficheChampsEmp();
        
        fenC_employe.getBtnBack().addActionListener(this);
        fenC_employe.getbtnAnnuler().addActionListener(this);
        fenC_employe.getbtnAide().addActionListener(this);
        fenC_employe.getbtnValider().addActionListener(this);
        fenC_employe.getComboTypeEmploye().addActionListener(this);
        
        fenC_employe.setVisible(true);
        fenC_employe.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(fenC_employe.getBtnBack())){
            fenC_employe.dispose();
            EmployerController ac = new EmployerController(modelEmploye);
        }
        else if(e.getSource().equals(fenC_employe.getComboTypeEmploye())){
            JComboBox<String> combo = (JComboBox<String>) e.getSource();
            String selecte = (String) combo.getSelectedItem();
            if (selecte.equals("Docteur")) {
                noAction(false);
                afficheChampsDoc();
            }else if(selecte.equals("Infirmier")){
                noAction(false);
                afficheChampsInf();
            }else if(selecte.equals("")){
                afficheChampsEmp();
                noAction(true);
            }
            fenC_employe.repaint();
            fenC_employe.pack();
        }
         if(e.getSource() == fenC_employe.getbtnAnnuler()){
            viderChamps();
            fenC_employe.repaint();
        }else if(e.getSource() == fenC_employe.getbtnAide()){  
            JOptionPane.showMessageDialog(null, "Débrouille toi !", "Aide création service ", JOptionPane.PLAIN_MESSAGE);
        }else if(e.getSource() == fenC_employe.getbtnValider()){
            JOptionPane.showMessageDialog(null, "valider !", "valider ", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    @Override
    public void noAction(boolean disable){
        if(disable){
            fenC_employe.getBtnValider().setEnabled(false);
            fenC_employe.getFieldNom().setEnabled(false);
            fenC_employe.getFieldPrenom().setEnabled(false);
            fenC_employe.getCombodSpecia().setEnabled(false);
            fenC_employe.getFieldTel().setEnabled(false);
            fenC_employe.getFieldAdresse().setEnabled(false);
            fenC_employe.getComboSexe().setEnabled(false);
            fenC_employe.getFieldEmail().setEnabled(false);
        }else{
            fenC_employe.getBtnValider().setEnabled(true);
            fenC_employe.getFieldNom().setEnabled(true);
            fenC_employe.getFieldPrenom().setEnabled(true);
            fenC_employe.getCombodSpecia().setEnabled(true);
            fenC_employe.getFieldTel().setEnabled(true);
            fenC_employe.getFieldAdresse().setEnabled(true);
            fenC_employe.getComboSexe().setEnabled(true);
            fenC_employe.getFieldEmail().setEnabled(true);
        }
    }
    
    @Override
    public void afficheChampsDoc(){
        fenC_employe.getlabSpecialite().setVisible(true);
        fenC_employe.getCombodSpecia().setVisible(true);
        fenC_employe.getlabRotation().setVisible(false);
        fenC_employe.getComboRotation().setVisible(false);
        fenC_employe.getlabSalaire().setVisible(false);
        fenC_employe.getSpinSalaire().setVisible(false);
        fenC_employe.getLabCodeServ().setVisible(false);
        fenC_employe.getComboCodeServ().setVisible(false);
        
    }
    
    @Override
    public void afficheChampsInf(){
        fenC_employe.getlabRotation().setVisible(true);
        fenC_employe.getComboRotation().setVisible(true);
        fenC_employe.getlabSalaire().setVisible(true);
        fenC_employe.getSpinSalaire().setVisible(true);
        fenC_employe.getlabSpecialite().setVisible(false);
        fenC_employe.getCombodSpecia().setVisible(false);   
        fenC_employe.getLabCodeServ().setVisible(true);
        fenC_employe.getComboCodeServ().setVisible(true);
    }
    

    public void afficheChampsEmp(){
        fenC_employe.getlabSpecialite().setVisible(false);
        fenC_employe.getCombodSpecia().setVisible(false);
        fenC_employe.getlabRotation().setVisible(false);  
        fenC_employe.getComboRotation().setVisible(false);
        fenC_employe.getlabSalaire().setVisible(false);
        fenC_employe.getSpinSalaire().setVisible(false);
        fenC_employe.getLabCodeServ().setVisible(false);
        fenC_employe.getComboCodeServ().setVisible(false);
    }
    
    @Override
    public void viderChamps(){
        fenC_employe.getFieldNom().setText("");
        fenC_employe.getFieldPrenom().setText("");
        fenC_employe.getFieldAdresse().setText("");
        fenC_employe.getCombodSpecia().setSelectedItem(0);
        fenC_employe.getSpinSalaire().setValue(0);
        fenC_employe.getFieldTel().setText("");
    }
    
}

