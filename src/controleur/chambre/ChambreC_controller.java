
package controleur.chambre;
import controleur.MetaDataController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Chambre;
import model.MetaDataModel;
import vue.chambre.FenC_chambre;

public class ChambreC_controller implements ActionListener, ChambreC_Interface{

    private Chambre modelChambre = new Chambre();
    public FenC_chambre fenC_chambre = new FenC_chambre();

    
    public ChambreC_controller(Chambre c) {
        this.modelChambre = c;
        fenC_chambre.getComboCodeServ().setModel(c.getModelCodeServ());
        
        fenC_chambre.getBtnCleInfirm().addActionListener(this);
        fenC_chambre.getBtnBack().addActionListener(this);
        fenC_chambre.getBtnAnnuler().addActionListener(this);
        fenC_chambre.getBtnAide().addActionListener(this);
        fenC_chambre.getBtnValider().addActionListener(this);
    
        fenC_chambre.setVisible(true);
        fenC_chambre.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(fenC_chambre.getBtnBack())){
            fenC_chambre.dispose();
            ChambreController ac = new ChambreController(modelChambre);
        }
        else if(ae.getSource().equals(fenC_chambre.getBtnAnnuler())){
            fenC_chambre.getSpinNumChambre().setValue(0);
            fenC_chambre.getFieldCleInfirm().setText("");
            fenC_chambre.getSpinNumLit().setValue(0);
        }
        else if(ae.getSource().equals(fenC_chambre.getBtnAide())){
            JOptionPane.showMessageDialog(null, "Débrouille toi !", "Aide création chambre", JOptionPane.PLAIN_MESSAGE);
        }
        else if(ae.getSource().equals(fenC_chambre.getBtnValider())){
            
            
        }
        else if(ae.getSource().equals(fenC_chambre.getBtnCleInfirm())){
            MetaDataModel mdm = new MetaDataModel();
            MetaDataController mdc = new MetaDataController(mdm, 2);
             
            
        }
        
    }

    @Override
    public boolean isnotEmpty() {
        return false;
    }

    
}