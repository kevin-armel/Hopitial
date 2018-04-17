
package controleur.chambre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Chambre;
import vue.chambre.FenC_chambre;

public class ChambreC_controller implements ActionListener, ChambreC_Interface{

    private Chambre modelChambre = new Chambre();
    private final FenC_chambre fenC_chambre = new FenC_chambre();

    public ChambreC_controller(Chambre c) {
        this.modelChambre = c;
        fenC_chambre.repaint();
        fenC_chambre.setVisible(true);
        
        fenC_chambre.getbtnAnnuler().addActionListener(this);
        fenC_chambre.getbtnAide().addActionListener(this);
        fenC_chambre.getbtnValider().addActionListener(this);
    
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == fenC_chambre.getbtnAnnuler()){
            fenC_chambre.getnoCh().setValue(0);
            fenC_chambre.getnoSur().setValue(0);
            fenC_chambre.getnoLit().setValue(0);
        }
        if(ae.getSource() == fenC_chambre.getbtnAide()){
            JOptionPane.showMessageDialog(null, "Débrouille toi !", "Aide création chambre", JOptionPane.PLAIN_MESSAGE);
        }
        if(ae.getSource() == fenC_chambre.getbtnValider()){
            
            
            
            
            
            //JOptionPane.showMessageDialog(null, "Bouton Validé Ok !", "Aide création chambre", JOptionPane.PLAIN_MESSAGE);
        }
        
    }

    @Override
    public boolean isnotEmpty() {
        return false;
    }
    
    
}