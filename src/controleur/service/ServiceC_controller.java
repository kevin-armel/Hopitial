
package controleur.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Service;
import vue.service.FenC_service;

public class ServiceC_controller implements ActionListener, ServiceC_Interface {
    
    private Service modelService = new Service();
    private final FenC_service fenC_service = new FenC_service();

    public ServiceC_controller(Service s) {
        this.modelService = s;
        
        fenC_service.setVisible(true);
        fenC_service.repaint();
        
        fenC_service.getbtnAnnuler().addActionListener(this);
        fenC_service.getbtnAide().addActionListener(this);
        fenC_service.getbtnValider().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fenC_service.getbtnAnnuler()){
            fenC_service.getcode().setText("");
            fenC_service.getnom().setText("");
            fenC_service.getbatiment().setText("");
            fenC_service.getdirecteur().setValue(0);
        }
        if(e.getSource() == fenC_service.getbtnAide()){
            JOptionPane.showMessageDialog(null, "Débrouille toi !", "Aide création service ", JOptionPane.PLAIN_MESSAGE);
        }
        if(e.getSource() == fenC_service.getbtnValider()){
            JOptionPane.showMessageDialog(null, "valider !", "valider ", JOptionPane.PLAIN_MESSAGE);
        }
        
    }
    
    
}