
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
        fenC_employe.repaint();
        fenC_employe.setVisible(true);
        
        fenC_employe.getBtnBack().addActionListener(this);
        fenC_employe.getbtnAnnuler().addActionListener(this);
        fenC_employe.getbtnAide().addActionListener(this);
        fenC_employe.getbtnValider().addActionListener(this);
        fenC_employe.getComboTypeEmploye().addActionListener(this);
        
        
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
                afficheChampsDoc();
            }else if(selecte.equals("Infirmier")){
                afficheChampsInf();
            }else if(selecte.equals("Employe")){
                afficheChampsEmp();
            }
        }
         if(e.getSource() == fenC_employe.getbtnAnnuler()){
            viderChamps();
        }else if(e.getSource() == fenC_employe.getbtnAide()){  
            JOptionPane.showMessageDialog(null, "Débrouille toi !", "Aide création service ", JOptionPane.PLAIN_MESSAGE);
        }else if(e.getSource() == fenC_employe.getbtnValider()){
            JOptionPane.showMessageDialog(null, "valider !", "valider ", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    @Override
    public void afficheChampsDoc(){
        fenC_employe.getlabSpecialite().setVisible(true);
        fenC_employe.getFieldSpecia().setVisible(true);
        fenC_employe.getlabRotation().setVisible(false);
        fenC_employe.getComboRotation().setVisible(false);
        fenC_employe.getlabSalaire().setVisible(false);
        fenC_employe.getSpinSalaire().setVisible(false);
    }
    
    @Override
    public void afficheChampsInf(){
        fenC_employe.getlabRotation().setVisible(true);
        fenC_employe.getComboRotation().setVisible(true);
        fenC_employe.getlabSalaire().setVisible(true);
        fenC_employe.getSpinSalaire().setVisible(true);
        fenC_employe.getlabSpecialite().setVisible(false);
        fenC_employe.getFieldSpecia().setVisible(false);       
    }
    
    @Override
    public void afficheChampsEmp(){
        fenC_employe.getlabSpecialite().setVisible(false);
        fenC_employe.getFieldSpecia().setVisible(false);
        fenC_employe.getlabRotation().setVisible(false);  
        fenC_employe.getComboRotation().setVisible(false);
        fenC_employe.getlabSalaire().setVisible(false);
        fenC_employe.getSpinSalaire().setVisible(false);
    }
    
    @Override
    public void viderChamps(){
        fenC_employe.getFieldNom().setText("");
        fenC_employe.getFieldPrenom().setText("");
        fenC_employe.getFieldAdresse().setText("");
        fenC_employe.getFieldSpecia().setText("");
        fenC_employe.getSpinSalaire().setValue(0);
        fenC_employe.getno1().setValue(0);
        fenC_employe.getno2().setValue(0);
        fenC_employe.getno3().setValue(0);
        fenC_employe.getno4().setValue(0);
        fenC_employe.getno5().setValue(0);        
    }
    
}

