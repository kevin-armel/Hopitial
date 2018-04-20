package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Recherche;
import vue.Fen_search;


public class SearchController implements ActionListener, SearchInterface {

    private final Fen_search fen_search = new Fen_search();
    private Recherche rechercheModel;
    
    
    public SearchController(Recherche r) {
        this.rechercheModel = r;
        activerListener();
        
        fen_search.setVisible(true);
        fen_search.repaint();
        
    }
    
    private void activerListener(){
        fen_search.getBtnAide().addActionListener(this);
        fen_search.getBtnRecherche().addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource().equals(fen_search.getBtnAide())){
            JOptionPane.showMessageDialog(null, "Pour effectuer une recherche, vous devez entrer l'expression recherchée. "
                        + "\nEt par la suite, si vous connaissez où effectuer votre requête, \nvous sélectionnez dirrectement l'environnement de recherche, "
                        + "mais si vous ne connaissez \npas dans quel classe appartient votre expression, sélectionnez toutes les cases.", "Aide de recherche", JOptionPane.PLAIN_MESSAGE);
        }
        else if(ae.getSource().equals(fen_search.getBtnRecherche())){
            System.out.println("recherche");
            
        }
    }
    
}
