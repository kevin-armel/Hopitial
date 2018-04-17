
package controleur.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Service;
import vue.service.FenRUD_service;

public class ServiceRUD_controller implements ActionListener, ServiceRUD_Interface {
    
    private Service modelService = new Service();
    private final FenRUD_service fenRUD_service = new FenRUD_service();

    public ServiceRUD_controller(Service s) {
        this.modelService = s;
        
        fenRUD_service.setVisible(true);
        fenRUD_service.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}