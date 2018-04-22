package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Recherche;
import vue.Fen_search;


public class SearchController implements ActionListener, SearchInterface {

    private final Fen_search fen_search = new Fen_search();
    private Recherche rechercheModel;
    
    
    public SearchController(Recherche r) {
        this.rechercheModel = r;
        configStart();
        //fen_search.getTableResultat().setModel(r.getModelDataEmploye());
        CellReadOnly(fen_search.getTableResultat());
        
        activerListener();
        fen_search.setVisible(true);
        fen_search.repaint();
        
    }
    
    public void hideFisrtColumn(){
        fen_search.getTableResultat().getColumnModel().getColumn(0).setMaxWidth(0);
        fen_search.getTableResultat().getColumnModel().getColumn(0).setMinWidth(0);
        fen_search.getTableResultat().getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    public void configStart(){
        if(fen_search.getRadioEmploy().isSelected()){
            fen_search.getTableResultat().setModel(rechercheModel.getModelDataEmploye());
            hideFisrtColumn();
            
        }else 
            if(fen_search.getRadioChambre().isSelected()){
            fen_search.getTableResultat().setModel(rechercheModel.getModelDataChambre());
        }else 
            if(fen_search.getRadioMalade().isSelected()){
            fen_search.getTableResultat().setModel(rechercheModel.getModelDataMalade());
            hideFisrtColumn();
        }else 
            if(fen_search.getRadioHospitalisation().isSelected()){
            
            fen_search.getTableResultat().setModel(rechercheModel.getModelDataHospitalisation());
        }else 
            if(fen_search.getRadioService().isSelected()){
            
            fen_search.getTableResultat().setModel(rechercheModel.getModelDataService());
        }else 
            if(fen_search.getRadioSoigne().isSelected()){
            
            fen_search.getTableResultat().setModel(rechercheModel.getModelDataSoigne());
        }
        fen_search.pack();
        fen_search.repaint();
    }
    
    public void CellReadOnly(JTable table){
        for (int i=0; i < table.getColumnCount(); i++){
            Class<?> col_class = table.getColumnClass(i);
            table.setDefaultEditor(col_class, null);
        }
    } 
    
    private void activerListener(){
        fen_search.getBtnAide().addActionListener(this);
        fen_search.getBtnRecherche().addActionListener(this);
        fen_search.getRadioEmploy().addActionListener(this);
        fen_search.getRadioChambre().addActionListener(this);
        fen_search.getRadioHospitalisation().addActionListener(this);
        fen_search.getRadioMalade().addActionListener(this);
        fen_search.getRadioSoigne().addActionListener(this);
        fen_search.getRadioService().addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource().equals(fen_search.getBtnAide())){
            JOptionPane.showMessageDialog(null, "Pour effectuer une recherche, vous devez entrer l'expression recherchée. "
                        + "\nEt par la suite, si vous connaissez où effectuer votre requête, \nvous sélectionnez dirrectement l'environnement de recherche, "
                        + "mais si vous ne connaissez \npas dans quel classe appartient votre expression, sélectionnez toutes les cases.", "Aide de recherche", JOptionPane.PLAIN_MESSAGE);
        }
        else if(ae.getSource().equals(fen_search.getBtnRecherche())){
            if(fen_search.getRadioEmploy().isSelected()){
                rechercheEmploye();
            }else if(fen_search.getRadioChambre().isSelected()){
                rechercheChambre();
            }else if(fen_search.getRadioMalade().isSelected()){
                rechercheMalade();
            }else if(fen_search.getRadioService().isSelected()){
                rechercheService();
            }else if(fen_search.getRadioSoigne().isSelected()){
                rechercheSoigne();
            }else if(fen_search.getRadioHospitalisation().isSelected()){
                rechercheHospitalisation();
            }
            
        }
        else if(ae.getSource().equals(fen_search.getRadioEmploy())){
            fen_search.getTableResultat().repaint();
            fen_search.getTableResultat().clearSelection();
            configStart();
        }else if(ae.getSource().equals(fen_search.getRadioMalade())){
            fen_search.getTableResultat().repaint();
            fen_search.getTableResultat().clearSelection();
            configStart();
        }else if(ae.getSource().equals(fen_search.getRadioChambre())){
            fen_search.getTableResultat().repaint();
            fen_search.getTableResultat().clearSelection();
            configStart();
        }else if(ae.getSource().equals(fen_search.getRadioHospitalisation())){
            fen_search.getTableResultat().repaint();
            fen_search.getTableResultat().clearSelection();
            configStart();
        }else if(ae.getSource().equals(fen_search.getRadioService())){
            fen_search.getTableResultat().repaint();
            fen_search.getTableResultat().clearSelection();
            configStart();
        }else if(ae.getSource().equals(fen_search.getRadioSoigne())){
            fen_search.getTableResultat().repaint();
            fen_search.getTableResultat().clearSelection();
            configStart();
        }
        
    }
    
    public void rechercheEmploye(){
        String expression = fen_search.getFieldRecherche().getText();
        DefaultTableModel model = new DefaultTableModel();
        model = rechercheModel.findExpressionE(expression);
        fen_search.getTableResultat().setModel(model);
        hideFisrtColumn();
        fen_search.repaint();
    }
    
    public void rechercheChambre(){
        String expression = fen_search.getFieldRecherche().getText();
        DefaultTableModel model = new DefaultTableModel();
        model = rechercheModel.findExpressionC(expression);
        fen_search.getTableResultat().setModel(model);
        fen_search.repaint();
    }
    
    public void rechercheMalade(){
        String expression = fen_search.getFieldRecherche().getText();
        DefaultTableModel model = new DefaultTableModel();
        model = rechercheModel.findExpressionM(expression);
        fen_search.getTableResultat().setModel(model);
        hideFisrtColumn();
        fen_search.repaint();
    }
    
    public void rechercheSoigne(){
        String expression = fen_search.getFieldRecherche().getText();
        DefaultTableModel model = new DefaultTableModel();
        model = rechercheModel.findExpressionSo(expression);
        fen_search.getTableResultat().setModel(model);
        fen_search.repaint();
    }
    
    public void rechercheHospitalisation(){
        String expression = fen_search.getFieldRecherche().getText();
        DefaultTableModel model = new DefaultTableModel();
        model = rechercheModel.findExpressionH(expression);
        fen_search.getTableResultat().setModel(model);
        fen_search.repaint();
    }
    
    public void rechercheService(){
        String expression = fen_search.getFieldRecherche().getText();
        DefaultTableModel model = new DefaultTableModel();
        model = rechercheModel.findExpressionSe(expression);
        fen_search.getTableResultat().setModel(model);
        fen_search.repaint();
    }
}
