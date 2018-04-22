
package controleur.malade;

import controleur.SearchController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Malade;
import model.Recherche;
import vue.malade.FenRUD_malade;


public class MaladeRUD_controller implements ActionListener, MaladeRUD_Interface{
    
    private Malade modelMalade = new Malade();
    private final FenRUD_malade fenRUD_malade = new FenRUD_malade();

    public MaladeRUD_controller(Malade m) {
        this.modelMalade = m;
        fenRUD_malade.getTableDonnees().setModel(m.getModelDataTable());
        fenRUD_malade.getComboSexe().setModel(m.getModelSexe());
        fenRUD_malade.getComboMutuelle().setModel(m.getModelMutuelle());
        
        fenRUD_malade.getTableDonnees().getColumnModel().getColumn(0).setMaxWidth(0);
        fenRUD_malade.getTableDonnees().getColumnModel().getColumn(0).setMinWidth(0);
        fenRUD_malade.getTableDonnees().getColumnModel().getColumn(0).setPreferredWidth(0);
        
        setCellReadOnly(fenRUD_malade.getTableDonnees());
        
        fenRUD_malade.getBtnAide().addActionListener(this);
        fenRUD_malade.getBtnBack().addActionListener(this);
        fenRUD_malade.getBtnModifier().addActionListener(this);
        fenRUD_malade.getBtnRaz().addActionListener(this);
        fenRUD_malade.getBtnRecherche().addActionListener(this);
        fenRUD_malade.getBtnReporting().addActionListener(this);
        fenRUD_malade.getBtnSupression().addActionListener(this);
        fenRUD_malade.getBtnUpdate().addActionListener(this);
        fenRUD_malade.getCheckOnModif().addActionListener(this);
        
        fenRUD_malade.setVisible(true);
        fenRUD_malade.repaint();
    }
    
    @Override
    public void setCellReadOnly(JTable table){
        for (int i=0; i < table.getColumnCount(); i++){
            Class<?> col_class = table.getColumnClass(i);
            table.setDefaultEditor(col_class, null);
        }
    }
    
    public void activeModif(){
        fenRUD_malade.getFieldNom().setEnabled(true);
        fenRUD_malade.getFieldPrenom().setEnabled(true);
        fenRUD_malade.getFieldAdresse().setEnabled(true);
        fenRUD_malade.getFieldTel().setEnabled(true);
        fenRUD_malade.getFieldAge().setEnabled(true);
        fenRUD_malade.getComboSexe().setEnabled(true);
        fenRUD_malade.getComboMutuelle().setEnabled(true);
        fenRUD_malade.getSpinPoids().setEnabled(true);
        fenRUD_malade.getSpinTaille().setEnabled(true);
        fenRUD_malade.getBtnModifier().setEnabled(true);
    }
    
    public void desactiveModif(){
        fenRUD_malade.getFieldNom().setEnabled(false);
        fenRUD_malade.getFieldPrenom().setEnabled(false);
        fenRUD_malade.getFieldAdresse().setEnabled(false);
        fenRUD_malade.getFieldTel().setEnabled(false);
        fenRUD_malade.getFieldAge().setEnabled(false);
        fenRUD_malade.getComboSexe().setEnabled(false);
        fenRUD_malade.getComboMutuelle().setEnabled(false);
        fenRUD_malade.getSpinPoids().setEnabled(false);
        fenRUD_malade.getSpinTaille().setEnabled(false);
        fenRUD_malade.getBtnModifier().setEnabled(false);
    }
    
    public void videzChamp(){
        fenRUD_malade.getFieldNom().setText("");
        fenRUD_malade.getFieldPrenom().setText("");
        fenRUD_malade.getFieldAdresse().setText("");
        fenRUD_malade.getFieldTel().setText("");
        fenRUD_malade.getFieldAge().setText("");
        fenRUD_malade.getComboSexe().setSelectedIndex(0);
        fenRUD_malade.getComboMutuelle().setSelectedIndex(0);
        fenRUD_malade.getSpinPoids().setValue(0);
        fenRUD_malade.getSpinTaille().setValue(0);
        fenRUD_malade.getTableDonnees().clearSelection();
    }
    
