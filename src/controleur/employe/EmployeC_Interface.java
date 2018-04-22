
package controleur.employe;


public interface EmployeC_Interface {
    
    /**
     * Methode pour afficher les champs specifiques aux docteurs
     */
    public void afficheChampsDoc();
    
    /**
     * Methode pour afficher les champs specifique aux infermiers
     */
    public void afficheChampsInf();
    
    /**
     * Methode pour vides les champs
     */
    public void viderChamps();
    
    public void noAction(boolean disable);
}
 