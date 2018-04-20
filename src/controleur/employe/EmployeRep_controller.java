
package controleur.employe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Employe;
import vue.employe.FenRep_employe;


public class EmployeRep_controller implements EmployeRep_Interface, ActionListener {
 
    private Employe modelEmploye = new Employe();
    private final FenRep_employe fenRep_employe = new FenRep_employe();

    public EmployeRep_controller(Employe e) {
        this.modelEmploye = e;
        fenRep_employe.getBtnBack().addActionListener(this);
        
        fenRep_employe.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(fenRep_employe.getBtnBack())){
            fenRep_employe.dispose();
            EmployerController ac = new EmployerController(modelEmploye);
        }
    }
    
    
}
