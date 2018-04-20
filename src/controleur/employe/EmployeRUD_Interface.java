
package controleur.employe;

import javax.swing.JTable;

/**
 * 
 * Cette classe est une classe de prototypage
 */
public interface EmployeRUD_Interface {
    
    /**
     * 
     * @param table 
     */
    public void setCellReadOnly(JTable table);
    
    /**
     * Cette méthode permets de désactiver l'autorisation de modification des données dans la base de donnée
     */
    public void desactiveModif();
    
    /**
     * Cette méthode permets de d'activer l'autorisation de modification des données dans la base de donnée
     */
    public void activeModif();
    
    /**
     * Cette méthode permets en fonction du numéro de ligne passé en paramètre, charger toutes les informations dans les champs de saisie. Pour permettre une mise à jour
     * @param posi C'est la position de la ligne sélectionnée dans le tableau.
     */
    public void remplirFormModif(int posi, boolean isDoctor);
    
    /**
     * Cette méthode permets de vider les champs de saisie si besoin est.
     */
    public void videzChamp();
}
 