
package controleur.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Service;
import vue.service.FenC_service;

public class ServiceC_controller implements ActionListener{
    
    private Service modelService = new Service();
    private final FenC_service fenC_service = new FenC_service();

    public ServiceC_controller(Service s) {
        this.modelService = s;
        
        fenC_service.setVisible(true);
        fenC_service.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}