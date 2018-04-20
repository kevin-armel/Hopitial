
package controleur.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
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
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(fenRUD_service.getBtnBack())){
            fenRUD_service.dispose();
            ServiceController sc = new ServiceController(modelService);
        }
    }
    
    
}