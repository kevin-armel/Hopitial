
package controleur.malade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Malade;
import vue.malade.FenC_malade;


public class MaladeC_controller implements ActionListener, MaladeC_Interface{
    
    private Malade modelMalade = new Malade();
    private final FenC_malade fenC_malade = new FenC_malade();

    public MaladeC_controller(Malade m) {
        this.modelMalade = m;
        fenC_malade.repaint();
        fenC_malade.setVisible(true);
        
        fenC_malade.getBtnBack().addActionListener(this);
        fenC_malade.getBtnAnnuler().addActionListener(this);
        fenC_malade.getBtnAide().addActionListener(this);
        fenC_malade.getBtnValider().addActionListener(this);
    }

    @Override
    public void viderChamps(){
        fenC_malade.getnum().setValue(0);
            fenC_malade.getno00().setValue(0);
            fenC_malade.getno11().setValue(0);
            fenC_malade.getno22().setValue(0);
            fenC_malade.getno33().setValue(0);
            fenC_malade.getno44().setValue(0);
            fenC_malade.getSpinTaille().setValue(0);
            fenC_malade.getSpinPoids().setValue(0);
            fenC_malade.getSpinAge().setValue(0);
            fenC_malade.getComboSexe().setSelectedIndex(0);
            fenC_malade.getFieldNom().setText("");
            fenC_malade.getFieldPrenom().setText("");
            fenC_malade.getFieldAddresse().setText("");
            fenC_malade.getComboMutuelle().setSelectedIndex(0);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(fenC_malade.getBtnBack())){
            fenC_malade.dispose();
            MaladeController mc = new MaladeController(modelMalade);
        }
        else if(ae.getSource() == fenC_malade.getBtnAnnuler()){
            viderChamps();
        }
        if(ae.getSource() == fenC_malade.getBtnAide()){
            JOptionPane.showMessageDialog(null, "Débrouille toi !", "Aide création malade", JOptionPane.PLAIN_MESSAGE);
        }
        if(ae.getSource() == fenC_malade.getBtnValider()){
            JOptionPane.showMessageDialog(null, "Bouton Validé Ok !", "Aide création malade", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
}
