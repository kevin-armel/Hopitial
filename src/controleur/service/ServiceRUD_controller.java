
package controleur.service;

import controleur.SearchController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Recherche;
import model.Service;
import vue.service.FenRUD_service;

public class ServiceRUD_controller implements ActionListener, ServiceRUD_Interface {
    
    private Service modelService = new Service();
    private final FenRUD_service fenRUD_service = new FenRUD_service();

    public ServiceRUD_controller(Service s) {
        this.modelService = s;
        fenRUD_service.getTableDonnees().setModel(s.getModelDataTable());
        setCellReadOnly(fenRUD_service.getTableDonnees());
        
        fenRUD_service.getBtnBack().addActionListener(this);
        fenRUD_service.getBtnAide().addActionListener(this);
        fenRUD_service.getBtnCleDocteur().addActionListener(this);
        fenRUD_service.getBtnModifier().addActionListener(this);
        fenRUD_service.getBtnRaz().addActionListener(this);
        fenRUD_service.getBtnRecherche().addActionListener(this);
        fenRUD_service.getBtnReporting().addActionListener(this);
        fenRUD_service.getBtnSupression().addActionListener(this);
        fenRUD_service.getCheckOnModif().addActionListener(this);
        
        fenRUD_service.setVisible(true);
        fenRUD_service.repaint();
    }

    @Override
    public void setCellReadOnly(JTable table){
        for (int i=0; i < table.getColumnCount(); i++){
            Class<?> col_class = table.getColumnClass(i);
            table.setDefaultEditor(col_class, null);
        }
    }  
    
    public void desactiveModif(){
        fenRUD_service.getBtnUpdate().setEnabled(false);
        fenRUD_service.getBtnModifier().setEnabled(false);
        fenRUD_service.getFieldNom().setEnabled(false);
        fenRUD_service.getFieldCode().setEnabled(false);
        fenRUD_service.getFieldCleDoc().setEnabled(false);
        fenRUD_service.getComboBatiment().setEnabled(false);
        fenRUD_service.getBtnCleDocteur().setEnabled(false);
    }
    
    public void activeModif(){
        fenRUD_service.getBtnCleDocteur().setEnabled(true);
        fenRUD_service.getBtnUpdate().setEnabled(true);
        fenRUD_service.getBtnModifier().setEnabled(true);
        fenRUD_service.getFieldNom().setEnabled(true);
        fenRUD_service.getFieldCleDoc().setEnabled(true);
        fenRUD_service.getComboBatiment().setEnabled(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(fenRUD_service.getBtnBack())){
            fenRUD_service.dispose();
            ServiceController sc = new ServiceController(modelService);
        }
        else if(ae.getSource().equals(fenRUD_service.getBtnAide())){
            //aide
        }else if(ae.getSource().equals(fenRUD_service.getCheckOnModif())){
            if(fenRUD_service.getCheckOnModif().isSelected()){
                activeModif();
            }else
                desactiveModif();
            fenRUD_service.repaint();
        }
        else if(ae.getSource().equals(fenRUD_service.getBtnRaz())){
            fenRUD_service.getFieldNom().setText("");
            fenRUD_service.getFieldCode().setText("");
            fenRUD_service.getFieldCleDoc().setText("");
            fenRUD_service.getComboBatiment().setSelectedItem(0);
        }
        else if(ae.getSource().equals(fenRUD_service.getBtnRecherche())){
            Recherche r = new Recherche();
            SearchController sc = new SearchController(r);
        }
        else if(ae.getSource().equals(fenRUD_service.getBtnReporting())){
            //
        }
        else if(ae.getSource().equals(fenRUD_service.getBtnSupression())){
            //
        }
        else if(ae.getSource().equals(fenRUD_service.getBtnModifier())){
            int i = fenRUD_service.getTableDonnees().getSelectedRow();
            if(i>=0){
                //
            }else
                JOptionPane.showMessageDialog(fenRUD_service, "Impossible de modifier, aucune donnée n'est sélectionée.", "Modification", JOptionPane.OK_OPTION);
        }
        else if(ae.getSource().equals(fenRUD_service.getBtnCleDocteur())){
            //
        }
        else if(ae.getSource().equals(fenRUD_service.getBtnUpdate())){
            //
        }
   
    }
    
    
}