
package controleur.chambre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Chambre;
import vue.chambre.FenC_chambre;

public class ChambreC_controller implements ActionListener{

    private Chambre modelChambre = new Chambre();
    private final FenC_chambre fenC_chambre = new FenC_chambre();

    public ChambreC_controller(Chambre c) {
        this.modelChambre = c;
        fenC_chambre.repaint();
        fenC_chambre.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}