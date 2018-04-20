
package controleur.malade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Malade;
import vue.malade.FenRep_malade;


public class MaladeRep_controller implements ActionListener, MaladeRep_Interface{
    
    private Malade modelMalade = new Malade();
    private final FenRep_malade fenRep_malade = new FenRep_malade();

    public MaladeRep_controller(Malade m) {
        this.modelMalade = m;
        
        fenRep_malade.getBtnBack().addActionListener(this);
        fenRep_malade.setVisible(true);
        fenRep_malade.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(fenRep_malade.getBtnBack())){
            fenRep_malade.dispose();
            MaladeController mc = new MaladeController(modelMalade);
        }
    }
    
    
}