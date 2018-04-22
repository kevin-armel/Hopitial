
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import static model.Accueil.connex;


public class Malade extends Abstract_Personne{
    
    private String nom_malade;
    private String prenom_malade;
    private String sexe_malade;
    private String Tel_malade;
    private String adress_malade;
    private String mut_malade;
    private double taille;
    private double poids;
    private Date age =new Date();
    
    public DefaultTableModel getModelDataTable(){
        DefaultTableModel modelData = new DefaultTableModel();
        modelData.addColumn("numero");
        modelData.addColumn("Nom");
        modelData.addColumn("Prenom");
        modelData.addColumn("Age");
        modelData.addColumn("Sexe");
        modelData.addColumn("Poids");
        modelData.addColumn("Taille");
        modelData.addColumn("Teléphone");
        modelData.addColumn("Adresse");
        modelData.addColumn("Mutulle");
        try {
            ArrayList<String> liste = new ArrayList<String>();
            liste = connex.remplirChampsRequete("SELECT malade.numero, malade.nom, malade.prenom, malade.age, malade.sexe, malade.poids, malade.taille, malade.tel, malade.adresse, mutuelle FROM malade;");
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
    
    public DefaultComboBoxModel getModelSexe(){
        DefaultComboBoxModel modelData = new DefaultComboBoxModel();
        try {
            connex.setRset(connex.getStmt().executeQuery("SELECT DISTINCT sexe FROM malade;"));
            connex.getRset().beforeFirst();
            while(connex.getRset().next()){
                modelData.addElement(connex.getRset().getString(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelData;
    }
    
    public DefaultComboBoxModel getModelMutuelle(){
        DefaultComboBoxModel modelData = new DefaultComboBoxModel();
        try {
            connex.setRset(connex.getStmt().executeQuery("SELECT DISTINCT mutuelle FROM malade;"));
            connex.getRset().beforeFirst();
            while(connex.getRset().next()){
                modelData.addElement(connex.getRset().getString(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelData;
    }
    
    public boolean deletedData(int id){
        boolean b =false;
        try {
            connex.executeUpdate("DELETE FROM soigne WHERE no_malade = "+ id +";");
            connex.executeUpdate("DELETE FROM hospitalisation WHERE no_malade = "+ id +";");
            connex.executeUpdate("DELETE FROM malade WHERE numero = "+ id +";");
            b = true;
        } catch (Exception e) {
            b= false;
            System.out.println(e.getMessage());
        }
        return b;
    }
    
}
