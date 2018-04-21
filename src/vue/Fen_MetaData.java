
package vue;


import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Fen_MetaData extends JDialog {
    
    private final JButton btnValider = new JButton("Valider"); //creation bouton valider
    private final JButton btnAnnuler = new JButton("Annuler"); //creation bouton annuler
    private final JLabel labelTitre = new JLabel("exprime ce qui est appele"); //creation label
    private final JTable tableDonnee = new JTable(20, 5); //creation tableau
    
    public Fen_MetaData(){
        
        tableDonnee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JPanel panelGeneral = new JPanel(new BorderLayout(50,50)); //creation du panel general
        JPanel panelBas = new JPanel(new BorderLayout(0,100)); //creation du panel bas
                
        panelBas.add(btnValider, BorderLayout.WEST); //ajout bouton valider au panel bas 
        panelBas.add(btnAnnuler, BorderLayout.EAST); //ajout bouton annuller au panel bas
        
        panelGeneral.add(labelTitre, BorderLayout.NORTH); //ajout label titre au pane general 
        panelGeneral.add(new JScrollPane(tableDonnee), BorderLayout.CENTER); //ajout tableau au panel general 
        panelGeneral.add(panelBas, BorderLayout.SOUTH); //ajout panel bas au panel general
        
        //methodes
        setContentPane(panelGeneral); //methode affichant l'ensemble du contenu affecté au panel general 
        setTitle("Fen_MetaData"); //titre panel general
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //fermeture juste de la fenetre en question
        
    }   
    
    //getteurs
    public JButton getBtnValider() {
        return btnValider;
    }

    public JButton getBtnAnnuler() {
        return btnAnnuler;
    }

    public JLabel getLabelTitre() {
        return labelTitre;
    }

    public JTable getTableDonnee() {
        return tableDonnee;
    }


    
}