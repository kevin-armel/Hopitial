
package controleur.chambre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Chambre;
import vue.chambre.FenC_chambre;

public class ChambreRUD_controller implements ActionListener, ChambreRUD_Interface{
    
    
    private Chambre modelChambre = new Chambre();
    private final FenC_chambre fenC_malade = new FenC_chambre();

    public ChambreRUD_controller(Chambre c) {
        this.modelChambre = c;
        fenC_malade.repaint();
        fenC_malade.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}