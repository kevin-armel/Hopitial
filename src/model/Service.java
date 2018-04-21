
package model;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import static model.Accueil.connex;


public class Service {

    public Service() {
    }
    
       public DefaultComboBoxModel getModelBatiment(){
        DefaultComboBoxModel modelData = new DefaultComboBoxModel();
        try {
            connex.setRset(connex.getStmt().executeQuery("SELECT DISTINCT batiment FROM service;"));
            connex.getRset().beforeFirst();
            while(connex.getRset().next()){
                modelData.addElement(connex.getRset().getString(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelData;
    }
    
    public DefaultTableModel getModelDataTable(){
        DefaultTableModel modelData = new DefaultTableModel();
        modelData.addColumn("Nom Service");
        modelData.addColumn("Code Service");
        modelData.addColumn("Batiment");
        modelData.addColumn("Nom Directeur");
        modelData.addColumn("Prenom Directeur");
        modelData.addColumn("Teléphone Directeur");
        try {
            ArrayList<String> liste = new ArrayList<String>();
            liste = connex.remplirChampsRequete("SELECT service.nom, service.code, service.batiment, employe.nom, employe.prenom, employe.tel FROM service,employe WHERE service.directeur = employe.numero;");
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
