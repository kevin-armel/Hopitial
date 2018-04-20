
package controleur.chambre;

import javax.swing.JTable;

public interface ChambreRUD_Interface {
    
    
    

    public void setCellReadOnly(JTable table);
    
    public void videzChamp();
    
    public void remplirFormModif(int posi);
    
    public void activeModif();
    
    public void desactiveModif();
}
