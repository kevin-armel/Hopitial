
package controleur.employe;

import model.Employe;
import vue.employe.FenRep_employe;


public class EmployeRep_controller implements EmployeRep_Interface {
 
    private Employe modelEmploye = new Employe();
    private final FenRep_employe fenRep_employe = new FenRep_employe();

    public EmployeRep_controller(Employe e) {
        this.modelEmploye = e;
        fenRep_employe.setVisible(true);

    }
    
    
}
