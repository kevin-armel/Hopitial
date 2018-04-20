
package controleur.service;

import controleur.AccueilController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Accueil;
import model.Service;
import vue.Fen_accueil;
import vue.service.FenC_service;
import vue.service.FenRUD_service;
import vue.service.FenRep_service;
import vue.service.Fen_service;


public class ServiceController implements ActionListener, ServiceInterface {

    private Service modelService = new Service();
    private Fen_service fen_service = new Fen_service();
    private final FenC_service fenC_service = new FenC_service();
    private final FenRUD_service fenRUD_service = new FenRUD_service();
    private final FenRep_service fenRep_employe = new FenRep_service();
    private final Fen_accueil fen_accueil = new Fen_accueil();
    
    public ServiceController(Service s) {
        this.modelService = s;
        
        fen_service.setVisible(true);
        fen_service.repaint();
        fen_service.getBtnBack().addActionListener(this);
        fen_service.getBtnC_servic().addActionListener(this);
        fen_service.getBtnRUD_servic().addActionListener(this);
        fen_service.getBtnRep_servic().addActionListener(this);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Service");
        if(ae.getSource() == fen_service.getBtnBack()){
            fen_service.dispose();
            Accueil a = new Accueil();
            AccueilController ac = new AccueilController(a, false);
        }else if(ae.getSource() == fen_service.getBtnC_servic()){
            fen_service.setVisible(false);
            ServiceC_controller eCc = new ServiceC_controller(modelService);
        }else if(ae.getSource() == fen_service.getBtnRUD_servic()){
            fen_service.setVisible(false);
            ServiceRUD_controller eRUDc = new ServiceRUD_controller(modelService);
        }else if(ae.getSource() == fen_service.getBtnRep_servic()){
            fen_service.setVisible(false);
            ServiceRep_controller eRepc = new ServiceRep_controller(modelService);
        }
    }
    
}
