
package controleur.chambre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Chambre;
import vue.chambre.FenRep_chambre;

public class ChambreRep_controller implements ActionListener{

    
    private Chambre modelChambre = new Chambre();
    private final FenRep_chambre fenRep_chambre = new FenRep_chambre();

    public ChambreRep_controller(Chambre c) {
        this.modelChambre = c;
        fenRep_chambre.repaint();
        fenRep_chambre.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}