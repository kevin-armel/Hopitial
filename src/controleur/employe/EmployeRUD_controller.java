
package controleur.employe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Employe;
import vue.employe.FenRUD_employe;


public class EmployeRUD_controller implements ActionListener, MouseListener, EmployeRUD_Interface {

    private Employe modelEmploye = new Employe();
    private final FenRUD_employe fenRUD_employe = new FenRUD_employe();

    public EmployeRUD_controller(Employe e) {
        this.modelEmploye = e;
        fenRUD_employe.setVisible(true);
        fenRUD_employe.getTableDonnees().setModel(e.getModelDataTable());
        //fenRUD_employe.getTableDonnees().getMouseListeners();
        fenRUD_employe.getBtnRaz().addActionListener(this);
        fenRUD_employe.getCheckOnModif().addMouseListener(this);
    }
    
    
    @Override
    public void desactiveModif(){
        fenRUD_employe.getFieldNom().setEnabled(false);
        fenRUD_employe.getFieldPrenom().setEnabled(false);
        fenRUD_employe.getFieldAdresse().setEnabled(false);
        fenRUD_employe.getFieldTel().setEnabled(false);
        fenRUD_employe.getFieldEmail().setEnabled(false);
        fenRUD_employe.getComboDSpecialite().setEnabled(false);
        fenRUD_employe.getComboIRotation().setEnabled(false);
        fenRUD_employe.getBtnRaz().setEnabled(false);
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
        fenRUD_employe.getComboIRotation().setEnabled(true);
        fenRUD_employe.getBtnRaz().setEnabled(true);
        fenRUD_employe.getBtnUpdate().setEnabled(true);
    }
    
    @Override
    public void remplirFormModif(int posi){
        try {
            for(int i=0; i<modelEmploye.getModelDataTable().getRowCount(); i++){
                fenRUD_employe.getFieldNom().setText(modelEmploye.getModelDataTable().getValueAt(i, 0).toString());
                fenRUD_employe.getFieldPrenom().setText(modelEmploye.getModelDataTable().getValueAt(i, 1).toString());
                fenRUD_employe.getFieldAdresse().setText(modelEmploye.getModelDataTable().getValueAt(i, 2).toString());
                fenRUD_employe.getFieldTel().setText(modelEmploye.getModelDataTable().getValueAt(i, 3).toString());
                //fenRUD_employe.getFieldEmail().setText(modelEmploye.getModelDataTable().getValueAt(i, 4).toString()); // POur l'email
            }
            
        } catch (Exception e) {
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if((ae.getSource() == fenRUD_employe.getBtnRaz()) && (fenRUD_employe.getCheckOnModif()).isSelected()){
            fenRUD_employe.getFieldNom().setText("");
            fenRUD_employe.getFieldPrenom().setText("");
            fenRUD_employe.getFieldAdresse().setText("");
            fenRUD_employe.getFieldTel().setText("");
            fenRUD_employe.getFieldEmail().setText("");
            fenRUD_employe.getComboDSpecialite().setSelectedIndex(0);
            fenRUD_employe.getComboIRotation().setSelectedIndex(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int i = fenRUD_employe.getTableDonnees().getSelectedRow();
        System.out.println("mouse");
        if((me.getSource().equals(fenRUD_employe.getCheckOnModif())) && (fenRUD_employe.getCheckOnModif()).isSelected()){
            activeModif();
            fenRUD_employe.repaint();
        }else if(me.getSource().equals(fenRUD_employe.getCheckOnModif())){
            desactiveModif();
            fenRUD_employe.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
