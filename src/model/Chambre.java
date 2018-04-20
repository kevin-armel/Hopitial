
package model;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import static model.Accueil.connex;


public class Chambre {

    public Chambre() {
    }
    
    
    public DefaultTableModel getModelDataTable(){
        DefaultTableModel modelData = new DefaultTableModel();
        modelData.addColumn("Numéro de chambre");
        modelData.addColumn("Nombre de lit");
        
        modelData.addColumn("Code Service");
        
        modelData.addColumn("Nom Infirmier");
        modelData.addColumn("Prénom Infirmier");
        modelData.addColumn("Teléphone Infirmier");
        
        try {
            ArrayList<String> liste = new ArrayList<String>();
            liste = connex.remplirChampsRequete("SELECT DISTINCT chambre.no_chambre, chambre.nb_lits, chambre.code_service, employe.nom, employe.prenom, employe.tel FROM employe, service, chambre WHERE employe.numero =chambre.surveillant;");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelData.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return modelData;
    }
    
}
