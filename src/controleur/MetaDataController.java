
package controleur;

import controleur.chambre.ChambreC_controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.MetaDataModel;
import vue.Fen_MetaData;

public class MetaDataController implements ActionListener, MetaDataInterface{ //implementation 
    
    private Fen_MetaData fen_MetaData = new Fen_MetaData(); //déclaration d'une new fen
    private MetaDataModel modelMetaData;
    
    
    public MetaDataController(MetaDataModel mMD) {
        this.modelMetaData = mMD;
        fen_MetaData.setVisible(true);
        fen_MetaData.getBtnValider().addActionListener(this);
        
    }
    @Override
    public String getCleInfirmier(String cle){
        return cle;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource().equals(fen_MetaData.getBtnValider())){ //losrque le buton valider est actionné

            //ChambreC_controller.isCLose = "je suis la cle";

            ChambreC_controller.fenC_chambre.getLabCleInfirm().setText(""); //affichage du nom de la varible 
            ChambreC_controller.fenC_chambre.repaint();
            fen_MetaData.setVisible(false);
        }
    }
}
