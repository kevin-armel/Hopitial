
package controleur.chambre;
import controleur.MetaDataController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Chambre;
import model.MetaDataModel;
import vue.chambre.FenC_chambre;

public class ChambreC_controller implements ActionListener, ChambreC_Interface{

    public static String isCLose;
    private Chambre modelChambre = new Chambre();
    public static FenC_chambre fenC_chambre = new FenC_chambre();

    public ChambreC_controller(Chambre c) {
        this.modelChambre = c;
        fenC_chambre.repaint();
        fenC_chambre.setVisible(true);
        
        fenC_chambre.getbtnAnnuler().addActionListener(this); //bouton annuler sur ecoute 
        fenC_chambre.getbtnAide().addActionListener(this); //bouton aide sur ecoute
        fenC_chambre.getbtnValider().addActionListener(this); //bouton valider sur ecoute
        fenC_chambre.getBtnAffectInf().addActionListener(this); //bouton affecter infirmier sur ecoute
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == fenC_chambre.getbtnAnnuler()){
            fenC_chambre.getnoCh().setValue(0);
            fenC_chambre.getnoLit().setValue(0);
        }
        else if(ae.getSource() == fenC_chambre.getbtnAide()){
            JOptionPane.showMessageDialog(null, "Débrouille toi !", "Aide création chambre", JOptionPane.PLAIN_MESSAGE);
        }
        else if(ae.getSource() == fenC_chambre.getbtnValider()){
            //JOptionPane.showMessageDialog(null, "Bouton Validé Ok !", "Aide création chambre", JOptionPane.PLAIN_MESSAGE);
        }
        else if(ae.getSource().equals(fenC_chambre.getBtnAffectInf())){ //losque bouton affecter infirmier activé
            MetaDataModel mdm = new MetaDataModel(); //créeation d'un model 
            MetaDataController mdc= new MetaDataController(mdm); //affectation du odel créé au controleur 
            fenC_chambre.repaint();
        }
        
    }

    @Override
    public boolean isnotEmpty() {
        return false;
    }
    
    
}