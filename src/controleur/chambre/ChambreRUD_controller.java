
package controleur.chambre;

import controleur.AccueilController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import model.Accueil;
import model.Chambre;
import vue.chambre.FenRUD_chambre;

public class ChambreRUD_controller implements ActionListener, ChambreRUD_Interface{
    
    
    private Chambre modelChambre = new Chambre();
    private final FenRUD_chambre fenRUD_chambre = new FenRUD_chambre();

    public ChambreRUD_controller(Chambre c) {
        this.modelChambre = c;
        fenRUD_chambre.getTableDonnees().setModel(c.getModelDataTable());
        setCellReadOnly(fenRUD_chambre.getTableDonnees());
        
        fenRUD_chambre.getBtnBack().addActionListener(this);
        fenRUD_chambre.setVisible(true);
        fenRUD_chambre.repaint();
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
        fenRUD_chambre.getSpinNbrLits().setEnabled(false);
        fenRUD_chambre.getSpinNumChambree().setEnabled(false);
        fenRUD_chambre.getBtnCleInfirm().setEnabled(false);
        fenRUD_chambre.getBtnCleServic().setEnabled(false);
        /*fenRUD_chambre.getFieldEmail().setEnabled(false);
        fenRUD_chambre.getComboDSpecialite().setEnabled(false);
        fenRUD_chambre.getComboIRotation().setEnabled(false);*/
        fenRUD_chambre.getTableDonnees().clearSelection();
        fenRUD_chambre.getBtnRaz().setEnabled(false);
        fenRUD_chambre.getBtnModifier().setEnabled(false);
        fenRUD_chambre.getBtnUpdate().setEnabled(false);
    }
    
    @Override
    public void activeModif(){
        fenRUD_chambre.getSpinNbrLits().setEnabled(true);
        fenRUD_chambre.getSpinNumChambree().setEnabled(true);
        fenRUD_chambre.getBtnCleInfirm().setEnabled(true);
        fenRUD_chambre.getBtnCleServic().setEnabled(true);
        /*fenRUD_chambre.getFieldEmail().setEnabled(true);
        fenRUD_chambre.getComboDSpecialite().setEnabled(true);
        fenRUD_chambre.getComboIRotation().setEnabled(true);*/
        fenRUD_chambre.getBtnRaz().setEnabled(true);
        fenRUD_chambre.getBtnUpdate().setEnabled(true);
        fenRUD_chambre.getBtnModifier().setEnabled(true);
    }
    
    @Override
    public void remplirFormModif(int posi){
        try {
            /*fenRUD_chambre.getFieldNom().setText(modelChambre.getModelDataTable().getValueAt(posi, 0).toString());
            fenRUD_chambre.getFieldPrenom().setText(modelChambre.getModelDataTable().getValueAt(posi, 1).toString());
            fenRUD_chambre.getFieldAdresse().setText(modelChambre.getModelDataTable().getValueAt(posi, 2).toString());
            fenRUD_chambre.getFieldTel().setText(modelChambre.getModelDataTable().getValueAt(posi, 3).toString());
            //fenRUD_chambre.getFieldEmail().setText(modelChambre.getModelDataTable().getValueAt(i, 4).toString()); // POur l'email*/

        } catch (Exception e) {
        }
    }
    
    @Override
    public void videzChamp(){
        fenRUD_chambre.getFieldCleInfirm().setText("");
        fenRUD_chambre.getFieldCleServic().setText("");
        fenRUD_chambre.getSpinNbrLits().setValue(null);
        fenRUD_chambre.getSpinNumChambree().setValue(null);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == fenRUD_chambre.getBtnBack()){
            fenRUD_chambre.dispose();
            ChambreController ac = new ChambreController(modelChambre);
        }
    }
    
    
}