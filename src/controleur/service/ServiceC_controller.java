
package controleur.service;

import controleur.MetaDataController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.MetaDataModel;
import model.Service;
import vue.service.FenC_service;

public class ServiceC_controller implements ActionListener, ServiceC_Interface {
    
    private Service modelService = new Service();
    private final FenC_service fenC_service = new FenC_service();

    public ServiceC_controller(Service s) {
        this.modelService = s;
        
        
        fenC_service.getBtnCleDocteur().addActionListener(this);
        fenC_service.getBtnBack().addActionListener(this);
        fenC_service.getBtnAnnuler().addActionListener(this);
        fenC_service.getBtnAide().addActionListener(this);
        fenC_service.getBtnValider().addActionListener(this);
        fenC_service.getComboBatiment().setModel(s.getModelBatiment());
        fenC_service.setVisible(true);
        fenC_service.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(fenC_service.getBtnBack())){
            fenC_service.dispose();
            ServiceController sc = new ServiceController(modelService);
        }
        else if(ae.getSource() == fenC_service.getBtnAnnuler()){
            fenC_service.getFieldCode().setText("");
            fenC_service.getFieldNom().setText("");
            fenC_service.getComboBatiment().setSelectedItem(0);
            fenC_service.getFieldCleDocteur().setText("");
        }
        else if(ae.getSource() == fenC_service.getBtnAide()){
            JOptionPane.showMessageDialog(null, "Débrouille toi !", "Aide création service ", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(ae.getSource() == fenC_service.getBtnCleDocteur()){
            MetaDataModel mdm = new MetaDataModel();
            MetaDataController mdc = new MetaDataController(mdm, 1);
        }
        else if(ae.getSource() == fenC_service.getBtnValider()){
            JOptionPane.showMessageDialog(null, "valider !", "valider ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
}