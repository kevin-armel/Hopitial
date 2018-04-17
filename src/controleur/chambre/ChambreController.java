
package controleur.chambre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Chambre;
import vue.Fen_accueil;
import vue.chambre.FenC_chambre;
import vue.chambre.FenRUD_chambre;
import vue.chambre.FenRep_chambre;
import vue.chambre.Fen_chambre;


public class ChambreController implements ActionListener{

    private Chambre modelChambre = new Chambre();
    private Fen_chambre fen_chambre = new Fen_chambre();
    private final FenC_chambre fenC_chambre= new FenC_chambre();
    private final FenRUD_chambre fenRUD_chambre = new FenRUD_chambre();
    private final FenRep_chambre fenRep_chambre = new FenRep_chambre();
    private final Fen_accueil fen_accueil = new Fen_accueil();
    
    public ChambreController(Chambre c) {
        this.modelChambre = c;
        fen_chambre.setVisible(true);
        
        fen_chambre.getBtnBack().addActionListener(this);
        fen_chambre.getBtnC_chambre().addActionListener(this);
        fen_chambre.getBtnRUD_chambre().addActionListener(this);
        fen_chambre.getBtnRep_chambre().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Service");
        if(ae.getSource() == fen_chambre.getBtnBack()){
            fen_chambre.setVisible(false);
            fen_accueil.setVisible(true);
            fen_accueil.repaint();
        }else if(ae.getSource() == fen_chambre.getBtnC_chambre()){
            fen_chambre.setVisible(false);
            ChambreC_controller eCc = new ChambreC_controller(modelChambre);
        }else if(ae.getSource() == fen_chambre.getBtnRUD_chambre()){
            fen_chambre.setVisible(false);
            ChambreRUD_controller eRUDc = new ChambreRUD_controller(modelChambre);
        }else if(ae.getSource() == fen_chambre.getBtnRep_chambre()){
            fen_chambre.setVisible(false);
            ChambreRep_controller eRepc = new ChambreRep_controller(modelChambre);
        }
    }
    
}