        public void remplirFormModif(int posi){
        try {
            fenRUD_malade.getFieldNom().setText(modelMalade.getModelDataTable().getValueAt(posi, 1).toString());
            fenRUD_malade.getFieldPrenom().setText(modelMalade.getModelDataTable().getValueAt(posi, 2).toString());
            fenRUD_malade.getFieldAdresse().setText(modelMalade.getModelDataTable().getValueAt(posi, 8).toString());
            fenRUD_malade.getFieldTel().setText(modelMalade.getModelDataTable().getValueAt(posi, 7).toString());
            fenRUD_malade.getComboSexe().setSelectedItem(modelMalade.getModelDataTable().getValueAt(posi, 4));
            fenRUD_malade.getFieldAge().setText(modelMalade.getModelDataTable().getValueAt(posi, 3).toString());
            fenRUD_malade.getComboMutuelle().setSelectedItem(modelMalade.getModelDataTable().getValueAt(posi, 9));
            fenRUD_malade.getSpinTaille().setValue(Integer.parseInt(modelMalade.getModelDataTable().getValueAt(posi, 6).toString()));
            fenRUD_malade.getSpinPoids().setValue(Integer.parseInt(modelMalade.getModelDataTable().getValueAt(posi, 5).toString()));

            }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(fenRUD_malade.getBtnBack())){
            fenRUD_malade.dispose();
            MaladeController mc = new MaladeController(modelMalade);
        }
        else if(ae.getSource().equals(fenRUD_malade.getCheckOnModif())){
            if(fenRUD_malade.getCheckOnModif().isSelected())
                activeModif();
            else
                desactiveModif();
            fenRUD_malade.repaint();
        }
        else if(ae.getSource().equals(fenRUD_malade.getBtnAide())){
            //
        }
        else if(ae.getSource().equals(fenRUD_malade.getBtnRaz())){
            videzChamp();
        }
        else if(ae.getSource().equals(fenRUD_malade.getBtnRecherche())){
            Recherche r = new Recherche();
            SearchController sc = new SearchController(r);
        }
        else if(ae.getSource().equals(fenRUD_malade.getBtnModifier())){
            int i = fenRUD_malade.getTableDonnees().getSelectedRow();
            if(i>=0){
                remplirFormModif(i);
                fenRUD_malade.repaint();
            }else
                JOptionPane.showMessageDialog(fenRUD_malade, "Impossible de modifier, aucune donnée n'est sélectionée.", "Modification", JOptionPane.OK_OPTION);
        }
        else if(ae.getSource().equals(fenRUD_malade.getBtnReporting())){
            MaladeRep_controller mRc = new MaladeRep_controller(modelMalade);
        }
        else if(ae.getSource().equals(fenRUD_malade.getBtnSupression())){
            int i = fenRUD_malade.getTableDonnees().getSelectedRow();
            if(i>=0){
                int numero = Integer.parseInt(fenRUD_malade.getTableDonnees().getValueAt(i, 0).toString());
                if(modelMalade.deletedData(numero))
                    JOptionPane.showMessageDialog(fenRUD_malade, "La supression du malade s'est effectuée avec succès.", "Supression de chambre", JOptionPane.INFORMATION_MESSAGE);
            }else
                JOptionPane.showMessageDialog(fenRUD_malade, "Impossible de suprimer, aucune donnée n'est sélectionée.", "Supression", JOptionPane.OK_OPTION);
        }
        else if(ae.getSource().equals(fenRUD_malade.getBtnUpdate())){
            int i = fenRUD_malade.getTableDonnees().getSelectedRow();
            if(i>=0){
                //
            }else
                JOptionPane.showMessageDialog(fenRUD_malade, "Impossible de mettre à jour les données, aucune donnée n'est sélectionée.", "Mise A jour", JOptionPane.OK_OPTION);
        }
        
    }
    
    
}
