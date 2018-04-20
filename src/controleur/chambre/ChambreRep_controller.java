
package controleur.chambre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Chambre;
import vue.chambre.FenRep_chambre;

public class ChambreRep_controller implements ActionListener, ChambreRep_Interface{

    
    private Chambre modelChambre = new Chambre();
    private final FenRep_chambre fenRep_chambre = new FenRep_chambre();

    public ChambreRep_controller(Chambre c) {
        this.modelChambre = c;
        
        fenRep_chambre.getBtnBack().addActionListener(this);
        
        fenRep_chambre.repaint();
        fenRep_chambre.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(fenRep_chambre.getBtnBack())){
            fenRep_chambre.dispose();
            ChambreController ac = new ChambreController(modelChambre);
        }
    }
    
    
}