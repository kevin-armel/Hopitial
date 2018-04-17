
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
        
        fenC_malade.getbtnAnnuler().addActionListener(this);
        fenC_malade.getbtnAide().addActionListener(this);
        fenC_malade.getbtnValider().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == fenC_malade.getbtnAnnuler()){
            viderChamps();
        }
        if(ae.getSource() == fenC_malade.getbtnAide()){
            JOptionPane.showMessageDialog(null, "Débrouille toi !", "Aide création malade", JOptionPane.PLAIN_MESSAGE);
        }
        if(ae.getSource() == fenC_malade.getbtnValider()){
            JOptionPane.showMessageDialog(null, "Bouton Validé Ok !", "Aide création malade", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    @Override
    public void viderChamps(){
        fenC_malade.getnum().setValue(0);
            fenC_malade.getno00().setValue(0);
            fenC_malade.getno11().setValue(0);
            fenC_malade.getno22().setValue(0);
            fenC_malade.getno33().setValue(0);
            fenC_malade.getno44().setValue(0);
            fenC_malade.gettail().setValue(0);
            fenC_malade.getpoids().setValue(0);
            fenC_malade.getage().setValue(0);
            fenC_malade.getsex().setText("");
            fenC_malade.getnom().setText("");
            fenC_malade.getpre().setText("");
            fenC_malade.getadd().setText("");
            fenC_malade.getmut().setText("");
    }
    
}
