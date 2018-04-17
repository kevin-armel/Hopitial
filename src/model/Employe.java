
package model;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static model.Accueil.connex;


public class Employe extends Abstract_Personne implements InterfaceEmploye{

    
    
    public Employe(){
        
    }
    
    public DefaultTableModel getModelDataTable(){
        DefaultTableModel modelData = new DefaultTableModel();
        modelData.addColumn("Nom");
        modelData.addColumn("Prenom");
        modelData.addColumn("Adresse");
        modelData.addColumn("Teléphone");
        try {
            ArrayList<String> liste = new ArrayList<String>();
            liste = connex.remplirChampsRequete("SELECT nom,prenom,adresse,tel FROM employe;");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                int i=0;
                for(String str:string.split(",")){
                    data.add(str);
                }
                System.out.println(string);
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
