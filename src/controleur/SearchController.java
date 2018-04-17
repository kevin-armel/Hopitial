package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Recherche;


public class SearchController implements ActionListener{

    private Recherche rechercheModel;
    
    public SearchController(Recherche r) {
        this.rechercheModel = r;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
