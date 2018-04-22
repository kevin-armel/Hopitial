
package controleur.chambre;
import controleur.MetaDataController;
import static controleur.MetaDataController.cleSurveillant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Chambre;
import model.MetaDataModel;
import vue.chambre.FenC_chambre;

public class ChambreC_controller implements ActionListener, ChambreC_Interface{

    private Chambre modelChambre = new Chambre();//creation du model de la chambre 
    public FenC_chambre fenC_chambre = new FenC_chambre();//creation d'une nouvelle fenetre chambre 

    /**
     * Constructeur par defaut, avec parametre 
     * @param c Passage en paramètre du modele qui sera utilisé
     */
    public ChambreC_controller(Chambre c) {
        this.modelChambre = c; //affectation du model chambre à la variable c 
        fenC_chambre.getComboCodeServ().setModel(c.getModelCodeServ()); //recuperation du code service
        
        fenC_chambre.getBtnCleInfirm().addActionListener(this); //mise sur ecoute du bouton clé infermier
        fenC_chambre.getBtnBack().addActionListener(this); //mise sur ecoute du bouton retour 
        fenC_chambre.getBtnAnnuler().addActionListener(this); //mise sur ecoute du bouton annuler
        fenC_chambre.getBtnAide().addActionListener(this); //mise sur ecoute du bouton aide
        fenC_chambre.getBtnValider().addActionListener(this); //mise sur ecoute du bouton valider
    
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
            fenC_chambre.getSpinNumChambre().setValue(0);//tout les champs du formulaire à remplir sont effacé 
            fenC_chambre.getFieldCleInfirm().setText("");
            fenC_chambre.getSpinNumLit().setValue(0);
        }
        else if(ae.getSource().equals(fenC_chambre.getBtnAide())){
            JOptionPane.showMessageDialog(null, "Veuillez suivre les instructions suivantes svp :\n\n1.Remplissez tous les champs\n2.Cliquez sur le bouton valider\n3.Si vous voulez supprimer les données saisis, cliquez sur le bouton annuler", "Aide création chambre", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(ae.getSource().equals(fenC_chambre.getBtnValider())){//losque le bouton valider est activé, les données saisis prise en compte 
            int num = Integer.parseInt(fenC_chambre.getSpinNumChambre().getValue().toString());
            int lit = Integer.parseInt(fenC_chambre.getSpinNumLit().getValue().toString());
            String code = fenC_chambre.getComboCodeServ().getSelectedItem().toString();
            if(modelChambre.insertData(num, code ,cleSurveillant, lit)){
                JOptionPane.showMessageDialog(fenC_chambre, "L'ajout de la chambre s'est effectué avec succès.", "Ajout de chambre", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        else if(ae.getSource().equals(fenC_chambre.getBtnCleInfirm())){//losque le bouton clé infirmier est activé, la clé infirmier est generer depuis la bdd
            MetaDataModel mdm = new MetaDataModel();
            MetaDataController mdc = new MetaDataController(mdm, 2); //controleur prend en compte le model 
             
            
        }
        
    }

    @Override
    public boolean isnotEmpty() {
        return false;
    }

    
}