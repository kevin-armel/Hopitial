
package controleur.chambre;

import controleur.MetaDataController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Chambre;
import model.MetaDataModel;
import vue.chambre.FenRUD_chambre;

public class ChambreRUD_controller implements ActionListener, ChambreRUD_Interface{
    
    
    private Chambre modelChambre = new Chambre();
    private final FenRUD_chambre fenRUD_chambre = new FenRUD_chambre();

    public ChambreRUD_controller(Chambre c) {
        this.modelChambre = c;
        fenRUD_chambre.getTableDonnees().setModel(c.getModelDataTable());
        fenRUD_chambre.getComboCodeServ().setModel(c.getModelCodeServ());
        setCellReadOnly(fenRUD_chambre.getTableDonnees());
        
        fenRUD_chambre.getBtnBack().addActionListener(this);
        fenRUD_chambre.getBtnAide().addActionListener(this);
        fenRUD_chambre.getBtnCleSurveil().addActionListener(this);
        fenRUD_chambre.getBtnModifier().addActionListener(this);
        fenRUD_chambre.getBtnRaz().addActionListener(this);
        fenRUD_chambre.getBtnRecherche().addActionListener(this);
        fenRUD_chambre.getBtnReporting().addActionListener(this);
        fenRUD_chambre.getBtnSupression().addActionListener(this);
        fenRUD_chambre.getBtnUpdate().addActionListener(this);
        fenRUD_chambre.getCheckOnModif().addActionListener(this);
        
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
        fenRUD_chambre.getComboCodeServ().setEnabled(false);
        fenRUD_chambre.getBtnCleSurveil().setEnabled(false);
        fenRUD_chambre.getTableDonnees().clearSelection();
        fenRUD_chambre.getBtnRaz().setEnabled(false);
        fenRUD_chambre.getBtnModifier().setEnabled(false);
        fenRUD_chambre.getBtnUpdate().setEnabled(false);
    }
    
    @Override
    public void activeModif(){
        fenRUD_chambre.getSpinNbrLits().setEnabled(true);

        fenRUD_chambre.getBtnCleSurveil().setEnabled(true);
        fenRUD_chambre.getBtnRaz().setEnabled(true);
        fenRUD_chambre.getBtnUpdate().setEnabled(true);
        fenRUD_chambre.getBtnModifier().setEnabled(true);
    }
    
    @Override
    public void remplirFormModif(int posi){
        try {
            fenRUD_chambre.getSpinNumChambree().setValue(Integer.parseInt(modelChambre.getModelDataTable().getValueAt(posi, 0).toString()));
            fenRUD_chambre.getSpinNbrLits().setValue(Integer.parseInt(modelChambre.getModelDataTable().getValueAt(posi, 1).toString()));
            fenRUD_chambre.getComboCodeServ().setSelectedItem(modelChambre.getModelDataTable().getValueAt(posi, 2).toString());
            //fenRUD_chambre.getFieldCleServic().setText(modelChambre.getModelDataTable().getValueAt(posi, 3).toString());
            //fenRUD_chambre.getFieldEmail().setText(modelChambre.getModelDataTable().getValueAt(i, 4).toString()); // POur l'email*/

        } catch (Exception e) {
        }
    }
    
    @Override
    public void videzChamp(){
        fenRUD_chambre.getComboCodeServ().setSelectedItem(0);
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
        else if(ae.getSource().equals(fenRUD_chambre.getBtnAide())){
            //aide
        }
        else if(ae.getSource().equals(fenRUD_chambre.getBtnRaz())){
            //videz champs
            videzChamp();
        }
        else if(ae.getSource().equals(fenRUD_chambre.getBtnCleSurveil())){
            MetaDataModel mdm = new MetaDataModel();
            MetaDataController mdc = new MetaDataController(mdm, 2);
        }
        else if(ae.getSource().equals(fenRUD_chambre.getBtnModifier())){
            int i = fenRUD_chambre.getTableDonnees().getSelectedRow();
            if(i>=0){
                remplirFormModif(i);
                fenRUD_chambre.pack();
                fenRUD_chambre.repaint();
            }else
                JOptionPane.showMessageDialog(fenRUD_chambre, "Impossible de mettre à jour, aucune donnée n'est sélectionée.", "Mise à jour données", JOptionPane.OK_OPTION);
        }
        else if(ae.getSource().equals(fenRUD_chambre.getCheckOnModif())){
            if(fenRUD_chambre.getCheckOnModif().isSelected()){
            activeModif();
            }else
                desactiveModif();
        }
        else if(ae.getSource().equals(fenRUD_chambre.getBtnReporting())){
            //reporting
        }
        else if(ae.getSource().equals(fenRUD_chambre.getBtnUpdate())){
            
            int i = fenRUD_chambre.getTableDonnees().getSelectedRow();
            if(i>=0){
                int reponse = JOptionPane.showOptionDialog(fenRUD_chambre, "Voulez-vous enregister vos modifications?", "Mise à jour des données", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(reponse == JOptionPane.YES_OPTION){
                    int numero = Integer.parseInt(fenRUD_chambre.getTableDonnees().getValueAt(i, 0).toString());
                    String codeServ = (String)fenRUD_chambre.getComboCodeServ().getSelectedItem();
                    int numeroChambre = (int)fenRUD_chambre.getSpinNumChambree().getValue();
                    int nbrLits = (int)fenRUD_chambre.getSpinNbrLits().getValue();

                    if(modelChambre.updateDataRoom(numeroChambre, codeServ, MetaDataController.cleSurveillant, nbrLits)){
                        JOptionPane.showMessageDialog(fenRUD_chambre, "Les informations de la chambre ont été correctement mis à jour.", "Mise à jour données - succès", JOptionPane.INFORMATION_MESSAGE);
                        fenRUD_chambre.pack();
                        fenRUD_chambre.repaint();
                    }else{
                        JOptionPane.showMessageDialog(fenRUD_chambre, "Impossible de mettre à jour les données de la chambre. Une erreur c'est produite.", "Mise à jour données - erreur", JOptionPane.OK_OPTION);
                    }
                }else
                    JOptionPane.showMessageDialog(fenRUD_chambre, "Les modifications n'ont pas été sauvegardées.", "Mise à jour des données", JOptionPane.WARNING_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(fenRUD_chambre, "Impossible de mettre à jour, aucune donnée n'est sélectionée.", "Mise à jour données", JOptionPane.OK_OPTION);
        }else if(!(fenRUD_chambre.getCheckOnModif().isSelected()))
            desactiveModif();
        
    }
}