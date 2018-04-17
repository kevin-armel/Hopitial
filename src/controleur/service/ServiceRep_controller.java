
package controleur.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Service;
import vue.service.FenRep_service;


public class ServiceRep_controller implements ActionListener, ServiceRep_Interface {

    private Service modelService = new Service();
    private final FenRep_service fenRep_service = new FenRep_service();

    public ServiceRep_controller(Service s) {
        this.modelService = s;
        
        fenRep_service.setVisible(true);
        fenRep_service.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}