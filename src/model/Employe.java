
package model;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import static model.Accueil.connex;


public class Employe extends Abstract_Personne implements InterfaceEmploye{

    
    
    public Employe(){
        
    }
    
    public boolean updateDataEmploye(int numero, String nom, String prenom, String adresse, String tel){
        boolean b = false;
        try {
            connex.executeUpdate("UPDATE employe SET nom='"+ nom +"', prenom='"+ prenom +"', adresse='"+ adresse +"', tel='"+ tel +"' WHERE numero="+numero+";");
            b = true;
        } catch (Exception e) {
            b = false;
        }
        return b;
    }
    
    public boolean updateDataDoc(int numero, String specialite){
        boolean b = false;
        try {
            connex.executeUpdate("UPDATE docteur SET specialite='"+ specialite +"' WHERE numero="+numero+";");
            b = true;
        } catch (Exception e) {
            b = false;
        }
        return b;
    }
    
    public boolean updateDataInf(int numero, String code_service, String rotation, Double salaire){
        boolean b = false;
        try {
            connex.executeUpdate("UPDATE infirmier SET code_service='"+ code_service +"' rotation='"+ rotation +"' salaire="+ salaire +" WHERE numero="+numero+";");
            b = true;
        } catch (Exception e) {
            b = false;
        }
        return b;
    }
    
    public boolean isDocteur(int numEmploye){
        boolean b = false;
        try {
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            connex.setRset(connex.getStmt().executeQuery("SELECT employe.numero FROM employe, docteur WHERE employe.numero = docteur.numero;"));
            connex.getRset().beforeFirst();
            while(connex.getRset().next()){
                //System.out.println());
                if(numEmploye == Integer.parseInt(connex.getRset().getString(1)))
                    b = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return b;
    }
    
    public DefaultTableModel getModelDataTable(){
        DefaultTableModel modelData = new DefaultTableModel();
        modelData.addColumn("numero employe");
        modelData.addColumn("Nom");
        modelData.addColumn("Prenom");
        modelData.addColumn("Adresse");
        modelData.addColumn("Teléphone");
        modelData.addColumn("Spécialité Docteur");
        modelData.addColumn("Code service Infirmier");
        modelData.addColumn("Rotation Infirmier");
        modelData.addColumn("Salaire Infirmier");
        
        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT employe.numero, employe.nom, employe.prenom, employe.adresse, employe.tel, docteur.specialite, infirmier.code_service, infirmier.rotation, infirmier.salaire FROM employe LEFT JOIN infirmier ON employe.numero = infirmier.numero LEFT JOIN docteur ON employe.numero = docteur.numero;");
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
            connex.setRset(connex.getStmt().executeQuery("SELECT DISTINCT infirmier.rotation FROM infirmier WHERE rotation = rotation;"));
            connex.getRset().beforeFirst();
            while(connex.getRset().next()){
                modelData.addElement(connex.getRset().getString(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return modelData;
    }
    
    public DefaultComboBoxModel getModelSpecialite(){
        DefaultComboBoxModel modelData = new DefaultComboBoxModel();
        try {
            connex.setRset(connex.getStmt().executeQuery("SELECT DISTINCT docteur.specialite FROM docteur WHERE specialite = specialite;"));
            connex.getRset().beforeFirst();
            while(connex.getRset().next()){
                modelData.addElement(connex.getRset().getString(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return modelData;
    }
    
    public DefaultComboBoxModel getModelRotationInf(){
        DefaultComboBoxModel modelData = new DefaultComboBoxModel();
        try {
            connex.setRset(connex.getStmt().executeQuery("SELECT DISTINCT infirmier.rotation FROM infirmier WHERE rotation = rotation;"));
            connex.getRset().beforeFirst();
            while(connex.getRset().next()){
                modelData.addElement(connex.getRset().getString(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return modelData;
    }

}
