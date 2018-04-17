
package controleur.malade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Malade;
import vue.malade.FenC_malade;


public class MaladeC_controller implements ActionListener{
    
    private Malade modelMalade = new Malade();
    private final FenC_malade fenC_malade = new FenC_malade();

    public MaladeC_controller(Malade m) {
        this.modelMalade = m;
        fenC_malade.repaint();
        fenC_malade.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
