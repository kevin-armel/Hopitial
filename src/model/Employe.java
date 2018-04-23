
package model;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
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
    
    public boolean deletedData(int id, boolean isDoc){
        boolean b = false;
        try {
            connex.executeUpdate("DELETE FROM employe WHERE numero = "+ id +";");
            if(isDoc){
                connex.executeUpdate("DELETE FROM docteur WHERE numero = "+ id +";");
                connex.executeUpdate("DELETE FROM soigne WHERE no_docteur = "+ id +";");
                b = true;
            }else{
                connex.executeUpdate("DELETE FROM infirmier WHERE numero = "+ id +";");
                b = true;
            }
        } catch (Exception e) {
            b =false;
            System.out.println(e.getMessage());
        }
        return b;
    }
    
    public boolean insertData(int numero, String nom, String prenom, String adresse, String tel, String sexe, String email, String type){
        boolean b =false;
        try {
            connex.executeUpdate("INSERT INTO employe (numero, nom, prenom, adresse, tel, sexe, email) VALUES ( "+numero+", '"+nom+"', '"+prenom+"', '"+adresse+"', '"+tel+"', '"+sexe+"', '"+email+"');");
            if(type == "Docteur"){
                //connex.executeUpdate("INSERT INTO docteur (numero, nom, prenom, adresse, tel, sexe, email) VALUES ( "+numero+", '"+nom+"', '"+prenom+"', '"+adresse+"', '"+tel+"', '"+sexe+"', '"+email+"');");
            }else if(type == "Infirmier"){
                //connex.executeUpdate("INSERT INTO docteur (numero, nom, prenom, adresse, tel, sexe, email) VALUES ( "+numero+", '"+nom+"', '"+prenom+"', '"+adresse+"', '"+tel+"', '"+sexe+"', '"+email+"');");
            }b = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            b =false;
        }
        
        return b;
    }
    
    public int lastNumPerson() {
        //Test de connexion a la base de donnees
        try {
            ArrayList<String> liste = new ArrayList<String>();
            liste = connex.remplirChampsRequete("SELECT numero FROM employe ORDER BY numero DESC;");
            String res = new String();
            res = liste.get(0).replace("\n", "");
            connex.deconectBDD();
            return Integer.parseInt(res);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossible d'ajouter d'obtenir la liste \n\n"+ e.getMessage(), "Erreur de lecture", JOptionPane.ERROR);
            return 0;
        }
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
        modelData.addColumn("Sexe");
        modelData.addColumn("Email");
        modelData.addColumn("Spécialité Docteur");
        modelData.addColumn("Code service Infirmier");
        modelData.addColumn("Rotation Infirmier");
        modelData.addColumn("Salaire Infirmier");
        
        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT employe.numero, employe.nom, employe.prenom, employe.adresse, employe.tel, employe.sexe, employe.email, docteur.specialite, infirmier.code_service, infirmier.rotation, infirmier.salaire FROM employe LEFT JOIN infirmier ON employe.numero = infirmier.numero LEFT JOIN docteur ON employe.numero = docteur.numero;");
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
            connex.setRset(connex.getStmt().executeQuery("SELECT DISTINCT employe.sexe FROM employe WHERE sexe = sexe;"));
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
    
       public DefaultComboBoxModel getModelCodeServ(){
        DefaultComboBoxModel modelData = new DefaultComboBoxModel();
        try {
            connex.setRset(connex.getStmt().executeQuery("SELECT DISTINCT code FROM service;"));
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
