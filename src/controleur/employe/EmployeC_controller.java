
package controleur.employe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Employe;
import vue.employe.FenC_employe;


public class EmployeC_controller implements ActionListener{
    private Employe modelEmploye = new Employe();
    private final FenC_employe fenC_employe = new FenC_employe();

    public EmployeC_controller(Employe e) {
        this.modelEmploye = e;
        fenC_employe.repaint();
        fenC_employe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //
    }
}
