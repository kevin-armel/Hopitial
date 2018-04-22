
package model;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import static model.Accueil.connex;


public class Chambre {

    public Chambre() {
    }
    
    public boolean updateDataRoom(int numeroChambre, String code_service, int numSurviellant, int nombreLits){
        boolean b = false;
        try {
            connex.executeUpdate("UPDATE chambre SET  surveillant="+ numSurviellant +", nb_lits="+ nombreLits +"WHERE code_service='"+ code_service +"' AND no_chambre="+ numeroChambre +";");
            b = true;
        } catch (Exception e) {
            b = false;
        }
        return b;
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
    
    public boolean deletedData(int numChambre, String codeServ){
        boolean b =false;
        try {
            connex.executeUpdate("DELETE FROM chambre WHERE code_service = '"+ codeServ +"' AND no_chambre = "+ numChambre +";");
            connex.executeUpdate("DELETE FROM hospitalisation WHERE code_service = '"+ codeServ +"' AND no_chambre = "+ numChambre +";");
            b = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            b =false;
        }
        
        return b;
    }
    
    public boolean insertData(int numChambre, String codeServ, int numSurv, int nbrLits){
        boolean b =false;
        System.out.println(numChambre);System.out.println(codeServ);System.out.println(nbrLits);
        try {
            connex.executeUpdate("INSERT INTO chambre (code_service, no_chambre, surveillant, nb_lits) VALUES ( '"+codeServ+"',"+numChambre+", "+numSurv+", "+nbrLits+");");
            b = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            b =false;
        }
        
        return b;
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
}
