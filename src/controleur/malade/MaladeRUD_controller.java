
package controleur.malade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import model.Malade;
import vue.malade.FenRUD_malade;


public class MaladeRUD_controller implements ActionListener, MaladeRUD_Interface{
    
    private Malade modelMalade = new Malade();
    private final FenRUD_malade fenRUD_malade = new FenRUD_malade();

    public MaladeRUD_controller(Malade m) {
        this.modelMalade = m;
        fenRUD_malade.getTableDonnees().setModel(m.getModelDataTable());
        setCellReadOnly(fenRUD_malade.getTableDonnees());
        
        fenRUD_malade.getBtnBack().addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(fenRUD_malade.getBtnBack())){
            fenRUD_malade.dispose();
            MaladeController mc = new MaladeController(modelMalade);
        }
    }
    
    
}
