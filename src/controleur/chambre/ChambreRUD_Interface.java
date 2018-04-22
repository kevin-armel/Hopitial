
package controleur.chambre;

import javax.swing.JTable;

public interface ChambreRUD_Interface {
    
    /**
     * Configuration des cellulkes du tableau en lecteur seulement, il s'agit de désactiver la modification au clavier
     * @param table 
     */
    public void setCellReadOnly(JTable table);
    
    public void videzChamp();
    
    /**
     * methode remplisant en fonction des données selectionnées (venant de la position de la séléction) les champs à coté du tableau
     * @param posi posi est la ligne séléctionné par l'utilisateur
     */
    public void remplirFormModif(int posi);
    
    /**
     * methode de blindage, lorsque les modifications sont activées, l'utilisateur peux apporter des modifications sur la bdd
     */
    public void activeModif();
    
    public void desactiveModif();
}
