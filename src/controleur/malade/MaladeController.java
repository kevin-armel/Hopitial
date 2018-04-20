
package controleur.malade;

import controleur.AccueilController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Accueil;
import model.Malade;
import vue.Fen_accueil;
import vue.malade.FenC_malade;
import vue.malade.FenRUD_malade;
import vue.malade.FenRep_malade;
import vue.malade.Fen_malade;


public class MaladeController implements ActionListener{

    private Malade modelMalade = new Malade();
    private Fen_malade fen_malade = new Fen_malade();
    private final FenC_malade fenC_ = new FenC_malade();
    private final FenRUD_malade fenRUD_employe = new FenRUD_malade();
    private final FenRep_malade fenRep_employe = new FenRep_malade();
    private final Fen_accueil fen_accueil = new Fen_accueil();
    
    public MaladeController(Malade m) {
        this.modelMalade = m;
        
        fen_malade.setVisible(true);
        fen_malade.repaint();
        fen_malade.getBtnBack().addActionListener(this);
        fen_malade.getBtnC_malad().addActionListener(this);
        fen_malade.getBtnRUD_malad().addActionListener(this);
        fen_malade.getBtnRep_malad().addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == fen_malade.getBtnBack()){
            fen_malade.dispose();
            Accueil a = new Accueil();
            AccueilController ac = new AccueilController(a, false);
        }else if(ae.getSource() == fen_malade.getBtnC_malad()){
            fen_malade.setVisible(false);
            MaladeC_controller mCc = new MaladeC_controller(modelMalade);
        }else if(ae.getSource() == fen_malade.getBtnRUD_malad()){
            fen_malade.setVisible(false);
            MaladeRUD_controller mRUDc = new MaladeRUD_controller(modelMalade);
        }else if(ae.getSource() == fen_malade.getBtnRep_malad()){
            fen_malade.setVisible(false);
            MaladeRep_controller mRepc = new MaladeRep_controller(modelMalade);
        }
    }
    
}
