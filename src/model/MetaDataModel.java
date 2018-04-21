
package model;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import static model.Accueil.connex;


public class MetaDataModel {

    public MetaDataModel() {
    
    }
    
    public int getCleDocteur(int position){
        
        return Integer.parseInt(getModelDataDoc().getValueAt(position, 0).toString());
    }
    
    public int getCleMalade(int position){
        return Integer.parseInt(getModelDataMal().getValueAt(position, 0).toString());
    }
    
    public int getCleInfirmier(int position){
    
        return Integer.parseInt(getModelDataInf().getValueAt(position, 0).toString());
    }
    
    public DefaultTableModel getModelDataDoc(){
        DefaultTableModel modelDataDoc = new DefaultTableModel();
        modelDataDoc.addColumn("numero");
        modelDataDoc.addColumn("Nom");
        modelDataDoc.addColumn("Prénom");
        modelDataDoc.addColumn("Téléphone");

        try {
            ArrayList<String> liste = new ArrayList<String>();
            liste = connex.remplirChampsRequete("SELECT employe.numero, employe.nom, employe.prenom, employe.tel FROM employe, docteur WHERE employe.numero = docteur.numero;");
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
                modelDataDoc.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataDoc;
    }
    
    public DefaultTableModel getModelDataInf(){
        DefaultTableModel modelDataInf = new DefaultTableModel();
        modelDataInf.addColumn("numero");
        modelDataInf.addColumn("Nom");
        modelDataInf.addColumn("Prénom");
        modelDataInf.addColumn("Téléphone");
        
        try {
            ArrayList<String> liste = new ArrayList<String>();
            liste = connex.remplirChampsRequete("SELECT employe.numero, employe.nom, employe.prenom, employe.tel FROM infirmier, employe WHERE employe.numero = infirmier.numero;");
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
                modelDataInf.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataInf;
    }
    
    public DefaultTableModel getModelDataMal(){
        DefaultTableModel modelDataMal = new DefaultTableModel();
        modelDataMal.addColumn("numero");
        modelDataMal.addColumn("Nom");
        modelDataMal.addColumn("Prénom");
        modelDataMal.addColumn("Téléphone");
        
        try {
            ArrayList<String> liste = new ArrayList<String>();
            liste = connex.remplirChampsRequete("SELECT malade.numero, malade.nom, malade.prenom, malade.tel FROM malade;");
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
                modelDataMal.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return modelDataMal;
    }
}
