
package controleur.malade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Malade;
import vue.malade.FenRUD_malade;


public class MaladeRUD_controller implements ActionListener, MaladeRUD_Interface{
    
    private Malade modelMalade = new Malade();
    private final FenRUD_malade fenRUD_malade = new FenRUD_malade();

    public MaladeRUD_controller(Malade m) {
        this.modelMalade = m;
        
        fenRUD_malade.setVisible(true);
        fenRUD_malade.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
